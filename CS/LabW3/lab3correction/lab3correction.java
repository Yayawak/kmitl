package CS.LabW3.lab3correction;

public class lab3correction {
    public static void main(String[] args) {
        // int[] d = {9,20,6,10,14,8,60,11};
        int[] d = {9,11,13,14,15,17,19,22};
        int markIdx = 0;
        int magic = 0;
        for (int iter=0; iter < d.length - 1; iter++) {
            markIdx = iter;
            for (int currentExamineIdx=markIdx; currentExamineIdx<d.length;
                currentExamineIdx++) {
                if(d[markIdx] > d[currentExamineIdx]) {
                    markIdx = currentExamineIdx;
                    magic++;
                }        
            }

            // * : SWAPPING
            int temp = d[iter];
            d[iter] = d[markIdx];
            d[markIdx] = temp;
            
            // * : SHOW ITEMS IN ARRAY
            for (int i=0; i<d.length; i++) {
                System.out.print(d[i] + " ");
            }
            System.out.println("last temp : " + temp);
            System.out.println();
        }
        System.out.println("magic : " + magic);
        
    }
}
