package modelo;

import java.util.ArrayList;
import java.util.List;

public class JuegoPrincipal {
    private final List<Carton> cartones = new ArrayList<>();
    private final Tombola tombola = new Tombola();
    private final List<ListaDeJuego> listas = new ArrayList<>();

    private Condicion condicion;
    private EnumModoJuego modo = EnumModoJuego.AUTOMATICO;
    private EnumTipoDeVictoria ModoVictoria = EnumTipoDeVictoria.NORMAL;

    public void aggLista(ListaDeJuego l) { listas.add(l); }
    public void removerLista(ListaDeJuego l) { listas.remove(l); }

    public void addCarton(Carton c) { cartones.add(c); }
    public void removeCarton(Carton c) { cartones.remove(c); }

    public Tombola getTombola() { return tombola; }

    public void setMode(EnumModoJuego m) { this.modo = m; }

    public void setModoVictoria(EnumTipoDeVictoria vm) {
        this.ModoVictoria = vm;
        switch (vm) {
            case NORMAL -> {
                List<Condicion> list = new ArrayList<>();
                list.add(new GanadorHorizontal());
                list.add(new GanadorVertical());
                list.add(new GanadorDiagonal());
                list.add(new GanadorCuatroEsquinas());
                this.condicion = new GnadorCualquierCondicion(list);
            }
            case CUATROESQUINAS -> this.condicion = new GanadorCuatroEsquinas();
            case CARTONLLENO -> this.condicion = new GanadorCartonLleno();
            default -> this.condicion = new GnadorCualquierCondicion(new ArrayList<>());
        }
    }

    public void automatico() {
        int numero = tombola.tiradaAleat();
        if (numero == -1) {
            listas.forEach(ListaDeJuego::JuegoReiniciado);
            return;
        }
        marcarn(numero);
        listas.forEach(l -> l.numeroLlamado(numero));
    }

    public boolean manual(int numero) {
        boolean added = tombola.aggManuel(numero);
        if (!added) return false; {
            listas.forEach(l -> l.numeroLlamado(numero));
        return true;
        }
    }

    private void marcarn(int numero) {
        for (Carton c : cartones) {
            boolean marcado = c.marcarNumero(numero);
            if (!marcado) continue;
            if (condicion != null && condicion.ganador(c)) {
                List<int[]> gan = condicion.cartonGanador(c);
                listas.forEach(l -> l.Gnador(c, gan));
            }
        }
    }

    public void reiniciarJuego() {
        tombola.reinicio();
        cartones.forEach(c -> {
            boolean[][] marc = c.getMarcados();
            for (int r=0;r<5;r++) for (int s=0;s<5;s++) marc[r][s] = false;
            marc[2][2] = true;
        });
        listas.forEach(ListaDeJuego::JuegoReiniciado);
    }
    
    public JuegoPrincipal (){
        setModoVictoria(EnumTipoDeVictoria.NORMAL);
    }

    public List<Carton> getCartones() { return new ArrayList<>(cartones); }
}
