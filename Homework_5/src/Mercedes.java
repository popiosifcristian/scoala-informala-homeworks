/**This class is a child of Car
 * This class have the goal to define Mercedes cars
 * Some Mercedes Cars have a super sport mode
 * @author Pop Iosif Cristian
 */
public abstract class Mercedes extends Car {
    private boolean superSport;
    public Mercedes(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tireSize,boolean superSport) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType);
        setTireSize(tireSize);
        setSuperSport(superSport);
    }

    public void setSuperSport(boolean superSport) {
        this.superSport = superSport;
    }

    public boolean isSuperSport() {
        return superSport;
    }
}
