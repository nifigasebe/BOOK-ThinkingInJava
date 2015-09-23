/**
 * Created by Chizhov-AS on 22.09.2015.
 */
public class BusBoy implements Runnable {

    private Restaurant restaurant;
    boolean waitPersonIsCalling = false;
    volatile Meal meal;

    public BusBoy(Restaurant r){
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    if(!waitPersonIsCalling){
                        wait();
                    }
                    System.out.println("BusBoy clear " + meal);
                    waitPersonIsCalling = false;
                }

                synchronized (restaurant.waitPerson){
                    restaurant.waitPerson.busBoyJobDone = true;
                    restaurant.waitPerson.notifyAll();
                }
            }

        }catch (InterruptedException iEX){
            System.out.println("BusBoy interrupted");
        }

    }
}
