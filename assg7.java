public class _123B5B292_Shweta_Jadhav_assg7 {
    
        static class Node{
            private String data;
            Node next;
            Node(String data){
                this.data=data;
                this.next=null;
            }
            public String getData() {
                return data;
            }
    
            
            public void setData(String data) {
                this.data = data;
            }
        }
        static class Stack{
            Node top;
            Stack(){
                top=null;
            }
            public void push(String data){
                Node nn=new Node(data);
                if(top==null){
                    top=nn;
                    return;
                }
                nn.next=top;
                top=nn;
                
            }
    
            public String pop(){
                if(top==null){
                    System.out.println("list is empty");
                    return null ;
                }
                String x=top.getData();
                top=top.next;
                return x;
                
            }
            public boolean isEmpty() 
            {
                return top==null;
        }
            public void display() {
                if (top == null) {
                    System.out.println("no pages visted");
                    return;
            }
                Node temp = top;  
                while (temp != null) {  
                    System.out.print(temp.getData() + "  ");
                    temp = temp.next;  
            }
                System.out.println();  
    }
    
    }
        
        public static class WebPage
        {
    
            Stack st,temp;
            WebPage(){
                st=new Stack();
                temp=new Stack();
            }
            // adding visited page
            void addPage(String visitPage){
                
                st.push(visitPage);
                st.display();
                
            }
            // navigating back
            void naviGateBack(){
                if(st.isEmpty()){
                    System.out.println("Cant go back!!");
                    return;
                }
                String n=st.pop();
                temp.push(n);
                System.out.println("the back page is ");
                st.display();
                
            }
            // navigating forward page
            void forwardPage(){
                if(temp.isEmpty()){
                    System.out.println("You are on the current page cant go forward!");
                    return;
                }
                st.push(temp.pop());
                System.out.println("the forward page is");
                st.display();
                
            }
            // printing current page
            void viewCurrent(){
                if(st.isEmpty()){
                    System.out.println("you did not visit any page");
                    return;
                }
                System.out.println("you are on "+ st.top.getData()+" this page");
            }
            // checking histry
            void checkHistry(){
                 if(st.isEmpty()){
                    System.out.println("HISTRY IS EMPTY  !! you did not visit any page");
                    return;
                }
                System.out.println("you visited following pages");
                st.display();
                
            }
            
            
        }
        public static void main(String[] args){
            WebPage w=new WebPage();
            w.checkHistry();
            w.addPage("www.pccoepune.org");
            w.addPage("www.coep.org");
            w.addPage("www.vit.org");
            w.addPage("www.pccoerpune.org");
            w.addPage("www.jspm.org");
            w.addPage("www.viit.org");
            w.forwardPage();
            
            w.naviGateBack();
            w.viewCurrent();
            w.naviGateBack();
            w.viewCurrent();
            
            w.forwardPage();
            w.viewCurrent();
            w.forwardPage();
            w.viewCurrent();
            w.forwardPage();
            
            w.viewCurrent();
            w.checkHistry();
            
            
            
            
            
            
    
            
            
        }
        
        
    }
    
    

