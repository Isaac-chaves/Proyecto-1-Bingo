package modelo;

import java.util.List;

public interface Condicion {
    boolean ganador(Carton carton);
    List<int[]> cartonGanador(Carton carton);
}
