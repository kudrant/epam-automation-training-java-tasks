package epamqasejavaexceptions.model;

import epamqasejavaexceptions.exceptions.EmptyStudyGroupException;
import epamqasejavaexceptions.exceptions.IncorrectScoreException;
import epamqasejavaexceptions.util.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * EPAM QA SE course Java Exceptions Main task
 * <p>
 * В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.
 * <p>
 * Посчитать средний балл по всем предметам студента
 * Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
 * Посчитать средний балл по предмету для всего университета
 * <p>
 * Реализовать следующие исключения:
 * <p>
 * Оценка ниже 0 или выше 10
 * Отсутствие предметов у студента (должен быть хотя бы один)
 * Отсутствие студентов в группе
 * Отсутствие групп на факультете
 * Отсутствие факультетов в университете
 *
 *
 *
 * <p>
 * The university has several faculties in which students study in groups.
 * Each student has several subjects in which he receives grades.
 * It is necessary to implement a hierarchy of students, groups and faculties.
 * <p>
 * Calculate the GPA in all of the student's subjects
 * Calculate the average score for a specific subject in a specific group and at a specific faculty
 * Calculate the GPA in a subject for the entire university
 * <p>
 * Implement the following exceptions:
 * Score below 0 or above 10
 * Lack of subjects for the student (must have at least one)
 * Lack of students in the group
 * Lack of groups in the faculty
 * Lack of faculties at the university
 */
public class University {
    private List<Student> students = new ArrayList<>();

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void showAverageScoreBySubjectGroupFaculty(Faculty faculty, int group, Subject subject) throws EmptyStudyGroupException {
        int counter = 0;
        double scoreSum = 0.0;
        for (Student student : students
        ) {
            if (student.getFaculty() == faculty && student.getGroup() == group) {
                try {
                    scoreSum += student.getScoreBySubject(subject);
                    counter++;
                } catch (IncorrectScoreException e) {
                    e.printStackTrace();
                }
            }
        }
        double result = Helper.getNormalizedAverage(scoreSum, counter);
        if (result <= 0.0 || result > 10.0)
            throw new EmptyStudyGroupException("Result = " + result);
        Helper.printMessage("Average Score for " +
                subject + " subject " +
                "in group # " + group +
                " at " + faculty + " faculty = " + result);
    }

    public void showAverageScoreBySubjectInUniversity(Subject subject) {
        int counter = 0;
        double result = 0.0;
        for (Student student : students
        ) {
            try {
                result += student.getScoreBySubject(subject);
                counter++;
            } catch (IncorrectScoreException e) {
                e.printStackTrace();
            }
        }
        Helper.printMessage("Average Score for " +
                subject + " subject " +
                "in the University  = " + Helper.getNormalizedAverage(result, counter));
    }

    public void showStudentsByEachFaculty() {
        for (Faculty faculty : Faculty.values()
        ) {
            Helper.printMessage("Students of faculty " + faculty.name());
            for (Student student : students
            ) {
                if (student.getFaculty().equals(faculty))
                    Helper.printMessage(student.toString());
            }
        }
    }
}
