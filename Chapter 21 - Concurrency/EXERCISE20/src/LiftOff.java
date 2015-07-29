/**
 * Created by alexeychizhov on 23.05.2015.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : countDown +">>>LiftOff") + ")";
    }

    public void run(){
        while (countDown-- > 0){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted: #" + id);
                break;
            }
                System.out.println(status());
                Thread.yield();
        }
    }
}
