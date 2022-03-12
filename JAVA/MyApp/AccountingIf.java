
public class AccountingAppIF {

	public static void main(String[] args) {
		
		double valueOfsupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double VAT = valueOfsupply * vatRate;
		double expenseRate = 0.3;
		double total = valueOfsupply + VAT;
		double expense = valueOfsupply * expenseRate;
		double income = valueOfsupply - expense;
		
		double dividend_1;
		double dividend_2;
		double dividend_3;
		
		if (income > 10000.0) {
			dividend_1 = income * 0.5;
			dividend_2 = income * 0.3;
			dividend_3 = income * 0.2;
		} else {
			dividend_1 = income * 1.0;
			dividend_2 = income * 0;
			dividend_3 = income * 0;
		}
		
		System.out.println("Value of Supply : " + valueOfsupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Selling Price : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		System.out.println("Dividend1 : " + dividend_1);
		System.out.println("Dividend2 : " + dividend_2);
		System.out.println("Dividend3 : " + dividend_3);
		

	}

}
