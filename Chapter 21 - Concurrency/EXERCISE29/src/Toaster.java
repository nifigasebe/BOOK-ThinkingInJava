import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class Toaster implements Runnable{

    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue tq){
        this.toastQueue = tq;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }

        }catch (InterruptedException e){
            System.out.println("Toaster Interrupted");
        }

        System.out.println("Toaster off");
    }
}
