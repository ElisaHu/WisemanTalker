package ui;

import interactionException.EmptyDream;
import interactionException.EmptyMotto;
import model.Motto;
import model.Wiseman;
import model.Wiseman2;
import model.Wiseman3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Gui {
    private JFrame window;
    private Container con;
    private JPanel titleNamePanel;
    private JPanel startPanel;
    private JPanel mainTextPanel;
    private JPanel choiceButtonPanel;
    private JLabel titleNameLable;
    private JButton startButton;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JTextArea mainTextArea;
    private JTextField userinput;
    private TitleScreenHandler tsHandler = new TitleScreenHandler();
    private ChoiceHandler chHandler = new ChoiceHandler();
    private Choice1Handler c1Handler = new Choice1Handler();
    private Choice2abHandler c2Handler = new Choice2abHandler();
    private Choice2cdHandler c22Handler = new Choice2cdHandler();

    private Wiseman wiseman;
    private Wiseman2 wiseman2;
    private Wiseman3 wiseman3;

    private Font titleFont = new Font("Times New Roman",Font.PLAIN,80);
    private Font normalFont = new Font("Times New Roman",Font.PLAIN,30);

    private Gui() {

        ArrayList<String> dreamList = new ArrayList<>();
        ArrayList<Motto> mottos = new ArrayList<>();
        Motto motto1 = new Motto("It is not the length of life, but depth of life.");
        Motto motto2 = new Motto("No pain, no gain.");
        mottos.add(motto1);
        mottos.add(motto2);
        wiseman = new Wiseman(209,"normal",mottos);
        wiseman2 = new Wiseman2(999,"kind",dreamList);
        wiseman3 = new Wiseman3(10,"predicted");

        window = new JFrame();
        window.setSize(1050,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(200,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLable = new JLabel("wiseman talker");
        titleNameLable.setForeground(Color.white);
        titleNameLable.setFont(titleFont);

        startPanel = new JPanel();
        startPanel.setBounds(300,400,200,100);
        startPanel.setBackground(Color.black);

        startButton = new JButton("start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setVisible(true);

        startPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startPanel);
        titleNamePanel.add(titleNameLable);
        window.setVisible(true);
    }

    private void createGameScreen() {
        titleNamePanel.setVisible(false);
        startPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,800,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Which wiseman you want to talk with");
        mainTextArea.setBounds(100,100,800,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        createButtonPanel();

        choiceButtonPanel.setVisible(true);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }

    private void createButtonPanel() {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));

        choice1 = new JButton("1. mottowiseman");
        choice2 = new JButton("2. dreamwiseman");
        choice3 = new JButton("3. weatherwiseman");
        choice4 = new JButton("leave");
        setJButtonParam(choice1,"1");
        setJButtonParam(choice2,"2");
        setJButtonParam(choice3,"3");
        setJButtonParam(choice4,"4");
    }

    private void setJButtonParam(JButton button, String num) {
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        button.addActionListener(chHandler);
        button.setActionCommand(num);
        choiceButtonPanel.add(button);
    }

    private void talkToMottoWiseman() {
        mainTextArea.setText(wiseman.wisemanInfo() + "\n"
                + "he said 'Young man, what do you want?'");
        choice1.addActionListener(c1Handler);
        choice2.addActionListener(c1Handler);
        choice3.addActionListener(c1Handler);
        choice4.addActionListener(c1Handler);
        choice1.setText("1: Tell your motto");
        choice1.setActionCommand("1a");
        //choice1.addActionListener(moHandler);
        choice2.setText("2: For a daily motto");
        choice2.setActionCommand("1b");
        choice3.setText("3: Leave");
        choice3.setActionCommand("1c");
        choice4.setText("");
        choice4.setActionCommand("1c");
    }
    private void talkToDreamWiseman() {

        mainTextArea.setText(wiseman2.wisemanInfo() + "\n"
                + "He said 'Young man, what do you want?'");
        choice1.addActionListener(c2Handler);
        choice2.addActionListener(c2Handler);
        choice3.addActionListener(c2Handler);
        choice4.addActionListener(c22Handler);

        choice1.setText("a. Tell your dream");
        choice1.setActionCommand("2a");
        choice2.setText("b. See dream");
        choice2.setActionCommand("2b");
        choice3.setText("c. Delete a dream");
        choice3.setActionCommand("2c");
        choice4.setText("d. Leave");
        choice4.setActionCommand("2d");
    }

    private void talkToWeatherWiseman() {
        userinput = new JTextField(20);
        userinput.setSize(20,40);
        mainTextPanel.add(userinput);
        mainTextArea.setText(wiseman3.wisemanInfo()
                + "he said 'Young man, which city you want to know'");
        choice1.setText("enter");
        choice1.setActionCommand("3a");
        choice2.setText("leave");
        choice2.addActionListener(c1Handler);
        choice2.setActionCommand("1c");
        choice3.setText("");
        choice3.setActionCommand("1c");
        choice4.setText("");
        choice4.setActionCommand("1c");
    }

    private void predictWeather() throws IOException {

        mainTextArea.setText("This is what weather wiseman predicted! \n\t"
                + wiseman3.predict(userinput.getText()));
    }

    private void tellHimMotto() {
        mainTextArea.setText("tell him a motto");
        userinput = new JTextField(20);
        userinput.setSize(20,40);
        mainTextPanel.add(userinput);

        choice1.setVisible(true);
        choice1.setText("enter");
        choice1.setActionCommand("1a1");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    private void randomMotto() {
        int x = wiseman.getMotto().size() - 1;
        int randomNum = ThreadLocalRandom.current().nextInt(0, x + 1);
        mainTextArea.setText("This is what wiseman want to tell you about:" + "\n"
                + wiseman.getMotto().get(randomNum));
    }

    private void enterMotto() {

        mainTextArea.setText("Wiseman noded his head, it seems he agrees with you"
                + "\n"
                + " he said 'Young man, what do you want?'");
        Motto input = new Motto(userinput.getText());
        try {
            wiseman.addMotto(input);
        } catch (EmptyMotto emptyMotto) {

        }
        userinput.setVisible(false);
        choice1.setText("1: Tell your motto");
        choice1.setActionCommand("1a");
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
    }

    private void tellYouDream() {
        mainTextArea.setText("Tell wiseman a simple dream you have:");
        userinput = new JTextField(20);
        userinput.setSize(20,40);
        mainTextPanel.add(userinput);
        choice1.setVisible(true);
        choice1.setText("enter");
        choice1.setActionCommand("2a1");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    private void enterDream() {
        String input = userinput.getText();
        mainTextArea.setText("You told him: " + input + "\n"
                + "He wish you that dream comes true");
        try {
            wiseman2.addDream(input);
        } catch (EmptyDream emptyDream) {

        }
        userinput.setVisible(false);
        choice1.setText("1: Tell your dream");
        choice1.setActionCommand("2a");
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
    }

    private void seeDream() throws IOException {
        mainTextArea.setText("These are the dream you have wished before: " + "\n"
                + wiseman2.load() + "\n" + wiseman2.printDream());
    }

    private void deleteDream() {
        mainTextArea.setText("which dream you want to delete? ");
        userinput = new JTextField(20);
        userinput.setSize(20,40);
        mainTextPanel.add(userinput);
        choice1.setVisible(true);
        choice1.setText("enter");
        choice1.addActionListener(c22Handler);
        choice1.setActionCommand("2c1");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    private void setDelete() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data/outputfile.txt"));
        String input = userinput.getText();
        wiseman2.getDream().remove(input);
        while (lines.contains(input)) {
            lines.remove(input);
        }
        PrintWriter writer = new PrintWriter("data/outputfile.txt", "UTF-8");

        for (String line: lines) {
            writer.println(line);
        }
        writer.close();
        userinput.setVisible(false);
        choice1.setText("1: Tell your dream");
        choice1.setActionCommand("2a");
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
        mainTextArea.setText("The dream now you have:" + "\n" + wiseman2.printDream() + wiseman2.load());
    }

    private void saveDream() throws IOException {
        wiseman2.save();
        mainTextArea.setText("May the force be with you :)");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                },
                3000
        );
    }

    private void leaveWord() {
        mainTextArea.setText("Parting is for the next reunion"
                + "\n" + "May the force be with you :)");


        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                },
                3000
        );

    }

    public class TitleScreenHandler implements ActionListener {


        //EFFECT: activate the method when there is an event
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        //MODIFIES: this
        //EFFECT: choose which case to operate
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (yourChoice) {

                case "1": talkToMottoWiseman();
                    break;
                case "2": talkToDreamWiseman();
                    break;
                case "3": talkToWeatherWiseman();
                    break;


                case "3a":
                    try {
                        predictWeather();
                    } catch (IOException ex) {
                        System.out.println("IOException!");
                    }
                    break;


                default: break;

            }
        }

    }

    public class Choice1Handler implements ActionListener {

        //MODIFIES: this
        //EFFECT: choose which case to operate
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (yourChoice) {

                case "1a": tellHimMotto();
                    break;
                case "1a1": enterMotto();
                    break;
                case "1b": randomMotto();
                    break;
                case "1c":
                    leaveWord();
                    break;
                default: break;
            }
        }
    }

    public class Choice2abHandler implements ActionListener {

        //MODIFIES: this
        //EFFECT: choose which case to operate
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (yourChoice) {
                case "2a": tellYouDream();
                    break;
                case "2a1": enterDream();
                    break;
                case "2b":
                    try {
                        seeDream();
                    } catch (IOException ex) {
                        System.out.println("IOException!");
                    }
                    break;
                case "2c": deleteDream();
                    break;

                default: break;
            }
        }
    }

    public class Choice2cdHandler implements ActionListener {

        //MODIFIES: this
        //EFFECT: choose which case to operate
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (yourChoice) {

                case "2c1":
                    try {
                        setDelete();
                    } catch (IOException ex) {
                        System.out.println("IOException!");
                    }

                    break;
                case "2d":
                    try {
                        saveDream();
                    } catch (IOException ex) {
                        System.out.println("IOException!");
                    }
                    break;
                default: break;
            }
        }
    }

    //EFFECT: start the program
    public static void main(String[] args) {
        new Gui();
    }

}
