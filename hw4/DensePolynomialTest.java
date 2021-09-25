import org.junit.*;
import static org.junit.Assert.*;

public class DensePolynomialTest {
    @Test
    public void isZeroExpectsTrue() {
        int[] expo = new int[]{1, 2, 3};
        double[] coeff = new double[]{0, 0, 0};
        DensePolynomial p = new DensePolynomial(coeff, expo);
        boolean result = p.isZero();
        assertEquals("isZeroExpectsTrue() ", true, result);
    }

    @Test
    public void isZeroExpectsFalse() {
        int[] expo = new int[]{1, 2, 3};
        double[] coeff = new double[]{1, 0, 0};
        DensePolynomial p = new DensePolynomial(coeff, expo);
        boolean result = p.isZero();
        assertEquals("isZeroExpectsFalse() ", false, result);
    }

    @Test
    public void getDegreeZero() {
        DensePolynomial test = new DensePolynomial(new double[]{0}, new int[]{0});
        assertTrue(test.getDegree() == 0);
    }

    @Test
    public void getDegreeTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        assertTrue(test.getDegree() == 4);
    }

    @Test
    public void getDegreeTrueInputReverse() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
        assertTrue(test.getDegree() == 4);
    }


    @Test
    public void getCoeffDoesNotExist() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        assertTrue(test.getCoeff(100) == 0);
    }


    @Test
    public void addTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        DensePolynomial test2 = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        assertEquals(test.add(test2), new DensePolynomial(new double[]{2, 4, 6, 8}, new int[]{1, 2, 3, 4}));
        assertEquals(test, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        assertEquals(test2, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
    }


    @Test
    public void addNegativeTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        DensePolynomial test2 = new DensePolynomial(new double[]{-1, -2, -3, -4}, new int[]{1, 2, 3, 4});
        assertEquals(test.add(test2), new DensePolynomial(new double[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}));
        assertEquals(test, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        assertEquals(test2, new DensePolynomial(new double[]{-1, -2, -3, -4}, new int[]{1, 2, 3, 4}));
    }

    @Test
    public void multTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1}, new int[]{1});
        DensePolynomial test2 = new DensePolynomial(new double[]{1}, new int[]{1});
        assertEquals(test.multiply(test2), new DensePolynomial(new double[]{1}, new int[]{2}));
        assertEquals(test, new DensePolynomial(new double[]{1}, new int[]{1}));
        assertEquals(test2, new DensePolynomial(new double[]{1}, new int[]{1}));
    }

    
    @Test
    public void subTest() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        DensePolynomial test2 = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        assertEquals(test.subtract(test2), new DensePolynomial(new double[]{0}, new int[]{0}));
        assertEquals(test, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        assertEquals(test2, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
    }


    @Test
    public void subNegativeTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        DensePolynomial test2 = new DensePolynomial(new double[]{-1, -2, -3, -4}, new int[]{1, 2, 3, 4});
        assertEquals(test.subtract(test2), new DensePolynomial(new double[]{2, 4, 6, 8}, new int[]{1, 2, 3, 4}));
        assertEquals(test, new DensePolynomial(new double[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        assertEquals(test2, new DensePolynomial(new double[]{-1, -2, -3, -4}, new int[]{1, 2, 3, 4}));
    }

    public void equalsTrue() {
        DensePolynomial test = new DensePolynomial(new double[]{1, 2, 3, 4, 10}, new int[]{1, 2, 3, 4, 4});
        DensePolynomial test2 = new DensePolynomial(new double[]{1, 2, 3, 4, 10}, new int[]{1, 2, 3, 4, 4});
        assertEquals(test, test2);
    }
}