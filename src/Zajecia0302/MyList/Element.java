package Zajecia0302.MyList;

public class Element {
    private int data;
    private Element next;
    private Element prev;

    public int getData() {return data;}
    public void setData(int data) {this.data = data;}
    public Element getNext() {return next;}
    public void setNext(Element next) { this.next = next; }
    public Element getPrev() { return prev; }
    public void setPrev(Element prev) { this.prev = prev; }

    @Override
    public String toString() {
        return "Element{data=" + data +'}';
    }
}
