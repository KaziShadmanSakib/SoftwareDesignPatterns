# Coffee Vending Machine

![](https://github.com/KaziShadmanSakib/SoftwareDesignPatterns/blob/main/VendingMachine/Image/coffeeVendingMachine.jpg?raw=true)

Developed a coffee vending machine simulator program to showcase the State Design Pattern in action that accepts coins of 10, 20, and 50 cents worth, and prepares two types of drinks - Coffee and Cappuccino, costing 1.20 and 1.50 respectively. The program allows users to insert and eject money, ejects money automatically if there is not enough to purchase a selected beverage, and returns change if the inserted money is sufficient. It also ensures that the cup is taken before allowing the user to make another order.

A coffee vending machine goes through 4 states, NoCoinInsertedState -> CoinInsertedState ->  PrepareState -> CupTakenState.