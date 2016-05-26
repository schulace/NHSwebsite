package project.serverLogic;

public class MongoTest {

		public static void main(String[] args){
			
			Mongoconnect newconnection = new Mongoconnect();
			System.out.println(newconnection.getDbInfo());
			newconnection.insertToDb(ServerStart.getTestJson());
			System.out.println(newconnection.getUserCount());
			String json = newconnection.getfromdb("name", "test_student@greenwich.k12.ct.us");
			System.out.println(json);
		}
}
