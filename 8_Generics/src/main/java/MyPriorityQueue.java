import java.util.Arrays;

public class MyPriorityQueue<E> {
    private E[] arr;

    public MyPriorityQueue() {
        arr = (E[]) new Object[0];
    }

    public void add(E e) {
        Object[] temp = (E[]) new Object[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        temp[temp.length - 1] = e;
        Arrays.sort(temp);
        arr = (E[]) temp;
    }

    public E remove(int index) {
        if (index >= arr.length || index < 0) {
            throw new RuntimeException("Invalid index");
        }
        E element = (E) arr[index];
        arr[index] = null;
        E[] temp = (E[]) new Object[arr.length - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            temp[i - 1] = arr[i];
        }
        arr = temp;
        return element;
    }

    public int size() {
        return arr.length;
    }

    public E poll() {
        E res = arr[0];
        if (arr.length != 0) {
            E[] temp = (E[]) new Object[arr.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[i + 1];
            }
            arr = temp;
        } else {
            return null;
        }
        return res;
    }

    public E peek() {
        if (arr.length != 0) {
            return arr[0];
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + ", ";
        }
        res = res.substring(0, res.length() - 2);
        res += "]";
        return res;
    }
}
