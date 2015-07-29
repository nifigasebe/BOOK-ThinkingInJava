import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chizhov-as on 10.06.2015.
 */
public class Data {
    private int x = 1;
    private int y = 0;
    private int z=0;

    private SyncObject syncObject = new SyncObject();
    private Lock lock = new ReentrantLock();

    public void zPlus(){
        //synchronized (syncObject){
        lock.lock();
        for (int i=0;i<100;i++){
                x++;
                y++;
                z = x + y;
                System.out.println("zPlus:" + "(" + i + ")" + " x=" + x + " y=" + y + " z=" + z);
            }
        lock.unlock();
        //}
        System.out.println("zPlus" + " z=" + z);
    }

    public void zMinus(){
        //synchronized (syncObject){
        for (int i=0;i<100;i++){
            lock.lock();            // Лочим другую область
            x++;
            y++;
            z = x - y;
            System.out.println("zMinus:" + "(" + i +")" + " x="+ x + " y="+ y + " z=" + z);
            lock.unlock();
            Thread.yield();
        }
        //}
        System.out.println("zMinus" + " z=" + z);
    }

    public void zMultiply(){
        //synchronized (syncObject){ // !=syncObject
        lock.lock();
        for (int i=0;i<100;i++){
                x++;
                y++;
                z = x * y;
                System.out.println("zMultiply:" + "(" + i + ")" + " x=" + x + " y=" + y + " z=" + z);
            }
        lock.unlock();
        //}
        System.out.println("zMultiply" + " z=" + z);
    }
}