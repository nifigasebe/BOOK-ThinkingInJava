/**
 * Created by Chizhov-as on 26.06.2015.
 */
public class ClassA implements Runnable {

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("Start waiting");
                wait();
            }catch (InterruptedException iEX){
                System.out.println("iEX" + Thread.currentThread().getName());
            }
            System.out.println("End waiting!");
        }
    }
}
