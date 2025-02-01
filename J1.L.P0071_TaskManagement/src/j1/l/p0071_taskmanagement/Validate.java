package j1.l.p0071_taskmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Validate the input
 *
 * @version 10.00pm 25 Jan 2025
 * @author VQPC
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);
    private static final String DATE_VALID = "\\d{1,2}[-]\\d{1,2}[-]\\d{4}";

    /**
     * check the String input
     *
     * @return String not empty
     */
    public static String checkString() {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return s;
            }
        }
    }

    /**
     * check if input is integer
     *
     * @return integer number
     */
    public static int checkInteger() {
        while (true) {
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Must enter an integer number!");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check the limit of the input
     *
     * @param min min value
     * @param max max value
     * @return number in range
     */
    public static int checkInputLimit(int min, int max) {
        while (true) {
            int x = checkInteger();
            if (x >= min && x <= max) {
                return x;
            }
            System.err.println("Input must be in range [" + min + ", " + max + "]");
            System.out.print("Enter again: ");
        }
    }

    /**
     * check if input is double
     *
     * @return integer number
     */
    public static double checkDouble() {
        while (true) {
            try {
                double x = Double.parseDouble(sc.nextLine().trim());
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Must enter an integer number!");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check valid date (I clearly have no idea wtf am I doing right now)
     *
     * @return valid date
     */
    public static String checkDate() {
        Date now = new Date();
        
        while (true) {
            try {
                String result = checkString();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Date must before today");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
                System.out.print("Enter again: ");
            } catch (ParseException ex) {
                System.err.println("Input must be DD-MM-YYYY!");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check valid plan
     *
     * @return valid plan
     */
    public static double checkPlan() {
        while (true) {
            String x = checkString();
            if (x.matches("^(\\d+\\.([5]|[0]))$")) {
                double result = Double.parseDouble(x);
                if (result >= 8 && result <= 17.5) {
                    return result;
                } else {
                    System.err.println("Plan must be in range [8.0, 17.5]");
                    System.out.print("Enter again: ");
                }
            } else {
                System.err.println("Plan must be x.0 or x.5");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check plan to
     *
     * @param from plan from
     * @return plan to
     */
    public static double checkPlanTo(double from) {
        while (true) {
            double result = checkPlan();
            if (from < result) {
                return result;
            } else {
                System.err.println("Plan to must after plan from!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int taskType() {
        while (true) {
            int x = checkInteger();
            if (x >= 1 && x <= 4) {
                return x;
            }
            System.err.println("Input must be in range 1-4 (1. Code, 2. Test, 3.Design, 4.Review)");
            System.out.print("Enter again: ");
        }
    }
}
