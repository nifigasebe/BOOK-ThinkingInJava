import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 01.07.2015.
 */
public class WaxOMatic {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOff(car));
        executorService.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(3);
        executorService.shutdownNow();
    }
}
