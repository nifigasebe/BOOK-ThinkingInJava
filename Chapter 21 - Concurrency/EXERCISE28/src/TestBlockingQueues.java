import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

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
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i=0; i<5;i++){
            runner.add(new LiftOff());
        }
        getkey("Press 'Enter' (" + msg +")");
        t.interrupt();
        System.out.println("Finished "+ msg + "test");
    }

    public static void main(String[] args) {

        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());

        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));

        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }



}