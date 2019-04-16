import java.awt.desktop.SystemEventListener;

public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree bt5 = new BinaryTree( 10 );
        BinaryTree bt6 = new BinaryTree( 25 );
        BinaryTree bt3 = new BinaryTree( 70 );
        BinaryTree bt4 = new BinaryTree( 34 );

        BinaryTree bt1 = new BinaryTree( 50 );
        bt6.attachLeft( bt5 );
        bt1.attachLeft( bt6 );

        bt3.attachLeft( bt4 );
        bt1.attachRight( bt3 );

        BinaryTree bt2 = new BinaryTree( 78 );
        BinaryTree bt7 = new BinaryTree( 63 );
        bt2.attachLeft( bt7 );

        BinaryTree bt = BinaryTree.combine( bt1,  bt2,  100 );

        System.out.print( "Pre order: " );
        bt.preOrder();
        System.out.print("\nIn order: ");
        bt.inOrder();
        System.out.print("\nPost order: ");
        bt.postOrder();

        System.out.println("\nLeftmost node: " + bt.getLowestLeftNode());
        System.out.println("Number of nodes: " + bt.getNumberOfNodes());
        System.out.println("Number of leaves: " + bt.getNumberOfLeaves());
        System.out.println("Number of levels in tree: " + bt.getNumberOfLevels());
    }

}