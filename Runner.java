public class Runner {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
        lst.push(7);
        lst.push(8);
        lst.push(1);
        lst.push(9);
        lst.push(2);

        System.out.println(lst);
        lst.reverse();
        System.out.println(lst);
    }
    
}
