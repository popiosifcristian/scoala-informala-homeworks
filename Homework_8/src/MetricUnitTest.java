import org.junit.Assert;
import org.junit.Test;
/**
 * This is the tests class
 */
public class MetricUnitTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidUnit() {
            MetricUnit unit = MetricUnit.fromString("10 ana");
    }

    @Test
    public void invalidUnit_3() {
        try {
            MetricUnit unit = MetricUnit.fromString("10 ana");
            Assert.fail("ana is not a valid unit!!!");
        }catch (IllegalArgumentException ex) {
            //expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void noSpaceSeparator() {
        MetricUnit unit = MetricUnit.fromString("10cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noUnit() {
        MetricUnit unit = MetricUnit.fromString("10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noValue() {
        MetricUnit unit = MetricUnit.fromString("cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidValue() {
        MetricUnit unit = MetricUnit.fromString("XX cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSwitchedUnitAndValue() {
        MetricUnit unit = MetricUnit.fromString("cm 10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullString() {
        MetricUnit unit = MetricUnit.fromString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty() {
        MetricUnit unit = MetricUnit.fromString("");
    }


    @Test
    public void one_cm() {
        MetricUnit unit = MetricUnit.fromString("1 cm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_cm_upper_case() {
        MetricUnit unit = MetricUnit.fromString("1 CM");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_cm_camel_case() {
        MetricUnit unit = MetricUnit.fromString("1 Cm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_mm() {
        MetricUnit unit = MetricUnit.fromString("1 mm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("mm", unit.getUnit());
    }

    @Test
    public void one_m() {
        MetricUnit unit = MetricUnit.fromString("1 m");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }


    @Test
    public void smallValue() {
        MetricUnit unit = MetricUnit.fromString("0.01 m");
        Assert.assertEquals(0.01, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }

    @Test
    public void largeValue() {
        MetricUnit unit = MetricUnit.fromString("1000.99 m");
        Assert.assertEquals(1000.99, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }

    @Test
    public void negativeValue() {
        MetricUnit unit = MetricUnit.fromString("-10.5 cm");
        Assert.assertEquals(-10.5, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }


    @Test
    public void addWithNull() {
        MetricUnit m1 = new MetricUnit(1, "cm");
        MetricUnit m2 = m1.add(null);
        Assert.assertEquals(m1, m2);
    }


    @Test
    public void multiplyWithTwo() {
        MetricUnit m1 = new MetricUnit(1, "cm");
        MetricUnit m2 = m1.add(m1);
        Assert.assertEquals(2, m2.getValue(), 0.0001);
        Assert.assertEquals("cm", m2.getUnit());
    }

    @Test
    public void addCmToM() {
        MetricUnit m1 = new MetricUnit(10, "cm");
        MetricUnit m2 = new MetricUnit(2, "m");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(210, m3.getValue(), 0.0001);
        Assert.assertEquals("cm", m3.getUnit());
    }

    @Test
    public void addMMToM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "m");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(2010, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void addMMToCm() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "cm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(30, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void addMMToMM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "mm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(12, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }


    @Test
    public void substractMMToCm() {
        MetricUnit m1 = new MetricUnit(-10, "mm");
        MetricUnit m2 = new MetricUnit(2, "cm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(10, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void substractMMToMM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(-2, "mm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(8, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void calculateExpression(){
        String expression = "10 cm + 1 m - 10 mm ";
        MetricUnit result=new MetricUnit(0,"km");
        result = result.calculateExpression(expression);
        Assert.assertEquals(1090, result.getValue(), 0.0001);
        Assert.assertEquals("mm", result.getUnit());
    }
    @Test
    public void noExpression(){
        String expression = "10 cm";
        MetricUnit result=new MetricUnit(0,"km");
        result = result.calculateExpression(expression);
        Assert.assertEquals(10, result.getValue(), 0.0001);
        Assert.assertEquals("cm", result.getUnit());
    }
    @Test
    public void justSubstraction(){
        String expression = "10 cm - 1 m - 10 mm ";
        MetricUnit result=new MetricUnit(0,"km");
        result = result.calculateExpression(expression);
        Assert.assertEquals(-910, result.getValue(), 0.0001);
        Assert.assertEquals("mm", result.getUnit());
    }
    @Test
    public void notCompleteExpression(){
        String expression = "10 cm -";
        MetricUnit result=new MetricUnit(0,"km");
        result = result.calculateExpression(expression);
        Assert.assertEquals(10, result.getValue(), 0.0001);
        Assert.assertEquals("cm", result.getUnit());
    }
}
