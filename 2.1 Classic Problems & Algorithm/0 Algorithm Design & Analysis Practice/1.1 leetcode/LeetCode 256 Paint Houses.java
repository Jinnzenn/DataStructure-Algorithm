public class PaintHouses{
    public int minCost(int[][] costs) {
        if (costs==null || cost.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = new int[costs.length][costs[0].length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = costs[i].clone();
        }
        //Arrays.copyOf() 方法对于基本数据类型来说是深拷贝，对引用类型来说是浅拷贝
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                dp[i][j] += Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);//自动换颜色
            }
        }
        return Math.min(Math.min(dp[costs.length-1][0], dp[costs.length-1][1]), dp[costs.length-1][2]);
    }
}