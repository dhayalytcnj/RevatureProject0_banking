
import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement
import scala.io.StdIn._

object MainApp {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/proj0"
    val username = "root"
    val password = "dhayal"

    Class.forName(driver)
    var connection:Connection = DriverManager.getConnection(url, username, password)

    //use for submenu
    var hold_id:Int = 0;
    var hold_fname:String = "";
    var hold_lname:String = "";

    //--------------------------------------------

    def submenu(id:Int): Unit = {
        // menu for logged in user to perform operations
        println("---------------------------------------------")
        println(s"\nWelcome, $hold_fname $hold_lname")

        var menu_option:Int = 0;
        while (menu_option != 5) {
            var bal = balance(hold_id);
            val checking = bal._1;
            val savings = bal._2;
            println(f"\nChecking: $$$checking%.2f")
            println(f"Savings: $$$savings%.2f")
            println("\n- Select an option:\n" + "1. Deposit\n" + "2. Withdraw\n" +
              "3. Transfer\n" + "4. Delete Account\n" + "5. Exit");

            print("\nOption: ")
            menu_option = readInt();

            menu_option match {
                case 1 => deposit(id);
                case 2 => withdraw(id);
                case 3 => transfer(id);
                case 4 => delete(id);
                case 5 => println("Goodbye!\n");
                case _ => println("please enter valid input\n");
            }
        }
    }

    //--------------------------------------------

    def balance(acctID:Int): (Double, Double) = {
        //get balance of account by acctID
        //output checking and savings balance as a tuple for submenu to use
        val st:Statement = connection.createStatement();
        val sql1 = s"SELECT checking, savings FROM Customers WHERE acctID = '$acctID'";
        val rs1 = st.executeQuery(sql1);
        rs1.next();
        val checking:Double = rs1.getString("checking").toDouble;
        val savings:Double = rs1.getString("savings").toDouble;
        return (checking, savings);
    }

    //--------------------------------------------

    def deposit(acctID:Int): Unit = {
        //Find account with acctID
        //input deposit amount
            //if deposit < 0, try again. Redo deposit loop
        //Input if to deposit into checking or savings

        println("\nHow much do you wish to deposit (minimum of $0):");
        var cash:Double = -1
        while(cash < 0){
            print("Quantity: ");
            cash = readDouble();
            if (cash < 0) {
                println("Invalid deposit quantity. Try again")
            }
        }

        val st:Statement = connection.createStatement();

        var option:Int = 0;
        while (option != 1 && option != 2){
            println("Which account to deposit to:\n1.Checking\n2.Savings")
            print("Option: ")
            option = readInt();
            if (option == 1) {
                val sql1 = s"UPDATE Customers SET checking = checking + $cash WHERE acctID = $acctID";
                st.executeUpdate(sql1);
            }
            else if (option == 2) {
                val sql1 = s"UPDATE Customers SET savings = savings + $cash WHERE acctID = $acctID";
                st.executeUpdate(sql1);
            }
            else {
                println("Invalid option. Please try again.\n");
            }
        }
    }

    //--------------------------------------------

    def withdraw(acctID:Int): Unit = {
        //Find account with acctID
        //ask if withdraw from checking or savings
        //input withdraw amount
            //if withdrawal < 0 or withdrawal > current balance of chosen account, deny it. redo loop

        var option:Int = 0;
        var choice:String = null;
        var choice_balance:Double = 0;
        while (option != 1 && option != 2) {
            println("\nWhich account to withdraw from:\n1.Checking\n2.Savings")
            print("Option: ")
            option = readInt();
            if (option == 1) {
                choice = "checking";
                choice_balance = balance(acctID)._1;
            }
            else if (option == 2) {
                choice = "savings";
                choice_balance = balance(acctID)._2;
            }
            else {
                println("Invalid option. Please try again.\n");
            }
        }

        println("\nHow much do you wish to withdraw (minimum of $0):");
        var cash:Double = -1
        while(cash < 0 || cash > choice_balance){
            print("Quantity: ");
            cash = readDouble();
            if (cash < 0) {
                println("Cannot withdraw less than 0. Try again.")
            }
            else if (cash > choice_balance) {
                println(s"Cannot withdraw more than $$$choice_balance")
            }
        }
        val st:Statement = connection.createStatement();
        val sql1 = s"UPDATE Customers SET $choice = $choice - $cash WHERE acctID = $acctID";
        st.executeUpdate(sql1);
    }

    //--------------------------------------------

    def transfer(acctID:Int): Unit = {
        //Find account with acctID
        //ask if to transfer from checking to savings or vice versa
        //withdraw amount using round(quantity, 2) from 1 position
            // if withdrawal for transfer more than current balance, deny it.
        //deposit into other

        var option:Int = 0;
        var choice:String = null;
        var opposite:String = null;
        var choice_balance:Double = 0;
        while (option != 1 && option != 2) {
            println("\nWhich transfer method:\n1.Checking to Savings \n2.Savings to Checking")
            print("\nOption: ")
            option = readInt();
            if (option == 1) {
                choice = "checking";
                opposite = "savings";
                choice_balance = balance(acctID)._1;
            }
            else if (option == 2) {
                choice = "savings";
                opposite = "checking";
                choice_balance = balance(acctID)._2;
            }
            else {
                println("Invalid option. Please try again.\n");
            }
        }

        var cash:Double = -1
        while(cash < 0 || cash > choice_balance){
            println("\nHow much do you wish to transfer (minimum of $0):");
            print("Quantity: ");
            cash = readDouble();
            if (cash < 0) {
                println("\nCannot transfer less than 0. Try again.")
            }
            else if (cash > choice_balance) {
                println(s"Cannot transfer more than balance in $choice account ($$$choice_balance). Try Again\n")
            }
        }
        val st:Statement = connection.createStatement();
        val sql1 = s"UPDATE Customers SET $choice = $choice - $cash WHERE acctID = $acctID";
        val sql2 = s"UPDATE Customers SET $opposite = $opposite + $cash WHERE acctID = $acctID";
        st.executeUpdate(sql1);
        st.executeUpdate(sql2);
    }

    //--------------------------------------------

    def delete(acctID:Int): Unit = {
        //Find account with acctID
        //ask if user is sure to delete account (boolean yes or no)
            //if yes, delete account and exit app
            //if no or any other input, return to menu.
        println("Are you sure you want to delete account?")
        println("1. Yes \n2. No")
        print("Option: ")
        var option = readInt();
        if (option == 1) {
            val st: Statement = connection.createStatement();
            val sql1 = s"DELETE FROM Customers WHERE acctID = '$acctID'";
            val sql2 = s"DELETE FROM Accounts WHERE acctID = '$acctID'";
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            println("\nAccount deleted. Goodbye")

            //once account is deleted, close connection and exit program.
            connection.close();
            System.exit(0);

        }
        else if (option == 2) {
            println("Deletion refused. Returning to menu.\n")
        }
        else {
            println("Invalid option, returning to menu.\n")
        }
    }

    //--------------------------------------------

    def login(): Int = {
        //user inputs username and password
        //sql query to search for username password by count aggregation
        val username = readLine("\nEnter username: ");
        val password = readLine("Enter password: ");
        try {
            val st:Statement = connection.createStatement();
            val sql1 = s"SELECT count(*) as quantity FROM Accounts WHERE username = '$username' and password = '$password'";
            val sql2 = s"SELECT Accounts.acctID as acctID, Customers.fname as fname, Customers.lname as lname from Accounts, Customers " +
              s"WHERE username = '$username' and Accounts.acctID = Customers.acctID"; //need this for hold_user
            val rs1 = st.executeQuery(sql1);
            rs1.next();
            var quantity:Int = rs1.getString("quantity").toInt;
            if (quantity == 1){
                val rs2 = st.executeQuery(sql2);
                rs2.next()
                hold_id = rs2.getString("acctID").toInt; // will use this for submenu if login succeeds
                hold_fname = rs2.getString("fname");
                hold_lname = rs2.getString("lname");
            }
            return quantity;
        }
        catch
        {
            case e: Exception => e.printStackTrace();
                return -1;
        }
    }

    //--------------------------------------------

    def signup(): Unit = {
        //user inputs for username, password, first name, last name.
        //insert into accounts table the new username and password
        //insert into customers table the new id, first name, password

        try {
            val st:Statement = connection.createStatement();

            //check if username already exists
            var username:String = null;
            var loop_control = false;
            while (loop_control == false) {
                username = readLine("\nEnter username (20 characters limit): ");
                val sql1 = s"SELECT count(*) as quantity FROM Accounts WHERE username = '$username'";
                val rs = st.executeQuery(sql1);
                rs.next();
                var quantity = rs.getString("quantity").toInt;
                if (quantity != 0) {
                    println("Account with that username already exists. Please choose another username.\n")
                }
                else{ //username is fine to use
                    loop_control = true;
                }
            }
            val password = readLine("Enter password (20 characters limit): ");
            val fname = readLine("Enter your first name: ");
            val lname = readLine("Enter your last name: ");

            val sql2 = s"INSERT INTO Accounts(username,password) VALUES('$username', '$password')";
            val sql3 = s"INSERT INTO Customers(acctID, fname, lname) " +
              s"VALUES( (SELECT acctID from Accounts WHERE username = '$username'), '$fname', '$lname')";
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
        }
        catch
        {
            case e => e.printStackTrace;
        }
    }

    //--------------------------------------------

    // command-line interface and all tasks
    def main(args:Array[String]): Unit = {
        println("---------------------------------------------\n" +
          "--- Welcome to Yash's Banking Application ---\n" +
          "---------------------------------------------");
        var loop_control = false;
        while (loop_control == false) { //login or signup loop
            println("\n- Select an option:\n" + "1. Login\n" + "2. Sign Up");
            print("Option: ");
            var first_option = readLine();
            if (first_option == "1") {
                //login process.
                    //If login result is -1, then some error occurred. Redo
                    //If login result is 0, username password combo doesn't exist. Redo
                    //If login result is 1, login accepted. break loop.
                val login_val = login();
                if (login_val == -1) {
                    println("Error. Please try again")
                }
                else if (login_val == 0) {
                    println("Account with that username password combination doesn't exist. Try again")
                }
                else if (login_val == 1) {
                    println("Login accepted.\n")
                    loop_control = true;
                }
            }

            else if (first_option == "2") {
                //sign up, then redo loop to login
                signup();
            }

            else {
                //non-accepted input, redo loop.
                println("Invalid input. Try again.")
            }
        }

        //go to logged in user's menu
        submenu(hold_id);

        //once done in submenu, close connection and exit
        connection.close()
        System.exit(0);
    }
}
