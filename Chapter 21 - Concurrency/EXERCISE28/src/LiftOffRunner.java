import java.util.concurrent.BlockingQueue;

/**
 * Created by Chizhov-AS on 23.09.2015.
 */
public class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> blockingQueue;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        blockingQueue = queue;
    }

    public void add(LiftOff liftOff){
        try {
            blockingQueue.put(liftOff);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                LiftOff liftOff = blockingQueue.take();
                liftOff.run();
            }
        } catch (InterruptedException e){
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting ListOfRunner");
    }
}
