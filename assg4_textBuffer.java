public class assg4_textBuffer {
    static class NodeText{
        private String text;
        NodeText prev;
        NodeText next;

        NodeText(String text) {
            this.text=text;
            this.prev=null;
            this.next=null;
        }
        public String getText() {
            return text;
        }
    
        public void setString(String text) {
            this.text = text;
        }
       
        
    }
    public static class textBuffer{
        private NodeText head;
        private NodeText tail;
        private int count;
        textBuffer(){
            head=null;
            tail=null;
            count=0;
        }
        // insert text at the end
        public void inserAtEnd(String text)
        {
            NodeText nn=new NodeText(text);
           
            if(head==null){
                head=tail=nn;
                count++;
                return;
            }
            
            tail.next=nn;
            nn.prev=tail;
            tail=nn;
            count++;
            return;

        }
        // insert at the begining
        public void inserAtStart(String text)
        {
            NodeText nn=new NodeText(text);
            
            if(head==null){
                head=tail=nn;
                count++;
                return;
            }
            
            nn.next=head;
            head.prev=nn;
            head=nn;
            count++;
            return;

        }
        // insert in between
        public void insertInBetween(String oldText,String newText){
            NodeText nn=new NodeText(newText);
            NodeText temp=head;
             if(head==null){
                System.out.println("list is empty");
                System.out.println("adding at end");
                inserAtEnd(newText);
                return;
             }
             
             while(temp!=null){
                if(temp.getText().equals(oldText)){
                    nn.prev=temp;
                    nn.next=temp.next;
                    if(temp.next!=null){
                        temp.next.prev=nn;
                    }
                    else{
                        tail=nn;
                    }
                    temp.next=nn;
                    count++;
                    return;
                    
                }
                temp=temp.next;
                
             }
             System.out.println("text not found");
             return;
        }
            
        
        // displaty text
        public void display(){
            NodeText temp=head;
            while(temp!=null){
                System.out.print(temp.text+" ");
                temp=temp.next;
            }
            System.out.println();
        }

        // display in reverse order
        public void displayReverse(){
            
            NodeText temp=tail;
            
            
            while(temp!=null){
                
                System.out.print(temp.text+" ");
                temp=temp.prev;
                
            }
            System.out.println();
        }
        // delete at start
    public void deleteAtStart()
    {
        if(head==null){
            tail=null;
            System.out.println("nothing to delete");
            count--;
            
            return;

        }
        head=head.next;
        head.prev=null;
        count--;
        
        
        System.out.println("text has been deleted");
        return;
    }
     // delete at end
     public void deleteAtEnd()
     {
         if(head==null){
             tail=null;
             System.out.println("nothing to delete");
             count--;
             return;
 
         }
         tail=tail.prev;
         tail.next=null;
         count--;
     }
    //  DELETE in between
    public void deleteInBetween(String text){
        if(head==null){
            System.out.println("no text in tex editor");
            return;
        }

        NodeText temp=head;
        if(head.getText().equals(text)){
            deleteAtStart();
            
            return;
        }
        if(tail.getText().equals(text)){
            deleteAtEnd();
            
            return;
        }
        while(temp!=null){
            if(temp.getText().equals(text)){
                temp.prev.next=temp.next;
                System.out.println("text deleted");
                count--;
                break;
            }
            temp=temp.next;
            
        }
    }
    //  search text
    public void searchText(String t){
        NodeText temp=head;
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        while(temp!=null){
            if(temp.getText().equals(t)){
                System.out.println("Text found");
                return;
            }
            temp=temp.next;
           

        }
        System.out.println("text not found");

    }
     public int count(){
        return count;
     }
     public void deletAll(){
        head=null;
        tail=null;
        count=0;
        System.out.println("entire texxts in text editor has been delted");
     }


    }
    public static void main(String[] args) {
        textBuffer t1=new textBuffer();
        System.out.println("--inserting text--");
        t1.inserAtStart("goodbye");
        t1.display();


        t1.inserAtStart("nice");
        t1.display();

        t1.inserAtStart("welcome");
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());

        t1.inserAtEnd("shweta");
        t1.display();

        System.out.println("--deleting entire texts-- ");
        t1.deletAll();
        System.out.println("--inserting text--");
        t1.inserAtStart("goodbye");
        t1.display();
        t1.inserAtStart("DSA");
        t1.display();


        t1.inserAtStart("nice");
        t1.display();

        t1.inserAtStart("welcome");
        t1.display();

        t1.inserAtEnd("shweta");
        t1.display();

        t1.inserAtEnd("hello");
        t1.display();

        t1.inserAtEnd("good");
        t1.display();

        System.out.println("--displaying full text--");
        t1.display();

        System.out.println("--displaying full text in reverse order--");
        t1.displayReverse();
        
        System.out.println("--deleting text--");
        t1.deleteAtStart();
        t1.display();

        
        System.out.println("--deleting text--");
        t1.deleteAtEnd();
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());

        System.out.println("--Inserting text in between--");
        t1.insertInBetween("nice", "sumedh");
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());

        System.out.println("--searching for text--");
        t1.searchText("sumedh");

        System.out.println("--sraching and deleing text--");
        t1.deleteInBetween("hello");
        t1.display();

        t1.deleteInBetween("nice");
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());

        t1.deleteInBetween("shweta");
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());

        System.out.println("--Inserting text in between--");
        t1.insertInBetween("sumedh", "PCCOE");
        t1.display();

        System.out.println("--displaying total numbers of text--");
        System.out.println(t1.count());


    }
}
// functions used
// 1.add at start
// 2.add at end
// 3.add in between
// 4.delete at start 
// 5.delete at end
// 6.delete in between
// 7.display text
// 8.display in reverse
// 9.search text
// 10.count text
// 11.DELETE ALL TEXTS