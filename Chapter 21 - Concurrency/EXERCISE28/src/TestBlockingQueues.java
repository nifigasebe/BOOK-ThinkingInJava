import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by Chizhov-AS on 23.09.2015.
 */
public class TestBlockingQueues {

    static void getkey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (java.io.IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message){
        System.out.println(message);
        getkey();
    }

    static void test (String msg, BlockingQueue<LiftOff> queue){

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(msg.toUpperCase());
        System.out.println();
        LiftOffRunner liftOffRunner = new LiftOffRunner(queue);
        LiftOffManager liftOffManager = new LiftOffManager(liftOffRunner);
        executorService.execute(liftOffRunner);
        executorService.execute(liftOffManager);
        getkey("Press 'ENTER' (" + msg + ")");
        executorService.shutdown();
        System.out.println("Finished "+ msg + "test");
    }

    public static void main(String[] args) {

        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());

        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));

        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }
}