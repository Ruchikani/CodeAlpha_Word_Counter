import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;
    private Image backgroundImage;

    public WordCounter() {

        backgroundImage = new ImageIcon("01.jpg").getImage();
        setTitle("Simple Word Counter");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel enterLabel = new JLabel("Enter paragraph you wish to count the words :");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(enterLabel, gbc);

        textField = new JTextField(25);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(textField, gbc);

        JButton countButton = new JButton("Count Words");
        countButton.setBackground(Color.BLACK);
        countButton.setForeground(Color.WHITE);
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                String[] words = inputText.split("\\s+");
                int wordCount = words.length;
                resultLabel.setText("There are " + wordCount + " words in your paragraph");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(countButton, gbc);

        resultLabel = new JLabel("Exiting to see the results !");
        resultLabel.setForeground(Color.RED); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        add(panel);
        setVisible(true);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounter();
            }
        });
    }
}
