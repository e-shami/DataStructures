public class SinglyLinkedList<T> {
    private class Node {
        T data;
        Node Next;

        Node(T data) {
            this.data = data;
            this.Next = null;
        }

        boolean isNextNUll() {
            return this.Next == null;
        }

        // boolean equals(Node other) {
        //     return this.data == other.data;
        // }

        public String toString() {
            return this.data.toString();
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public int count() {
        if (isEmpty())
            return 0;

        int total = 0;

        Node temp = head;
        do {
            total++;
            temp = temp.Next;

        } while (temp != null);

        return total;
    }

    public void push(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (!temp.isNextNUll()) {
                temp = temp.Next;
            }
            temp.Next = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T dataToReturn;

        if (head.isNextNUll()) {
            dataToReturn = head.data;
            head.Next = null;
        } else {
            Node temp = head, prev = null;

            while (!temp.isNextNUll()) {
                prev = temp;
                temp = temp.Next;
            }

            prev.Next = null;
            dataToReturn = temp.data;
        }
        return dataToReturn;
    }

    public void insert(int index, T data) {
        int totalItems = count();
        if (isEmpty() || index < 0 || index >= totalItems) {
            throw new IndexOutOfBoundsException(index);
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.Next = head;
            head = newNode;
            return;
        }

        Node temp = head, saved = null;

        for (int i = 0; i < index; i++) {
            saved = temp;
            temp = temp.Next;
        }
        saved.Next = newNode;
        newNode.Next = temp;
    }

    public T remove(int index){
        int totalItems = count();
        if (index < 0 || index >= totalItems)
            throw new IndexOutOfBoundsException(index);
        
        T dataToReturn;
        if (index == 0){
            dataToReturn = head.data;
            head = head.Next;
        }

        else{
            Node temp = head, saved = null; 
            for (int i = 0; i < index; i++){
                saved = temp;
                temp = temp.Next;
            }
            dataToReturn = temp.data;
            saved.Next = temp.Next;
        }

        return dataToReturn;
    }

    public void reverse(){
        int iterations = count();

        Node reversed = null;

        for(int i = 0; i < iterations; i++){
            Node temp = head;
            for(int k = 0; k < iterations-i-1; k++){
                temp = temp.Next;
            }

            if (temp.isNextNUll()){
                reversed = new Node(temp.data);
            }
            else{
                Node reverseTemp = reversed;
                while(!reverseTemp.isNextNUll()){
                    reverseTemp = reverseTemp.Next;
                }
                reverseTemp.Next = new Node(temp.data);
            }
        }

        head = reversed;
    }

    public String toString() {
        if (isEmpty()){
            return "List is Empty";
        }


        StringBuilder str = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            str.append(temp);

            if (!temp.isNextNUll())
                str.append(" --> ");

            temp = temp.Next;
        }

        return str.toString();
    }
}