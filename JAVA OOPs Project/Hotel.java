import javax.swing.JOptionPane;

class Hotel {
    static HotelRoom[][] rooms = new HotelRoom[4][60];
    static int roomNumber;

    static void display(int roomType, String feature) {
        JOptionPane.showMessageDialog(null, "\nRoom Type " + roomType + " - " + feature);
    }

    static void displayFeatures(int roomType) {
        switch (roomType) {
            case 1:
                display(roomType, "1 double bed, AC, Free breakfast, Charge per day: 4000");
                break;
            case 2:
                display(roomType, "1 double bed, No AC, Free breakfast, Charge per day: 3000");
                break;
            case 3:
                display(roomType, "1 single bed, AC, Free breakfast, Charge per day: 2200");
                break;
            case 4:
                display(roomType, "1 single bed, No AC, Free breakfast, Charge per day: 1200");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Enter a valid option");
                break;
        }
    }

    static void displayAvailability(int roomType) {
        int count = 0;
        for (HotelRoom room : rooms[roomType - 1]) {
            if (room == null) {
                count++;
            }
        }
        JOptionPane.showMessageDialog(null, "Number of rooms available for Room Type " + roomType + ": " + count);
    }

    static int bookRoom(int roomType) {
        int roomNumber = -1;
        for (int i = 0; i < rooms[roomType - 1].length; i++) {
            if (rooms[roomType - 1][i] == null) {
                roomNumber = i;
                break;
            }
        }

        if (roomNumber != -1) {
            String name = JOptionPane.showInputDialog("Enter customer name:");
            String contact = JOptionPane.showInputDialog("Enter contact number:");
            String gender = JOptionPane.showInputDialog("Enter gender:");

            switch (roomType) {
                case 1:
                    rooms[roomType - 1][roomNumber] = new DeluxeRoom(name, contact, gender);
                    break;
                case 2:
                    rooms[roomType - 1][roomNumber] = new StandardRoom(name, contact, gender);
                    break;
                case 3:
                    rooms[roomType - 1][roomNumber] = new SingleRoom(name, contact, gender);
                    break;
                case 4:
                    rooms[roomType - 1][roomNumber] = new DoubleRoom(name, contact, gender);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Enter a valid room type");
                    break;
            }

            JOptionPane.showMessageDialog(null, "Room Booked successfully, Room Number: " + (roomNumber + 1));
        } else {
            JOptionPane.showMessageDialog(null, "No rooms available of this type.");
        }

        return roomNumber;
    }

    static void orderFood() {
        int roomIndex = roomNumber - 1;
        if (rooms[roomIndex / 10][roomIndex % 10] != null) {
            JOptionPane.showMessageDialog(null, "\nMenu:\n1. Sandwich\tRs.50\n2. Pasta\tRs.60\n3. Noodles\tRs.70\n4. Coke\t\tRs.30");

            char wish;
            do {
                int itemNo = Integer.parseInt(JOptionPane.showInputDialog("Enter item number:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));

                rooms[roomIndex / 10][roomIndex % 10].food.add(new Food(itemNo, quantity));

                wish = JOptionPane.showInputDialog("Do you want to order anything else? (y/n)").charAt(0);

                while (wish != 'y' && wish != 'Y' && wish != 'n' && wish != 'N') {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'y' or 'n'.");
                    wish = JOptionPane.showInputDialog("Invalid input. Please enter 'y' or 'n'.").charAt(0);
                }

            } while (wish == 'y' || wish == 'Y');

            JOptionPane.showMessageDialog(null, "Order successfully delivered.");
        } else {
            JOptionPane.showMessageDialog(null, "Room not booked or invalid room number.");
        }
    }

    static void checkout() {
        int roomIndex = roomNumber - 1;
        if (rooms[roomIndex / 10][roomIndex % 10] != null) {
            System.out.println("Checkout successful. Bill details:");

            double amount = 0;
            System.out.println("\nFood Charges:");
            for (Food food : rooms[roomIndex / 10][roomIndex % 10].food) {
                amount += food.price;
                System.out.println("Item: " + food.itemNo + ", Quantity: " + food.quantity + ", Price: " + food.price);
            }

            System.out.println("\nRoom Charge: " + rooms[roomIndex / 10][roomIndex % 10].getRoomCharge());
            amount += rooms[roomIndex / 10][roomIndex % 10].getRoomCharge();

            System.out.println("Total Amount: " + amount);

            rooms[roomIndex / 10][roomIndex % 10] = null;
            System.out.println("Deallocated successfully.");

            JOptionPane.showMessageDialog(null, "Checkout successful. Total Amount: " + amount);
        } else {
            JOptionPane.showMessageDialog(null, "Room not booked or invalid room number.");
        }
    }
}
