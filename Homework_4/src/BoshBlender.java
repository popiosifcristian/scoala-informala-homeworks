/**Our Class for Bosh Blender
 * @author Pop Iosif Cristian
 */
public class BoshBlender extends Appliance {
    public BoshBlender(String serialNumber) {
        super(serialNumber);
    }

    public void start(){
        setWorking(true);
        setConsumption(50f);
    }
    public void stop(){
        setWorking(false);
        setConsumption(0f);
    }
    public void superFastFunction(){
        setWorking(true);
        setConsumption(200f);
    }


}
