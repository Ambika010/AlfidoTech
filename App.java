
// import java.beans.Statement;
import java.sql.*;
import java.util.Scanner;
// import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) {
        int choices = 0;
        while (choices != 9009) {
            System.out.println("Welcome to SMS (Student Management System)");
            System.out.println("Please Authenticate the System");
            System.out.println("Enter your choices: \n 1: Login \n 2: Signup \n 3: Exit \n");
            int menu = 0;
            Scanner sc = new Scanner(System.in);
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    boolean result = Login();
                    if (result) {
                        System.out.println("Login Success");
                    } else {
                        System.out.println("Wrong Credentials");
                    }
                    break;
                case 2:
                    SignUp();
                    break;
                case 3:
                    choices = 9009;
                    break;
            }

        }
    }

    static boolean Login() {
        boolean loginSuccess = false;
        String id1 = "", pass = "";
        String id = "", password = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your ID :");
        id = sc.nextLine();
        System.out.print("Enter Your Password :");
        password = sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "Akartik@121");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = ((java.sql.Statement) st).executeQuery("Select * from login");
            // if any error occur see this line just remove the do while with while loop and
            // initialise the id1="" and pass=""

            while (rs.next()) {
                id1 = rs.getString(1);
                pass = rs.getString(2);
            }

            if (id.equals(id1) && password.equals(pass)) {
                loginSuccess = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return loginSuccess;
    }

    // Sign up code snippet
    static void SignUp() {
        int loop = 0;
        int code = 0;
        String id = "", passWord = "", name = "";
        while (loop != 8008) {
            Scanner sc = new Scanner(System.in);
            System.out.println("SignUp : Two Step Authentication");
            code = sc.nextInt();
            if (code == 8008) {
                Scanner data = new Scanner(System.in);
                System.out.println("Enter ID :");
                id = data.nextLine();
                System.out.println("Enter Your Password");
                passWord = data.nextLine();
                System.out.println("Enter your name ");
                name = data.nextLine();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root",
                            "Akartik@121");
                    // for preparing the new entries
                    String query = "insert into signup (id,passWord,name)" + "values(?,?,?)";
                    String query1 = "insert into login (id,passWord)" + "values(?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps1 = con.prepareStatement(query1);
                    ps.setString(1, id);
                    ps.setString(2, passWord);
                    ps.setString(3, name);
                    ps1.setString(1, id);
                    ps1.setString(2, passWord);

                    int i = ps.executeUpdate();
                    ps1.executeUpdate();
                    if (i > 0) {
                        System.out.print("\n\nData is inserted....\n\n");
                    } else {
                        System.out.print("\n\nData is not inserted.....\n\n");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                System.out.println("Wrong Pin code.\n");
                return;
            }
        }

    }
}
