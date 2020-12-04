public class Entry {
    public Object dataObject;
    public String status;

    public Entry() {
        status = "E";
    }

    public Entry(Object dataObject) {
        this.dataObject = dataObject;
        status = "O";
    }

    public void Entry(Object dataObject, String status){
        this.dataObject = dataObject;
        this.status = status;
    }

    public int getHashCode(){
        return dataObject.hashCode();
    }
    @Override
    public String toString() {
        return "Entry{" +
                "dataObject=" + dataObject +
                '}';
    }
}
