package cashRegister;

import java.util.Arrays;

public class CashRegister {
	
	private int [] denominations;

    /**
     * Constructor
     * @param denominations values of coin types not in any order
     * @throws Exception when a coin of denomination 1 does not exist
     */
    public CashRegister(int [] denominations) throws Exception {
        /**
         * Complete code here

         */
        int check = 0;
        for ( int i : denominations){
            if ( i == 1){
                check = 1;
            }
        }
        if (check == 0){
            throw new Exception("No denomination of 1");
        }
        this.denominations = denominations;
    }

    /**
     * Make change for value
     * @param value
     * @return array of same length as denominations array that specifies
     *         coins of each denomination to use in making given change
     *         with minimum number of coins
     */
    public int [] makeChange(int value) {
        /**
         * Complete code here
         */
        int[] arr = new int[denominations.length];
        for ( int i = 0; i < denominations.length; i++) {
        	if (denominations[i] < value ) {
        		arr[i] = 1;
        		value = value - denominations[i];
        	}
        }
        return arr;
    }

    /**
     * Specifies description of change in coins
     * @param coins
     * @return
     */
    public void printValues(int [] coins) {
        StringBuilder builder = new StringBuilder();
        int totalCoins = 0;
        for (int i=0; i < denominations.length; i++) {
            if (coins[i] > 0) {
                if (builder.length() > 0) {
                    builder.append(",");
                }
                builder.append(coins[i] + " coins of value " + denominations[i]);
                totalCoins += coins[i];
            }
        }
        builder.append(" for a total of " + totalCoins + " coins");
        System.out.println(builder.toString());
    }

    public static void main(String [] args) throws Exception {
        CashRegister reg = new CashRegister(new int [] {50, 25, 10, 5, 1});
        System.out.println("Change for " + 48 + ":");
        // should have a total of 6 coins
        reg.printValues(reg.makeChange(48));
        System.out.println("Change for " + 56 + ":");
        // should have a total of 3 coins
        reg.printValues(reg.makeChange(56));
        reg = new CashRegister(new int [] {25, 10, 1});
        System.out.println("Change for " + 33 + ":");
        // should have a total of 6 coins
        reg.printValues(reg.makeChange(33));
        reg = new CashRegister(new int [] {1, 7, 24, 42});
        System.out.println("Change for " + 48 + ":");
        // should have a total of 2 coins
        reg.printValues(reg.makeChange(48));
        reg = new CashRegister(new int [] {50, 1, 3, 16, 30});
        System.out.println("Change for " + 35 + ":");
        // should have a total of 3 coins
        reg.printValues(reg.makeChange(35));
    }

	
}
