public class Quicksort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void quicksort(int arr[], int si, int ei) {
        // Base Case
        if (si >= ei) {
            return;
        }
        
        // Working
        int pid = partition(arr, si, ei);
        quicksort(arr, si, pid - 1); // Left
        quicksort(arr, pid + 1, ei); // Right
    }
    
    public static int partition(int arr[], int si, int ei) {
        // Last element as pivot
        int pivot = arr[ei];
        int i = si - 1; // To make place for smaller elements than pivot
        
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        // Put pivot in the right place
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        
        return i;
    }
    
    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 100, 9, 77, 55, 103};
        quicksort(arr, 0, arr.length - 1);
        print(arr);
    }
}
