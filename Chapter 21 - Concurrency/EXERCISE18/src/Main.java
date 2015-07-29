import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 19.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new RunnableClass());
        try {
            Thread.sleep(7000);
        }catch (InterruptedException iEX){
            //ignore
        }
        future.cancel(true);
        executorService.shutdown();

        //-----------------------------------------------------------------

        Thread t = new Thread(new RunnableClass());
        t.start();
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException iEX){
            //ignore
        }
        t.interrupt();
    }
}
