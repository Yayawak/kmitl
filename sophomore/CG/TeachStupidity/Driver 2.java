package TeachStupidity;

@FunctionalInterface
interface ISumable  {
    public int sum(int x, int y); 
    // public int subtract(int x, int y); 
}

// class ClassX

public class Driver {
    public static void main(String[] args) {
        // * version 1 (old fasion)
        class A implements ISumable 
        {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        }

        ISumable a = new A();
        // A a = new A();

        // * version 2 : anonymouse class
        ISumable b = new ISumable() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
            
        };

        // * version 3 : lambda expression (new age)
        ISumable c = (x, y) -> {
        // ISumable c = (xxxxxxxxxxxxx, _y_a92394592394) -> {
        // ISumable c = (int x, int y) -> {
        // ISumable c = (double x, int y) -> {
            // return xxxxxxxxxxxxx + _y_a92394592394;
            return x + y;
        };




        System.out.println(a.sum(10, 20));
        System.out.println(b.sum(10, 20));
        System.out.println(c.sum(10, 20));
    }
}
