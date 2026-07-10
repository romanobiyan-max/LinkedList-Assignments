package linkedlistassignments;

public class Assignment2DoublyLinkedListInsertion {

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
    private Node tail;

    // Inserts at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(data + " was inserted at the beginning.");
    }

    // Inserts at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println(data + " was inserted at the end.");
    }

    // Inserts after a given node
    public void insertAfter(int target, int data) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = current;
        newNode.next = current.next;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;

        System.out.println(data + " was inserted after " + target + ".");
    }

    // Inserts before a given node
    public void insertBefore(int target, int data) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }

        if (current == head) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = current;
        newNode.prev = current.prev;

        current.prev.next = newNode;
        current.prev = newNode;

        System.out.println(data + " was inserted before " + target + ".");
    }

    // Inserts at a specific position
    public void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Position must be 1 or greater.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current == tail) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = current.next;
        newNode.prev = current;

        current.next.prev = newNode;
        current.next = newNode;

        System.out.println(data + " was inserted at position " + position + ".");
    }

    private Node findNode(int target) {
        Node current = head;

        while (current != null) {
            if (current.data == target) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public void displayForward() {
        Node current = head;

        System.out.print("Forward  : ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public void displayBackward() {
        Node current = tail;

        System.out.print("Backward : ");

        while (current != null) {
            System.out.print(current.data);

            if (current.prev != null) {
                System.out.print(" <-> ");
            }

            current = current.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Assignment2DoublyLinkedListInsertion list =
                new Assignment2DoublyLinkedListInsertion();

        System.out.println("=== DOUBLY LINKED LIST INSERTION ===");

        System.out.println("\n1. Creating the initial linked list");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.displayForward();
        list.displayBackward();

        System.out.println("\n2. Insertion at the beginning");
        list.insertAtBeginning(5);
        list.displayForward();

        System.out.println("\n3. Insertion at the end");
        list.insertAtEnd(40);
        list.displayForward();

        System.out.println("\n4. Insertion after a given node");
        list.insertAfter(20, 25);
        list.displayForward();

        System.out.println("\n5. Insertion before a given node");
        list.insertBefore(30, 28);
        list.displayForward();

        System.out.println("\n6. Insertion at a specific position");
        list.insertAtPosition(3, 15);
        list.displayForward();

        System.out.println("\n7. Final linked list");
        list.displayForward();
        list.displayBackward();
    }
}