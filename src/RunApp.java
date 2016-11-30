/**
 * Created by sebastian on 25.11.16.
 */
public class RunApp {
    public static void main(String[] args) throws Exception {
        MyHeap myHeap = new MyHeap(6);
        myHeap.insert(6);
        myHeap.insert(3);
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.insert(8);
        myHeap.insert(0);
        myHeap.print();
        myHeap.deleteMin();
        myHeap.print();
        myHeap.updateKey(2, 0);
        myHeap.print();
        myHeap.updateKey(1, 9);
        myHeap.print();
    }
}
