/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber(){
        return serialNumber++;
    }
}
