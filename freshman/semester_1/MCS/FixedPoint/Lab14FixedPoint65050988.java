class Lab14FixedPoint65050988 {

    static class MyFixedPoint {
        public int data;
        public static final float diviser = 1000.0f;

        MyFixedPoint(float data) {
            this.data = (int)(data * diviser);
        }
        float getReal() {
            // return data;
            return data / diviser;
        }
        void adds(MyFixedPoint b) {
            // data = 1234 + 3421;
            data += b.data;
        }

        void subtracts(MyFixedPoint b) {
            data -= b.data;
        }
        void multiplies(MyFixedPoint b) {
            // data *= (int)(b.data / diviser);
            // data = data * (int)(b.data / diviser);
            // data = data * (int)(b.data);
            // data *= b.data;
            data *= b.data / diviser;
        }
        void divides(MyFixedPoint b) {
            // data /= (int)(b.data / diviser);
            // data /= (int)(b.data / diviser);
            data /= (b.data / diviser);
        }
        public String toString() {
            String ret = "FXP";
            System.out.println(ret);
            float real = getReal();
            System.out.println(real);
            return ret;
        }
    }

    static class MyFloatingPoint {
        public float data;

        MyFloatingPoint(float data) {
            this.data = data;
        }
        float getReal() {
            return data;
        }

        void adds(MyFloatingPoint b) {
            data = data + b.data;
            // data = 1.234f + 3.421f;
        }

        void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }

        void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }

        void divides(MyFloatingPoint b) {
            data = data / b.data;
        }

        public String toString() {
            String ret = "FLP";
            System.out.println(ret);
            float real = getReal();
            System.out.println(real);
            return ret;
        }
    }

    public static void main(String[] args) {
        final float initVal = 0.555f;
        final float testVal = 1.533f;
        MyFixedPoint fxp1 =  new MyFixedPoint(initVal);
        MyFixedPoint fxp2 =  new MyFixedPoint(testVal);

        MyFloatingPoint flp1 = new MyFloatingPoint(initVal);
        MyFloatingPoint flp2 = new MyFloatingPoint(testVal);

        long initT;
        long termT;
        long elapsedT;


        initT = System.nanoTime();
        fxp1.adds(fxp2);
        // fxp1.subtracts(fxp2);
        // fxp1.multiplies(fxp2);
        // fxp1.divides(fxp2);
        // fxp1.getReal();
        fxp1.toString();
        termT = System.nanoTime();
        elapsedT =  termT - initT;
        System.out.println("Elapsed Time : " + elapsedT);



        initT = System.nanoTime();
        flp1.adds(flp2);
        // flp1.subtracts(flp2);
        // flp1.multiplies(flp2);
        // flp1.divides(flp2);
        // fxp1.getReal();
        flp1.toString();
        termT = System.nanoTime();
        elapsedT = termT - initT;
        System.out.println("Elapsed Time : " + elapsedT);
    }
}
