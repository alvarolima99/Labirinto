public class Labirinto {
    private static final int N = 4;
    private static final int M = 5;

    int n = N, m = M;

    private static boolean[][] visited = new boolean[N][M];

    public static void main(String[] args)
    {
        setVisited(true);

        int labirinto[][] = {{ 1, 0, 1, 1, 0 },
                             { 1, 1, 1, 0, 1 },
                             { 0, 1, 0, 1, 1 },
                             { 1, 1, 1, 1, 1 } };

        if (isReachable(labirinto))
        {
            System.out.println("Caminho encontrado!\n");
        }
        else
            System.out.println("Caminho não encontrado!\n");
    }

    private static void setVisited(boolean b)
    {
        for (int i = 0; i < visited.length; i++)
        {
            for (int j = 0; j < visited[i].length; j++)
            {
                visited[i][j] = b;
            }
        }

    }

    private static boolean isReachable(int labirinto[][]) {
        int i = 0, j = 0;

        int fx, fy;
        fx = 1;
        fy = 4;

        Stack<No> s = new Stack<No>();

        No temp = new No(i, j);

        s.push(temp);

        while (!s.empty()) {

            temp = s.peek();
            int d = temp.getDir();
            i = temp.getX();
            j = temp.getY();


            temp.setDir(temp.getDir() + 1);
            s.pop();
            s.push(temp);

            if (i == fx && j == fy) {
                return true;
            }

            if (d == 0) {
                if (i - 1 >= 0 && labirinto[i - 1][j] == 1 && visited[i - 1][j]) {
                    No temp1 = new No(i - 1, j);
                    visited[i - 1][j] = false;
                    s.push(temp1);
                }

            } else if (d == 1) {
                if (j - 1 >= 0 && labirinto[i][j - 1] == 1 && visited[i][j - 1]) {
                    No temp1 = new No(i, j - 1);
                    visited[i][j - 1] = false;
                    s.push(temp1);
                }

            } else if (d == 2) {
                if (i + 1 < N && labirinto[i + 1][j] == 1 && visited[i + 1][j]) {
                    No temp1 = new No(i + 1, j);
                    visited[i + 1][j] = false;
                    s.push(temp1);
                }

            } else if (d == 3) {
                if (j + 1 < M && labirinto[i][j + 1] == 1 && visited[i][j + 1]) {
                    No temp1 = new No(i, j + 1);
                    visited[i][j + 1] = false;
                    s.push(temp1);
                }
            } else {
                visited[temp.getX()][temp.getY()] = true;
                s.pop();
            }
            System.out.print(i);
            System.out.println(j);
        }
        return false;
    }
}
