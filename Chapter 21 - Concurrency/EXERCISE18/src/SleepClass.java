/**
 * Created by Chizhov-as on 19.06.2015.
 */
public class SleepClass {

    public void start(){
        try {

            System.out.println("Start1 " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Stop1 "  + Thread.currentThread().getName());

            System.out.println("Start2 " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Stop2 "  + Thread.currentThread().getName());

            System.out.println("Start3 " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Stop3 "  + Thread.currentThread().getName());

        }catch (InterruptedException iEX){
            System.out.println("InterruptedException! " + Thread.currentThread().getName());
        }
    }
}
