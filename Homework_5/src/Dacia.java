/**This class is a child of Car
 * This class have the goal to define Dacia cars
 * Some Dacia Cars have a special function
 * @author Pop Iosif Cristian
 */
public abstract class Dacia extends Car {
    private boolean specialFunction;
    public Dacia(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean specialFunction) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType);
        setTireSize(tireSize);
        setSpecialFunction(specialFunction);
    }

    public void setSpecialFunction(boolean specialFunction) {
        this.specialFunction = specialFunction;
    }

    public boolean isSpecialFunction() {
        return specialFunction;
    }
}
