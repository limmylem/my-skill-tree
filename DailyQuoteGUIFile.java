import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DailyQuoteGUIFile extends JFrame {
    private JTextArea quoteTextArea;
    private ArrayList<String> quotes = new ArrayList<>();
    private LocalDate currentDate;

    public DailyQuoteGUIFile() {
        setTitle("Daily Quote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        quoteTextArea = new JTextArea();
        quoteTextArea.setLineWrap(true);
        quoteTextArea.setWrapStyleWord(true);
        quoteTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        add(quoteTextArea, BorderLayout.CENTER);

        try {
            int lineNumber = 1;
            int skipInterval = 3; // Change this to modify the skip interval
            for (String line : Files.readAllLines(Paths.get("quotes.txt"))) {
                if (lineNumber % skipInterval == 0) {
                    quotes.add(line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            quotes.add("Error reading quotes file.");
        }

        currentDate = LocalDate.now();
        updateQuote();

        // Schedule a timer task to check for a new day every 10 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                LocalDate newDate = LocalDate.now();
                if (!newDate.equals(currentDate)) {
                    currentDate = newDate;
                    updateQuote();
                }
            }
        }, 10000, 10000);

        setVisible(true);
    }

    private void updateQuote() {
        int index = new Random(currentDate.getDayOfYear()).nextInt(quotes.size());
        String quote = quotes.get(index);
        if (quote.trim().isEmpty()) {
            quoteTextArea.setText("No quote available for today");
        } else {
            quoteTextArea.setText(quote);
        }
    }

    public static void main(String[] args) {
        new DailyQuoteGUIFile();
    }
}
