import java.util.*;
 class Example {
	public static void cls(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	  private static String convertToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }

    private static int convertFromRoman(String romanStr) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = romanStr.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(romanStr.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }
		
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        L1:do{
			
			cls();
            System.out.println("                                       __   ______             __                                                                 ");
            System.out.println("                                      |  \\ /      \\           |  \\                                                             ");
            System.out.println("                                       \\$$|  $$$$$$\\  ______  | $$  _______                                                     ");
            System.out.println("                                      |  \\| $$    \\$$|      \\ | $$ /       \\                                                  ");
            System.out.println("                                      | $$| $$        \\$$$$$$\\| $$|  $$$$$$$                                                    ");
            System.out.println("                                      | $$| $$   __   /     $$| $$| $$                                                            ");
            System.out.println("                                      | $$| $$__/  \\ | $$$$$$$| $$| $$_____                                                      ");
            System.out.println("                                      | $$\\ $$   $$  \\$$    $$| $$ \\$$     \\                                                  ");
            System.out.println("                                       \\$$ \\$$$$$$    \\$$$$$$$ \\$$  \\$$$$$$$                                             	  ");
            System.out.println('\n');
            System.out.println(" _   _                       _                       _____                                         _                              ");
            System.out.println("| \\ | |                     | |                     / ____|                                       | |                            ");
            System.out.println("|  \\| |  _   _   _ __ ___   | |__     ___   _ __   | |        ___    _ __   __   __   ___   _ __  | |_    ___   _ __             ");
            System.out.println("| . ` | | | | | | '_ ` _ \\  | '_ \\   / _ \\ | '__|  | |       / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|    ");
            System.out.println("| |\\  | | |_| | | | | | | | | |_) | |  __/ | |     | |____  | (_) | | | | |  \\ V /  |  __/ | |    | |_  |  __/ | |              ");
            System.out.println("|_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|      \\_____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|       ");
            System.out.println('\n');
            System.out.println("==========================================================================================================================        ");
            System.out.println('\n');
            System.out.println("	[01] Decimal Converter\n");
            System.out.println("	[02] Binary Converter\n");
            System.out.println("	[03] Octal Converter\n");
            System.out.println("	[04] Hexadecimal Converter\n");	
            System.out.println("	[05] Roman Number Converter\n");
            System.out.println("        [06] Exit the application..");
            System.out.println('\n');
            System.out.print("Enter Option ->");
            int option=input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    L2:do{
						
						cls();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|            Decimal Converter              |");
                        System.out.println("+-------------------------------------------+");
                        System.out.println('\n');
                        System.out.print("Enter a Decimal number : ");
                        int decimal = input.nextInt();
                        input.nextLine();
                        System.out.println('\n');
                         
                            if (decimal >= 0) {
								
                                System.out.println("    *) Binary number      : " +Integer.toBinaryString(decimal));
                                System.out.println("    *) Octal number       : " +Integer.toOctalString(decimal));
                                System.out.println("    *) Hexadecimal number : " +Integer.toHexString(decimal).toUpperCase());
                            } else {
                                System.out.println("     Invalid input...Please enter a positive number.");
                            }   System.out.println('\n');
                       
						
						
						
                        L3:do{
							
                            System.out.print("     Do you want to continue..?.(Y/N)-->");
                            char option2 = input.next().charAt(0);
                            input.nextLine();
                            if(option2 == 'Y' || option2 == 'y') {
                                continue L2;
                            }else if(option2 == 'N'||option2 == 'n') {
                                break L2;
                            }else{
                                System.out.println("Wrong selection..Input again.");
                                continue L3;
                            }
                        }while(true);
                    }while(true);
                    break;

                case 2:
                    L2:do{
						
						cls();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|             Binary Converter              |");
                        System.out.println("+-------------------------------------------+");
                        System.out.println('\n');
                        System.out.print("Enter a Binary number : ");
                        String binary = input.nextLine();
                        System.out.println('\n');
                        
                        
                        if(binary.matches("[01]+")) {
							
								int decimal = Integer.parseInt(binary, 2);
                                System.out.println("    *) Decimal number     : " +decimal);
                                System.out.println("    *) Octal number       : " +Integer.toOctalString(decimal));
                                System.out.println("    *) Hexadecimal number : " +Integer.toHexString(decimal).toUpperCase());
								System.out.println('\n');
                                }
                         else {
                            System.out.println("     Invalid input...Please enter a binary number (only 0s and 1s).");
                       }	System.out.println('\n');

                        L3:do{
							
                            System.out.print("      Do you want to continue..?.(Y/N)-->");
                            char option2 = input.next().charAt(0);
                            input.nextLine();
                            if(option2 == 'Y' || option2 == 'y') {
                                continue L2;
                            }else if(option2 == 'N'||option2 == 'n') {
                                break L2;
                            }else{
                                System.out.println("Wrong selection..Input again.");
                                continue L3;
                            }
                        }while(true);
                    }while(true);
                    break;
                    
                case 3:
                     L2:do{
						
						cls();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|             Octal Converter               |");
                        System.out.println("+-------------------------------------------+");
                        System.out.println('\n');
                        System.out.print("Enter an Octal number : ");
                        String octal = input.nextLine();
                        System.out.println('\n');
                        
                        
                        if(octal.matches("[0-7]+")) {
							
								int decimal = Integer.parseInt(octal, 8);
                                System.out.println("    *) Decimal number     : " +decimal);
                                System.out.println("    *) Binary number      : " +Integer.toBinaryString(decimal));
                                System.out.println("    *) Hexadecimal number : " +Integer.toHexString(decimal).toUpperCase());
								System.out.println('\n');
                                }
                         else {
                            System.out.println("     Invalid input...Please enter a octal number (only 0-7s).");
                       }	System.out.println('\n');

                        L3:do{
							
                            System.out.print("      Do you want to continue..?.(Y/N)-->");
                            char option2 = input.next().charAt(0);
                            input.nextLine();
                            if(option2 == 'Y' || option2 == 'y') {
                                continue L2;
                            }else if(option2 == 'N'||option2 == 'n') {
                                break L2;
                            }else{
                                System.out.println("Wrong selection..Input again.");
                                continue L3;
                            }
                        }while(true);
                    }while(true);
                    break;
                    
                    
                case 4:
                     L2:do{
						
						cls();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|             Hexadecimal Converter         |");
                        System.out.println("+-------------------------------------------+");
                        System.out.println('\n');
                        System.out.print("Enter a Hexadecimal number : ");
                        String HexaString = input.nextLine();
                        System.out.println('\n');
                        
                        
                        if(HexaString.matches("[0-9a-fA-F]+")) {
							
								int decimal = Integer.parseInt(HexaString, 16);
                                System.out.println("    *) Decimal number     : " +decimal);
                                System.out.println("    *) Binary number      : " +Integer.toBinaryString(decimal));
                                System.out.println("    *) Octal number       : " +Integer.toOctalString(decimal).toUpperCase());
								System.out.println('\n');
                                }
                         else {
                            System.out.println("     Invalid input...Please enter a octal number (only 0-7s).");
                       }	System.out.println('\n');

                        L3:do{
							
                            System.out.print("      Do you want to continue..?.(Y/N)-->");
                            char option2 = input.next().charAt(0);
                            input.nextLine();
                            if(option2 == 'Y' || option2 == 'y') {
                                continue L2;
                            }else if(option2 == 'N'||option2 == 'n') {
                                break L2;
                            }else{
                                System.out.println("Wrong selection..Input again.");
                                continue L3;
                            }
                        }while(true);
                    }while(true);
                    break;
                    
                 case 5:
                    L2: do {
                        cls();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|             Roman Number Converter        |");
                        System.out.println("+-------------------------------------------+");
                        System.out.println('\n');
                        System.out.println(" [01]  Decimal Number to Roman Number Converter\n");
                        System.out.println(" [02]  Roman Number to Decimal Number Converter\n");
                        System.out.print("Enter an Option ->");
                        int suboption = input.nextInt();
                        input.nextLine();

                        switch (suboption) {
                            case 1:
                                L4: do {
                                    cls();
                                    System.out.println("+-------------------------------------------+");
                                    System.out.println("|  Decimal Number to Roman Number Converter |");
                                    System.out.println("+-------------------------------------------+");
                                    System.out.println('\n');
                                    System.out.print("Enter a Decimal number : ");
                                    int decimal = input.nextInt();
                                    input.nextLine();
                                    System.out.println('\n');

                                    if (decimal <= 0) {
                                        System.out.println("Invalid input. Please enter a positive integer.");
                                        continue L4;
                                    }

                                    String roman = convertToRoman(decimal);
                                    System.out.println("Roman numeral: " + roman);

                                    L3: do {
                                        System.out.print("\n     Do you want to continue..?.(Y/N)-->");
                                        char option2 = input.next().charAt(0);
                                        input.nextLine();
                                        if (option2 == 'Y' || option2 == 'y') {
                                            continue L4;
                                        } else if (option2 == 'N' || option2 == 'n') {
                                            break L2;
                                        } else {
											System.out.println('\n');
                                            System.out.println("      Wrong selection..Input again.");
                                            continue L2;
                                        }
                                    } while (true);
                                } while (true);
                               

                            case 2:
                                L4: do {
                                    cls();
                                    System.out.println("+-------------------------------------------+");
                                    System.out.println("|  Roman Number to Decimal Number Converter |");
                                    System.out.println("+-------------------------------------------+");
                                    System.out.println('\n');
                                    System.out.print("Enter a Roman number : ");
                                    String romanStr = input.next().toUpperCase();
                                    input.nextLine();
                                    System.out.println('\n');

                                    if (romanStr.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
                                        
                                            int decimal = convertFromRoman(romanStr);
                                            System.out.println("\n    Decimal number: " + decimal);
                                        } 
                                        
                                    else {
                                        System.out.println("\nInvalid Roman numeral.");
                                    }

                                    L3: do {
                                        System.out.print("\n      Do you want to continue..?.(Y/N)-->");
                                        char option2 = input.next().charAt(0);
                                        input.nextLine();
                                        if (option2 == 'Y' || option2 == 'y') {
                                            continue L4;
                                        } else if (option2 == 'N' || option2 == 'n') {
                                            break L2;
                                        } else {
                                            System.out.println("Wrong selection..Input again.");
                                            continue L1;
                                        }
                                    } while (true);
                                } while (true);
                               

                            default:
                                System.out.println("Invalid option. Please try again.");
                                continue L1;
                        }
                    } while (true);
                   

                case 6:
                    System.out.println('\n');
                    System.out.println("               Existing the application..bye..");
                    System.exit(0);
                    break;

                default:
                    System.out.println('\n');
                    System.out.println("               Wrong Selection....Try again");
                    break L1;
            }
        } while (true);
    }
}
