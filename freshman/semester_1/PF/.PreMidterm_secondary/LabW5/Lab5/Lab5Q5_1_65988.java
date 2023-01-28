package PF.LabW5.Lab5;

public class Lab5Q5_1_65988 {
    public static void main(String[] args) {
        int n = 10;
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if (row == col) {
                    drawEmpty();
                }
                // * ทำไมต้องใช้ ลด n มาหนึ่ง เพราะว่า
                // * เราอ้างอิงถึง index ไม่ใช่ จำนวนปกติ ดังนั้นเราจึงต้อง -1 ตามเสต็ป
                else if (row == ((n-1) - col)) {
                // if (row == (n-col)) {
                    drawEmpty();
                }
                else {
                    drawX();
                }
            }
            System.out.println();
            System.out.println();
        }
    }
    static void drawEmpty() { System.out.print(" "); }
    static void drawX() { System.out.print("x"); }
}
