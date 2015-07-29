/**
 * Created by Chizhov-as on 10.06.2015.
 */
public class Data {
    private int x = 100;
    private int y = 50;
    private int z=0;

    private SyncObject syncObject = new SyncObject();

    public void zPlus(){
        synchronized (syncObject){
            for (int i=0;i<100;i++){
                x++;
                y++;
                z = x + y;
                System.out.println(i + ":zPlus");
            }
        }
        System.out.println("zPlus" + " z=" + z);
    }

    public void zMinus(){
        synchronized (syncObject){
            for (int i=0;i<100;i++){
                x++;
                y++;
                z = x - y;
                System.out.println(i + ":zMinus");
            }
        }
        System.out.println("zMinus" + " z=" + z);
    }

    public void zMultiply(){
        synchronized (this){ // !=syncObject
            for (int i=0;i<100;i++){
                x++;
                y++;
                z = x * y;
                System.out.println(i + ":zMultiply");
            }
        }
        System.out.println("zMultiply" + " z=" + z);
    }
}
