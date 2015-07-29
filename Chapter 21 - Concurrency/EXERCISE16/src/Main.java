/**
 * Created by Chizhov-as on 10.06.2015.
 */
public class Main {
    static Data data = new Data();

    public static void main(String[] args) {
        new Thread("Thread1"){public void run(){
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>Start");
            data.zPlus();
            }
        }.start();
        new Thread("Thread2"){public void run(){
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>Start");
            data.zMinus();
            }
        }.start();
        new Thread("Thread3"){public void run(){
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>Start");
            data.zMultiply();
            }
        }.start();
    }
}
