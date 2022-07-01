package TM;

public class StudentTM {
    private String Stu_Id;
    private String Name;
    private String Address;

    public StudentTM() {
    }

    public StudentTM(String stu_Id, String name, String address) {
        Stu_Id = stu_Id;
        Name = name;
        Address = address;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "Stu_Id='" + Stu_Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
