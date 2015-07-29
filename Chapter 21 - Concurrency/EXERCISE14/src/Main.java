import java.util.Timer;

/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(0);
        new Timer("Timer t1").schedule(new Work(data), 1000);
        new Timer("Timer t2").schedule(new Work(data), 999);
        new Timer("Timer t3").schedule(new Work(data), 1001);
        try {
            Thread.sleep(4000);
        }catch (InterruptedException iEX){
            //ignore
        }
        System.out.println(data.getData());
    }
}
