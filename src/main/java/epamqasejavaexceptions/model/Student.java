package epamqasejavaexceptions.model;

import epamqasejavaexceptions.exceptions.IncorrectScoreException;
import epamqasejavaexceptions.util.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class Student {
    private final int id;
    private final String lastName;
    private final String name;
    private final Date birthDate;
    private final String address;
    private final String phoneNo;
    private final Faculty faculty;
    private final int course;
    private final int group;
    private final Map<Subject, Double> grades;

    public Student(int id, String lastName, String name, Date birthDate, String address, String phoneNo, Faculty faculty, int course, int group, Map<Subject, Double> grades) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNo = phoneNo;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
        this.grades = grades;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getGroup() {
        return group;
    }

    public double getAverageScore() {
        Double result = 0.0;
        for (Map.Entry<Subject, Double> entry : grades.entrySet()
        ) {
            result += entry.getValue();
        }
        return Helper.getNormalizedAverage(result, grades.size());
    }

    public double getScoreBySubject(Subject subject) throws IncorrectScoreException {
        for (Map.Entry<Subject, Double> entry : grades.entrySet()
        ) {
            if (entry.getKey().equals(subject)) {
                return entry.getValue();
            }
        }
        throw new IncorrectScoreException();
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return "Student #" + id +
                ", Name = " + lastName + " " + name +
                ", Date of birth = " + format.format(birthDate) +
                ", Faculty = " + faculty +
                ", Course = " + course +
                ", Group # = " + group +
                ", Average score (GPA) = " + getAverageScore();

    }
}
