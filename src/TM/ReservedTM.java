package TM;

import javax.xml.crypto.Data;

public class ReservedTM {

    private String Reserved_id;
    private String Room_No;
    private String Stu_id;
    private String Stu_Name;
    private String Room_Type;
    private double Price;
    private String Date;

    public ReservedTM() {
    }

    public ReservedTM(String reserved_id, String room_No, String stu_id, String stu_Name, String room_Type, double price, String date) {
        Reserved_id = reserved_id;
        Room_No = room_No;
        Stu_id = stu_id;
        Stu_Name = stu_Name;
        Room_Type = room_Type;
        Price = price;
        Date = date;
    }

    public String getReserved_id() {
        return Reserved_id;
    }

    public void setReserved_id(String reserved_id) {
        Reserved_id = reserved_id;
    }

    public String getRoom_No() {
        return Room_No;
    }

    public void setRoom_No(String room_No) {
        Room_No = room_No;
    }

    public String getStu_id() {
        return Stu_id;
    }

    public void setStu_id(String stu_id) {
        Stu_id = stu_id;
    }

    public String getStu_Name() {
        return Stu_Name;
    }

    public void setStu_Name(String stu_Name) {
        Stu_Name = stu_Name;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String room_Type) {
        Room_Type = room_Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "ReservedTM{" +
                "Reserved_id='" + Reserved_id + '\'' +
                ", Room_No='" + Room_No + '\'' +
                ", Stu_id='" + Stu_id + '\'' +
                ", Stu_Name='" + Stu_Name + '\'' +
                ", Room_Type='" + Room_Type + '\'' +
                ", Price=" + Price +
                ", Date='" + Date + '\'' +
                '}';
    }
}
