package modelo;

import java.util.ArrayList;
import java.util.List;

public class GanadorHorizontal implements Condicion{

    @Override
    public boolean ganador(Carton carton) {
        boolean[][] m = carton.getMarcados();
        for (int f = 0; f < 5; f++) {
            boolean casillas = true;
            for (int col = 0; col < 5; col++) {
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
        for (int f = 0; f < 5; f++) {
            boolean casillas = true;
            for (int col = 0; col < 5; col++) {
                if (f == 2 && col == 2) continue;
                if (!m[f][col]) { casillas = false; break; }
            }
            if (casillas) {
                for (int col = 0; col < 5; col++) gan.add(new int[]{f, col});
                break;
            }
        }
        return gan;
    }
    
}
