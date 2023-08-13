public class SortedandRotatedArray {

    public static int index(int arr[],int si,int ei,int tar){
        //Base Case
        if(si>ei){
            return -1;
        }
        //Working
        int mid=(si+ei)/2;
        //case found
        if(arr[mid]==tar){
            return mid;
        }
        //mid on L1
        if(arr[si]<=arr[mid]){
            //case a: left
            if(arr[si]<=tar && tar<=arr[mid]){
                return index(arr,si,mid,tar);
            }else{
                //Cases b=right
                return index(arr,mid+1,ei,tar);
            }
        }else{
            //mid on L2
            //case c: Right
            if(arr[mid]<=tar&&tar<=arr[ei]){
                return index(arr,mid+1,ei,tar);
            }else{
                //left
                return index(arr,si,mid-1,tar);
            }
        }
    }
    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int tar = 4;
        System.out.println(index(arr, 0, arr.length - 1, tar));
    }
}
