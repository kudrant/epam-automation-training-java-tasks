package epamqasejavaexceptions;

import epamqasejavaexceptions.exceptions.EmptyStudyGroupException;
import epamqasejavaexceptions.model.Faculty;
import epamqasejavaexceptions.model.Subject;
import epamqasejavaexceptions.model.University;
import epamqasejavaexceptions.util.Generator;

public class Runner {

    public static void main(String[] args) {
        University university = new University();
        university.setStudents(Generator.generateStudents(50));
        university.showStudentsByEachFaculty();
        try {
            university.showAverageScoreBySubjectGroupFaculty(Faculty.CS, 246, new Subject("CSC-221"));
        } catch (EmptyStudyGroupException e) {
            e.printStackTrace();
        }
        university.showAverageScoreBySubjectInUniversity(new Subject("Microeconomics I"));
    }
}
