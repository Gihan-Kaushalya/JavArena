import java.util.*;
class shop{
	
	private static String[] orderIdArray=new String[0];//private-encapsulation
	private static String[] phoneNumberArray=new String[0];
	private static String[] nameArray=new String[0];
	private static int[] qtyArray=new int[0];
	private static double[] totalValueArray=new double[0];
	private static int[] orderStatusArray=new int[0];
	
	private static final double BURGER_PRICE=500.00;
    private static final int PREPARING=0;
    private static final int DELIVERED=1;
    private static final int CANCEL=2;
    private static int orderCount=0;

    public static final void cls() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public static void main(String args[]){
		homepage();
	}

    public static void homepage(){
        Scanner input=new Scanner(System.in);

        System.out.println("----------------------------------------------------------------");
        System.out.println("|\t\t\tiHungry Burger                         |");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println(" [1] Place Order  \t\t  [2] Search Best Customer\n ");
        System.out.println(" [3] Search Order  \t\t  [4] Search Customer\n     ");
        System.out.println(" [5] View Order  \t\t  [6] Update Order Details\n  ");
        System.out.println(" [7] Exit");
        System.out.println();
        System.out.print("  Enter an option to continue >> ");
		int option=input.nextInt();

        switch(option){
            case 1:
				cls();
                placeOrder();
                break;
            case 2:
				cls();
                SearchBestCustomer();
                break;
            case 3:
				cls();
                SearchOrder();
                break;
            case 4:
				cls();
                SearchCustomer();
                break;
            case 5:
				cls();
                ViewOrder();
                break;
            case 6:
				cls();
                UpdateOrderDetails();
                break;
            case 7:
				cls();
				System.out.println();
				System.out.println("\t\tExisting the Application...Thank U.");
                System.exit(0);
                break;
            default:
				cls();
				System.out.println();
				System.out.println("\tWrong Selection...Input again.");
				System.out.println();
                homepage();
                break;
        }
    }
    
     public static String generateID(){
        if(orderIdArray.length > 0){
            int lastId = Integer.parseInt(orderIdArray[orderIdArray.length - 1].substring(1));
            return String.format("B%04d", lastId + 1);
        }else{
            return "B0001";
        }
    }
    
    public static boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("0[0-9]{9}");
    }
    
    public static boolean validityQty(int qty){
		if(qty>0){
			return true;
		}
		return false;
	}
	
	public static void extendsArrays(){
		String[] temporderIdArray=new String[orderIdArray.length+1];
		String[] tempphoneNumberArray=new String[phoneNumberArray.length+1];
		String[] tempnameArray=new String[nameArray.length+1];
		int[] tempqtyArray=new int[qtyArray.length+1];
		double[] temptotalValueArray=new double[totalValueArray.length+1];
		int[] tempOrderStatusArray = new int[orderStatusArray.length + 1];
		
		for (int i = 0; i < orderIdArray.length; i++)
		{
			temporderIdArray[i]=orderIdArray[i];
			tempphoneNumberArray[i]=phoneNumberArray[i];
			tempnameArray[i]=nameArray[i];
			tempqtyArray[i]=qtyArray[i];
			temptotalValueArray[i]=totalValueArray[i];
			tempOrderStatusArray[i] = orderStatusArray[i];
		}
		orderIdArray=temporderIdArray;
		phoneNumberArray=tempphoneNumberArray;
		nameArray=tempnameArray;
		qtyArray=tempqtyArray;
		totalValueArray=temptotalValueArray;
		orderStatusArray = tempOrderStatusArray;
	}
		
	public static void placeOrder(){
        Scanner input=new Scanner(System.in);
        
        L1:do{
        System.out.println("--------------------------------------------------------------");
        System.out.println("|\t\t\tPLACE ORDER                          |");
        System.out.println("--------------------------------------------------------------");
        System.out.println('\n');
        System.out.println('\n');
        String orderId=generateID();
        System.out.println(" ORDER ID - "+orderId);
        System.out.println(" ================");
        System.out.println('\n');
        System.out.println('\n');
        
        String phoneNumber; 
        L2:do {
               System.out.print(" Enter Customer ID (Phone no.)  : ");
               phoneNumber=input.next();
               boolean isValidPhoneNumber=validatePhoneNumber(phoneNumber);
               if(isValidPhoneNumber){
                    break L2;
               }else{
				    System.out.println("\n");
                    System.out.println(" Invalid Phone number...Try again.");
                    System.out.println("\n");
                    input.nextLine();

                    continue L2;
               }
            }while(true);
            input.nextLine();
            System.out.print(" Customer Name                  : ");
			String name=input.next();
			
			int qty;
			L3:do{
				System.out.print(" Enter Burger Quantity          : ");
				qty=input.nextInt();
				
				boolean isValidQty=validityQty(qty);
				if(isValidQty){
					break L3;
				}else{
					System.out.println("Invalid input..Enter again.");
					input.next();
					continue L3;
				}
			}while(true);
			
			double amount=0;
			amount=BURGER_PRICE*qty;
			System.out.print(" Total Value(Rs)                : "+amount);
			System.out.println("\n");
			System.out.print("\tAre you confirm the order? (Y/N) : ");
			char confirm = input.next().charAt(0);
			if (confirm == 'Y' || confirm == 'y') {
				System.out.println("\n");
				
				extendsArrays();
				orderIdArray[orderIdArray.length - 1]=orderId;
				phoneNumberArray[phoneNumberArray.length - 1]=phoneNumber;
				nameArray[nameArray.length - 1]=name;
				qtyArray[qtyArray.length - 1]=qty;
				totalValueArray[totalValueArray.length - 1]=amount;
				
            System.out.println("\tYour order is enter to the system successfully!");
            System.out.println("\n");
            System.out.println("\n");
            System.out.print(" Do you want to place another order? (Y/N): ");
            char placeAnother=input.next().charAt(0);
            if(placeAnother == 'Y' || placeAnother == 'y') {
			cls();	
                placeOrder(); // Recursive call to place another order
            }else{
				cls();
                homepage();
            }
			}else{
				cls();
				System.out.println('\n');
				System.out.println(" \tOrder cancelled !!");
				System.out.println('\n');
				homepage();
        }
    }while(true);
}

    public static void SearchBestCustomer(){
		Scanner input = new Scanner(System.in);

    // Step 1: Gather unique customers
    int n=phoneNumberArray.length;
    String[] uniquePhones=new String[n];
    String[] uniqueNames=new String[n];
    double[] uniqueTotals=new double[n];
    int uniqueCount=0;

    for (int i = 0; i < n; i++){
        String phone=phoneNumberArray[i];
        String name=nameArray[i];
        double total=totalValueArray[i];

        int index= -1;
        for (int j = 0; j < uniqueCount; j++){
            if(uniquePhones[j]==phone){
                index=j;
                break;
            }
        }
        if(index==-1){
            // New customer
            uniquePhones[uniqueCount]=phone;
            uniqueNames[uniqueCount]=name;
            uniqueTotals[uniqueCount]=total;
            uniqueCount++;
        }else{
            // Existing customer: add to total
            uniqueTotals[index]+=total;
        }
    }

   
    for (int i = 0; i < uniqueCount - 1; i++) {
        for (int j = 0; j < uniqueCount-i-1; j++) {
            if (uniqueTotals[j] < uniqueTotals[j + 1]){
                
                double tempTotal=uniqueTotals[j];
                uniqueTotals[j]=uniqueTotals[j + 1];
                uniqueTotals[j + 1]=tempTotal;
                
                String tempPhone=uniquePhones[j];
                uniquePhones[j]=uniquePhones[j + 1];
                uniquePhones[j + 1]=tempPhone;
                
                String tempName=uniqueNames[j];
                uniqueNames[j]=uniqueNames[j + 1];
                uniqueNames[j + 1]=tempName;
            }
        }
    }
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("|\t\t\tBest Customer                        |");
		System.out.println("--------------------------------------------------------------");
		System.out.printf("|\t\t%-15s %-10s %-10s","CustomerID","Name","Total\t     |");
		System.out.println();
		System.out.println("--------------------------------------------------------------");

		for (int i = 0; i < uniqueCount; i++){
			System.out.printf("\t\t%-15s %-10s %-10.2f\n", uniquePhones[i], uniqueNames[i], uniqueTotals[i]);
		    System.out.println("--------------------------------------------------------------");
		    }
		    
		System.out.println('\n');
		System.out.println('\n');
		
		System.out.print("\tDo you want to go back to main menu? (Y/N) >> ");
		char ch = input.next().charAt(0);
		if(ch == 'Y' || ch == 'y'){
			cls();
			homepage();
		}else {
			cls();
			SearchBestCustomer();
		}
	}

	 public static void SearchOrder(){
        Scanner input=new Scanner(System.in);
        
        System.out.println("-----------------------------------------------------------------------------");
		System.out.println("|\t\t\t     SEARCH ORDER DETAILS                           |");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println();
		System.out.print(" Enter order ID - ");
		String orderId = input.next().trim();
		System.out.println();

        boolean found=false;
		System.out.println("------------------------------------------------------------------------------");
		System.out.printf("|  %-10s  %-12s %-10s %-10s %-12s %-10s\n","OrderID","CustomerID","  Name","Quantity","OrderValue","OrderStatus   |");
		System.out.println("------------------------------------------------------------------------------");

		for (int i = 0; i < orderIdArray.length; i++){

			if (orderIdArray[i].equalsIgnoreCase(orderId)){
				System.out.printf("|  %-10s  %-12s   %-10s %-10d %-12.2f %-10s  |\n",
                    orderIdArray[i],
                    phoneNumberArray[i],
                    nameArray[i],
                    qtyArray[i],
                    totalValueArray[i],
                    orderStatusArray[i]==PREPARING ? "Preparing" :
                    orderStatusArray[i]==DELIVERED ? "Delivered" : "Cancelled");
                    System.out.println("------------------------------------------------------------------------------");

            found=true;
            break; 
        }
    }

        if (!found){
			System.out.println('\n');
            System.out.println(" \tSorry..Order ID not found.");
        }
		
        System.out.println();
        System.out.print(" \tDo you want to search another order details (Y/N): ");
        char choice = input.next().charAt(0);
        if (choice == 'Y' || choice == 'y') {
			cls();
            SearchOrder();
        } else {
            cls();
            homepage();
        }
    }
	
	public static void SearchCustomer(){
    Scanner input=new Scanner(System.in);
    
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|\t\t\t     SEARCH CUSTOMER DETAILS                           |");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
    
		String phoneNumber; 
		L4:while(true){
			System.out.print(" Enter Customer ID (Phone no.)  - ");
			phoneNumber=input.next().trim();
			System.out.println('\n');
			boolean isValidPhoneNumber=validatePhoneNumber(phoneNumber);
        
        if(!isValidPhoneNumber){
            System.out.println("\n");
            System.out.println(" \tInvalid Phone number...Try again.");
            System.out.println("\n");
            input.nextLine();
            continue L4;
        }
        
        boolean customerfound=false;
        String customername="";
        
        for (int i = 0; i < phoneNumberArray.length; i++) {
            if(phoneNumberArray[i].equals(phoneNumber)) {
                customerfound = true;
                customername = nameArray[i];
                break;
            }
        }
        
        if(!customerfound){
            System.out.println('\n');
            System.out.println(" \tThis Customer ID is not added yet..");
            System.out.println('\n');
            System.out.print(" \tDo you want to search another customer details (Y/N) ? ");
            char choice = input.next().charAt(0);
            
            if(choice == 'Y' || choice == 'y') {
                cls();
                continue L4;
            } else {
                cls();
                homepage();
            }
        }
        System.out.println('\n');
        System.out.println(" Customer ID - " + phoneNumber);
        System.out.println(" Name        - " + customername);
        System.out.println("\n");
        System.out.println(" Customer Details ");
        System.out.println(" ================ ");
        System.out.println('\n');
        System.out.println("---------------------------------------------");
        System.out.printf("|  %-10s %-15s %15s\n","Order_ID","Order_Quantity","Total_Value  |");
        System.out.println("---------------------------------------------");

         boolean hasOrders = false;
            for(int i = 0; i < phoneNumberArray.length; i++) {
                if(phoneNumberArray[i].equals(phoneNumber)) {
                    System.out.printf("    %-10s   %-15d  %-15.2f\n", 
                                    orderIdArray[i], 
                                    qtyArray[i], 
                                    totalValueArray[i]);
                    hasOrders=true;
                }
            }System.out.println("---------------------------------------------");


            
            if(!hasOrders){
                System.out.println(" No orders found for this customer.");
            }
            System.out.println('\n');
            System.out.print(" \tDo you want to search another customer details (Y/N) ? ");
            char choice = input.next().charAt(0);
            
            if(choice == 'Y' || choice == 'y') {
                cls();
                continue L4;
            } else {
                cls();
                homepage();
            }

        break; 
    }
}

    public static void ViewOrder(){
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
        System.out.println("|\t\t\tVIEW ORDER LIST                      |");
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println("[1] Delivered Order\n");
        System.out.println("[2] Preparing Order\n");
        System.out.println("[3] Cancel Order\n");
        System.out.println();
        System.out.print("\tEnter an option to continue >> ");
        int suboption = input.nextInt();
        
        cls();
        
        switch(suboption){
            case 1: 
                System.out.println("----------------------------------------------------------------");
                System.out.println("|\t\t\tDELIVERED ORDER                        |");
                System.out.println("----------------------------------------------------------------");
                System.out.println('\n');
                System.out.println("----------------------------------------------------------------");
				System.out.printf("|  %-8s   %-12s   %-10s %-8s   %-12s\n", "OrderID", "CustomerID", "Name", "Quantity", "OrderValue  |");
                System.out.println("----------------------------------------------------------------");
                
                for (int i = 0; i < orderIdArray.length; i++){
                    if (orderStatusArray[i]==DELIVERED){
						System.out.printf("   %-8s   %-12s    %-10s   %-8d %-12.2f\n",
							orderIdArray[i],
                            phoneNumberArray[i],
                            nameArray[i],
                            qtyArray[i],
                            totalValueArray[i]);
                    }System.out.println("----------------------------------------------------------------");
                }

                break;
                
                case 2:
					System.out.println("----------------------------------------------------------------");
					System.out.println("|\t\t\tPREPARING ORDER                        |");
					System.out.println("----------------------------------------------------------------");
					System.out.println('\n');
					System.out.println("----------------------------------------------------------------");
					System.out.printf("|  %-8s   %-12s   %-10s %-8s   %-12s\n", "OrderID", "CustomerID", "Name", "Quantity", "OrderValue  |");
					System.out.println("----------------------------------------------------------------");
					
					for (int i = 0; i < orderIdArray.length; i++)
					{
						if(orderStatusArray[i]==PREPARING){
							System.out.printf("   %-8s   %-12s    %-10s   %-8d %-12.2f\n",
							orderIdArray[i],
							phoneNumberArray[i],
							nameArray[i],
							qtyArray[i],
							totalValueArray[i]
							);
						}System.out.println("----------------------------------------------------------------");
							
					}break;
					
					case 3:
						System.out.println("----------------------------------------------------------------");
						System.out.println("|\t\t\tCANCEL ORDER                           |");
						System.out.println("----------------------------------------------------------------");
						System.out.println('\n');
						System.out.println("----------------------------------------------------------------");
						System.out.printf("|  %-8s   %-12s   %-10s %-8s   %-12s\n", "OrderID", "CustomerID", "Name", "Quantity", "OrderValue  |");
						System.out.println("----------------------------------------------------------------");
						
						for (int i = 0; i < orderIdArray.length; i++)
						{
							if(orderStatusArray[i]==CANCEL){
								System.out.printf("   %-8s   %-12s    %-10s   %-8d %-12.2f\n",
								orderIdArray[i],
								phoneNumberArray[i],
								nameArray[i],
								qtyArray[i],
								totalValueArray[i]
								);
							}System.out.println("----------------------------------------------------------------");


						}break;
						
						default:
							
							System.out.println('\n');
							cls();
							System.out.println(" \tInvalid Option..! Try again.");
						
					}

			System.out.println('\n');
            System.out.print(" \tDo you want to go to home page (Y/N) ? ");
            char choice = input.next().charAt(0);
            
            if(choice == 'Y' || choice == 'y') {
                cls();
                homepage();;
            } else {
                cls();
                ViewOrder();
            }
			
		}
		
		
	 public static void UpdateOrderDetails(){
        Scanner input = new Scanner(System.in);
        
         L1:while(true){
            cls();
            System.out.println("--------------------------------------------------------------");
            System.out.println("|\t\t\tUPDATE ORDER DETAILS                 |");
            System.out.println("--------------------------------------------------------------");
            System.out.println();
            System.out.print(" Enter order Id - ");
            String orderId=input.next();
            
            int index= -1;
            for(int i = 0; i < orderIdArray.length; i++) {
                if (orderIdArray[i].equalsIgnoreCase(orderId)){
                    index= i;
                    break;
                }
            }
            
            if(index== -1){
                System.out.println("\nOrder ID not found.");
            } else {
                int currentStatus = orderStatusArray[index];
                
                
                if (currentStatus == DELIVERED) {
                    System.out.println("\nThis Order is already delivered...You can not update this order...");
                } else if (currentStatus == CANCEL) {
                    System.out.println("\nThis Order is already cancelled...You can not update this order...");
                } else {
                    
                    System.out.println("\nCurrent Order Details:");
                    System.out.println("OrderID    - " + orderIdArray[index]);
                    System.out.println("CustomerID - " + phoneNumberArray[index]);
                    System.out.println("Name       - " + nameArray[index]);
                    System.out.println("Quantity   - " + qtyArray[index]);
                    System.out.println("OrderValue - " + totalValueArray[index]);
                    System.out.println("OrderStatus- " + 
                        (orderStatusArray[index] == PREPARING ? "Preparing" :
                         orderStatusArray[index] == DELIVERED ? "Delivered" : "Cancelled"));
                    
                    System.out.println("\nWhat do you want to update?");
                    System.out.println("[1] Quantity");
                    System.out.println("[2] Status");
                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
                    
                    if (choice == 1) {
                        
                        cls();
                        System.out.println("Quantity Update");
                        System.out.println("==========================");
                        System.out.println("OrderID    - " + orderIdArray[index]);
                        System.out.println("CustomerID - " + phoneNumberArray[index]);
                        System.out.println("Name       - " + nameArray[index]);
                        System.out.print("\nEnter your quantity update value - ");
                        int newQty = input.nextInt();
                        
                        if (newQty > 0) {
                            qtyArray[index] = newQty;
                            totalValueArray[index] = newQty * BURGER_PRICE;
                            System.out.println("\nupdate order quantity success fully...");
                            System.out.println("new order quantity - " + newQty);
                            System.out.println("new order value - " + String.format("%.2f", totalValueArray[index]));
                        } else {
                            System.out.println("Invalid quantity. Update failed.");
                        }
                    } else if (choice == 2) {
                        
                        System.out.println("\nStatus Update");
                        System.out.println("==========================");
                        System.out.println("OrderID    - " + orderIdArray[index]);
                        System.out.println("CustomerID - " + phoneNumberArray[index]);
                        System.out.println("Name       - " + nameArray[index]);
                        System.out.println("    (8)Cancel");
                        System.out.println("    (1)Preparing");
                        System.out.println("    (2)Delivered");
                        System.out.print("\nEnter new order status - ");
                        int newStatus = input.nextInt();
                        
                        if (newStatus == 8) {
                            orderStatusArray[index] = CANCEL;
                            System.out.println('\n');
                            System.out.println(" \tUpdate order status successfully...");
                            System.out.println(" \tnew order status - Cancelled");
                        } else if (newStatus == 1) {
                            orderStatusArray[index] = PREPARING;
                            System.out.println('\n');
							System.out.println(" \tUpdate order status successfully...");
                            System.out.println(" \tnew order status - Preparing");
                        } else if (newStatus == 2) {
                            orderStatusArray[index] = DELIVERED;
                            System.out.println('\n');
                            System.out.println(" \tUpdate order status successfully...");
                            System.out.println('\n');
                            System.out.println(" \tnew order status - Delivered");
                        } else {
							System.out.println('\n');
                            System.out.println(" \tInvalid status selection. Update failed.");
                        }
                    } else {
						System.out.println('\n');
                        System.out.println(" \tInvalid choice.");
                    }
                }
            }
            
            System.out.println('\n');
            System.out.print(" \tDo you want to update another order details (Y/N): ");
            char cont = input.next().charAt(0);
            if (cont == 'Y' || cont == 'y') {
                continue L1;
            } else {
                cls();
                homepage();
                break L1;
            }
        }
    }
}
    
    
        
	

    
    


