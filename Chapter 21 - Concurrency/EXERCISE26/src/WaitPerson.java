/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    boolean busBoyJobDone;

    public WaitPerson(Restaurant r){
        restaurant = r;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal == null){
                        wait();
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal + " ");

                synchronized (restaurant.busBoy){
                    restaurant.busBoy.waitPersonIsCalling = true;
                    restaurant.busBoy.meal = restaurant.meal;
                    System.out.println("Calling BusBoy");
                    restaurant.busBoy.notifyAll();
                }
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }

                synchronized (this){
                    if(!busBoyJobDone){
                        wait();
                    }
                    busBoyJobDone = false;
                }
            }
        } catch (InterruptedException iEX){
            System.out.println("WaitPerson interrupted");
        }
    }

}
