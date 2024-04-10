public class DiscreteMaths {

    public DiscreteMaths() {
    }

    public double sumX(double[] x) {
        double totalX = 0;

        for (int i = 0; i < x.length; i++)
            totalX += x[i];

        return totalX;
    }

    public double sumY(double[] y) {
        double totalY = 0;

        for (int i = 0; i < y.length; i++)
            totalY += y[i];

        return totalY;
    }

    public double sumXY(double[] x, double[] y) {
        double totalXY = 0;

        for (int i = 0; i < x.length; i++)
            totalXY += x[i] * y[i];

        return totalXY;
    }

    public double sumXSquare(double[] x) {
        double totalXSquare = 0;

        for (int i = 0; i < x.length; i++)
            totalXSquare += x[i] * x[i];

        return totalXSquare;
    }

    public double sumXCubic(double[] x) {
        double totalXCubic = 0;

        for (int i = 0; i < x.length; i++)
            totalXCubic += Math.pow(x[i], 3);

        return totalXCubic;
    }

    public double sumXSquareY(double[] x, double[] y) {
        double totalXSquareY = 0;

        for (int i = 0; i< x.length; i++)
            totalXSquareY += x[i] * x[i] * y[i];

        return totalXSquareY;
    }
    public double sumXQuartic(double[] x) {
        double totalXQuartic = 0;

        for (int i = 0; i < x.length; i++)
            totalXQuartic += Math.pow(x[i], 4);

        return totalXQuartic;
    }

}
