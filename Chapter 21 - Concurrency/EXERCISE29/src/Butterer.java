/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class Butterer implements Runnable {

    private ToastQueue dryQueue, butterQueue;

    public Butterer(ToastQueue dry,ToastQueue buttered){
        dryQueue = dry;
        butterQueue = buttered;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}
