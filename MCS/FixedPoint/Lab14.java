class Lab14 {

    // abstract class MyXXPoint<T> {
    abstract class MyXXPoint {
        // public int data;
        public float data;
        // private float data;
        // private T data;
        // public abstract int getData();
        // public abstract T getData() {
        public float getData() {
            return this.data;
        }
        // public abstract float getData();
        // abstract MyXXPoint() {};
        // abstract MyXXPoint();
        // public abstract MyXXPoint(MyXXPoint b);
        // public abstract void MyXXPoint();
        // public MyXXPoint(MyXXPoint b) {
        //     this.data = b.data;
        // }
        // public static final float data = 0;
        // interface MyXXPoint {
    // interface MyXXPoint {
        // public int data = 0;
        // public int data;
        // abstract public int data;
        // public abstract int data;
        // abstract int data;
        // private int data;
        // public abstract int data;
        // public abstract int data;
        // public int data;
        // abstract private int data;
        // private float getReal;
        // private abstract float getReal();
        public abstract float getReal();
        // public abstract void adds(T b);
        // public abstract void subtracts(T b);
        // public abstract void multiplies(T b);
        // public abstract void divides(T b);

        public abstract void adds(MyXXPoint b);
        public abstract void subtracts(MyXXPoint b);
        public abstract void multiplies(MyXXPoint b);
        public abstract void divides(MyXXPoint b);
        public abstract String toString();
        // private void adds(MyXXPoint b) {}
        // private void subtracts(MyXXPoint b) {}
        // private void multiplies(MyXXPoint b) { }
        // private void divides(MyXXPoint b) {}
    }
    class MyFixedPoint extends MyXXPoint {
    // class MyFixedPoint extends MyXXPoint<MyFixedPoint> {
    // class MyFixedPoint extends MyXXPoint<Integer> {
    // class MyFixedPoint implements MyXXPoint {
        private int data;
        // public int data;
        private static float divider = 1000.0f;

        MyFixedPoint(float inputData) {
            // System.out.println("kkk : " + (inputData * divider));
            // System.out.println("kkk : " + (int)(inputData * divider));
            this.data = (int)(inputData * divider);
            // System.out.println("MFXP data after calc : " + this.data);
        }

        @Override
        public float getReal() {
            // System.out.println("Get data :" + data);
            // return data/divider;
            return data;
        }

        @Override
        // public void adds(MyFixedPoint b) {
        public void adds(MyXXPoint b) {
        // public void adds(MyFixedPoint b) {
            // data += r2;
            // System.out.println("Here adds FXP");
            // System.out.println("B.data : " + b.data);
            System.out.println("B.data : " + b.getData());
            this.data = this.data + (int)b.getData();
            // this.data = this.data + b.data;
            // this.data = this.data + b.getReal();
            // System.out.println("This.data after adds : " + this.data);
        }

        @Override
        public void subtracts(MyXXPoint b) {
        // public void subtracts(MyFixedPoint b) {
            // data = data - b.data;
            data = (int)(data - b.data);
            // data
        }

        @Override
        public void multiplies(MyXXPoint b) {
        // public void multiplies(MyFixedPoint b) {
            data = data * (int)(b.data / divider);
            // data = data * (int)(b.getReal());
            // data = data * b.getReal();
            // data = data * b.getReal();
            // data = data * (b.data / divider);
            // data = data * b.data;
            // data = data * b.data;
            // data = data * b.data;
            // data = data * b.getData();
            // data *= r2;
        }

        @Override
        // public void divides(MyFixedPoint b) {
        public void divides(MyXXPoint b) {
            // data = data * (int)(b.data / divider);
            // data = data / b.data;
            data = (int)(data / b.data);
            // data /= r2;
        }

        public String toString() {
            String ret = "FXP";
            return ret;
        }
    }

    // class MyFloatingPoint extends MyXXPoint<MyFloatingPoint> {
    class MyFloatingPoint extends MyXXPoint {
        // private float data;
        public float data;

        MyFloatingPoint(float data) {
            this.data = data;
        }

        public float getReal() {
            return data;
        }

        // public void adds(MyFloatingPoint b) {
        public void adds(MyXXPoint b) {
            data = data + b.data;
        }

        public void subtracts(MyXXPoint b) {
        // public void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }

        public void multiplies(MyXXPoint b) {
        // public void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }

        // public void divides(MyFloatingPoint b) {
        public void divides(MyXXPoint b) {
            data = data / b.data;
        }

        public String toString() {
            String ret = "FLP";
            return ret;
        }

    }


    public static void main(String[] args) {

        Lab14 l14= new Lab14();

        float initVal = 1.234f;
        float val = 4.321f;
        // MyXXPoint fxp =  l14.new MyFixedPoint(initVal);
        // MyXXPoint fxp2 = l14.new MyFixedPoint(val);
        MyFixedPoint fxp =  l14.new MyFixedPoint(initVal);
        MyFixedPoint fxp2 = l14.new MyFixedPoint(val);

        MyFloatingPoint flp = l14.new MyFloatingPoint(initVal);
        MyFloatingPoint flp2 = l14.new MyFloatingPoint(val);
        // MyXXPoint flp = l14.new MyFloatingPoint(initVal);
        // MyXXPoint flp2 = l14.new MyFloatingPoint(val);

        MyXXPoint[] As = {fxp, flp};
        MyXXPoint[] Bs = {fxp2, flp2};

        for (int i = 0; i < 2; i++)
        {
            MyXXPoint A = As[i];
            MyXXPoint B = Bs[i];

            long startT = System.nanoTime();

            A.adds(B);
            System.out.println("Get data : " + A.getReal());
            // A.toString();
            System.out.println(A.toString());

            long endT = System.nanoTime();
            long elapsedT = endT - startT;
            System.out.println("Elaped time : " + elapsedT);
            System.out.println();

        }

    }
}
