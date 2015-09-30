/**
 * Created by Chizhov-AS on 29.09.2015.
 */
public class Toast {

    public enum Status {DRY, BUTTERED, JAMMED,PEANUTBUTTERED}
    private Status status = Status.DRY;
    private final int id;

    public Toast(int id){
        this.id = id;
    }

    public void butter(){
        status = Status.BUTTERED;
    }

    public void penautButter(){
        status = Status.PEANUTBUTTERED;
    }

    public void jam(){
        status = Status.JAMMED;
    }

    public Status getStatus(){
        return status;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Toast " + id + ": " + status;
    }
}
