class ParcelTracker {

    private Node head;

    static class Node {
        String stage;
        Node next;

        Node(String stage) {
            this.stage = stage;
        }
    }

    public void addStage(String stage) {
        if (head == null) {
            head = new Node(stage);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(stage);
    }

    public void addCheckpointAfter(String existingStage, String newStage) {
        Node temp = head;
        while (temp != null) {
            if (temp.stage.equals(existingStage)) {
                Node node = new Node(newStage);
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    public void trackParcel() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Parcel lost or tracking unavailable");
            return;
        }
        while (temp != null) {
            System.out.println("Stage: " + temp.stage);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpointAfter("Shipped", "Customs Check");

        tracker.trackParcel();
    }
}
