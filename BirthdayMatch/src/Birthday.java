
public class Birthday {

	public static void main(String[] args) {
		final String[] days = new String[]{
				"19861031",
				"19880810",
				"19880815",
				"19880810",
				"19370218",
				"19920604",
				"19850826",
				"19760802",
				"20051014",
				"19770219",
				"19840714",
				"19851124",
				"19780318",
				"19970518",
				"",
				"19800926",
				"19840814",
				"19850223"};
		
		//iterate through birthdays, prints the difference between the dates
		for(int i = 0; i < days.length; i++){
			for(int j = i+1; j < days.length; j++){
				int difference = 1000;
				//Only process if they're valid birthdays 
				if(validBirthday(days[i]) && validBirthday(days[j])){
					//if the birthdays match, then difference is 0.
					difference = calculateDifference(days[i], days[j]);
					

					
					//store or print the difference
					System.out.println("Difference between " + i + " and " + j + " is " + difference);
				}
			}
			
		}
		
	}
	
	//check if the length of the string is 8 after removing spaces and letters (correctly formatted)
	static boolean validBirthday(String birthday){
		birthday = birthday.replaceAll("[^\\d]", "");
		if(birthday.length() != 8) return false;
		return true;
	}
	
	//get the year of the birthday as an integer
	static int getYear(String birthday){
		String year = birthday.substring(0, 4);
		return Integer.parseInt(year);
	}
	
	//get the month of the birthday as an integer
	static int getMonth(String birthday){
		String month = birthday.substring(4, 6);
		return Integer.parseInt(month);
	}
	
	//get the day of the birthday as an integer
	static int getDay(String birthday){
		String day = birthday.substring(6);
		return Integer.parseInt(day);
	}
	
	//calculate the difference given two birthdays
	static int calculateDifference(String day1, String day2){
		if(day1.matches(day2)){
			return 0;
		}
		int sum = 0;
		for(int i = 0; i < day1.length(); i++){
			sum += Math.abs(day1.charAt(i) - day2.charAt(i));
		}
		return sum;
	}
	
	//checks the permutations of the birthdays and returns the minimum difference.
	static int calculateMinDiff(String day1, String day2){
		int min = calculateDifference(day1, day2);
		if(min == 0) return 0;
		
		//flip the day
		
		//flip the month
		
		//flip the day and the month
		String mod1 = day1.substring(0, 4).concat(day1.substring(6, 8)).concat(day1.substring(4, 6));
		String mod2 = day2.substring(0, 4).concat(day2.substring(6, 8)).concat(day2.substring(4, 6));
		min = calculateDifference(mod1, mod2);
		if(min == 0) return 0;
		
		//flip day+month + day
		
		//flip day+month + day + month
		
		return min;
	}
	
}
