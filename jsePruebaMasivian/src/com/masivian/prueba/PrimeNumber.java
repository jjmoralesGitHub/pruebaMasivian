package com.masivian.prueba;

/**
 * Class responsible for processing and displaying prime numbers
 * @author jjmorales
 *
 */
public class PrimeNumber {
	
	private int p[];
	private int qtyPrimeNumbers;

	/**
	 * Constructor method responsible for processing the number of prime numbers entered
	 * @param qtyPrimeNumbers number of prime numbers to process
	 */
	PrimeNumber(int qtyPrimeNumbers) {
		this.qtyPrimeNumbers = qtyPrimeNumbers;
		process();
	}
	
	/**
	 * Method responsible for processing the quantity of prime numbers requested
	 */
	private void process() {
		int j = 1, k = 1, square = 9, ord = 2, n = 0, ordMax = 30;
		int mult[] = new int[ordMax + 1];
		boolean jPrime;
		this.p = new int[this.qtyPrimeNumbers + 1];
		this.p[1] = 2;

		while (k < this.qtyPrimeNumbers) {
			do {
				j += 2;
				if (j == square) {
					ord++;
					square = this.p[ord] * this.p[ord];
					mult[ord - 1] = j;
				}
				n = 2;
				jPrime = true;

				while (n < ord && jPrime) {
					while (mult[n] < j)

						mult[n] += this.p[n] + this.p[n];
					if (mult[n] == j)
						jPrime = false;
					n++;
				}

			} while (!jPrime);
			k++;
			this.p[k] = j;
		}
	}
	
	/**
	 * Method responsible for displaying the requested prime numbers
	 * @param numberOfValuesPerRow number of values ​​per row to display
	 * @param numberOfRowsPerPage number of rows per page to display
	 */
	public void showInfo(int numberOfValuesPerRow, int numberOfRowsPerPage) { 
		int pageNumber = 1, pageOffSet = 1, rowOffSet, c;
		
		while (pageOffSet <= this.qtyPrimeNumbers) {
			System.out.println("The First " + this.qtyPrimeNumbers + " Prime Numbers === Page "+ pageNumber);
			
			for (rowOffSet = pageOffSet; rowOffSet <= pageOffSet + numberOfRowsPerPage - 1; rowOffSet++) {
				for (c = 0; c <= numberOfValuesPerRow - 1; c++) {
					if (rowOffSet + c * numberOfRowsPerPage <= this.qtyPrimeNumbers)
						System.out.printf("%10d", this.p[rowOffSet + c * numberOfRowsPerPage]);
				}
				System.out.println();
			}
			
			System.out.println("\f");
			pageNumber++;
			pageOffSet += numberOfRowsPerPage * numberOfValuesPerRow;
		}
	}
}
