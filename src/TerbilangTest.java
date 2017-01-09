import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 1/4/17.
 */

public class TerbilangTest {
    @Test
    public void testSatuan() {
        assertEquals(Terbilang.terbilang(1.0), "satu");
        assertEquals(Terbilang.terbilang(2.0), "dua");
        assertEquals(Terbilang.terbilang(3.0), "tiga");
        assertEquals(Terbilang.terbilang(4.0), "empat");
        assertEquals(Terbilang.terbilang(5.0), "lima");
        assertEquals(Terbilang.terbilang(6.0), "enam");
        assertEquals(Terbilang.terbilang(7.0), "tujuh");
        assertEquals(Terbilang.terbilang(8.0), "delapan");
        assertEquals(Terbilang.terbilang(9.0), "sembilan");
    }

    @Test
    public void testBelasan() {
        assertEquals(Terbilang.terbilang(11.0), "sebelas");
        assertEquals(Terbilang.terbilang(12.0), "dua belas");
        assertEquals(Terbilang.terbilang(13.0), "tiga belas");
        assertEquals(Terbilang.terbilang(14.0), "empat belas");
        assertEquals(Terbilang.terbilang(15.0), "lima belas");
        assertEquals(Terbilang.terbilang(16.0), "enam belas");
        assertEquals(Terbilang.terbilang(17.0), "tujuh belas");
        assertEquals(Terbilang.terbilang(18.0), "delapan belas");
        assertEquals(Terbilang.terbilang(19.0), "sembilan belas");
    }

    @Test
    public void test() {
        Map<Long, String> kunci = new HashMap<Long, String>();

        kunci.put(0L, "nol");
        kunci.put(1L, "satu");
        kunci.put(3L, "tiga");
        kunci.put(7L, "tujuh");
        kunci.put(10L, "sepuluh");
        kunci.put(11L, "sebelas");
        kunci.put(13L, "tiga belas");
        kunci.put(27L, "dua puluh tujuh");
        kunci.put(30L, "tiga puluh");
        kunci.put(39L, "tiga puluh sembilan");
        kunci.put(50L, "lima puluh");
        kunci.put(70L, "tujuh puluh");
        kunci.put(75L, "tujuh puluh lima");
        kunci.put(99L, "sembilan puluh sembilan");
        kunci.put(109L, "seratus sembilan");
        kunci.put(213L, "dua ratus tiga belas");
        kunci.put(353L, "tiga ratus lima puluh tiga");
        kunci.put(1735L, "seribu tujuh ratus tiga puluh lima");
        kunci.put(1100122L, "satu juta seratus ribu seratus dua puluh dua");
        kunci.put(13423532L, "tiga belas juta empat ratus dua puluh tiga ribu lima ratus tiga puluh dua");
        kunci.put(175028000L, "seratus tujuh puluh lima juta dua puluh delapan ribu");
        kunci.put(127983125L, "seratus dua puluh tujuh juta sembilan ratus delapan puluh tiga ribu seratus dua puluh lima");
        kunci.put(1934569023L, "satu milyar sembilan ratus tiga puluh empat juta lima ratus enam puluh sembilan ribu dua puluh tiga");
        kunci.put(110389000000L, "seratus sepuluh milyar tiga ratus delapan puluh sembilan juta");
        kunci.put(110389000000L, "seratus sepuluh milyar tiga ratus delapan puluh sembilan juta");
        kunci.put(1893756233123L, "satu triliun delapan ratus sembilan puluh tiga milyar tujuh ratus lima puluh enam juta dua ratus tiga puluh tiga ribu seratus dua puluh tiga");
        kunci.put(1123578320126389L, "seribu seratus dua puluh tiga triliun lima ratus tujuh puluh delapan milyar tiga ratus dua puluh juta seratus dua puluh enam ribu tiga ratus delapan puluh sembilan");

        for (Long i : Terbilang.asSortedList(kunci.keySet())) {
            System.out.println(i + " expected " + kunci.get(i));
            assertEquals(Terbilang.terbilang(i.doubleValue()), kunci.get(i));
        }
    }
}