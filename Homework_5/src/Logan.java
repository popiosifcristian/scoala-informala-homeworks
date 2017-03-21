/**This is the Logan class, child of Dacia
 * The Logan has a air conditioner. IF the air coditioner is turned on the consume
 * will be with 30% higher than the basic consume
 * @author Pop Iosif Cristian
 */
public class Logan extends Dacia {
    public Logan(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean airConditioner) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tireSize,airConditioner);
    }

    @Override
    public void drive(float distance){
        setGearsConsumption(7,6,5,7,8,7);
        if(isSpecialFunction())//if air conditioner is turned on
            setActualConsumption(getActualConsumption()+getActualConsumption()*30/100);//the consumption will be with 30% higher
        setAvailableFuel(getAvailableFuel()-(getActualConsumption()*distance/100));
        setConsumptionCount(getConsumptionCount()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+getActualConsumption());
    }
}
