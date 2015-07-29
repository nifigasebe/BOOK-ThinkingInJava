import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chizhov-as on 19.06.2015.
 */
public class Entrance implements Runnable{
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public  static void cancel() {
        canceled = true;
    }

    public Entrance(int id){
        this.id = id;
        entrances.add(this);
    }

    public void run(){
        while (!canceled){
            synchronized (this){
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (InterruptedException iEX){
                System.out.println("Sleep interrupted");
                break; // Way out !
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue(){
        return number;
    }

    public String toString(){
        return "Entrance " + id +": "+ getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum = 0;
        for(Entrance entrance : entrances){
            sum += entrance.getValue();
        }
        return sum;
    }
}