package linkedlistassignments;

public class Assignment3DoublyLinkedListDeletion {

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

    // Used to create the initial linked list
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
    }

    // Deletes the first node
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        int deletedData = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println(deletedData + " was deleted from the beginning.");
    }

    // Deletes the last node
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        int deletedData = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println(deletedData + " was deleted from the end.");
    }

    // Deletes the node after a given node
    public void deleteAfter(int target) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }

        if (current.next == null) {
            System.out.println("There is no node after " + target + ".");
            return;
        }

        Node nodeToDelete = current.next;
        int deletedData = nodeToDelete.data;

        current.next = nodeToDelete.next;

        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = current;
        } else {
            tail = current;
        }

        System.out.println(deletedData + " after " + target + " was deleted.");
    }

    // Deletes the node before a given node
    public void deleteBefore(int target) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }

        if (current.prev == null) {
            System.out.println("There is no node before " + target + ".");
            return;
        }

        Node nodeToDelete = current.prev;
        int deletedData = nodeToDelete.data;

        if (nodeToDelete == head) {
            head = current;
            current.prev = null;
        } else {
            nodeToDelete.prev.next = current;
            current.prev = nodeToDelete.prev;
        }

        System.out.println(deletedData + " before " + target + " was deleted.");
    }

    // Deletes a node at a specific position
    public void deleteAtPosition(int position) {
        if (position < 1) {
            System.out.println("Position must be 1 or greater.");
            return;
        }

        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        if (position == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        int deletedData = current.data;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        System.out.println(
                deletedData + " at position " + position + " was deleted.");
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
        Assignment3DoublyLinkedListDeletion list =
                new Assignment3DoublyLinkedListDeletion();

        System.out.println("=== DOUBLY LINKED LIST DELETION ===");

        System.out.println("\n1. Creating the initial linked list");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtEnd(70);
        list.insertAtEnd(80);

        list.displayForward();
        list.displayBackward();

        System.out.println("\n2. Deletion at the beginning");
        list.deleteAtBeginning();
        list.displayForward();

        System.out.println("\n3. Deletion at the end");
        list.deleteAtEnd();
        list.displayForward();

        System.out.println("\n4. Deletion after a given node");
        list.deleteAfter(30);
        list.displayForward();

        System.out.println("\n5. Deletion before a given node");
        list.deleteBefore(70);
        list.displayForward();

        System.out.println("\n6. Deletion at a specific position");
        list.deleteAtPosition(2);
        list.displayForward();

        System.out.println("\n7. Final linked list");
        list.displayForward();
        list.displayBackward();
    }
}