//Program 7
//Bethany Schafer
//21013
import java.util.*;
import java.io.*;

public class ClassStats
{
    public String path = "";
    public String input = "";
    public int percentage = 0;
    public int lowPercentage = 0;
    public int highPercentage = 0;
    public int average = 0;
    public int total = 0;

    public void sortClass()
    {
      ArrayList<Student> classList = new ArrayList<Student>();
      System.out.println("Class Stats program by Bethany Schafer");
      System.out.println("loaded " + "'" + path + "'");

      try
      {
        Scanner fileScan = new Scanner(new File(path));
        String[] classAssignments = fileScan.nextLine().split(",");
        String line = "";
        while(fileScan.hasNext())
        {
          line = fileScan.nextLine();
          String[] grades = line.split(",");
          classList.add(new Student(  grades[0], grades[1],
                                    Double.parseDouble(grades[2]),
                                    Double.parseDouble(grades[3]),
                                    Double.parseDouble(grades[4]),
                                    Double.parseDouble(grades[5]),
                                    Double.parseDouble(grades[6]) ));

        }
        ArrayList<Integer> totalPointsList = new ArrayList<Integer>();
        for(int i = 1; i<classList.size(); i++)
        {
          percentage = classList.get(i).getTP();
          totalPointsList.add(new Integer( percentage ));
        for(int j = 1; j<totalPointsList.size(); j++)
        {
          if( totalPointsList.get(j)< totalPointsList.get(j-1))
          {
            Collections.swap(totalPointsList, j, j-1);
          }
        }
        }
        for(int i = 0; i<totalPointsList.size(); i++)
        {
          total += totalPointsList.get(i);
           average = total / totalPointsList.size();
        }

        while(true){
          Scanner scan = new Scanner(System.in);
          System.out.println();
          System.out.print("> ");

          input = scan.nextLine();
          if(input.equalsIgnoreCase("help"))
          {
            System.out.println("      Accepted commands: ");
            System.out.println("      exit");
            System.out.println("      help");
            System.out.println("      students");
            System.out.println("      search [partial name]");
            System.out.println("      assignments");
            System.out.println("      report");
            System.out.println("      student [student name]");
            System.out.println("      assignment [assignment name]");

            continue;
          }
          else if(input.equalsIgnoreCase("exit")){ System.exit(0);}
          else if (input.equalsIgnoreCase("students"))
          {
            System.out.println("Student Grades for Philosophy 101, Sextion 1");
            System.out.println("Total Points Possible: " + classList.get(0).getTP());
            System.out.println();
            System.out.format("%10s%15s%10s%10s", "First Name", "Last Name", "Points", "Grade");
            System.out.println();
            System.out.format("%10s%15s%10s%10s", "----------", "---------", "------", "-----");
            System.out.println();
            for(int i = 1;i<classList.size(); i++){
              System.out.printf("%-16s%-17s%-9d%-10c\n", classList.get(i).getFirstName(),
                                 classList.get(i).getLastName(),
                                 classList.get(i).getTP(),
                                 classList.get(i).getLetterGrade());
            }
          }
          else if (input.equalsIgnoreCase("assignments"))
          {
            System.out.println("Assignments for Philosophy 101, Section 1");
            System.out.println();
            System.out.format("%11s%7s", "Assignments", "Points");
            System.out.println();
            System.out.format("%10s%7s", "-----------", "------");
            System.out.println();

            System.out.printf("%-14s%4.0f\n", classAssignments[2],classList.get(0).getEssay1());
            System.out.printf("%-14s%4.0f\n", classAssignments[3], classList.get(0).getTest1());
            System.out.printf("%-14s%4.0f\n", classAssignments[4], classList.get(0).getEssay2());
            System.out.printf("%-14s%4.0f\n", classAssignments[5], classList.get(0).getTest2());
            System.out.printf("%-14s%4.0f\n", classAssignments[6], classList.get(0).getFinal1());

          }

          /*else if (input.substring(0,7).equalsIgnoreCase("search "))
          {
            String partialName = input.substring(7);

            System.out.format("%10s%15s%10s%10s", "First Name", "Last Name", "Points", "Grade");
            System.out.println();
            System.out.format("%10s%15s%10s%10s", "----------", "---------", "------", "-----");
            System.out.println();
            for(int i =1; i<classList.size(); i++)
            {

              if(classList.get(i).getFirstName().contains(partialName) ||
                 classList.get(i).getLastName().contains(partialName))
              {
                System.out.printf("%-16s%-17s%-9d%-10c\n", classList.get(i).getFirstName(),
                                   classList.get(i).getLastName(),
                                   classList.get(i).getTP(),
                                   classList.get(i).getLetterGrade());
              }
            }
          }
*/
        /*  else if (input.substring(0,8).equalsIgnoreCase("student "))
          {
            String[] student = new String[input.substring(8).length()];
            student = input.substring(8).split(" ");

            System.out.format("%11s%7s", "Assignments", "Points");
            System.out.println();
            System.out.format("%10s%7s", "-----------", "------");
            System.out.println();

            for(int i = 1; i<classList.size(); i++)
            {
                if( classList.get(i).getFirstName().equals(student[0]) &&
                    classList.get(i).getLastName().equals(student[1]))
                {
                  System.out.println(classList.get(i).getFirstName());
                }
            }
          }
          */
          else if(input.equalsIgnoreCase("report"))
          {
            System.out.println("Grade breakdown for Philosophy 101, Section 1");
            System.out.println();
            System.out.println("Low: " + totalPointsList.get(0) + "%");
            System.out.println("High: " + totalPointsList.get(totalPointsList.size()-1) + "%");
            System.out.println("Ave: " + average + "%");

          }
        }
      }
      catch (FileNotFoundException e)
      {
        System.out.println("ERROR: File cannot be found ");
        System.out.println("Usage: Enter an existing file.");
        System.exit(0);
      }


    }
    public String getPath() {return path;}
    public void setPath(String p) {path = p;}

    public static void main(String[] args)
    {
      if (args.length != 1) {
        System.out.println("ERROR: incorrect number of arguments\n"+ "Usage: java ClassStats [path\\fileName.txt] ");
        System.exit(0);
      }
      ClassStats classStats = new ClassStats();
      classStats.setPath(args[0]);
      classStats.sortClass();
    }

}
