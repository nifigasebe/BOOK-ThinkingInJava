/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class Boss implements Runnable {
    JobStack jobStack = new JobStack();


    public Boss(JobStack jobStack){
        this.jobStack = jobStack;
    }

    @Override
    public void run() {
        for(int i=1;i<11;i++){
            try {
                while (!Thread.interrupted()){
                    while (JobStack.jobFlag) {
                        wait();
                    }
                    synchronized (jobStack){
                        Job job = new Job(i);
                        jobStack.setJob(job);
                        JobStack.jobFlag = false;
                        ;
                    }
                }
            }catch (InterruptedException iEX){
                iEX.printStackTrace();
            }
        }
    }
}
