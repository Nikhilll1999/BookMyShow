package MapTesting;

import java.lang.ref.WeakReference;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class IdentityHashMapTest {
    static WeakHashMap<Integer, String> identityHashMap = new WeakHashMap<>();
    SortedMap sortedMap = new TreeMap();

    public static void main(String[] args) throws InterruptedException {
        Integer i2 = new Integer(101);
        Integer i1 = new Integer(101);
        identityHashMap.put(i1, "NIkhil");
        identityHashMap.put(i2, "Jagdish");
        System.out.println(identityHashMap);
        i1 = null;
        System.gc();

        Thread.sleep(1000L);

        System.out.println(identityHashMap);
    }

}
