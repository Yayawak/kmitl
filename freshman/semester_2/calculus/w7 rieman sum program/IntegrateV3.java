import java.util.List;

class IntegrateV3 {
    static class Data {
        FofX f;
        int a;
        int b;
        // int interval;
        PointType pt;
        double exactValue;
        double acceptedError;
        public Data(FofX f, int a, int b,
        // int interval,
            PointType pt, double exactValue, double acceptedError) {
            this.f = f;
            this.a = a;
            this.b = b;
            // this.interval = interval;
            this.pt = pt;
            this.exactValue = exactValue;
            this.acceptedError = acceptedError;
        }
        @Override
        public String toString() {
            return "Data [f=" + f + ", a=" + a + ", b=" + b + ", pt=" + pt + ", exactValue=" + exactValue
                    + ", acceptedError=" + acceptedError + "]";
        }
    }
    public interface FofX {
        double eval(double x);
    }

    private enum PointType {
        LEFT_POINT, MID_POINT, RIGHT_POINT;
    };

    static double integrate(Data data, int interval) {
    // static double integrate(FofX f, double a, double b,
    //     int interval, PointType pointType) {
        double sum = 0;
        double dx = (data.b - data.a) / (double)interval;
        for(int i=0; i<interval; i++) {
            switch(data.pt) {
                case LEFT_POINT:
                    sum+=data.f.eval(data.a +i*dx) * dx;
                    break;
                case MID_POINT:
                    sum+=data.f.eval(data.a +i*dx + dx/2) * dx;
                    break;
                case RIGHT_POINT:
                    sum+=data.f.eval(data.a + i*dx + dx) * dx;
                    break;
            }
        }
        return sum;
    }

    // static double integrate2(FofX f, double a, double b,
    //     int interval, PointType pointType) {
    static double integrate2(Data data, int interval) {
        double sum=0;
        double d = data.b - data.a;
        double xi=0;
        double factor=interval * (interval + 1) / 2;
        for(int i=0; i<interval; i++) {
            double dxi = d*(interval-i)/factor;
            switch(data.pt) {
                case LEFT_POINT:
                    sum+=data.f.eval(xi)*dxi;
                    break;
                case MID_POINT:
                    sum+=data.f.eval(xi+dxi/2)*dxi;
                    break;
                case RIGHT_POINT:
                    sum+=data.f.eval(xi+dxi)*dxi;
                    break;
            }
            xi+=dxi;
        }
        return sum;
    }


    public static int findMinIntervalWithNoError(Data data,
        int integrationType
    ) {
        int interval = 1;

        while (true) {
            // interval = 1000*i;
            // interval = 2*i;
            interval++;
            // System.out.println(interval);
            double s = integrate(data, interval);
            double s2 = integrate2(data, interval);
            double[] sumAB = {s, s2};
            // System.out.println(sumAB[integrationType]);
            double deltaError = Math.abs(sumAB[integrationType] - data.exactValue);
            // System.out.format("∂E = %f\n", deltaError);

            if (deltaError > data.acceptedError) {
            }else {
                return interval;
            }
        }
    }
    public static void main(String args[]) {
        printTable();
    }

    public static void printTable() {
        FofX[] fns = {x -> x*x, x -> x*x*x*x};
        double[] exactValues = {1/3d, 1/5d};
        PointType[] pts = {PointType.LEFT_POINT, PointType.MID_POINT,
            PointType.RIGHT_POINT
        };

        System.out.format("%-14s", "");
        List.of(pts).stream().forEach(pt -> {
            System.out.format("%-14s", pt.name());
        });
        System.out.println();
        for (int i = 0; i < fns.length; i++) {
            System.out.format("fn %-14d", i);
            for (int j = 0; j < pts.length; j++) {
                Data data = new Data(
                    fns[i], 0, 1,
                    pts[j],
                    exactValues[i],
                    0.001d
                );
                // System.out.println("With data = ...");
                // System.out.println(data.toString());
                // System.out.println("End point = " + data.pt.name());
                // System.out.print("Minimum interval = ");
                // System.out.println(findMinIntervalWithNoError(data));
                // System.out.println();

                // System.out.print(findMinIntervalWithNoError(data) + "\t");
                // System.out.format("%-4d,%-7d",
                System.out.format("%d,%-7d",
                    findMinIntervalWithNoError(data, 0),
                    findMinIntervalWithNoError(data, 1)
                );
            }
            // System.out.println("==============================\n");
            System.out.println();
        }
    }
}
