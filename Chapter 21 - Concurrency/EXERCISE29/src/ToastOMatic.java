import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class ToastOMatic {

    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),butteredQueue = new ToastQueue(), finishedQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue,butteredQueue));
        executorService.execute(new PeanutButterer(dryQueue,finishedQueue));
        executorService.execute(new Jammer(butteredQueue,finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
