import java.util.*;

public class Scheduler {

    public static void generateSchedule(List<Project> projects) {

        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }

        // Sort projects by highest revenue first
        projects.sort((a, b) -> Integer.compare(b.revenue, a.revenue));

        Project[] schedule = new Project[5]; // Monday–Friday
        boolean[] occupied = new boolean[5];

        int totalRevenue = 0;

        for (Project p : projects) {

            // Skip invalid deadlines
            if (p.deadline < 1 || p.deadline > 5) {
                System.out.println("Skipping invalid project: " + p.title);
                continue;
            }

            // Try to schedule on latest possible day before deadline
            for (int day = p.deadline - 1; day >= 0; day--) {

                if (!occupied[day]) {
                    occupied[day] = true;
                    schedule[day] = p;
                    totalRevenue += p.revenue;
                    break;
                }
            }
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("\n===== Weekly Schedule =====");

        for (int i = 0; i < 5; i++) {
            if (schedule[i] != null)
                System.out.println(days[i] + " → " + schedule[i].title +
                        " (₹" + schedule[i].revenue + ")");
            else
                System.out.println(days[i] + " → No Project");
        }

        System.out.println("\nTotal Revenue Earned: ₹" + totalRevenue);
    }
}
