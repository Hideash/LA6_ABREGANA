import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame{
    private JPanel jpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton computeResultButton;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JTextField lblResult;
    private JButton btnCompute;

    public SimpleCalculator(){
        cbOperations.addItem(" + ");
        cbOperations.addItem(" - ");
        cbOperations.addItem(" * ");
        cbOperations.addItem(" / ");

        btnCompute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    double num1 = Double.parseDouble(tfNumber1.getText());
                    double num2 = Double.parseDouble(tfNumber2.getText());
                    String operation = (String) cbOperations.getSelectedItem();
                    double result = 0;

                    switch (operation) {
                        case " + ":
                            result = num1 + num2;
                            break;
                        case " - ":
                            result = num1 - num2;
                            break;
                        case " * ":
                            result = num1 * num2;
                            break;
                        case " / ":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                lblResult.setText("Error: Div by 0");
                                return;
                            }
                            break;
                    }
                    lblResult.setText(String.valueOf(result));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setTitle("Simple Calculator");
        app.setContentPane(app.jpanel);
        app.setSize(600,300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}