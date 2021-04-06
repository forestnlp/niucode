package stack;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class MaxWindow {

    public int[] getMaxWindow(int[] arr,int w) {

        //要返回的答案
        int [] ans = new int[arr.length-w+1];
        int index = 0;
        //窗口右端指针
        int R=0;
        //窗口，存储下标
        Deque<Integer> deque = new LinkedBlockingDeque<>();

        while (R<arr.length) {

            //将arr[R]，当前元素存储到合适的位置。
            //如果它是一个比前面都大的数，队列清空
            while (!deque.isEmpty()&&arr[deque.peekLast()]<=arr[R]) {
                deque.pollLast();
            }
            deque.addLast(R);


            //每一次移动都可以取一次答案，此时并没有弹出
            if(R>=w-1) {
                ans[index++] = arr[deque.peekFirst()];
            }

            //啥时候弹出最左侧的头元素呢？
            if(R-w+1==deque.peekFirst())
                deque.pollFirst();


            R++;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {5,4,6,7,9,4,3,1,12,65,3,1};

        int[] ans = new MaxWindow().getMaxWindow(arr,3);

        for(int a:ans){
            System.out.println(a);
        }

    }

}
