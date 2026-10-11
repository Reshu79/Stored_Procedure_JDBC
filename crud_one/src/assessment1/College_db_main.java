package assessment1;

public class College_db_main {
	public static void main (String args[]) {
	System.out.println(DBconnection.dbconnection());
	College_db_logic.creation();
//	College_db_logic.insertion();
//	College_db_logic.display();
	Company_db.creation();
//	Company_db.insertion();
	Company_db.display();
	Shopping_db.creation();
	Shopping_db.insertion();
	Shopping_db.display();
	}

}
