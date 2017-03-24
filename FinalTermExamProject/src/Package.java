import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Joseph Friday, 24.03.2017 at 18:08.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Package {
    private TargetLocation targetLocation;
    private double merchandiseValue;
    private LocalDate deliveryDate;
    private DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Package(String targetLocation, int distance, double merchandiseValue, String deliveryDate) {
        this.targetLocation=new TargetLocation(targetLocation,distance);
        this.merchandiseValue = merchandiseValue;
        this.deliveryDate = LocalDate.parse(deliveryDate,formatter);
    }

    public TargetLocation getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(TargetLocation targetLocation) {
        this.targetLocation = targetLocation;
    }

    public double getMerchandiseValue() {
        return merchandiseValue;
    }

    public void setMerchandiseValue(double merchandiseValue) {
        this.merchandiseValue = merchandiseValue;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (Double.compare(aPackage.merchandiseValue, merchandiseValue) != 0) return false;
        if (targetLocation != null ? !targetLocation.equals(aPackage.targetLocation) : aPackage.targetLocation != null)
            return false;
        return deliveryDate != null ? deliveryDate.equals(aPackage.deliveryDate) : aPackage.deliveryDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = targetLocation != null ? targetLocation.hashCode() : 0;
        temp = Double.doubleToLongBits(merchandiseValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n"+"Package{ " + targetLocation +
                ", merchandiseValue=" + merchandiseValue +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

