public class Runner {
    public static void main(String[] args) {
        // SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
        // lst.push(7);
        // lst.push(8);
        // lst.push(1);
        // lst.push(9);
        // lst.push(2);

        // System.out.println(lst);
        // lst.reverse();
        // System.out.println(lst);


        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.push(1);
        System.out.println(list);

        list.push(2);
        System.out.println(list);

        list.push(3);
        System.out.println(list);

        list.push(5);
        System.out.println(list);

        System.out.println("popped item: " + list.pop());
        System.out.println(list);

        list.insert(0, 0);
        System.out.println(list);

        list.insert(2, -1);
        System.out.println(list);

        list.insert(4, -2);
        System.out.println(list);

        System.out.println("item removed: " + list.remove(0));
        System.out.println(list);

        System.out.println("item removed: " + list.remove(1));
        System.out.println(list);

        System.out.println("item removed: " + list.remove(3));
        System.out.println(list);

        list.reverse();
        System.out.println(list);
    }   
}
