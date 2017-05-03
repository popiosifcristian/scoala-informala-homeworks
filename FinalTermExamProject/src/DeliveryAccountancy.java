import java.util.List;

/**
 * Created by Joseph Friday, 24.03.2017 at 19:47.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class DeliveryAccountancy {
    private static final double COST_PER_KM = 1;
    private static final double INCOME_PER_KM = 3;
    private static final double PROFIT_PER_KM = INCOME_PER_KM-COST_PER_KM;
    private double totalProfit;
    private double totalMerchandiseValue;


    public void calculateProfit(List<Package> packages) {
        for (Package p : packages) {
            totalProfit = totalProfit + calculatePackageProfit(p.getTargetLocation().getDistance());
            totalMerchandiseValue = totalMerchandiseValue + p.getMerchandiseValue();
        }
    }

    private double calculatePackageProfit(int distance) {
        return PROFIT_PER_KM * distance;
    }


    public void reset(){
        totalMerchandiseValue=0;
        totalProfit=0;
    }

    public double getTotalProfit() {
        return totalProfit;
    }


    public double getTotalMerchandiseValue() {
        return totalMerchandiseValue;
    }

    @Override
    public String toString() {
        return " total profit= " + totalProfit +
                " and total merchandise value= " + totalMerchandiseValue ;
    }
}

