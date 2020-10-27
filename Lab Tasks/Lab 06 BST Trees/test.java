public class test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(15);
        //              5
        //          2       10
        //                      20
        //                  15       30
        System.out.println(bst.count());
        System.out.println(bst.countLeaves());
        System.out.println(bst.isAtLevel(new BSTNode<Integer>(2)));
        System.out.println(bst.height());
        System.out.println("Step 6 testing");
        BST<Integer> bst1 = new BST<Integer>();
        for(int i =0; i < 5; i++){
            bst1.insert((int) (Math.random()*5));
        }
        bst1.breadthFirst();
        System.out.println();
        bst1.preorder();
        System.out.println();
        bst1.inorder();
        System.out.println();
        bst1.postorder();
        System.out.println();
        System.out.println(bst1.count());
        System.out.println(bst1.countLeaves());
        System.out.println(bst1.isAtLevel(new BSTNode<Integer>(3)));
        System.out.println(bst1.height());
    }
    
}
