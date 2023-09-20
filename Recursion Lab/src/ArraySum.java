public class ArraySum {

	public int sumOfArray(Integer[] a, int index) {
		// index starts as the size of the array
		int sum;
		if (index == 0) {
			sum = a[index];
		}
		else {
			sum = a[index] + sumOfArray(a, index - 1);
		}
		return sum;
	}
}
