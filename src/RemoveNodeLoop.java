import java.util.IdentityHashMap;

public class RemoveNodeLoop {

    public Node detectAndRemoveLoop(Node source) {
        Node head = source;
        IdentityHashMap<Node, Integer> visited = new IdentityHashMap<>();
        visited.put(source, 0);
        while(source != null) {
            if(visited.get(source.next) == null) {
                visited.put(source.next, 0);
            } else {
                source.next = null;
            }
            source = source.next;
        }
        return head;
    }

    public void printAll(Node source) {
        while(source != null) {
            System.out.print(source.item);
            System.out.println("*******");
            source = source.next;
        }
    }

    public static void main(String[] args) {
        RemoveNodeLoop removeLoop = new RemoveNodeLoop();

        Node first = new Node();
        first.item = 1;

        Node second = new Node();
        second.item = 2;

        Node third = new Node();
        third.item = 3;

        Node fourth = new Node();
        fourth.item = 4;

        Node fifth = new Node();
        fifth.item = 5;

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        removeLoop.printAll(removeLoop.detectAndRemoveLoop(first));

    }
}
