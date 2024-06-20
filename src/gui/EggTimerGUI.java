package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import cooking.*;
import sound.SoundManager;
import util.TimeUtil;
import exceptions.NoEggTypeSelectedException;

public class EggTimerGUI extends JFrame {
    private JComboBox<Object> eggTypeCombo;
    private JLabel timerLabel;
    private JButton startButton;
    private JLabel imageLabel;
    private JButton englishButton;
    private JButton igboButton;
    private Properties englishProperties;
    private Properties igboProperties;
    private Timer timer;

    public EggTimerGUI() {
        loadProperties();
        initializeComponents();

    }

    private void loadProperties() {
        englishProperties = new Properties();
        igboProperties = new Properties();
        try {
            englishProperties.load(new FileInputStream("C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\MessagesBundle_en_US.properties"));
            igboProperties.load(new FileInputStream("C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\MessagesBundle_ig_NG.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeComponents() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle(getString("title"));

        eggTypeCombo = new JComboBox<>();
        eggTypeCombo.addItem("Select Your Egg!"); // Initial text

        Egg[] eggs = {
                new SoftBoiledEgg(),
                new MediumBoiledEgg(),
                new HardBoiledEgg()
        };
        for (Egg egg : eggs) {
            eggTypeCombo.addItem(egg);
        }

        eggTypeCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Egg) {
                    setText(getString(((Egg) value).getType()));
                }
                return this;
            }
        });
        add(eggTypeCombo);

        timerLabel = new JLabel("00:00");
        add(timerLabel);

        startButton = new JButton(getString("start"));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        add(startButton);

        imageLabel = new JLabel();
        add(imageLabel);

        englishButton = new JButton("English");
        englishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLanguage(englishProperties);
            }
        });
        add(englishButton);

        igboButton = new JButton("Igbo");
        igboButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLanguage(igboProperties);
            }
        });
        add(igboButton);

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(60, 63, 65));

        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        Color buttonColor = new Color(191, 191, 191);

        timerLabel.setFont(new Font("Digital-7", Font.PLAIN, 28));
        timerLabel.setForeground(new Color(255, 0, 0));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        startButton.setFont(buttonFont);
        startButton.setBackground(buttonColor);
        englishButton.setFont(buttonFont);
        englishButton.setBackground(buttonColor);
        igboButton.setFont(buttonFont);
        igboButton.setBackground(buttonColor);
    }

    private void updateLanguage(Properties properties) {
        setTitle(properties.getProperty("title"));
        startButton.setText(properties.getProperty("start"));
        eggTypeCombo.removeAllItems();
        eggTypeCombo.addItem("Select Your Egg!"); // Initial text
        Egg[] eggs = {
                new SoftBoiledEgg(),
                new MediumBoiledEgg(),
                new HardBoiledEgg()
        };
        for (Egg egg : eggs) {
            eggTypeCombo.addItem(egg);
        }
        eggTypeCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Egg) {
                    setText(properties.getProperty(((Egg) value).getType()));
                }
                return this;
            }
        });
        try {
            timerLabel.setText("00:00");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getString(String key) {
        return englishProperties.getProperty(key);
    }

    private void startTimer() {
        Object selectedItem = eggTypeCombo.getSelectedItem();

        if (selectedItem instanceof String && selectedItem.equals("Select Your Egg!")) {
            JOptionPane.showMessageDialog(null, getString("error_no_egg_selected"), getString("error_title"), JOptionPane.ERROR_MESSAGE);
        } else {
            Egg selectedEgg = (Egg) selectedItem;
            timer = new Timer(1000, new ActionListener() {
                int timeLeft = selectedEgg.getBoilTime();

                public void actionPerformed(ActionEvent e) {
                    if (timeLeft > 0) {
                        timerLabel.setText("00:" + (timeLeft < 10 ? "0" + timeLeft : timeLeft));
                        timeLeft--;
                    } else {
                        ((Timer) e.getSource()).stop();
                        timerLabel.setText(getString("done_message"));
                        SoundManager.playSound(selectedEgg.getSoundPath());
                        imageLabel.setIcon(new ImageIcon(selectedEgg.getImagePath()));
                    }
                }
            });
            timer.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EggTimerGUI().setVisible(true);
            }
        });
    }
}
