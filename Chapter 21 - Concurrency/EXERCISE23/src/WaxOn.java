import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 01.07.2015.
 */
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c){
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.print(" Wax ON! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending WAX On task");
    }
}
