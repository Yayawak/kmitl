public class Caller {
    public static void main(String[] args) {
        WeighedGraph<String> g = new WeighedGraph<>();
        int[][] citiesDistance = {
            {0, 32, 5, 1},
            {5, 0, 100, 1},
            {8, 9, 0, 2},
            {1, 6, 3, 0}
        };
        String[] citiesName = {"A", "B", "C", "D"};
        for (String cityName : citiesName) {
            g.addVertex(cityName);
        }
        for (String cityName : citiesName)
            g.addVertex(cityName);
        for (int from_i = 0; from_i < citiesDistance.length; from_i++) {
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
