//Osama Ahmed Salem
//201814960
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class s201814960_Q1 {
    public static PrintWriter pw;
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = args[0];
        String outputFileName = args[1];
        File inputFile = new File(inputFileName);
        File tmpOutputFile = new File("tmp.txt");
        Scanner sc = new Scanner(inputFile);
        pw = new PrintWriter(tmpOutputFile);
        DLL myList = new DLL();
        Scanner scLine = new Scanner(sc.nextLine());
        while(scLine.hasNextInt()){
            int item = scLine.nextInt();

            myList.addToTail(item);
        }
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            String s = sc.next();
            switch (s) {
                case "ia":
                    myList.insertAfter(sc.nextInt(), sc.nextInt());
                    break;
                case "ib":
                    myList.insertBefore(sc.nextInt(), sc.nextInt());
                    break;
                case "db":
                    myList.deleteBefore(sc.nextInt());
            }
            if (i != count - 1) {
                ArrayList<Integer> al = myList.printAll();
                for (int j = 0; j < al.size() -1 ; j++) {
                    pw.print(al.get(j) + " ");
                }
                pw.print(al.get(al.size() - 1));
                if (i != (count -1))
                    pw.println();
            }
        }
        pw.close();
        //making a new pw and sc to remove the empty lines
        Scanner sc2 = new Scanner(tmpOutputFile);
        PrintWriter pw2 = new PrintWriter(new File(outputFileName));
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
            if(sc2.hasNextLine()){
                pw2.println(line);
            }
            else{
                pw2.print(line);
            }
        }
        pw2.close();
        sc.close();
        sc2.close();
        tmpOutputFile.deleteOnExit();
 }
}

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

//****************************  DLL.java  *******************************
//                  generic doubly linked list class
class DLLNode<T> {
    public T info;
    public DLLNode<T> next, prev;
    public DLLNode() {
        next = null; prev = null;
    }
    public DLLNode(T el) {
        info = el; next = null; prev = null;
    }
    public DLLNode(T el, DLLNode<T> n, DLLNode<T> p) {
        info = el; next = n; prev = p; 
    }
}

class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public void insertBefore(T newElem, T existingElem){
        if (isEmpty()) {
            s201814960_Q1.pw.println(-1);
            return;
        }
        boolean found = false;
        DLLNode<T> tmp = this.head;
        do {
            if (tmp.info == existingElem){
                if(tmp.info == head.info){
                    addToHead(newElem);
                    return;
                }
                DLLNode<T> newElemNode = new DLLNode<T>(newElem, tmp, tmp.prev);
                tmp.prev = newElemNode;
                newElemNode.prev.next = newElemNode;
                found = true;
                break;
            }
            tmp= tmp.next;
            } while (tmp != tail);

        if(!found){
            s201814960_Q1.pw.println(-1);
        }

    }
    public void insertAfter(T newElem, T existingElem){
        if (isEmpty()) {
            s201814960_Q1.pw.println(-1);
            return;
        }
        boolean found = false;
        DLLNode<T> tmp = this.head;
        do {
            if (tmp.info == existingElem){
                DLLNode<T> newElemNode = new DLLNode<T>(newElem, tmp.next, tmp.prev);
                tmp.next = newElemNode;
                found = true;
                break;
            }
            tmp= tmp.next;
            } while (tmp != tail);

        if (tail.info == existingElem){ // if we want to add after the last element
            DLLNode<T> newNode = new DLLNode<T>(newElem);
            tail.next = newNode;
            tail = tail.next;
            found = true;
        }
        if(!found){
            s201814960_Q1.pw.println(-1);
        }

    }
//    public void deleteBefore(T existingElem){
//        if (isEmpty()) {
//            System.out.println(-1);
//            return;
//        }
//        DLLNode<T> tmp = this.head;
//        boolean found = false;
//        do {
//            if (tmp.info == existingElem){
//                if(tmp == head){
//                    System.out.println("debug");
//                    System.out.println(-1);
//                    return;
//                }
//                else if (tmp.prev == head){
//                    System.out.println("debug head");
//                    deleteFromHead();
//                }
//                tmp = tmp.prev;
//                System.out.println("Bruh Deletion");
//                System.out.println(tmp.info);
//                    tmp.prev.next = tmp.next;
//                    tmp.next.prev = tmp.prev;
//                    found = true;
//                    return;
//            }
//            tmp= tmp.next;
//        } while (tmp != tail);
//
//        if(!found){
//            System.out.println(-1);
//        }
//    }
    public void deleteBefore(T existingElem){
        if (isEmpty()){
            s201814960_Q1.pw.println(-1);
            return;
        }
        DLLNode tmp = this.head;
        if (tmp.info == existingElem){
            s201814960_Q1.pw.println(-1);
            return;
        }
        if (tmp.next.info == existingElem) {
            deleteFromHead();
            return;
        }


        while (tmp.next != null) {
            if (tmp.next.info== existingElem) {
                tmp.prev.next = tmp;
                return;
            }
            tmp = tmp.next;
        }
        s201814960_Q1.pw.println(-1);
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
        else {
            head = tail = new DLLNode<T>(el);
        }

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
    public ArrayList<T> printAll() { 
        ArrayList<T> al = new ArrayList<>();
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             al.add(tmp.info);
             return al;
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
        }
        else{
            DLLNode<T> tmp = tail;
            while (tmp.prev != null){
                tmp = tmp.prev;
            }
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
