/**
 * Created by Chizhov-as on 30.06.2015.
 */
public class ClassD implements Runnable {

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("ClassD start wait");
                wait();
                System.out.println("ClassD stop wait");
            }catch (InterruptedException iEX){
                System.out.println("iEX " + Thread.currentThread().getName());
            }
        }
        ClassC.flag = false;
        System.out.println("ClassD: flag=false");
    }
}