
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] array = {"this", "is", "I", "My name is bla bla bla", "bla bla bla"};
        System.out.println(findSmallest(array, 0));
        System.out.println(findLongest(array, 0));
        System.out.println(putCommas(1237811234));
        DLL<Integer> test2 = new DLL<Integer>();
		for(int i = 0; i < 10; i++) {
			test2.addToTail(i);
        }
        test2.printAll();
        System.out.println();
        deleteKth(4, test2.getHead(), 0);
        test2.printAll();
    }

    public static String findSmallest(String[] array, int index){
        if (index == array.length -1){
            return array[index];
        }
        String s = findSmallest(array, index +1);
        if(array[index].length() < s.length())
            return array[index];
        else
            return s;
    }
    public static String findLongest(String[] array, int index){
        if (index == array.length -1){
            return array[index];
        }
        String s = findLongest(array, index +1);
        if(array[index].length() > s.length())
            return array[index];
        else
            return s;
    }
    public static String putCommas(int x){
        if (x < 1000){
            return x + "";
        }
        return putCommas(x/1000) + String.format(",%3d",(x%1000));
    }
    public static DLLNode<Integer> deleteKth(int k, DLLNode<Integer> node, int count) throws Exception {
        if(k == count){
            if (node.next != null){
                node.next.prev = node.prev;
            }
            node.prev.next = node.next;
            return node;
        }
        if(node.next == null)
            throw new Exception("Error: K is out of the list");
        
        
        return deleteKth(k, node.next, ++count);
    }


}
