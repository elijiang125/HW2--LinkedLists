import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayList<E extends Comparable> extends List<E> {
    private int size;
    private int capacity;
    private Object[] ls;

    // TODO: default: should create an arraylist that is capable of holding 10 element
    // Notes: done
    public ArrayList(){

        this.capacity = 10;
        this.size = 0;

        this.ls = new Object[capacity];
    }

    // TODO: second constructor - should create an arraylist that is capable of holding x element
    //Notes: done
    public ArrayList(int capacity){
        this.capacity = capacity;
        size = 0;
        ls = new Object[capacity];
    }

    public int size(){
        return this.size; //returns object's size
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E) this.ls[index];
    }

    // TODO: insert --> takes some element and inserts it at the end of the arraylist, resizes to double capacity if no space
    // Notes: DONE
    public void add(E value){
        Object[] tempLS = new Object[capacity];
        int j = 0;

        if (this.size == this.capacity) { //if size is same as capacity, that means that there's no space left
            this.capacity *= 2; //double capacity
            tempLS = this.ls; //saves list to tempLS
            this.ls = new Object[capacity]; //resizes to double capacity
            for (j = 0; j < this.size; j++) {
                this.ls[j] = tempLS[j]; //move all elements from temp list to the doubled list
            }
        }

        this.ls[size()] = value; //add value to end of the list
        this.size++; //size increases because new number added in list
    }

    // TODO: delete - deletes an element at said index; moves elements such that there are no gaps in between them
    //Notes: done
    public void delete(int index) throws IndexOutOfBoundsException{
        Object[] tempLS = new Object[capacity];
        try {
            for (int i = 0, j = 0; i < this.capacity; i++) { //i is to check if it's the index, j is used to copy the element to a temporary list
                if (i == index) {
                    continue; //keep going, but do not copy
                }
                tempLS[j++] = this.ls[i]; //temporary list values moved from list, i & j increases afterwards
            }
            this.ls = tempLS;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }

    }

    // TODO: searches one by one to find the element, if it doesn't exist then return -1
    // Notes: done
    public int search(E value){
        for (int i = 0; i < this.capacity; i++) {
            if (this.ls[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // TODO: given some other arraylist, compare it to see if it has the same contents
    // NOTE: Need help comparing objects
    public boolean equals(Object o){
        Object[] s = (Object[]) o; //downcast to Object array type

        if (this.ls == s) {
            return true;
        }

        else {
            return false;
        }
    }

    // to help you
    public String toString(){
        String ret = "";
        for(int i = 0; i < this.size; i++){
            ret += i + ": "+ this.ls[i] + "\n";
        }
        return ret;
    }

}
