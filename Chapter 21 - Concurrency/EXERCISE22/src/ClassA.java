/**
 * Created by Chizhov-as on 30.06.2015.
 */
public class ClassA implements Runnable {
    private volatile boolean flag = false;

    public synchronized boolean getFlag() {
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            System.out.println("ClassA: start sleep");
            Thread.sleep(5000);
            System.out.println("ClassA: stop  sleep");
        }catch (InterruptedException iEX){
            System.out.println("iEX" + Thread.currentThread().getName());
        }
        System.out.println("ClassA: flag=true");
        flag = true;
    }
}