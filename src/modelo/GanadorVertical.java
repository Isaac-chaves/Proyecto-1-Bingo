package modelo;

import java.util.ArrayList;
import java.util.List;

public class GanadorVertical implements Condicion{

    @Override
    public boolean ganador(Carton carton) {
        boolean[][] m = carton.getMarcados();
        for (int col = 0; col < 5; col++) {
            boolean casillas = true;
            for (int f = 0; f < 5; f++) {
                if (f == 2 && col == 2) continue;
                if (!m[f][col]) { casillas = false; break; }
            }
            if (casillas) return true;
        }
        return false;
    }

    @Override
    public List<int[]> cartonGanador(Carton carton) {
        List<int[]> gan = new ArrayList<>();
        boolean[][] m = carton.getMarcados();
        for (int col = 0; col < 5; col++) {
            boolean casillas = true;
            for (int f = 0; f < 5; f++) {
                if (f == 2 && col == 2) continue;
                if (!m[f][col]) { casillas = false; break; }
            }
            if (casillas) {
                for (int row = 0; row < 5; row++) gan.add(new int[]{row, col});
                break;
            }
        }
        return gan;
    }
    
}
