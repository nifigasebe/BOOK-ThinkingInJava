/**
 * Created by Chizhov-as on 19.06.2015.
 */
public class RunnableClass implements Runnable{

    SleepClass sleepClass = new SleepClass();

    @Override
    public void run() {
        sleepClass.start();
    }
}
