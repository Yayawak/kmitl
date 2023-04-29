public class CallerOld {
    public static void main(String[] args) {
        WeighedGraph<String> g = new WeighedGraph<>();
        // String[] province;
        // int[][] citiesDistance = {
        // tokyo, osaka, nagoya, kyoto
        //     {0  , 570, 344, 463}, //tokyo
        //     {570,   0, 172, 53 }, //osaka
        //     {344, 172,   0, 137}, //nagoya
        //     {463,  53, 237,   0}, //kyoto
        // };

        // String[] citiesName = {"tokyo", "osaka", "nagoya",
        //     "kyoto"};
        // for (String cityName : citiesName) {
        //     g.addVertex(cityName);
        // }

        // int[][] citiesDistance = {
        //     {0, 0, 0, 348, 0, 0, 0, 695},
        //     {0, 0, 0, 74, 0, 0, 348, 0},
        //     {0, 348, 0, 0, 230, 0, 306, 0},
        //     {0, 74, 0, 0, 0, 262, 269, 0},
        //     {0, 0, 236, 0, 0, 0, 83, 0},
        //     { 0, 0, 0, 262, 0,0, 242, 0 },
        //     { 0, 348, 306, 269, 83, 242, 0, 151 },
        //     {695, 0, 0, 0, 0, 0, 151, 0}
        // };
        // String[] citiesName = {"A", "B", "C", "D",
        //     "E", "F", "G", "H" };
        // int[][] citiesDistance = {
        //     {0, 32, 5},
        //     {5, 0, 100},
        //     {8, 9, 0}
        // };
        // String[] citiesName = {"A", "B", "C"};
        // for (String cityName : citiesName) {
        //     g.addVertex(cityName);
        // }
        int[][] citiesDistance = {
            {0, 32, 5, 1},
            {5, 0, 100, 1},
            {8, 9, 0, 2},
            // {1, 6, 3, 1}
            {1, 6, 3, 0}
        };
        String[] citiesName = {"A", "B", "C", "D"};
        for (String cityName : citiesName) {
            g.addVertex(cityName);
        }
        // g.addEdge("melburn", "thailand", 10);
        // g.addEdge("melburn", "america", 2);
        // g.addEdge("america", "thailand", 100);
        // for (int to_i = 0; to_i < citiesDistance.length; to_i++) {
        //     if (to_i == 0)
        //         continue;
        //     g.addEdge(citiesName[0], citiesName[to_i],
        //         citiesDistance[0][to_i]
        //     );
        // }
        for (int from_i = 0; from_i < citiesDistance.length; from_i++) {
            // for (int to_j = from_i + 1; to_j < citiesDistance[from_i].length; to_j++) {
            for (int to_j = 0; to_j < citiesDistance[from_i].length; to_j++) {
                g.addEdge(citiesName[from_i], citiesName[to_j],
                    citiesDistance[from_i][to_j]
                );
            }
        }
        g.printGraph();

        KruskalMst<String> kk = new KruskalMst<>(g);
        System.out.println("MST");
        System.out.println(kk.getMst());
    }


}
