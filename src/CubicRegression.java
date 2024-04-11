public class CubicRegression {

    private double a; // es lo mismo a B2
    private double b; // es lo mismo a B1
    private double c; // es lo mismo a B0
    private double d; // es lo mismo a B3
    //private double varR; // es el margen de error aproximado

    public CubicRegression() {
        // Constructor empty
    }

    public void fit(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        // Variables Assigner
        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumXSquare = dm.sumXSquare(x);
        double sumXSquareY = dm.sumXSquareY(x, y);
        double sumXCube = dm.sumXCubic(x);
        double sumXQuartic = dm.sumXQuartic(x);

        // Variables Reassigner
        double newSumXX = (sumXSquare) - (Math.pow(sumX,2)/n);
        double newSumXY = (sumXY) - ((sumX*sumY)/n);
        double newSumXXSquare = (sumXCube) - ((sumXSquare*sumX)/n);
        double newSumXSquareY = (sumXSquareY) - ((sumXSquare*sumY)/n);
        double newSumXSquareXSquare = (sumXQuartic) - ((Math.pow(sumXSquare, 2))/n);

        double den = (newSumXX * newSumXSquareXSquare) - Math.pow(newSumXXSquare, 2);

        a = ( (newSumXSquareY * newSumXX) - (newSumXY * newSumXXSquare) ) / ( den ) ;
        b = ( (newSumXY * newSumXSquareXSquare) - (newSumXSquareY * newSumXXSquare) ) / ( den ) ;
        c = ( sumY - (b * sumX) - (a * sumXSquare) ) /n;

        double rSSE = (sumY - (a* sumXSquare) - (b*sumX - c));
        double rSST = Math.pow((sumY - (sumY / n)), 2);

        //varR = ( 1 - (rSSE/rSST) );
    }

    public double predict(double x) {
        return (a + (b * x) + (c * Math.pow(x, 2) + (d * Math.pow(x, 3) ));
    }
    //y = a + bx + cx2 + dx3

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    /*
    public double getR() {
            return varR;
    }
    */

    public static double[] calculateCubicRegression(double newXCubic) {
        DataSet ds = new DataSet();
        double[] xData = ds.getX();
        double[] yData = ds.getY();

        // Calcular la regresión cuadrática
        CubicRegression quadraticRegression = new CubicRegression();
        quadraticRegression.fit(xData, yData);

        // Obtener los coeficientes de la regresión cuadrática
        double aQuadratic = quadraticRegression.getA();
        double bQuadratic = quadraticRegression.getB();
        double cQuadratic = quadraticRegression.getC();
        //double R = quadraticRegression.getR();

        // Predecir el valor de Y para un nuevo valor de X usando regresión cuadrática
        //double predictedYQuadratic = quadraticRegression.predict(newXQuadratic);

        // Devolver los coeficientes de la regresión cuadrática
        return new double[] {aQuadratic, bQuadratic, cQuadratic}; // B2, B1 y B0
    }
}
