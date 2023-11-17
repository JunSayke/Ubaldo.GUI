import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {

    private JPanel jpanel;
    private JCheckBox cPizza;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    JCheckBox[] foods = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
    JRadioButton[] discounts = {rbNone, rb5, rb10, rb15};
    public FoodOrderingSystem() {
        rbNone.setSelected(true);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                for (JCheckBox food : foods) {
                    if (food.isSelected()) {
                        String foodName = food.getText();
                        switch (foodName) {
                            case "Pizza":
                                total += 100;
                                break;
                            case "Burger":
                                total += 80;
                                break;
                            case "Fries":
                                total += 65;
                                break;
                            case "Soft Drinks":
                                total += 55;
                                break;
                            case "Tea":
                                total += 50;
                                break;
                            case "Sundae":
                                total += 40;
                                break;
                            default:
                        }
                    }
                }
                for (JRadioButton discount : discounts) {
                    if (discount.isSelected()) {
                        String discountOff = discount.getText();
                        switch (discountOff) {
                            case "5% Off":
                                total *= 0.95;
                                break;
                            case "10% Off":
                                total *= 0.90;
                                break;
                            case "15% Off":
                                total *= 0.85;
                                break;
                            default:
                        }
                        break;
                    }
                }
                if (total > 0) {
                    JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
                } else {
                    JOptionPane.showMessageDialog(null, "You currently don't have any order yet!");
                }
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setContentPane(app.jpanel);
        app.setSize(400, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Food Ordering System");
        app.setVisible(true);
    }
}