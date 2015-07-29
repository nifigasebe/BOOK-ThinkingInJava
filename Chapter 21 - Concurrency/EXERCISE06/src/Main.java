
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by alexeychizhov on 24.05.2015.
 */
public class Main {

    static int numberOfThreads = 10;
    static ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
    static ArrayList<Future<String>> results = new ArrayList<Future<String>>();
    public static void main(String[] args) {
        for (int i=0;i<numberOfThreads;i++){
            results.add(executorService.submit(new SleepingTask(i+1)));
        }
        executorService.shutdown();
        try {
            for (Future<String> s : results){
                System.out.println(s.get());
            }
        }catch (InterruptedException iEX){
            iEX.printStackTrace();
        }catch (ExecutionException eEX){
            eEX.printStackTrace();
        }

    }
}
