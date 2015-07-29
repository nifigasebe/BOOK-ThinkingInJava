import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 19.06.2015.
 */
public class OrnamentGarden {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            executorService.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        //Entrance.cancel();
        executorService.shutdownNow(); // Sent interrupts (without canceling):

        if(!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println("Some tasks were not terminated");
        }

        System.out.println("---------------------");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}

/* Dafault version
public class OrnamentGarden {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            executorService.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        executorService.shutdown();

        if(!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println("Some tasks were not terminated");
        }

        System.out.println("---------------------");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
*/