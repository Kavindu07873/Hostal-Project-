package dto;

import javax.xml.crypto.Data;

public class ReservedDto {
    private String Stu_Id;
    private String Name;
    private Data Date;
    private String Type_Id;
    private double Price;
    private String Room_No;

    public ReservedDto() {
    }

    public ReservedDto(String stu_Id, String name, Data date, String type_Id, double price, String room_No) {
        Stu_Id = stu_Id;
        Name = name;
        Date = date;
        Type_Id = type_Id;
        Price = price;
        Room_No = room_No;
    }

    public String getStu_Id() {
        return Stu_Id;
    }

    public void setStu_Id(String stu_Id) {
        Stu_Id = stu_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Data getDate() {
        return Date;
    }

    public void setDate(Data date) {
        Date = date;
    }

    public String getType_Id() {
        return Type_Id;
    }

    public void setType_Id(String type_Id) {
        Type_Id = type_Id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getRoom_No() {
        return Room_No;
    }

    public void setRoom_No(String room_No) {
        Room_No = room_No;
    }

    @Override
    public String toString() {
        return "ReservedDto{" +
                "Stu_Id='" + Stu_Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Date=" + Date +
                ", Type_Id='" + Type_Id + '\'' +
                ", Price=" + Price +
                ", Room_No='" + Room_No + '\'' +
                '}';
    }
}
