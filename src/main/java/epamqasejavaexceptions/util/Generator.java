package epamqasejavaexceptions.util;

import com.github.javafaker.Faker;
import epamqasejavaexceptions.model.Faculty;
import epamqasejavaexceptions.model.Student;
import epamqasejavaexceptions.model.Subject;

import java.util.*;

public class Generator {
    private static Random random = new Random();

    public static List<Student> generateStudents(int quantity) {
        ArrayList<Student> generatedStudents = new ArrayList<>();

        int id;
        String lastName;
        String name;
        Date birthDate;
        String address;
        String phoneNo;
        Faculty faculty;
        int course;
        int group;

        Faker faker = new Faker();

        for (int i = 1; i <= quantity; i++) {
            lastName = faker.name().lastName();
            name = faker.name().firstName();
            birthDate = faker.date().birthday();
            address = faker.address().fullAddress();
            phoneNo = faker.phoneNumber().phoneNumber();
            int facultyIndex = random.nextInt(4);
            faculty = Faculty.values()[facultyIndex];
            course = random.nextInt(4) + 1;
            group = getGroupNumber();

            generatedStudents.add(new Student(i, lastName, name, birthDate, address, phoneNo, faculty, course, group, generateGrades(faculty)));
        }
        return generatedStudents;
    }

    private static Map<Subject, Double> generateGrades(Faculty faculty) {
        Map<Subject, Double> grades = new HashMap<>();
        for (Subject subject : faculty.getSubjects()
        ) {
            grades.put(subject, Helper.normalizeDouble(random.nextDouble() * 10));
        }
        return grades;
    }

    private static int getGroupNumber() {
        List<Integer> groupID = new ArrayList<>();
        groupID.add(113);
        groupID.add(246);
        groupID.add(315);
        groupID.add(491);
        return groupID.get(random.nextInt(4));
    }


}
