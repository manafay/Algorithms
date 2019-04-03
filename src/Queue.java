import java.util.ArrayList;

public class Queue<T> {

        ArrayList<T> arr = new ArrayList<>();

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public int size() {
            return  arr.size();
        }

        public void enqueue(T data) {
            arr.add(data);
        }

        public T dequeue() {
            if (!isEmpty()) {
                return arr.remove(0);
            }
            return null;
        }

        public T peek() {
            if (!isEmpty()) {
                return arr.get(0);
            }
            return null;
        }

}
