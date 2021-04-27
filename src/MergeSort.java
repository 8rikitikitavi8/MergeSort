import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 3, 1, 3, 8, 0, -16, 276};

        divide(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    static void divide(int[] array, int first, int last) {


        System.out.println(first + " " + last);
        if (first == last) {
            return ;
        }

        // а здесь вызываем divide для левого подмассива
        divide(array, first, (first + last) / 2);

        // а здесь вызываем divide для правого подмассива
        divide(array, (first + last) / 2 + 1, last);
        merge(array,first,last);

    }

    static void merge(int[] array, int first, int last) {
//        int[] resultArray = new int[array.length];
        int start = first;
        int end = last;
        int middle = first + (last - first) / 2 + 1;
        int[] leftArray = Arrays.copyOfRange(array, start, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, end + 1);
        int[] resultArray = merge2arrays(leftArray, rightArray);
        for (int i = first; i < first + resultArray.length; i++) {
            array[i] = resultArray[i-first];
        }
    }
    // реализация слияния массивов
    static int[] merge2arrays(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int counter = 0;
        int[] remaining = new int[Math.max(array1.length, array2.length)];
        int index = 0;
        int i = 0;

        for (int j = 0; j < array2.length || i < array1.length;) {
            if (array1[i] <= array2[j]) {
                resultArray[counter] = array1[i];
                i++;
                counter++;
                if (i == array1.length) {
                    remaining = array2;
                    index = j;
                    break;
                }
            }
            if (array1[i] > array2[j]) {
                resultArray[counter] = array2[j];
                j++;
                counter++;
                if (j == array2.length) {
                    remaining = array1;
                    index = i;
                    break;
                }
            }
        }
        for (int j = index; j < remaining.length; j++) {
            resultArray[counter] = remaining[j];
            counter++;
        }
        return resultArray;
    }
}
