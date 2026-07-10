package linkedlistassignments;

public class Assignment1CircularDoublyLinkedList {

    // Represents one node
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    // Checks whether the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Inserts a new node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

            // A single node points to itself
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
        }

        System.out.println(data + " was inserted at the beginning.");
    }

    // Inserts a new node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }

        System.out.println(data + " was inserted at the end.");
    }

    // Deletes a node based on its value
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node current = head;

        do {
            if (current.data == data) {
                break;
            }

            current = current.next;

        } while (current != head);

        if (current.data != data) {
            System.out.println(data + " was not found.");
            return;
        }

        // If there is only one node
        if (current.next == current) {
            head = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;

            if (current == head) {
                head = current.next;
            }
        }

        System.out.println(data + " was deleted.");
    }

    // Displays the linked list from head to the last node
    public void displayForward() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node current = head;

        System.out.print("Forward  : ");

        do {
            System.out.print(current.data);
            current = current.next;

            if (current != head) {
                System.out.print(" <-> ");
            }

        } while (current != head);

        System.out.println(" -> back to HEAD");
    }

    // Displays the linked list from the last node to the head
    public void displayBackward() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node last = head.prev;
        Node current = last;

        System.out.print("Backward : ");

        do {
            System.out.print(current.data);
            current = current.prev;

            if (current != last) {
                System.out.print(" <-> ");
            }

        } while (current != last);

        System.out.println(" -> back to the last node");
    }

    // Proves that the linked list is circular
    public void showCircularConnection() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node last = head.prev;

        System.out.println("Head                  : " + head.data);
        System.out.println("Last node             : " + last.data);
        System.out.println("Next of last node     : " + last.next.data);
        System.out.println("Previous of the head  : " + head.prev.data);
    }

    public static void main(String[] args) {
        Assignment1CircularDoublyLinkedList list =
                new Assignment1CircularDoublyLinkedList();

        System.out.println("=== CIRCULAR DOUBLY LINKED LIST ===");

        System.out.println("\n1. Inserting data at the end");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("\nInitial linked list:");
        list.displayForward();
        list.displayBackward();

        System.out.println("\n2. Inserting 5 at the beginning");
        list.insertAtBeginning(5);

        System.out.println("\nLinked list after insertion:");
        list.displayForward();
        list.displayBackward();

        System.out.println("\n3. Deleting 20");
        list.deleteNode(20);

        System.out.println("\nLinked list after deletion:");
        list.displayForward();
        list.displayBackward();

        System.out.println("\n4. Proving the circular connection");
        list.showCircularConnection();
    }
}