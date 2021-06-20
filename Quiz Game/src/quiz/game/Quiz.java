package quiz.game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * @author Dinamo
 */
public class Quiz implements ActionListener{
    
    String[] questions = {
                            "Which company created Java?",
                            "Which year was Java created?",
                            "What was Java originally called",
                            "Who is credited with creating Java"
                         };
    String[][] options ={
                        {"Sun Microsystems", "Oracle", "Michrosoft", "Facebook"},
                        {"1989", "1996", "1972", "1492"},
                        {"Apple", "Latte", "Oak", "Koffing"},
                        {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerburg"}
                        };
    char[] answers =  {
                       'A',
                       'B',
                       'C',
                       'C'
                      };
    char guess;
    char answer;
    int index;
    int correctGuesses = 0;
    int totalQuestions = questions.length;
    int result;
    int seconds = 10;
    
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea  textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel  answerLabelA = new JLabel();
    JLabel  answerLabelB = new JLabel();
    JLabel  answerLabelC = new JLabel();
    JLabel  answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secodsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JTextField precentage = new JTextField();
     Timer timer =  new Timer(1000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              seconds--;
              secodsLeft.setText(String.valueOf(seconds));
              if(seconds<= 0){
                  displayAnswer();
              }
           }
       });
    
    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        
        textfield.setBounds(0, 0, 650, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("Test");
        
        textarea.setBounds(0, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setText("seample txt");
        
        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");
        
        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");
        
        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");
        
    
        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");
        
        answerLabelA.setBounds(125, 100, 500,100);
        answerLabelA.setBackground(new Color(50, 50, 50));
        answerLabelA.setForeground(new Color(25, 255, 0));
        answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
        
        answerLabelB.setBounds(125, 200, 500,100);
        answerLabelB.setBackground(new Color(50, 50, 50));
        answerLabelB.setForeground(new Color(25, 255, 0));
        answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answerLabelC.setBounds(125, 300, 500,100);
        answerLabelC.setBackground(new Color(50, 50, 50));
        answerLabelC.setForeground(new Color(25, 255, 0));
        answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
        
        answerLabelD.setBounds(125, 400, 500,100);
        answerLabelD.setBackground(new Color(50, 50, 50));
        answerLabelD.setForeground(new Color(25, 255, 0));
        answerLabelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
        
            
        secodsLeft.setBounds(535, 510, 100, 100);
        secodsLeft.setBackground(new Color(25, 25, 25));
        secodsLeft.setForeground(new Color(255, 0 ,0));
        secodsLeft.setFont(new Font("Ink Free", Font.BOLD, 60));
        secodsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secodsLeft.setOpaque(true);
        secodsLeft.setHorizontalAlignment(JTextField.CENTER);
        secodsLeft.setText(String.valueOf(seconds));
        
        timeLabel.setBounds(535, 475, 100, 25);
        timeLabel.setBackground(new Color(50, 50, 50));
        timeLabel.setForeground(new Color(255, 0, 0));
        timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer >:D");
        
        numberRight.setBounds(255, 255, 200, 100);
        numberRight.setBackground(new Color(25, 25, 25));
        numberRight.setForeground(new Color(25, 255, 0));
        numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);
        
        precentage.setBounds(255, 325, 200, 100);
        precentage.setBackground(new Color(25, 25, 25));
        precentage.setForeground(new Color(25, 255 ,0));
        precentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        precentage.setBorder(BorderFactory.createBevelBorder(1));
        precentage.setHorizontalAlignment(JTextField.CENTER);
        precentage.setEditable(false);
        
        frame.add(timeLabel);
        frame.add(secodsLeft);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);
        
        nextQuestion();
    }
    public void nextQuestion(){
        if(index >= totalQuestions){
            results();
        }else{
            textfield.setText("Question"+(index+1));
            textarea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       buttonA.setEnabled(false);
       buttonB.setEnabled(false);
       buttonC.setEnabled(false);
       buttonD.setEnabled(false);
       
       if(e.getSource() == buttonA){
           answer = 'A';
           if(answer == answers[index]){
               correctGuesses++;
           }
       }
        if(e.getSource() == buttonB){
           answer = 'B';
           if(answer == answers[index]){
               correctGuesses++;
           }
       }
         if(e.getSource() == buttonC){
           answer = 'C';
           if(answer == answers[index]){
               correctGuesses++;
           }
       }
          if(e.getSource() == buttonD){
           answer = 'D';
           if(answer == answers[index]){
               correctGuesses++;
           }
       }
          displayAnswer();
    }
    public void displayAnswer(){
        timer.stop();
       buttonA.setEnabled(false);
       buttonB.setEnabled(false);
       buttonC.setEnabled(false);
       buttonD.setEnabled(false);
       if(answers[index] != 'A')
           answerLabelA.setForeground(new Color(255, 0 , 0));
       if(answers[index] != 'B')
           answerLabelB.setForeground(new Color(255, 0 , 0));
       if(answers[index] != 'C')
           answerLabelC.setForeground(new Color(255, 0 , 0));
       if(answers[index] != 'D')
           answerLabelD.setForeground(new Color(255, 0 , 0));
       Timer pause =  new Timer(2000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              answerLabelA.setForeground(new Color(25, 255, 0));
              answerLabelB.setForeground(new Color(25, 255, 0));
              answerLabelC.setForeground(new Color(25, 255, 0));
              answerLabelD.setForeground(new Color(25, 255, 0));
              
              answer = ' ';
              seconds = 10;
              secodsLeft.setText(String.valueOf(seconds));
              buttonA.setEnabled(true);
              buttonB.setEnabled(true);
              buttonC.setEnabled(true);
              buttonD.setEnabled(true);
              index++;
              nextQuestion();
           }
       });
       pause.setRepeats(false);
       pause.start();
       
    }
    public void results(){
       buttonA.setEnabled(false);
       buttonB.setEnabled(false);
       buttonC.setEnabled(false);
       buttonD.setEnabled(false);
       
       result = (int)((correctGuesses/(double)totalQuestions)*100);
       textfield.setText("RESULTS");
       textarea.setText("");
       answerLabelA.setText("");
       answerLabelC.setText("");
       answerLabelB.setText("");
       answerLabelD.setText("");
       
       numberRight.setText("("+correctGuesses+"/"+totalQuestions+")");
       precentage.setText(result+"%");
       
       frame.add(precentage);
       frame.add(numberRight);
    }
}
