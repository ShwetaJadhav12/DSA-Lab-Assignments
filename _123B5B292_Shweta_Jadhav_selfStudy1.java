

public class _123B5B292_Shweta_Jadhav_selfStudy1{
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=this;
            this.prev=this;
        }
    }
    class circularDoubly{
        Node head;
        circularDoubly(){
            this.head=null;
        }
        public void add(int data){
            Node nn=new Node(data);
            if(head==null){
                head=nn;
               }
               else{
                Node tail=head.prev;
                tail.next=nn;
                nn.prev=tail;
                nn.next=head;
                head.prev=nn;
                

               }
        }
        public void  deleteAtStart(){
            if(head==null){
                System.out.println("List is empty can not delete");
                return;
            }
            if(head.next==head){
                head=null;
                System.out.println("First element deleted");
                return;
            }
            
            Node tail=head.prev;
            head=head.next;
            head.prev=tail;
            tail.next=head;
            System.out.println("First element deleted");

        }
        public void deleteLast(){
            if(head==null){
                System.out.println("list is empty");
                return;
            }
            if(head.next==head){
                head=null;
                System.out.println("l;ast elemnet deleted ");
                return;
            }
            Node tail=head.prev;
            tail.prev.next=head;
            head.prev=tail.prev;
            System.out.println("lats element deleted");


        }
        public void display(){
            Node temp=head;
            System.out.print(head.data+" ");
            while(temp.next!=head){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        _123B5B292_Shweta_Jadhav_selfStudy1 list = new _123B5B292_Shweta_Jadhav_selfStudy1();
        circularDoubly c = list.new circularDoubly();
        c.add(12);
        c.add(13);
        c.add(14);
        c.add(15);
        c.add(16);
        c.display();
        c.deleteAtStart();
        c.display();
        c.deleteLast();
        c.display();

    }
}