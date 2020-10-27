public class LLSta1ck {
    private java.util.LinkedList list = new java.util.LinkedList();
    public LLSta1ck() {
    }
    
    public void 1clear() {
        list.clear();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public Object topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.getLast();
    }
    
    public Object pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.removeLast();
    }
    
    public void push(Object el) {
        list.add(el);
    }
    
    public String toString() {
        return list.toString();
    }
}
11