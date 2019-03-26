public class ReverseIndex {

    public Node reverse(Node source) {
        Node target = new Node();
        target.item = source.item;
        source = source.next;
        while(source != null) {
            Node temp = new Node();
            temp.item = source.item;
            temp.next = target;
            target = temp;
            source = source.next;
        }
        return target;
    }

    public Node reverseIndex(Node src, int position) {
        if (src == null) { return null; }
        if (position == 0) { return src; }
        Node target = new Node();
        int i = 0;
        while (i < position) {

        }


        return new Node();
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

        testReverse.printAll(testReverse.reverse(first));


    }
}
