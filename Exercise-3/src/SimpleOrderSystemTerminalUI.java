import java.util.ArrayList;
import java.util.Iterator;

public class SimpleOrderSystemTerminalUI implements SimpleOrderSystemView
{
  public static final int ADD_CUSTOMER = 1;
  public static final int ADD_ORDER = 2;
  public static final int ADD_PRODUCT = 3;
  public static final int LIST_CUSTOMERS = 4;
  public static final int DISPLAY_TOTAL_VALUE = 5;
  public static final int EDIT_CUSTOMER_DETAILS = 6;
  public static final int QUIT = 10;
  private Input in;
  private SimpleOrderSystemModel model;
  private OrderEntryController orderEntryController;


  public SimpleOrderSystemTerminalUI(Input in, SimpleOrderSystemModel model)
  {
    this.in = in;
    this.model = model;
  }

  public void addOrderEntryController(OrderEntryController orderEntryController)
  {
    this.orderEntryController = orderEntryController;
  }

  public void run()
  {
    while(true)
    {
      displayMenu();
      int option = getMenuInput();
      if (option == QUIT)
      {
        break;
      }
      doOption(option);
    }
  }

  private void displayMenu()
  {
    System.out.println("Simple Order System Menu");
    System.out.println(ADD_CUSTOMER + ". Add Customer");
    System.out.println(ADD_ORDER + ". Add Order");
    System.out.println(ADD_PRODUCT + ". Add Product");
    System.out.println(LIST_CUSTOMERS + ". List Customers");
    System.out.println(DISPLAY_TOTAL_VALUE + ". Display Total Value");
    System.out.println(EDIT_CUSTOMER_DETAILS + ". Edit Customer Details");
    System.out.println();
    System.out.println(QUIT + ". Quit");
  }
  
  private void doOption(int option)
  {
    switch (option)
    {
      case ADD_CUSTOMER:
        addCustomer();
        break;
      case ADD_ORDER:
        addOrder();
        break;
      case ADD_PRODUCT:
        addProduct();
        break;
      case LIST_CUSTOMERS:
        listCustomers();
        break;
      case DISPLAY_TOTAL_VALUE:
        displayTotalValue();
        break;
      case EDIT_CUSTOMER_DETAILS:
        editCustomerDetails();
        break;
      default:
        System.out.println("Invalid option - try again");
    }
  }

  private int getMenuInput()
  {
    System.out.print("Enter menu selection: ");
    int option = in.nextInt();
    in.nextLine();
    return option;
  }

  private void addCustomer()
  {
    System.out.println("Add new customer");
    System.out.println("Enter first name:");
    String firstName = in.nextLine();
    System.out.println("Enter last name:");
    String lastName = in.nextLine();
    System.out.println("Enter address:");
    String address = in.nextLine();
    System.out.println("Enter phone number:");
    String phone = in.nextLine();
    System.out.println("Enter mobile phone number:");
    String mobilePhone = in.nextLine();
    System.out.println("Enter email address:");
    String email = in.nextLine();
    model.addCustomer(firstName,lastName,address,phone,mobilePhone,email);
  }

  private void addOrder()
  {
    Customer customer = findCustomer();
    if (customer == null)
    {
      System.out.println("Unable to add order");
      return;
    }
    Order order = new Order();
    addLineItems(order);
    if (order.getLineItemCount() == 0)
    {
      System.out.println("Cannot have an empty order");
      return;
    }
    customer.addOrder(order);
  }

  private String getWithPrompt(String prompt)
  {
    System.out.print(prompt);
    return in.nextLine();
  }

  private void reportInvalidCustomer(int id)
  {
    System.out.println("Cannot find a customer with id " + id);
  }

  private Customer findCustomer()
  {
    Iterator<Customer> customers = model.getCustomerIterator();
    int customerId = 0;
    while (customers.hasNext()) {
      customerId++;
      Customer customer = customers.next();
      System.out.println(customerId + " : " + customer.getFirstName() + " " + customer.getLastName());
    }
    int customerIdMax = customerId;
    System.out.print("Enter customer ID: ");
    int id = in.nextInt();
    if (id > customerIdMax || id <= 0) reportInvalidCustomer(id);
    int getCustomerId = 0;
    Iterator<Customer> customers = model.getCustomerIterator();
    while (customers.hasNext()) {
      customerId++;
      Customer customer = customers.next();

    }
    return model.getCustomer(firstName, lastName);
  }

  private void addLineItems(Order order)
  {
    while (true)
    {
      System.out.print("Enter line item (y/n): ");
      String reply = in.nextLine();
      if (reply.startsWith("y"))
      {
        LineItem item = getLineItem();
        if (item != null)
        {
          order.add(item);
        }
      }
      else
      {
        break;
      }
    }
  }

  private LineItem getLineItem()
  {
    return orderEntryController.getLineItemFromView();
  }

  public boolean isNextLineItem()
  {
      System.out.print("Enter line item (y/n): ");
      String reply = in.nextLine();
      if (reply.startsWith("y"))
      {
        return true;
      }
      return false;
  }

  public int getProductCode()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();
    return code;
  }

  public void reportInvalidProductCode(int productCode)
  {
    System.out.println("Product code: " + productCode + " is invalid");
  }

  public int getProductQuantity()
  {
    System.out.print("Enter quantity: ");
    int quantity = in.nextInt();
    in.nextLine();
    return quantity;
  }

  private void addProduct()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();
    if (!model.isAvailableProductCode(code))
    {
      return;
    }
    System.out.print("Enter product description: ");
    String description = in.nextLine();
    System.out.print("Enter product price: ");
    int price = in.nextInt();
    in.nextLine();
    model.addProduct(code, description, price);
  }

  public void listCustomers()
  {
    System.out.println("List of customers");
    Iterator<Customer> customers = model.getCustomerIterator();
    while (customers.hasNext())
    {
      Customer customer = customers.next();
      System.out.println("Name: " + customer.getLastName()
                                  + ", "
                                  + customer.getFirstName());
      System.out.println("Address: " + customer.getAddress());
      System.out.println("Phone: " + customer.getPhone());
      System.out.println("Mobile Phone: " + customer.getMobilePhone());
      System.out.println("Email: " + customer.getEmail());
      System.out.println("Orders made: " + customer.getOrders().size());
      System.out.println("Total for all orders: " + customer.getTotalForAllOrders());
    }
  }

  public void displayTotalValue()
  {
    System.out.print("Total Value = ");
    Iterator<Customer> customers = model.getCustomerIterator();
    int totalValue = 0;
    while (customers.hasNext())
    {
      Customer customer = customers.next();
      totalValue += customer.getTotalForAllOrders();
    }
    System.out.println(totalValue);
  }

  public void editCustomerDetails()
  {
    Customer customerToDelete = findCustomer();
    ArrayList<Order> savedOrder = customerToDelete.getOrders();
    model.deleteCustomer(customerToDelete.getFirstName(), customerToDelete.getLastName());
    System.out.println("Re-Enter first name:");
    String firstName = in.nextLine();
    System.out.println("Re-Enter last name:");
    String lastName = in.nextLine();
    System.out.println("Re-Enter address:");
    String address = in.nextLine();
    System.out.println("Re-Enter phone number:");
    String phone = in.nextLine();
    System.out.println("Re-Enter mobile phone number:");
    String mobilePhone = in.nextLine();
    System.out.println("Re-Enter email address:");
    String email = in.nextLine();
    Customer customerToAdd = model.addCustomer(firstName, lastName, address, phone, mobilePhone, email);
    for (Order order : savedOrder) customerToAdd.addOrder(order);
  }
}
