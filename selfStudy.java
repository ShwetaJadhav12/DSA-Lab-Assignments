public class _123B5B292_Shweta_Jadhav_selfStudy {
    

        public static boolean areArraysIdentical(int[] arr1, int[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }
    
            int[] frequencyArr1 = new int[101];
            int[] frequencyArr2 = new int[101];
    
            for (int element : arr1) {
                frequencyArr1[element]++;
            }
    
            for (int element : arr2) {
                frequencyArr2[element]++;
            }
    
            for (int i = 0; i < 101; i++) {
                if (frequencyArr1[i] != frequencyArr2[i]) {
                    return false;
                }
            }
    
            return true;
        }
    
        public static void main(String[] args) {
            int[] array1 = {21, 31, 11, 42, 31, 51};
            int[] array2 = {31, 21, 51, 11, 31, 42};
    
            if (areArraysIdentical(array1, array2)) {
                System.out.println("The arrays are identical.");
            } else {
                System.out.println("The arrays are not identical.");
            }
        }
    }

