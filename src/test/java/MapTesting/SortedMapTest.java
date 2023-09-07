package MapTesting;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {
    public static void main(String[] args) {
        SortedMap<TemproryDTO, String> m = new TreeMap();

        m.put(new TemproryDTO("101"), "First Value");
        m.put(new TemproryDTO("wer"), "Second Value");
        m.put(new TemproryDTO("w32"), "Third Value");
        m.put(new TemproryDTO("9ubu"), "Fourth Value");

        System.out.println(m);
    }
}
