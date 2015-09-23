import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    Lock lock = new ReentrantLock(); //1
    Condition condition = lock.newCondition(); //1

    public WaitPerson(Restaurant r){
        restaurant = r;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                lock.lock();
                try {
                    while (restaurant.meal == null){
                        condition.await();
                    }
                }finally {
                    lock.unlock();
                }
                System.out.print("WaitPerson got " + restaurant.meal + " ");
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException iEX){
            System.out.println("WaitPerson interrupted");
        }
    }

}
