import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-as on 30.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB(classA);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(classA);
        executorService.execute(classB);

        try {
            Thread.sleep(6000);
            System.out.println("--------------------");
        }catch (InterruptedException iEX){
            System.out.println("iEX " + Thread.currentThread().getName());
        }

        ClassD classD = new ClassD();
        ClassC classC = new ClassC(classD);

        executorService.execute(classC);
        executorService.execute(classD);
        executorService.shutdown();
    }
}