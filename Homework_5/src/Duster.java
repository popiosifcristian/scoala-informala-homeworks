/**This is the Duster class, child of Dacia
 * The Duster has a radio FM . IF the radio is turned on the consume
 * will be with 10% higher than the basic consume
 * @author Pop Iosif Cristian
 */
public class Duster extends Dacia {
    public Duster(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean radioFm) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tireSize,radioFm);
    }

    @Override
    public void drive(float distance){
        setGearsConsumption(7,6,5,7,8,7);
        if(isSpecialFunction())//if radio FM is turned on
            setActualConsumption(getActualConsumption()+getActualConsumption()*10/100);//the consumption will be with 10% higher
        setAvailableFuel(getAvailableFuel()-(getActualConsumption()*distance/100));
        setConsumptionCount(getConsumptionCount()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+getActualConsumption());
    }
}
