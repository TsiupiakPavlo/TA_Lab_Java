package a;

public class Main {
    public static int[] addAll(int[] array) {
        return array;
    }

    public static int[] addAll(int[] array1, int[] array2) {
        int[] joinedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};

        int[] combined1 = Main.addAll(arr1, arr2);
        for (int tmp : combined1) {
            System.out.print(tmp + " ");
        }

        int[] combined2 = Main.addAll(arr2);
        for (int tmp : combined2) {
            System.out.print(tmp + " ");
        }

    }
}
