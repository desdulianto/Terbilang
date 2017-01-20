/**
 * Created by david on 1/4/17.
 */

import java.util.Collections;
import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Terbilang {
    private static Map<Long, String> satuan;
    private static Map<Long, String> ket;

    static {
        satuan = new HashMap<>();

        satuan.put(0L, "nol");
        satuan.put(1L, "satu");
        satuan.put(2L, "dua");
        satuan.put(3L, "tiga");
        satuan.put(4L, "empat");
        satuan.put(5L, "lima");
        satuan.put(6L, "enam");
        satuan.put(7L, "tujuh");
        satuan.put(8L, "delapan");
        satuan.put(9L, "sembilan");
    }

    static {
        ket = new HashMap<>();

        ket.put(10L, "puluh");
        ket.put(100L, "ratus");
        ket.put(1000L, "ribu");
        ket.put(1000000L, "juta");
        ket.put(1000000000L, "milyar");
        ket.put(1000000000000L, "triliun");
    }

    public static String terbilang(Double angka) {
        String awalan;
        String tengah;
        String akhiran;
        if (angka < 10.0)
            return satuan.get(angka.longValue());
        else if (angka >= 11 && angka <= 19) {
            awalan = satuan.get(angka.longValue() % 10);
            if (awalan.equals("satu"))
                awalan = "se";
            return awalan + (awalan.equals("se") ? "" : " ") + "belas";
        } else {
            List<Long> sorted = asSortedList(ket.keySet());
            Collections.reverse(sorted);
            for (Long i : sorted) {
                if (angka < i)
                    continue;
                if (angka.longValue() / i < 10L)
                    awalan = satuan.get(angka.longValue() / i);
                else
                    awalan = terbilang(new Long(angka.longValue() / i).doubleValue());

                if (awalan.equals("satu") && angka.longValue() < 2000L)
                    awalan = "se";

                tengah = ket.get(i);

                akhiran = "";

                if (angka.longValue() % i > 0L)
                    akhiran = terbilang(new Long(angka.longValue() % i).doubleValue());

                return awalan + (awalan.equals("se") ? "" : " ") + tengah + (akhiran.equals("") ? "" : " ") + akhiran;
            }
        }
        return "";
    }

    public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
        List<T> list = new ArrayList<>(c);
        java.util.Collections.sort(list);
        return list;
    }
}
