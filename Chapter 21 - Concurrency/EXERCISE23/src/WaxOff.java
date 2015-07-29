import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 01.07.2015.
 */
public class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c){
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitForWaxing();
                System.out.print(" Wax OFF! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax off task");
    }
}
