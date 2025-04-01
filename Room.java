public class Room {
    String floor;
    String wing;
    int roomNum;
    int id;
    public Room(String floor, String wing, int roomNum, int id){
        this.floor=floor;
        this.wing=wing;
        this.roomNum=roomNum;
        this.id=id;
    }
    public String getCombo(){
        return floor+wing+roomNum;
    }
}