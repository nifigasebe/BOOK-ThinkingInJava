import java.util.concurrent.TimeUnit;

/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r){
        restaurant = r;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null){
                        wait();
                    }
                }
                if(++count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.executorService.shutdownNow();
                    return;
                }
                System.out.println("Orer Up!");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException iEX){
            System.out.println("Chef interrupted");
        }
    }
}
