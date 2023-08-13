public class CircularLinkedList<T>{
    private class Node{
        T data;
        Node Next;

        Node(T data){
            this.data = data;
            this.Next = null;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node head;

    public CircularLinkedList(){
        head = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public int count(){
        if (isEmpty())
            return 0;

        int total = 0;
        Node temp = head;

        do{
            total++;
            temp = temp.Next;
        }while(temp != head);

        return total;
    }

    public void push(T data){
        Node newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
            head.Next = head;
            return;
        }

        Node temp = head;

        do{
            temp = temp.Next;
        }while(temp.Next != head);

        temp.Next = newNode;
        newNode.Next = head;
    }

    public T pop(){
        if (isEmpty())
            return null;
        
        T dataToReturn;
        if (head.Next == head){
            dataToReturn = head.data;
            head = null;
        }
        else{
            Node temp = head, prev = null;

            do{
                prev = temp;
                temp = temp.Next;
            }while(temp.Next != head);

            dataToReturn = temp.data;
            prev.Next = head;
        }

        return dataToReturn;
    }

    public void insert(int index, T data){
        int totalItems = count();
        if (isEmpty() || index < 0 || index >= totalItems)
            throw new IndexOutOfBoundsException(index);
        
        Node newNode = new Node(data), temp = head;
        if (index == 0){
            newNode.Next = head;

            do{
                temp = temp.Next;
            }while(temp.Next != head);

            head = newNode;
            temp.Next = head;

        }
        else{
            Node prev = null;
            for(int i = 0; i < index; i++){
                prev = temp;
                temp = temp.Next;
            }
            prev.Next = newNode;
            newNode.Next = temp;
        }
    }

    public T remove(int index){
        int totalItems = count();
        if (isEmpty() || index < 0 || index >= totalItems)
            throw new IndexOutOfBoundsException(index);
        
        T dataToReturn;
        Node temp = head;
        if (index == 0){
            dataToReturn = head.data;
            if (head.Next == head){
                head = null;
            }
            else{
                do{
                    temp = temp.Next;
                }while (temp.Next != head);
                head = head.Next;
                temp.Next = head;
            }
        }
        else{
            Node prev = null;
            for(int i = 0; i < index; i++){
                prev = temp;
                temp = temp.Next;
            }
            prev.Next = temp.Next;
            dataToReturn = temp.data;
        }

        return dataToReturn;
    }

    public void reverse(){
        if (isEmpty())
            return;
    
        CircularLinkedList<T> newList = new CircularLinkedList<>();
        while(!isEmpty()){
            newList.push(this.pop());
        }

        this.head = newList.head;
    }

    public String toString(){
        if (isEmpty())
            return "List is Empty";
        
        StringBuilder str = new StringBuilder();
        Node temp = head;

        do{
            str.append(temp.data);
            if (temp.Next != head)
                str.append(" --> ");
            temp = temp.Next;

        }while(temp != head);

        return str.toString();
    }
}