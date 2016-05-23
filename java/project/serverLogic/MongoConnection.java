package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;

public class MongoConnection {
	
	
	public static String getdbinfo(){//get db info, probably never gonna be used, might commend out
			MongoClient mongoClient = new MongoClient( "localhost" ); //connects to client on localhost
			MongoDatabase database = mongoClient.getDatabase("mydb");//gets db called mydb
			MongoCollection<Document> collection = database.getCollection("test1");//replace with not test
			
			String info = database.getName();//just make a string with the name of the db
			return info;//return
	}
	
	public static void sendtodb(){//send data to database
			MongoClient mongoClient = new MongoClient( "localhost" ); //connects to client on localhost
			MongoDatabase database = mongoClient.getDatabase("mydb");//gets db called mydb
			MongoCollection<Document> collection = database.getCollection("test1");//replace with not tes
			
			Document parsedjson = Document.parse(ServerStart.getTestJson()); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
			collection.insertOne(parsedjson); //insert document into collection
	}

	public static void sendtodb(String json){//send data to database
		MongoClient mongoClient = new MongoClient( "localhost" ); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase("mydb");//gets db called mydb
		MongoCollection<Document> collection = database.getCollection("test1");//replace with not tes
		
		Document parsedjson = Document.parse(json); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		collection.insertOne(parsedjson); //insert document into collection
	}
	
//	public static String getfromdb(){    TODO
//		
//	}

}