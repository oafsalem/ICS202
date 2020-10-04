//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");                
    }
    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }

    public int length() {
        if (this.isEmpty())
            return 0;
        if (this.head == this.tail)
            return 1;
        SLLNode<T> tmp = this.head;
        int count= 0;
        while (tmp != tail){
            tmp = tmp.next;
            count++;
        }
        count++; // counting the tail here
        return count;
    }
    public void insertAfter(T newElem, T existingElem){
        if (isEmpty()) {
            throw new NullPointerException();
        }
        boolean found = false;
        SLLNode<T> tmp = this.head;
        do {
            if (tmp.info == existingElem){
                SLLNode<T> newElemNode = new SLLNode<T>(newElem, tmp.next);
                tmp.next = newElemNode;
                found = true;
                break;
            }
            tmp= tmp.next;
            } while (tmp != tail);

        if (tail.info == existingElem){ // if we want to add after the last element
            SLLNode<T> newNode = new SLLNode<T>(newElem);
            tail.next = newNode;
            tail = tail.next;
            found = true;
        }
        if(!found){
            throw new NullPointerException();
        }
    }
    public void deleteAfter(T elem){
        if (isEmpty()) {
            throw new RuntimeException();
        }
        if (head == tail && head.info == elem){
            head = tail = null;
        }
        SLLNode<T> tmp = this.head;
        boolean found = false;
        do {
            if (tmp.info == elem){
                if (tmp.next == tail){
                    tmp.next = null;
                    tail = tmp;
                    found = true;
                    break;
                }
                    tmp.next = tmp.next.next;
                    found = true;
                    break;
            }
            tmp= tmp.next;
        } while (tmp != tail);

        if(!found){
            throw new RuntimeException();
        }
    }
}
