import java.util.*;
import java.io.*;

public class Student
{
  String firstName = "";
  String lastName = "";
  double essay1 = 0.0;
  double test1 = 0.0;
  double essay2 = 0.0;
  double test2 = 0.0;
  double final1 = 0.0;
  int totalPoints = 0;
  char gradeLetter = ' ';
  

  public Student(String fN, String lN,
                  double e1, double t1,
                  double e2, double t2, double f1)
  {
    firstName = fN;
    lastName = lN;
    essay1 = e1;
    test1 = t1;
    essay2 = e2;
    test2 = t2;
    final1 = f1;

    totalPoints = (int)(e1 + t1 + e2 + t2 + f1);
    if(totalPoints >= 90 ){ gradeLetter = 'A';}
    else if(totalPoints >= 80){ gradeLetter = 'B';}
    else if(totalPoints >= 70){ gradeLetter = 'C';}
    else if(totalPoints >= 60){ gradeLetter = 'D';}
    else if(totalPoints < 60){ gradeLetter = 'F';}



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
    return essay1;
  }
  public void setEssay1(double e1){
    essay1 = e1;
  }
  public double getTest1() {
    return test1;
  }
  public void setTest1(double t1){
    test1 = t1;
  }
  public double getEssay2() {
    return essay2;
  }
  public void setEssay2(double e2){
    essay2 = e2;
  }
  public double getTest2() {
    return test2;
  }
  public void setTest2(double t2){
    test2 = t2;
  }
  public double getFinal1() {
    return final1;
  }
  public void setFinal1(double f1){
    final1 = f1;
  }

  public int getTP() { return totalPoints;}
  public char getLetterGrade() { return gradeLetter;}
}
