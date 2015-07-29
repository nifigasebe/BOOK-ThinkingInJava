import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexeychizhov on 24.05.2015.
 */
public class SleepingTask implements Callable<String> {
    int stopTime = (int)(Math.random()*11);
    long st = (long)(stopTime * 1000);
    int threadID;

    SleepingTask(int threadID){
        this.threadID = threadID;
    }

    public String call(){
        try {
            TimeUnit.MILLISECONDS.sleep(st);
            System.out.println(">>>"+"["+threadID+"]" + "Время приостановки: " + stopTime);
            return "["+threadID+"]" + "Время приостановки: " + stopTime;
        }catch (InterruptedException iEX) {
            iEX.printStackTrace();
            return null;
        }
    }
}
