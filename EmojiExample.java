import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmojiExample {
    public static void main(String[] args) {
        // Create a GUI window
        JFrame frame = new JFrame("Emoji Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and add a text field for input
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        panel.add(textField);

        // Add the panel to the window and display it
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Wait for input
        while (true) {
            String input = textField.getText();
            System.out.println("Input: " + input);

            // Sleep for a short time to avoid consuming too much CPU
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
