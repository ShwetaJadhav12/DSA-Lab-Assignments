import java.util.*;

public class _123B5B292_Shweta_Jadhav_assg8a {
    static class Stack<T> {
        private T[] ar;
        private int size;
        private int top;

        @SuppressWarnings("unchecked")
        Stack(int size) {
            this.size = size;
            this.top = -1;
            this.ar = (T[]) new Object[size];
        }

        public void push(T data) {
            if (isFull()) {
                System.out.println("stack is full");
                return;
            }
            ar[++top] = data;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");

            }
            return ar[top--];

        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return ar[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size - 1;
        }

    }

    public static class Evaluate_Expression {
        private boolean isDigit(char ch) {
            return ch >= '0' && ch <= '9';
        }

        private boolean isExp(char ch) {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        private double  performOperation(double v2, double v1, char op) {
            switch (op) {
                case '+':
                    return v2 + v1;
                case '-':
                    return v2 - v1;
                case '*':
                    return v2 * v1;
                case '/':
                    if (v1 == 0)
                        throw new ArithmeticException("cant divide by zero");
                    return v2 / v1;
                default:
                    throw new IllegalArgumentException("bad operand type" + op);
            }

        }

        public double  evalu(String expression) {
            Stack<Double> St = new Stack<>(120);

            int i = 0;
            while (i < expression.length()) {
                char current = expression.charAt(i);
                if (isDigit(current)) {
                    double number = 0;
                    while (i < expression.length() && isDigit(expression.charAt(i))) {
                        number = number * 10 + (current - '0');
                        i++;
                        if (i < expression.length()) {
                            current = expression.charAt(i);
                        }

                    }
                    St.push(number);
                }

                 else if (isExp(current)) {
                    char op = current;

                    double v1 = St.pop();
                    double v2 = St.pop();
                    St.push(performOperation(v2, v1, op));
                    i++;
                } else if (current == ' ') {
                    i++;
                } else {
                    throw new IllegalArgumentException("invalid character");
                }
            }
            return St.pop();
        }
    }

    public static void main(String[] args) {
        Evaluate_Expression exp = new Evaluate_Expression();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter postfix expression");
        String expression = sc.nextLine();
        try {
            double result = exp.evalu(expression);
            System.out.println("result: " + result);

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        } finally {
            sc.close();
        }

    }
}
