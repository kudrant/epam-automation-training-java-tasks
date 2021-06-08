package epamqasejavaexceptions.model;

import java.util.ArrayList;
import java.util.List;

public enum Faculty {
    CS {
        @Override
        public List<Subject> getSubjects() {
            return createSubjectsFromNames("CSC-212", "CSC-221", "CSC-231", "CSC-232", "CSC-233");
        }
    },
    BIOLOGY {
        @Override
        public List<Subject> getSubjects() {
            return createSubjectsFromNames("Pathology-402-407", "Pharmacology-408",
                    "Psychology-409", "Biochemistry-411", "Plant Sciences(412)",
                    "Genetics (414)", "Zoology (427)");
        }
    },
    ECONOMICS {
        @Override
        public List<Subject> getSubjects() {
            return createSubjectsFromNames("Microeconomics I", "Municipal and Regional Finance",
                    "Time Series Analysis", "Marketing Research", "Probability and Statistics",
                    "Macroeconomics I", "Management", "Introduction to Public Law");
        }
    },
    MATHEMATICS {
        @Override
        public List<Subject> getSubjects() {
            return createSubjectsFromNames("Analysis I ", "Groups", "Time Series Analysis",
                    "Numbers and Sets", "Probability", "Vectors and Matrices",
                    "Complex Analysis", "Geometry");
        }
    };

    public abstract List<Subject> getSubjects();

    private static List<Subject> createSubjectsFromNames(String... names) {
        List<Subject> subjects = new ArrayList<>();
        for (String name : names
        ) {
            subjects.add(new Subject(name));
        }
        return subjects;
    }


}
