package CustomerManagement;

import java.util.Comparator;

public class ComparatorCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2){
        return o1.getNameCustomer().compareTo(o2.getNameCustomer());
    }
}
