/* Assignment 04 -  A Coffee Vending Machine*/

/* Kazi Shadman Sakib
Roll: 97
3rd Year
CSE, University of Dhaka */

import java.util.*;

/* State Design Pattern */
/* NoCoinInsertedState -> CoinInsertedState ->  PrepareState -> CupTakenState */

/* A coffee vending machine goes through 4 states, given above */
interface State{

    /* Every state has 4 methods or functions */
    void insertCoin(double amount);
    void pressButton(int drinkType);
    void prepare(int drinkType);
    void cupTaken(int takenStatus);

}

class NoCoinInsertedState implements State{

    VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    /* In NoCoinInsertedState, if coin is inserted it sets the amount in vending machine
    * and then changes its state to CoinInsertedState*/
    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setCurrentStateOfVendingMachine(vendingMachine.getCoinInsertedState());

    }

    /* No use of this method if no coin is inserted */
    @Override
    public void pressButton(int drinkType) {
        throw new IllegalStateException("No coin is inserted!!");
    }

    /* No use of this method if no coin is inserted */
    @Override
    public void prepare(int drinkType) {
        throw new IllegalStateException("No coin is inserted!!");
    }

    /* No use of this method if no coin is inserted */
    @Override
    public void cupTaken(int takenStatus) {
        throw new IllegalStateException("No coin is inserted!!");
    }
}

class CoinInsertedState implements State{

    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    /* In CoinInsertedState, if we insert coins again then it will add the inserted amount
    * with the vending machines already accounted amount */
    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(vendingMachine.getAmount() + amount);
    }

    /* by using pressButton method, user chooses the beverage type from vending machine */
    @Override
    public void pressButton(int drinkType) {
        Inventory inventory = vendingMachine.getInventory();
        Beverage beverage = inventory.getBeverageAt(drinkType);

        /* checking if the beverage is available or not */
        if(beverage == null){
            throw new IllegalStateException("Beverage is not available anymore.");
        }

        /* Checking if the user has inserted sufficient amount of money to buy that
        * specific beverage */
        if(!vendingMachine.hasSufficientAmount(beverage.getPrice())){
            throw new IllegalStateException("Insufficient amount to buy this beverage!! Ejected your inserted " + vendingMachine.getAmount() +  " dollars due to insufficient amount.");
        }

        /* checking if the beverage is out of quantity or not */
        if(!inventory.checkIfBeverageIsAvailable(beverage.getId())){
            throw new IllegalStateException("Beverage is not available anymore.");
        }

        /* After choosing the specific beverage, we are going to the next stage that is
        * the PrepareState where the vending machine prepares the beverage for the user */
        vendingMachine.setCurrentStateOfVendingMachine(vendingMachine.getPrepareState());

    }

    /* No use of this method as beverage is not selected yet */
    @Override
    public void prepare(int drinkType) {
        throw new IllegalStateException("Beverage is not chosen yet!!");
    }

    /* No use of this method as beverage is not selected yet */
    @Override
    public void cupTaken(int takenStatus) {
        throw new IllegalStateException("Beverage is not chosen yet!!");
    }
}

class PrepareState implements State{

    VendingMachine vendingMachine;

    public PrepareState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    /* No use of this method as beverage is being prepared */
    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Beverage is being prepared!!");
    }

    /* No use of this method as beverage is being prepared */
    @Override
    public void pressButton(int drinkType) {
        throw new IllegalStateException("Beverage is being prepared!!");
    }

    /* In this method prepare(), we get the beverage from the vending machine's inventory,
    * and deduct the beverage count as this beverage is sold to the user
    * the vending machine calculates the change to be given to the user and ejects it
    * then vending machine prepares the beverage and returns the user with change */
    @Override
    public void prepare(int drinkType) {
        Inventory inventory = vendingMachine.getInventory();
        Beverage beverage = inventory.getBeverageAt(drinkType);

        inventory.deductBeverageCount(drinkType);

        double change = vendingMachine.getAmount() - beverage.getPrice();

        double changeCoins[] = new double[10];

        change = (int)Math.round(change*100);

        /* The Vending Machine will only return the users 10, 20 and 50 cent changes */
        int totalCoins=0;

        while (change > 0){

            if (change>=50){
                change = change - 50;
                changeCoins[totalCoins++] = 50;
            }

            if(change>=20 && change < 50){
                change = change - 20;
                changeCoins[totalCoins++] = 20;
            }

            if(change>=10 && change < 20){
                change = change - 10;
                changeCoins[totalCoins++] = 10;
            }

        }

        vendingMachine.setAmount(0.0);
        System.out.println("Beverage: " + beverage.getName() + " is being prepared now.");

        System.out.print("Changes returned to the user: ");
        for (int i=0;i<totalCoins;i++) {
            if(i<totalCoins-1){
                System.out.print((int)Math.round(changeCoins[i]) + " cent,");
            }
            else{
                System.out.print((int)Math.round(changeCoins[i]) + " cent.");
            }
        }
        System.out.println();

        System.out.println("Beverage is ready, waiting for the cup to be taken.");

        /* After preparing the beverage and returning the change, the next state of vending machine,
        * is to wait for the beverage to be taken out */
        vendingMachine.setCurrentStateOfVendingMachine(vendingMachine.getCupTakenState());
    }

    /* No use of this method as the beverage is being prepared */
    @Override
    public void cupTaken(int takenStatus) {
        throw new IllegalStateException("Beverage is being prepared!!");
    }
}

class CupTakenState implements State{

    VendingMachine vendingMachine;

    public CupTakenState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    /* No use of this method as the prepared beverage has not been taken out yet */
    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Take the prepared beverage first!!");
    }

    /* No use of this method as the prepared beverage has not been taken out yet */
    @Override
    public void pressButton(int drinkType) {
        throw new IllegalStateException("Take the prepared beverage first!!");
    }

    /* No use of this method as the prepared beverage has not been taken out yet */
    @Override
    public void prepare(int drinkType) {
        throw new IllegalStateException("Take the prepared beverage first!!");
    }

    /* the takenStatus is checked to check if the beverage is taken out or not
    * only if the beverage is taken out then the vending machine can take the next order */
    @Override
    public void cupTaken(int takenStatus) {
        if(takenStatus == 1){
            System.out.println("Beverage is taken.");
            System.out.println();

            /* After checking if the beverage is taken out, the state changes to NoCoinInsertedState again */
            vendingMachine.setCurrentStateOfVendingMachine(vendingMachine.getNoCoinInsertedState());
        }
    }
}

/* A beverage has its name, id and price */
class Beverage{
    private String name;
    private int id;
    private double price;

    public Beverage(String name, int id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

}

class Inventory{
    /* Says which aisle have which beverage */
    private Map<Integer, Beverage> aisleToBeverageMap;

    /* Says which number beverage id has how many quantity left */
    private Map<Integer, Integer> beverageIdToCountMap;
    Queue<Integer> availableAisles;

    public Inventory(int aisleCount){

        availableAisles = new LinkedList<>();

        for(int aisleNo = 1; aisleNo <= aisleCount ; aisleNo++){
            availableAisles.add(aisleNo);
        }
        aisleToBeverageMap = new HashMap<>();
        beverageIdToCountMap = new HashMap<>();
    }

    /* Adds beverages */
    public void addBeverage(Beverage beverage) throws Exception{
        int beverageId = beverage.getId();
        int beverageCount = beverageIdToCountMap.getOrDefault(beverageId, 0);
        if(beverageCount == 0){
            if(availableAisles.isEmpty()){
                throw new Exception("Out of Space to add Beverage!!");
            }
            aisleToBeverageMap.put(availableAisles.poll(), beverage);
        }
        beverageIdToCountMap.put(beverageId, beverageCount+1);
    }

    public Beverage getBeverageAt(int aisleNumber){
        return aisleToBeverageMap.get(aisleNumber);
    }

    /* Checks if the beverage is available or not */
    public boolean checkIfBeverageIsAvailable(int beverageId){
        int beverageCount = beverageIdToCountMap.getOrDefault(beverageId, 0);
        return beverageCount > 0;
    }

    /* Deducts per beverage type count */
    public void deductBeverageCount(int aisleNumber){
        int beverageId = aisleToBeverageMap.get(aisleNumber).getId();
        int updatedBeverageCount = beverageIdToCountMap.get(beverageId) - 1;

        //stock of product if finished
        if(updatedBeverageCount == 0){
            beverageIdToCountMap.remove(beverageId);
            aisleToBeverageMap.remove(aisleNumber);
            availableAisles.add(aisleNumber);
        }

        else{
            beverageIdToCountMap.put(beverageId, updatedBeverageCount);
        }

    }
}

/* Only the VendingMachine class and its methods are visible to the users */
class VendingMachine{

    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private PrepareState prepareState;

    private CupTakenState cupTakenState;
    private State currentStateOfVendingMachine;
    private Inventory inventory;

    private double amount;

    /* Beverage types */
    private static final int AISLE_COUNT = 2;

    public VendingMachine(){

        noCoinInsertedState = new NoCoinInsertedState(this);
        coinInsertedState = new CoinInsertedState(this);
        prepareState = new PrepareState(this);
        cupTakenState = new CupTakenState(this);
        currentStateOfVendingMachine = noCoinInsertedState;
        amount = 0.0;
        inventory = new Inventory(AISLE_COUNT);
    }

    public boolean hasSufficientAmount(double expectedAmount){
        return expectedAmount <= this.amount;
    }

    /* Inserts money to vending machine */
    public void insertCoin(double amount){
        this.currentStateOfVendingMachine.insertCoin(amount);
        System.out.println((int)Math.round(amount*100) + " cent is inserted.");
    }

    /* User chooses beverages and vending machine prepares beverages using this method */
    public void pressButton(int aisleNumber){
        this.currentStateOfVendingMachine.pressButton(aisleNumber);
        this.currentStateOfVendingMachine.prepare(aisleNumber);
    }

    /* Checks if the beverage cup is taken out of vending machine or not */
    public void cupTaken(int takenStatus){
        this.currentStateOfVendingMachine.cupTaken(takenStatus);
    }

    /* Adds beverage to the inventory of a vending machine */
    public void addBeverage(Beverage beverage){
        try{
            this.getInventory().addBeverage(beverage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setCurrentStateOfVendingMachine(State currentStateOfVendingMachine) {
        this.currentStateOfVendingMachine = currentStateOfVendingMachine;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public PrepareState getPrepareState() {
        return prepareState;
    }

    public CupTakenState getCupTakenState() {
        return cupTakenState;
    }

    public Inventory getInventory() {
        return inventory;
    }

}

class VendingMachine97{
    static VendingMachine vendingMachine = new VendingMachine();

    public static void main(String[] args){

        /* Creating two beverages */
        Beverage coffee = new Beverage("Coffee", 1, 1.20);
        Beverage cappuccino = new Beverage("Cappuccino", 2, 1.50);

        /* Inserting 5 cups of Coffee and 5 Cups of Cappuccino available in the Vending Machine */
        for(int i=0;i<5;i++){
            vendingMachine.addBeverage(coffee);
            vendingMachine.addBeverage(cappuccino);
        }

        /* Simulation of Vending Machine */
        initiate();

    }

    /* Simulation of Vending Machine */
    public static void initiate(){

        boolean run1 = true;
        Scanner scanner = new Scanner(System.in);

        while (run1!=false){
            boolean run2 = true;
            System.out.println("Hello World.\nWould you like to order a beverage?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.print("Your Input: ");

            int input1 = scanner.nextInt();

            if(input1 == 1){
                while(run2!=false){
                    System.out.println("Would you like to insert money?");
                    System.out.println("1. Yes.");
                    System.out.println("2. No.");
                    System.out.print("Your Input: ");
                    int input2 = scanner.nextInt();

                    if(input2 == 1){
                        System.out.println("Insert a coin worth of: ");
                        System.out.println("1. 10 cents.");
                        System.out.println("2. 20 cents.");
                        System.out.println("3. 50 cents.");
                        System.out.print("Your Input: ");
                        int input3 = scanner.nextInt();

                        if(input3 == 1){
                            vendingMachine.insertCoin(.10);
                        }

                        if(input3 == 2){
                            vendingMachine.insertCoin(.20);
                        }

                        if(input3 == 3){
                            vendingMachine.insertCoin(.50);
                        }

                    }

                    if(input2 == 2){
                        System.out.println("Choose your beverage: ");
                        System.out.println("1. Coffee, cost: 1.20 Dollar.");
                        System.out.println("2. Cappuccino, cost: 1.50 Dollar.");
                        System.out.print("Your Input: ");
                        int input4 = scanner.nextInt();

                        if(input4 == 1){
                            vendingMachine.pressButton(1);
                            System.out.print("Please press any integer key to take out the beverage: ");
                            int input5 = scanner.nextInt();
                            vendingMachine.cupTaken(1);
                            run2 = false;
                        }

                        if(input4 == 2){
                            vendingMachine.pressButton(2);
                            System.out.print("Please press any integer key to take out the beverage: ");
                            int input5 = scanner.nextInt();
                            vendingMachine.cupTaken(1);
                            run2 = false;
                        }
                    }
                }
            }
        }
    }
}