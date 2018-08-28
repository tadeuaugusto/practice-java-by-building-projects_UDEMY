package emailapp;

/**
 * Main
 * @author Tadeu
 *
 */
public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Email app = new Email("tadeu", "dutra");
		app.setAlternativeEmail("alternative-email@gmail.com");
		
		System.out.println(app.showInfo());
	}

}
