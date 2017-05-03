import java.util.List;

/**
 * Created by Joseph Friday, 24.03.2017 at 19:14.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class PackageDeliveryThread extends Thread {
    private List<Package> packages;
    private DeliveryAccountancy accountancy= new DeliveryAccountancy();

    public PackageDeliveryThread(List<Package> packages) {
        this.packages = packages;
        accountancy.calculateProfit(packages);
    }

    @Override
    public void run() {
        Package pack = packages.get(0);
        System.out.println("Starting delivery for "+packages.size()+
                " package/s to "+pack.getTargetLocation().getName());
        try {
            while(pack.getTargetLocation().getDistance()>0){
                Thread.sleep(1000);
                pack.getTargetLocation().setDistance(pack.getTargetLocation().getDistance()-1);
                System.out.print("->");
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
        System.out.println('\n'+"The delivery for "+pack.getTargetLocation().getName()+" was performed successfully" +
                " with total merchandise value= "+String.format("%.2f",accountancy.getTotalMerchandiseValue())+
                " and total profit= "+accountancy.getTotalProfit());
    }
}

