class Integrate {
    public interface FofX {
        double eval(double x);
    }

    private enum PointType {
        LEFT_POINT, MID_POINT, RIGHT_POINT;
    };

    static double integrate(FofX f, double a, double b,
        int interval, PointType pointType) {
        double sum = 0;
        double dx = (b-a)/interval;
        for(int i=0; i<interval; i++) {
            switch(pointType) {
                case LEFT_POINT:
                    sum+=f.eval(a+i*dx) * dx;
                    break;
                case MID_POINT:
                    sum+=f.eval(a+i*dx + dx/2) * dx;
                    break;
                case RIGHT_POINT:
                    sum+=f.eval(a+i*dx + dx) * dx;
                    break;
            }
        }
        return sum;
    }

    static double integrate2(FofX f, double a, double b,
        int interval, PointType pointType) {
        double sum=0;
        double d = b-a;
        double xi=0;
        double factor=interval * (interval + 1) / 2;
        for(int i=0; i<interval; i++) {
            double dxi = d*(interval-i)/factor;
            switch(pointType) {
                case LEFT_POINT:
                    sum+=f.eval(xi)*dxi;          // left point
                    break;
                case MID_POINT:
                    sum+=f.eval(xi+dxi)*dxi;      // mid point
                    break;
                case RIGHT_POINT:
                    sum+=f.eval(xi+dxi/2)*dxi;      // right point
                    break;
            }
            xi+=dxi;
        }
        return sum;
    }

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
    }

    public static int findMinIntervalWithNoError(Data data) {
        int i = 0;
        int interval;
        FofX f = data.f;
        int a = data.a;
        int b = data.b;
        PointType pt = data.pt;
        double exactValue = data.exactValue;
        double acceptedError = data.acceptedError;

        // outerloop:
        while (true) {
        // for (int i = 0; i < 10; i ++) {
            // interval = 1000*i;
            interval = 2*i;
            System.out.format("Interval = %d\tyields result\n",
                interval);
            double s = integrate(f, a, b,
                interval, pt);
            double s2 = integrate2(f, a, b,
                interval, pt);

            double[] sumAB = {s, s2};
            System.out.println("******************");
            for (int j = 0; j < sumAB.length; j++) {
                double deltaError = Math.abs(sumAB[j] - exactValue);
                String name = (j == 0) ? "sum1" : "sum2";
                System.out.format("TYPE OF INTEGRATION : %s\n", name);
                System.out.format("∂E = %f\n", deltaError);
                System.out.format("%s = %f\n", name, sumAB[j]);

                interface GetDecimal2PlaceItf {
                    String get2Place(double db);
                }
                GetDecimal2PlaceItf itf = (db) -> {
                    System.out.println(String.valueOf(deltaError).split("\\.")[0]);
                    System.out.println("kkkkkkkkk");
                    String twoPlace =  String.valueOf(deltaError).split("[.]")[1].
                        substring(0, 3);
                    System.out.println(twoPlace);
                    return twoPlace;
                };
                itf.get2Place(deltaError);

                if (deltaError > acceptedError) {
                // del
                // if (deltaError.)
                    System.out.println("Error is too much");
                }else {
                    System.out.println("Accepted the little error");
                    // if (j == 0) {
                    if (j == 1) {
                        return interval;
                        // break outerloop;
                    }
                }
                System.out.println("--------------");
            }
            System.out.println();
            i++;
        }

    }
    public static void main(String args[]) {
        Data dataA = new Data(
            (x) -> x * x,
            0,
            1,
            PointType.MID_POINT,
            1/3d,
            0.001d
        );
        System.out.println(findMinIntervalWithNoError(dataA));
    }
}
