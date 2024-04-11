public class Main {
    public static void main(String[] args) {

        DataSet ds = new DataSet();
        double[] xData = ds.getX();
        double[] yData = ds.getY();

        double newX = 3;

        double[] linearCoefficients = LinearRegression.calculateSimpleLinearRegression(newX);
        double[] quadraticCoefficients = QuadraticRegression.calculateQuadraticRegression(newX);
        double[] cubicCoefficients = CubicRegression.calculateCubicRegression(newX);

        // Obtener los coeficientes de la regresión lineal
        double B0SLR = linearCoefficients[0];
        double B1SLR = linearCoefficients[1];

        // Obtener los coeficientes de la regresión cuadrática
        double B0QLR = quadraticCoefficients[0];
        double B1QLR = quadraticCoefficients[1];
        double B2QLR = quadraticCoefficients[2];

        System.out.println("----------------------------");
        System.out.println("B0SLR: " + B0SLR);
        System.out.println("B1SLR: " + B1SLR);
        System.out.println("----------------------------");
        System.out.println("B0QLR: " + B0QLR);
        System.out.println("B1QLR: " + B1QLR);
        System.out.println("B2QLR: " + B2QLR);
    }
}