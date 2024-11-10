public class _123B5B292_Shweta_Jadhav_selfStudy4 {
    

        public static boolean isBalanced(String expression) {
            char[] stack = new char[expression.length()];
            int top = -1; 
    
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
    
             
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack[++top] = ch; 
                }
                
                else if (ch == ')' || ch == '}' || ch == ']') {
                    
                    if (top == -1) {
                        return false;
                    }
                    
                    char topChar = stack[top--]; 
    
                   
                    if ((ch == ')' && topChar != '(') ||
                        (ch == '}' && topChar != '{') ||
                        (ch == ']' && topChar != '[')) {
                        return false;
                    }
                }
            }
    
            
            return top == -1;
        }
    
        public static void main(String[] args) {
            String expression = "{[()]}";
            System.out.println("Expression: " + expression);
            System.out.println("Balanced: " + isBalanced(expression));
    
            expression = "{[(])}";
            System.out.println("Expression: " + expression);
            System.out.println("Balanced: " + isBalanced(expression));
        }
    }
    

