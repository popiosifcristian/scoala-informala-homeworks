import java.util.Arrays;

/**This is the metric unit class where we will define metric units
 * and where we will have the methods of metric units
 */
public class MetricUnit {

    private static String[] KNOWN_UNITS = new String[]{"mm", "cm", "dm", "m", "km"};
    private double value;
    private String unit;

    public MetricUnit(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }


    /**@throws  IllegalArgumentException in case that the string can not be converted to a {@link MetricUnit}
     * @param string
     * @return metricUnit
     */
    public static MetricUnit fromString(String string) {

        if (string==null)
            throw new IllegalArgumentException("a null string");

        String[] separated=string.split(" ");

        if(separated.length<2)
            throw new IllegalArgumentException("no unit or no value");

        if(!separated[1].toLowerCase().equals("mm")&&!separated[1].toLowerCase().equals("cm")&&
                !separated[1].toLowerCase().equals("dm")&&!separated[1].toLowerCase().equals("m")&&
                !separated[1].toLowerCase().equals("km"))
            throw new IllegalArgumentException("not valid unit");

        MetricUnit metricUnit = new MetricUnit(Double.parseDouble(separated[0]),separated[1].toLowerCase());

        return metricUnit;
    }


    /**
     * This method will convert other unit to our unit if our unit is smaller otherwise will convert
     * our unit to other unit if other unit is smaller. after that it will initialize our value with the
     * sum of our value and other value
     * @param other
     * @return
     */
    public MetricUnit add(MetricUnit other) {
        if (other == null) {
            return this;
        }

        MetricUnit result = null;
        String targetUnit = null;
        if (unitIndex(this.getUnit()) > unitIndex(other.getUnit())) {
            targetUnit = other.getUnit();
        }else {
            targetUnit = this.getUnit();
        }

        double thisValue = convertTo(targetUnit);

        double thatValue = other.convertTo(targetUnit);

        result = new MetricUnit(thisValue + thatValue, targetUnit);

        return result;
    }

    /**
     * this method will get us the index of the unit.
     * this method will help us to convert a value of a Metric Unit
     * @param unit
     * @return the index of our unit
     */
    private int unitIndex(String unit) {
        return Arrays.asList(KNOWN_UNITS).indexOf(unit);
    }

    /**
     *This method will convert our Metric Unit value using unitIndex
     * @param unit
     * @return converted value
     */
    private double convertTo(String unit) {

        return getValue() * Math.pow(10, unitIndex(this.getUnit()) - unitIndex(unit));
    }

    /**
     * This method will calculate an expression stored in a string
     * Firstly we will create an Array of strings filled by expression string items separated by space
     *we will set a pattern with a,b and c where a will be always the opperator + or -
     * b will be always the value of the metric unit and c the unit
     * if a is + we will gather the metric units else if a is - we will subtract the metric units
     * while a will be smaller than length of separatedExpression - 1
     * @param expression
     *
     */
    public MetricUnit calculateExpression(String expression){
        String[] separatedExpression = expression.split(" ");
        int a=2,b=0,c=1;
        MetricUnit result= new MetricUnit(Double.parseDouble(separatedExpression[b]),separatedExpression[c]);
        b=3;
        c=4;
        while (a<separatedExpression.length-1){
            if(separatedExpression[a].equals("+"))
                result=result.add(new MetricUnit(Double.parseDouble(separatedExpression[b]),separatedExpression[c]));
            else
                result=result.add(new MetricUnit(-Double.parseDouble(separatedExpression[b]),separatedExpression[c]));
            a=a+3;
            b=b+3;
            c=c+3;
        }
        return result;
    }

    @Override
    public String toString() {
        return "MetricUnit{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
