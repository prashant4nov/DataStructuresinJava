package Array;

/**
 * Created by Prashant on 6/12/16.
 * Compelxity of build heap looks like O(nlogn) but it's upper bound time complexity if O(n).
 * Best explanation: http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
 */
public class MinHeap {
    int size;
    int capacity;
    int[] a;

    MinHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.a = new int[capacity];
    }


    public int getParent(int child) {
        return (child-1)/2;
    }

    public int getLeftChild(int parent) {
        return (2*parent+1);
    }

    public int getRightChild(int parent) {
        return (2*parent+2);
    }

    public void insertKey(int key) {
        if(size==capacity) {
            System.out.println("Heap full!");
            return;
        }

        size += 1;
        a[size-1] = key;
        perculateUp(size-1);
    }

    public void perculateUp(int index) {
        if(index==0) {
            return;
        }
        int parent = getParent(index);
        int tmp = a[index];
        if(a[parent]>a[index]) {
            a[index] = a[parent];
            a[parent] = tmp;
            perculateUp(parent);
        }
    }

    public int getMin() {
        return a[0];
    }
    public int extractMin() {
        int min = a[0];
        a[0] = a[size-1];
        size--;
        Heapify(0);

        return min;
    }

    public void Heapify(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        int minIndex = index;
        int minValue = a[index];

        if(leftChild<size&&a[leftChild]<a[minIndex]) {
            minIndex = leftChild;
        }

        if(rightChild<size&&a[rightChild]<a[minIndex]) {
            minIndex = rightChild;
        }

        if(minIndex!=index) {
            minValue = a[minIndex];
            a[minIndex] = a[index];
            a[index] = minValue;
            Heapify(minIndex);
        }
    }


    public static void main(String[] args) {
        MinHeap h = new MinHeap(6);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

        System.out.println(h.extractMin());
        System.out.println(h.getMin());

        System.out.println("array:");
        for(int i=0;i<h.a.length;i++) {
            System.out.print(h.a[i]+" ");
        }

        System.out.println();

    }
}
