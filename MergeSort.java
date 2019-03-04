public class MergeSort implements SortingAlgorithm
{
    public void sort(int[] array)
    {
        divideArr(array);
    }

    int[] divideArr(int[] array)
    {
        if (array.length <= 1)
        {
            return array;
        } //if
        
        //temporary arrays  
        int temp1[] = new int[array.length/2];
        int temp2[] = new int[array.length - temp1.length];

        //copies arrays
        System.arraycopy(array, 0, temp1, 0, temp1.length); //starting at element 0 and putting array into temp1 array
        System.arraycopy(array, temp1.length, temp2, 0, temp2.length); //starting at temp1 length and putting array into temp2 array
        
        //divides arrays into separate arrays
        divideArr(temp1);
        divideArr(temp2);

        //merges all arrays
        merge(array, temp1, temp2);
        return array;
    }

    void merge(int[] target, int[] top, int[] bottom)
    {
        int topIndex = 0;
        int bottomIndex = 0;
        int targetIndex = 0;

        while (topIndex < top.length && bottomIndex < bottom.length)
        {
            if (top[topIndex] <= bottom[bottomIndex])
            {
                target[targetIndex++] = top[topIndex++]; //targetIndex++ starts at 1
            }
            else
            {
                target[targetIndex++] = bottom[bottomIndex++];
            }
        } //while

        while (topIndex < top.length)
        {
            target[targetIndex++] = top[topIndex++];
        } //while

        while (bottomIndex < bottom.length)
        {
            target[targetIndex++] = bottom[bottomIndex++];
        } //while
    }
}

