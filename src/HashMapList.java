import java.util.*;

class HashMapList<T, U> {
    private ArrayList<ArrayList<Pair<T, U>>> hashList = new  ArrayList<>(Collections.nCopies(100,null));
    private int hashCount = 0;
    private Node order;

    private int getHash(T k) {
        return k.toString().length() % 100;
    }

    private void insertOrder(T k) {
        Node newItem = new Node();
        newItem.item = k;
        if (order == null) {
            order = newItem;
        } else {
            Node temp = order;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    public class Iterator<T, U> {
        private ArrayList<Pair<T, U>> iterList = new ArrayList<>();
        private int iter;
        private int iterHashCount = 0;

        private ArrayList randomHead() {
            // how do I check if the hashMap is not null or at least there is one insertion in place
            Random rand = new Random();
            int pick = rand.nextInt(100);
            return hashList.get(pick) != null ? hashList.get(pick) : randomHead();
        }

        Iterator() {
           iterList = randomHead();
           iter = -1;
           iterHashCount = hashCount;
        }

        public boolean hasNext() {
            if (iterHashCount != hashCount)
            {
                throw new ConcurrentModificationException("Failed as iterator has changed");
            }
            int nextIndex = iter + 1;
            if (iterList.size() > nextIndex) {
                return iterList.get(nextIndex) != null;
            }
            return false;
        }

        public U next() {
            if (iterHashCount != hashCount)
            {
                throw new ConcurrentModificationException("Failed as iterator has changed");
            }
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
        insertOrder(k);
        ++hashCount;
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
        test.put("John", 6);
        try
        {
            while (firstIter.hasNext()) {
                System.out.print("********");
                System.out.println(firstIter.next());
                System.out.print("********");
            }
        }

        catch (ConcurrentModificationException e)
        {
            System.out.println("Concurrent Modification exception was thrown");
        }
        HashMapList<String, Integer>.Iterator<String, Integer> secondIter = test.new Iterator<String, Integer>();
        while(secondIter.hasNext()) {
            System.out.print("********Second*********");
            System.out.println(secondIter.next());
            System.out.print("********");
        }

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