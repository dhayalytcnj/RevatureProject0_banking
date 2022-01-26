
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


    def login(username:String, password:String): Unit = {
        //ask user to enter username and password
            //if pair doesn't exist, return not such account with username and password
    }

    def create(fname:String, lname:String): Unit = {
        // ask to enter new user and pass
            //if username already exists, ask user to try again
        // ask user to enter first name and last name
            //if first name ann last name together already exist, tell user account already exists
        // create new account
    }

    def balance(acctID:Int): Unit = {
        //Find account with acctID
        //display name, checking amount, savings amount
    }

    def deposit(acctID:Int, chk_or_sav:Boolean, quantity:Float): Unit = {
        //Find account with acctID
        //ask if to deposit into checking or savings with chk_or_sav
        //deposit amount using round(quantity, 2)
    }

    def withdraw(acctID:Int, chk_or_sav:Boolean, quantity:Float): Unit = {
        //Find account with acctID
        //ask if withdraw from checking or savings with chk_or_sav
        //withdraw amount using round(quantity, 2)
            // if withdrawal more than current balance, deny it.
    }

    def transfer(acctID:Int, chk_or_sav:Boolean, quantity:Float): Unit = {
        //Find account with acctID
        //ask if to transfer from checking to savings or vice versa (use boolean chk_or_sav)
        //withdraw amount using round(quantity, 2) from 1 position
            // if withdrawal more than current balance, deny it.
        //deposit into other
    }


    def delete(acctID:Int): Unit = {
        //Find account with acctID
        //ask if user is sure to delete account (boolean yes or no)
            //if yes, delete account and exit
    }


    def login(): Int = {
        //user inputs username and password
        //sql query to search for username password
        val username = readLine("\nEnter username: ");
        val password = readLine("\nEnter password: ");
        try {
            val st:Statement = connection.createStatement();
            val sql1 = s"SELECT count(*) as quantity FROM Accounts WHERE username = '$username' and password = '$password'";
            val rs = st.executeQuery(sql1);
            val quantity = rs.getString("quantity").toInt;
            return quantity
        }
        catch
        {
            case e: Exception => e.printStackTrace();
                return -1;
        }

    }


    def signup(): Unit = {
        //user inputs for username, password, first name, last name.
        //insert into accounts table the new username and password
        //insert into customers table the new id, first name, password

        val username = readLine("\nEnter username (20 characters limit): ");
        val password = readLine("\nEnter password (20 characters limit): ");
        val fname = readLine("\nEnter your first name: ");
        val lname = readLine("\nEnter your last name: ");

        try {
            val st:Statement = connection.createStatement();
            val sql1 = s"INSERT INTO Accounts(username,password) VALUES($username, $password)";
            val sql2 = s"INSERT INTO Customers(acctID, fname, lname) " +
              s"VALUES( (SELECT acctID from Accounts WHERE username = '$username'), $fname, $lname)";
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
        }
        catch
        {
            case e => e.printStackTrace;
        }
    }


    // command-line interface and all tasks
    def main(args:Array[String]): Unit = {
        var checking:Float = 0;
        var savings:Float = 0;
        var acctID:Int = 0;
        var username:String = "";
        var password:String = "";

        println("---------------------------------------------\n" +
          "--- Welcome to Yash's Banking Application ---\n" +
          "---------------------------------------------");
        var login_val:Int = 0;
        var loop_control = false;
        while (loop_control == false) {
            println("\n- Select an option:\n" + "1. Login\n" + "2. Sign Up");
            print("Option: ");
            var first_option = readInt();

            if (first_option == 1) {
                //login process.
                    //If -1, then some error occurred. Redo
                    //If 0, username password combo doesn't exist. Redo
                    //If 1, login accepted. break loop.
                login_val = login();
                if (login_val == -1) {
                    println("Error. Please try again")
                }
                else if (login_val == 0) {
                    println("Account with that username password combination doesn't exist. Try again")
                }
                else if (login_val == 1) {
                    println("Login accepted.")
                    loop_control = true;
                }
            }
            else if (first_option == 2) {
                //sign up, then redo loop to login
                signup();
            }
            else {
                //non-accepted input, redo loop.
                println("Invalid input. Try again.")
            }
        }


        try {
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT username,password FROM accounts")
            while ( resultSet.next() ) {
                val host = resultSet.getString("username")
                val user = resultSet.getString("password")
                println("\nusername, password = " + host + ", " + user)
            }
        }  catch {
            case e => e.printStackTrace
        }
        connection.close()
    }
}
