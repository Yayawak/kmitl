import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    static double getMaxValue(ItemValue[] arr, int capacity) {
        // sort by val/wt ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2){
                double cpr1 = (double)item1.value/(double)item1.weight;
                double cpr2 = (double)item2.value/(double)item2.weight;
                if (cpr1 < cpr2) return 1;
                else return -1;
            }
        });
        double totalVal = 0d;
        for (ItemValue i : arr) {
            int curWt = (int)i.weight;
            int curVal = (int)i.value;
            if(capacity - curWt >= 0)  {
                capacity -= curWt;
                totalVal += curVal;
                // i.isPicked = true;
            }else {
                double fraction = (double)capacity/(double)curWt;
                totalVal += (curVal*fraction);
                capacity = (int)(capacity-(curWt*fraction));
                // i.isPicked = false;
                break;
            }
        }
        return totalVal;
    }
    static class ItemValue {
        int value, weight;
        boolean isPicked = false;
        public ItemValue(int val, int wt) {
            this.value = val; this.weight = wt;
        }
        public static void main(String[] args) {
            ItemValue[] arr = {
                new ItemValue(20, 2),
                new ItemValue(30, 5),
                new ItemValue(50, 10),
                new ItemValue(10, 5),
            };
            int capacity = 50;
            double maxValue = getMaxValue(arr, capacity);
            System.out.println("Maximum Value we obtain = " + maxValue);
            // System.out.println(Arrays.toString(arr));
            for(ItemValue iv : arr) {
                System.out.println(iv.isPicked);
            }
        }
    }
}
