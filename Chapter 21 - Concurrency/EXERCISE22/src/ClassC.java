/**
 * Created by Chizhov-as on 30.06.2015.
 */
public class ClassC implements Runnable{
    static volatile boolean flag = false;

    ClassD classD;
    ClassC(ClassD classD){
        this.classD = classD;
    }

    @Override
    public void run() {
        try {
            System.out.println("ClassC: start sleep");
            Thread.sleep(2000);
            System.out.println("ClassC: stop  sleep");
        }catch (InterruptedException iEX){
            System.out.println("iEX" + Thread.currentThread().getName());
        }
        System.out.println("ClassC: flag=true");
        flag = true;
        synchronized (classD){
            System.out.println("ClassC: notifyAll ClassD");
            classD.notifyAll();
        }
    }
}