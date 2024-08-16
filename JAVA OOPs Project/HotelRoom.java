import java.util.ArrayList;

abstract class HotelRoom {
    String name, contact, gender;
    ArrayList<Food> food = new ArrayList<>();

    HotelRoom() {
        this.name = "";
    }

    HotelRoom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }

    abstract double getRoomCharge();
}

class DeluxeRoom extends HotelRoom {
    DeluxeRoom(String name, String contact, String gender) {
        super(name, contact, gender);
    }

    @Override
    double getRoomCharge() {
        return 4000;
    }
}

class StandardRoom extends HotelRoom {
    StandardRoom(String name, String contact, String gender) {
        super(name, contact, gender);
    }

    @Override
    double getRoomCharge() {
        return 3000;
    }
}

class SingleRoom extends HotelRoom {
    SingleRoom(String name, String contact, String gender) {
        super(name, contact, gender);
    }

    @Override
    double getRoomCharge() {
        return 2200;
    }
}

class DoubleRoom extends HotelRoom {
    DoubleRoom(String name, String contact, String gender) {
        super(name, contact, gender);
    }

    @Override
    double getRoomCharge() {
        return 1200;
    }
}

class Food {
    int itemNo, quantity;
    float price;

    Food(int itemNo, int quantity) {
        this.itemNo = itemNo;
        this.quantity = quantity;
        calculatePrice();
    }

    void calculatePrice() {
        switch (itemNo) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;
                break;
        }
    }
}
