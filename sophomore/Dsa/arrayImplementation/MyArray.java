public class MyArray
{
    public int MaxSize;
    public int size = 0;
    int data[];

    public MyArray(int arraySize)
    {
        this.MaxSize = arraySize;
        data = new int[MaxSize];
    }

    public boolean isFull()
    {
        return size == MaxSize;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void insert(int d, int idx)
    {
        // data[]
        // ~ 0 >> 1
        for (int i = size; i > idx; i--)
        {
            data[i] = data[i - 1];
        }
        data[idx] = d;
        size++;
    }

    public int find(int d)
    {
        for (int i = 0; i < size; i++)
            if (data[i] == d)
                return i;
        return -1;
    }

    public int add(int d)
    {
        if (!isFull())
        {
            data[size] = d;
            size++;
            return size;
        }
        return -1;
    }

    public int binarySearch(int d)
    {
        return binarySearch(d, 0, data.length - 1);
    }

    private int binarySearch(int search, int low, int high)
    {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;

        if (data[mid] == search)
            return mid;
        else if (data[mid] < search)
            return binarySearch(search, mid + 1, high);
        else
            return binarySearch(search, low, mid - 1);
    }

    public void deleteU(int index)
    {
        data[index] = data[--size];
    }

    public void deleteO(int index)
    {
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size--;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer("");
        sb.append("[");
        for (int i = 0; i < size - 1; i++)
        {
            sb.append(data[i]);
            sb.append(",");
        }
        if (size > 0)
            sb.append(data[size - 1]);
        sb.append("]");
        return sb.toString();
    }

}
