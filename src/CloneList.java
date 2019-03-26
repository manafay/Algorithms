import java.util.IdentityHashMap;

public class CloneList {

    public Node cloneANode(Node source) {
        if (source == null) return null;
        Node result = new Node();
        result.item = source.item;
        Node target = result;
        Node top = source;

        while(top.next != null) {
            result.next = new Node();
            result = result.next;
            top  = top.next;
            result.item = top.item;
        }
        result.next = null;
        IdentityHashMap<Node, Node> pair = new IdentityHashMap<>();
        top = source;
        Node temp = target;
        while(top != null) {
            pair.put(top, temp);
            top = top.next;
            temp = temp.next;
        }
       Node n = source;
        Node finalResult = target;
        while (n != null) {
           Node first =  pair.get(n.randomNext);
           finalResult.randomNext = first;
           finalResult = finalResult.next;
           n = n.next;
        }

        return target;
    }

    public void printAll(Node source) {
        while(source != null) {
            System.out.print(source.item);
            System.out.print((source.next == null) ? "null" : source.next.item);
            System.out.print((source.randomNext == null) ? "null" : source.randomNext.item);
            System.out.println("*******");
            source = source.next;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CloneList test = new CloneList();
        Node first = new Node();
        first.item = 1;

        Node second = new Node();
        second.item = 2;

        Node third = new Node();
        third.item = 9;

        Node fourth = new Node();
        fourth.item = 7;

        Node fifth = new Node();
        fifth.item = 11;

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        first.randomNext = third;
        second.randomNext = fifth;
        third.randomNext = first;
        fourth.randomNext = second;

        test.printAll(first);
        test.printAll(test.cloneANode(first));

    }
}
