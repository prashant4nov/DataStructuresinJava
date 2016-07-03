package Array;

/**
 * Created by Prashant on 7/2/16.
 * http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 */

class MinHeapNode{
    int element;
    int i;
    int j;
}

class MinHeapModified {
    int size;
    int capacity;
    MinHeapNode[] a;

    MinHeapModified(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.a = new MinHeapNode[capacity];
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

    public void insertKey(int key, int i, int j) {
        if(size==capacity) {
            System.out.println("Heap full!");
            return;
        }

        size += 1;
        a[size-1].element = key;
        a[size-1].i = i;
        a[size-1].j = j;
        perculateUp(size-1);
    }

    public void perculateUp(int index) {
        if(index==0) {
            return;
        }
        int parent = getParent(index);
        MinHeapNode tmp = a[index];
        if(a[parent].element>a[index].element) {
            a[index] = a[parent];
            a[parent] = tmp;
            perculateUp(parent);
        }
    }

    public int getMin() {
        return a[0].element;
    }
    public int extractMin() {
        int min = a[0].element;
        a[0] = a[size-1];
        size--;
        Heapify(0);

        return min;
    }

    public void Heapify(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        int minIndex = index;
        MinHeapNode minValue = a[index];

        if(leftChild<size&&a[leftChild].element<a[minIndex].element) {
            minIndex = leftChild;
        }

        if(rightChild<index&&a[rightChild].element<a[minIndex].element) {
            minIndex = rightChild;
        }

        if(minIndex!=index) {
            minValue = a[minIndex];
            a[minIndex] = a[index];
            a[index] = minValue;
            Heapify(minIndex);
        }
    }



}

public class MergeKSortedArray {
    public static void main(String[] args) {
        int arr[][] = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;
        int k = arr.length;
        int n = arr[0].length;
        MinHeap minHeap = new MinHeap(k);
        for(int m=0;m<k;m++) {
          //  minHeap.insertKey(arr[][0], i, j);
        }
        System.out.print(" ");
    }
}
