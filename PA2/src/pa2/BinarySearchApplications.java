package PA2;

public class BinarySearchApplications {

    public static int minIndexBinarySearch(int array[], int arrayLength, int key) {
        int left = 0, right = arrayLength - 1;
        int minIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;

            } else if (array[mid] > key) {
                right = mid - 1;

            } else if (array[mid] == key) {
                minIndex = mid;
                right = mid - 1;
            }

        }
        return minIndex;

    }

    public static int maxIndexBinarySearch(int array[], int arrayLength, int key) {
        int left = 0, right = arrayLength - 1;
        int maxIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;

            } else if (array[mid] > key) {
                right = mid - 1;

            } else if (array[mid] == key) {
                maxIndex = mid;
                left = mid + 1;
            }

        }
        return maxIndex;
    }

    public static int countNumberOfKeys(int array[], int arrayLength, int key) {
        int minIndex = minIndexBinarySearch(array, arrayLength, key);
        if (minIndex == -1){
            return 0;
        }
        int maxIndex = maxIndexBinarySearch(array, arrayLength, key);

        return maxIndex - minIndex + 1;
    }

    public static int predecessor(int array[], int arrayLen, int key) {
        int left = 0, right = arrayLen - 1;
        int predIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                predIndex = mid;
                left = mid + 1;

            } else if (array[mid] > key) {
                right = mid - 1;

            } else if (array[mid] == key) {
                return mid;
            }

        }
        return predIndex;

    }

    public static int findPeak(int twoToneArray[], int arrayLen) {
        int left = 0, right = arrayLen - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }

            if (right == left + 1) {
                if (twoToneArray[right] > twoToneArray[left]) {
                    return right;
                } else {
                    return left;
                }
            }
            int mid = (left + right) / 2;
            if (twoToneArray[mid] < twoToneArray[mid + 1]) {
                left = mid + 1;
            }
            else if (twoToneArray[mid] < twoToneArray[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

}
