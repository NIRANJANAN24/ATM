import java.util.Scanner;

class User {
    private String username;
    private double balance;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }
}



class Admin {


    private String adminUsername;
    private String password;

    public Admin(String adminUsername, String password) {
        this.adminUsername = adminUsername;
        this.password = password;
    }


    public boolean authenticate(String username, String password) {
        return this.adminUsername.equals(username) && this.password.equals(password);
    }

    public void addBalance(User user, double amount) {
        user.deposit(amount);
    }
}

class Banker {
    private String bankerUsername;
    private String password;

    public Banker(String bankerUsername, String password) {
        this.bankerUsername = bankerUsername;
        this.password = password;
    }



    public boolean authenticate(String username, String password) {
        return this.bankerUsername.equals(username) && this.password.equals(password);
    }

    public void withdrawBalance(User user, double amount) {
        user.withdraw(amount);
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("user123", 1000);
        Admin admin = new Admin("admin", "adminpass");
        Banker banker = new Banker("banker", "bankerpass");

        while (true) {
            System.out.println("1. User Login\n2. Admin Login\n3. Banker Login\n4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String userUsername = scanner.next();
                    System.out.println("Enter password:");
                    String userPassword = scanner.next();
                    if (true) {
                        System.out.println("Logged in as User");
                        System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Logout");
                        int userOption = scanner.nextInt();
                        switch (userOption) {
                            case 1:
                                System.out.println("Balance: " + user.getBalance());
                                break;
                            case 2:
                                System.out.println("Enter deposit amount:");
                                double depositAmount = scanner.nextDouble();
                                user.deposit(depositAmount);
                                break;
                            case 3:
                                System.out.println("Enter withdrawal amount:");
                                double withdrawAmount = scanner.nextDouble();
                                user.withdraw(withdrawAmount);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    System.out.println("Enter admin username:");
                    String adminUsername = scanner.next();
                    System.out.println("Enter admin password:");
                    String adminPassword = scanner.next();
                    if (admin.authenticate(adminUsername, adminPassword)) {
                        System.out.println("Logged in as Admin");
                        System.out.println("Enter username of the user to add balance:");
                        String userToAddBalance = scanner.next();
                        System.out.println("Enter amount to add:");
                        double amountToAdd = scanner.nextDouble();
                        admin.addBalance(user, amountToAdd);
                    } else {
                        System.out.println("Invalid admin username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Enter banker username:");
                    String bankerUsername = scanner.next();
                    System.out.println("Enter banker password:");
                    String bankerPassword = scanner.next();
                    if (banker.authenticate(bankerUsername, bankerPassword)) {
                        System.out.println("Logged in as Banker");
                        System.out.println("Enter username of the user to withdraw balance:");
                        String userToWithdrawBalance = scanner.next();
                        System.out.println("Enter amount to withdraw:");
                        double amountToWithdraw = scanner.nextDouble();
                        banker.withdrawBalance(user, amountToWithdraw);
                    } else {
                        System.out.println("Invalid banker username or password.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
