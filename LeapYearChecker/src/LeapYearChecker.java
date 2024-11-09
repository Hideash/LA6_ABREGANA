import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {

    private JTextField yearTextField;
    private JPanel jpanel;
    private JButton checkYearButton;

    public static void main(String[] args) {
        LeapYearChecker app = new LeapYearChecker();
        app.setTitle("Leap Year Checker");            // Set title of the application
        app.setSize(300, 150);                        // Set dimensions of the frame
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);              // Center the window on the screen
        app.setVisible(true);                         // Make the frame visible
        app.getContentPane().setBackground(new Color(0xCCCCCC));
    }

    public LeapYearChecker() {
        setLayout(new FlowLayout());

        // Initialize and set up yearTextField
        yearTextField = new JTextField(10);
        yearTextField.setName("yearTextField");       // Set the name for the JTextField
        add(new JLabel("Enter Year:"));               // Label for the text field
        add(yearTextField);

        // Initialize and set up checkYearButton
        checkYearButton = new JButton("Check Year");
        checkYearButton.setName("checkYearButton");   // Set the name for the JButton
        add(checkYearButton);

        // Add action listener to the button
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearTextField.getText());
                    String message;

                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            if (year % 400 == 0) {
                                message = "Leap year";
                            } else {
                                message = "Not a leap year";
                            }
                        } else {
                            message = "Leap year";
                        }
                    } else {
                        message = "Not a leap year";
                    }

                    // Display result in JOptionPane with 'this' as parent frame
                    JOptionPane.showMessageDialog(
                            LeapYearChecker.this,
                            message,
                            "Message",
                            JOptionPane.PLAIN_MESSAGE
                    );

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            LeapYearChecker.this,
                            "Please enter a valid year.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
