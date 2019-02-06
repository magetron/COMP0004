import java.util.Iterator;

public interface SimpleOrderSystemModel
{
  Customer addCustomer(String firstName, String lastName,
                   String address, String phone, String mobilePhone, String email);

  Customer getCustomer(String firstName, String lastName);

  void deleteCustomer(String firstName, String lastName);

  Iterator<Customer> getCustomerIterator();

  Product getProduct(int code);

  void addProduct(int code, String description, int price);

  boolean isAvailableProductCode(int code);
}
