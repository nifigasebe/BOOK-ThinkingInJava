/**
 * Created by Chizhov-as on 30.06.2015.
 */
public class ClassB implements Runnable{

    ClassA classA;
    public ClassB(ClassA classA){
        this.classA = classA;
    }

    @Override
    public void run() {
        while (true){
            if (classA.getFlag()){
                classA.setFlag(false);
                System.out.println("ClassB: flag=false");
                break;
            }
        }
    }
}
