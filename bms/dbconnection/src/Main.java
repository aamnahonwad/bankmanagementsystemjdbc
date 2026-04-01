import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankDAO dao = new BankDAO();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. View User by Acc No");
            System.out.println("4. Delete User");
            System.out.println("5. Update User");
            System.out.println("6. Credit Amount");
            System.out.println("7. Debit Amount");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pwd = sc.nextLine();

                    System.out.print("Enter Phone No: ");
                    long phone = sc.nextLong();

                    System.out.print("Enter Balance: ");
                    double bal = sc.nextDouble();

                    System.out.print("Enter Account No: ");
                    int acc = sc.nextInt();

                    Bank b = new Bank(name, email, pwd, phone, bal, acc);
                    dao.addUser(b);
                    break;

                case 2:
                    dao.viewUsers();
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    dao.getUserByAccNo(accNo);
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    int delAcc = sc.nextInt();
                    dao.deleteUser(delAcc);
                    break;

                case 5:
                    System.out.print("Enter Account No: ");
                    int upAcc = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n--- Update Menu ---");
                    System.out.println("1. Update Email");
                    System.out.println("2. Update Password");
                    System.out.println("3. Update Phone No");

                    System.out.print("Enter choice: ");
                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {

                        case 1:
                            System.out.print("Enter New Email: ");
                            String newEmail = sc.nextLine();
                            dao.updateEmail(upAcc, newEmail);
                            break;

                        case 2:
                            System.out.print("Enter New Password: ");
                            String newPwd = sc.nextLine();
                            dao.updatePassword(upAcc, newPwd);
                            break;

                        case 3:
                            System.out.print("Enter New Phone No: ");
                            String newPhone = sc.nextLine();
                            dao.updatePhone(upAcc, newPhone);
                            break;

                        default:
                            System.out.println("Invalid Choice");
                    }
                    break;


                case 6:
                    System.out.print("Enter Account No: ");
                    int cAcc = sc.nextInt();

                    System.out.print("Enter Amount to Credit: ");
                    double cAmt = sc.nextDouble();

                    dao.creditAmount(cAcc, cAmt);
                    break;

                case 7:
                    System.out.print("Enter Account No: ");
                    int dAcc = sc.nextInt();

                    System.out.print("Enter Amount to Debit: ");
                    double dAmt = sc.nextDouble();

                    dao.debitAmount(dAcc, dAmt);
                    break;

                case 8:
                    System.out.println("Program Ended");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}