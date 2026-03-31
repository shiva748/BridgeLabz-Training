public class TaskScheduler {

	// starting of circular linked list
	private Task head;
	// end of circular linked list
	private Task tail;

	// add a task at front of the list
	public void addAtFront(Task task) {
		if (head == null) {
			head = task;
			tail = task;
			task.setNext(task);
			return;
		}

		task.setNext(head);
		tail.setNext(task);
		head = task;
	}

	// add a task at end of the list
	public void addAtLast(Task task) {
		if (tail == null) {
			addAtFront(task);
			return;
		}

		task.setNext(head);
		tail.setNext(task);
		tail = task;
	}

	// add a task at a specific position (1-based index)
	public void addAtPosition(Task task, int position) {
		if (position <= 1 || head == null) {
			addAtFront(task);
			return;
		}

		Task temp = head;
		int count = 1;

		while (temp.getNext() != head && count < position - 1) {
			temp = temp.getNext();
			count++;
		}

		task.setNext(temp.getNext());
		temp.setNext(task);

		if (temp == tail) {
			tail = task;
		}
	}

	// remove a task by task id
	public void removeTask(int taskId) {
		if (head == null) {
			return;
		}

		Task curr = head;
		Task prev = tail;

		do {
			if (curr.getTaskId() == taskId) {

				if (curr == head && curr == tail) {
					head = null;
					tail = null;
					return;
				}

				if (curr == head) {
					head = head.getNext();
					tail.setNext(head);
				} else if (curr == tail) {
					tail = prev;
					tail.setNext(head);
				} else {
					prev.setNext(curr.getNext());
				}
				return;
			}

			prev = curr;
			curr = curr.getNext();

		} while (curr != head);
	}

	// view current task and move to next task
	public void viewCurrentTask() {
		if (head == null) {
			return;
		}

		printTask(head);
		head = head.getNext();
		tail = tail.getNext();
	}

	// display all tasks
	public void displayTasks() {
		if (head == null) {
			return;
		}

		Task temp = head;
		do {
			printTask(temp);
			temp = temp.getNext();
		} while (temp != head);
	}

	// search tasks by priority
	public void searchByPriority(int priority) {
		if (head == null) {
			return;
		}

		Task temp = head;
		do {
			if (temp.getPriority() == priority) {
				printTask(temp);
			}
			temp = temp.getNext();
		} while (temp != head);
	}

	private void printTask(Task task) {
		System.out.println("Task ID: " + task.getTaskId() + ", Name: " + task.getTaskName() + ", Priority: "
				+ task.getPriority() + ", Due Date: " + task.getDueDate());
	}

	// main method (same usage style as previous programs)
	public static void main(String[] args) {

		TaskScheduler scheduler = new TaskScheduler();

		scheduler.addAtFront(new Task(1, "Design Module", 1, "10-01-2025"));
		scheduler.addAtLast(new Task(2, "Write Code", 2, "12-01-2025"));
		scheduler.addAtLast(new Task(3, "Testing", 2, "14-01-2025"));
		scheduler.addAtPosition(new Task(4, "Review", 1, "13-01-2025"), 3);

		System.out.println("All Tasks:");
		scheduler.displayTasks();

		System.out.println("\nView current task:");
		scheduler.viewCurrentTask();

		System.out.println("\nTasks after moving to next:");
		scheduler.displayTasks();

		System.out.println("\nSearch tasks with priority 2:");
		scheduler.searchByPriority(2);

		System.out.println("\nRemoving task with ID 2:");
		scheduler.removeTask(2);
		scheduler.displayTasks();
	}
}

class Task {
	private int taskId;
	private String taskName;
	private int priority;
	private String dueDate;
	private Task next;

	public Task(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
	}

	public void setNext(Task next) {
		this.next = next;
	}

	public Task getNext() {
		return this.next;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public int getPriority() {
		return this.priority;
	}

	public String getDueDate() {
		return this.dueDate;
	}
}
