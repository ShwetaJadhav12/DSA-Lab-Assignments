import java.util.Scanner;

public class _123B5B292_shweta_jadhav_assg9b {

    static class Customer {
        String name;
        long phoneNumber;
        int waitingNumber;

        public Customer(String name, long phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    static class CheckoutQueue {
        private Customer[] queue;
        private int front, rear, size;
        private static final int MAX_SIZE = 10; // Maximum size of the queue
        private int waitNumberCounter = 1;

        public CheckoutQueue() {
            queue = new Customer[MAX_SIZE];
            front = rear = -1;
            size = 0;
        }

        public void enqueue(String name, long phoneNumber) {
            if (size == MAX_SIZE) {
                System.out.println("Queue is full. Cannot add more customers.");
                return;
            }

            Customer newCustomer = new Customer(name, phoneNumber);
            newCustomer.waitingNumber = waitNumberCounter++;

            if (rear == -1) { // If the queue is empty
                front = rear = 0;
            } else {
                rear = (rear + 1) % MAX_SIZE; // Circular queue
            }
            queue[rear] = newCustomer;
            size++;

            System.out.println("Customer " + name + " added to the queue with waiting number: " + newCustomer.waitingNumber);
        }

        public void dequeue() {
            if (size == 0) {
                System.out.println("No customers in the queue.");
                return;
            }

            Customer customer = queue[front];
            System.out.println("Customer " + customer.name + " with waiting number " + customer.waitingNumber + " has checked out.");
            front = (front + 1) % MAX_SIZE; // Circular queue
            size--;

            adjustWaitingNumbers();
        }

        private void adjustWaitingNumbers() {
            if (size == 0) {
                return;
            }

            int waitingNumber = 1;
            for (int i = front; i != rear; i = (i + 1) % MAX_SIZE) {
                queue[i].waitingNumber = waitingNumber++;
            }
            queue[rear].waitingNumber = waitingNumber;
        }

        public void viewQueue() {
            if (size == 0) {
                System.out.println("The queue is empty.");
                return;
            }

            System.out.println("Customers in the queue:");
            for (int i = front; i != rear; i = (i + 1) % MAX_SIZE) {
                System.out.println("Waiting Number: " + queue[i].waitingNumber + ", Name: " + queue[i].name + ", Phone: " + queue[i].phoneNumber);
            }
            System.out.println("Waiting Number: " + queue[rear].waitingNumber + ", Name: " + queue[rear].name + ", Phone: " + queue[rear].phoneNumber);
        }

        public void closeCounter() {
            if (size == 0) {
                System.out.println("Checkout counter is already closed. No customers in the queue.");
            } else {
                System.out.println("Closing checkout counter. Remaining customers in the queue:");
                viewQueue();
                front = rear = -1;
                size = 0;
                System.out.println("Checkout counter closed.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckoutQueue queue = new CheckoutQueue();
        int choice;

        do {
            System.out.println("\nSupermarket Checkout System:");
            System.out.println("1. Customer Arrival");
            System.out.println("2. Customer Checkout");
            System.out.println("3. Close Checkout Counter");
            System.out.println("4. View Customers");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer phone number: ");
                    long phoneNumber = scanner.nextLong();
                    queue.enqueue(name, phoneNumber);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.closeCounter();
                    break;

                case 4:
                    queue.viewQueue();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
