public class _123B5B292_shweta_Jadhav_stack_using_queue {
    class Queue<T> {
        private T[] data;
        private int front, rear, size, capacity;

        @SuppressWarnings("unchecked")
        public Queue(int capacity) {
            this.capacity = capacity;
            data = (T[]) new Object[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void enqueue(T value) {
            if (isFull()) {
                throw new IllegalStateException("Queue is full");
            }
            rear = (rear + 1) % capacity;
            data[rear] = value;
            size++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            T result = data[front];
            front = (front + 1) % capacity;
            size--;
            return result;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return data[front];
        }

        public int getSize() {
            return size;
        }
    }

    class StackUsingQueues<T> {
        private Queue<T> queue1;
        private Queue<T> queue2;
        private int capacity;

        public StackUsingQueues(int capacity) {
            this.capacity = capacity;
            queue1 = new Queue<>(capacity);
            queue2 = new Queue<>(capacity);
        }

        public void push(T value) {
            if (queue1.isFull()) {
                throw new IllegalStateException("Stack is full");
            }
            queue1.enqueue(value);
        }

        public T pop() {
            if (queue1.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            while (queue1.getSize() > 1) {
                queue2.enqueue(queue1.dequeue());
            }

            T poppedValue = queue1.dequeue();

            while (!queue2.isEmpty()) {
                queue1.enqueue(queue2.dequeue());
            }

            return poppedValue;
        }

        public T peek() {
            if (queue1.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            while (queue1.getSize() > 1) {
                queue2.enqueue(queue1.dequeue());
            }

            T topValue = queue1.peek();
            queue2.enqueue(queue1.dequeue());

            while (!queue2.isEmpty()) {
                queue1.enqueue(queue2.dequeue());
            }

            return topValue;
        }

        public void display() {
            if (queue1.isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }

            System.out.print("Stack (top to bottom): ");
            while (!queue1.isEmpty()) {
                T value = queue1.dequeue();
                System.out.print(value + " ");
                queue2.enqueue(value);
            }
            System.out.println();

            while (!queue2.isEmpty()) {
                queue1.enqueue(queue2.dequeue());
            }
        }

        public boolean isEmpty() {
            return queue1.isEmpty();
        }

        public int size() {
            return queue1.getSize();
        }
    }

    public static void main(String[] args) {
        // Correctly create the instance of StackUsingQueues
        _123B5B292_shweta_Jadhav_stack_using_queue outerClass = new _123B5B292_shweta_Jadhav_stack_using_queue();
        _123B5B292_shweta_Jadhav_stack_using_queue.StackUsingQueues<Integer> stack = outerClass.new StackUsingQueues<>(7);

        stack.push(61);
        stack.push(92);
        stack.push(38);
        stack.push(11);
        stack.push(22);
        stack.push(34);



        System.out.println("After pushing :");
        stack.display();

        System.out.println("Top element : " + stack.peek());

        System.out.println("Popped element : " + stack.pop());

        System.out.println("After popping:");
        stack.display();

        stack.push(4);
        System.out.println("After pushing 4:");
        stack.display();
    }
}
