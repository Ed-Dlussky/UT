package triangle;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTest {
    private Triangle triangle;


    @Test
    public void squareCalcTest(){
        triangle = new Triangle(3.0,4.0,5.0);
        Assert.assertEquals(triangle.getSquare(),6.0);
    }

    @Test
    public void squareCalcNegativeTest(){
        triangle = new Triangle(-20.0,4.0,6.0);
        Assert.assertEquals(triangle.getSquare(), "can't calculate square for false triangle",
                "need to checkTriangle() first, if true -- calculate square");
    }

}
