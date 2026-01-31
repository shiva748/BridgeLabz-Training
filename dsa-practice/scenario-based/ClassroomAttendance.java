import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DuplicateAttendanceException extends Exception {
    DuplicateAttendanceException(String message) {
        super(message);
    }
}

class AttendanceService {

    private Map<String, Set<String>> attendanceMap = new HashMap<>();

    void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
        attendanceMap.putIfAbsent(sessionId, new HashSet<>());
        Set<String> students = attendanceMap.get(sessionId);

        if (students.contains(studentId)) {
            throw new DuplicateAttendanceException("Attendance already marked for student " + studentId);
        }

        students.add(studentId);
        System.out.println("Attendance marked: " + studentId + " in session " + sessionId);
    }

    void removeAttendance(String sessionId, String studentId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students != null && students.remove(studentId)) {
            System.out.println("Attendance removed: " + studentId + " from session " + sessionId);
        }
    }

    void displayAttendance(String sessionId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students == null || students.isEmpty()) {
            System.out.println("No attendance for session " + sessionId);
            return;
        }

        System.out.println("Attendance for session " + sessionId + ":");
        students.forEach(System.out::println);
    }
}

public class ClassroomAttendance {
    public static void main(String[] args) {

        AttendanceService service = new AttendanceService();

        try {
            service.markAttendance("SESSION1", "STU101");
            service.markAttendance("SESSION1", "STU102");
            service.markAttendance("SESSION1", "STU103");
            service.markAttendance("SESSION1", "STU101");
        } catch (DuplicateAttendanceException e) {
            System.out.println(e.getMessage());
        }

        service.displayAttendance("SESSION1");

        service.removeAttendance("SESSION1", "STU102");

        service.displayAttendance("SESSION1");
    }
}
