public class SortedandRotatedArray {

    public static int recurr(int arr[], int si, int ei, int tar) {
        if (si > ei) {
            return -1; // Element not found
        }
        
        int mid = (si + ei) / 2;
        
        if (arr[mid] == tar) {
            return mid;
        }
        
        int idx = -1; // Initialize idx with a default value
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                idx = recurr(arr, si, mid - 1, tar);
            } else {
                idx = recurr(arr, mid + 1, ei, tar);
            }
        } else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                idx = recurr(arr, mid + 1, ei, tar);
            } else {
                idx = recurr(arr, si, mid - 1, tar);
            }
        }
        
        return idx; // Return the index
    }

    public static int index(int arr[], int si, int ei, int tar) {
        int mid = (si + ei) / 2;
        while (si <= ei) {
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[si] <= arr[mid]) {
                if (arr[si] <= tar && tar <= arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (arr[mid] <= tar && tar <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
            mid = (si + ei) / 2;
        }
        return -1; // Element not found
    }

    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int tar = 0;
        System.out.println(index(arr, 0, arr.length - 1, tar));
    }
}
