package videostore.horror;

public class Rental {
	private final Movie movie;
	private final int daysRented;
	
	public Rental(Movie movie, int daysRentals) {
		this.movie = movie;
		this.daysRented = daysRentals;
	}
	public int getDaysRented() {
		return daysRented;
	}
	public Movie getMovie() {
		return movie;
	}

	public double calculatePrice() {
		// got from spring
		RentalPriceCalculator rentalPriceCalculator = new RentalPriceCalculator();
		return movie.getType().priceAlgo.apply(rentalPriceCalculator, daysRented);
	}
	public int calculateRenterPoints() {
		int points = 1;
		if (isEligibleForBonusPoints()) {
			points++;
		}
		return points;
	}
	private boolean isEligibleForBonusPoints() {
		return movie.isNewRelease() && daysRented >= 2;
	}
}




