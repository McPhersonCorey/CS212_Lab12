public class BinaryTree {
    // instance variables
    private Node root;
    public int lowestLevel = 0;
    public int lowestLeftNode;
    public int numberOfNodes = 0;

    public BinaryTree( )
    {
        root = null;
    }

    public BinaryTree( int value )
    {
        root = new Node( value );
    }

    public void attachLeft( BinaryTree bt )
    {
        if( root.getLeft( ) == null ) // no left child
            root.setLeft( bt.root );
    }

    public void attachRight( BinaryTree bt )
    {
        if( root.getRight( ) == null ) // no right child
            root.setRight( bt.root );
    }

    public static BinaryTree combine( BinaryTree left, BinaryTree right, int value )
    {
        BinaryTree bt = new BinaryTree( value );
        bt.attachLeft( left );
        bt.attachRight( right );
        return bt;
    }

    // traverses in pre order the tree rooted at nd
    private void preOrder( Node nd )
    {
        if( nd != null )
        {
            System.out.print( nd.getData( ) + " " );
            // traverse the left subtree in pre order
            preOrder( nd.getLeft( ) );
            // traverse the right subtree in pre order
            preOrder( nd.getRight( ) );
        }
        // else, empty subtree, do nothing
    }

    // traverses the tree in pre order
    public void preOrder( )
    {
        preOrder( root );
    }

    // traverses in order the tree rooted at nd
    private void inOrder( Node nd )
    {
        if( nd != null )
        {
            numberOfNodes++;
            // traverse the left subtree in order
            inOrder( nd.getLeft( ) );
            System.out.print( nd.getData( ) + " " );
            // traverse the right subtree in order
            inOrder( nd.getRight( ) );
        }
        // else, empty subtree, do nothing
    }

    // traverses the tree in pre order
    public void inOrder( )
    {
        inOrder( root );
    }

    // traverses in post order the tree rooted at nd
    private void postOrder( Node nd )
    {
        if( nd != null )
        {
            // traverse the left subtree in post order
            postOrder( nd.getLeft( ) );
            // traverse the right subtree in post order
            postOrder( nd.getRight( ) );
            System.out.print( nd.getData( ) + " " );
        }
        // else, empty subtree, do nothing
    }

    // traverses the tree in pre order
    public void postOrder( )
    {
        postOrder( root );
    }

    private void find(Node root, int level, boolean left) {
        if (root != null) {
            find(root.getLeft(), ++level, true);
            if (left && lowestLevel < level) {
                lowestLeftNode = root.getData();
                lowestLevel = level;
            }
            find(root.getRight(), level, false);
        }
    }


    private int getLowestLeftNode (Node root) {
        find(root, 0, true);
        return lowestLeftNode;
    }

    public int getLowestLeftNode() {
        return getLowestLeftNode(root);
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    int countNumberOfLeaves(Node nd) {
        if (nd == null)
            return 0;
        if (nd.getLeft() == null && nd.getRight() == null)
            return 1;
        return countNumberOfLeaves(nd.getLeft()) + countNumberOfLeaves(nd.getRight());
    }

    int getNumberOfLeaves () {
        return countNumberOfLeaves(root);
    }

    int getNumberOfLevels () {
        return lowestLevel;
    }

}
