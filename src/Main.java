public class Main {
    public static void main(String[] args) {

        DataSet ds = new DataSet();
        double[] xData = ds.getX();
        double[] yData = ds.getY();

        Regressions regressions = new Regressions();
        regressions.fitSimple(xData, yData);
        regressions.fitCuadratic(xData, yData);

        double slopeLinear = regressions.getSlope();
        double interceptLinear = regressions.getIntercept();

        double a = regressions.getA();  // Assuming you add a getA() method in Regressions
        double b = regressions.getB();  // Assuming you add a getB() method in Regressions
        double c = regressions.getC();  // Assuming you add a getC() method in Regressions
        System.out.println("Quadratic regression:");
        System.out.println("  Coefficient A: " + a);
        System.out.println("  Coefficient B: " + b);
        System.out.println("  Coefficient C: " + c);

        System.out.println("Linear regression:");
        System.out.println("  Slope: " + slopeLinear);
        System.out.println("  Intercept: " + interceptLinear);

    }
}