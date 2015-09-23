import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    Lock lock = new ReentrantLock(); //1
    Condition condition = lock.newCondition(); //1

    public Chef(Restaurant r){
        restaurant = r;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                lock.lock(); //1
                try { //1
                    while (restaurant.meal != null){
                        condition.await(); //1
                    } //1
                } finally { //1
                    lock.unlock(); //1
                } //1
                if(++count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.executorService.shutdownNow();
                    return; //2
                }
                System.out.println("Orer Up!");
                restaurant.waitPerson.lock.lock(); //1
                try{
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll(); //1

                }finally {
                    restaurant.waitPerson.lock.unlock(); //1
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException iEX){
            System.out.println("Chef interrupted");
        }
    }
}
