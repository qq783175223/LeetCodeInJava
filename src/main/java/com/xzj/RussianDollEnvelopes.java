package src.main.java.com.xzj;

import java.util.Arrays;

//时间复杂度O(N*logN)
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        //将行如[[a1,b1],[a2,b2]]的元组按a从小到大排序,a相同则按b从大到小排序
        Arrays.sort(envelopes,(a, b)->{
            if(Integer.valueOf(a[0]).compareTo(Integer.valueOf(b[0]))!=0){
                return Integer.valueOf(a[0]).compareTo(Integer.valueOf(b[0]));
            }else{
                return Integer.valueOf(b[1]).compareTo(Integer.valueOf(a[1]));
            }
        });

        int result=1;
        int h[]=new int[envelopes.length];
        int j=0;
        h[0]=envelopes[0][1];
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1]>h[j]){//如果下一个元素大于h[j]的最后一个元素,则扩充h的有效区域
                j++;
                h[j]=envelopes[i][1];
                result++;
            }else if(envelopes[i][1]<h[j]){
                int key=envelopes[i][1];
                if(Arrays.binarySearch(h,0,j,key)<0){//如果h数组中不存在相同的值,则将key插到第一个大于它的位置
                    int index=binarySearch(h,0,j,key);//h数组中第一个大于key的位置
                    h[index]=key;
                }
            }
        }
        return result;
    }
    
    
    public int binarySearch(int[] h, int fromIndex, int toIndex, int key){
        if(fromIndex>toIndex){
            return -1;//出错,对于本题，其实可不写这个判断，因为不可能有这种情况
        }else if(fromIndex==toIndex&&h[fromIndex]>key){
            return fromIndex;
        }else if(fromIndex==toIndex&&h[fromIndex]<=key){
            return -2;//出错,对于本题，其实可不写这个判断，因为不可能有这种情况
        }
        int mid=fromIndex+(toIndex-fromIndex+1)/2;
        if(key>h[mid-1]&&key<h[mid]){
            return mid;
        }else if(key>h[mid-1]&&key>h[mid]){
            return binarySearch(h,mid,toIndex,key);
        }else if(key<h[mid-1]&&key<h[mid]){
            return binarySearch(h,0,mid-1,key);
        }else{
            return -3;
        }
    }
}