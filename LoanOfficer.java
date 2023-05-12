// Description: LoanOfficer class represents a bank loan officer
//              that accept/handle and release customers.

public class LoanOfficer
{
    // declare variables
    private int officerID;
    private Customer currentCustomer;

  // constructor to initialize member variables, initially no patient is assigned
  public LoanOfficer(int id)
  {
     this.officerID = id;
     this.currentCustomer = null;
  }

  // an accessor method to get the officer's ID
  public int getID()
  {
     return officerID;
  }

  // method to determine if a loanOfficer currently has a customer by
  // checking the currentCustomer variable
  public boolean hasCustomer()
  {
     if (currentCustomer != null)
     {
        return true;
     } 
     else 
     {
        return false;
     }
  }

  // assign customer1 to currentCustomer if the officer does not have customer
  public boolean assignCustomer(Customer customer1)
  {
     if (hasCustomer() != true)
     {
        this.currentCustomer = customer1;
        return true;
     } 
     else
     {
        return false;
     }
  }

  // simulates a loan officer handling a customer 
  // if officer is assigned a customer, method returns its current customer
  // later, returns null
  public Customer handleCustomer()
  {
    if (currentCustomer != null) 
    {
        Customer customer2 = currentCustomer;
        currentCustomer = null;
        return customer2;
    }
    else
    {
         return null;
    }
  }

  // toString method returns a string containing
  // the information of a loanOfficer
  public String toString()
  {
     String result = "\nOfficer ID: " + officerID;


     if (currentCustomer == null)
        result += " does not have any cutomers\n";
     else
        result += " is serving customer with id " + currentCustomer.getCustID() + "\n";


     return result;
  }
}
