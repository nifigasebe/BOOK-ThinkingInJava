/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class JobStack {
    Job job;

    public static volatile boolean jobFlag = false;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

}
