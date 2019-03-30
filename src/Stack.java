import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> arr = new ArrayList<>();

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public int size() {
        return  arr.size();
    }

    public void push(T data) {
        arr.add(data);
    }

    public T pop() {
        if (!isEmpty()) {
            return arr.remove(size() - 1);
        }
        return null;
    }

    public T peek() {
        return arr.get(arr.size() - 1);
    }

}
