import java.util.concurrent.BlockingQueue;

/**
 * Created by Chizhov-AS on 23.09.2015.
 */
public class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }

    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e){
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting ListOfRunner");
    }
}
