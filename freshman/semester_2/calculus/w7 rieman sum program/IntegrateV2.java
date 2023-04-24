class IntegrateV2 {
    static class Data {
        FofX f;
        int a;
        int b;
        // int interval;
        PointType pt;
        double exactValue;
        @Override
        public String toString() {
            return "Data [f=" + f + ", a=" + a + ", b=" + b + ", pt=" + pt + ", exactValue=" + exactValue
                    + ", acceptedError=" + acceptedError + "]";
        }
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
        // System.out.println(data.toString());
        // System.out.println("data.b = " + data.b);
        // System.out.println("data.a = " + data.a);
        double dx = (data.b - data.a) / (double)interval;
        System.out.println("DX = " + dx);
        for(int i=0; i<interval; i++) {
            switch(data.pt) {
                case LEFT_POINT:
                    sum+=data.f.eval(data.a +i*dx) * dx;
                    // System.out.println("little sum = " + sum);
                    break;
                case MID_POINT:
                    sum+=data.f.eval(data.a +i*dx + dx/2) * dx;
                    break;
                case RIGHT_POINT:
                    sum+=data.f.eval(data.a + i*dx + dx) * dx;
                    break;
            }
        }
        // System.out.println("Sum from integrate 1 = " + sum);
        return sum;
    }

    // static double integrate2(FofX f, double a, double b,
    //     int interval, PointType pointType) {
    // static double integrate2(Data data, int interval) {
    static double integrate2(Data data, int interval) {
        // double interval = (double)interval;
        double sum=0;
        double d = data.b - data.a;
        double xi=0;
        double factor=interval * (interval + 1) / 2;
        for(int i=0; i<interval; i++) {
            double dxi = d*(interval-i)/factor;
            // System.out.println("dxi = " + dxi);
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
        System.out.println("Sum final = " + sum);
        return sum;
    }


    public static int findMinIntervalWithNoError(Data data) {
        int i = 1;
        int interval = 1;

        // outerloop:
        while (true) {
            // interval = 1000*i;
            interval = 2*i;
            // interval++;
            double s = integrate(data, interval);
            double s2 = integrate2(data, interval);

            double[] sumAB = {s, s2};
            System.out.format("interval = %d\n", interval);
            System.out.println("******************");
            for (int j = 0; j < sumAB.length; j++) {
                // if (j == 0) continue;
                double deltaError = Math.abs(sumAB[j] - data.exactValue);
                String name = (j == 0) ? "sum1" : "sum2";
                System.out.format("TYPE OF INTEGRATION : %s\n", name);
                System.out.format("∂E = %f\n", deltaError);
                System.out.format("%s = %f\n", name, sumAB[j]);

                if (deltaError > data.acceptedError) {
                    System.out.println("Error is too much");
                }else {
                    System.out.println("Accepted the little error");
                    if (j == 0) {
                    // if (j == 1) {
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
            // (x) -> x * x * x * x,
            (x) -> x * x,
            0,
            1,
            PointType.LEFT_POINT,
            // PointType.MID_POINT,
            // PointType.RIGHT_POINT,
            1/3d,
            // 1/5d,
            0.001d
        );
        System.out.println(findMinIntervalWithNoError(dataA));
    }
}
