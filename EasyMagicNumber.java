public class EasyMagicNumber {
	public static void main(String[] args) {
    int myNumber = 2;
    
    // We will refer to myNumber as the original number from now on.
	
	int magicNumber = myNumber * myNumber;
    magicNumber += myNumber;
    magicNumber /= myNumber;
    magicNumber += 17;
    magicNumber -= myNumber;
    magicNumber /= 6;

    System.out.println(magicNumber);

	}
}
