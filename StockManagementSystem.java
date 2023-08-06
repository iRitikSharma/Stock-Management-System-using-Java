import java.util.Scanner;
import java.util.ArrayList;



    class Stock
    {
        private String name;
        private int quantity;
        private double price;

        public Stock(String name, int quantity ,double price)
        {
            this.name=name;
            this.quantity=quantity;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void removeQuantity(int QuantityTORemove)
        {
            if(QuantityTORemove <= quantity)
            {
                quantity = QuantityTORemove;
            } else
            {
                System.out.println("Not enough quantity to remove");
            }
        }
        public String toString(){
            return name + ", Quantity : " + quantity + " , price : Rs" + price;
        }
    }

public class StockManagementSystem
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Create an empty arraylist to hold stocks
        ArrayList<Stock> stocks = new ArrayList<>();

        //display the menu and ask for user input
        int choice;
        do {
            System.out.println("1. Add Stock");
            System.out.println("2. Remove Stock");
            System.out.println("3. View Stock");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice :");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1 :
                    //ask for stock details
                    System.out.println("Enter the stock name : ");
                    String name = sc.next();
                    System.out.println("Enter the stock quantity : ");
                    int quantity = sc.nextInt();
                    System.out.println("Enter the sock price : ");
                    double price = sc.nextDouble();

                    //Create new stock object and add it to arraylist
                    Stock newStock = new Stock(name, quantity, price);
                    stocks.add(newStock);

                    System.out.println("Stock added successfully");
                    break;


                case 2 :
                    //ask for stock name and quantity to remove
                    System.out.println("Enter the stock name : ");
                    String stockName = sc.next();
                    System.out.println("Enter the quantity to remove :");
                    int removeQuantity = sc.nextInt();

                    //loop through the stock to find the matching stock
                    boolean stockFound = false;
                    for (Stock stock : stocks)
                    {
                        if (stock.getName().equals(stockName)){
                            //if stock is found remove the specified quantity
                            stockFound = true;
                            stock.removeQuantity(removeQuantity);
                            System.out.println("Stock removed successfully" );
                            break;
                        }
                    }
                    if(!stockFound)
                    {
                        System.out.println("Stock not found");
                    }
                    break;

                case 3 :
                    //display the list of stocks
                    System.out.println("Current Stocks : ");
                    for(Stock stock : stocks)
                    {
                        System.out.println(stocks.toString());
                    }
                    break;


                case 4 :
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid Choice, Try Again ");
                    break;
            }
        }while(choice !=4);
        {
            sc.close();
        }





}
}
