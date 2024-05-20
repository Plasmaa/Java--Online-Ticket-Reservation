package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;



public class BusReservationPage extends JFrame {
    JFrame frame;
    JLabel fromLabel, toLabel, seatsLabel, dateLabel, returnDateLabel, pickupPointLabel, dropoffPointLabel, timeLabel, acLabel, l8, infoLabel;
    JComboBox<String> fromComboBox, toComboBox, timeComboBox, acComboBox;
    JComboBox<Integer> seatsComboBox;
    JFormattedTextField dateField, returnDateField;
    JTextField pickupPointField, dropoffPointField;
    JButton submitButton, closeButton, minimizeButton, backButton;

    public BusReservationPage() {
        frame = new JFrame("Bus Reservation System");
        frame.setUndecorated(true);
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        frame.setLocationRelativeTo(null);

        initComponents();

        frame.setVisible(true);
    }

    private void initComponents() {
        // Close button
        closeButton = new JButton("X");
        closeButton.setBounds(1320, 4, 30, 40);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Minimize button
        minimizeButton = new JButton("-");
        minimizeButton.setBounds(1290, 4, 25, 30);
        minimizeButton.setFont(new Font("Segoe UI", Font.BOLD, 40));
        minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(Frame.ICONIFIED); // Minimize the window
            }
        });

        // Back button
        backButton = new JButton("<");
        backButton.setBounds(4, 4, 30, 30);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                new opening();  // Show the opening page
            }
        });

        // Labels and fields
		
		// Provide Information label
        infoLabel = new JLabel("Provide Information.....");
        infoLabel.setBounds(80, 50, 300, 30);
        infoLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
        l8 = new JLabel();
        l8.setIcon(new ImageIcon("image/Bus1.png"));
        Dimension size = l8.getPreferredSize();
        l8.setBounds(683, 0, size.width, size.height);
        
        fromLabel = new JLabel("From:");
        fromLabel.setBounds(80, 100, 100, 30);
        fromLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        fromComboBox = new JComboBox<>(new String[]{"Dhaka", "Chittagong", "Khulna", "Barishal", "Rajshahi", "Sylhet", "Mymenshing"});
        fromComboBox.setBounds(230, 100, 200, 30);

        toLabel = new JLabel("To:");
        toLabel.setBounds(80, 150, 100, 30);
        toLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        toComboBox = new JComboBox<>(new String[]{"Dhaka", "Chittagong", "Khulna", "Barishal", "Rajshahi", "Sylhet", "Mymenshing"});
        toComboBox.setBounds(230, 150, 200, 30);

        seatsLabel = new JLabel("Number of Seats:");
        seatsLabel.setBounds(80, 200, 150, 30);
        seatsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        seatsComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        seatsComboBox.setBounds(230, 200, 200, 30);

        dateLabel = new JLabel("Date of Journey:");
        dateLabel.setBounds(80, 250, 150, 30);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        dateField = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy"));
        dateField.setValue(new Date());
        dateField.setBounds(230, 250, 200, 30);

        returnDateLabel = new JLabel("Date of Return:");
        returnDateLabel.setBounds(80, 300, 150, 30);
        returnDateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        returnDateField = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy"));
        returnDateField.setBounds(230, 300, 200, 30);

        pickupPointLabel = new JLabel("Pick-up Point:");
        pickupPointLabel.setBounds(80, 350, 150, 30);
        pickupPointLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        pickupPointField = new JTextField();
        pickupPointField.setBounds(230, 350, 200, 30);

        dropoffPointLabel = new JLabel("Drop-off Point:");
        dropoffPointLabel.setBounds(80, 400, 150, 30);
        dropoffPointLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        dropoffPointField = new JTextField();
        dropoffPointField.setBounds(230, 400, 200, 30);

        timeLabel = new JLabel("Time of Journey:");
        timeLabel.setBounds(80, 450, 150, 30);
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        timeComboBox = new JComboBox<>(new String[]{"Morning", "Afternoon", "Evening", "Night"});
        timeComboBox.setBounds(230, 450, 200, 30);

        acLabel = new JLabel("AC/Non-AC:");
        acLabel.setBounds(80, 500, 150, 30);
        acLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        acComboBox = new JComboBox<>(new String[]{"AC", "Non-AC"});
        acComboBox.setBounds(230, 500, 200, 30);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(280, 550, 100, 40);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setFocusPainted(false);
        submitButton.setBackground(new Color(23, 61, 123));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				saveTicketInformation();
				frame.dispose();
				Payment frame = new Payment();
                frame.setVisible(true);
				showTicketPrice();
            }
        });

        // Add components to the frame
        frame.add(closeButton);
        frame.add(minimizeButton);
        frame.add(backButton);
        frame.add(fromLabel);
        frame.add(fromComboBox);
        frame.add(toLabel);
        frame.add(toComboBox);
        frame.add(seatsLabel);
        frame.add(seatsComboBox);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(returnDateLabel);
        frame.add(returnDateField);
        frame.add(pickupPointLabel);
        frame.add(pickupPointField);
        frame.add(dropoffPointLabel);
        frame.add(dropoffPointField);
        frame.add(timeLabel);
        frame.add(timeComboBox);
        frame.add(acLabel);
        frame.add(acComboBox);
        frame.add(submitButton);
        frame.add(l8);
		frame.add(infoLabel);
    }
	
	private void saveTicketInformation() {
    // Retrieve user name from user_data.txt
    String userName = retrieveUserName();

    if (userName == null) {
        JOptionPane.showMessageDialog(frame, "User name not found. Cannot save ticket information.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String from = fromComboBox.getSelectedItem().toString();
    String to = toComboBox.getSelectedItem().toString();
    int seats = (int) seatsComboBox.getSelectedItem();
    String date = dateField.getText();
    String returnDate = returnDateField.getText();
    String pickupPoint = pickupPointField.getText();
    String dropoffPoint = dropoffPointField.getText();
    String time = timeComboBox.getSelectedItem().toString();
    String ac = acComboBox.getSelectedItem().toString();

    // Create the ticket information string
    String ticketInfo = String.format("%s\nFrom: %s\nTo: %s\nNumber of Seats: %d\nDate of Journey: %s\nDate of Return: %s\nPick-up Point: %s\nDrop-off Point: %s\nTime of Journey: %s\nAC/Non-AC: %s\n______________________________",
            userName, from, to, seats, date, returnDate, pickupPoint, dropoffPoint, time, ac);

    // Write the ticket information to file
    try {
        FileWriter writer = new FileWriter("Data/ticket_information.txt", true); // append mode
        writer.write(ticketInfo);
        writer.write("\n\n"); // Add newline for better readability
        writer.close();
        System.out.println("Ticket information saved successfully.");
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error occurred while saving ticket information.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private String retrieveUserName() {
    try (BufferedReader reader = new BufferedReader(new FileReader("Data/user_data.txt"))) {
        return reader.readLine(); // Assuming the first line contains the username
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}


private void showTicketPrice() {
        // Retrieve the necessary information
        int seats = (int) seatsComboBox.getSelectedItem();
        String ac = acComboBox.getSelectedItem().toString();
        
        // Simple calculation formula for ticket price
        int basePrice = 500; // Base price per seat
        int acCharge = ac.equals("AC") ? 200 : 0; // Additional charge for AC
        int totalPrice = seats * (basePrice + acCharge);

        // Show the ticket price in a dialog box
        JOptionPane.showMessageDialog(frame, "Total Ticket Price: " + totalPrice + " BDT", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BusReservationPage();
            }
        });
    }
}
