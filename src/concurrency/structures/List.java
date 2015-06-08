package concurrency.structures;

public class List<T>
{
    protected ListNode<T> head;
    protected int size;

    public List()
    {
        head = null;
    }

    public ListNode<T> get(int index)
    {
        if ((head == null) || (index > size)) {
            return null;
        }
        if (index == 0) {
            return head;
        }
        ListNode<T> result = head;
        for (int i = 0; i <= index; i++) {
            result = result.getNext();
        }
        return result;
    }

    public synchronized void add(T value)
    {
        ListNode<T> newNode = new ListNode<>(value);
        if (head == null) {
            head = newNode;
        } else {
            get(size - 1).setNext(newNode);
        }
        size += 1;
        System.out.println(Thread.currentThread().getName() + " notifying all");
        notifyAll();
    }

    public synchronized ListNode<T> remove(int index)
    {
        try
        {
            while (head == null)
            {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " is go!");
            ListNode<T> deadNode = get(index);
            if (index == 0) {
                head = head.getNext();
            } else {
                get(index - 1).setNext(deadNode.getNext());
            }
            size -= 1;
            return deadNode;
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
