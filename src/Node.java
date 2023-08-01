public class Node implements Comparable {
    private String keyword;
    private List<String> references;

    // TODO: given some keyword, and mode (1 = arraylist 2 = sorted arraylist) set up the Node
    public Node(String keyword, int mode){
        this.keyword = keyword;
        if (mode == 1) {
            this.references = new ArrayList(); //reference to ArrayList class
        }
        else if (mode == 2) {
            this.references = new SortedArrayList(); //reference to SortedArrayList class
        }
    }

    public String getKeyword(){ //gets keyword
        return this.keyword;
    }

    public List getReferences(){ //gets list of references
        return this.references;
    }

    public void insertReference(String website){ //adds website url to list of references
        this.references.add(website);
    }


    // TODO: Compare some other Node to this Node, String compareTo is your bestfriend here; return -1 if the other object of comparison isn't a Node
    // Do we compare the list? Or both the keyword and the list?
    public int compareTo(Object o) {
        String privNodeKeyword = getKeyword();
        List privNodeReferences = getReferences();

        if (!(o instanceof Node)) { //if it's not a node, return -1
            return -1;
        }

        else {
            return 0; //I was told during Office Hours that it's only checking it's a Node or not
        }

        //Assuming it is a Node, start comparing by taking their counterparts
        //String oKeyword = ((Node) o).keyword;
        //List oReferences = ((Node) o).references;

        /*
        if (equals(o)) {
        ... //compare lists?
        }
         */
    }

    // TODO: similar to compareTo except in boolean format and is only concerned if the other Node has the same keyword or not
    public boolean equals (Object o) {
        if (o instanceof Node) {
            Node other = (Node) o;
            return this.keyword.equals(other.keyword);
        }
        else return false;
    }

    public String toString(){
        return this.keyword + " " + this.references;
    }


}
