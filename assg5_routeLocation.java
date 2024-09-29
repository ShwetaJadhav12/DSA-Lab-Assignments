public class _123B5B292_Shweta_Jadhav_assg5 {
    public static class Route{
        private String location;
        Route next;
        Route(String location){
            this.location=location;
            this.next=null;
        }
        public String getLocation() {
            return location;
        }
    }
    public static class Order{
        private Route head;
        int count;
        Order(){
            head=null;
            this.count=0;
        }
        // adding location ata starting
        public void addAtStart(String location){
            Route nn=new Route(location);
            if(head==null){
                head=nn;
                nn.next=head;
                count++;
                return;
            }
            Route current =head;
            while(current.next!=head){
                current=current.next;
            }
            current.next=nn;
            nn.next=head;
            head=nn;
            count++;
            return;
        }
        // adding location at end
        public void addAtEnd(String location) {
            Route nn = new Route(location);
            if (head == null) {
                head = nn;
                nn.next = head; 
                count++;
                return;// Point to itself
            } 
                Route current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = nn; // Last route points to the new node
                nn.next = head; // New node points to head
            
            count++;
            return;
        }
        // counting total number of locations
        public int count(){
            return count;
        }
        // displaying entire list
        public void printRoutes() {
            if (head == null) {
                System.out.println("No routes available.");
                return;
            }
            Route current = head;
            do {
                System.out.print(current.getLocation()+" "); // Use getter for location
                current = current.next;
            } while (current != head);
            System.out.println();
        }
        // adding location in between
        public void insertInBetween(int idx,String location){
            if (idx < 0 || idx > count) {
                System.out.println("Index out of bounds.");
                return;
            }
            Route nn=new Route(location);
            if (idx == 0) {
                addAtStart(location);
                return;
            }
            if(head==null){
                addAtEnd(location);
                return;
            }
            Route temp=head;
            if(idx<=count){
                for(int i=0;i<idx;i++){
                    temp=temp.next;
                }
                
                nn.next=temp.next;
                temp.next=nn;
                count++;
                return;
            }

        }
        // deteing first location
        public void deleteAtStar(){
            if(head==null){
                System.out.println("list odf location is already empty");
                return;
            }
            Route temp=head;
            
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=head.next;
            head=head.next;
            count--;
            return;
        }
        // deleting last location
        public void deleteAtEnd(){
            if(head==null){
                System.out.println("list odf location is already empty");
                return;
            }
            if(head.next==head){
                head=null;
                System.out.println("list has been deleted");
                count--;
                return;
            }
            Route temp=head;
            while(temp.next.next!=head){
                temp=temp.next;
            }
            temp.next=head;
            count--;
            return;


        }
        // deleting all locations
        public void deleteAll(){
            head=null;
            count=0;
        }
        // searching and deleting loaction
        public void searchDelete(String location) {
            if (head == null) {
                System.out.println("List of locations is already empty.");
                return;
            }
        
            Route current = head;
            Route previous = null;
            do {
                if (current.getLocation().equals(location)) {
                    if (previous == null) {                      
                        if (current.next == head) {
                            head = null; 
                            return;
                        }                           
                            Route last = head;
                            while (last.next != head) {
                                last = last.next;
                            }
                            last.next = current.next; 
                            head = current.next; 
                            
                    } 
                    else 
                    {
                        
                        previous.next = current.next;
                    }
                    count--;
                    System.out.println("Deleted: " + location);
                    return; 
                }
                previous = current; 
                current = current.next;
            } 
            while (current != head);
        
            System.out.println("Location not found: " + location);
        }
        // saerching for a perticular loaction
        public void serach(String location){
            if(head==null){
                System.out.println("list odf location is already empty");
                return;
            }
            Route temp=head;
            do{
                if(temp.getLocation().equals(location)){
                    System.out.println("location "+ location+" found");
                    return;
                }
                temp=temp.next;
            }while(temp!=head);
            System.out.println("location "+location+" not found ");
            return;
            
            
        }
        // modifying location
        public void modify(String oldl,String newl){
            if(head==null){
                System.out.println("list odf location is already empty");
                return;
            }
            Route temp=head;
            while(temp.next!=head){
                if(temp.getLocation().equals(oldl)){
                    temp.location =newl;
                    System.out.println("modified");
                    return;
                
                }
                temp=temp.next;
            }
            System.out.println("location not found");
            return;
        }
        
       
    }
    public static void main(String[] args) {
        Order ll=new Order();
        System.out.println("--inserting at start--");
        ll.addAtStart("PCCOE");
        ll.addAtStart("VIT");
        ll.addAtStart("AKURDI");
        ll.printRoutes();

        System.out.println("--inserting at end--");
        ll.addAtEnd("COEP");
        ll.addAtEnd("MOSHI");
        ll.addAtEnd("Shivajinagar");
        ll.printRoutes();

        System.out.println("--inserting in between--");
        ll.insertInBetween(2, "NIGDI");
        ll.printRoutes();
        System.out.println("--printing total number of locations--");
        System.out.println( ll.count());

        System.out.println("--delete at start--");
        ll.deleteAtStar();
        ll.printRoutes();
        System.err.println("TOTAL locations are "+ll.count());

        System.out.println("--DELETING at end--");
        ll.deleteAtEnd();
        ll.printRoutes();
        System.err.println("TOTAL locations are "+ll.count());
        

        System.out.println("--delete all--");
        ll.deleteAll();

        System.out.println("--inserting at start--");
        ll.addAtStart("PCCOE");
        ll.addAtStart("VIT");
        ll.addAtStart("AKURDI");
        ll.printRoutes();

        System.out.println("--inserting at end--");
        ll.addAtEnd("COEP");
        ll.addAtEnd("MOSHI");
        ll.addAtEnd("Shivajinagar");
        ll.printRoutes();

        System.out.println("--inserting in between--");
        ll.insertInBetween(2, "NIGDI");
        ll.printRoutes();
        System.out.println("--printing total number of locations--");
        System.out.println( ll.count());

        System.out.println("--delete at start--");
        ll.deleteAtStar();
        ll.printRoutes();
        System.err.println("TOTAL locations are "+ll.count());

        System.out.println("--DELETING at end--");
        ll.deleteAtEnd();
        ll.printRoutes();
        System.err.println("TOTAL locations are "+ll.count());

        System.out.println("--delete in between--");
        ll.searchDelete("NIGDI");
        ll.printRoutes();
        
        System.out.println("TOTAL locations are "+ll.count());

        System.out.println("--searching location--");
        ll.serach("MOSHI");

        System.out.println("--modifying location--");
        ll.modify("VIT", "wakad");
        ll.printRoutes();

        


    }
    
}
