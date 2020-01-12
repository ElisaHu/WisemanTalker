package model;

import interactionexception.EmptyDream;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class DreamDealer {

    private ArrayList<String> dream;
    private Wiseman2 wiseman2;

    DreamDealer(Wiseman2 wiseman2) {
        this.wiseman2 = wiseman2;
    }

    //MODIFIES: this
    //EFFECTS: add dream to the list, throw exception if it is an empty string
    void addDream(String s)  {
//        if (s.equals("")) {
//            throw new EmptyDream();
//        }
        dream.add(s);
    }


    //EFFECTS: return the result
    String printDream() {
        return wiseman2.printResult(dream);
    }
//    public String printDream() {
//        String yourdream = "";
//        for (String s : dream) {
//            yourdream = yourdream + s + "\n";
//        }
//        return yourdream;
//    }

    ArrayList<String> getDream() {
        return dream;
    }


    //MODIFIES: txt
    //EFFECTS: save dream to another file
    void save() throws IOException {

        // PrintWriter writer = new PrintWriter("./outputfile.txt", "UTF-8");

        List<String> lines = Files.readAllLines(Paths.get("data/outputfile.txt"));

        PrintWriter writer = new PrintWriter("data/outputfile.txt", "UTF-8");

        for (String line: lines) {
            writer.println(line);
        }

        System.out.println("wiseman keeps (save) the dream for you.");

        for (String eachDream : getDream()) {
            writer.println(eachDream);
        }
        writer.close();


    }

    //MODIFIES: lines
    //EFFECTS: read the txt file and retrieve the dream
    String load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data/outputfile.txt"));

        String result = "";
        for (String line: lines) {
            result += line;  //result +
        }
        return result;
    }

    ArrayList setDream(ArrayList<String> dream) {
        this.dream = dream;
        return dream;
    }
}

