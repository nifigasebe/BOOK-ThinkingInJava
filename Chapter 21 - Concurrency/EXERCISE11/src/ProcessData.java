/**
 * Created by Chizhov-AS on 27.05.2015.
 */
public class ProcessData implements Runnable{

    Data data;
    ProcessData(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        for (int i=0; i < 100;i++){
            data.sum();
        }
        System.out.println(">>" + data.sum());
    }
}