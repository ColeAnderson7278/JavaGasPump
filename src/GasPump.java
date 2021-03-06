import java.util.HashMap;
import java.util.Scanner;

public class GasPump {
    private HashMap<String, Double> fuelTypes = new HashMap<>();
    private Scanner user = new Scanner(System.in);
    private String paymentType;
    private String fuelType;
    private Double totalPrice;
    private Double totalGallons;

    public void go() {
        establishFuelTypes();
        selectPaymentType();
        selectFuelType();
        if (paymentType.equals("cash")) {
            getAmountCash();
        } else if (paymentType.equals("card")) {
            getAmountGallons();
        }
        askForReceipt();
    }

    private void establishFuelTypes() {
        fuelTypes.put("regular", 1.89);
        fuelTypes.put("premium", 1.97);
        fuelTypes.put("supreme", 2.06);
    }

    private void selectPaymentType() {
        System.out.println("Welcome to Gas-Mart! Please choose a payment option:\n1) Cash\n2) Card\n3) Cancel");
        while (true) {
            String choice = user.nextLine();
            if (choice.equals("1")) {
                System.out.println("You've chosen to pay with cash.");
                paymentType = "cash";
                break;
            } else if (choice.equals("2")) {
                System.out.println("You've chosen to pay with a card.");
                paymentType = "card";
                break;
            } else if (choice.equals("3")) {
                System.out.println("Goodbye! Hope to see you again soon.");
                System.exit(0);
            }
            System.out.println("Please enter a valid input.");
        }
    }

    private void selectFuelType() {
        System.out.println("Gas Prices:\n--------------------\nRegular - $" + fuelTypes.get("regular") + "\nPremium - $" + fuelTypes.get("premium") + "\nSupreme - $" + fuelTypes.get("supreme") + "\n--------------------");
        System.out.println("Please select a fuel type:\n1) Regular 2) Premium 3) Supreme");
        while (true) {
            String choice = user.nextLine();
            if (choice.equals("1")) {
                System.out.println("You've chosen the regular fuel type.");
                fuelType = "regular";
                break;
            } else if (choice.equals("2")) {
                System.out.println("You've chosen the premium fuel type.");
                fuelType = "premium";
                break;
            } else if (choice.equals("3")) {
                System.out.println("You've chosen the premium fuel type.");
                fuelType = "supreme";
                break;
            }
            System.out.println("Please enter a valid input.");
        }
    }

    private void getAmountCash() {
        System.out.println("How much money are you spending?");
        Double cash = user.nextDouble();
        totalPrice = Math.round(cash * 100d) / 100d;
        convertToGallons(cash, fuelType);
        System.out.println("You've paid $" + cash + " for " + totalGallons + " gallons of gas.");
    }

    private void convertToGallons(Double cash, String fuelType) {
        try{
            totalGallons = Math.round((cash / fuelTypes.get(fuelType)) * 100d) / 100d;
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void getAmountGallons(){
        System.out.println("How many gallons would you like?");
        Double gallons = user.nextDouble();
        totalGallons = Math.round(gallons * 100d) / 100d;
        convertToCash(gallons, fuelType);
        System.out.println("You've bought " + gallons + " of gas for $" + totalPrice + ".");
    }

    private void convertToCash(Double gallons, String fuelType){
        if (fuelType.equals("regular")) {
            totalPrice = Math.round((gallons * fuelTypes.get("regular")) * 100d) / 100d;
        } else if (fuelType.equals("premium")) {
            totalPrice = Math.round((gallons * fuelTypes.get("premium")) * 100d) / 100d;
        } else{
            totalPrice = Math.round((gallons * fuelTypes.get("supreme")) * 100d) / 100d;
        }
    }

    private void askForReceipt(){
        System.out.println("Would you like your receipt?\n1) Yes 2) No");
        while (true){
            String choice = user.nextLine();
            if (choice.equals("1")){
                Receipt userReceipt = new Receipt(fuelType, totalGallons, totalPrice);
                System.out.println(userReceipt.toString());
                break;
            }else if(choice.equals("2")){
                System.out.println("Thank your for your purchase and please come back again.");
                break;
            }System.out.println("Please enter a valid input.");
        }
    }
}
