import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

class HashMapList {
    private ArrayList<ArrayList<Pair<String, Integer>>> hashList = new  ArrayList<ArrayList<Pair<String, Integer>>>(Collections.nCopies(100,null));

    private int getHash(String k) {
        return k.length() % 100;
    }

    public Integer get(String k) {
        int hashKey = getHash(k);
        ArrayList<Pair<String, Integer>> searchList = hashList.get(hashKey);
        for (int i = 0; i < searchList.size(); ++i) {
            Pair<String, Integer> item = searchList.get(i);
                return item.get(k);
        }
        return 0;
    }

    public void put(String k, Integer v) {
        int hashKey = getHash(k);
        if (hashList.get(hashKey) != null) {
            hashList.get(hashKey).add(new Pair(k, v));
        } else {
            ArrayList<Pair<String, Integer>> newList = new ArrayList<Pair<String, Integer>>();
            newList.add(new Pair(k, v));
            hashList.set(hashKey, newList);
        }

    }

    public void remove(String k) {
        Integer hashKey = getHash(k);
        ArrayList<Pair<String, Integer>> searchList = hashList.get(hashKey);
        int removeKey = -1;
        for (int i = 0; i < searchList.size(); ++i) {
            Pair<String, Integer> item = searchList.get(i);
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
        System.out.println("Hello World");
        HashMapList test = new HashMapList();
        test.put("Nafay", 13);
        test.put("Fatima", 13);
        test.put("Ammi", 5);
        System.out.println(test.get("Nafay"));
        System.out.println(test.get("Fatima"));
        test.remove("Fatima");
        System.out.println(test.get("Fatima"));
    }



}