import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;
    public static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws Exception {

        logger.error("error message is written to error.log");
        logger.info("Info message is written in info.log ");
        logger.debug("error message is written to info.log");
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            if(tokens[0].equals("add")) {
                try {
                    executor.addCustomer(tokens[1]);
                } catch (Exception e) {
                    logger.error("Error while processing 'add' command", e);
                }
            }
            else if(tokens[0].equals("list")) {
                executor.listCustomers();
            }
            else if(tokens[0].equals("remove"))
            {
                executor.removeCustomer(tokens[1]);
            }
            else if(tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            }
            else if(tokens[0].equals("help")) {
                System.out.println(helpText);
            }
            else {
                System.out.println(commandError);
            }
        }
    }
}
