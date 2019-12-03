package patterns.clone.immutable.samples;

/** 
 * This class leak's its this reference during initialization in the constructor.
 * Running this application will print two different values for the name attribute:
 * 1. in the TextUtil class the default value of name is accessible (null)
 * 2. in the main method after construction, the final value of name is visible. ("Eva")
 */
public class LeakingThis {
	private final String salutation;
	private final String name;
	private final boolean female;

	public LeakingThis(boolean female, String name) {
		this.female = female;
		salutation = TextUtil.getSalutation(this) + ' ' + name; // leaking this
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSalutation() {
		return salutation;
	}
	
	public boolean isFemale() {
		return female;
	}

	public static void main(String[]args) {
		LeakingThis l = new LeakingThis(true, "Eva");
		System.out.println("in main: " + l.getName());
	}
}

class TextUtil {
	static String getSalutation(LeakingThis lt) {
		System.out.println("in TextUtil: " + lt.getName());
		return lt.isFemale() ? "Liebe" : "Lieber";
	}
}
