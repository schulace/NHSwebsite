package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoTest
{

		public static void main(String[] args)
		{
			Mongoconnect conn = new Mongoconnect();
			conn.setDbname("NHS");
			System.out.println(conn.listCollections());
			conn.close();
		}
}
