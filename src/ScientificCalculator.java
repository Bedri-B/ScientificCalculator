import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.atomic.DoubleAccumulator;


public class ScientificCalculator extends javax.swing.JFrame implements ActionListener {
    private ArrayList<String> tokens = new ArrayList<String>();
    private String[] ops = {"+", "-", "*", "/", "SIN", "COS", "TAN", "LOG", "!", "Sqrt", "Negate", "^", "ONE_OVER"};
    private String[] unaryOPs = {"-", "SIN", "COS", "TAN", "LOG", "Sqrt"};
    private boolean syntaxerror = false;
    private double Memory = 0.0;

    public ScientificCalculator() {
        initComponents();
    }

    private void initComponents() {

        Container c = this.getContentPane();
        c.setLayout(null);
        input = new javax.swing.JTextField();
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!isNum(e.getKeyChar())) {
                    e.consume();
                } else {
                    manage(e.getKeyChar() + "");
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        MR = new javax.swing.JButton();
        MC = new javax.swing.JButton();
        MP = new javax.swing.JButton();
        MM = new javax.swing.JButton();
        NUM8 = new javax.swing.JButton();
        NUM1 = new javax.swing.JButton();
        NUM3 = new javax.swing.JButton();
        NUM2 = new javax.swing.JButton();
        NUM4 = new javax.swing.JButton();
        NUM5 = new javax.swing.JButton();
        NUM6 = new javax.swing.JButton();
        NUM7 = new javax.swing.JButton();
        NUM9 = new javax.swing.JButton();
        NUM0 = new javax.swing.JButton();
        PLUS = new javax.swing.JButton();
        MINUS = new javax.swing.JButton();
        MULT = new javax.swing.JButton();
        DIVIDE = new javax.swing.JButton();
        PLUS_MINUS = new javax.swing.JButton();
        DOT = new javax.swing.JButton();
        EQUALS = new javax.swing.JButton();
        ONE_OVER = new javax.swing.JButton();
        SQRT = new javax.swing.JButton();
        LOG = new javax.swing.JButton();
        SIN = new javax.swing.JButton();
        COS = new javax.swing.JButton();
        TAN = new javax.swing.JButton();
        SQR = new javax.swing.JButton();
        CUBE = new javax.swing.JButton();
        POWER = new javax.swing.JButton();
        FACTORIAL = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(295, 290));
        setTitle("Scientific Calculator");
        setResizable(false);


        input.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        input.setBounds(10, 10, 270, 20);

        MR.setText("MR");
        MR.setBounds(10, 50, 60, 20 );
        MR.addActionListener(this);

        MC.setText("MC");
        MC.setBounds(80, 50, 60, 20);
        MC.addActionListener(this);

        MP.setText("M+");
        MP.setBounds(150, 50, 60, 20);
        MP.addActionListener(this);

        MM.setText("M-");
        MM.setBounds(220, 50, 60, 20);
        MM.addActionListener(this);



        NUM1.setText("1");
        NUM1.setBounds(10, 75, 60, 20);
        NUM1.addActionListener(this);

        NUM2.setText("2");
        NUM2.setBounds(80, 75, 60, 20);
        NUM2.addActionListener(this);

        NUM3.setText("3");
        NUM3.setBounds(150, 75, 60, 20);
        NUM3.addActionListener(this);

        NUM4.setText("4");
        NUM4.setBounds(220, 75, 60, 20);
        NUM4.addActionListener(this);

        NUM5.setText("5");
        NUM5.setBounds(10, 100, 60, 20);
        NUM5.addActionListener(this);

        NUM6.setText("6");
        NUM6.setBounds(80, 100, 60, 20);
        NUM6.addActionListener(this);

        NUM7.setText("7");
        NUM7.setBounds(150, 100, 60, 20);
        NUM7.addActionListener(this);

        NUM8.setText("8");
        NUM8.setBounds(220, 100, 60, 20);
        NUM8.addActionListener(this);

        NUM9.setText("9");
        NUM9.setBounds(10, 125, 60, 20);
        NUM9.addActionListener(this);

        NUM0.setText("0");
        NUM0.setBounds(80, 125, 60, 20);
        NUM0.addActionListener(this);

        PLUS.setText("+");
        PLUS.setBounds(150, 125, 60, 20);
        PLUS.addActionListener(this);

        MINUS.setText("-");
        MINUS.setBounds(220, 125, 60, 20);
        MINUS.addActionListener(this);

        MULT.setText("*");
        MULT.setBounds(10, 150, 60, 20);
        MULT.addActionListener(this);

        DIVIDE.setText("/");
        DIVIDE.setBounds(80, 150, 60, 20);
        DIVIDE.addActionListener(this);

        PLUS_MINUS.setText("+/-");
        PLUS_MINUS.setBounds(150, 150, 60, 20);
        PLUS_MINUS.addActionListener(this);

        DOT.setText(".");
        DOT.setBounds(220, 150, 60, 20);
        DOT.addActionListener(this);

        EQUALS.setText("=");
        EQUALS.setBounds(10, 175, 60, 20);
        EQUALS.addActionListener(this);

        ONE_OVER.setText("1/x");
        ONE_OVER.setBounds(80, 175, 60, 20);
        ONE_OVER.addActionListener(this);

        SQRT.setText("Sqrt");
        SQRT.setBounds(150, 175, 60, 20);
        SQRT.addActionListener(this);

        LOG.setText("LOG");
        LOG.setBounds(220, 175, 60, 20);
        LOG.addActionListener(this);

        SIN.setText("SIN");
        SIN.setBounds(10, 200, 60, 20);
        SIN.addActionListener(this);

        COS.setText("COS");
        COS.setBounds(80, 200, 60, 20);
        COS.addActionListener(this);

        TAN.setText("TAN");
        TAN.setBounds(150, 200, 60, 20);
        TAN.addActionListener(this);

        SQR.setText("x^2");
        SQR.setBounds(220, 200, 60, 20);
        SQR.addActionListener(this);

        CUBE.setText("x^3");
        CUBE.setBounds(10, 225, 60, 20);
        CUBE.addActionListener(this);

        POWER.setText("Exp");
        POWER.setBounds(80, 225, 60, 20);
        POWER.addActionListener(this);

        FACTORIAL.setText("n!");
        FACTORIAL.setBounds(150, 225, 60, 20);
        FACTORIAL.addActionListener(this);

        CLEAR.setText("AC");
        CLEAR.setBounds(220, 225, 60, 20);
        CLEAR.addActionListener(this);

        c.add(MP);
        c.add(MC);
        c.add(MR);
        c.add(SQR);
        c.add(SQRT);
        c.add(POWER);
        c.add(CLEAR);
        c.add(CUBE);
        c.add(COS);
        c.add(LOG);
        c.add(EQUALS);
        c.add(SIN);
        c.add(ONE_OVER);
        c.add(FACTORIAL);
        c.add(MULT);
        c.add(TAN);
        c.add(MM);
        c.add(MINUS);
        c.add(DOT);
        c.add(DIVIDE);
        c.add(PLUS_MINUS);
        c.add(PLUS);
        c.add(NUM0);
        c.add(NUM9);
        c.add(NUM8);
        c.add(NUM7);
        c.add(NUM6);
        c.add(NUM5);
        c.add(NUM4);
        c.add(NUM3);
        c.add(NUM2);
        c.add(NUM1);
        c.add(input);

    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScientificCalculator().setVisible(true);
            }
        });
    }

    private javax.swing.JButton CLEAR;
    private javax.swing.JButton COS;
    private javax.swing.JButton CUBE;
    private javax.swing.JButton DIVIDE;
    private javax.swing.JButton DOT;
    private javax.swing.JButton EQUALS;
    private javax.swing.JButton FACTORIAL;
    private javax.swing.JButton LOG;
    private javax.swing.JButton MC;
    private javax.swing.JButton MINUS;
    private javax.swing.JButton MM;
    private javax.swing.JButton MP;
    private javax.swing.JButton MR;
    private javax.swing.JButton MULT;
    private javax.swing.JButton NUM0;
    private javax.swing.JButton NUM1;
    private javax.swing.JButton NUM2;
    private javax.swing.JButton NUM3;
    private javax.swing.JButton NUM4;
    private javax.swing.JButton NUM5;
    private javax.swing.JButton NUM6;
    private javax.swing.JButton NUM7;
    private javax.swing.JButton NUM8;
    private javax.swing.JButton NUM9;
    private javax.swing.JButton ONE_OVER;
    private javax.swing.JButton PLUS;
    private javax.swing.JButton PLUS_MINUS;
    private javax.swing.JButton POWER;
    private javax.swing.JButton SIN;
    private javax.swing.JButton SQR;
    private javax.swing.JButton SQRT;
    private javax.swing.JButton TAN;
    private javax.swing.JTextField input;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (syntaxerror) {
            syntaxerror = false;
            input.setText("");
            tokens = new ArrayList<String>();
        }
        if (e.getSource() == CLEAR) {
            input.setText("");
            tokens = new ArrayList<String>();
        }
        else if (e.getSource() == NUM1) {
            manage("1");

        }
        else if (e.getSource() == NUM2) {
            manage("2");

        }
        else if (e.getSource() == NUM3) {
            manage("3");

        }
        else if (e.getSource() == NUM4) {
            manage("4");

        }
        else if (e.getSource() == NUM5) {
            manage("5");
        }
        else if (e.getSource() == NUM6) {
            manage("6");

        }
        else if (e.getSource() == NUM7) {
            manage("7");

        }
        else if (e.getSource() == NUM8) {
            manage("8");

        }
        else if (e.getSource() == NUM9) {
            manage("9");

        }
        else if (e.getSource() == NUM0) {
            manage("0");

        }
        else if (e.getSource() == MULT) {
            manage("*");

        }
        else if (e.getSource() == DIVIDE) {
            manage("/");

        }
        else if (e.getSource() == PLUS) {
            manage("+");

        }
        else if (e.getSource() == MINUS) {
            manage("-");

        }
        else if (e.getSource() == PLUS_MINUS) {
            manage("Negate");
        }
        else if (e.getSource() == SQRT) {
            manage("Sqrt");

        }
        else if (e.getSource() == SIN) {
            manage("SIN");

        }
        else if (e.getSource() == COS) {
            manage("COS");

        }
        else if (e.getSource() == TAN) {
            manage("TAN");

        }
        else if (e.getSource() == FACTORIAL) {
            manage("!");

        }
        else if (e.getSource() == CUBE) {
            manage("^");
            if(tokens.get(tokens.size()-1).equals("^")) manage("3");

        }
        else if (e.getSource() == LOG) {
            manage("LOG");

        }
        else if (e.getSource() == MP) {
            try{
                Memory = Memory + Double.parseDouble(tokens.get(tokens.size()-1));
            }
            catch(Exception ex){ex.printStackTrace();}
        }
        else if (e.getSource() == MC) {
            Memory = 0.0;
        }
        else if (e.getSource() == MM) {
            try{
                Memory = Memory - Double.parseDouble(tokens.get(tokens.size()-1));
            }
            catch(Exception ex){ex.printStackTrace();}
        }
        else if (e.getSource() == MR) {
            System.out.println(Memory);
            manage(Memory+"");
        }
        else if (e.getSource() == EQUALS) {
            Calculate();
        }
        else if (e.getSource() == ONE_OVER) {
            manage("ONE_OVER");
        }
        else if (e.getSource() == DOT) {
            manage(".");

        }
        else if (e.getSource() == SQR) {
            manage("^");
            if(tokens.get(tokens.size()-1).equals("^")) manage("2");

        }
        else if (e.getSource() == POWER) {
            manage("^");
        }

    }

    private void Calculate(){
        while(tokens.size() > 1){
            if(tokens.contains("-")){
                int op = tokens.indexOf("-");
                if(op == 0 || isOperator(tokens.get(op-1))){
                    double num = Double.parseDouble(tokens.get(op+1));
                    double val = -num;
                    tokens.set(op, val+"");
                    tokens.set(op+1, null);
                    CleanUP();
                    continue;
                }
            }
            if(tokens.contains("!")){
                int op = tokens.lastIndexOf("!");
                double num = Double.parseDouble(tokens.get(op-1));
                if(num < 0){
                    input.setText("Syntax Error: Factorial of Negative");
                    syntaxerror = true;
                    return;
                }
                double val = Factorial(num);
                tokens.set(op-1, val+"");
                tokens.set(op, null);
            }
            else if(tokens.contains("Sqrt")){
                int op = tokens.lastIndexOf("Sqrt");
                double num = Double.parseDouble(tokens.get(op+1));
                double val = Math.sqrt(num);
                tokens.set(op, val+"");
                tokens.set(op+1, null);
            }
            else if(tokens.contains("LOG")){
                int op = tokens.lastIndexOf("LOG");
                double num = Double.parseDouble(tokens.get(op+1));
                double val = Math.log(num);
                tokens.set(op, val+"");
                tokens.set(op+1, null);
            }
            else if(tokens.contains("SIN")){
                int op = tokens.lastIndexOf("SIN");
                double num = Double.parseDouble(tokens.get(op+1));
                double val = Math.sin(num);
                tokens.set(op, val+"");
                tokens.set(op+1, null);
            }
            else if(tokens.contains("COS")){
                int op = tokens.lastIndexOf("COS");
                double num = Double.parseDouble(tokens.get(op+1));
                double val = Math.cos(num);
                tokens.set(op, val+"");
                tokens.set(op+1, null);

            }
            else if(tokens.contains("TAN")){
                int op = tokens.lastIndexOf("TAN");
                double num = Double.parseDouble(tokens.get(op+1));
                double val = Math.tan(num);
                tokens.set(op, val+"");
                tokens.set(op+1, null);
            }
            else if(tokens.contains("^")){
                int op = tokens.lastIndexOf("^");
                double num1 = Double.parseDouble(tokens.get(op-1));
                double num2 = Double.parseDouble(tokens.get(op+1));
                double val = Math.pow(num1, num2);
                tokens.set(op-1, val+"");
                tokens.set(op, null);
                tokens.set(op+1, null);
            }
            else if(tokens.contains("*")){
                int op = tokens.lastIndexOf("*");
                double num1 = Double.parseDouble(tokens.get(op-1));
                double num2 = Double.parseDouble(tokens.get(op+1));
                double val = num1 * num2;
                tokens.set(op-1, val+"");
                tokens.set(op, null);
                tokens.set(op+1, null);
            }
            else if(tokens.contains("/")){
                int op = tokens.lastIndexOf("/");
                double num1 = Double.parseDouble(tokens.get(op-1));
                double num2 = Double.parseDouble(tokens.get(op+1));
                if(num2 == 0.0){
                    input.setText("Syntax Error: Division by Zero");
                    syntaxerror = true;
                    return;
                }
                double val = num1 / num2;
                tokens.set(op-1, val+"");
                tokens.set(op, null);
                tokens.set(op+1, null);
            }
            else if(tokens.contains("-")){
                int op = tokens.indexOf("-");
                double num1 = Double.parseDouble(tokens.get(op-1));
                double num2 = Double.parseDouble(tokens.get(op+1));
                double val = num1 - num2;
                tokens.set(op-1, val+"");
                tokens.set(op, null);
                tokens.set(op+1, null);
            }
            else if(tokens.contains("+")){
                int op = tokens.lastIndexOf("+");
                double num1 = Double.parseDouble(tokens.get(op-1));
                double num2 = Double.parseDouble(tokens.get(op+1));
                double val = num1 + num2;
                tokens.set(op-1, val+"");
                tokens.set(op, null);
                tokens.set(op+1, null);
            }

            CleanUP();
            updateInput();
        }
        if(!tokens.isEmpty())  input.setText(tokens.get(0));
    }

    private void CleanUP() {
        ArrayList<String> Tokens = new ArrayList<String>();
        for(String s : tokens){
            if(s != null){
                Tokens.add(s);
            }
        }
        tokens = Tokens;
    }

    private void manage(String source) {
        String temp = input.getText();
        if (temp.equals("")) {
            if(isNum(source) && source.length() > 1){
                if(!tokens.isEmpty()){
                    tokens.set(tokens.size() - 1, source);
                }
                else{
                    tokens.add(source);
                }
                updateInput();
            }
            if (source.length() == 1 && isNum(source.charAt(0))) {
                tokens.add(source);
                input.setText(source);
            }
            if (isUnaryOperator(source)) {
                tokens.add(source);
                input.setText(source);
            }
            else if (source.equals("ONE_OVER")) {
                tokens.add("1");
                tokens.add("/");
                input.setText("1/");
            }
        }
        else {
            String item = tokens.get(tokens.size() - 1);
            if (isNum(item)) {
                if(isNum(source) && source.length() > 1){
                    tokens.set(tokens.size() - 1, source);
                    updateInput();
                }
                else if (source.length() == 1 && (isNum(source.charAt(0)) || source.equals("."))) {
                    if (source.equals(".") && item.contains(".")) return;
                    tokens.set(tokens.size() - 1, item + source);
                    input.setText(temp + source);
                }
                else if (isOperator(source) && !isUnaryOperator(source) || isOperator(source) && (source.equals("-") || source.equals("Negate"))) {
                    if (source.equals("ONE_OVER")) {
                        double val = Double.parseDouble(item);
                        if (val == 0) {
                            input.setText("Syntax Error: Division by Zero");
                            syntaxerror = true;
                            return;
                        }
                        tokens.set(tokens.size() - 1, (1 / val) + "");
                        updateInput();
                        return;
                    }
                    if (source.equals("Negate")){
                        if(tokens.size()>2){
                            String v = tokens.get(tokens.size() - 2);
                            if(v.equals("-")){
                                String b = tokens.get(tokens.size() - 3);
                                if(b.equals("+")){
                                    tokens.set(tokens.size() - 2, item);
                                    tokens.remove(tokens.size()-1);
                                    updateInput();
                                    return;
                                }
                                else {
                                    tokens.set(tokens.size() - 2, "+");
                                    updateInput();
                                    return;
                                }
                            }
                        }
                        else if(tokens.size()==2){
                            tokens.set(tokens.size() - 2, item);
                            tokens.remove(tokens.size()-1);
                            updateInput();
                            return;
                        }
                        tokens.set(tokens.size() - 1, "-");
                        tokens.add(item);
                        updateInput();
                        return;
                    }
                    tokens.add(source);
                    input.setText(temp + source);
                }
            }
            else if (isOperator(item)) {
                if(item.equals("!")){
                    if (isOperator(source) && !isUnaryOperator(source)) {
                        tokens.set(tokens.size() - 1, source);
                        updateInput();
                    }
                    else{
                        return;
                    }
                }
                if (source.length() == 1 && isNum(source.charAt(0))) {
                    tokens.add(source);
                    input.setText(temp + source);
                }
                else if (isUnaryOperator(source)) {
                    tokens.add(source);
                    input.setText(temp + source);
                }
                else if (isOperator(source)) {
                    if (source.equals("+/-")) return;
                    tokens.set(tokens.size() - 1, source);
                    updateInput();
                }
            }
            else if (isUnaryOperator(item)) {
                if (source.length() == 1 && isNum(source.charAt(0))) {
                    tokens.add(source);
                    input.setText(temp + source);
                }
                else if (isUnaryOperator(source)) {
                    tokens.add(source);
                    input.setText(temp + source);
                }
            }
        }
    }

    private boolean isOperator(String item) {
        for (int x = 0; x < ops.length; x++) {
            if (item.equals(ops[x])) return true;
        }
        return false;
    }

    private boolean isUnaryOperator(String item) {
        for (int x = 0; x < unaryOPs.length; x++) {
            if (item.equals(unaryOPs[x])) return true;
        }
        return false;
    }

    private void updateInput() {
        StringBuilder bb = new StringBuilder();
        for (String token : tokens) {
            bb.append(token);
        }
        input.setText(bb.toString());
    }

    private boolean isNum(char x) {
        return (int) x >= 48 && (int) x <= 58;
    }

    private boolean isNum(String x) {
        try {
            double num = Double.parseDouble(x);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private double Factorial(double val){
        double fact = 1;
        for(double i=1;i<=val;i++){
            fact=fact*i;
        }
        return fact;
    }
}