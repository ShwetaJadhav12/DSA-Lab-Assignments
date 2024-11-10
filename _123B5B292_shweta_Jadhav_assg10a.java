public class _123B5B292_shweta_Jadhav_queue_using_stack {

    class Stack<T> {
        private T[] array;
        private int top;
        private int capacity;

        @SuppressWarnings("unchecked")
        public Stack(int capacity) {
            this.capacity = capacity;
            array = (T[]) new Object[capacity];
            top = -1;
        }

        public void push(T value) {
            if (top == capacity - 1) {
                throw new IllegalStateException("Stack is full");
            }
            array[++top] = value;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            T value = array[top];
            array[top--] = null;
            return value;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
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
                System.out.print("Stack is empty");
            } else {
                for (int i = top; i >= 0; i--) {
                    System.out.print(array[i] + " ");
                }
            }
        }
    }

    class QueueUsingTwoStacks<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;

        public QueueUsingTwoStacks(int capacity) {
            stack1 = new Stack<>(capacity);
            stack2 = new Stack<>(capacity);
        }

        public void enqueue(T value) {
            stack1.push(value);
        }

        public T dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return stack2.pop();
        }

        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return stack2.peek();
        }

        public void display() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            if (!stack2.isEmpty()) {
                stack2.display();
            }

            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.array[i] + " ");
            }

            System.out.println();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }
    }

    public static void main(String[] args) {
        _123B5B292_shweta_Jadhav_queue_using_stack outerClass = new _123B5B292_shweta_Jadhav_queue_using_stack();
        QueueUsingTwoStacks<Integer> queue = outerClass.new QueueUsingTwoStacks<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("After enqueuing :");
        queue.display();
        System.out.println("\nQueue size: " + queue.size());

        System.out.println("Front element is: " + queue.peek());

        System.out.println("Dequeued element is: " + queue.dequeue());

        System.out.println("After dequeuing:");
        queue.display();
        System.out.println("\nQueue size: " + queue.size());

        queue.enqueue(4);
        System.out.println("After enqueueing 4:");
        queue.display();
        System.out.println("\nQueue size: " + queue.size());
    }
}
