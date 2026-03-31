import java.util.*;

public class Program {

    public void RegisterCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    public Dictionary<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Dictionary<String, Integer> result = new Hashtable<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double likes : creator.WeeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.CreatorName, count);
            }
        }
        return result;
    }

    public double CalculateAverageLikes() {
        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            for (double likes : creator.WeeklyLikes) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0) {
            return 0;
        }

        return totalLikes / totalWeeks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        int choice;

        do {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] weeklyLikes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        weeklyLikes[i] = sc.nextDouble();
                    }
                    sc.nextLine();

                    CreatorStats creator = new CreatorStats(name, weeklyLikes);
                    program.RegisterCreator(creator);

                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();
                    sc.nextLine();

                    Dictionary<String, Integer> topPosts =
                            program.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        Enumeration<String> keys = topPosts.keys();
                        while (keys.hasMoreElements()) {
                            String key = keys.nextElement();
                            System.out.println(key + " - " + topPosts.get(key));
                        }
                    }
                    break;

                case 3:
                    double average = program.CalculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) average);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
