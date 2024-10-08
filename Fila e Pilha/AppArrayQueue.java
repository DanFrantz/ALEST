public class AppArrayQueue {
    public static void main (String args[]){
        ArrayQueue aq=new ArrayQueue();
        aq.enqueue(10);
        aq.dequeue();
        aq.enqueue(20);
        aq.enqueue(100);
        aq.enqueue(42);
        aq.enqueue(432);
        aq.enqueue(3124);
        aq.enqueue(98);
        aq.enqueue(2345);
        aq.enqueue(999);
        aq.dequeue();
        aq.dequeue();
        aq.dequeue();
        aq.enqueue(99999);
        System.out.print(aq.indexOf(0)+" "+
        aq.indexOf(1)+" "+
        aq.indexOf(2)+" "+aq.indexOf(3)+" "+
        aq.indexOf(4)+" "+
        aq.indexOf(5)+" "+aq.indexOf(6)+aq.indexOf(7)+aq.indexOf(8));
        }
}
