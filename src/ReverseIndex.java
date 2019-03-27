public class ReverseIndex {

    public Node reverse(Node source) {
        Node target = null;
        while(source != null) {
            Node temp = new Node();
            temp.item = source.item;
            temp.next = target;
            target = temp;
            source = source.next;
        }
        return target;
    }

    public Node reverseIndex(Node src, Node dest, int position) {
        if (src == null) {
            return dest;
        }
        if (position == 0) { return src; }
        Node head = dest;
        Node target = new Node();
        target.item = src.item;
        Node top = target;
        src = src.next;
        Node iter = src;
        int i = position - 1;
        while (iter != null && i > 0) {

            target.next = new Node();
            target = target.next;
            target.item = iter.item;
            iter = iter.next;
            -- i;
        }
        System.out.println(dest != null);
        Node temp = head;
        if (head != null) {
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = reverse(top);
        } else {
            head = reverse(top);
        }

        return reverseIndex(iter, head, position);
    }

    public void printAll(Node source) {
        while(source != null) {
            System.out.print(source.item);
            System.out.println("*******");
            source = source.next;
        }
    }

    public static void main(String[] args) {

        ReverseIndex testReverse = new ReverseIndex();

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
        fifth.next = null;
        testReverse.printAll(testReverse.reverseIndex(first, null, 3));
        testReverse.printAll(testReverse.reverseIndex(first, null, 5));

    }
}
