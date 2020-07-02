import java.util.Scanner;
public class Main{
    public int countWays(int[][] office){
        int rowNum = office.length;
        int colNum = office[0].length;
        int[][] dp = new int[rowNum+1][colNum+1];
        dp[0][0] = 1;
        for(int i = 1;i <= rowNum; i++){
            if(office[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }
        for(int j = 1; j <= colNum; j++){
            if(office[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }
        for(int i = 1; i <= rowNum; i++){
            for(int j = 1; j <= colNum; j++){
                if(office[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[rowNum][colNum];
    }
    public static void main(String[] argu){
        //Scanner sc = new Scanner(System.in);
        int row = 10;//sc.nextInt();
        int col = 10;//sc.nextInt();
        int bossNum = 5;//sc.nextInt();
        int[][] office = new int[row][col];
        for(int i = 0; i < bossNum; i++){
            int bossx = i;
            int bossy = i;
            office[bossx][bossy] = 1;
        }
        Main walkWays = new Main();
        int ret = walkWays.countWays(office);
        System.out.println(ret);
    }
}