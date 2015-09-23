/**
 * Created by alexeychizhov on 13.09.2015.
 */
public class Meal {
    private final int orderNum;

    public Meal (int orderNum){
        this.orderNum = orderNum;
    }

    public String toString(){
        return "Meal " + orderNum;
    }
}
