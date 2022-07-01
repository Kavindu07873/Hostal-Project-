package TM;

import javafx.scene.control.Button;

public class RoomTM {
    private String Room_type;
    private String Type_Id;
    private String Description;
    private double Price;
    private String keyMoney;
    private Button status;

    public RoomTM() {
    }

    public RoomTM(String room_type, String type_Id, String description, double price, String keyMoney, Button status) {
        Room_type = room_type;
        Type_Id = type_Id;
        Description = description;
        Price = price;
        this.keyMoney = keyMoney;
        this.status = status;
    }

    public RoomTM(String room_type, String type_id, String description, double price, String kyMoney) {
    }

    public String getRoom_type() {
        return Room_type;
    }

    public void setRoom_type(String room_type) {
        Room_type = room_type;
    }

    public String getType_Id() {
        return Type_Id;
    }

    public void setType_Id(String type_Id) {
        Type_Id = type_Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public Button getStatus() {
        return status;
    }

    public void setStatus(Button status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "Room_type='" + Room_type + '\'' +
                ", Type_Id='" + Type_Id + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", keyMoney='" + keyMoney + '\'' +
                ", status=" + status +
                '}';
    }
}
