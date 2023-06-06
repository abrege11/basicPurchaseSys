/*
Abe Brege
LabA
2/9/23
*/
package widgetPackage;
import java.util.Scanner;
import java.text.NumberFormat;

public class PurchaseSystem {

    
    public static void main(String[] args) {
        System.out.println("Welcome to the Widget Order Processing System."); //greeting message
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); //setting up currency instances

        String customerName; //variable declarations
        String purchasedProduct;
        String productCode;
        String productDescription;
        double pricePerWidget = 0;
        double discountRate = 0;
        double orderSubtotal;
        double discountAmount;
        final double taxRate = .06;
        double preTaxTotal;
        double taxAmount;
        double finalTotal;
        int orderNumber = 0;
        String nextOrder = "y";
        boolean validWidget = false;
        boolean validQuantity = false;
        double productQuantity = 0;
        
        while(!nextOrder.equalsIgnoreCase("n")){
            
            Scanner sc; //setting up scanner
            sc = new Scanner(System.in);
            String input;
        
            System.out.print("Enter your name: "); //getting customers name
            input = sc.nextLine();
            customerName = input;
        
     
        
            do{
                System.out.print("Enter what product you wish to purchase: "); //getting the product the customer wants to purchase
                input = sc.nextLine();
                purchasedProduct = input.toUpperCase();//making the pruchasedProduct variable the input from the user
                
                
                switch (purchasedProduct) {//switch statment that is switching the case depending on what the user has entered and then assigning the appropriate variables. 

                case "W01":
                    productCode = "W01"; //setting product code variable
                    productDescription = "Small Widget"; //setting description variable
                    pricePerWidget = .75; //setting price per widget
                    orderNumber ++; //adding one to the order number
                    validWidget = true;//stopping the loop
                    break;
         
                case "W02":     
                    productCode = "W02";
                    productDescription = "Medium Widget";
                    pricePerWidget = 1.25; 
                    orderNumber ++;
                    validWidget = true;
                    break;
                
                case "W03":
                    productCode = "W03";
                    productDescription = "Large Widget";
                    pricePerWidget = 1.50; 
                    orderNumber ++;
                    validWidget = true;
                    break;
                
                case "W04":
                    productCode = "W04";
                    productDescription = "Extra Large Widget";
                    pricePerWidget = 2.25;
                    orderNumber ++;
                    validWidget = true;
                    break;
                default: 
                validWidget = false; //continuing the loop since there was no valid product code
                System.out.println("\nIt looks like you entered an invalid product code\nPlease enter one of the following codes: W01, W02, W03, or W04\n" );
                //^^ prompting the user to enter in the right input
                break;
                }
            }while(!validWidget);//keeping them in a loop until they enter a valid product code
            
            
            
            
            do{
                System.out.print("Enter the quantity you wish to purchase: "); //getting the product the customer wants to purchase
                input = sc.nextLine();
                productQuantity = Double.parseDouble(input); //string to double conversion to account for values less than 1 (decimals)

                //below is the if statement outlining the discount rates
                if(productQuantity >= 1 && productQuantity <= 1000){//checking to see if the product is even in the scope to begin with
                    if(productQuantity >= 900){//this and many more assigning discount rates to different number amounts between 1-1000
                        discountRate = .2;
                        validQuantity = true;
                    } else if(productQuantity <900 && productQuantity >700){
                        discountRate = .1;
                        validQuantity = true;
                    } else {
                        discountRate = 0;
                        validQuantity = true;
                    }
                } else {
                    validQuantity = false;//running back through the loop if incorrect quantity
                    System.out.println("Please enter a quantity between 1 and 1000.");//instructions on how to enter correct quantity
                }
            }while(!validQuantity);//back through loop

            
            orderSubtotal = productQuantity * pricePerWidget; //getting the subtotal of the order
            discountAmount = orderSubtotal * discountRate; //getting the discount amount of the order
            preTaxTotal = orderSubtotal - discountAmount;//getting the final total before tax
            taxAmount = preTaxTotal * taxRate;//getting the total of the tax
            finalTotal = preTaxTotal + taxAmount;//getting the final amount after the discount and tax
        
            //printing order summary
            System.out.println("");
            System.out.println("ORDER SUMMARY");
            System.out.println("Order Number: " + orderNumber);
            System.out.println("Customer Name: " + customerName);
            System.out.println("Product Code: " + purchasedProduct);
            System.out.println("Quantity: " + productQuantity);
            System.out.println("");
            System.out.println("Subtotal: " + currencyFormat.format(orderSubtotal));
            System.out.println("Discount: " + currencyFormat.format(discountAmount));
            System.out.println("Subtotal (after discount): " + currencyFormat.format(preTaxTotal));
            System.out.println("Tax: " + currencyFormat.format(taxAmount));
            System.out.println("Order Total: " + currencyFormat.format(finalTotal));
            System.out.println("");
        
            System.out.print("Would you like to proceed with an additional order? (y/n): ");//seeing if they want another order
            input = sc.nextLine();
            nextOrder = input;//if they say y, they will restart, if they say n, the code ends
        

        }
        
        
    }
    
}
