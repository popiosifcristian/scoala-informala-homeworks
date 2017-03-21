/**This is the main class
 * In this class we will create instances of all classes
 * @author Pop Iosif Cristian
 */
public class Main {
    public static void main(String args[]){
    Car car = new Logan(50, "oiqe0934hkkadsn",50,"benzina",13,false);
        car.start();
        car.shiftGear(2);
        car.drive(150);
        car.shiftGear(3);
        car.drive(150);
        car.shiftGear(1);
        car.drive(10);
        car.stop();
        float availableFuel = car.getAvailableFuel();
        float fuelConsumedPer100Km = car.getConsumptionPer100Km();
        System.out.println("we have "+availableFuel+" fuel left");
        System.out.println("average fuel consumption per 100Km is "+fuelConsumedPer100Km);

    Car offroad = new Brabus(160, "1987ddkshik289",161,"motorina",20,false);
        offroad.start();
        offroad.shiftGear(1);
        offroad.drive(100);
        offroad.stop();
        availableFuel=offroad.getAvailableFuel();
        fuelConsumedPer100Km=offroad.getConsumptionPer100Km();
        System.out.println("we have "+availableFuel+" fuel left");
        System.out.println("average fuel consumption per 100Km is "+fuelConsumedPer100Km);

        Vehicle vehicle=new Logan(50, "oiqe0934hkkadsn",50,"benzina",13,false);
        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();
        Car absolute = (Car)vehicle;
        availableFuel=absolute.getAvailableFuel();
        System.out.println("available fuel "+availableFuel);

    Car duster = new Duster(50, "oiqe0934hkkadsn",50,"motorina",15,true);
        duster.start();
        duster.shiftGear(2);
        duster.drive(150);
        duster.shiftGear(3);
        duster.drive(150);
        duster.shiftGear(1);
        duster.drive(10);
        duster.stop();
        availableFuel=duster.getAvailableFuel();
        fuelConsumedPer100Km=duster.getConsumptionPer100Km();
        System.out.println("we have "+availableFuel+" fuel left");
        System.out.println("average fuel consumption per 100Km is "+fuelConsumedPer100Km);

        Car red = new S63Coupe(50, "oiqe0934hkkadsn",50,"motorina",15,true);
        red.start();
        red.shiftGear(2);
        red.drive(150);
        red.shiftGear(3);
        red.drive(150);
        red.shiftGear(1);
        red.drive(10);
        red.stop();
        availableFuel=red.getAvailableFuel();
        fuelConsumedPer100Km=red.getConsumptionPer100Km();
        System.out.println("we have "+availableFuel+" fuel left");
        System.out.println("average fuel consumption per 100Km is "+fuelConsumedPer100Km);
    }
}
