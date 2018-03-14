public class MergeSorter implements IntSorter
{
	private int[] originalArray = null;
	private int[] tempArray = null;
	private int leftIndex = 0;
	private int rightIndex = 0;
	private int index = 0;
	private int middle = 0;
	private int left = 0;
	private int right = 0;
	private int moves = 0;
	private int start = 0;
	private int end  = 0;
  	private long startTime = 0;
  	private long endTime = 0;

	public void init(int[] a)//this allows us to access our array by using the array in the tester class
	{
		this.originalArray = a;
   		moves = 0;
	}

	public void sort()//the method that starts it all but not the place where we actually do the sorting
	{
		startTime = System.nanoTime();
		tempArray = new int[originalArray.length];//instantiating the temporary array
		left = 0;//lowerbound
		right = originalArray.length - 1;//upperbound
		split(originalArray, left, right);
		merge(left, middle, right);
		endTime = System.nanoTime();
	}

	public void split(int array[], int left, int right)//dividing the array recursively into they're size 1
	{
		if(left < right)//base case
		{	
			middle = (left + right)/2;//this line splits the array
			split(originalArray, left, middle);//splits the left half of the array
			split(originalArray, middle + 1, right);//splits the right half of the array
			merge(left, middle, right);
		}
	}

	private void merge(int left, int mid, int right)//second half of the sort algorithm; putting the arrays together
	{
		leftIndex = left;//start of our first array to be merged
		rightIndex = mid + 1;//start of our second array to be merged
		index = left;//this index is referring to the index of our temp array; the array we're adding the sorted data into

		while(leftIndex != mid || rightIndex != right)//while there's still data to be merged
		{
			if(originalArray[leftIndex] < originalArray[rightIndex])//comparing the sub arrays to find the smallest value
			{
				tempArray[left] = originalArray[leftIndex];//putting the smaller value into the new array
				leftIndex++;
				index++;
				moves++;
			}
			else if(originalArray[leftIndex] > originalArray[rightIndex])//comparing the sub arrays to find the smallest value
			{
				tempArray[left] = originalArray[rightIndex];//putting the smaller value into the new array
				rightIndex++;
				index++;
				moves++;
			}
		}	

		while(leftIndex != mid)//while there's still data left in the array to be merged
		{
			tempArray[index] = originalArray[leftIndex];
			leftIndex++;
			index++;
			moves++;
		}
		while(rightIndex != right)//while there's still data left in the array to be merged
		{
			tempArray[index] = originalArray[rightIndex];
			rightIndex++;
			index++;
			moves++;
		}
		System.arraycopy(tempArray, 0, originalArray, 0, right);//moving the data back into the original array, this 
	}

	public int getMoves()//O(1) by simply returning the variable that keep track of the number of moves
	{
		return moves;
	}

	public long getSortTime()//O(1) operation that returns how long your sort algorithm takes
	{
		return endTime - startTime;
	}
}