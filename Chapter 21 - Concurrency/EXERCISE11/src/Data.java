/**
 * Created by Chizhov-AS on 28.05.2015.
 */
public class Data {

    private int data01 = 1;
    private int data02 = 1;

    public int sum(){ //!!!synchronized!!!

        //System.out.println(Thread.currentThread().getName() + "     Start ++++++++++");

        data01++;
        data01++;
        data02++;
        data02++;
        data01--;
        data01--;
        data02--;
        data02--;
        // !!!Result = zero!!!

        //System.out.println(Thread.currentThread().getName() + "     Finish ---------");
        return data01 - data02;
    }
}