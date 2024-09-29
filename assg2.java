public class assg2 {
    static class Employee {
        private int empid;
        private String empname;
        private float empsalary;

        public int getId() {
            return empid;
        }

        public void setId(int empid) {
            this.empid = empid;
        }

        public String getName() {
            return empname;
        }

        public void setName(String empname) {
            this.empname = empname;
        }

        public float getSalary() {
            return empsalary;
        }

        public void setSalary(float empsalary) {
            this.empsalary = empsalary;
        }

        public Employee(int empid, String empname, float empsalary) {
            this.empid = empid;
            this.empname = empname;
            this.empsalary = empsalary;
        }

        void display() {
            System.out.print("EMP-ID: " + getId() + "\t");
            System.out.print("Name: " + getName() + "\t");
            System.out.print("Salary: " + getSalary() + "\t");
            System.out.println();
        }
    }

    public static int partition(Employee[] e, int s, int ei) {
        int pivot = e[s].getId();  // Pivot is the EMP-ID of the first element
        int i = s + 1;
        int j = ei;

        while (i <= j) {
            while (i <= ei && e[i].getId() <= pivot) {
                i++;
            }
            while (j >= s && e[j].getId() > pivot) {
                j--;
            }
            if (i < j) {
                swap(e, i, j);
            }
        }
        swap(e, s, j);
        return j;
    }

    public static void swap(Employee[] e, int i, int j) {
        Employee temp = e[i];
        e[i] = e[j];
        e[j] = temp;
    }

    public static void quickSort(Employee[] e, int s, int ei) {
        if (s < ei) {
            int pi = partition(e, s, ei);
            quickSort(e, s, pi - 1);
            quickSort(e, pi + 1, ei);
        }
    }
    public static void merge(Employee[] s, int si, int mid, int ei) {
        Employee[] temp = new Employee[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (s[i].getName().compareTo(s[j].getName())<0) {
                temp[k] = s[i];
                k++;
                i++;
            } else {
                temp[k] = s[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = s[i];
            i++;
            k++;
        }

        while (j <= ei) {
            temp[k] = s[j];
            j++;
            k++;
        }

        for (k = 0; k < temp.length; k++) {
            s[si + k] = temp[k];
        }
    }

    public static void mergeSort(Employee[] s, int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;
        mergeSort(s, si, mid);
        mergeSort(s, mid + 1, ei);
        merge(s, si, mid, ei);
    }


    public static void main(String[] args) {
        Employee[] e = {
            new Employee(20, "Alice", 55000.45f),
            new Employee(17, "Bob", 60000),
            new Employee(16, "Charlie", 70000),
            new Employee(19, "David", 50000.67f),
            new Employee(18, "Eve", 75000),
            new Employee(15, "Abha", 82000),
            new Employee(3, "Mohan", 910000),
            new Employee(10, "Charvi", 76666.34f),
            new Employee(7, "Danish", 89999),
            new Employee(5, "Eshal", 90000.1f),
            new Employee(1, "Feyoni", 84444.678f),
            new Employee(12, "Gargi", 85000.23f),
            new Employee(8, "Hiral", 79000.78f),
            new Employee(11, "Isha", 81000),
            new Employee(2, "Gauri", 94068),
            new Employee(4, "Manohar", 86394),
            new Employee(9, "Niraj", 88936),
            new Employee(14, "Ovi", 75678),
            new Employee(6, "Sumedh", 89806),
            new Employee(13, "Trupti", 88888)
        };

        quickSort(e, 0, 19);  // Updated to handle the full array dynamically
        System.out.println("Sorted list by EMP-ID: ");
        for (Employee employee : e) {
            employee.display();
        }
        System.out.println();
        System.out.println("Alphabetically sorted list of employees: ");
        mergeSort(e, 0, 19);
        for (Employee employee : e) {
            employee.display();
        }


    }
}
