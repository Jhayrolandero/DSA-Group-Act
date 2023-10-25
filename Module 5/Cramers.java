import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cramers {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Example");
        frame.setLayout(null); // Using null layout for simplicity

        // Create a JTextField for input
        JTextField inputField = new JTextField();
        inputField.setBounds(20, 20, 200, 30);
        frame.add(inputField);

        // Create a JButton to submit input
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 60, 80, 30);
        frame.add(submitButton);

        // Create an ActionListener for the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();

                if (inputField.equals(null) || inputField.equals(" ")) {

                }
                // Create a new frame
                JFrame newFrame = new JFrame("New Frame");
                newFrame.setSize(300, 200);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame

                String inputText = inputField.getText();

                // Create components for the new frame
                JLabel label = new JLabel(inputText);
                label.setBounds(150, 20, 100, 100);
                newFrame.add(label);

                // Add labels, buttons, or other components as needed

                // Make the new frame visible
                newFrame.setVisible(true);
            }
        });

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
