public class Node
{
    private int count;
    private Node next;
    private Node prev;

    public Node(int value)
    {
        count = value;
        next = null;
        prev = null;
    }

    public int getVal()
    {
        return count;
    }

    public Node getNext()
    {
        return next;
    }

    public Node getPrev()
    {
        return prev;
    }

    public void setNext(Node nextNode)
    {
        next = nextNode;
    }

    public void setPrev(Node prevNode)
    {
        prev = prevNode;
    }
}
