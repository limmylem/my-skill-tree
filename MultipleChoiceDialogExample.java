import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class MultipleChoiceDialogExample {
    public static void main(String[] args) {
        // Create an array of radio buttons
        JRadioButton[] radioButtons = {
                new JRadioButton("Option 1"),
                new JRadioButton("Option 2"),
                new JRadioButton("Option 3")
        };

        // Add the radio buttons to a button group to ensure only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        for (JRadioButton radioButton : radioButtons) {
            buttonGroup.add(radioButton);
        }

        // Display the dialog box and get the user's selection
        int selection = JOptionPane.showConfirmDialog(null, radioButtons, "Title", JOptionPane.OK_CANCEL_OPTION);

        // Check the user's selection and perform the appropriate action
        if (selection == JOptionPane.OK_OPTION) {
            for (JRadioButton radioButton : radioButtons) {
                if (radioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You selected " + radioButton.getText());
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You clicked Cancel");
        }
    }
}
