class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool ans = 1;
        //检查横向上有无重复元素
        for(int i = 0;i < 9;i++){
            vector<int> record(9,0);
            for(int j = 0;j < 9;j++){
                int num = (board[i][j] - '0') - 1;
                if(num != ('.' - '0' - 1)){
                    record[num] == 0 ? record[num]++ : ans = 0;
                }
            }    
        }
        //检查纵向上有无重复元素
        for(int j = 0;j < 9;j++){
            vector<int> record(9,0);
            for(int i = 0;i < 9;i++){
                int num = (board[i][j] - '0') - 1;
                if(num != ('.' - '0' - 1)){
                    record[num] == 0 ? record[num]++ : ans = 0;
                }
            }    
        }
        //检查九宫格里有无重复元素
        for(int k = 0;k < 9;k += 3){
            vector<int> record1(9,0);
            vector<int> record2(9,0);
            vector<int> record3(9,0);
            for(int i = k;i < k+3;i++){
                for(int j = 0;j < 3;j++){
                    int num = (board[i][j] - '0') - 1;
                    if(num != ('.' - '0' - 1)){
                        record1[num] == 0 ? record1[num]++ : ans = 0;
                    }
                }
                for(int j = 3;j < 6;j++){
                    int num = (board[i][j] - '0') - 1;
                    if(num != ('.' - '0' - 1)){
                        record2[num] == 0 ? record2[num]++ : ans = 0;
                    }
                }
                for(int j = 6;j < 9;j++){
                    int num = (board[i][j] - '0') - 1;
                    if(num != ('.' - '0' - 1)){
                        record3[num] == 0 ? record3[num]++ : ans = 0;
                    }
                }
            }
        }
        return ans;         
    }
};
