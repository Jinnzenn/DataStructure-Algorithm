package Chapter201ClassicProblemsAndAlgorithm.Section208DynamicPlanning;

public class MinAddToMakeValid {
    public double minAddToMakeValid(String S, double[] weights) {
        char[] chArr = S.toCharArray();
        int n = S.length();
        //n+1 == weights.n
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 0;//weights[0];//i表示字符串下标 , j表示未匹配的左括号数量???
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j * weights[0];//能出现这种情况？？？
        }
        for(int i = 1; i <= n; ++i){
            //添加左括号
            for(int j = 0; j <= n; ++j){
                dp[i][j] = Double.MAX_VALUE;
                if(chArr[i-1] == ')'){
                    if(j < n) dp[i][j] = Math.min(dp[i-1][j+1], dp[i][j]);
                }else{
                    if(j > 0) dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
                }
                
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j-1] + weights[i], dp[i][j]);
                }
            }
            //添加右括号
            for(int j = n - 1; j >= 0; --j){
                dp[i][j] = Math.min(dp[i][j+1] + weights[i], dp[i][j]);
            }
        }
        return dp[n][0];
    }
    public static void main(String[] args){
        String str = "()))((";
        double[] weights = new double[]{0.9, 1.9, 1.1, 2.0, 3.0, 1.2, 3.3};
        MinAddToMakeValid solution = new MinAddToMakeValid();
        double res = solution.minAddToMakeValid(str, weights);
        System.out.println(res);
    }
}
