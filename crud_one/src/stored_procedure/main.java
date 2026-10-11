package stored_procedure;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DBconnection.dbconnection());
        Stored_procedure_logic.create();
	}

}
