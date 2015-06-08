package concurrency.structures;

public class ListNode<T>
{
    private T info;
    private ListNode<T> next;

    public ListNode(T info)
    {
        this.info = info;
        next = null;
    }

    public void setNext(ListNode<T> node)
        {
        next = node;
    }

    public T getInfo()
    {
        return info;
    }

    public ListNode<T> getNext()
    {
        return next;
    }

    public String toString()
    {
        return info.toString();
    }
}
