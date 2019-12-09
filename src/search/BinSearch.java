package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] arr = {1,22,34,56,78,88,88,88,93,94,99,955,988,788};
        List<Integer> resList = binSearch(arr, 0, arr.length - 1, 88);
        System.out.println(resList);//[5,6,7]


    }

    /**
     *
     * @param arr       数组
     * @param left      数组起始索引
     * @param right     数组最大索引
     * @param findVal   需要查找的值
     * @return          List集合,值为数组下标,若集合为空则未找到
     */
    public static List<Integer> binSearch(int[] arr,int left,int right,int findVal){
        if(left>right){
            return new ArrayList<Integer>();
        }
        //中间值的下标
        int mid = (left+right)>>1;
        //中间值
        int midVal = arr[mid];

        if(findVal<midVal){
            //向左递归
            return binSearch(arr,left,mid-1,findVal);
        }else if (findVal>midVal){
            //向右递归
            return binSearch(arr,mid+1,right,findVal);
        }else{
            List<Integer> resultIndexList = new ArrayList<>();
            int temp = mid - 1;
            //扫描
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                resultIndexList.add(temp);
                temp -= 1;
            }
            resultIndexList.add(mid);
            temp = mid + 1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
                resultIndexList.add(temp);
                temp += 1;
            }
            return resultIndexList;
        }
    }

}
