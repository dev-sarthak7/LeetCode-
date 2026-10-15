class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int k,int v){
            key=k;
            value=v;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> map;
    private final Node head, tail;
    public LRUCache(int capacity) {
        this.capacity= capacity;
        map= new HashMap<>();
        head= new Node(-1,-1);
        tail= new Node(-1,-1);

        head.next= tail;
        tail.prev= head;
    }
    private void remove(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }
    private void addToHead(Node node){
        node.next= head.next;
        node.prev= head;
        node.next.prev= node;
        head.next= node;
    }
    private void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }
    private Node removeLRU(){
        Node node= tail.prev;
        node.prev.next= tail;
        tail.prev= node.prev;
        return node;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node= map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            node.value= value;
            map.put(key,node);
            moveToHead(node);
            return;
        }
        Node node = new Node(key, value);
        addToHead(node);
        map.put(key,node);
        if(map.size()>capacity){
            Node lru= removeLRU();
            map.remove(lru.key);
        }
        return;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */