public class Regressions {

    private double intercept;   // Intersección (B0) para la regresión lineal simple
    private double slope;       // Pendiente (B1) para la regresión lineal simple

    private double a; // Coeficiente cuadrático (A) para la regresión cuadrática
    private double b; // Coeficiente lineal (B) para la regresión cuadrática
    private double c; // Término independiente (C) para la regresión cuadrática

    private double aCubic; // Coeficiente cúbico (A) para la regresión cúbica
    private double bCubic; // Coeficiente cuadrático (B) para la regresión cúbica
    private double cCubic; // Coeficiente lineal (C) para la regresión cúbica
    private double dCubic; // Término independiente (D) para la regresión cúbica


    public double getSlope() { // Obtener B1
        return slope;
    }

    public double getIntercept() { // Obtener B2
        return intercept;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


    public double getACubic() {
        return aCubic;
    }

    public double getBCubic() {
        return bCubic;
    }

    public double getCCubic() {
        return cCubic;
    }

    public double getDCubic() {
        return dCubic;

    public void fitSimple(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumXSquare = dm.sumXSquare(x);

        // Calcular los coeficientes de la regresión lineal
        slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX); // B1
        intercept = (sumY - slope * sumX) / n; // B0
    }

    public void fitCuadratic(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumXSquare = dm.sumXSquare(x);
        double sumXSquareY = dm.sumXSquareY(x, y);

        // Calcular los coeficientes de la regresión cuadrática
        double deno = n * sumXSquare - sumX * sumX;
        a = (sumXSquareY * sumX - sumXY * sumXSquare) / deno;
        b = (n * sumXY - sumX * sumY) / deno;
        c = (sumY * sumXSquare - sumX * sumXSquareY) / deno;

    }

    public void fitCubic(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        // Calculate sums of powers of x
        double sumX3 = dm.sumXCube(x);
        double sumX2 = dm.sumXSquare(x);
        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumX2Y = dm.sumXSquareY(x, y);

        // Calculate cubic regression coefficients
        aCubic = (sumX2Y * sumX - sumXY * sumX2) / (n * sumX3 - sumX * sumX2);
        bCubic = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        cCubic = (sumY * sumX2 - sumX * sumX2Y) / (n * sumX - sumX * sumX);
        dCubic = sumY / n;
    }
}