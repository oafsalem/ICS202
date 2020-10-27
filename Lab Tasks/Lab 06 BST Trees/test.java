public class test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        System.out.println(bst.count());
    }
    
}
