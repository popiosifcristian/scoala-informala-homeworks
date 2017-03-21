/**This is the Brabus class, child of Mercedess
 * The Brabus has a higher consumption when the tire size are larger than 16
 * @author Pop Iosif Cristian
 */
public class Brabus extends Mercedes {
    public Brabus(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean superSport) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tireSize,superSport);
    }

    @Override
    public void drive(float distance) {
        setGearsConsumption(10,11,13,15,17,20);
        if(getTireSize()>16)//if size of tires is larger than 16 the consumption will be higher
            setActualConsumption(getActualConsumption()*getTireSize()/10);//a proportional calculation of consume depending on tire size
        setAvailableFuel(getAvailableFuel()-(getActualConsumption()*distance/100));
        setConsumptionCount(getConsumptionCount()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+getActualConsumption());
    }
}
