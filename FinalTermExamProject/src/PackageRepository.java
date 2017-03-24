import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joseph Friday, 24.03.2017 at 19:08.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class PackageRepository {
    private List<Package> packageList = new ArrayList<>();
    private DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public void addPackage (Package p){
        if (p!=null){
            packageList.add(p);
        }
    }

    public Map<String , List<Package>> getPackagesWithSpecificDate(String specificDate){
        LocalDate date = LocalDate.parse(specificDate,formatter);
        Map<String, List<Package>> packages = new HashMap<>();

        for (Package p : packageList){
            if (p.getDeliveryDate().equals(date)) {
                if (!packages.containsKey(p.getTargetLocation().getName())) {
                    packages.put(p.getTargetLocation().getName(), new ArrayList<>());
                }
                packages.get(p.getTargetLocation().getName()).add(p);
            }
        }
        return packages;
    }
}
