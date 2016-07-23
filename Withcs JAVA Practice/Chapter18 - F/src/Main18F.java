import java.util.*;

class Class {
    private final static int[][] moves = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
    private int[][] grid;
    private int total;
    private int i;
    private int j;

    public Class(int i, int j) {
        this.i = i;
        this.j = j;
        asdf();
    }

    public void asdf() {
        int baseX, baseY;
        baseX = i + 4;
        baseY = j + 4;
        grid = new int[baseX][baseY];
        total = (baseX - 4) * (baseY - 4);

        for (int r = 0; r < baseX; r++)
            for (int c = 0; c < baseY; c++)
                if (r < 2 || r > baseX - 3 || c < 2 || c > baseY - 3)
                    grid[r][c] = -1;

        int row = 2 + (int) (Math.random() * (baseX - 4));
        int col = 2 + (int) (Math.random() * (baseY - 4));

        grid[row][col] = 1;

        if (solve(row, col, 2)) {
            System.out.println("True  ");
            printResult();
        }
        else
            System.out.println("False ");
    }

    private boolean solve(int r, int c, int count) {
        if (count > total)
            return true;

        List<int[]> nbrs = neighbors(r, c);

        if (nbrs.isEmpty() && count != total)
            return false;

        Collections.sort(nbrs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] nb : nbrs) {
            r = nb[0];
            c = nb[1];
            grid[r][c] = count;
            if (!orphanDetected(count, r, c) && solve(r, c, count + 1))
                return true;
            grid[r][c] = 0;
        }

        return false;
    }

    private List<int[]> neighbors(int r, int c) {
        List<int[]> nbrs = new ArrayList<int[]>();

        for (int[] m : moves) {
            int x = m[0];
            int y = m[1];
            if (grid[r + y][c + x] == 0) {
                int num = countNeighbors(r + y, c + x);
                nbrs.add(new int[]{r + y, c + x, num});
            }
        }
        return nbrs;
    }

    private int countNeighbors(int r, int c) {
        int num = 0;
        for (int[] m : moves)
            if (grid[r + m[1]][c + m[0]] == 0)
                num++;
        return num;
    }

    private boolean orphanDetected(int cnt, int r, int c) {
        if (cnt < total - 1) {
            List<int[]> nbrs = neighbors(r, c);
            for (int[] nb : nbrs)
                if (countNeighbors(nb[0], nb[1]) == 0)
                    return true;
        }
        return false;
    }

    private void printResult() {
        for (int[] row : grid) {
            for (int i : row) {
                if (i == -1) continue;
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
    }
}

public class Main18F {
    public static void main(String[] args) {

        for(int i = 1;i<10;i++) {
            //for(int j = i;j<10;j++) {
                Class c1 = new Class(i,i);
            //}
            System.out.println();
        }
    }
}