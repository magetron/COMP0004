import java.util.ArrayList;
import java.util.Iterator;

public class DataManager implements SimpleOrderSystemModel
{
  private ArrayList<Customer> customers;
  private ArrayList<Product> products;

  public DataManager()
  {
    customers = new ArrayList<Customer>();
    products = new ArrayList<Product>();
  }

  public Customer addCustomer(String firstName, String lastName,
                          String address, String phone, String mobilePhone, String email)
  {
    Customer customer = new Customer(firstName, lastName,address, phone, mobilePhone, email);
    customers.add(customer);
    return customer;
  }

  public Customer getCustomer(String firstName, String lastName)
  {
    for (Customer customer : customers)
    {
      if (customer.getFirstName().equals(firstName)
          && customer.getLastName().equals(lastName))
      {
        return customer;
      }
    }
    return null;
  }

  public void deleteCustomer(String firstName, String lastName)
  {
    for (Customer customer : customers)
    {
      if (customer.getFirstName().equals(firstName)
              && customer.getLastName().equals(lastName))
      {
        customers.remove(customer);
        return;
      }
    }
  }

  public Iterator<Customer> getCustomerIterator()
  {
    return customers.iterator();
  }

  public Product getProduct(int code)
  {
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return product;
      }
    }
    return null;
  }

  public void addProduct(int code, String description, int price)
  {
    Product product = new Product(code,description,price);
    products.add(product);
  }

  public boolean isAvailableProductCode(int code)
  {
    if (code < 1)
    {
      return false;
    }
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return false;
      }
    }
    return true;
  }

  public int overallTotal()
  {
    int total = 0;
    for (Customer customer : customers)
    {
      total += customer.getTotalForAllOrders();
    }
    return total;
  }

}
