/**
 * Created by Chizhov-as on 10.06.2015.
 */
public class Main {
    static Data data = new Data();

    public static void main(String[] args) {
        new Thread(){public void run(){data.zPlus();}}.start();
        new Thread(){public void run(){data.zMinus();}}.start();
        new Thread(){public void run(){data.zMultiply();}}.start();
    }
}
