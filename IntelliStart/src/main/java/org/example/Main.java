package org.example;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int idProduct[]=new int[3];
        String nameProduct []=new String[3];
        int price []=new int[3];

        int idUser[]=new int[3];
        String firstName []=new String[3];
        String lastName []=new String[3];
        int money[]=new int[3];
        int idForBuy;
        String nameForBuy;
        int moneyForBuy = 0;
        String buyInfo[]=new String[99];
        buyInfo[0]="No purchases have been made yet";
        int x=0;
        int n=1;
        for(int i=0; i<3;i++) {
            System.out.println("Enter product id #" + n);
            idProduct[i] = s.nextInt();
            System.out.println("Enter the name of the product #" + n);
            nameProduct[i] = s.next();
            System.out.println("Enter the price of the product #" + n);
            price[i] = s.nextInt();
            n++;
        }
        if(idProduct[0]==idProduct[1]){
            System.out.println("This id already exists. Please choose another id for product #1: ");
            idProduct[1]=s.nextInt();
        }
        if(idProduct[1]==idProduct[2]){
            System.out.println("This id already exists. Please choose another id for product #2: ");
            idProduct[2]=s.nextInt();
        }
        if(idProduct[0]==idProduct[2]){
            System.out.println("This id already exists. Please choose another id for product #2: ");
            idProduct[2]=s.nextInt();
        }
        n=1;
        for(int i=0; i<3;i++) {
            System.out.println("Enter buyer id #" + n);
            idUser[i]=s.nextInt();
            System.out.println("Enter the buyer name #" + n);
            firstName[i]=s.next();
            System.out.println("Enter the buyer's last name #" + n);
            lastName[i]=s.next();
            System.out.println("Enter the amount of the buyer money #" + n);
            money[i]=s.nextInt();
            n++;
        }
        if(idUser[0]==idUser[1]){
            System.out.println("This id already exists. Enter a new id for user #1: ");
            idUser[1]=s.nextInt();
        }
        if(idUser[1]==idUser[2]){
            System.out.println("This id already exists. Enter a new id for user #2: ");
            idUser[2]=s.nextInt();
        }
        if(idUser[0]==idUser[2]){
            System.out.println("This id already exists. Enter a new id for user #2: ");
            idUser[2]=s.nextInt();
        }
        for(int j=0;j<999;j++) {
            System.out.println("Choose the desired option:\n" + "1 - View users;\n" + "2 - View the list of products;\n"+"3 - Buy"+"4 - Purchase history"+"0 - Exite");
            int choice = s.nextInt();
            if(choice==0){
                break;
            }
            switch (choice) {
                case (1):
                    for (int i = 0; i < 3; i++) {
                        System.out.println("User id: " + idUser[i] + "      " + "Name and surname of the user: " + firstName[i] + " " + lastName[i] + "     " + "Amount of user funds: " + money[i]);
                    }
                    break;
                case (2):
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Product Id: " + idProduct[i] + "      " + "Product name: " + nameProduct[i] + "     " + "Product price: " + price[i]);
                    }
                    break;
                case (3):
                    System.out.println("Enter the ID of the user who wants to buy:");
                    idForBuy=s.nextInt();
                    for(int i=0;i<999;i++) {
                        if (idForBuy == idUser[0] || idForBuy == idUser[1] || idForBuy == idUser[2]) {
                            break;
                        }else{
                            System.out.println("Such an id does not exist. Enter another:");
                            idForBuy=s.nextInt();
                        }
                    }
                    System.out.println("Enter the name of the product which wants to buy:");
                    nameForBuy=s.next();
                    for(int i=0;i<999;i++) {
                        if (nameForBuy.toLowerCase() == nameProduct[0].toLowerCase() || nameForBuy.toLowerCase() == nameProduct[1].toLowerCase() || nameForBuy.toLowerCase() == nameProduct[2].toLowerCase()) {
                            break;
                        }else{
                            System.out.println("Such an name does not exist. Enter another:");
                            nameForBuy=s.next();
                        }
                    }
                    for(int i=0; i<3;i++) {
                        for (int k = 0; k < 3; k++) {
                            if (moneyForBuy == money[i]) {
                                if (nameForBuy == nameProduct[j]) {
                                    if (money[i] < price[j]) {
                                        System.out.println("Lack of money");
                                        break;
                                    }
                                    money[i] -= price[j];
                                    System.out.println("The purchase is made");
                                    buyInfo[x]=firstName+" "+lastName+" "+nameProduct;
                                    x++;
                                    break;
                                }
                            }
                        }
                    }
                case (4):
                        System.out.println("Purchase history: ");
                        for (int i=0;i<=x;i++){
                            System.out.println(buyInfo[i]);
                        }
                    break;
            }
        }

        s.close();
    }
}