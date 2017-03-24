/**
 * Created by Joseph Friday, 24.03.2017 at 19:59.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        PackageRepository packageRepository = new PackageRepository();
        PackageDeliverySystem packageDeliverySystem = new PackageDeliverySystem(packageRepository);
        packageRepository.addPackage(new Package("Baia Mare", 10, 20, "2017-04-20"));
        packageRepository.addPackage(new Package("Baia Mare", 10, 20, "2017-04-20"));
        packageRepository.addPackage(new Package("Baia Mare", 10, 20, "2017-04-20"));
        packageRepository.addPackage(new Package("Baia Mare", 10, 20, "2017-04-21"));
        packageRepository.addPackage(new Package("Sibiu", 20, 40, "2017-04-20"));
        packageRepository.addPackage(new Package("Sibiu", 20, 60, "2017-04-20"));
        packageRepository.addPackage(new Package("Cluj-Napoca", 30, 10, "2017-04-20"));
        packageRepository.addPackage(new Package("Bucuresti", 60, 0, "2017-04-28"));
        packageRepository.addPackage(new Package("Vaslui", 70, 0, "2017-04-27"));



        packageDeliverySystem.startDeliveryOfPackagesWithSpecificDate("2017-04-20");
    }
}

