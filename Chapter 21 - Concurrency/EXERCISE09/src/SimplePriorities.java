import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Chizhov-AS on 25.05.2015.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 2;
    private volatile double d;
    public static int priority = 4;

    public String toString(){
        return Thread.currentThread() + ": >>> " + countDown;
    }

    public void run(){

        while (true){
            for(int i=0; i<100000; i++){
                d+= (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0 ){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    static class PriorityThreadFactory implements ThreadFactory{

        int priority;
        PriorityThreadFactory(int p){
            if ((p>0)&(p<11)){
                this.priority = p;
            }else {
                this.priority = 5;
            }
        }

        public Thread newThread(Runnable r){
            Thread t = new Thread(r);
            t.setPriority(priority);
            return t;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(priority));
        for (int i=0;i<5;i++){
            exec.execute(new SimplePriorities());
            exec.execute(new SimplePriorities());
        }
        exec.shutdown();
    }
}