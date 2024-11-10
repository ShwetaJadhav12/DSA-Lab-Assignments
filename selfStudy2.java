
public class _123B5B292_Shweta_Jadhav_selfStudy2 {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    class DLL{
        Node head;

        public DLL() {
            this.head=null;
        }
        public void add(int data){
            Node nn=new Node(data);
            
            if(head==null){
                head=nn;
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;

            }
            temp.next=nn;
            nn.prev=temp;

        }
        public void deleteDuplicate(){
            if(head==null){
                System.out.println("list is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                Node run1=temp.next;
                while(run1!=null){
                    if(temp.data==run1.data){
                        remove(run1);
                        break;
                    }
                    run1=run1.next;
                }
                temp=temp.next;

            }
        }
        public void remove(Node x){
            if(x==null){
                return;
            }
            if(x.prev!=null){
                x.prev.next=x.next;

            }
            if(x.next!=null){
                x.next.prev=x.prev;
            }
            if(x==head){
                head=x.next;
            }
            x.next=null;
            x.prev=null;
        }

        public void display(){
            if(head==null){
                System.out.println("List is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

        
    }
    public static void main(String[] args) {
        _123B5B292_Shweta_Jadhav_selfStudy2 list = new _123B5B292_Shweta_Jadhav_selfStudy2();
        DLL dll = list.new DLL();
        dll.add(12);
        dll.add(13);
        dll.add(14);
        dll.add(12);
        dll.add(15);
        dll.add(14);
        dll.add(17);
        dll.display();
        dll.deleteDuplicate();
        dll.display();

        
    }
    
}
