/**
 * Created by Chizhov-AS on 30.09.2015.
 */
public class PeanutButterer implements Runnable {

    private  ToastQueue dryQueue, finishedQueue;

    public PeanutButterer(ToastQueue dry, ToastQueue finished){
        dryQueue = dry;
        finishedQueue = finished;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                Toast t = dryQueue.take();
                t.penautButter();
                System.out.println(t);
                finishedQueue.put(t);
            }catch (InterruptedException e){
                System.out.println("PeanutButterer interrupted");
            }
        }
        System.out.println("PeanutButterer off");
    }
}
