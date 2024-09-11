public class DoublyLinkedList implements ListTAD {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public int item;
        public Node previous;
        public Node next;

        public Node(int element) {
            this.item = element;
            this.previous = null;
            this.next = null;
        }

        public Node(int element, Node previous, Node next) {
            this.item = element;
            this.previous = previous;
            this.next = next;
        }
        public Node() {
            this.item = 0;
            this.previous = null;
            this.next = null;
        }
    }
    public DoublyLinkedList()
    {
        //Implementar
    }
    
    @Override
    public void add(int element) {
        // TODO Auto-generated method stub
        Node newNode=new Node(element,trailer.previous,trailer);
        newNode.previous.next=newNode;
        trailer.previous=newNode;
        count++;
    }

    @Override
    public void add(int index, int element) {
        // TODO Auto-generated method stub
        if(count>=index){
            Node newNode=new Node(element);
            Node tempNode=header;
            for(int i=0;i<=index;i++){
                tempNode=tempNode.next;
                    if(i==index){
                    newNode.next=tempNode;
                    newNode.previous=tempNode.previous;
                    newNode.previous.next=newNode;
                    tempNode.previous=newNode;
                    count++;
                    }
                }
        }

    @Override
    public void addFirst(int e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFirst'");
    }

    @Override
    public int get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int getFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public int getLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLast'");
    }

    @Override
    public int set(int index, int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public boolean remove(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int removeByIndex(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeByIndex'");
    }

    @Override
    public int removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public int removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public int indexOf(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ("[");
        Node atual=header.next;
        while(atual!=trailer)
        {
            sb.append(atual.item).append(" ");
            atual=atual.next;
        }
        sb.append("]")    
        return sb.toString();
    }

}
