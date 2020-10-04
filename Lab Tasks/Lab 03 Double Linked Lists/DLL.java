package com.company;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }
    public void printReverse() {
        if (head == tail){ // if the list has one item or no items
            if(head == null){
                throw new RuntimeException("This DLL IS Empty");
            }
            System.out.println(head.info);
        }
        else{
            DLLNode<T> tmp = tail;
            while (tmp.prev != null){
                System.out.print(tmp.info + " ");
                tmp = tmp.prev;
            }
            System.out.println(this.head.info);
        }
    }
    public void delete7(){
        if (head == tail){
            if(head ==null){
            throw new RuntimeException("This DLL IS Empty");
            }
            else{
                head = tail = null;
            }
        }
        else{
            int count = 1; //from one since im already in the head
            boolean found = false;
            DLLNode<T> tmp=head;
            while (!found){ // while i didnt reach the 7th element
                while(tmp.next != null){ // loop to go forward
                    if(count == 7){ // if we reach element 7;
                        found = true;
                        break;
                    }
                    else{ //still not there
                        tmp = tmp.next;
                        count++;
                    }
                    }
                if (!found && tmp == tail){ // while we still didnt find anything
                    while(tmp.prev != null){ // loop to go backwards
                        if(count == 7){ //if we reach element 7;
                            found = true;
                            break;
                        }
                        else{ // still not there
                            tmp = tmp.prev;
                            count++;
                        }
                    }
                }
            } //if found.
            if(tmp == head){
                head = tmp.next;
                head.prev = null;
            }
            else if(tmp == tail){
                tail = tmp.prev;
                tail.next = null;
            }
            else {
                tmp.prev.next = tmp.next;
                tmp.next.prev =tmp.prev;
            }
        }
    }
}