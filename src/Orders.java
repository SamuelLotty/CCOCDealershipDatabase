
public class Orders {
	private int DealershipNumber,NumberOfCars,NumberOfStaff,CarsSold;
	private String DealershipLocation; 
	
	public Orders(){
	}
	
	public int getDealershipNumber() {
		return DealershipNumber;
	}
	public void setDealershipNumber(int DealershipNumber) {
		this.DealershipNumber = DealershipNumber;
	}
	
	public int getCarsSold() {
		return CarsSold;
	}
	public void setCarsSold(int CarsSold) {
		this.CarsSold=CarsSold;
	}
	
	public int getNumberOfStaff() {
		return NumberOfStaff;
	}
	public void setNumberOfStaff(int NumberOfStaff) {
		this.NumberOfStaff=NumberOfStaff;
	}
	public int getNumberOfCars() {
		return NumberOfCars;
	}
	public void setNumberOfCars(int NumberOfCars) {
		this.NumberOfCars=NumberOfCars;
	}
	public String getDealershipLocation() {
		return DealershipLocation;
	}
	public void setDealershipLocation(String DealershipLocation) {
		this.DealershipLocation=DealershipLocation;
	}
}
