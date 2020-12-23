public class LinkedL {


    private NodeL head;
    private NodeL tail;

    public NodeL getHead() {
        return head;
    }

    public int count() {
        NodeL temp = head;
        int count = 0;
        if (head == null)
            return 0;
        else {

            while (temp != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }

    }

    public void addFirst(int x) {
        NodeL newNode = new NodeL(x);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    public void printList() {
        if (head == null)
            System.out.println("List is empty");
        else {
            NodeL temp = head;

            while (temp != null) {
                System.out.print("-" + temp.data);
                temp = temp.next;
            }
            System.out.println("");
        }
    }

    public void addLast(int x) {
        NodeL newNode = new NodeL(x);


        if (head == null) {
            head = newNode;
        } else {
            NodeL temp = head;

            while (temp.next != null) {
                temp = temp.next;

            }

            temp.next = newNode;

        }
    }

    public void addAtIndex(int value, int index) {
        NodeL newNode = new NodeL(value);

        if (head == null)
            head = newNode;
        else {
            int current = 1;
            NodeL temp = head;

            if (count() >= index) {
                while (current < index) {
                    temp = temp.next;
                    current++;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("End of list");
            }

        }

    }

    public void removeHead() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("Error, list is empty");
        }


    }

    public NodeL getTail() {
        NodeL temp = head;
        if (temp == null) {
            System.out.println("Error, list is empty");
            return null;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            tail = temp;
            return tail;
        }
    }

    public void removeLast() {
        if (head == null)
            System.out.println("Error, list is empty");
        else {
            NodeL temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

        }
    }

    public void removeAtIndex(int index) {
        if (head == null)
            System.out.println("Error, list is empty");
        else {
            NodeL temp = head;
            int current = 1;
            if (count() > index) {
                if (index == 0) {
                    head = head.next;
                } else {
                    while (current < index) {
                        temp = temp.next;
                        current++;
                    }
                    temp.next = temp.next.next;
                }
            } else {
                System.out.println("Index is bigger than list count");
            }
        }
    }

    public void removeValue(int value){
        if (head == null)
            System.out.println("List is empty");
        else{

            if(head.data == value)
                head = head.next;
            else {
                NodeL temp = head;
                while(temp.next.data != value){
                    temp = temp.next;

                }
                temp.next = temp.next.next;
            }
        }
    }

    public void addNodeAtLast(NodeL newNode){
        if (head == null)
            head = newNode;
        else{
            NodeL temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


}
