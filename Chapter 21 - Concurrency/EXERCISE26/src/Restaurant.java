import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);

    public Restaurant(){
        executorService.execute(chef);
        executorService.execute(waitPerson);
        executorService.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
