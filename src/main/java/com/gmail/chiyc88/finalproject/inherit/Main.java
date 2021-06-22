package com.gmail.chiyc88.finalproject.inherit;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Drink Machine!\n--------------------");
        System.out.print("How much money do you have: ");
        int money = scanner.nextInt();
        money = selectItem(money);
        while (money != 0) {
            System.out.println("Buy? (Y/N)");
            if (scanner.next() == "Y") {
                selectItem(money);
            } else {
                System.out.println("Bye!");
            }
        }
    }
    private static int selectItem(int money) {
        Scanner scanner = new Scanner(System.in);
        Cola cola = new Cola();
        Sprite sprite = new Sprite();
        Coffee coffee = new Coffee();

        HashMap<Integer, Drink> toDrink = new HashMap<Integer, Drink>();
        toDrink.put(1, cola);
        toDrink.put(2, sprite);
        toDrink.put(3, coffee);

        listItems();
        System.out.print("Enter: 1, 2, 3");
        int buy = scanner.nextInt();
        Drink drink = toDrink.get(buy);
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();
        int total = drink.getPrice() * amount;
        if (amount > drink.stocks) {
            System.out.println("Out of stocks!!");
        } else if (total > money) {
            System.out.println("You're poor! You don't have enough money.");
            return -1;
        } else {
            money = money - total;
            return total;
        }
        return -1;
    }

    private static void listItems() {
        Cola cola = new Cola();
        Sprite sprite = new Sprite();
        Coffee coffee = new Coffee();
        System.out.println("================================");
        System.out.println("(1)Cola");
        System.out.println("Price: " + cola.getPrice() +", Stocks: " + cola.getStocks());
        System.out.println("(2)Sprite");
        System.out.println("Price: " + sprite.getPrice() +", Stocks: " + sprite.getStocks());
        System.out.println("(3)Coffee");
        System.out.println("Price: " + coffee.getPrice() +", Stocks: " + coffee.getStocks());
        System.out.println("================================");
    }
}
