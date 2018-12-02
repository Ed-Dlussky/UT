package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CheckTriangleTest {
    private Triangle triangle;

    @DataProvider
    public Object[][] triangleOptions(){
        return new Object[][]{
                {1.0, 1.0, 4.0},
                {1.0, 4.0, 1.0},
                {4.0, 1.0, 1.0},
                {2.0, 2.0, 4.0},
                {2.0, 4.0, 2.0},
                {4.0, 2.0, 2.0},
        };
    }

    @Test(dataProvider = "triangleOptions")
    public void negativeTriangleInequalityTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        assertFalse(triangle.checkTriangle());
    }

    @Test
    public void negativeTriangleZeroATest(){
        triangle = new Triangle(0.0, 4.0, 6.0);
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), "a<=0");
        assertFalse(triangle.checkTriangle());
    }
    @Test
    public void negativeTriangleZeroBTest(){
        triangle = new Triangle(4.0, 0.0, 6.0);
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), "b<=0");
        assertFalse(triangle.checkTriangle());
    }
    @Test
    public void negativeTriangleZeroCTest(){
        triangle = new Triangle(4.0, 6.0, 0.0);
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), "c<=0");
        assertFalse(triangle.checkTriangle());
    }

    @Test
    public void positiveTriangleTest(){
        triangle = new Triangle(4.0, 6.0, 8.0);
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), "");
        assertTrue(triangle.checkTriangle());
    }

}
