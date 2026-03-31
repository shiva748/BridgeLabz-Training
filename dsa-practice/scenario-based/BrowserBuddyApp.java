import java.util.Stack;

class Page {
    String url;
    Page prev;
    Page next;

    Page(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class Tab {
    private Page current;

    public void visit(String url) {
        Page newPage = new Page(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }
        current = newPage;

        System.out.println("Visited: " + url);
    }

    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No previous page.");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No forward page.");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    public String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}

class BrowserBuddy {
    private Tab activeTab;
    private Stack<Tab> closedTabs;

    BrowserBuddy() {
        activeTab = new Tab();
        closedTabs = new Stack<>();
    }

    public void visitPage(String url) {
        activeTab.visit(url);
    }

    public void back() {
        activeTab.back();
    }

    public void forward() {
        activeTab.forward();
    }

    public void closeTab() {
        closedTabs.push(activeTab);
        activeTab = new Tab();
        System.out.println("Tab closed.");
    }

    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore.");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("Tab restored. Current page: " +
                activeTab.getCurrentPage());
    }
}

public class BrowserBuddyApp {
    public static void main(String[] args) {
        BrowserBuddy browser = new BrowserBuddy();

        browser.visitPage("google.com");
        browser.visitPage("github.com");
        browser.visitPage("stackoverflow.com");

        browser.back();
        browser.back();
        browser.forward();

        browser.closeTab();

        browser.restoreTab();
        browser.back();
    }
}
