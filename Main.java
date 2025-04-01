import java.util.HashMap;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return fileData;
        }
    }
    private static void makeRooms(){
        String floors[] = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String wings[] = {"N", "S", "E", "W"};
        int roomNum [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int id = 1;

        for (String floor : floors){
            for (String wing: wings){
                for (int num : roomNum){
                    String combination = floor+wing+num;
                    System.out.println("INSERT INTO Rooms (r_id, room) VALUES (" + id + "," + combination + ");");
                    Room room = new Room(floor, wing, num, id);
                    System.out.println(room.getCombo());
                    id++;
                }
            }
        }


    }

    private static void makeAssignmentTypes(){
        String AssignTypes[] = {"Major", "Minor"};
        for (int i = 1; i<=AssignTypes.length; i++){
            AssignmentType assignment = new AssignmentType(i, AssignTypes[i-1]);
            System.out.println(assignment.getId());
            System.out.println(assignment.getType());
            System.out.println("INSERT INTO Assignment_Type(as_type_id, Assignment_Type_Name) VALUES (" + i + "," + assignment.getType() + ");");
        }

    }

    public static void makeCourseTypes(){
        String CourseTypes[] = {"AP", "Elective", "Regents"};
        for(int i = 1; i<= CourseTypes.length; i++){
            CourseType courseType = new CourseType(i, CourseTypes[i-1]);
            System.out.println("INSERT INTO Course_Type(as_type_id, Assignment_Type_Name) VALUES (" + i + "," + courseType.getType() + ");");
        }

    }

    public static void makePeople(ArrayList<String> data){
        HashMap<String, Integer> DeptIds = new HashMap<String, Integer>();
        DeptIds.put("Biology", 1);
        DeptIds.put("Chemistry", 2);
        DeptIds.put("CTE", 3);
        DeptIds.put("English", 4);
        DeptIds.put("PE", 5);
        DeptIds.put("Mathematics", 6);
        DeptIds.put("Physics", 7);
        DeptIds.put("Social", 8 );
        DeptIds.put("Arts", 9);
        DeptIds.put("Language", 10);
        int peopleId = 5001;
        int currDept = 0;
        for (int i = 0; i < data.size(); i++){
            if (!data.get(i).contains(" ")){
                currDept = DeptIds.get(data.get(i));

            }
            if (data.get(i).contains(" ")){
                int firstSpace = data.get(i).indexOf(" ");
                String firstName = data.get(i).substring(0,firstSpace);
                String lastName = data.get(i).substring(firstSpace+1);
                System.out.println("INSERT INTO People(p_id, d_id, First_Name, Last_Name) VALUES (" + peopleId + "," + currDept + "," + firstName +"," + lastName+");");

                peopleId++;
            }

        }

    }




    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DataPopulate/Teachers.txt");
        makeCourseTypes();
    }
}
