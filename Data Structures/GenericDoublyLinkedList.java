//Written by Burakhan Ünver | 27.10.2020

//Main linkedlist class
public class GenericDoublyLinkedList<T> {
    //Generic node class for list
    public class Node<T> {
        Node<T> prev;
        Node<T> next;
        T value;

        Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }

    //head node
    private Node<T> head;

    //constructor
    public GenericDoublyLinkedList() {
        this.head = null;
    }

    //getter
    public Node<T> getHead() {
        return head;
    }

    //Adds a node from given value at the start of the list
    public void addFirst(T value) {
        if (head == null) {
            head = new Node<T>(value);
        } else {
            var newNode = new Node<T>(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
    }

    //Adds a node from given value at the end of the list
    public void addLast(T value) {
        if (head == null) {
            head = new Node<T>(value);
        } else {
            var temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<T>(value);
            temp.next.prev = temp;
        }
    }

    //returns size of list
    public int count() {
        int num = 0;
        var temp = head;
        while (temp != null) {
            temp = temp.next;
            num++;
        }
        return num;
    }

    //prints list in one line
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            var temp = head;

            while (temp != null) {
                System.out.print("->" + temp.value);
                temp = temp.next;
            }
        }
    }

    //it is same as addFirst(), but with different name for make things easy
    public void push(T value) {
        addLast(value);
    }

    //prints list with links of each node
    public void printWithLinks() {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            var temp = head;
            while (temp != null) {
                if (temp.prev == null && temp.next == null) {
                    System.out.println("Value : " + temp.value + ", Prev : none, next : none");
                } else if (temp.prev == null) {
                    System.out.println("Value : " + temp.value + ", Prev : none, next : " + temp.next.value);
                } else if (temp.next == null) {
                    System.out.println("Value : " + temp.value + ", Prev : " + temp.prev.value + ", next : none ");
                } else {
                    System.out.println("Value : " + temp.value + ", Prev : " + temp.prev.value + ", next : " + temp.next.value);

                }
                temp = temp.next;
            }
        }
    }

    //removes a node at given index
    public void removeAtIndex(int index) {
        if (head == null) {
            throw new Error("List is empty");
        } else if (index < 0 || index > count() - 1) {
            throw new Error("Out of index");
        } else {
            var temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            if (temp.prev == null && temp.next == null) {
                head = null;
            } else if (temp.next == null) {
                temp.prev.next = null;
            } else if (temp.prev == null) {
                head = head.next;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }


        }
    }

    //removes last node, return it's value
    public T pop() {
        if (head == null)
            throw new Error("List is empty");
        else {
            var temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            T value = temp.value;
            temp.prev.next = null;


            return value;
        }
    }

    //removes the head node
    public void removeHead(){
        if (head == null){
            throw new Error("List is empty");
        }
        else if(head.next == null){
            head = null;
        }
        else{
            head = head.next;
        }
    }

    //returns index of node by given value
    public T get(int index){
        if(head == null)
            throw new Error("List is empty");
        else if(index < 0 || index > count()-1)
            throw new Error("Out of index");
        else{
            var temp = head;
            for(int i = 0 ; i<index ; i++)
                temp = temp.next;
            return temp.value;
        }
    }

    //returns value of node by given index
    public int get_index(T value){
        if(head == null)
            throw new Error("List is empty");
        else{
            var temp = head;
            int index = 0;
            for(int i = 0 ; i<count(); i++) {
                if (temp.value == value)
                    return index;
                index++;
                temp = temp.next;
            }

        }
        return -1;
    }
}
