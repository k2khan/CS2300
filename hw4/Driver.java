public class Driver {
    public static void main(String[] args) {
    DensePolynomial test = new DensePolynomial(new double[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3});
    System.out.println(test.getCoeff(1));

    }
}
