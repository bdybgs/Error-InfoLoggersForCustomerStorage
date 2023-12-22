import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        String[] components = data.split("\\s+");
        String regexForMail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regexForPhoneNumber = "^\\+7[0-9]{10}$";

        if (components.length != 4)
            throw new ArrayIndexOutOfBoundsException("неверный формат ввода");
        if (!Pattern.matches(regexForPhoneNumber, components[3]))
            throw new IllegalArgumentException("неправильно введен номер телефона");
        if (!Pattern.matches(regexForMail, components[2]))
            throw new IllegalArgumentException("неправильно введена почта");
            String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}