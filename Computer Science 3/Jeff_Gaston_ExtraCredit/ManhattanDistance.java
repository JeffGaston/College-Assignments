import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManhattanDistance {

    private static List<int[][]> paths = new ArrayList<>();
    private  static int[] start;
    private static int[] end;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = promptCoordinate("King", scanner);
        end = promptCoordinate("Queen", scanner);

        int vertDist = end[1] - ManhattanDistance.start[1];
        int horizDist = end[0] - ManhattanDistance.start[0];
        findManhattanPaths(start[0], start[1], vertDist, horizDist, new int[0][]);

        System.out.println("\nAll Possible Shortest Paths: ");
        for (int[][] path : paths)
        System.out.printf("\t%s\n", Arrays.deepToString(path));
        System.out.printf("\nTotal Solutions: %s\n", paths.size());
        System.out.printf("Manhattan Distance: %d\n", Math.abs(vertDist) + Math.abs(horizDist));

    }

    private static int[] promptCoordinate(String prefix, Scanner scanner) {
        System.out.printf("%s X: ", prefix);
        int startX = scanner.nextInt();
        System.out.printf("%s Y: ", prefix);
        int startY = scanner.nextInt();

        return new int[]{startX, startY};
    }

    private static int[][] concat(int[][] a, int x, int y) {
        int[][] concat = new int[a.length + 1][];
        System.arraycopy(a, 0, concat, 0, a.length);
        concat[a.length] = new int[]{x, y};
        return concat;
    }

    private static void findManhattanPaths(int x, int y, int vertDist, int horizDist, int[][] path) {
        path = concat(path, x, y);
        if (Math.abs(vertDist) >= 1) {
            int offsetY = Math.abs(vertDist) / vertDist;
            findManhattanPaths(x, y + offsetY, vertDist - offsetY, horizDist, path);
        }

        if (Math.abs(horizDist) >= 1) {
            int offsetX = Math.abs(horizDist) / horizDist;
            findManhattanPaths(x + offsetX, y, vertDist, horizDist - offsetX, path);
        }

        if (x == end[0] && y == end[1])
            paths.add(path);
    }
}
