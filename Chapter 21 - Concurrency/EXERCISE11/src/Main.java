import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-AS on 26.05.2015.
 */
public class Main {

    public static void main(String[] args) {

        Data data = new Data();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<8;i++){
            executorService.execute(new ProcessData(data));
        }
        executorService.shutdown();
    }
}
