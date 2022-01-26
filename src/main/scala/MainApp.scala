
import java.sql.DriverManager
import java.sql.Connection

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


    // command-line interface and all tasks
    def main(args:Array[String]): Unit = {
        var checking:Float = 0;
        var savings:Float = 0;
        var acctID:Int = 0;
        var username:String = "";
        var password:String = "";


        println("---------------------------------------------\n" +
          "--- Welcome to Yash's Banking Application ---\n" +
          "---------------------------------------------")
        println("- Select an option:\n" + "1. Login\n" + "2. Sign Up")





        try {
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT username,password FROM accounts")
            while ( resultSet.next() ) {
                val host = resultSet.getString("username")
                val user = resultSet.getString("password")
                println("username, password = " + host + ", " + user)
            }
        }  catch {
            case e => e.printStackTrace
        }
        connection.close()
    }
}
