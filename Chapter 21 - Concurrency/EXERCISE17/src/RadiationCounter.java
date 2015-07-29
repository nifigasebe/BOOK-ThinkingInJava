/**
 * Created by Chizhov-as on 11.06.2015.
 */
public class RadiationCounter {
    float[] sensorsData;

    RadiationCounter(int numberOfSensors){
        sensorsData = new float[numberOfSensors];
    }

    public synchronized void setRadiationLevel(float radiationLevel,int numberOfSensor ){
        sensorsData[numberOfSensor] = radiationLevel;
    }

    public float getAverageRadiationLevel(){
        float sum = 0;
        for (float sensor : sensorsData){
            sum += sensor;
        }
        return sum / sensorsData.length;
    }
}
