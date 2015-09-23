/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

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
                System.out.print("WaitPerson got " + restaurant.meal + " ");
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException iEX){
            System.out.println("WaitPerson interrupted");
        }
    }

}
