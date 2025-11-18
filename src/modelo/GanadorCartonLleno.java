package modelo;

import java.util.ArrayList;
import java.util.List;

public class GanadorCartonLleno implements Condicion{

    @Override
    public boolean ganador(Carton carton) {
        boolean[][] m = carton.getMarcados();
        int cont = 0;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (r == 2 && c == 2) continue;
                if (m[r][c]) cont++;
            }
        }
        return cont == 24;
    }

    @Override
    public List<int[]> cartonGanador(Carton carton) {
        List<int[]> gan = new ArrayList<>();
        boolean[][] m = carton.getMarcados();
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (r == 2 && c == 2) continue;
                gan.add(new int[]{r, c});
            }
        }
        return gan;
    }
    
}
