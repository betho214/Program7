import java.util.*;
import java.io.*;

public class Grades extends ClassStats
{

    int aGrades = 0;
    int bGrades = 0;
    int cGrades = 0;
    int dGrades = 0;
    int fGrades = 0;
public static void main(String[] args)
{


    for(int i=0; i<classList.size(); i++)
    {
      if (classList.get(i).getLetterGrade().equals("A"))
      {
        aGrades += 1;
      }
    }
    System.out.println(aGrades);
  }
}
