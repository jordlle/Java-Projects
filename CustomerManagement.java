// Description: This program manages customer queues, assigns customer to loan officer,
//              process and release them, etc.

import java.util.LinkedList;

public class CustomerManagement
{
    // delcare linked lists to hold customers for each category
    private LinkedList<Customer> LEQueue;
    private LinkedList<Customer> MEQueue;
    private LinkedList<Customer> SEQueue;

    // declare linked list to hold customers who have completed their loan process
    private LinkedList<Customer> checkoutQueue;

    // declare an array of loan officers
    private LoanOfficer[] officerList;

  // constructor that initializes the linked lists and the array
  public CustomerManagement(int numOfLoanOfficers)
  {
     LEQueue = new LinkedList<Customer>();
     MEQueue = new LinkedList<Customer>();
     SEQueue = new LinkedList<Customer>();
     checkoutQueue = new LinkedList<Customer>();

     // creates LoanOfficer objects
     officerList = new LoanOfficer[numOfLoanOfficers];

     // loop that instantiates loan officer objects and adds them to the officer list
     for (int i = 0; i < officerList.length; i++)
     {
        officerList[i] = new LoanOfficer(i);
     }
  }

  // add a customer to the corresponding queue based on its category
  // return true if added to a queue successfully; otherwise return false
  public boolean addCustomer(int id, String category)
  {
   // check if the category is valid
   if (!category.equals("LE") && !category.equals("ME") && !category.equals("SE"))
   {
      return false;
   }

    // adds customer to the appropriate queue based on their category
     if (category.equals("LE"))
     {
      Customer customer = new Customer(id, category);
      LEQueue.add(customer);
      return true;
     }
     else if (category.equals("ME"))
     {
      Customer customer = new Customer(id, category);
      MEQueue.add(customer);
      return true;
     }
     else if (category.equals("SE"))
     {
      Customer customer = new Customer(id, category);
      SEQueue.add(customer);
      return true;
     }
     else 
     {
        return false;
     }
   }

  // assign a customer to a loan officer with large enterprise (LE) queues
  // going first; return null if there are no customers in the queues or if
  // there are no loan officer are available
  public Customer assignCustomerToLoanOfficer()
  {
   // declare local variables
   int i;
   boolean available = false;

    // loop through the officer list to find the first available loan officer
     for (i = 0; i < officerList.length; i++) 
     {
      if(officerList[i].hasCustomer() == false) 
      {
         available = true;
         break;
      }
     }

   // conditional statement that determines availability by enterprise
   // assigns customer to an officer, then removes assigned customer from the enterprise linked list
     if ((!LEQueue.isEmpty()) && available == true) 
     {
         Customer customer = LEQueue.getFirst();
         officerList[i].assignCustomer(LEQueue.getFirst());
         LEQueue.remove(LEQueue.getFirst());
         return customer;
     }
     else if ((!MEQueue.isEmpty()) && available == true)
     {
         Customer customer = MEQueue.getFirst();
         officerList[i].assignCustomer(MEQueue.getFirst());
         MEQueue.remove(MEQueue.getFirst());
         return customer;
     }
     else if ((!SEQueue.isEmpty()) && available == true)
     {
         Customer customer = SEQueue.getFirst();
         officerList[i].assignCustomer(SEQueue.getFirst());
         SEQueue.remove(SEQueue.getFirst());
         return customer;
     }
     else 
     {
         return null;
     }
   }
  // check if officer with the officerID has a customer, and release
  // that customer if they do. Then add that customer to checkout queue
  // and return the Customer object; otherwise return null
Customer releaseCustomerFromOfficer(int officerID)
{

    // loop that finds if officer has a customer.
    // handles the customer and processes checkout if so;
    // returns null if no customer present
   for (int i = 0; i < officerList.length; i++)
   {
      if(officerList[i].getID() == officerID && officerList[i].hasCustomer())
      {
         Customer customer =  officerList[i].handleCustomer();
         checkoutQueue.add(customer);
         return customer;
      }
   }
   return null;
}

  // remove the first Customer from the checkoutQueue and return it;
  // otherwise the method return null.
  public Customer checkoutCustomer()
  {
     if (checkoutQueue.isEmpty())
     {
        return null;
     }
     else
     {
         Customer customer = checkoutQueue.getFirst();
         checkoutQueue.remove(0);
         return customer;
     }
  }

  // the printQueue prints out the content
  // of the queues and the array of loan officers
  public void printQueues()
  {
     System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
     System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
     System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
     for (int i = 0; i < officerList.length; i++)
     {
        System.out.print(officerList[i].toString());
     }
     System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
  }
}
