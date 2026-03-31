import java.util.*;

public class CreatorStats {

    public String CreatorName;
    public double[] WeeklyLikes;

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.CreatorName = creatorName;
        this.WeeklyLikes = weeklyLikes;
    }
}
