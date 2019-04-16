public class BinaryTree {
    // instance variables
    private Node root;
    private int lowestLevel = 0;
    private int lowestLeftNode;
    private int numberOfNodes = 0;

    public BinaryTree( )
    {
        root = null;
    }

    BinaryTree(int value)
    {
        root = new Node( value );
    }

    void attachLeft(BinaryTree bt)
    {
        if( root.getLeft( ) == null ) // no left child
            root.setLeft( bt.root );
    }

    void attachRight(BinaryTree bt)
    {
        if( root.getRight( ) == null ) // no right child
            root.setRight( bt.root );
    }

    static BinaryTree combine(BinaryTree left, BinaryTree right, int value)
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
    void inOrder()
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
    void postOrder()
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

    int getLowestLeftNode() {
        return getLowestLeftNode(root);
    }

    int getNumberOfNodes() {
        return numberOfNodes;
    }

    private int countNumberOfLeaves(Node nd) {
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

     private void levelOrder(Node root)
    {
        int height = getNumberOfLevels();
        int i;
        for (i = 1; i <= height; i++)
        {
            printCurrentLevel(root, i);
            System.out.println();
        }
    }
    /* Print nodes at a given level */
    private void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.getData());
        else if (level > 1)
        {
            printCurrentLevel(root.getLeft(), level - 1);
            printCurrentLevel(root.getRight(), level - 1);
        }
    }

    void printLevelOrder() {
        levelOrder(root);
    }


}
