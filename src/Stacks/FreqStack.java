class FreqStack {

    Map<Integer, Integer> elements;
    int pushCount;
    PriorityQueue<Node> queue;

    public FreqStack() {
        elements = new HashMap<Integer, Integer>();
        pushCount = 0;
        queue = new PriorityQueue<Node>(new NodeComparator());
    }
    
    public void push(int el) {
        int freq = elements.getOrDefault(el, 0) + 1;
        elements.put(el, freq);
        
        Node elNode = new Node(el, freq, pushCount++);
        queue.offer(elNode);
    }

    public int pop() {
        Node res = queue.poll();
        elements.put(res.el, res.freq - 1);

        return res.el;
    }
    
    class Node {
        int el;
        int freq;
        int pushCount;

        public Node(int el, int freq, int pushCount) {
            this.el = el;
            this.freq = freq;
            this.pushCount = pushCount;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.freq != b.freq) return b.freq - a.freq;
            return b.pushCount - a.pushCount;
        }
    }
}

