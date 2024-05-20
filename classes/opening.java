package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class opening extends JFrame {
    JFrame f1;
    JButton b1, b2, busButton, airplaneButton, shipButton, b3;
    JLabel chooseLabel;
    ImageIcon i1;

    public opening() {
        f1 = new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 768);
        f1.setLayout(null);
        f1.getContentPane().setBackground(new Color(173, 216, 230)); // Light Cyan color
        f1.setUndecorated(true);
        f1.setLocationRelativeTo(null);

        initComponents();

        f1.setVisible(true);
    }

    private void initComponents() {
        // Initialize buttons
        b1 = new JButton("X");
        b1.setBounds(1320, 4, 30, 40);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);
		b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose(); // Close the window
            }
        });

        b2 = new JButton("-");
        b2.setBounds(1290, 4, 25, 30);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 40));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
		b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setState(Frame.ICONIFIED); // Minimize the window
				new BusReservationPage();
            }
        });

        chooseLabel = new JLabel("Choose...");
        chooseLabel.setBounds(550, 250, 200, 40);
        chooseLabel.setFont(new Font("Arial", Font.BOLD, 40));

        busButton = createButton("Bus", "image/bus.png", 393, 334);
		busButton.setContentAreaFilled(false);
		busButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose(); // Minimize the window
				new BusReservationPage();
            }
        });
		
        airplaneButton = createButton("Airplane", "image/airplane.png", 593, 334);
		airplaneButton.setContentAreaFilled(false);
		
        shipButton = createButton("Ship", "image/ship.png", 783, 334);
		shipButton.setContentAreaFilled(false);

        b3 = new JButton("<");
		b3.setBounds(4, 4, 100, 40);
		b3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setFocusPainted(false);
		b3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		b3.setContentAreaFilled(false);
		b3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            f1.dispose(); // Close the current window
            new Home();  // Show the home page
        }
		});

        f1.add(b1);
        f1.add(b2);
		f1.add(b3);
        f1.add(chooseLabel);
        f1.add(busButton);
        f1.add(airplaneButton);
        f1.add(shipButton);
    }

    private JButton createButton(String text, String iconFilename, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 100);
		button.setBorderPainted(false);

        try {
            ImageIcon icon = new ImageIcon(iconFilename);
            Image image = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // button.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
                //Logic to navigate to respective page goes here
                // JOptionPane.showMessageDialog(null, "Opening " + text + " page");
            // }
        // });

        return button;
    }
}
