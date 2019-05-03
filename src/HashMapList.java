import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

class HashMapList<T, U> {
    private ArrayList<ArrayList<Pair<T, U>>> hashList = new  ArrayList<>(Collections.nCopies(100,null));

    private int getHash(T k) {
        return k.toString().length() % 100;
    }

    public class Iterator<T, U> {
        private ArrayList<Pair<T, U>> iterList = new ArrayList<>();
        private int iter;

        private ArrayList randomHead() {
            // how do I check if the hashMap is not null or at least there is one insertion in place
            Random rand = new Random();
            int pick = rand.nextInt(100);
            return hashList.get(pick) != null ? hashList.get(4) : randomHead();
        }

        Iterator() {
           iterList = randomHead();
           iter = -1;
        }

        public boolean hasNext() {
            int nextIndex = iter + 1;
            if (iterList.size() > nextIndex) {
                return iterList.get(nextIndex) != null;
            }
            return false;
        }

        public U next() {
            return iterList.get(++iter).getValue();
        }
    }

    public U get(T k) {
        int hashKey = getHash(k);
        ArrayList<Pair<T, U>> searchList = hashList.get(hashKey);
        for (int i = 0; i < searchList.size(); ++i) {
            Pair<T, U> item = searchList.get(i);
            if(item.getKey().equals(k)) {
                return item.getValue();
            }
        }
        return null;
    }

    public void put(T k, U v) {
        int hashKey = getHash(k);
        if (hashList.get(hashKey) != null) {
            hashList.get(hashKey).add(new Pair(k, v));
        } else {
            ArrayList<Pair<T, U>> newList = new ArrayList<>();
            newList.add(new Pair(k, v));
            hashList.set(hashKey, newList);
        }

    }

    public void remove(T k) {
        Integer hashKey = getHash(k);
        ArrayList<Pair<T, U>> searchList = hashList.get(hashKey);
        int removeKey = -1;
        for (int i = 0; i < searchList.size(); ++i) {
            Pair<T, U> item = searchList.get(i);
            if(item.getKey().equals(k)) {
                removeKey = i;
                break;
            }
        }
        if (removeKey != -1) {
            searchList.remove(removeKey);
        }
    }

    public static void main(String args[]) {
        HashMapList<String, Integer> test = new HashMapList();
        test.put("Nafay", 13);
        test.put("Azhar", 25);
        test.put("Fatima", 13);
        test.put("Ammi", 5);
        HashMapList<String, Integer>.Iterator<String, Integer> firstIter = test.new Iterator<String, Integer>();
        while(firstIter.hasNext()) {
            System.out.print("********");
            System.out.println(firstIter.next());
            System.out.print("********");
        }
        System.out.println(test.get("Nafay"));
        System.out.println(test.get("Azhar"));
        test.remove("Azhar");
        System.out.println(test.get("Nafay"));


//        HashMapList<String, String> test2 = new HashMapList();
//        test2.put("Nafay", "Soccer");
//        test2.put("Azhar", "Cricket");
//        System.out.println(test2.get("Nafay"));
//        System.out.println(test2.get("Azhar"));
//        test2.remove("Azhar");
//        System.out.println(test2.get("Nafay"));
//        System.out.println(test2.get("Azhar"));
//
//        HashMapList<Integer, Boolean> test3 = new HashMapList();
//        test3.put(14, true);
//        test3.put(25, false);
//        System.out.println(test3.get(14));
//        System.out.println(test3.get(25));
//        test3.remove(14);
//        System.out.println(test3.get(14));
//        System.out.println(test3.get(25));
    }



}