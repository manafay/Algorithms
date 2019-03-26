public class Pair<T, U> {
    private T key;
    private U value;

    Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public U get(T key) {
        return this.value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

}
