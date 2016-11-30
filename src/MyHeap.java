/**
 * Created by sebastian on 25.11.16.
 */

public class MyHeap {
    // Attribute
    private int[] array;
    private int lastElem;
    private int root;

    // Konstruktor
    public MyHeap(int n)
    {
        this.array = new int[n];
        this.lastElem = -1; // Zeiger auf Index des letzten besetzten Elementes
        this.root = 0; // Index der Wurzel
    }

    // Methoden
    public void insert(int k) throws Exception
    {
        if(lastElem == array.length - 1) // Array voll?
        {
            throw new Exception("Heap ist ueberfuellt!");
        }
        else
        {
            increaseLastElem(); // erhoehe lastElem um 1
            array[lastElem] = k; // speichere k an der Stelle lastElem im Array
            bubbleUp(lastElem); // bubbleUp falls noetig
        }
    }

    public int deleteMin() throws Exception
    {
        if(lastElem == -1)
        {
            throw new Exception("Heap ist leer!");
        }
        else
        {
            int result = array[0];
            array[0] = array[lastElem]; // ersetze Wurzel mit letztem Element im Heap
            decreaseLastElem(); // veringere lastElem um 1
            bubbleDown(root);
            return result;
        }
    }

    private void bubbleDown(int k)
    {
        if(array[root] < array[getLeftChildIndex(root)] && array[root] < array[getRightChildIndex(root)]) // Wurzel kleiner als Kinder?
        {
            return; // breche ab
        }
        else
        {
            int help = root;
            while((hasLeftChild(help) == true || hasRightChild(help)) == true && (less(getLeftChildIndex(help), help) || less(getParentIndex(help), help)))
            {
                if(less(getLeftChildIndex(help), getRightChildIndex(help)) == true) // linkes Kind von root kleiner als rechtes Kind von root?
                {
                    swap(getLeftChildIndex(help), help); // tausche linkes Kind mit Elternknoten
                    help = getLeftChildIndex(help);
                }
                if(less(getRightChildIndex(help), getLeftChildIndex(help)) == true) // rechtes Kind von root groesser als linkes Kind von root?
                {
                    swap(getRightChildIndex(help), help); // tausche rechtes Kind mit Elternknoten
                    help = getRightChildIndex(help);
                }
            }
        }
    }

    private void swap(int i, int j)
    {
        int tmp = array[i]; // speichere das i-te Element im Array in tmp
        array[i] = array[j]; // ueberschreibe das i-te Element mit dem j-ten Element im Array
        array[j] = tmp; // ueberschreibe das j-te Element mit tmp im Array
    }

    private boolean less(int i, int j)
    {
        if(i > lastElem || j > lastElem)
        {
            return false;
            //break;
        }
        else
        {
            return array[i] < array[j]; // wenn das i-te Element < j-te Element im Array, gib true zurueck
        }
    }

    private void bubbleUp(int k)
    {
        if(getParentIndex(lastElem) < 0) // Index des Elternknotens von lastElem < 0 ?
        {
            return; // breche ab
        }
        else
        {
            int help = lastElem;
            while(help >= 0 && getParentIndex(help) >= 0 && less(help, getParentIndex(help))== true) // Elternknoten < Kindknoten?
            {
                swap(getParentIndex(help), help); // tausche Elternknoten mit Kindknoten
                help = getParentIndex(help); //
            }
        }
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

    private void increaseLastElem()
    {
        this.lastElem++; // erhoehe lastElem um 1
    }

    private void decreaseLastElem()
    {
        this.lastElem--; // veringere lastElem um 1
    }

    private boolean hasLeftChild(int k)
    {
        return (2 * k + 1 <= lastElem)? true:false;
    }

    private boolean hasRightChild(int k)
    {
        return (2 * k + 2 <= lastElem)? true:false;
    }

    public void updateKey(int i, int j)
    {
        int index = findKey(i);
        array[index] = j; // ersetze Schluessel i durch Schluessel j
        int ls = lastElem;
        int r = root;
        if(array[index] < array[getParentIndex(index)])
        {
            lastElem = index;
            bubbleUp(index);
            lastElem = ls;
        }
        if((getRightChildIndex(index) <= lastElem && array[index] > array[getRightChildIndex(index)]) || (getLeftChildIndex(index) <= lastElem && array[index] > array[getLeftChildIndex(index)]))
        {
            root = index;
            bubbleDown(index);
            root = r;
        }
    }

    public int findKey(int i)
    {
        int result = -1;
        for(int j = 0; j < lastElem + 1; j++)
        {
            if(i == array[j]) // zu ersetzender Schluessel im Array?
            {
                result = j; // gib Index zurueck
                break;
            }
        }
        return result;
    }


    public void print()
    {
        for(int i = 0; i < lastElem + 1; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
}
