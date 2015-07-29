import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by alexeychizhov on 23.05.2015.
 */
public class TestDriveLiftOff {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);

        for (int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();

        System.out.println("AfterStart");

    }
}
