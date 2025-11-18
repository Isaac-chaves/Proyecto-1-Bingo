package modelo;

import java.util.ArrayList;
import java.util.List;

public class GanadorCuatroEsquinas implements Condicion{

    @Override
    public boolean ganador(Carton carton) {
        boolean[][] m = carton.getMarcados();
        return m[0][0] && m[0][4] && m[4][0] && m[4][4];
    }

    @Override
    public List<int[]> cartonGanador(Carton carton) {
        List<int[]> gan = new ArrayList<>();
        gan.add(new int[]{0,0});
        gan.add(new int[]{0,4});
        gan.add(new int[]{4,0});
        gan.add(new int[]{4,4});
        return gan;
    }
    
}
