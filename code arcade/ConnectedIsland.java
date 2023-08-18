import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Utils
{
    // public static boolean isNumber(String s)
    // {
    //     try {
    //         Integer.parseInt(s);
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }
    public static String getMatrixInput(int nrow)
    {
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(System.in);
        while (nrow >= 0)
        {
            String s = sc.nextLine();
            // System.out.println("s" + s);
            sb.append(s);
            nrow--;
        }
        sc.close();
        return sb.toString();
    }
}

final class MatrixUtils
{
    public static <T> void printMatrix2D(T[][] mat)
    {
        // System.out.println("Print Matrix of type " + mat.getClass().getName());
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // public int[][] zerolike(Character[][] mat)
    public static <T> Integer[][] zerolike(T[][] mat)
    // public static <T> Character[][] zerolike(T[][] mat)
    {
        int nrow = mat.length;
        int ncol = mat[0].length;
        Integer[][] ret = new Integer[nrow][ncol];
        // T[][] ret = new T[nrow][ncol];
        // Character[][] ret = new Character[nrow][ncol];
        for (int i = 0; i < nrow; i++)
        {
            for (int j = 0; j < ncol; j++)
            {
                // ret[i][j] = '0';
                ret[i][j] = 0;
            }
        }
        return (ret);
    }
    // public <T, Ret> Ret[][] alike(T[][] mat, Ret defaultValue)
    // {
    //     Ret[][] ret = new Ret[nrow][ncol];
    //     for (int i = 0; i < nrow; i++)
    //     {
    //         for (int j = 0; j < ncol; j++)
    //         {
    //             ret[i][j] = defaultValue;
    //         }
    //     }
    //     return (ret);
    // }
}

class SequencialConnectedComponent
{
    public Integer[][] map;
    public List<Set<Integer>> equivalenceTable = new ArrayList<Set<Integer>>();
    // public Map<Integer, Integer> connectedComponent
    static class Component
    {
        static class Point
        {
            public int x;
            public int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public String toString()
            {
                return String.format("[%d,%d]", x, y);
            }
        }
        public int label;
        public int size;
        public Set<Point> points;

        public Component(int label, int size,
            int x, int y
        )
        {
            // Set<SequencialConnectedComponent.Component.Point> points) {
            this.label = label;
            this.size = size;
            // this.points = points;
            this.points = new HashSet<SequencialConnectedComponent.Component.Point>();
            addNewPoint(x, y);
        }

        public void addNewPoint(int x, int y)
        {
            points.add(new Point(x, y));
        }

        @Override
        public String toString() {
            // return "Component [label=" + label + ", size=" + size + ", points=" + points + "]";
            // return String.format("[%d, %d, %s]", label, size, points);
            return String.format("[label : %d, size: %d]", label, size);
        }
    }
    public List<Component> components = new ArrayList<>();

    public SequencialConnectedComponent(Integer[][] inputMap)
    {
        this.map = inputMap;

    }

    private void addEquivalentSetToEquivalentTable(int x1, int x2)
    {
        Set<Integer> set = new HashSet<>();
        set.add(x1);
        set.add(x2);

        boolean isThisNewSetIsolated = true;
        for (Set<Integer> s : equivalenceTable)
        {
            if (s.contains(x1) || s.contains(x2))
            {
                s.addAll(set);
                isThisNewSetIsolated = false;
            }
        }
        if (isThisNewSetIsolated)
        {
            equivalenceTable.add(set);
        }
        // System.out.println("Adding Eqivalence set to EqivalenceTable");
        // System.out.println(equivalenceTable);
    }

    private boolean haveLabel(int num)
    {
        return (num > 0);
    }

    public void startProcess()
    {
        // System.out.println("BEFORE PROCESSING CONNECTED COMPONENTS\n");
        // System.out.println("PROCESSING CONNECTED COMPONENTS\n");
        // System.out.println("processing connected components....");
        // Character[][] emptyMap = MatrixUtils.zerolike(map);
        // assert (emptyMap.length == map.length && emptyMap[0].length == map[0].length);

        int curentLabel = 0;
        final int noPixelSymbol = -1;
        for (int y = 0; y < map.length; y++)
        {
            for (int x = 0; x < map[0].length; x++)
            {
                int currentPixel = map[y][x];
                if (currentPixel == 0) continue;

                int l = (x != 0) ? map[y][x - 1] : noPixelSymbol;
                int t = (y != 0) ? map[y - 1][x] : noPixelSymbol;
                boolean hasL = l != noPixelSymbol;
                boolean hasT = t != noPixelSymbol;
                if (x == 0 && y == 0 && haveLabel(curentLabel))
                {
                    curentLabel++;
                    map[y][x] = curentLabel;
                    continue;
                }
                // handle only row 0
                if (!hasT && hasL && haveLabel(l))
                {
                    map[y][x] = l;
                    continue;
                }
                // handle only column 0
                if (hasT && !hasL && haveLabel(l))
                {
                    map[y][x] = t;
                    continue;
                }

                
                //LINK - Do the rest of logics here (no need to worry about out of bound)
                if ((haveLabel(l) && haveLabel(t)))
                {
                    // NOTE : same t == l
                    if (l == t)
                    {
                        map[y][x] = l;
                    }
                    // NOTE : different t != l
                    else if (l != t)
                    {
                        map[y][x] = t;
                        addEquivalentSetToEquivalentTable(l, t);
                    }
                }
                else if (haveLabel(l) && !haveLabel(t))
                {
                    map[y][x] = l;
                }
                else if (!haveLabel(l) && haveLabel(t))
                {
                    map[y][x] = t;
                }
                // no labels initiated now
                else if (!(haveLabel(l) && haveLabel(t)))
                {
                    curentLabel++;
                    map[y][x] = curentLabel;
                }
            }
        }

        // empty Map is no empty anymore.
        // MatrixUtils.printMatrix2D(map);
    }

    //NOTE - use uncleaned-labeled map & equivalent table
    public void reconstructMap()
    {
        // System.out.println("After reconstructing");
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                int cur = map[i][j];
                if (cur == 0) continue;

                for (Set<Integer> set : equivalenceTable) 
                {
                    final int min = Collections.min(set);
                    for (int n : set) 
                    {
                        if (cur == n)
                        {
                            map[i][j] = min;
                            break;
                        }
                    }
                }
            }
        }
        // MatrixUtils.printMatrix2D(map);
    }

    public void countConnectedComponentWithSizes()
    {
        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[0].length; j++)
            {
                int label = map[i][j];
                if (label == 0) continue;
                boolean isNewCompnent = true;

                for (Component component : components) {
                    if (component.label == label)
                    {
                        component.size++;
                        component.addNewPoint(i, j);
                        isNewCompnent = false;
                        break;
                    }
                }
                if (isNewCompnent)
                {
                    components.add(
                        new Component(label, 1, 
                            i, j
                    ));
                }
            }
        }
    }
}

class Map
{
    public String[][] map;
    public int nrow;
    public int ncol;

    public Map(int nrow, int ncol)
    {
        // map = new char[nrow][ncol];
        map = new String[nrow][ncol];
        this.nrow = nrow;
        this.ncol = ncol; 
    }


    public void fullfillMapFromString(String s)
    {
        // System.out.println("slen = " + s.length());
        // System.out.println("String s is " );
        // System.out.println(s);
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            //NOTE for debuging
            // if (c == '\n')
            //     System.out.print("\\n");
            // else
            //     System.out.print(c);
                

            if (c == ' ')
            {
                continue;
            }
            else if (c == '\n')
            // else if (c == '\n' || x == map[0].length)
            // else if (c == '\n' || x == map[0].length - 1)
            {
                // ! this line is problematic when we can't check for \n
                // if (y == map.length - 1)
                //     break;
                // map[y][x] = "" + c;
                y++;
                x = 0;
                // map[y][x] = "" + c;
                continue;
            }
            else if (c == 'X')
            {
                map[y][x] = "X";
            }
            // else if (Utils.isNumber(c))
            // else if (Integer.parseInt(s))
            else
            {
                // System.out.format("What is 4 xy[%d,%d]\n", x, y);
                map[y][x] = "" + c;
                // map[y][x] = 1;
            }
            x++;
        }
    }

    // public void convertVerboseToBinaryMap(Character[][] charMap)
    // public void convertVerboseToBinaryMap()
    public Integer[][] verboseToBinaryMap()
    {
        Integer[][] ret = new Integer[nrow][ncol];
        for (int i = 0; i < ret.length; i++)
        {
            for (int j = 0; j < ret[i].length; j++)
            {
                if (map[i][j].equals("X"))
                    ret[i][j] = 1;
                // else if (map[i][j].equals("0"))
                else
                    ret[i][j] = 0;
            }
        }
        return (ret);
    }

    public void printMapMatrix()
    {
        System.out.println("Printing map matrix\n---->");
        MatrixUtils.printMatrix2D(map);
    }
}

public class ConnectedIsland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int nrow = sc.nextInt();
        // int ncol = sc.nextInt();

        String rc = sc.nextLine();
        String[] splited = rc.split(" ");
        final int nrow = Integer.parseInt(splited[0]);
        final int ncol = Integer.parseInt(splited[1]);
        // String mapString = Utils.getMatrixInput(nrow);
        StringBuilder sb = new StringBuilder("");
        // for (int i = 0; i < nrow * ncol; i++)
        for (int i = 0; i < nrow; i++)
        {
            // String s = sc.next();
            String s = sc.nextLine();
            // System.out.println("s" + s);
            sb.append(s);
            sb.append("\n");
            // System.out.println(i);
        }
        sc.close();
        String mapString = sb.toString().trim();
        Map M = new Map(nrow, ncol);

        // Map M = new Map(8, 13);
        // String mapString = """
        //     0 0 X 0 0 0 0 X 0 0 0 0 0
        //     0 0 0 0 0 0 0 X X X 0 0 0
        //     0 X X 0 X 0 0 0 0 0 0 0 0
        //     0 X 0 0 X X 0 0 X 0 X 0 0
        //     0 X 0 0 X X 0 0 X X X 0 0
        //     0 0 0 0 0 0 0 0 0 0 X 0 0
        //     0 0 0 X 0 0 0 X X X 0 0 0
        //     0 0 X X 0 0 0 X X 0 0 0 0""";
        
                
        M.fullfillMapFromString( mapString);
        // M.printMapMatrix();
        // Integer[][] zeroMat = MatrixUtils.zerolike(M.map);
        // MatrixUtils.printMatrix2D(zeroMat);
        // MatrixUtils.printMatrix2D(M.map);

        Integer[][] binaryMap = M.verboseToBinaryMap();
        // System.out.println("binary map");
        // MatrixUtils.printMatrix2D(binaryMap);

        SequencialConnectedComponent scc = new SequencialConnectedComponent(binaryMap);
        // MatrixUtils.printMatrix2D(scc.map);
        scc.startProcess();
        scc.reconstructMap();
        scc.countConnectedComponentWithSizes();
        // MatrixUtils.printMatrix2D(scc.map);
        
        final int numberOfIslands = scc.components.size();
        // Collections.max(scc.components);
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < scc.components.size(); i++)
        {
            SequencialConnectedComponent.Component c = scc.components.get(i);
            // System.out.println(c);
            // System.out.println(c.points);
            // System.out.println("-----------------------");
            if (c.size > maxSize)
            {
                maxSize = c.size;
            }
        }
        // System.out.println("How many Islands --> " + numberOfIslands);
        // System.out.println("Biggest Island Size  --> " + maxSize);
        System.out.println(maxSize);
        System.out.println(numberOfIslands);
        // System.out.println(scc.components);

        // System.out.println("Finding the Maxima Island...");

    }

}
