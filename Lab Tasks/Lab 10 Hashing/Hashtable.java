import java.util.Arrays;

public class Hashtable {
    private Entry array[];


    public Hashtable(int n) {
        this.array = new Entry[n];
    }

    public void insert(Object object){
        Entry entry = new Entry(object);
        int index = ((int) entry.dataObject %13) %13;
        if(array[index] == null || !array[index].status.equals("O"))
            array[index] = entry;
        else {
            boolean empty = false;
            for(int i =1; !empty && i < array.length; i++){
                int newIndex =((int) entry.dataObject + i) %13;
                if(array[newIndex]==null || !array[newIndex].status.equals("O")){
                    empty = true;
                    array[newIndex] = entry;
                }
            }
        }
    }

    public boolean retrieve(Object object){
        Entry entry = new Entry(object);
        int index = ((int) entry.dataObject %13) %13;
        if(array[index] == null || array[index].status.equals("E"))
            return false;

        else {
            if (array[index].status.equals("O") && (int) array[index].dataObject == (int) entry.dataObject){
                return true;
            }
            for(int i =1; i < array.length; i++){
                int newIndex =((int) entry.dataObject + i) %13;
                if(array[newIndex] == null || array[newIndex].status.equals("E")){
                    return false;
                } else {
                    if (array[newIndex].status.equals("O") && (int) array[newIndex].dataObject == (int) entry.dataObject){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public Object delete(Object object) {
        if (!retrieve(object)) {
            System.out.println("Object not found for deletion");
        }
        Entry entry = new Entry(object);
        int index = ((int) entry.dataObject % 13) % 13;
        if (array[index].status.equals("O") && (int) array[index].dataObject == (int) entry.dataObject) {
            Object temp = array[index].dataObject;
            array[index].dataObject = null;
            array[index].status = "D";
            return temp;
        }
        for (int i = 1; i < array.length; i++) {
            int newIndex = ((int) entry.dataObject + i) % 13;
            if (array[newIndex].status.equals("O") && (int) array[newIndex].dataObject == (int) entry.dataObject) {
                Object temp = array[newIndex].dataObject;
                array[newIndex].dataObject = null;
                array[newIndex].status = "D";
                return temp;
            }
        }
        return "Unreachable Statement But its there for the stupid Java compiler";
    }

    @Override
    public String toString() {
        return "Hashtable{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
