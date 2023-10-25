import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cramers extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public Cramers() {
        // Set up the form
        setTitle("Cramer's Rule Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the label
        label = new JLabel("Size of matrix:");
        label.setBounds(20, 20, 100, 20);
        add(label);

        // Create the text field
        textField = new JTextField();
        textField.setBounds(120, 20, 150, 20);
        add(textField);

        // Create the button
        button = new JButton("Submit");
        button.setBounds(120, 50, 80, 20);
        add(button);

        // Add a listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int size = -1;

                try {
                    size = Integer.parseInt(textField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Numbers only");
                    return;
                }

                if (size > 3 || size < 1) {
                    JOptionPane.showMessageDialog(null, "Size must be between 2 and 3");
                    return;
                }

                if (size == 2) {
                    twoxtwo(size);
                    return;
                }
                
                if(size == 3){
                    threexthree(size);
                    return;
                }
            }
        });

        // Show the form
        setLayout(null);
        setVisible(true);
    }
    

    public void twoxtwo(int size) {
        // Open a new JFrame
        JFrame newFrame = new JFrame("Cramer's Rule Calculator");

        // Create the labels
        JLabel x = new JLabel("X");
        x.setBounds(100, 0, 50, 50);
        newFrame.add(x);

        JLabel y = new JLabel("Y");
        y.setBounds(200, 0, 50, 50);
        newFrame.add(y);

        JLabel row1 = new JLabel("1");
        row1.setBounds(80, 20, 50, 50);
        newFrame.add(row1);

        JLabel row2 = new JLabel("2");
        row2.setBounds(80, 55, 55, 50);
        newFrame.add(row2);

        JLabel constants = new JLabel("b");
        constants.setBounds(300, 0, 50, 50);
        newFrame.add(constants);

        // Create the text fields
        JTextField matrix1x = new JTextField();
        matrix1x.setBounds(100, 35, 50, 20);
        newFrame.add(matrix1x);

        JTextField matrix1y = new JTextField();
        matrix1y.setBounds(200, 35, 50, 20);
        newFrame.add(matrix1y);

        JTextField matrix2x = new JTextField();
        matrix2x.setBounds(100, 75, 50, 20);
        newFrame.add(matrix2x);

        JTextField matrix2y = new JTextField();
        matrix2y.setBounds(200, 75, 50, 20);
        newFrame.add(matrix2y);

        JTextField matrix1b = new JTextField();
        matrix1b.setBounds(300, 35, 50, 20);
        newFrame.add(matrix1b);

        JTextField matrix2b = new JTextField();
        matrix2b.setBounds(300, 75, 50, 20);
        newFrame.add(matrix2b);

        // Create the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 110, 150, 30);
        newFrame.add(submitButton);

        // Add a listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Initialize array
                double[] numArr = new double[6];
                
                // Get the values from the text fields
                numArr[0] =  Double.parseDouble(matrix1x.getText()); 
                numArr[1] = Double.parseDouble(matrix1y.getText());
                numArr[2] = Double.parseDouble(matrix2x.getText());
                numArr[3] = Double.parseDouble(matrix2y.getText());
                numArr[4] = Double.parseDouble(matrix1b.getText());
                numArr[5] = Double.parseDouble(matrix2b.getText());

                double a = numArr[0];
                double b = numArr[1];
                double c = numArr[2];
                double d = numArr[3];
                double b1 = numArr[4];
                double b2 = numArr[5];

                // Calculate the determinant
                double determinant = a * d - b * c;

                // Calculate X determinant
                double xD = b1 * d - b2 * b;

                // Calculate Y determinant
                double yD = a * b2 - b1 * c;

                // Calculate X and Y
                double x = xD / determinant;
                double y = yD / determinant;

                // Display the result
                JOptionPane.showMessageDialog(null, "Determinant: " + determinant + "\nX: " + x + "\nY: " + y);

                // Close the frame
                newFrame.dispose();
            }
        });

        // Set the size of the frame
        newFrame.setSize(400, 200);

        // Set the close operation
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the frame to be visible
        newFrame.setLayout(null);
        newFrame.setVisible(true);
    }
    
    public void threexthree(int size) {
        // Open a new JFrame
        JFrame newFrame = new JFrame("Cramer's Rule Calculator");

        // Create the labels
        JLabel x = new JLabel("X");
        x.setBounds(100, 0, 50, 50);
        newFrame.add(x);

        JLabel y = new JLabel("Y");
        y.setBounds(200, 0, 50, 50);
        newFrame.add(y);

        JLabel z = new JLabel("Z");
        z.setBounds(300, 0, 50, 50);
        newFrame.add(z);

        JLabel row1 = new JLabel("1");
        row1.setBounds(80, 20, 50, 50);
        newFrame.add(row1);

        JLabel row2 = new JLabel("2");
        row2.setBounds(80, 55, 55, 50);
        newFrame.add(row2);

        JLabel row3 = new JLabel("3");
        row3.setBounds(80, 95, 55, 50);
        newFrame.add(row3);

        JLabel constants = new JLabel("b");
        constants.setBounds(400, 0, 50, 50);
        newFrame.add(constants);

        // Create the text fields
        JTextField matrix1x = new JTextField();
        matrix1x.setBounds(100, 35, 50, 20);
        newFrame.add(matrix1x);

        JTextField matrix1y = new JTextField();
        matrix1y.setBounds(200, 35, 50, 20);
        newFrame.add(matrix1y);

        JTextField matrix1z = new JTextField();
        matrix1z.setBounds(300, 35, 50, 20);
        newFrame.add(matrix1z);

        JTextField matrix2x = new JTextField();
        matrix2x.setBounds(100, 75, 50, 20);
        newFrame.add(matrix2x);

        JTextField matrix2y = new JTextField();
        matrix2y.setBounds(200, 75, 50, 20);
        newFrame.add(matrix2y);

        JTextField matrix2z = new JTextField();
        matrix2z.setBounds(300, 75, 50, 20);
        newFrame.add(matrix2z);

        JTextField matrix3x = new JTextField();
        matrix3x.setBounds(100, 115, 50, 20);
        newFrame.add(matrix3x);

        JTextField matrix3y = new JTextField();
        matrix3y.setBounds(200,115, 50, 20);
        newFrame.add(matrix3y);

        JTextField matrix3z = new JTextField();
        matrix3z.setBounds(300,115, 50, 20);
        newFrame.add(matrix3z);

        JTextField matrix1b = new JTextField();
        matrix1b.setBounds(400, 35, 50, 20);
        newFrame.add(matrix1b);

        JTextField matrix2b = new JTextField();
        matrix2b.setBounds(400, 75, 50, 20);
        newFrame.add(matrix2b);

        JTextField matrix3b = new JTextField();
        matrix3b.setBounds(400, 115, 50, 20);
        newFrame.add(matrix3b);

        // Create the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 150, 200, 30);
        newFrame.add(submitButton);

        // Add a listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Initialize array
                double[] numArr = new double[12];

                // Get the values from the text fields

                numArr[0] = Double.parseDouble(matrix1x.getText()); 
                numArr[1] = Double.parseDouble(matrix1y.getText());
                numArr[2] = Double.parseDouble(matrix1z.getText());
                numArr[3] = Double.parseDouble(matrix2x.getText());
                numArr[4] = Double.parseDouble(matrix2y.getText());
                numArr[5] = Double.parseDouble(matrix2z.getText());
                numArr[6] = Double.parseDouble(matrix3x.getText());
                numArr[7] = Double.parseDouble(matrix3y.getText());
                numArr[8] = Double.parseDouble(matrix3z.getText());
                numArr[9] = Double.parseDouble(matrix1b.getText());
                numArr[10] = Double.parseDouble(matrix2b.getText());
                numArr[11] = Double.parseDouble(matrix3b.getText());

                double a = numArr[0];
                double b = numArr[1];
                double c = numArr[2];
                double d = numArr[3];
                double e2 = numArr[4];
                double f = numArr[5];
                double g = numArr[6];
                double h = numArr[7];
                double i = numArr[8];
                double b1 = numArr[9];
                double b2 = numArr[10];
                double b3 = numArr[11];
                
                // Calculate the determinant
                double determinant = a * (e2 * i - f * h) - b * (d * i - f * g) + c*(d * h - e2 * g);

                // Calculate X determinant
                double xD = b1 * (e2 * i - f * h) - b * (b2 * i - f * b3) + c*(b2 * h - e2 * b3);

                // Calculate Y determinant
                double yD = a * (b2 * i - f * b3) - b1 * (d * i - f * g) + c * (d * b3 - b2 * g);

                // Calculate z determinant
                double zD = a * (e2 * b3 - b2 * h) - b * (d * b3 - b2 * g) + b1 * (d * h - e2 * g);

                // Calculate X, Y and Z
                double x = xD / determinant;
                double y = yD / determinant;
                double z = zD / determinant;

                // Display the result
                JOptionPane.showMessageDialog(null, "Determinant: " + determinant + "\nX: " + x + "\nY: " + y + "\nZ: " + z);

                // Close the frame
                newFrame.dispose();
            }
        });

        // Set the size of the frame
        newFrame.setSize(500, 300);

        // Set the close operation
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the frame to be visible
        newFrame.setLayout(null);
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Cramers start = new Cramers();
    }
}
   