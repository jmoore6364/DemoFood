import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FoodTrucks foodTrucks = new FoodTrucks();
		List<FoodTruck> openFoodTrucks = foodTrucks.getOpenFoodTrucks(new Date());
		openFoodTrucks.sort(Comparator.comparing(FoodTruck::getName));
		Scanner console = new Scanner(System.in);
		int i = 1;
		printHeader();
		for (FoodTruck foodTruck : openFoodTrucks) {
			if (i % 10 == 0) {
				System.out.println("Press 'Enter' to continue");
				console.nextLine();
				printHeader();
			}
			System.out.println(StringUtil.padRightWithSpaces(StringUtil.maxLength(foodTruck.getName(), 75), 75) + foodTruck.getLocation());
			i++;
		}
	}
	
	static void printHeader() {
		System.out.println(StringUtil.padRightWithSpaces("NAME", 75) + "ADDRESS");
	}

}
