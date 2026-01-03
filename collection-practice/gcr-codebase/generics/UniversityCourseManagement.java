import java.util.ArrayList;
import java.util.List;


abstract class CourseType {

    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}

class ExamCourse extends CourseType {

    public ExamCourse() {
        super("Exam Based");
    }
}

class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        super("Assignment Based");
    }
}

class ResearchCourse extends CourseType {

    public ResearchCourse() {
        super("Research Based");
    }
}


abstract class Course<T extends CourseType> {

    private String courseName;
    private int credits;
    private T courseType;

    public Course(String courseName, int credits, T courseType) {
        this.courseName = courseName;
        this.credits = credits;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public T getCourseType() {
        return courseType;
    }

    public abstract void display();
}


class ComputerScienceCourse extends Course<ExamCourse> {

    public ComputerScienceCourse(String name, int credits) {
        super(name, credits, new ExamCourse());
    }

    @Override
    public void display() {
        System.out.printf(
                "Computer Science course [%s] (%d credits) evaluated via [%s]%n",
                getCourseName(),
                getCredits(),
                getCourseType().getEvaluationMethod()
        );
    }
}

class ManagementCourse extends Course<AssignmentCourse> {

    public ManagementCourse(String name, int credits) {
        super(name, credits, new AssignmentCourse());
    }

    @Override
    public void display() {
        System.out.printf(
                "Management course [%s] (%d credits) evaluated via [%s]%n",
                getCourseName(),
                getCredits(),
                getCourseType().getEvaluationMethod()
        );
    }
}

class ResearchProgramCourse extends Course<ResearchCourse> {

    public ResearchProgramCourse(String name, int credits) {
        super(name, credits, new ResearchCourse());
    }

    @Override
    public void display() {
        System.out.printf(
                "Research course [%s] (%d credits) evaluated via [%s]%n",
                getCourseName(),
                getCredits(),
                getCourseType().getEvaluationMethod()
        );
    }
}


class CourseCatalog<T extends Course<?>> {

    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getAllCourses() {
        return courses;
    }
}


class UniversityUtils {

    public static void displayAllCourses(List<? extends Course<?>> courses) {
        for (Course<?> course : courses) {
            course.display();
        }
    }
}


public class UniversityCourseManagement {

    public static void main(String[] args) {

        CourseCatalog<ComputerScienceCourse> csCatalog = new CourseCatalog<>();
        csCatalog.addCourse(new ComputerScienceCourse("Data Structures", 4));
        csCatalog.addCourse(new ComputerScienceCourse("Operating Systems", 3));

        CourseCatalog<ManagementCourse> managementCatalog = new CourseCatalog<>();
        managementCatalog.addCourse(new ManagementCourse("Business Strategy", 3));
        managementCatalog.addCourse(new ManagementCourse("Marketing Fundamentals", 2));

        CourseCatalog<ResearchProgramCourse> researchCatalog = new CourseCatalog<>();
        researchCatalog.addCourse(new ResearchProgramCourse("AI Research", 6));
        researchCatalog.addCourse(new ResearchProgramCourse("Quantum Computing", 5));

        System.out.println("---- Computer Science Courses ----");
        UniversityUtils.displayAllCourses(csCatalog.getAllCourses());

        System.out.println("---- Management Courses ----");
        UniversityUtils.displayAllCourses(managementCatalog.getAllCourses());

        System.out.println("---- Research Programs ----");
        UniversityUtils.displayAllCourses(researchCatalog.getAllCourses());
    }
}
