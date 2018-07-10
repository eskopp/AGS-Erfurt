package add;

public class func {

	public static void main(String[] args) {
		String string = "123-12";
		String[] parts = string.split("-");
		Double zahl = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
		System.out.println(zahl);

	}

}
