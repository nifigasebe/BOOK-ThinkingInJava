import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-AS on 27.05.2015.
 */
public class Checker implements Runnable {

    public Checker(IntGenerator intGenerator, int id){
        this.intGenerator = intGenerator;
        this.id = id;
    }

    private IntGenerator intGenerator;
    private final int id;

    public static void test(IntGenerator intGenerator){
        test(intGenerator,4);
    }

    public static void test(IntGenerator intGenerator,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            executorService.execute(new Checker(intGenerator,i));
        }
        executorService.shutdown();
    }

    public void run(){
        while (!intGenerator.isCanceled()){
            int value = intGenerator.next();
            if(value % 2 != 0){
                System.out.println(">>" + value + " not even!");
                intGenerator.cancel();
            }
        }
    }
}
