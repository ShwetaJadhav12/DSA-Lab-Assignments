import java.util.Scanner;
public class _123B5B292_Shweta_Jadhav_assg8b{
static class Stack<T> {
    private T[] arr;
    private int top, size;

    @SuppressWarnings("unchecked")
    public Stack(int n) {
        arr = (T[]) new Object[n];
        top = -1;
        size = n;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(T ele) {
        if (isFull()) {
            return;
        }
        arr[++top] = ele;
    }

    public T peek() {
        if (isEmpty()) {
            return null; // Return null if the stack is empty
        }
        return arr[top];
    }

    public T pop() {
        if (isEmpty()) {
            return null; // Return null if the stack is empty
        }
        return arr[top--];
    }
}


    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == '/' || c == '%' || c == '^';
    }

    public static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case 'x':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> s1 = new Stack<>(100);  // Adjust size as necessary

        for (String arg : args) {
            if (isDigit(arg.charAt(0))) {
                int n = 0;
                for (int j = 0; j < arg.length(); j++) {
                    n = n * 10 + (arg.charAt(j) - '0');
                }
                System.out.print(n + " ");
                n = 0;
            } else if (isOperator(arg.charAt(0))) {
                
                s1.push(arg.charAt(0));
            }
            while (!s1.isEmpty() && prec(arg.charAt(0)) < prec(s1.peek())) {
                System.out.print(s1.pop() + " ");
            }
        }

        
        while (!s1.isEmpty()) {
            System.out.print(s1.pop() + " ");
        }
        System.out.println();

        sc.close();
    }
}
