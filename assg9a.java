import java.util.Scanner;

public class _123B5B292_shweta_jadhav_assg9a {

    class Node {
        String name;
        long phoneNumber;
        long numberOfPeople;
        int waitNumber;
        Node next;

        
        public Node(String name, long PhoneNumber, int numberOfPeople) {
            this.name = name;
            this.phoneNumber = PhoneNumber;
            this.numberOfPeople = numberOfPeople;
            this.next = null;
        }
    }

   
    public class Waitlist {
        private Node front, rear;
        private int waitNumberCounter;

       
        public Waitlist() {
            front = rear = null;
            waitNumberCounter = 1;
        }

        
        public void addParty(String name, long phoneNumber, int numberOfPeople) {
            Node nn = new Node(name, phoneNumber, numberOfPeople);
            nn.waitNumber = waitNumberCounter++; 

            if (front == null) {
                front = rear = nn; 
            } else {
                rear.next = nn;
                rear = nn; 
            }

            System.out.println("Party " + name + " added to the waiting list with waiting number " + nn.waitNumber);
        }

        
        public void SeatParty() {
            if (front == null) {
                System.out.println("There is no party on the waiting list. ");
            } else {
                System.out.println("Number of seats: " + front.name + " (waiting number: " + front.waitNumber + ")");
                front = front.next; 
            }
            
            Node temp = front;
            int newWaitNumber = 1; 
            while (temp != null) {
                temp.waitNumber = newWaitNumber++;
                temp = temp.next;
            }

            waitNumberCounter = newWaitNumber;
        } 

        
        public void displayWaitlist() {
            if (front == null) {
                System.out.println("The waiting list is now empty.");
            } else {
                Node temp = front;
                System.out.println("The waiting list is now :");
                while (temp != null) {
                    System.out.println("waiting number: " + temp.waitNumber + ", Name: " + temp.name + ", Phone: "
                            + temp.phoneNumber + " , People: " + temp.numberOfPeople);
                    temp = temp.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        _123B5B292_shweta_jadhav_assg9a app = new _123B5B292_shweta_jadhav_assg9a(); 
        Waitlist waitlist = app.new Waitlist();
        int choice;

        do {
            System.out.println("\nRestaurant Waiting List System:");
            System.out.println("1. Add people to waiting list");
            System.out.println("2. Seat queue");
            System.out.println("3. View waiting list");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice:");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Please enter the party name: ");
                    String name = sc.nextLine();
                    System.out.print("Please enter the phone number:");
                    long PhoneNumber = sc.nextLong();
                    System.out.print("Please enter the number of people :");
                    int numberOfPeople = sc.nextInt();
                    waitlist.addParty(name, PhoneNumber, numberOfPeople);
                    break;
                case 2:
                    waitlist.SeatParty();
                case 3:
                    waitlist.displayWaitlist();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection! Please try again. ");

            }

        } while (choice != 4);
        sc.close();
    }

}
