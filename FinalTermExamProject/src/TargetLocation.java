/**
 * Created by Joseph Friday, 24.03.2017 at 19:07.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class TargetLocation {
    private String name;
    private int distance;

    public TargetLocation(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetLocation that = (TargetLocation) o;

        if (distance != that.distance) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        return " name= " + name + '\'' +
                ", distance= " + distance ;
    }
}


