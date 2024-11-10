

public class _123B5B292_Shweta_Jadhav_selfStudy3{
    

    static class Stack<T> {
        private T[] array;
        private int top;
        private int capacity;

        @SuppressWarnings("unchecked")
        public Stack(int size) {
            capacity = size;
            array = (T[]) new Object[capacity];  // Create a generic array
            top = -1;
        }

        public void push(T item) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            array[++top] = item;
        }

        public T pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return null;
            }
            return array[top--];
        }

        public T peek() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return null;
            }
            return array[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            for (int i = top; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    static class Queue<T> {
        private T[] array;
        private int front, rear, capacity;

        @SuppressWarnings("unchecked")
        public Queue(int size) {
            capacity = size;
            array = (T[]) new Object[capacity];  // Create a generic array
            front = 0;
            rear = -1;
        }

        public void enqueue(T item) {
            if (rear == capacity - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            array[++rear] = item;
        }

        public T dequeue() {
            if (front > rear) {
                System.out.println("Queue Underflow");
                return null;
            }
            return array[front++];
        }

        public boolean isEmpty() {
            return front > rear;
        }

        public int size() {
            return rear - front + 1;
        }
    }

    public static <T> void reverseStack(Stack<T> stack) {
        Queue<T> queue = new Queue<>(stack.size());

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println("Original Stack:");
        stack.display();
        reverseStack(stack);
        
        System.out.println("Reversed Stack:");
        stack.display();

        Stack<String> stringStack = new Stack<>(4);
        stringStack.push("Apple");
        stringStack.push("Banana");
        stringStack.push("Cherry");
        stringStack.push("Date");

        System.out.println("\nOriginal String Stack:");
        stringStack.display();

        reverseStack(stringStack);

        System.out.println("Reversed String Stack:");
        stringStack.display();
    }
}

