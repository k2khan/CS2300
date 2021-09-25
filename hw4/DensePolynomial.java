import java.util.*;

public class DensePolynomial extends Polynomial {
   /**
    * Constructs a polynomial with the given coffeficients in front of the given exponents
    * The lengths of coefficients and exponents arrays are expected to be the same.
    * If not, the constructor should throw an IllegalArgumentException.
    * The values of coefficients array are the coefficients that correspond to the values in the exponents array.
    * For example, to construct a polynomial 5x1000+3, the coefficeints would be [5,3] and exponents would be [1000,0].
   */

   protected double coeff[];
   protected int expo[];

   public DensePolynomial() {

   }

   public DensePolynomial(double coefficients[], int exponents[]) {
      this.coeff = coefficients;
      this.expo = exponents;
   }

   public int getDegree() {
      int max = this.expo[0];
      for (int i = 0; i < this.expo.length; i++) {
         if (this.expo[i] > max) {
            max = this.expo[i];
         }
      }
      if (max > 0) {
         return max;
      } else {
         return 0;
      }
   }

   public double getCoeff(int d) {
      if (Arrays.asList(this.expo).contains(d)) { //Checks to see if the term exists
         double temp = this.coeff[Arrays.asList(this.expo).indexOf(d)];
         return temp;
      } else {
         return 0;
      }
   }

   public boolean isZero() {
      for (int i = 0; i < this.coeff.length ; i++) {
         if (this.coeff[i] != 0) {
            return false;
         }
      }
      return true;
   }


   public Polynomial add(Polynomial q) {
      if (this.isZero()) {
         return q;
      } else if (q.isZero()) {
         return this;
      } else {
         int size = q.getDegree();
         double[] resultingCoeffs = new double[size];
         
         for (int i = 0; i < size; i++) {
            resultingCoeffs[i] = q.getCoeff(i); //Populate coeffs with q's
         }

         for (int j = 0; j < size; j++) {
            if (Arrays.asList(this.expo).contains(j)) {
               resultingCoeffs[j] += this.coeff[Arrays.asList(this.expo).indexOf(j)]; //Populate coeffs with this
            }
         }
         Polynomial result = new DensePolynomial(resultingCoeffs, this.expo);
         return result;
      }
   }

   public Polynomial multiply(Polynomial q) {
      if (q.isZero() || this.isZero()) {
         int size = q.getDegree();
         Polynomial p = new DensePolynomial(new double [size], new int[size]);
         return p;
      }
      int size = q.getDegree() + this.getDegree();
      double[] resultingCoeffs = new double[size];
      int[] resultingExpos = new int[size];
      for (int i = 0; i < q.getDegree(); i++) {
         for (int j = 0; j < this.getDegree(); j++) {
            resultingCoeffs[i+j] = q.getCoeff(i) * this.coeff[Arrays.asList(this.expo).indexOf(j)];
            resultingExpos[i+j] = this.expo[i] + this.expo[j];
         }
      }
      Polynomial resultingPolynomial = new DensePolynomial(resultingCoeffs, resultingExpos);
      return resultingPolynomial;

   }

   public Polynomial subtract(Polynomial q) {
      if (this.isZero()) {
         return q;
      } else if (q.isZero()) {
         return this;
      } else {
         int size = q.getDegree();
         double[] resultingCoeffs = new double[size];

         for (int j = 0; j < size; j++) {
            if (Arrays.asList(this.expo).contains(j)) {
               resultingCoeffs[j] = this.coeff[Arrays.asList(this.expo).indexOf(j)]; //Populate coeffs with this
            }
         }     

         for (int i = 0; i < size; i++) {
            resultingCoeffs[i] -= q.getCoeff(i); //Populate coeffs with q's
         }

         Polynomial result = new DensePolynomial(resultingCoeffs, this.expo);
         return result;
      }
   }

   @Override
   public Polynomial minus() {
      int size = this.getDegree();
      double[] resultingCoeffs = new double[size];
      for (int i = 0; i < size; i++) {
         resultingCoeffs[i] = -this.coeff[i];
      }
      DensePolynomial resultingPolynomial = new DensePolynomial(coeff, expo);
      return resultingPolynomial;
   }

   public boolean equals(Object o) {
       DensePolynomial denseP = (DensePolynomial)o;
       if (o == denseP) {
          return true;
       }
       return false;
   }

   public String toString() {
      StringBuilder str = new StringBuilder();
      Map<Integer, Double> map = new TreeMap<>();
      for(int i = 0 ; i < this.coeff.length; i++){
        if (this.coeff[i] == 0) {
          continue;
        }
         map.put(this.expo[i], this.coeff[i]);
      }
      for (Map.Entry<Integer, Double> entry: map.entrySet()) {
         str.append(entry.getValue() + "x" + "^" + entry.getKey() + " + ");
      }
      str.deleteCharAt(str.lastIndexOf("+"));
      return str.toString(); 


   }
}
