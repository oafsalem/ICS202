public class Solution {
    public static void main(String[] args) {
        System.out.println(stringFindSmallest(["this", "bruh", "is", "I", "This is Sparta"], 0));

    }

    public static StringFindSmallest(String[] array, int index){
        if (index == array.length -1){
            return array[index];
        }
        if(array[index].length() > StringFindSmallest(array, index +1))
            return array[index];
        else
            return StringFindSmallest(array, index +1);
    }
}
