import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Joseph Friday, 24.03.2017 at 19:13.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class PackageDeliverySystem {
    private PackageRepository packageRepository;
    private PackageDeliveryThread delivery;
    private DeliveryAccountancy accountancy=new DeliveryAccountancy();


    public PackageDeliverySystem(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public void startDeliveryOfPackagesWithSpecificDate(String specificDate){
        Map<String, List<Package>> packages = packageRepository.getPackagesWithSpecificDate(specificDate);
        List<PackageDeliveryThread> trucks = new ArrayList<>();
        accountancy.reset();

        for (String location : packages.keySet()){
            accountancy.calculateProfit(packages.get(location));
            delivery= new PackageDeliveryThread(packages.get(location));
            trucks.add(delivery);
            delivery.start();
        }

        for (PackageDeliveryThread pdt : trucks){
            try {
                pdt.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("======================================================================================================================================");
        System.out.println("All deliveries with delivery date "+specificDate+" were performed successfully with " +
                " total merchandise value= "+String.format("%.2f",accountancy.getTotalMerchandiseValue())+
                " and total profit= "+accountancy.getTotalProfit());
    }
}

