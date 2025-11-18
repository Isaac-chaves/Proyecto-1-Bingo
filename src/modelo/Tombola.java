package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tombola {
    private final List<Integer> res;
    private final List<Integer> tir;
    private final Random rnd = new Random();

    public Tombola() {
        res = new ArrayList<>();
        for (int i = 1; i <= 75; i++) res.add(i);
        tir = new ArrayList<>();
    }

    public int drawRandom() {
        if (res.isEmpty()) return -1;
        int idx = rnd.nextInt(res.size());
        int n = res.remove(idx);
        tir.add(n);
        return n;
    }

    public boolean addManual(int n) {
        if (n < 1 || n > 75) return false;
        if (!res.contains(n)) return false;
        res.remove(Integer.valueOf(n));
        tir.add(n);
        return true;
    }

    public boolean wasDrawn(int n) {
        return tir.contains(n);
    }

    public void reset() {
        res.clear();
        tir.clear();
        for (int i = 1; i <= 75; i++) res.add(i);
    }

    public List<Integer> getDrawn() { return Collections.unmodifiableList(tir); }
    public List<Integer> getRemaining() { return Collections.unmodifiableList(res); }
}
