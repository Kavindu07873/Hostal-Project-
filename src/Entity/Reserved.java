package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reserved implements SuperEntity {
    private String Room_No;
@Id
    private String Reserved_id;

    private String Stu_id;
   // private String Stu_Name;
    private String Room_Type;
    private String Date;
     private  String status;

    public Reserved(String stu_id, String room_type, String status, double price, String reserved_id, String room_No) {
    }

    public Reserved(String room_No, String reserved_id, String stu_id, String room_Type, String date, String status) {
        Room_No = room_No;
        Reserved_id = reserved_id;
        Stu_id = stu_id;
        Room_Type = room_Type;
        Date = date;
        this.status = status;
    }

    public String getRoom_No() {
        return Room_No;
    }

    public void setRoom_No(String room_No) {
        Room_No = room_No;
    }

    public String getReserved_id() {
        return Reserved_id;
    }

    public void setReserved_id(String reserved_id) {
        Reserved_id = reserved_id;
    }

    public String getStu_id() {
        return Stu_id;
    }

    public void setStu_id(String stu_id) {
        Stu_id = stu_id;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String room_Type) {
        Room_Type = room_Type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserved{" +
                "Room_No='" + Room_No + '\'' +
                ", Reserved_id='" + Reserved_id + '\'' +
                ", Stu_id='" + Stu_id + '\'' +
                ", Room_Type='" + Room_Type + '\'' +
                ", Date='" + Date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
    //
//     @OneToMany
//     private Student student;
//     @OneToMany
//     private Rooms rooms;



