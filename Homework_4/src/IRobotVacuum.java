/**Our class for IRobot Vacum
 * @author Pop Iosif Cristian
 */
public class IRobotVacuum extends Appliance {
    public IRobotVacuum(String serialNumber) {
        super(serialNumber);
    }

    public void start(){
        setWorking(true);
        setConsumption(10f);
    }
    public void stop(){
        setWorking(false);
        setConsumption(0f);
    }
    public void cleanPetHair(){
        setWorking(true);
        setConsumption(15f);
    }
}
