import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class AtomycityTest implements Runnable {
    private int i = 0;

    public synchronized int getValue() {
        return i;
    }
     private synchronized void evenIncrement(){
         i++;
         i++;
     }
    public void run(){
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomycityTest atomycityTest = new AtomycityTest();
        executorService.execute(atomycityTest);
        while (true){
            int value = atomycityTest.getValue();
            if(value % 2 !=0){
                System.out.print(value);
                System.exit(0);
            }
        }
    }
}
