//Description: The Queue class is an implementation of a customer management system for a loan office.
//              It contains a menu that performs various actions depending on the users' input. The program allows
//              the user to add a new customer, assign a customer to an officer, release a customer, and list the 
//              queues of customers waiting to be assigned a loan officer.

import java.io.*;

public class Queue
{
    // main method
    public static void main (String[] args) throws IOException
    {
        // declare variables
        char input1;
        String line = new String();

        // call the printMenu method
        printMenu();

        // create objects to read user input
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);
        boolean setUpOfficers = false;
        CustomerManagement management1 = null;

        // the following part is to get a valid number of available loan officers from a user
        // in order to instantiate an object of CustomerManagement class
        do
        {
            // prompts the user to input number of loan officers
            System.out.print("Please specify how many loan officer will be available: ");
            try
            {
                // reads user input
                int numOfficers = Integer.parseInt(stdin.readLine().trim());

                // conditional statement that checks if user input is a positive integer
                if (numOfficers > 0 )
                {
                    // create a patient management object
                    management1 = new CustomerManagement(numOfficers);
                    setUpOfficers = true;
                }
                // returns if input is not a positive integer
                else
                {
                    System.out.print("\nPlease enter a positive integer");
                }
            }
            // returns if input is not a valid number
            catch(NumberFormatException ex)
            {
                System.out.print("\nPlease enter a valid number");
            }
        } while (setUpOfficers == false);

        do  // will ask for user input
        {
            System.out.print("\nWhat action would you like to perform:");
            line = stdin.readLine();
            input1 = line.charAt(0);
            input1 = Character.toUpperCase(input1);

            // converts user input to a single character
            if (line.length() == 1)
            {
                // matches one of the case statements
                switch (input1)
                {
                    case 'A':   // add a Customer
                        try
                        {   
                            // prompts user to input customer ID
                            System.out.print("\nPlease enter the cusomter ID to add: ");
                            int id = Integer.parseInt(stdin.readLine().trim());

                            // prompts user to specify category of the customer
                            System.out.print("\nPlease specify the category of the customer: ");
                            String category1 = stdin.readLine().trim();

                            // adds customer to cms and checks if addition was successful
                            boolean added = management1.addCustomer(id, category1);
                            if (added)
                            {
                                // returns if customer was added successfully
                                System.out.print("\nThe customer with id: " + id + " and category: " + category1
                                        + " is added\n");
                            }
                            else
                            {
                                // returns if customer was not added successfully
                                System.out.print("\nThe customer with id: " + id + " and category: " + category1
                                        + " is NOT added\n");
                            }

                        }
                        // returns if input is not a valid number
                        catch(NumberFormatException ex)
                        {
                            System.out.print("\nPlease enter a valid number");
                        }
                        break;
                    case 'C':   // check Out a Customer
                        Customer customer1 = management1.checkoutCustomer();

                        // conditional statement that checks if customer was checked out or not
                        if (customer1 == null)
                        {
                            System.out.print("\nNo customer was checked out"+"\n");
                        }
                        else
                        {
                            System.out.print("\nCustomer " + customer1.toString() + " was checked out\n");
                        }
                        break;

                    case 'L':   // list queues
                        management1.printQueues();
                        break;

                    case 'Q':   // quit
                        break;

                    case 'R':  // release Customer From the relevant loan officer
                        try
                        {
                            // prompts for user input
                            System.out.print("\nWhich loan officer is releasing a customer? Enter officer ID: ");
                            int officerID = Integer.parseInt(stdin.readLine().trim());

                            Customer releasedCustomer = management1.releaseCustomerFromOfficer(officerID);

                            // conditional statement that determines if a customer was checked out
                            if (releasedCustomer == null)
                            {
                                System.out.print("\nNo customer was released"+ "\n");
                            }
                            else
                            {
                                System.out.print("\nCustomer " + releasedCustomer.toString() + " was serviced and checked out\n");
                            }
                        }
                        // returns if user input is not a valid number
                        catch(NumberFormatException ex)
                        {
                            System.out.print("\nPlease enter a valid number");
                        }
                        break;

                    case 'S':   // assign a Customer to a loan officer
                        Customer customer2 = management1.assignCustomerToLoanOfficer();

                        // conditional statement that determines if a customer was assigned to a loan officer
                        if (customer2 == null)
                        {
                            System.out.print("\nNo customer was assigned to the loan officer" + "\n");
                        }
                        else
                        {
                            System.out.print("\nCustomer " + customer2.toString() + " was assigned to a loan officer" + "\n");
                        }
                        break;

                    case '?':   // display Menu
                        printMenu();
                        break;

                    default:    // returns if user does not input a defined character
                        System.out.print("\nUnknown action");
                        break;
                }
            }
            // returns if user inputs an unknown action
            else
            {
                System.out.print("\nUnknown action");
            }
            // end of do-while loop that runs until user inputs 'Q' to quit the program
        } while (input1 != 'Q' || line.length() != 1);
    }

    /** The method printMenu displays the menu to a user**/
    public static void printMenu()
    {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Customer\n" +
                "C\t\tCheck Out Customer\n" +
                "L\t\tList Customer Queues\n" +
                "Q\t\tQuit\n" +
                "R\t\tRelease Customer From Loan Officer\n" +
                "S\t\tAssign Customer To Loan Officer\n" +
                "?\t\tDisplay Help\n\n");
    }
}