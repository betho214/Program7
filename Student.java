import java.util.*;
import java.io.*;

public class Student
{
  String firstName = "";
  String lastName = "";
  double[] assignmentPoints = {0.0,0.0,0.0,0.0,0.0,0.0};
  char gradeLetter = ' ';


  public Student(String fN, String lN,
                  double e1, double t1,
                  double e2, double t2, double f1)
  {
    firstName = fN;
    lastName = lN;
    assignmentPoints[0] = e1;
    assignmentPoints[1] = t1;
    assignmentPoints[2] = e2;
    assignmentPoints[3] = t2;
    assignmentPoints[4] = f1;
    assignmentPoints[5] = (e1 + t1 + e2 + t2 + f1);
    if(assignmentPoints[5] >= 90 ){ gradeLetter = 'A';}
    else if(assignmentPoints[5] >= 80){ gradeLetter = 'B';}
    else if(assignmentPoints[5] >= 70){ gradeLetter = 'C';}
    else if(assignmentPoints[5] >= 60){ gradeLetter = 'D';}
    else if(assignmentPoints[5] < 60){ gradeLetter = 'F';}
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String fN){
    firstName = fN;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lN){
    lastName = lN;
  }
  public double getEssay1() {
    return assignmentPoints[0];
  }
  public void setEssay1(double e1){
    assignmentPoints[0] = e1;
  }
  public double getTest1() {
    return assignmentPoints[1]; //return test1;
  }
  public void setTest1(double t1) {
    assignmentPoints[1] = t1;
  }
  public double getEssay2() {
    return assignmentPoints[2];
  }
  public void setEssay2(double e2) {
    assignmentPoints[2] = e2;
  }
  public double getTest2() {
    return assignmentPoints[3];
  }
  public void setTest2(double t2) {
    assignmentPoints[3] = t2;
  }
  public double getFinal1() {
    return assignmentPoints[4];
  }
  public void setFinal1(double f1) {
    assignmentPoints[4] = f1;
  }
  public double getAssignmentPoints(int index) {
    return assignmentPoints[index-2];
  }


  public int getTP() { return (int)assignmentPoints[5];}

  public char getLetterGrade() { return gradeLetter;}
}
