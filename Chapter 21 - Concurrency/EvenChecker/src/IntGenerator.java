/**
 * Created by Chizhov-AS on 27.05.2015.
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();
    
    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}