package project.serverLogic;

public class MongoTest {

		public static void main(String[] args){
			
			Mongoconnect newconnection = new Mongoconnect();
			System.out.println(newconnection.getDbInfo());
		}
}
