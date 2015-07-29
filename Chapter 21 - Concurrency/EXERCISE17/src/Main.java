import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chizhov-as on 11.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int numberOfSensors = random.nextInt(9) + 3; //random int [3-12]
        RadiationCounter radiationCounter = new RadiationCounter(numberOfSensors);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<numberOfSensors; i++){
            executorService.execute(new Sensor(radiationCounter,i));
        }

        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException iEX){
                iEX.printStackTrace();
            }
            System.out.println(">>>>>>>>>>>>>>>>>" + radiationCounter.getAverageRadiationLevel());
        }
    }
}
