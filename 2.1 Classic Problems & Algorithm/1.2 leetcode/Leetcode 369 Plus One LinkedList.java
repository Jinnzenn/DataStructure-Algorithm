// 369 plus one linkedList
public class Solution{
    public ListNode plusOne(ListNode head){
        if(head==null) return null;
        int carry = carryAfterPlusOne(head);
        if(carry!=0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    //return:后续数字加1后的进位
    private int carryAfterPlusOne(ListNode head){
        //if(head == null) return 0;//可以不写
        //递归基
        if(head.next == null){
            //说明是最后一位。
            head.val = (head.val+1)%10;
            return head.val/10;
        }
        //不是最后一位
        int carry = carryAfterPlusOne(head.next);
        head.val = (head.val+carry)%10;
        return (head.val+carry)/10;
    }
}

//由于只加1，carry最多为1
public class Solution{
    public ListNode plusOne(ListNode head){
        if(head==null) return null;
        int carry = carryAfterPlusOne(head);
        if(carry!=0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    //return:后续数字加1后的进位
    private int carryAfterPlusOne(ListNode head){
        //if(head == null) return 0;//可以不写
        //递归基
        if(head.next == null){
            //说明是最后一位。
            int newVal = head.val+1;
            head.val = newVal >= 10 ? newVal-10 : newVal;
            return newVal>=10 ? 1 : 0;
        }
        //不是最后一位
        int carry = carryAfterPlusOne(head.next);
        int newVal = head.val + carry;
        head.val =newVal >= 10 ? newVal-10 : newVal;
        return newVal>=10 ? 1 : 0;
    }
}