/**
 * Created by Chizhov-as on 07.07.2015.
 */
public class JobStack {

    public static volatile boolean flagJobIsExist = false;
    public static volatile boolean isFlagJobIsDone = false;

    Job job;

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }
}
