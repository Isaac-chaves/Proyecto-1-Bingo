package modelo;

import java.util.ArrayList;
import java.util.List;

public class GanadorDiagonal implements Condicion{

    @Override
    public boolean ganador(Carton carton) {
        boolean[][] m = carton.getMarcados();
        boolean all = true;
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (!m[i][i]) { all = false; break; }
        }
        if (all) return true;

        all = true;
        for (int i = 0; i < 5; i++) {
            int r = i, c = 4 - i;
            if (r == 2 && c == 2) continue;
            if (!m[r][c]) { all = false; break; }
        }
        return all;
    }

    @Override
    public List<int[]> cartonGanador(Carton carton) {
        List<int[]> gan = new ArrayList<>();
        boolean[][] m = carton.getMarcados();

        boolean todasc = true;
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (!m[i][i]) { todasc = false; break; }
        }
        if (todasc) {
            for (int i = 0; i < 5; i++) gan.add(new int[]{i, i});
            return gan;
        }

        boolean todas = true;
        for (int i = 0; i < 5; i++) {
            int r = i, c = 4 - i;
            if (r == 2 && c == 2) continue;
            if (!m[r][c]) { todas = false; break; }
        }
        if (todas) {
            for (int i = 0; i < 5; i++) gan.add(new int[]{i, 4 - i});
        }
        return gan;
    }
    
}
