package PF.Playground;

public class midTerm2021 {
    public static void main(String[] args) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if ((i+j)>=4 && (i+j)<=12 && (j-i)<=4 && (i-j)<=4) {
                    System.out.print("0");
                }
                // else if((i+j)<4 || (j-i)>4 || (i-j)>4 || (i+j)>12) {
                //     System.out.print("A");
                // }
                else if((i+j)<4) {
                    System.out.print("A");
                }
                else if((i+j)>12) {
                    System.out.print("D");
                }
                else if((j-i)>4) {
                    System.out.print("B");
                }
                else if((i-j)>4) {
                    System.out.print("C");
                }

                // else if (i+j)
                else{
                    System.out.print("x");
                }
            }
            // ชึ้นบรรทัดใหม่เมื่อจบ 1 แถว
            System.out.println();
        }
    }
}
