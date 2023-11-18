package makechange;

import java.math.BigDecimal;
import java.util.Scanner;

/*
 * This class uses BigDecimal so precision isn't lost like when using doubles or floats.
 */

public class CashRegister {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("How much is the item you are purchasing?");
		BigDecimal price = keyboard.nextBigDecimal();

		System.out.print("How much cash are you providing to pay for your purchase?");
		BigDecimal cashPaid = keyboard.nextBigDecimal();

		if (cashPaid.compareTo(price) < 0) {
			System.out.println("You have not paid enough cash. Please try again.");
			keyboard.close();
			return;
		} else if (cashPaid.equals(price)) {
			System.out.println("Thank you for your puchase! There is no change due. Have a great day!");
			keyboard.close();
			return;
		} else {
			calculateChange(price, cashPaid);
		}
		keyboard.close();
	}

	public static void calculateChange(BigDecimal inputPrice, BigDecimal inputCashPaid) {

		BigDecimal changeDue = inputCashPaid.subtract(inputPrice);

		BigDecimal twentyTender = new BigDecimal("20");
		BigDecimal tenTender = new BigDecimal("10");
		BigDecimal fiveTender = new BigDecimal("5");
		BigDecimal oneTender = new BigDecimal("1");
		BigDecimal quarterTender = new BigDecimal("0.25");
		BigDecimal dimeTender = new BigDecimal("0.10");
		BigDecimal nickelTender = new BigDecimal("0.05");
		BigDecimal pennyTender = new BigDecimal("0.01");

		// Determine how many 20s
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, twentyTender));

		// Determine how many 10s
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, tenTender));

		// Determine how many 5s
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, fiveTender));

		// Determine how many 1s
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, oneTender));

		// Determine how many Quarters
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, quarterTender));

		// Determine how many Dimes
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, dimeTender));

		// Determine how many Nickels
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, nickelTender));

		// Determine how many Pennies
		changeDue = changeDue.subtract(calculateTenderDue(changeDue, pennyTender));

	}

	public static BigDecimal calculateTenderDue(BigDecimal inputChangeDue, BigDecimal inputDenomination) {
		BigDecimal tenderDue = new BigDecimal("0");
		BigDecimal incrementor = new BigDecimal("1.0");

		/*
		 * This while loop will determine how much of each type of tender will be needed
		 * for change when called from calculateChange(). For example, if
		 * calculateChange() determined there is 0.33c that is to be paid back to the
		 * customer, it will compareTo() 0.33 to 0.25 and return 1, so it will enter the
		 * loop and decrease the change due to 0.08 and the tenderDue variable (which is
		 * currently counting the 0.25c denomination) will increment by 1.
		 */

		while (inputChangeDue.compareTo(inputDenomination) >= 0) {
			inputChangeDue = inputChangeDue.subtract(inputDenomination);
			tenderDue = tenderDue.add(incrementor);
		}

		BigDecimal twentyTender = new BigDecimal("20");
		BigDecimal tenTender = new BigDecimal("10");
		BigDecimal fiveTender = new BigDecimal("5");
		BigDecimal oneTender = new BigDecimal("1");
		BigDecimal quarterTender = new BigDecimal("0.25");
		BigDecimal dimeTender = new BigDecimal("0.10");
		BigDecimal nickelTender = new BigDecimal("0.05");
		BigDecimal pennyTender = new BigDecimal("0.01");

		/*
		 * The if statements below compareTo and equals incrementor simply because it
		 * was a BigDecimal value set to 1 and I just needed a BigDecimal '1' to compare
		 * with. I used it instead of making an unneeded object.
		 *
		 * The compareTo() methods are determining if tenderDue > 1, and if so, the
		 * method will return a 1. If not, the method will return a -1. If they are
		 * equal it will return a 0.
		 */

		
		if (inputDenomination.equals(twentyTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " twenty dollar bills. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " twenty dollar bill. ");
			}
		} else if (inputDenomination.equals(tenTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " ten dollar bills. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " ten dollar bill. ");
			}
		} else if (inputDenomination.equals(fiveTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " five dollar bills. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " five dollar bill. ");
			}
		} else if (inputDenomination.equals(oneTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " one dollar bills. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " one dollar bill. ");
			}
		} else if (inputDenomination.equals(quarterTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " quarters. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " quarter. ");
			}
		} else if (inputDenomination.equals(dimeTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " dimes. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " dime. ");
			}
		} else if (inputDenomination.equals(nickelTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " nickels. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " nickel. ");
			}
		} else if (inputDenomination.equals(pennyTender)) {
			if (tenderDue.compareTo(incrementor) > 0) {
				System.out.print(tenderDue.intValue() + " pennies. ");
			} else if (tenderDue.equals(incrementor)) {
				System.out.print(tenderDue.intValue() + " penny. ");
			}
		}

		tenderDue = tenderDue.multiply(inputDenomination);
		return tenderDue;
	}

}
