public class Bank {

    int acc_no;
    String name;
    String email;
    String pwd;
    double bal_amt;
    long phone_no;

    public Bank(String name, String email, String pwd, long ph_no, double bal_amt, int acc_no) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.phone_no = ph_no; 
        this.bal_amt = bal_amt;  
        this.acc_no = acc_no;
    }
}