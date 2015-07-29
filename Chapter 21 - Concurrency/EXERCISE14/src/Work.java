import java.util.TimerTask;

/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class Work extends TimerTask {

    Data data;

    Work(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        for(int i=0; i<500;i++){
            data.add();
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
