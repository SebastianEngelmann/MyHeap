/**
 * Created by sebastian on 25.11.16.
 */
public class MyHeap {
    // Attribute
    private int[] array;
    private int lastElem;

    // Konstruktor
    public MyHeap(int n)
    {
        this.array = new int[n];
        this.lastElem = -1;
    }

    // Methoden
    public void insert(int k)
    {
        if(lastElem == array.length - 1)
        {
            return;
        }
        else
        {
            array[lastElem + 1] = k;
            lastElem++;
        }
    }

    public int deleteMin()
    {
        return 0;
    }

    private void bubbleDown()
    {

    }

    private void bubbleUp()
    {

    }

    private int getLeftChildIndex(int i)
    {
        return 2 * i +1;
    }

    private int getRightChildIndex(int i)
    {
        return 2 * i + 2;
    }

    private int getParentIndex(int j)
    {
        return (int) Math.floor((double)(j - 1) / 2);
    }

    public void print(MyHeap mh)
    {
        for(int i = 0; i < lastElem + 1; i++)
        {
            System.out.print(mh.array[i] + " ");
        }
    }
}
