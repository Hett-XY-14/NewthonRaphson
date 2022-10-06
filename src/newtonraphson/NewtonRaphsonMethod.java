/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newtonraphson;

/**
 *
 * @author Hoeco
 */
public class NewtonRaphsonMethod {
    /**
     * @param args the command line arguments
     */
    
    int[] f;
    int[] df;
    double[] roots;
    double x0;
    double x1;
    int i;
    double error;
    
    public NewtonRaphsonMethod(int[] equationCoefficients, double initialPoint, double error) {
        this.f = equationCoefficients;
        this.df = derivatePolynomial(this.f);
        this.x0 = initialPoint;
        this.x1 = 0;
        this.error = error;
    }
    
    public double findRoot() {
        double e = 10;
        while (e > error) {
            x1 = x0 - (evaluateEquation(f, x0)/evaluateEquation(df, x0));
            e = Math.abs(x1 - x0);
            x0 = x1;
        }
        return x1;
    }
    
    public double evaluateEquation(int[] function, double abscissa) {
        double result = 0;
        for (int i=0; i<function.length; i+=1) {
            int exponent = function.length -1 -i;
            result += function[i] * (Math.pow(abscissa, exponent));
        }
        return result;
    }
    
    public int[] derivatePolynomial(int[] polynomial) {
    /*
     *(La derivada de xn es el resultado de multiplicar el exponente n (polynomialLength-i) por la base x (polynomial[i]) elevado a n – 1 (o sea posicionarlo un lugar a la derecha)).
     */   
        int polynomialLength = polynomial.length;
        // new array with the coefficients of the derivative for the original function
        int[] resultEquation = new int[polynomialLength-1];
        // this for takes the coefficients of the original functions and multiplies them by its exponent
        // (the place where they are stored, that is polynomialLength-i) then stores it one place to the right 
        // meaning its exponent is one less than the original
        for(int i=0; i<polynomialLength-1; i+=1) {
            resultEquation[i] = polynomial[i] * (polynomialLength-1-i);
        }
        return resultEquation;
    }
} 
