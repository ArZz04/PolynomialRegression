public class LinearRegression {

    private double intercept;   // es lo mismo a B0
    private double slope;       // es lo mismo a B1

    public LinearRegression() {
        // Constructor empty
    }

    public void fit(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);

        double sumXY = dm.sumXY(x,y);
        double sumXSquare = dm.sumXSquare(x);

        // Calcular los coeficientes de la regresión lineaL
        slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX); // B1
        intercept = (sumY - slope * sumX) / n; // B0
    }

    public double predict(int x) {
        return  intercept + slope * x;
    }

    public double getSlope() { // Obtener B1
        return slope;
    }

    public double getIntercept() { // Obtener B2
        return intercept;
    }

    public static double[] calculateSimpleLinearRegression(double newXLinear) {
        DataSet ds = new DataSet();
        double[] xData = ds.getX();
        double[] yData = ds.getY();

        // Calcular la regresión lineal simple
        LinearRegression linearRegression = new LinearRegression();
        linearRegression.fit(xData, yData);

        // Obtener los coeficientes de la regresión lineal
        double interceptLinear = linearRegression.getIntercept(); // B0
        double slopeLinear = linearRegression.getSlope(); // B1

        // Predecir el valor de Y para un nuevo valor de X usando regresión lineal
        //double predictedYLinear = linearRegression.predict(newXLinear);

        return new double[] {interceptLinear, slopeLinear}; // BO y B1

    }
}