import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorAppTest {
    private CalculatorApp calculatorApp;

    @Before
    public void setUp() {
        calculatorApp = new CalculatorApp();
    }

    @Test
    public void testAddition() {
        calculatorApp.setCurrentNumber("5");
        calculatorApp.calculate("+");
        calculatorApp.setCurrentNumber("3");
        calculatorApp.calculate("");
        assertEquals("8.0", calculatorApp.getDisplayFieldText());
    }

    @Test
    public void testSubtraction() {
        calculatorApp.setCurrentNumber("7");
        calculatorApp.calculate("-");
        calculatorApp.setCurrentNumber("3");
        calculatorApp.calculate("");
        assertEquals("4.0", calculatorApp.getDisplayFieldText());
    }

    @Test
    public void testMultiplication() {
        calculatorApp.setCurrentNumber("4");
        calculatorApp.calculate("*");
        calculatorApp.setCurrentNumber("5");
        calculatorApp.calculate("");
        assertEquals("20.0", calculatorApp.getDisplayFieldText());
    }

    @Test
    public void testDivision() {
        calculatorApp.setCurrentNumber("9");
        calculatorApp.calculate("/");
        calculatorApp.setCurrentNumber("3");
        calculatorApp.calculate("");
        assertEquals("3.0", calculatorApp.getDisplayFieldText());
    }

    @Test
    public void testClear() {
        calculatorApp.setCurrentNumber("5");
        calculatorApp.calculate("+");
        calculatorApp.setCurrentNumber("3");
        calculatorApp.clear();
        assertEquals("", calculatorApp.getDisplayFieldText());
    }
}
