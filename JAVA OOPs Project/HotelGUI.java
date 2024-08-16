import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class HotelGUI {
    private static int roomType;
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeGUI();
            }
        });
    }

    private static void initializeGUI() {
        frame = new JFrame("Hotel Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton displayRoomButton = new JButton("Display Room Details");
        displayRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRoomDetails();
            }
        });

        JButton displayAvailabilityButton = new JButton("Display Room Availability");
        displayAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRoomAvailability();
            }
        });

        JButton bookRoomButton = new JButton("Book a Room");
        bookRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookRoom();
            }
        });

        JButton orderFoodButton = new JButton("Order Food");
        orderFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFood();
            }
        });

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(displayRoomButton);
        panel.add(displayAvailabilityButton);
        panel.add(bookRoomButton);
        panel.add(orderFoodButton);
        panel.add(checkoutButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void displayRoomDetails() {
        String userInput = JOptionPane.showInputDialog(frame, "Enter room type (1-4):");
        roomType = Integer.parseInt(userInput);
        Hotel.displayFeatures(roomType);
    }

    private static void displayRoomAvailability() {
        String userInput = JOptionPane.showInputDialog(frame, "Enter room type (1-4):");
        roomType = Integer.parseInt(userInput);
        Hotel.displayAvailability(roomType);
    }

    private static void bookRoom() {
        String userInput = JOptionPane.showInputDialog(frame, "Enter room type (1-4):");
        roomType = Integer.parseInt(userInput);
        Hotel.roomNumber = Hotel.bookRoom(roomType);
    }

    private static void orderFood() {
        String userInput = JOptionPane.showInputDialog(frame, "Enter room number:");
        Hotel.roomNumber = Integer.parseInt(userInput);
        Hotel.orderFood();
    }

    private static void checkout() {
        String userInput = JOptionPane.showInputDialog(frame, "Enter room number:");
        int roomNumber = Integer.parseInt(userInput);
        Hotel.roomNumber = roomNumber;
        Hotel.checkout();
    }
}
