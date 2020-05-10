	//
import java.util.*;
public class Vector2D {
    private int listIndex;
    private int elementIndex;
    private List<List<Integer>> list2d;

    public Vector2D(List<List<Integer>> vec2d) {
        list2d = vec2d;
        listIndex = 0;
        elementIndex = 0;
    }

    public int next() {
       return list2d.get(listIndex).get(elementIndex);
       elementIndex++;
    }

    //默认一定会调用hasNext()后再使用next()，所以对两个方法进行功能拆分
    public boolean hasNext() {
        if(listIndex < list2d.size()){
            if(elementIndex < list2d.get(listIndex).size()){
                return true;
            }else{
                //elementIndex == size, next list
                elementIndex = 0;
                return listIndex < list2d.size();
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */