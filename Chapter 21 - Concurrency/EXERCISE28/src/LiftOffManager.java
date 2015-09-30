/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class LiftOffManager implements Runnable {

    private LiftOffRunner liftOffRunner;

    public LiftOffManager(LiftOffRunner liftOffRunner){
        this.liftOffRunner = liftOffRunner;
    }

    @Override
    public void run() {
        for (int i=0; i<5;i++){
            liftOffRunner.add(new LiftOff(4));
            System.out.println("LiftOffManager add to queue " + i);
        }
    }
}
