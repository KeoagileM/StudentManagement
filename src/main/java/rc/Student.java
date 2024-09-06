package rc;
import java.util.*;

/**
 *
 * @author Keoagile Mafora (ST10457034)
 */
public class Student {
    static Scanner input = new Scanner(System.in); 
    static ArrayList<Student> students = new ArrayList<>();
    static int studentCount = 0;
    public int id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    

    public static void saveStudent() {
        Scanner inputs = new Scanner(System.in);
        studentCount++;
        
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************************");
        
        System.out.println("Enter the student ID:");
        int id = inputs.nextInt();
        inputs.nextLine();
        
        System.out.println("Enter the student name:");
        String name =inputs.nextLine();
        
        System.out.println("Enter the student age:");
        int age;
        while (true) { 
            try{
                age = inputs.nextInt();
                if(age >= 16) {
                    break;
                }else {
                    System.out.println("You have entered a incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                }
            } catch (InputMismatchException e) {
                System.out.println("You have entered a incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
                inputs.nextLine();
            }
        }
        inputs.nextLine();
        System.out.println("Enter the student emali");
        String email = inputs.nextLine();
        
        System.out.println("Enter the student course");
        String course = inputs.nextLine();
        
        Student student = new Student(id, name, age, email, course);
        students.add(student);
        
       
    }
    

    public static void searchStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student ID to search:");
        int newId = input.nextInt();
        
        boolean found = false;
        for ( Student student : students) {
            if( student.getId() == newId) {
                System.out.println("STUDENT ID: " + student.getId());
            
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
        
        found = true;
        break;
        
        }
    }
        if (!found) {
            System.out.println("Student with Student Id: " + newId + " was not found");
        }
}
    public static void addStudent(Student student) {
        students.add(student);
    }
    public static void deleteStudent() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the student id to delete");
        int deletedId = input.nextInt();
        input.nextLine();
        
        boolean delete = false;
        for (Student student : students ) {
            if (student.getId() == deletedId) {
                System.out.println("Are you sure you want student " + student.getId() + "from the system? type 'y' to confirm");
            String confirmation = input.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                System.out.println("Student with Student Id: " + deletedId + " was deleted");
                students.remove(student);
                delete = true;
            }
            break;
            }
        }
        if (!delete) {
            System.out.println("Student with Student Id: " + deletedId + " was not found");
        }
    }

    public static void studentReport() {
            System.out.println("STUDENT REPORT");
            System.out.println("***************");
            for(Student student : students) {
                System.out.println("STUDENT ID: " + student.getId());
                System.out.println("STUDENT NAME: " + student.getName());
                System.out.println("STUDENT AGE: " + student.getAge());
                System.out.println("STUDENT EMAIL: " + student.getEmail());
                System.out.println("STUDENT COURSE: " + student.getCourse());
            }
    }
    
    public static boolean studentAgeValid(int age) {
        return age >= 16 && age <= 100;
    }
    
    public static boolean studentAgeValid(String age) {
        
        try {
            int ageValue = Integer.parseInt(age);
            return studentAgeValid(ageValue);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
