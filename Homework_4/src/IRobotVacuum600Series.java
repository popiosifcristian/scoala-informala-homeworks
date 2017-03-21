/**Our class for Irobot Vacuum 600 Series
 * @author Pop Iosif Cristian
 */
public class IRobotVacuum600Series extends IRobotVacuum {
    public IRobotVacuum600Series(String serialNumber) {
        super(serialNumber);
    }

    public void superFastFunction(){
        setWorking(true);
        setConsumption(50f);
    }
}
