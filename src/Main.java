import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Generate Weekly Schedule");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.print("Deadline (1–5): ");
                    int deadline = sc.nextInt();
                    System.out.print("Revenue: ");
                    int revenue = sc.nextInt();
                    ProjectDAO.addProject(title, deadline, revenue);
                    break;

                case 2:

                            for(Project p :  ProjectDAO.getAllProjects()){
                                    System.out.println(
                                    p.id + " " + p.title + " " + p.deadline + " " + p.revenue)
                            ;}

                    break;

                case 3:
                    Scheduler.generateSchedule(ProjectDAO.getAllProjects());
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
