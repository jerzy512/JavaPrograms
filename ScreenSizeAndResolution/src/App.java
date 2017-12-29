import java.awt.Toolkit;

public class App {
	public static void main(String[] args) {
		// Create Toolkit object
		 Toolkit toolkit=Toolkit.getDefaultToolkit();
		 
		 // Get width, getScreenSize() returns Dimension & Dimension has width [variable]
		 System.out.println("The screen width is "+toolkit.getScreenSize().width);

		 // Get height, getScreenSize() returns Dimension & Dimension has height [variable]
		 System.out.println("The screen height is "+toolkit.getScreenSize().height);

		 // getScreenResolution() gives no.of dots per pixel
		 System.out.println("The screen resolution is "+toolkit.getScreenResolution());
	}
}
