//LeetCode 280
class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        //假设nums[0]~nums[i-1]已经用wiggle sort排好序了，那么对于nums[i]有两种可能需要考虑
        //如果i是奇数，而且nums[i-1]>nums[i]，例如[1,3,2]，nums[i]=1，这种情况只需要交换nums[i-1]和nums[i]
        //如果i是偶数，而且nums[i-1]<nums[i]，例如[1,3,2,4]，nums[i]=5，这种情况也只需要交换nums[i-1]和nums[i]
        //交换过程不会破坏nums[0]~nums[i-1]的摇摆性质
        for(int i=1;i<nums.size();i++)
        {
            if((i%2==0&&nums[i-1]<nums[i])||(i%2==1&&nums[i-1]>nums[i]))
                swap(nums[i-1],nums[i]);
        }
    }
};