import java.sql.*;

public class BankDAO {

    // CREATE
    public void addUser(Bank s) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO bank_system(name,email,pwd,acc_no,bal_amt,ph_no) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.name);
            ps.setString(2, s.email);
            ps.setString(3, s.pwd);
            ps.setInt(4, s.acc_no);
            ps.setDouble(5, s.bal_amt);
            ps.setLong(6, s.phone_no);

            ps.executeUpdate();

            System.out.println("User Added Successfully");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding User.");
        }
    }

    // READ
    public void viewUsers() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM bank_system";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getString("name") + " | "
                        + rs.getString("email") + "|"
                        + rs.getString("pwd") + "|"
                        + rs.getInt("acc_no") + "|"
                        + rs.getDouble("bal_amt") + "|"
                        + rs.getLong("ph_no")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while adding User.");
        }
    }

    // UPDATE
    public void updateUser(int acc_no, String email, String pwd, String ph_no) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE bank_system  SET email=? pwd=? ph_no=?  WHERE acc_no=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, pwd);
            ps.setString(3, ph_no);
            ps.setInt(4, acc_no);

            ps.executeUpdate();

            System.out.println("User Updated");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding User.");
        }
    }

    // DELETE
    public void deleteUser(int acc_no) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM bank_system WHERE acc_no=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, acc_no);

            ps.executeUpdate();

            System.out.println("User Deleted");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding User.");
        }
    }

    // Update Email
    public void updateEmail(int acc_no, String email) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE bank_system SET email=? WHERE acc_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setInt(2, acc_no);
            ps.executeUpdate();
            System.out.println("✅ Email Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Password
    public void updatePassword(int acc_no, String pwd) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE bank_system SET pwd=? WHERE acc_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pwd);
            ps.setInt(2, acc_no);
            ps.executeUpdate();
            System.out.println("✅ Password Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Phone
    public void updatePhone(int acc_no, String phone) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE bank_system SET ph_no=? WHERE acc_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setInt(2, acc_no);
            ps.executeUpdate();
            System.out.println("✅ Phone Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  READ USER BY ACC NO
    public void getUserByAccNo(int acc_no) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM bank_system WHERE acc_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, acc_no);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getString("name") + " | "
                        + rs.getString("email") + " | "
                        + rs.getDouble("bal_amt")
                );
            } else {
                System.out.println("User not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 6️⃣ CREDIT AMOUNT
    public void creditAmount(int acc_no, double amount) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE bank_system SET bal_amt = bal_amt + ? WHERE acc_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, acc_no);

            ps.executeUpdate();

            System.out.println(" Amount Credited");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 7️⃣ DEBIT AMOUNT
    public void debitAmount(int acc_no, double amount) {
        try {
            Connection conn = DBConnection.getConnection();

            // Check balance first
            String checkSql = "SELECT bal_amt FROM bank_system WHERE acc_no=?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, acc_no);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("bal_amt");

                if (balance >= amount) {
                    String sql = "UPDATE bank_system SET bal_amt = bal_amt - ? WHERE acc_no=?";
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps.setDouble(1, amount);
                    ps.setInt(2, acc_no);

                    ps.executeUpdate();

                    System.out.println(" Amount Debited");
                } else {
                    System.out.println(" Insufficient Balance");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}