public class QuickSort implements SortingAlgorithm
{
	public void sort (int arr[]){
		sort(arr, 0, arr.length - 1);
	}

	public void sort (int arr[], int left, int right)
	{
		if (left < right)
		{
			int part = partition(arr, left, right);
			sort(arr, left, part - 1); //values smaller than pivot			
			sort(arr, part + 1, right); //values bigger than pivot
		}	
	}

	public int partition (int arr[], int left, int right)
	{
		if (left < right)
		{
			int pivot = left;
			int i = left + 1;
			int j = right;

			while (i < j)
			{
				while (i <= right && arr[i] <= arr[pivot])
				{
					++i;
				} //while
				while (j >= i && arr[j] > arr[pivot])
				{
					--j;
				} //while

				//swap
				if (i <= right && i < j)
				{
					int temp = arr[i];
					arr[i]= arr[j];
					arr[j]= temp;
				} //if
			} //while
			
			// swap pivot
			int temp = arr[pivot];
			arr[pivot] = arr[j];
			arr[j] = temp;
			return j;
		} //if
		return left;
	}
}




