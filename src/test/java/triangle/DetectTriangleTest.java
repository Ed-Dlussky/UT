package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectTriangleTest {
    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ISOSCELES_EQUILATERAL = 3;   // равнобедренный + равносторонний
    final int TR_ORDINARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный
    final int TR_ISOSCELES_RECTANGULAR = 10;   // равнобедренный + прямоугольный

    private Triangle triangle;

    @DataProvider
    public Object[][] rectangularOptions(){
        return new Object[][]{
                {3.0, 4.0, 5.0},
                {4.0, 5.0, 3.0},
                {5.0, 3.0, 4.0},
        };
    }
    @DataProvider
    public Object[][] isoscelesOptions(){
        return new Object[][]{
                {4.0, 4.0, 5.0},
                {5.0, 4.0, 4.0},
                {4.0, 4.0, 5.0},
        };
    }
    @DataProvider
    public Object[][] isoscelesRectangularOptions(){
        return new Object[][]{
                {1.0, 1.0, Math.sqrt(2)},
                {Math.sqrt(2), 1.0, 1.0},
                {1.0, 1.0, Math.sqrt(2)},
        };
    }

    @Test(dataProvider = "rectangularOptions")
    public void defineRectangularTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_RECTANGULAR);
    }

    @Test(dataProvider = "isoscelesOptions")
    public void defineIsoscelesTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES);
    }

    @Test(dataProvider = "isoscelesRectangularOptions", groups = {"comb"})
    public void defineIsoscelesRectangularTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES_RECTANGULAR);
    }

    @Test(groups = {"comb"})
    public void defineEquilateralTest(){
        triangle = new Triangle(3.0,3.0,3.0);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES_EQUILATERAL);
    }

    @Test
    public void defineOrdinaryTest(){
        triangle = new Triangle(6.0,3.0,5.0);
        Assert.assertEquals(triangle.detectTriangle(), TR_ORDINARY);
    }

    @Test
    public void defineTriangleNegativeTest(){
        triangle = new Triangle(-5.0,2.0,1.0);
        Assert.assertEquals(triangle.detectTriangle(), "triangle cannot be detected");
    }


}
