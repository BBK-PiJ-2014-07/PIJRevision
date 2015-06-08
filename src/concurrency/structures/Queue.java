package concurrency.structures;


public class Queue<T>
        extends List<T>
{
    public ListNode<T> remove()
    {
        return super.remove(0);
    }

    public ListNode<T> remove(int index)
    {
        System.out.println("This is a queue, so removing from the front");
        return remove();
    }
}
