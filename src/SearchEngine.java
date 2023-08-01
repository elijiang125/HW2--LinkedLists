import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Collections.emptyList;

public class SearchEngine {

    private int mode;
    private List<Node> nodeList;

    // TODO: build the SearchEngine's nodelist according to mode (1 = ArrayList; 2 = SortedArrayList); build the searchEngine
    public SearchEngine(int mode) throws IOException {
        this.mode = mode;
        if (mode == 1) {
            nodeList = new ArrayList<>(); //note: the E can be anything, so Node works
        }
        if (mode == 2) {
            nodeList = new SortedArrayList<>(); //again, Node works
        }
        buildList(); //builds list
    }

    public List<Node> getNodeList(){
        return this.nodeList;
    }

    // TODO: Go through the dataset and then create a new Node if the word hasn't been seen before. Add the current URL to its references
    // if it hasn't been seen. If the node has been created already, add the current URL to its references. Add the Node to the the
    // SearchEngine's nodeList
    public void buildList() throws IOException {
        //runtime: O(n^3), is that concerning?

        BufferedReader reader = new BufferedReader(new FileReader("dataset.txt"));
        String url;
        while((url = reader.readLine()) != null){
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text().toLowerCase();
            String[] words = text.split("\\s+"); // splits by whitespace

            //put logic here

            for (int i = 0; i < this.nodeList.size(); i++) { //check each element in nodeList
                for (int j = 0; j < words.length; j++) { //check each word,

                    if (this.nodeList.get(i).toString() == words[j]) { /*node already created and same as node, add URL to its references*/
                        this.nodeList.get(i).getReferences().add(url); //add reference to nodeList

                    } else if (j == words.length - 1) { /* node not created, create a new Node and add URL to references*/
                        this.nodeList.add(new Node(words[j], this.mode));
                        this.nodeList.get(this.nodeList.size() - 1).getReferences().add(url); //adds recent reference to nodeList
                    }
                }
            }


        }
        reader.close();
        System.out.println("Finished reading through all URLs");
    }

    // TODO: Return the node's reference list - if the term isn't found, return an empty list
    public List<String> search(String term) {
        System.out.println("Searching for " + term + " using data structure mode " + mode + "...");
        // Search logic goes here

        for (int i = 0; i < this.nodeList.size(); i++) {
            if (this.nodeList.get(i).getKeyword() == term) {
                return this.nodeList.get(i).getReferences(); //returns reference list
            }
            else if (i == this.nodeList.size() - 1) {
                return this.nodeList.get(i).getReferences(); //returns empty list
            }
        }

        // Example code for displaying results
        System.out.println("Displaying results for " + term + ":");
        System.out.println("    1. URL 1: ");
        System.out.println("    2. URL 2: ");
        System.out.println("    3. URL 3: ");
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter mode as in what data structure to use:");
        System.out.println("    1. Array List ");
        System.out.println("    2. Sorted Array List");

        int mode = input.nextInt();

        System.out.println("Building Search Engine...");
        SearchEngine engine = new SearchEngine(mode);

        String answer = "y";
        while (answer.equals("y")) {
            input.nextLine(); // consume the remaining newline character
            System.out.print("Search (enter a term to query): ");
            String term = input.nextLine();
            engine.search(term);
            System.out.print("Would you like to search another term (y/n)? ");
            answer = input.nextLine();
        }
        input.close();
    }
}
