package CS.LabW6.Theif;

public class TheifXX {
    public static void main(String[] args) {
        int[] weightArr = {2,10,5,5};
        int[] valueArr = {20,50,30,10};

        int n = weightArr.length;
        int C = 16;
        Property[] properties = new Property[n];
        for (int i=0; i<n; i++) {
            Property prop = new Property(
                weightArr[i], valueArr[i]
            );
            properties[i] = prop;
        }

        // ? check sum of weight < C ?
        int sumW = 0;
        for(int i=0; i<n; i++) {
            int w = properties[i].weight;
            sumW += w;
        }
        if(sumW > C) {

        }else {

        }
        // System.out.println(properties.toString());
    }
}
