/**
 * Created by Chizhov-as on 01.07.2015.
 */
public class Car {

    private boolean waxOn = false;

    public synchronized void waxed(){
        waxOn = true;
        notify();
    }

    public synchronized void buffed(){
        waxOn = false;
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false){
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true){
            wait();
        }
    }
}
