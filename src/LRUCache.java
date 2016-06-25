import java.util.HashMap;

/**
 * http://www.ideserve.co.in/learn/lru-cache-implementation
 * Created by Prashant on 6/24/16.
 */
public class LRUCache {
    private int cacheSize;
    private DoublyLinkedList pageList;
    private HashMap<Integer, Node> pageMap;

    LRUCache(int size) {
        cacheSize = size;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<Integer, Node>();
    }

    // Access Page method.
    public void accessPage(int pageNumber) {
        Node pageNode = null;
        if(pageMap.containsKey(pageNumber)) {
            // If page exists in the cache, move it to the front.
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToFront(pageNode);
        } else {
            // If page doesn't exists in the cache, add it to the front of the cache.
            if(pageList.getCurrSize() == pageList.getSize()) {
                // If cache is full, remove tail from the pageList and remove the
                // pageNode from the pageMap too.
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);

        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        System.out.print(" ");
    }
}

class DoublyLinkedList {
    private int listSize;
    private int currSize;
    private Node head;
    private Node tail;

    DoublyLinkedList(int size) {
        listSize = size;
        currSize = 0;
    }

    // move page to front of doubly list method.
    public void movePageToFront(Node pageNode) {
        if(pageNode == null || pageNode == head) return;

        if(pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        Node prev = pageNode.getPrev();
        Node next = pageNode.getNext();

        prev.setNext(next);

        if(next != null) {
            next.setPrev(prev);
        }

        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }

    // add page to doubly list method.
    public Node addPageToList(int pageNumber) {
        Node pageNode = new Node(pageNumber);
        if(head == null) {
            head = pageNode;
            tail = pageNode;
            currSize = 1;
            return pageNode;
        } else if(currSize < listSize) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;

        return pageNode;
    }

    public void printList() {
        Node tmp = head;
        while(tmp!=null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public int getSize() {
        return listSize;
    }

    public int getCurrSize() {
        return currSize;
    }

    public Node getTail() {
        return tail;
    }

}

class Node {
    private int pageNumber;
    private Node prev;
    private Node next;

    public Node(int pageNumber) {
        this.pageNumber = pageNumber;
        prev = null;
        next = null;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPrev(Node pageNode) {
        prev = pageNode;
    }

    public void setNext(Node pageNode) {
        next = pageNode;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public String toString() {
        return pageNumber + " ";
    }
}
