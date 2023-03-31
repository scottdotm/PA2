package PA2;

import java.util.Arrays;

public class DynamicArray {

	int A[];
	int numElements;
	int length;

	public DynamicArray(int initialSize) {
		numElements = 0;
		length = initialSize;
		A = new int[initialSize];
	}
	
	/**
	 * Helper function that creates an array tmp[] of size newArrayLen
	 * if arrayLen <= newArrayLen, then copies array[] to tmp[]
	 * else copies the first newArrayLen elements of array[] into tmp[]
	 */
	private int[] copyArray(int[] array, int arrayLen, int newArrayLen) {
		int[] tmp = new int[newArrayLen];
		if (arrayLen <= newArrayLen) {
                    System.arraycopy(array, 0, tmp, 0, arrayLen);
		} else {
                    System.arraycopy(array, 0, tmp, 0, newArrayLen);
		}
		return tmp;
	}

	public int access(int index) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		return A[index];
	}

	public void update(int index, int val) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		A[index] = val;
	}

	public void insertAtEnd(int val) {
		if (numElements == length) {
			length = 2 * length;
			A = copyArray(A, numElements, length);
		}
		A[numElements++] = val;
	}

	public void deleteLast() {
            switch (numElements) {
                case 0 -> System.out.println("Cannot delete from an empty array");
                case 1 -> {
                    numElements = 0;
                    length = 1;
                    A = new int[length];
                }
                default -> {
                    numElements--;
                    if (4 * numElements == length) {
                        length = 2 * numElements;
                        A = copyArray(A, numElements, length);
                    }
                }
            }
	}

	public int getSize() {
		return numElements;
	}

        @Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(A, 0, numElements));
	}
}
