import model.Database;

public class TestDatabase {
	public static void main(String[] args) {
		System.out.println("Running Database test");
		
		Database db = new Database();
		db.connect();
		db.disconnect();
	}
}
