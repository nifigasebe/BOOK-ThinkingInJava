import java.util.Random;

/**
 * Created by Chizhov-as on 11.06.2015.
 */
public class Sensor implements Runnable {

    int numberOfSensor;
    private float radiationLevel;
    RadiationCounter radiationCounter;
    Random random = new Random();

    public Sensor(RadiationCounter radiationCounter,int numberOfSensor){
        this.radiationCounter = radiationCounter;
        this.numberOfSensor = numberOfSensor;
    }

    @Override
    public void run() {
        while (true){
            radiationLevel = random.nextFloat() * (1000.00f - 0.03f)+ 0.03f;
            radiationCounter.setRadiationLevel(radiationLevel,numberOfSensor);
            System.out.println("Sensor " + numberOfSensor + " : " + radiationLevel );
            try {
                Thread.sleep(1000);
            }catch (InterruptedException iEX){
                iEX.printStackTrace();
            }
        }
    }
}



/*

*/
