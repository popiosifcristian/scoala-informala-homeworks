/**Our class for Samsung Smart Fridge
 * @author Pop Iosif Cristian
 */
public class SamsungSmartFridge extends Appliance {
    public SamsungSmartFridge(String serialNumber) {
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
    public void superFreezer(){
        setWorking(true);
        setConsumption(20f);
    }

}
