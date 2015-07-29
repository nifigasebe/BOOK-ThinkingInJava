/**
 * Created by Chizhov-AS on 27.05.2015.
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public int next(){
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        Checker.test(new EvenGenerator());
    }
}
