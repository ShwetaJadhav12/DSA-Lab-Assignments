
public class assg1 {
    static class Student {
        private int prn;
        private String name;
        private double cgpa;

        public int getPrn() {
            return prn;
        }
        public void setPrn(int prn) {
            this.prn = prn;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getCgpa() {
            return cgpa;
        }
        public void setCgpa(double cgpa) {
            this.cgpa = cgpa;
        }

        public Student(int prn, String name, double cgpa) {
            this.prn = prn;
            this.name = name;
            this.cgpa = cgpa;
        }

        

        void display() {
            System.out.print("PRN: " + getPrn()+"\t");
            System.out.print("Name: " + getName()+"\t");
            System.out.print("CGPA: " + getCgpa()+"\t");
            System.out.println();
        }
    }

    public static void inserSort(Student[] arr, int n) {
        Student temp;
        for (int i = 1; i < n; i++) {
            temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrn()>(temp.getPrn())) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = temp;
        }
    }
    public static void shellSort(Student[] arr, int n, int gap) {
        Student temp;
        for (int i = gap; i < n; i++) {
            temp = arr[i];
            int j = i - gap;
            while (j >= 0 && arr[j].getName().compareTo(temp.getName()) > 0) {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = temp;
        }
    }

    public static void sort(Student[] arr, int n) {
        int gap = n / 2; // Initial gap

        while (gap >= 1) {
            shellSort(arr, n, gap);
            gap = gap / 2; // Reduce gap for next iteration
        }
    }
    public static void radixSortByCgpa(Student[] s) {
        
        double maxCgpa = getMaxCgpa(s);
    
        for (double exp = 0.1; maxCgpa / exp > 0; exp *= 10) {
            countingSortByCgpa(s, exp);
        }
    }
    
    private static double getMaxCgpa(Student[] students) {
        double max = students[0].cgpa;
        for (int i = 1; i < students.length; i++) {
            if (students[i].cgpa > max) {
                max = students[i].cgpa;
            }
        }
        return max;
    }
    
    private static void countingSortByCgpa(Student[] students, double exp) {
        int n = students.length;
        Student[] output = new Student[n];
        int[] count = new int[10];
    
        for (int i = 0; i < n; i++) {
            int index = (int) ((students[i].cgpa / exp) % 10);
            count[index]++;
        }
    
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
    
        for (int i = n - 1; i >= 0; i--) {
            int index = (int) ((students[i].cgpa / exp) % 10);
            output[count[index] - 1] = students[i];
            count[index]--;
        }
    
        for (int i = 0; i < n; i++) {
            students[i] = output[i];
        }
    }
    
    

    public static void main(String[] args) {
        Student[] s ={
            new Student(15, "Abha", 8.2),
            new Student(3, "Mohan", 9.1),
            new Student(10, "Charvi", 7.8),
            new Student(7, "Danish", 8.9),
            new Student(5, "Eshal", 9.0),
            new Student(1, "Feyoni", 8.4),
            new Student(12, "Gargi", 8.5),
            new Student(8, "Hiral", 7.9),
            new Student(11, "Isha", 8.1),
            new Student(2, "Gauri", 9.3),
            new Student(4, "Manohar", 8.0),
            new Student(9, "Niraj", 8.6),
            new Student(14, "Ovi", 7.7),
            new Student(6, "Sumedh", 8.7),
            new Student(13, "Trupti", 8.8)
        };
        
       

        inserSort(s, 15);
        System.out.println("Sorted list according to the prn of the student");
        for (Student student : s) {
            student.display();
        }
        System.out.println();

        sort(s, 15);
        System.out.println("Sorted list according to the name of the students");

        for (Student student : s) {
            student.display();
        }
        radixSortByCgpa(s);
        System.out.println("\nTop 10 Students by CGPA:");
        for (Student student : s) {
            student.display();
        }
    }
}






