/**This is the main class
 * @author Pop Iosif Cristian
 */
public class Main {
    public static void main(String[] args){

        String expression = "10 cm + 1 m - 10 mm ";

        MetricUnit result=new MetricUnit(0,"km");
        result=result.calculateExpression(expression);
        System.out.println(result.toString());

    }
}
