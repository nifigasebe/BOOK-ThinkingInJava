/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class Boss implements Runnable {

    JobStack jobStack;

    public Boss(JobStack jobStack){
        this.jobStack = jobStack;
    }

    @Override
    public void run() {
    try {
        while (!Thread.interrupted()) {
            for(int i=1;i<11;i++){
                synchronized (jobStack){
                    while (JobStack.flagJobIsExist) {
                        jobStack.wait();
                    }
                    Job job = new Job(i);
                    jobStack.setJob(job);
                    JobStack.flagJobIsExist = true;
                    jobStack.notifyAll();
                }
            }
            break;
        }
    }
    catch (InterruptedException iEX){
        iEX.printStackTrace();
    }
    JobStack.isFlagJobIsDone = true;
    System.out.println("Boss go home");
    }
}