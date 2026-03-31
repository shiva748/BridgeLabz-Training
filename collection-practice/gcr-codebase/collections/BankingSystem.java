import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class WithdrawalRequest {
    int accountNumber;
    int amount;

    WithdrawalRequest(int accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> accounts = new HashMap<>();

        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

        System.out.print("Enter number of accounts: ");
        int accountCount = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter initial balance: ");
            int balance = sc.nextInt();

            accounts.put(accNo, balance);
        }

        System.out.print("\nEnter number of withdrawal requests: ");
        int requests = sc.nextInt();

        for (int i = 0; i < requests; i++) {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            withdrawalQueue.add(new WithdrawalRequest(accNo, amount));
        }

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();

            if (!accounts.containsKey(req.accountNumber)) {
                System.out.println("Invalid account: " + req.accountNumber);
                continue;
            }

            int currentBalance = accounts.get(req.accountNumber);

            if (currentBalance >= req.amount) {
                accounts.put(req.accountNumber, currentBalance - req.amount);
                System.out.println("Withdrawal successful for account " + req.accountNumber);
            } else {
                System.out.println("Insufficient balance for account " + req.accountNumber);
            }
        }

        TreeMap<Integer, Integer> sortedByBalance = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nCustomers Sorted by Balance:");
        for (Map.Entry<Integer, Integer> entry : sortedByBalance.entrySet()) {
            System.out.println("Balance: " + entry.getKey() + " -> Account: " + entry.getValue());
        }

        sc.close();
    }
}
