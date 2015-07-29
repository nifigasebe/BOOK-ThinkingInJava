import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by alexeychizhov on 24.05.2015.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();
        for(int i=0;i<10;i++){
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }
            finally {
                exec.shutdown();
            }
        }
    }
}
