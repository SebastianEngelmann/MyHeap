/**
 * Created by sebastian on 25.11.16.
 */
public class RunApp {
    public static void main(String[] args)
    {
        MyHeap myHeap = new MyHeap(6);
        myHeap.insert(5);
        myHeap.insert(3);
        myHeap.insert(2);
        myHeap.insert(1);
        //myHeap.insert(8);
        //myHeap.insert(8);
        myHeap.print();
    }
}
