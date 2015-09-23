import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class Main {

    public static void main(String[] args) {

        JobStack jobStack = new JobStack();
        Boss boss = new Boss(jobStack);
        Worker worker = new Worker(jobStack);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(boss);
        executorService.execute(worker);
        executorService.shutdown();
    }
}
