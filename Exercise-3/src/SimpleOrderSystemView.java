public interface SimpleOrderSystemView
{
  void reportInvalidCustomer(int id);
  int getProductCode();
  void reportInvalidProductCode(int productCode);
  int getProductQuantity();
  boolean isNextLineItem();
  void run();

  void addOrderEntryController(OrderEntryController orderEntryController);
}
