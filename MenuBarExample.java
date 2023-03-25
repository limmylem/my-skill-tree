import javax.swing.*;

public class MenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar MenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        MenuBar.add(fileMenu);
        MenuBar.add(editMenu);

        frame.setJMenuBar(MenuBar);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
