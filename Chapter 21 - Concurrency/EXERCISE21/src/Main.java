import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-as on 26.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB(classA);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(classA);
        executorService.execute(classB);
        Thread.yield();
        executorService.shutdown();
    }
}
