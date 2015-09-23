/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class Worker implements Runnable{

    JobStack jobStack;
    Job job;

    public Worker(JobStack jobStack){
        this.jobStack = jobStack;
    }

    @Override
    public void run() {
        try {
            while (!JobStack.isFlagJobIsDone & !Thread.currentThread().isInterrupted()) {
                synchronized (jobStack) {
                    while (!JobStack.flagJobIsExist){
                        jobStack.wait();
                    }
                    job = jobStack.getJob();
                    Thread.currentThread().sleep(500);
                    System.out.println("Job " + job.id + " is done!");
                    JobStack.flagJobIsExist = false;
                    jobStack.notifyAll();
                }
            }

        }catch (InterruptedException iEX){
            iEX.printStackTrace();
        }
        System.out.println("Worker go home");
    }
}
