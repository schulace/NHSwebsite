package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoTest
{

		public static void main(String[] args)
		{
			MongoClient mc = new MongoClient(" 24.38.233.137", 27017);
			MongoDatabase db = mc.getDatabase("mydb");
			MongoIterable<String> z = db.listCollectionNames();
			for(String s:z)
			{
				System.out.println(s);
			}
			mc.close();
		}
}
