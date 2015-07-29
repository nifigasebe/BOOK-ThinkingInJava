import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-as on 22.06.2015.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<5;i++ ){
            executorService.execute(new LiftOff());
        }
        executorService.shutdownNow();
    }
}
