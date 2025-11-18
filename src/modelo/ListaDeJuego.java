package modelo;

import java.util.List;


public interface ListaDeJuego {
    void numeroLlamado(int numero);
    void Gnador(Carton carton, List<int[]> ganador);
    void JuegoReiniciado();
}
