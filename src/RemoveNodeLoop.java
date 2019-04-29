import java.util.IdentityHashMap;

public class RemoveNodeLoop {

    public static class NodeVisited {
        int item;
        int visit;
        NodeVisited next;

        public NodeVisited() {
            visit = 0;
        }
    }

    // with using extra memory
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


    // without using extra memory
    public Node removeAndDetectLoop(Node source) {
        Node top = source;
        Node twoSteps = source;
        int i = 0;
        while(source != null) {
            if (source.item == twoSteps.item && i > 0) {
                source.next = null;
                break;
            }
            twoSteps = twoSteps.next.next;
            source = source.next;
            ++i;
        }
        return top;
    }

    public void printAll(Node source) {
        while(source != null) {
            System.out.print(source.item);
            System.out.print(" -> ");
            source = source.next;
        }
        System.out.print("null");
    }

    public void printAllVertices(NodeVisited source) {
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

        NodeVisited firstv = new NodeVisited();
        firstv.item = 1;

        NodeVisited secondv = new NodeVisited();
        secondv.item = 2;

        NodeVisited thirdv = new NodeVisited();
        thirdv.item = 3;

        NodeVisited fourthv = new NodeVisited();
        fourthv.item = 4;

        NodeVisited fifthv = new NodeVisited();
        fifthv.item = 5;

        firstv.next = secondv;
        secondv.next = thirdv;
        thirdv.next = fourthv;
        fourthv.next = fifthv;
        fifthv.next = secondv;
//        System.out.println("With using Extra memory. That is, Identity hash map");
//        removeLoop.printAll(removeLoop.detectAndRemoveLoop(first));
        System.out.println("Without using Extra memory. That is, by adding a visit parameter in the node class");
        removeLoop.printAll(removeLoop.removeAndDetectLoop(first));
    }
}
