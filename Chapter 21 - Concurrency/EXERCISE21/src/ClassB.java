/**
 * Created by Chizhov-as on 26.06.2015.
 */
public class ClassB implements Runnable {

    ClassA classA;

    ClassB(ClassA classA){
        this.classA = classA;
    }

    @Override
    public void run() {

        try {
            System.out.println("Start sleep");
            Thread.sleep(3000);
            System.out.println("Stop  sleep");
            synchronized (classA){
                classA.notifyAll();}
            System.out.println(">>>notifyAll");
        }catch (InterruptedException iEX){
            System.out.println("iEX" + Thread.currentThread().getName());
        }
    }
}
