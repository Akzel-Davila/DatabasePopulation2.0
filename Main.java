import java.lang.reflect.Array;
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
    private static ArrayList makeRooms(){
        String floors[] = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String wings[] = {"N", "S", "E", "W"};
        int roomNum [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        ArrayList <String> allRooms = new ArrayList<String>();
        int id = 1;

        for (String floor : floors){
            for (String wing: wings){
                for (int num : roomNum){
                    String combination = floor+wing+num;
                    allRooms.add(combination);
                    System.out.println("INSERT INTO Rooms (r_id, room) VALUES (" + id + "," + combination + ");");
                    Room room = new Room(floor, wing, num, id);
                    System.out.println(room.getCombo());
                    id++;
                }
            }
        }
        return allRooms;


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

    public static void makeSections() {
        String[] courses = {"Anatomy", "AP Biology", "AP Environmental", "AP Psychology", "Bio-organic Chemistry", "Genetics", "Introduction to Neuroscience", "Living Environment", "Living Environment Lab", "Environmental sustainability",
                "Regents Chemistry", "AP Chemistry", " Organic Chemistry", "MICA", "Quantitative Analysis", "Forensics", "Regents Physics", "Regents Physics Labs", "AP Physics 1", "AP Physics 2", "AP Physics C Mechanics", "AP Physics C E/M", "Astronomy", "Modern Physics",
                "Common Core Algebra", "Common Core Geometry", "Common Core Algebra II", "Pre-Calculus", "Calculus", "AP Calculus AB", "AP Calculus BC", "AP Statistics", "Multivariable Calculus", "Math Research", "Linear Algebra",
                "AP Computer Science Principles", "AP Computer Science A", "Big Data: Warehousing & Analytics", "Computer Science & Engineering Home", "Cyber Security", "Digital Electronics PLTW", "Digital Systems Design", "Electrical Engineering Major", "Fundamentals of IT Infrastructure", "Green Building Construction", "PLTW EDD", "Statics", "Strength of Materials", "Web Development",
                "Physical Education", "Health Education", "9th Grade English", "10th Grade English", "10th Grade: AP Capstone Seminar", "11th Grade English", "11th Grade: AP English Language & Composition", "12th Grade: AP Capstone Research", "12th Grade: AP English Literature & Composition", "12th Grade: Creative Writing", "12th Grade: Drama", "12th Grade: Film & Literature", "12th Grade: Journalism", "12th Grade: Life, Love & Death", "12th Grade: Mystery, Horror & the Supernatural", "12th Grade: Science Fiction & Fantasy", "12th Grade: Yearbook", "The Survey",
                "9th Grade Global", "10th Grade Regents Global History", "AP World History", "AP European History", "11th Grade Regents American History", "AP American History", "Participation in Government", "AP US Government Economics", "AP Macroeconomics", "AP Microeconomics", "AP Comparative Government", "AP Psychology", "AP Human Geography Sociology", "Cultural Anthropology", "Physical Anthropology",
                "Chinese", "AP Chinese Language and Culture", "French", "AP French Language and Culture", "German", "AP German Language and Culture", "Italian", "AP Italian Language and Culture", "Spanish", "Spanish IV", "AP Spanish Language and Culture", "AP Spanish Literature and Culture"
        };
        ArrayList<String> allRooms = makeRooms();
        for (int i = 0; i < courses.length; i ++){


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
                System.out.println("INSERT INTO People(p_id, d_id, First_Name, Last_Name) VALUES (" + peopleId + "," + currDept + ",'" + firstName +"','" + lastName+"');");

                peopleId++;
            }

        }

    }




    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Teachers.txt");
        System.out.println(fileData);
        makeSections();
    }
}
