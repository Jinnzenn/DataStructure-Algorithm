//LeetCode 246 Strobogrammatic Number I
public class Solution{
    public boolean isStrobogrammatic(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('0', '0');
        map.put('8', '8');
        map.put('0', '0');
        int i = 0, j = s.length()-1;
        while(i<=j){
            if(!map.containsKey(s.charAt(i))) return false;
            if(map.get(s.charAt(i))!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Solution strobogrammatic = new Solution();
		boolean flag = solution.isStrobogrammatic("88");
		System.out.println("FLAG is: " + flag);
	}
}