import java.util.Scanner;

public class GasPump {
    private Double regularGasPrice = 1.89;
    private Double premiumGasPrice = 1.97;
    private Double supremeGasPrice = 2.06;
    private Scanner user = new Scanner(System.in);
    private String paymentType;

    public void go(){
        selectPaymentType();
    }

    private void selectPaymentType(){
        System.out.println("Welcome to Gas-Mart! Please choose a payment option:\n1) Cash\n2) Card\n3) Cancel");
        while(true){
            String choice = user.nextLine();
            if (choice.equals("1")){
                System.out.println("You've chosen to pay with cash.");
                paymentType = "cash";
                break;
            }else if (choice.equals("2")){
                System.out.println("You've chosen to pay with a card.");
                paymentType = "card";
                break;
            }else if (choice.equals("3")){
                System.out.println("Goodbye! Hope to see you again soon.");
                System.exit(0);
            }System.out.println("Please enter a valid input.");
        }
    }
}
