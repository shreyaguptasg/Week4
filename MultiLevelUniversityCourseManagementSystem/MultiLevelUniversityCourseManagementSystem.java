package Day1.MultiLevelUniversityCourseManagementSystem;
//Create an abstract class
// CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

abstract  class CourseType{
    private String courseName;

    public CourseType(String courseName){
        this.courseName=courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " + courseName;
    }
}

//Different course types extending CourseType
class ExamCourse extends CourseType{
    public ExamCourse(String courseName){
        super(courseName);
    }
}

class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseName){
        super(courseName);
    }
}

class ResearchCourse extends CourseType{
    public ResearchCourse(String courseName){
        super(courseName);
    }
}

//Generic course class with bounded type parameter
class Course<T extends CourseType>{
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course){
        courses.add(course);
    }

    public List<T> getCourses(){
        return courses;
    }
}

//Utility class to display all courses using wildcards
class CourseUtil{
    public static void displayCourse(List<? extends CourseType> courses){
        for(CourseType course : courses){
            System.out.println(course);
        }
    }
}
public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>();
        examCourse.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentCourse= new Course<>();
        assignmentCourse.addCourse(new AssignmentCourse("History"));

        Course<ResearchCourse> researchCourse= new Course<>();
        researchCourse.addCourse(new ResearchCourse("Data Analyst"));

        System.out.println("Exam based course: ");
        CourseUtil.displayCourse(examCourse.getCourses());

        System.out.println("Assignment based course: ");
        CourseUtil.displayCourse(assignmentCourse.getCourses());

        System.out.println("Research based course: ");
        CourseUtil.displayCourse(researchCourse.getCourses());






    }
}
