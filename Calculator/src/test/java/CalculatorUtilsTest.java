package test.java;

import main.java.calculator.utils.CalculatorUtils;
import org.junit.Assert;
import org.junit.Test;

class CalculatorUtilsTest {

    @Test
    void TC0001() {
        double result = CalculatorUtils.calculate("2+2");
        Assert.assertEquals(4, result, 0);
    }

    @Test
    void TC0002() {
        double result = CalculatorUtils.calculate("0,2;?фt");
        Assert.assertEquals("Вы ввели неизвестный(ые) символ(ы)", result, 0);
    }

    @Test
    void TC0003() {
        double result = CalculatorUtils.calculate("2-5+sqrt(7+2)-(9*4)+3*2+3/3-10+23*2+pow(2)");
        Assert.assertEquals("Вы ввели слишком большое количество символов", result, 0);
    }

    @Test
    void TC0004() {
        double result = CalculatorUtils.calculate("0.3");
        Assert.assertEquals(0.3, result, 0);
    }

    @Test
    void TC00051() {
        double result = CalculatorUtils.calculate("134+22");
        Assert.assertEquals(154, result, 0);
    }

    @Test
    void TC00052() {
        double result = CalculatorUtils.calculate("(-22)+(-12)");
        Assert.assertEquals(-34, result, 0);
    }

    @Test
    void TC00053() {
        double result = CalculatorUtils.calculate("3.2+21.7");
        Assert.assertEquals(24.9, result, 0);
    }

    @Test
    void TC00054() {
        double result = CalculatorUtils.calculate("(-0.6)+(-2.7)");
        Assert.assertEquals(-3.3, result, 0);
    }

    @Test
    void TC00055() {
        double result = CalculatorUtils.calculate("243+1.4");
        Assert.assertEquals(234.4, result, 0);
    }

    @Test
    void TC00056() {
        double result = CalculatorUtils.calculate("(-25)+(-5.2)");
        Assert.assertEquals(-30.2, result, 0);
    }

    @Test
    void TC00057() {
        double result = CalculatorUtils.calculate("12+(-1.2)");
        Assert.assertEquals(10.8, result, 0);
    }

    @Test
    void TC00058() {
        double result = CalculatorUtils.calculate("0.7+(-36)");
        Assert.assertEquals(-35.3, result, 0);
    }

    @Test
    void TC00059() {
        double result = CalculatorUtils.calculate("(-23.6)+34");
        Assert.assertEquals(10.4, result, 0);
    }

    @Test
    void TC000510() {
        double result = CalculatorUtils.calculate("(-72)+0.7");
        Assert.assertEquals(-71.3, result, 0);
    }

    @Test
    void TC00061() {
        double result = CalculatorUtils.calculate("11-14");
        Assert.assertEquals(-3, result, 0);
    }

    @Test
    void TC00062() {
        double result = CalculatorUtils.calculate("(-2)-(-4)");
        Assert.assertEquals(2, result, 0);
    }

    @Test
    void TC00063() {
        double result = CalculatorUtils.calculate("1834.3-22.2");
        Assert.assertEquals(1812.1, result, 0);
    }

    @Test
    void TC00064() {
        double result = CalculatorUtils.calculate("(-57.4)-(-14.1)");
        Assert.assertEquals(-43.3, result, 0);
    }

    @Test
    void TC00065() {
        double result = CalculatorUtils.calculate("55-0.9");
        Assert.assertEquals(54.1, result, 0);
    }

    @Test
    void TC00066() {
        double result = CalculatorUtils.calculate("(-8)-(-9.3)");
        Assert.assertEquals(1.3, result, 0);
    }

    @Test
    void TC00067() {
        double result = CalculatorUtils.calculate("66-(-7.1)");
        Assert.assertEquals(73.1, result, 0);
    }

    @Test
    void TC00068() {
        double result = CalculatorUtils.calculate("(-29)-0.3");
        Assert.assertEquals(-29.3, result, 0);
    }

    @Test
    void TC00069() {
        double result = CalculatorUtils.calculate(" 5.7-(-36)");
        Assert.assertEquals(41.7, result, 0);
    }

    @Test
    void TC000610() {
        double result = CalculatorUtils.calculate("(-18.2)-2");
        Assert.assertEquals(-20.2, result, 0);
    }

    @Test
    void TC00071() {
        double result = CalculatorUtils.calculate("4*2");
        Assert.assertEquals(8, result, 0);
    }

    @Test
    void TC00072() {
        double result = CalculatorUtils.calculate("(-3)*(-6)");
        Assert.assertEquals(18, result, 0);
    }

    @Test
    void TC00073() {
        double result = CalculatorUtils.calculate("0.2*0.4");
        Assert.assertEquals(0.08, result, 0);
    }

    @Test
    void TC00074() {
        double result = CalculatorUtils.calculate("(-1.6)*(-7.1)");
        Assert.assertEquals(11.36, result, 0);
    }

    @Test
    void TC00075() {
        double result = CalculatorUtils.calculate("11*0.3");
        Assert.assertEquals(3.3, result, 0);
    }

    @Test
    void TC00076() {
        double result = CalculatorUtils.calculate("(-12)*(-8.2)");
        Assert.assertEquals(98.4, result, 0);
    }

    @Test
    void TC00077() {
        double result = CalculatorUtils.calculate("34*(-4.6)");
        Assert.assertEquals(-156.4, result, 0);
    }

    @Test
    void TC00078() {
        double result = CalculatorUtils.calculate("(-3)*0.2");
        Assert.assertEquals(-0.6, result, 0);
    }

    @Test
    void TC00079() {
        double result = CalculatorUtils.calculate("0.1*(-16)");
        Assert.assertEquals(-1.6, result, 0);
    }

    @Test
    void TC000710() {
        double result = CalculatorUtils.calculate("(-2.4)*4");
        Assert.assertEquals(-9.6, result, 0);
    }

    @Test
    void TC00081() {
        double result = CalculatorUtils.calculate("6/4");
        Assert.assertEquals(1.5, result, 0);
    }

    @Test
    void TC00082() {
        double result = CalculatorUtils.calculate("(-3)/(-8)");
        Assert.assertEquals(0.375, result, 0);
    }

    @Test
    void TC00083() {
        double result = CalculatorUtils.calculate("0.3/0.4");
        Assert.assertEquals(0.75, result, 0);
    }

    @Test
    void TC00084() {
        double result = CalculatorUtils.calculate("(-6.3)/(-2.44)");
        Assert.assertEquals(2.58197, result, 0);
    }

    @Test
    void TC00085() {
        double result = CalculatorUtils.calculate("11/0,5");
        Assert.assertEquals(22, result, 0);
    }

    @Test
    void TC00086() {
        double result = CalculatorUtils.calculate("(-16)/(-5,5)");
        Assert.assertEquals(2.90909, result, 0);
    }

    @Test
    void TC00087() {
        double result = CalculatorUtils.calculate("34/(-2.3)");
        Assert.assertEquals(14.78261, result, 0);
    }

    @Test
    void TC00088() {
        double result = CalculatorUtils.calculate("(-323)/2.55 ");
        Assert.assertEquals(126.66667, result, 0);
    }

    @Test
    void TC00089() {
        double result = CalculatorUtils.calculate("4.6/(-2)");
        Assert.assertEquals(-2.3, result, 0);
    }

    @Test
    void TC000810() {
        double result = CalculatorUtils.calculate("(-2.1)/1");
        Assert.assertEquals(-2.1, result, 0);
    }

    @Test
    void TC00091() {
        double result = CalculatorUtils.calculate("pow(6)");
        Assert.assertEquals(36, result, 0);
    }

    @Test
    void TC00092() {
        double result = CalculatorUtils.calculate("pow(-19)");
        Assert.assertEquals(361, result, 0);
    }

    @Test
    void TC00093() {
        double result = CalculatorUtils.calculate("pow(1.97)");
        Assert.assertEquals(3.8809, result, 0);
    }

    @Test
    void TC00094() {
        double result = CalculatorUtils.calculate("pow(-34.8)");
        Assert.assertEquals(1211.04, result, 0);
    }

    @Test
    void TC000101() {
        double result = CalculatorUtils.calculate("sqrt(9)");
        Assert.assertEquals(3, result, 0);
    }

    @Test
    void TC000102() {
        double result = CalculatorUtils.calculate("sqrt(-21)");
        Assert.assertEquals("Извлечение квадратного корня из отрицательного числа не возможно", result, 0);
    }

    @Test
    void TC000103() {
        double result = CalculatorUtils.calculate("sqrt(0.66)");
        Assert.assertEquals(0.8124, result, 0);
    }

    @Test
    void TC000104() {
        double result = CalculatorUtils.calculate("sqrt(-356.582)");
        Assert.assertEquals("Извлечение квадратного корня из отрицательного числа не возможно", result, 0);
    }

    @Test
    void TC00011() {
        double result = CalculatorUtils.calculate("35/0");
        Assert.assertEquals("Деление на ноль невозможно", result, 0);
    }

    @Test
    void TC00012() {
        double result = CalculatorUtils.calculate("34++1");
        Assert.assertEquals("Ошибка ввода", result, 0);
    }

    @Test
    void TC00013() {
        double result = CalculatorUtils.calculate("1/3");
        Assert.assertEquals(0.33334, result, 0);
    }

    @Test
    void TC00014() {
        double result = CalculatorUtils.calculate("64+(34-2)*3");
        Assert.assertEquals(-32, result, 0);
    }

//    @Test
//    void TC00015() {
//        double result = CalculatorUtils.calculate("");
//        Assert.assertEquals(, result, 0);
//    }

    @Test
    void TC00016() {
        double result = CalculatorUtils.calculate("-3+4");
        Assert.assertEquals("Ошибка ввода", result, 0);
    }

//    @Test
//    void TC00017() {
//        double result = CalculatorUtils.calculate("");
//        Assert.assertEquals(, result, 0);
//    }

    @Test
    void TC00018() {
        double result = CalculatorUtils.calculate("24+((32-2)");
        Assert.assertEquals("Ошибка ввода", result, 0);
    }

    @Test
    void TC00019() {
        long timeStart = System.currentTimeMillis();
        double result = CalculatorUtils.calculate("1/3+4,636*34+pow(42)-sqrt(583)");
        long timeEnd = System.currentTimeMillis();
        Assert.assertTrue(timeEnd - timeStart < 300);
    }
}