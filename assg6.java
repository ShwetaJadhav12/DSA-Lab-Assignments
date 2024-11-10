public class _123B5B292_Shweta_Jadhav_assg6 {
    static class Node {
        private int coeff;
        private int degree;
        Node next;

        Node(int coeff, int degree) {
            this.coeff = coeff;
            this.degree = degree;
            this.next = null;
        }
        // getters and setters becoz the members are private in in java if you want 
        // to acceess ouside class you have to wrie setters(to set value ) and gettersto get value()
        public int getCoeff() {
            return coeff;
        }

        public void setCoeff(int coeff) {
            this.coeff = coeff;
        }

        public int getDegree() {
            return degree;
        }

        public void setDegree(int degree) {
            this.degree = degree;
        }

    }

    static class polynomial {
        Node head;

        polynomial() {
            head = null;
        }

        // craeting polynomial
        public void insertPolynomial(int coeff, int degree) {
            Node p1 = new Node(coeff, degree);
            if (head == null || head.getDegree() < degree) {
                p1.next = head;
                head = p1;
                return;
            }
            Node temp = head;
            while (temp.next != null && temp.next.getDegree() >= degree) {
                temp = temp.next;
            }
            if (temp.getDegree() == degree) {
                temp.setCoeff(temp.getCoeff() + coeff);
            } else {
                p1.next = temp.next;
                temp.next = p1;
            }
        }
        // add polynomial
        public static polynomial addPolynomials(polynomial poly1,polynomial poly2){
            polynomial result=new polynomial();
            Node p1=poly1.head;
            Node p2=poly2.head;
            while(p1!=null && p2!=null){
                if(p1.getDegree()==p2.getDegree()){
                    result.insertPolynomial(p1.getCoeff()+p2.getCoeff(),p1.getDegree());
                    p1=p1.next;
                    p2=p2.next;
                }
                else if(p1.getDegree()>p2.getDegree()){
                    result.insertPolynomial(p1.getCoeff(), p1.getDegree());
                    p1=p1.next;
                }
                else{
                    result.insertPolynomial(p2.getCoeff(), p2.getDegree());
                    p2=p2.next;

                }
            }
            while(p1!=null){
                result.insertPolynomial(p1.getCoeff(), p1.getDegree());
                p1=p1.next;
            }
            while(p2!=null){
                result.insertPolynomial(p2.getCoeff(), p2.getDegree());
                p2=p2.next;
            }
            return result;
            

        }
        // multiplication of polynomial
        public static polynomial multiplyPolynomials(polynomial poly1,polynomial poly2){
            polynomial result=new polynomial();
            Node p1=poly1.head;
            Node p2=poly2.head;
           
            while(p1!=null)
            {    
               
                while(p2!=null)
                {
                    int coeff=p1.coeff*p2.coeff;
                    int degree=p1.degree*p2.degree;
                    result.insertPolynomial(coeff, degree);
                    p2=p2.next;
            }
            p1=p1.next;
            }
            return result;
            
            }
        public void display(){
            if(head==null){
                System.out.println("0");
                return;
            }
            Node temp=head;
            boolean termOne=true;
            while(temp!=null){
                if(temp.getCoeff()!=0){
                    if (!termOne && temp.getCoeff() > 0) {
                        System.out.print("+");
                    }

            
                if (temp.getDegree() == 0) {
                        System.out.print(temp.getCoeff()); // For degree 0, just print the coefficient
                    } else {
                        System.out.print(temp.getCoeff() + "x^" + temp.getDegree());
                    }
                    termOne=false;
                }
                temp=temp.next;
            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
                   
            polynomial P1=new polynomial();
            polynomial P2=new polynomial();
            P1.insertPolynomial(3, 2);
            P1.insertPolynomial(1, 1);
            P1.insertPolynomial(4, 0);

            P2.insertPolynomial(5, 2);
            P2.insertPolynomial(8, 1);
            P2.insertPolynomial(-2, 0);

            System.out.println("polynomial 1: ");
            P1.display();

            System.out.println("polynomial 2: ");
            P2.display();

            System.out.println("addition is: ");
            polynomial result= polynomial.addPolynomials(P1, P2);
            result.display();

            System.out.println("multiplcation  is: ");
            polynomial result2= polynomial.multiplyPolynomials(P1, P2);
            result2.display();

        }
    }

