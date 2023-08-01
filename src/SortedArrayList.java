import java.lang.reflect.Array;

public class SortedArrayList<E extends Comparable> extends List<E> {

    private int size;
    private int capacity;
    private Object[] ls;

    // TODO: default: should create a sortedarraylist that is capable of holding 10 element
    public SortedArrayList(){
        this.capacity = 10;
        this.size = 0;
        this.ls = new Object[capacity];
    }

    // TODO: second constructor - should create a sortedarraylist that is capable of holding x element that size
    public SortedArrayList(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.ls = new Object[capacity];
    }

    public int size(){
        return this.size;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E) this.ls[index];
    }

    // TODO: inserts element while maintaining the sorted order of the contents; resize to double capacity if no space
    public void add(E value) {
        Object[] tempLS = new Object[capacity];
        int i;

        if (this.ls[0] == null) {
            this.ls[0] = value;
            size++;
        }

        if (this.size == this.capacity) { //if size is same as capacity, that means that there's no space left
            this.capacity *= 2; //double capacity
            tempLS = this.ls; //saves list to tempLS
            this.ls = new Object[capacity]; //resizes to double capacity
            for (i = 0; i < this.capacity; i++) {
                this.ls[i] = tempLS[i]; //saves all elements from tempLS to ls
            }
            tempLS = new Object[capacity]; //tempLS resets back as an empty array
        }

        for (i = 0; i < this.capacity - 1; i++) { //check each value
            String temp = toString();
            String temp2 = value.toString();

            if (temp == temp2 || temp.compareTo(temp2) > 0) { //compare if they are the same OR greater
                tempLS[i] = this.ls[i]; // sets temporary variable first
                tempLS[++i] = value;  //value is put next, while i is already increased
                size+=2;
            }
            else { //if it's less than, then copy the element
                tempLS[i] = this.ls[i];
                size++;
            }
        }

        this.ls = tempLS; //copies temporary array to ls


    }


    // TODO: delete - deletes an element at said index; moves elements such that there are no gaps in between them
    public void delete(int index) throws IndexOutOfBoundsException{
        Object[] tempLS = new Object[capacity];

        if (index < 0 || index > this.capacity) {
            throw new IndexOutOfBoundsException(); //error if out of bounds
        }

        for (int i = 0, j = 0; i < this.capacity; i++) { //i is to check if it's the index, j is used to copy the element to a temporary list
            if (i == index) {
                continue; //keep going, but do not copy
            }
            tempLS[j++] = this.ls[i]; //temporary list values moved from list, i & j increases afterwards
        }
        this.ls = tempLS;


    }

    // TODO: search - binary search O(log(n)) for the element; returns -1 if not found
    public int search(E value){
        for (int i = 0; i < this.capacity; i++) {
            if (this.ls[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // TODO: given some other sortedarraylist, compare it to see if it has the same contents (also in same order)
    // need help with comparing objects
    public boolean equals(Object o){
        String link = toString();

        if (link == o) {
            return true;
        }

        else {
            return false;
        }
    }

    // helper
    public String toString(){
        String ret = "";
        for(int i = 0; i < this.capacity; i++){
            ret += i + ": "+ this.ls[i] + "\n";
        }
        return ret;
    }
}
