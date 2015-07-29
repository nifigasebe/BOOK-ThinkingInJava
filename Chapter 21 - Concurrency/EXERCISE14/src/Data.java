/**
 * Created by alexeychizhov on 30.05.2015.
 */
public class Data {

    private int data;
    Data(int d){
        this.data = d;
    }

    public synchronized int add() {
        return data++;
    }

    public synchronized int getData() {
        return data;
    }
}
