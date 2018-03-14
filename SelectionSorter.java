public class SelectionSorter implements IntSorter
{
	private int[] array = null;
	private int moves = 0;
	private int smallest = 0;
  	private long startTime = 0;
  	private long endTime = 0;

	public void init(int[] a)//this allows us to access our array by using the array in the tester class
	{
		this.array = a;
   		moves = 0;
	}

	public void sort()//O(n^2)
	{
		startTime = System.nanoTime();
		boolean done = false;
		while(!done)
		{
			done = true;
			for(int i = 0; i < array.length - 1; i++)//looping through the array
			{
				smallest = i;//placekeeper for the smallest value
				for(int k = i + 1; k < array.length; k++)//looping through the unsorted section of the array
				{
					if(array[smallest] > array[k])
					{
						smallest = k;
						done = false;
					}
				}
				swap(array, smallest, i);
			}
		}
		endTime = System.nanoTime();
	}

	private void swap(int[] values, int p1, int p2)//method that swaps two values in the array
	{
    	int temp = values[p1];
    	values[p1] = values[p2];
    	values[p2] = temp;
    	moves++;
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