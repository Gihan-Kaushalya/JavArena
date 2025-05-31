import java.util.Scanner;

class Billprint {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        
        System.out.println("=================================================================================");
        System.out.println("__          __   _                             _          _ __  __");
        System.out.println("\\ \\        / /  | |                           | |        (_)  \\/  |          _ ");
        System.out.println(" \\ \\  /\\  / / __| | ___ ___  _,__,___   ___   | |_ ___    _| \\  / | __,_ _,_| |_");
        System.out.println("  \\ \\/  \\/ /  _ \\ |/ __/ _ \\|  _   _ \\ / _ \\  | __/ _ \\  | | |\\/| |/ _  | __| __|");
        System.out.println("   \\  /\\  /   __/ | (_ |(_) | | | | | |  __/  | || (_) | | | |  | | (_| | | | |_ ");
        System.out.println("    \\/  \\/  \\___|_|\\___\\___/|_| |_| |_|\\___|   \\__\\___/  |_|_|  |_|\\__,_|_|  \\__|");
        System.out.println("\n=================================================================================\n");

        
        System.out.print("Enter Customer Phone Number - ");
        String phoneNumber = input.nextLine();
        System.out.println('\n');
        System.out.print("Enter Customer Name         - ");
        String name = input.nextLine();
        System.out.println('\n');
        System.out.println("\n=================================================================================");

        
        double priceBasmathi = 250.0;
        double priceDhal = 180.0;
        double priceSugar = 150.0;
        double priceHighland = 1200.0;
        double priceYoghurt = 50.0;
        double priceFlour = 120.0;
        double priceSoap = 160.0;

        
        System.out.print("Basmathi Qty (Kg) - ");
        int qtyBasmathi = input.nextInt();
        System.out.println('\n');
        System.out.print("Dhal Qty (Kg)     - ");
        int qtyDhal = input.nextInt();
        System.out.println('\n');
        System.out.print("Sugar Qty (Kg)    - ");
        int qtySugar = input.nextInt();
        System.out.println('\n');
        System.out.print("Highland Qty      - ");
        int qtyHighland = input.nextInt();
        System.out.println('\n');
        System.out.print("Yoghurt Qty       - ");
        int qtyYoghurt = input.nextInt();
        System.out.println('\n');
        System.out.print("Flour Qty (Kg)    - ");
        int qtyFlour = input.nextInt();
        System.out.println('\n');
        System.out.print("Soap Qty          - ");
        int qtySoap = input.nextInt();

        // Calculate totals for each item
        double totalBasmathi = qtyBasmathi * priceBasmathi;
        double totalDhal = qtyDhal * priceDhal;
        double totalSugar = qtySugar * priceSugar;
        double totalHighland = qtyHighland * priceHighland;
        double totalYoghurt = qtyYoghurt * priceYoghurt;
        double totalFlour = qtyFlour * priceFlour;
        double totalSoap = qtySoap * priceSoap;

        
        double totalBill = totalBasmathi + totalDhal + totalSugar + totalHighland + totalYoghurt + totalFlour + totalSoap;

        
        double discount = totalBill * 0.10;
        double finalPrice = totalBill - discount;

        
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                _    __  __          _____ _______             |");
        System.out.println("|               (_)  |  \\/  |   /\\   |  __ \\__   __|            |");
        System.out.println("|                _   | \\  / |  /  \\  | |__) | | |               |");
        System.out.println("|               | |  | |\\/| | / /\\ \\ |  _  /  | |               |");
        System.out.println("|               | |  | |  | |/ ____ \\| | \\ \\  | |               |");
        System.out.println("|               |_|  |_|  |_/_/    \\_\\_|  \\_\\ |_|               |");
        System.out.println("|                     225,Galle Road,Panadura.                  |");
        System.out.println("|                                                               |");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                         # Tel : " + phoneNumber + "                             |");
        System.out.println("|                        # Name : " + name + "                             |");
        System.out.println("+-----------------+-------------+---------------+---------------+");
        System.out.println("|                 |             |               |               |");
        System.out.println("|                 |    Qty      |  unitprice    |  Price        |");// Print itemized bill
        System.out.println("|-----------------+-------------+---------------+---------------+");
        System.out.printf("| # Basmathi      |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtyBasmathi, +priceBasmathi, +totalBasmathi);
        System.out.printf("| # Dhal          |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtyDhal, +priceDhal, +totalDhal);
        System.out.printf("| # Sugar         |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtySugar, +priceSugar, +totalSugar);
        System.out.printf("| # Highland      |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtyHighland, +priceHighland, +totalHighland);
        System.out.printf("| # Yoghurt       |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtyYoghurt, +priceYoghurt, +totalYoghurt);
        System.out.printf("| # Flour         |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtyFlour, +priceFlour, +totalFlour);
        System.out.printf("| # Soap          |    %-5d    | %-10.2f    | %-10.2f    |\n", +qtySoap, +priceSoap, +totalSoap);

       
        System.out.println("+-----------------+-------------+---------------+---------------+");
        System.out.printf("|                               |  Total        | %-10.2f    |\n", +totalBill);
        System.out.println("                                +---------------+---------------+");
        System.out.printf("|                               |  discount(10%%)| %-10.2f    |\n", +discount);
        System.out.println("                                +---------------+---------------+");
        System.out.printf("|                               |  Price        | %-10.2f    |\n", +finalPrice);
        System.out.println("+-----------------+-------------+---------------+---------------+");
        
        
        System.out.print('\n');
        System.out.print("Enter customer given amount :");
        double amount;
        amount = input.nextDouble();
        double change;
        change= amount - finalPrice;
        
		System.out.println("+-----------------+-----------------+");
        System.out.printf("|     Net Amount  |      %-10.2f |", +finalPrice);
        System.out.print('\n');
        System.out.println("+-----------------+-----------------+");
        System.out.printf("|     Cash        |      %-10.2f |\n", +amount);
        System.out.println("+-----------------+-----------------+");
        System.out.printf("|     Change      |      %-10.2f |\n",+change);
        System.out.println("+-----------------+-----------------+");
        
        System.out.println('\n');
        System.out.print("+-----------------+-----------------+\n");
        System.out.print("|    Value        |       No        |\n");
        System.out.print("+-----------------+-----------------+\n");
        
        int r5000;
        r5000=(int)change/5000;
        change=change%5000;
        System.out.printf("|    RS.5000      | %7d         |\n", +r5000);
        System.out.println("+-----------------+-----------------+");
        
        int r2000;
        r2000=(int)change/2000;
        change=change%2000;
        System.out.printf("|    RS.2000      | %7d         |\n", +r2000);
        System.out.println("+-----------------+-----------------+");
        
        int r1000;
        r1000=(int)change/1000;
        change=change%1000;
        System.out.printf("|    RS.1000      | %7d         |\n", +r1000);
        System.out.println("+-----------------+-----------------+");
        
        int r500;
        r500=(int)change/500;
        change=change%500;
        System.out.printf("|    RS.500       | %7d         |\n",  +r500);
        System.out.println("+-----------------+-----------------+");
        
        int r100;
        r100=(int)change/100;
        change=change%100;
        System.out.printf("|    RS.100       | %7d         |\n", +r100);
        System.out.println("+-----------------+-----------------+");
        
        int r50;
        r50=(int)change/50;
        change=change%50;
        System.out.printf("|    RS.50        | %7d         |\n", +r500);
        System.out.println("+-----------------+-----------------+");
        
        int r20;
        r20=(int)change/20;
        change=change%20;
        System.out.printf("|    RS.20        | %7d         |\n", +r20);
        System.out.println("+-----------------+-----------------+");
        
        int r10;
        r10=(int)change/10;
        change=change%10;
        System.out.printf("|    RS.10        | %7d         |\n", +r10);
        System.out.println("+-----------------+-----------------+");
        
        int r5;
        r5=(int)change/5;
        change=change%5;
        System.out.printf("|    RS.5         | %7d         |\n", +r5);
        System.out.println("+-----------------+-----------------+");
        
        int r2;
        r2=(int)change/2;
        change=change%2;
        System.out.printf("|    RS.2         | %7d         |\n", +r2);
        System.out.println("+-----------------+-----------------+");
        
        int r1;
        r1=(int)change/1;
        change=change%1;
        System.out.printf("|    RS1          | %7d         |\n", +r1);
        System.out.println("+-----------------+-----------------+");
        
        int notes;
        notes=(r5000+r2000+r1000+r500+r100+r50+r20+r10);
        System.out.printf("|    No of Notes  | %7d         |\n", +notes);
        System.out.println("+-----------------+-----------------+");
        
        int coins;
        coins=(r5+r2+r1);
        System.out.printf("|    No of Coins  | %7d         |\n", +coins);
        System.out.println("+-----------------+-----------------+");
        System.out.println("-------------------------------------");
        System.out.println("    THANK U FOR SHOPPING WITH US");
        System.out.println("-------------------------------------");
        
        
        
        
        

        
	}
	
}
