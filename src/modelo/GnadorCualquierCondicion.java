package modelo;

import java.util.ArrayList;
import java.util.List;

public class GnadorCualquierCondicion implements Condicion{

    private List<Condicion> condiciones;
    
    @Override
    public boolean ganador(Carton carton) {
        for (Condicion c : condiciones) if (c.ganador(carton)) return true;
        return false;
    }

    @Override
    public List<int[]> cartonGanador(Carton carton) {
        for (Condicion c : condiciones) {
            if (c.ganador(carton)) return c.cartonGanador(carton);
        }
        return new ArrayList<>();
    }
    
    public GnadorCualquierCondicion(List<Condicion> condiciones) {
        this.condiciones = condiciones;
    }
}
