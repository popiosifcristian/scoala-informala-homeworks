/**This is the S63Coupe class, child of Mercedess
 * The S63Coupe has a super sport mode. IF that mode is turned on the consume
 * will be with 50% higher than the basic consume
 * @author Pop Iosif Cristian
 */
public class S63Coupe extends Mercedes {
    public S63Coupe(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean superSport) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tireSize,superSport);
    }
    @Override
    public void drive(float distance){

        setGearsConsumption(10,9,8,10,11,13);
        if(isSuperSport())//if super sport mode is activated
            setActualConsumption(getActualConsumption()+getActualConsumption()*50/100);//the consume will be with 50% higher
        setAvailableFuel(getAvailableFuel()-(getActualConsumption()*distance/100));
        setConsumptionCount(getConsumptionCount()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+getActualConsumption());
    }
}
