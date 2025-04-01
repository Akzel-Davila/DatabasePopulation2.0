public class People {
    int id;
    String firstName;
    String lastName;
    int d_id;

    public People(int id, String firstName, String lastName, int d_id){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.d_id = d_id;

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getD_id() {
        return d_id;
    }
}