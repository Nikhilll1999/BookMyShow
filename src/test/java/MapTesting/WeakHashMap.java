package MapTesting;

import lombok.Data;

@Data
public class WeakHashMap {
    private Integer i1;
    private Integer i2;


    /**
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
