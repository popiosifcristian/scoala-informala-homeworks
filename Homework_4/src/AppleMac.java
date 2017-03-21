/**Our class for Apple Mac
 * @author Pop Iosif Cristian
 */
public class AppleMac extends Appliance {
    public void start(){
        setWorking(true);
        setConsumption(100f);
    }
    public void stop(){
        setWorking(false);
        setConsumption(0f);
    }
    public void musicPlayer(){
        setWorking(true);
        setConsumption(130f);
    }
    public AppleMac(String serialNumber) {
        super(serialNumber);
    }
}
