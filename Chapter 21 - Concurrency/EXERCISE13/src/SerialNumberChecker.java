import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{
        public void run(){
            while (true){
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(circularSet.contains(serial)){
                    System.out.println("Duplicate: "+ serial);
                    System.exit(0);
                }
                circularSet.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        // Stop after n seconds if there's an argument:
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}