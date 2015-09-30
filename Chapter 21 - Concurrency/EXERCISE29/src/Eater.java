/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int couter = 0;

    public Eater(ToastQueue finished){
        finishedQueue = finished;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                Toast t = finishedQueue.take();
                if(!(t.getId() == couter++ || (t.getStatus() == Toast.Status.JAMMED | t.getStatus() == Toast.Status.PEANUTBUTTERED ))){
                    System.out.println(">>>> Error: " + t  );
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t );
                }
            }
        }catch (InterruptedException e){
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
