public class RestaurantSystem {
    public static void main(String[] args) throws InterruptedException {

        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}

class Chef extends Thread {
    private String chefName;
    private String dish;
    private int cookingTime;

    public Chef(String chefName, String dish, int cookingTime) {
        this.chefName = chefName;
        this.dish = dish;
        this.cookingTime = cookingTime;
    }

    @Override
    public void run() {
        System.out.println(chefName + " started preparing " + dish);

        int stepTime = cookingTime / 4;

        try {
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 25% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 50% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 75% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 100% complete");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(chefName + " completed " + dish);
    }
}
