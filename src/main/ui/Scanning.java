package ui;

import interactionException.*;
import model.Motto;
import model.Wiseman;
import model.Wiseman2;
import model.Wiseman3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Scanning {

    private Scanner scanner;
    private String input = "";
    private String input2;
    private String chooseWiseman;
    private Wiseman wiseman1;
    private Wiseman2 wiseman2;
    private Wiseman3 wiseman3;

    Scanning(Wiseman wiseman1, Wiseman2 wiseman2, Wiseman3 wiseman3) {
        scanner = new Scanner(System.in);
        this.wiseman1 = wiseman1;
        this.wiseman2 = wiseman2;
        this.wiseman3 = wiseman3;
        start();

    }

    private void start()  {
        System.out.println("Which wiseman you want to talk with");
        System.out.println("1. mottowiseman");
        System.out.println("2. dreamwiseman");
        System.out.println("3. weatherwiseman");
        chooseWiseman = scanner.nextLine();
        System.out.println("you chose: " + chooseWiseman);
        chooseWiseman();
    }

    private void chooseWiseman()  {
        if (chooseWiseman.equals("1")) {
            wiseman1.wisemanInfo();
            processOperations();
        }
        if (chooseWiseman.equals("2")) {
            wiseman2.wisemanInfo();
            dreamTalker();
        }
        if (chooseWiseman.equals("3")) {
            wiseman3.wisemanInfo();
            inputCity();
        }
    }

    private void processOperations() {
        while (true) {
            introduct();
            input = scanner.nextLine();
            System.out.println("you chose: " + input);
            try {
                if (decisions() == 9) {
                    System.out.println("Parting is for the next better reunion");
                    wiseman1.printDashLine();
                    System.out.println("May the force be with you :)");
                    break;
                }
            } catch (ChooseWord chooseWordword) {
                System.out.println("This is not a valid request! Can you give me a valid number?");
            } finally {
                wiseman1.printDashLine();
            }
        }
    }

    private void introduct() {
        System.out.println("You found the mottowiseman, he said 'Young man, give me a number' \n" +
                "Input numbers: 1, 2 or 3. \n" +
                "1: Tell your motto \n" +
                "2: For a daily motto\n" +
                "3: Leave");
    }

    private int decisions() throws ChooseNumber {
        if (input.equals("1")) {
            choose1();
            return 0;
        }
        if (input.equals("2")) {
            choose2();
            return 0;
        }
        if (input.equals("3")) {
            return 9;
        } else {
            throw new ChooseNumber();
            //return 0;
        }
    }
    private void choose1() {
        //Wiseman tempWiseman = (Wiseman) wiseman2;
        System.out.println("Tell wiseman your motto");
        //String input1 = scanner.nextLine();
        Motto input1 = new Motto(scanner.nextLine());
        System.out.println("you told him " + input1);
        try {
            wiseman1.addMotto(input1);
        } catch (EmptyMotto emptyMotto) {
        }
        System.out.println("wiseman noded his head, it seems he agrees with you");
        wiseman1.printDashLine();
    }

    private void choose2() {
        // Wiseman tempwiseman1 = (Wiseman) wiseman2;
        System.out.println("This is what wiseman want to tell you about:");
        int x = wiseman1.getMotto().size() - 1;
        int randomNum = ThreadLocalRandom.current().nextInt(0, x + 1);
        System.out.print(randomNum + " .");
        System.out.println(wiseman1.getMotto().get(randomNum));
        wiseman1.printDashLine();
    }

//---------------------------------------------------------------
    private void dreamTalker() {
        while (true) {
            dreamTalkerRandomWords();
            input2 = scanner.nextLine();
            System.out.println("you chose: " + input2);
            try {
                if (decisionDream() == -9) {
                    wiseman2.save();
                    System.out.println("May the force be with you :)");
                    break;
                }
            } catch (IOException e) {
                System.out.println("Java cannot find the file!");
                break;
            }
//            catch (ChooseLetter chooseLetter) {
//                System.out.println("This is a invalid letter! Could you give another letter");
//            }
        }
    }

    private void dreamTalkerRandomWords() {
        System.out.println("You found the dreamwiseman, he said 'Young man, give me a letter' \n" +
                "a. Tell your dream \n" +
                "b. See what you have dreamed before \n" +
                "c. Delete a dream \n" +
                "d. Leave");
    }

    private int decisionDream() throws IOException {
        if (input2.equals("a")) {
            chooseA();
        }
        if (input2.equals("b")) {
            System.out.println("These are the dream you have wished before");
            wiseman2.load();
            //System.out.println(wiseman2.load());
            System.out.println(wiseman2.printDream());
        }
        if (input2.equals("c")) {
            chooseC();
        }
        if (input2.equals("d")) {
            return -9;
        } else {
            return 0;
        }
    }

    private void chooseA() {
        // Wiseman2 tempwiseman2 = (Wiseman2) wiseman1;
        System.out.println("Tell wiseman a simple dream you have");
        String input3 = scanner.nextLine();
        System.out.println("you told him " + input3);
        try {
            wiseman2.addDream(input3);
            System.out.println("He wish you that dream comes true");
        }
        catch (EmptyStringException emptyDream) {
            System.out.println("This is an empty string!");
        }
        wiseman2.printDashLine();
    }

    private void chooseC() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data/outputfile.txt"));
        // Wiseman2 tempwiseman2 = (Wiseman2) wiseman1;
        System.out.println("which dream you want to delete");
        String input4 = scanner.nextLine();
        System.out.println(input4);
        wiseman2.getDream().remove(input4);
        while (lines.contains(input4)) {
            lines.remove(input4);
        }
        PrintWriter writer = new PrintWriter("data/outputfile.txt", "UTF-8");

        for (String line: lines) {
            writer.println(line);
        }
        writer.close();
        //wiseman2.printDashLine();
        System.out.println("The dream now you have:");
        System.out.print(wiseman2.printDream());
        wiseman2.load();
        wiseman2.notifyObserver();
    }

    private void inputCity()  {
        String input3;
        input3 = scanner.nextLine();
        System.out.println("This is what weatherwiseman predicted!");
        try {
            wiseman3.predict(input3);
        } catch (IOException e) {
            System.out.println("This is invalid! Try again?");
        }
    }

}


