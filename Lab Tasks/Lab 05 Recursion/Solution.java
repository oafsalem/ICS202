public class Solution {
    public static void main(String[] args) {
        String[] array = {"this", "is", "I", "My name is bla bla bla", "bla bla bla"};
        System.out.println(findSmallest(array, 0));
        System.out.println(findLongest(array, 0));
        System.out.println(putCommas(1237811234));

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


}
