/**This class implements Vehicle
 * This class have the goal to define all cars
 * @author Pop Iosif Cristian
 */
public abstract class Car implements Vehicle {

    //properties of a car model which can not change
    private float fuelTankSize;
    private  String fuelType;
    private  int gears;
    private  float consumptionPer100Km;

    //properties that are configurable
    private float availableFuel;
    private int tireSize;

    //properties that are instance specific
    private String chassisNumber;

    private int actualGear;
    private float actualConsumption;
    private int consumptionCount;

    public Car(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType){
        this.availableFuel=availableFuel;
        this.chassisNumber=chassisNumber;
        this.fuelTankSize=fuelTankSize;
        this.fuelType=fuelType;
    }

    /**
     * when we start we set consumption per 100 km 0,
     * consumption count 0 and we have actual gear 0
     */
    @Override
    public void start() {
    setConsumptionPer100Km(0);
    setConsumptionCount(0);
    setActualGear(0);
    }

    /**
     * when we stop we set actual gear to 0
     * and we calculate consumption per 100 km(the average)
     */
    @Override
    public void stop(){
    setActualGear(0);
    setConsumptionPer100Km(consumptionPer100Km/consumptionCount);
    }

    /**
     * here we have a function what calculate the available fuel
     * depending on consumption and distance
     * @param distance
     */
    public void drive(float distance){
        setAvailableFuel(getAvailableFuel()-(getActualConsumption()*distance/100));
        setConsumptionCount(getConsumptionCount()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+getActualConsumption());
    }

    /**
     *with this method we will set easy consumption for every gear
     */
    public void setGearsConsumption(float consumption1,float consumption2,float consumption3,float consumption4,float consumption5,float consumption6){
        switch(getActualGear()){
            case 1:{
                setActualConsumption(consumption1);
            }break;

            case 2:{
                setActualConsumption(consumption2);
            }break;

            case 3:{
                setActualConsumption(consumption3);
            }break;

            case 4:{
                setActualConsumption(consumption4);
            }break;

            case 5:{
                setActualConsumption(consumption5);
            }break;

            case 6:{
                setActualConsumption(consumption6);
            }break;

            default:{
                if(getActualGear()==0)
                    System.out.println("you are in idle speed");
                else
                    System.out.println("you don't have that gear");
            }break;
        }
    }

    public void shiftGear(int nextGear){
    this.actualGear=nextGear;
    }

    public float getFuelTankSize() {
        return fuelTankSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getGears() {
        return gears;
    }

    public float getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    public float getAvailableFuel() {
        return availableFuel;
    }

    public int getTireSize() {
        return tireSize;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public int getActualGear() {
        return actualGear;
    }

    public float getActualConsumption() {
        return actualConsumption;
    }

    public void setFuelTankSize(float fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setConsumptionPer100Km(float consumptionPer100Km) {
        this.consumptionPer100Km = consumptionPer100Km;
    }

    public void setAvailableFuel(float availableFuel) {
        this.availableFuel = availableFuel;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void setActualGear(int actualGear) {
        this.actualGear = actualGear;
    }

    public void setActualConsumption(float actualConsumption) {
        this.actualConsumption = actualConsumption;
    }

    public int getConsumptionCount() {
        return consumptionCount;
    }

    public void setConsumptionCount(int consumptionCount) {
        this.consumptionCount = consumptionCount;
    }
}
