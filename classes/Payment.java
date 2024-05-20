package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, label2, label3, imgLabel, amountLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private ImageIcon logo;
    private JTextField tf1, tf2, tf3;
    private JPasswordField pf;
    private JButton btn1, closeButton, minimizeButton, backButton;
    private Cursor cursor;

    public Payment() {

        // Frame Layout
        c = getContentPane();
        this.setTitle("Payment");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        initComponents();
        this.setVisible(true); // Only call setVisible(true) here after all components are added
    }

    private void initComponents() {
        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);

        c.setLayout(null);

        // Close Button
        closeButton = new JButton("X");
        closeButton.setBounds(860, 4, 30, 40);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        c.add(closeButton);

        // Minimize Button
        minimizeButton = new JButton("-");
        minimizeButton.setBounds(830, 4, 25, 30);
        minimizeButton.setFont(new Font("Segoe UI", Font.BOLD, 40));
        minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(Frame.ICONIFIED); // Minimize the window
            }
        });
        c.add(minimizeButton);

        // Back Button
        backButton = new JButton("<");
        backButton.setBounds(5, 5, 30, 30);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new opening();  // Show the opening page
            }
        });
        c.add(backButton);

        // Title
        label1 = new JLabel();
        label1.setText("Complete Your Payment");
        label1.setBounds(240, 20, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        label2 = new JLabel("Card Details");
        label2.setBounds(420, 140, 500, 50);
        label2.setFont(f2);
        c.add(label2);

        // Name On Card
        label3 = new JLabel("Name On Card");
        label3.setBounds(430, 180, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(570, 190, 235, 30);
        tf1.setFont(f4);
        c.add(tf1);

        // Card Number
        label3 = new JLabel("Card Number");
        label3.setBounds(430, 220, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(570, 230, 235, 30); // Adjusted bounds to fit layout
        tf2.setFont(f4);
        c.add(tf2);

        // Card Expiry
        label3 = new JLabel("Till ");
        label3.setBounds(430, 260, 100, 50);
        label3.setFont(f3);
        c.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(470, 270, 100, 30);
        tf3.setFont(f4);
        c.add(tf3);

        // Security Code
        label3 = new JLabel("CVV CODE");
        label3.setBounds(590, 260, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        pf = new JPasswordField();
        pf.setBounds(735, 270, 70, 30);
        pf.setFont(f4);
        c.add(pf);

        // Confirm Payment Button
        btn1 = new JButton("Confirm Payment");
        btn1.setBounds(500, 330, 200, 50);
        btn1.setFont(f5);
        btn1.setBackground(new Color(0, 128, 128));
        btn1.setForeground(Color.WHITE);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                String cvvCode = pf.getText();
                
                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    PaySuccess frame = new PaySuccess();
                    frame.setVisible(true);
                }
            }
        });
        c.add(btn1);

        // Display Payment Amount
        // amountLabel = new JLabel("Pay " + amount + " Taka");
        // amountLabel.setBounds(500, 80, 400, 50);
        // amountLabel.setFont(f6);
        // c.add(amountLabel);

        // Logo and Images
        logo = new ImageIcon(getClass().getResource("/image/LogoBlue.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 100, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);
    }

    // public static void main(String[] args) {
        // Example amount passed to Payment class
        // new Payment(amount);Change the amount as per your requirement
    // }
}
