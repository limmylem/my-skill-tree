import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JFrame;

public class DraggableSquare extends Panel {

    private static final long serialVersionUID = 1L;
    private static final int SQUARE_SIZE = 50;
    private Point squarePosition;

    public DraggableSquare() {
        squarePosition = new Point(0, 0);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                squarePosition = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point current = e.getPoint();
                int dx = current.x - squarePosition.x;
                int dy = current.y - squarePosition.y;
                squarePosition = current;
                setLocation(getLocation().x + dx, getLocation().y + dy);
            }
        });
        addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                saveSquarePosition();
            }
        });
        loadSquarePosition();
    }

    private void saveSquarePosition() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("square_position.txt"));
            writer.write(squarePosition.x + "," + squarePosition.y);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSquarePosition() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("square_position.txt"));
            String[] parts = reader.readLine().split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            squarePosition = new Point(x, y);
            reader.close();
            setLocation(x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(SQUARE_SIZE, SQUARE_SIZE);
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draggable Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(new DraggableSquare());
        frame.pack();
        frame.setVisible(true);
    }
}
