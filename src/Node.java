public class Node {
    // instance variables
    private int data;
    private Node left;
    private Node right;

    public Node( int value )
    {
        data = value;
        left = null;
        right = null;
    }

    public Node getLeft( )
    {
        return left;
    }

    public Node getRight( )
    {
        return right;
    }

    public int getData( )
    {
        return data;
    }

    public void setLeft( Node nd )
    {
        left = nd;
    }

    public void setRight( Node nd )
    {
        right = nd;
    }

    public void setData( int value )
    {
        data = value;
    }

}
