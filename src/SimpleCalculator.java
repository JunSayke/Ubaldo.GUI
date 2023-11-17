import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel jpanel;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;

    public SimpleCalculator() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(tfNumber1.getText());
                    int y = Integer.parseInt(tfNumber2.getText());
                    int op = cbOperations.getSelectedIndex();
                    switch (op) {
                        case 0:
                            lblResult.setText(String.valueOf(x + y));
                            break;
                        case 1:
                            lblResult.setText(String.valueOf(x - y));
                            break;
                        case 2:
                            lblResult.setText(String.valueOf(x * y));
                            break;
                        case 3:
                            lblResult.setText(String.valueOf(x / y));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid operation!");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                } catch (ArithmeticException exception) {
                    JOptionPane.showMessageDialog(null, "Undefined!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.jpanel);
        app.setSize(500, 200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Simple Calculator");
        app.setVisible(true);
    }
}
