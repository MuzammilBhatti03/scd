import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q2 extends JFrame {

    private JComboBox<String> colorComboBox;
    private JLabel selectedColorLabel;

    public Q2() {
        setTitle("Color Selector");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Create a JComboBox with color options
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange"};
        colorComboBox = new JComboBox<>(colors);

        // Create a JLabel to display the selected color
        selectedColorLabel = new JLabel("Selected Color: ");
        selectedColorLabel.setForeground(Color.BLACK);

        // Set the label to be opaque so that the background color is visible
        selectedColorLabel.setOpaque(true);

        // Add components to the GUI
        add(new JLabel("Select a Color: "));
        add(colorComboBox);
        add(selectedColorLabel);

        // Add an action listener to the JComboBox
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                displaySelectedColor(selectedColor);
            }
        });
    }

    private void displaySelectedColor(String color) {
        switch (color) {
            case "Red":
                selectedColorLabel.setBackground(Color.RED);
                selectedColorLabel.setForeground(Color.WHITE);
                break;
            case "Green":
                selectedColorLabel.setBackground(Color.GREEN);
                selectedColorLabel.setForeground(Color.BLACK);
                break;
            case "Blue":
                selectedColorLabel.setBackground(Color.BLUE);
                selectedColorLabel.setForeground(Color.WHITE);
                break;
            case "Yellow":
                selectedColorLabel.setBackground(Color.YELLOW);
                selectedColorLabel.setForeground(Color.BLACK);
                break;
            case "Orange":
                selectedColorLabel.setBackground(Color.ORANGE);
                selectedColorLabel.setForeground(Color.BLACK);
                break;
            default:
                // Reset background color
                selectedColorLabel.setBackground(null);
                selectedColorLabel.setForeground(Color.BLACK);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Q2 colorSelector = new Q2();
                colorSelector.setVisible(true);
            }
        });
    }
}
