import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFiltering {

	public static void main(String[] args) {

		List<Notification> notifications = new ArrayList<>();
		notifications.add(new Notification("30% off on generic medicine.", NotificationType.PROMOTIONAL));
		notifications.add(new Notification("Your blood report is ready.", NotificationType.MEDICAL));
		notifications.add(new Notification("You can schedule your next visit with Dr. XYZ.", NotificationType.GENERAL));
		notifications.add(new Notification("50% off on diabetes test.", NotificationType.PROMOTIONAL));
		notifications.add(new Notification("Donate to our medical trust.", NotificationType.PROMOTIONAL));

		Predicate<Notification> nonPromotionalFilter = notification -> notification
				.getType() != NotificationType.PROMOTIONAL;

		List<Notification> filteredNotifications = notifications.stream().filter(nonPromotionalFilter)
				.collect(Collectors.toList());

		System.out.println("Filtered Notifications:");
		filteredNotifications.forEach(System.out::println);
	}
}

class Notification {

	private final String message;
	private final NotificationType type;

	public Notification(String message, NotificationType type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public NotificationType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "[" + type + "] " + message;
	}
}

enum NotificationType {
	PROMOTIONAL, MEDICAL, GENERAL
}
