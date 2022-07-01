package dto;

public class RoomDto {
    private String Room_type;
    private String Type_Id;
    private String Description;
    private double Price;

    public RoomDto() {
    }

    public RoomDto(String room_type, String type_Id, String description, double price) {
        Room_type = room_type;
        Type_Id = type_Id;
        Description = description;
        Price = price;
    }

    public RoomDto(String room_type, String type_id, String description, double price, String kyMoney) {



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

    @Override
    public String toString() {
        return "RoomDto{" +
                "Room_type='" + Room_type + '\'' +
                ", Type_Id='" + Type_Id + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                '}';
    }
}
