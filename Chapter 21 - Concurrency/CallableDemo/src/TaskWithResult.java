import java.util.concurrent.Callable;

/**
 * Created by alexeychizhov on 24.05.2015.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "Result" + id;
    }
}
