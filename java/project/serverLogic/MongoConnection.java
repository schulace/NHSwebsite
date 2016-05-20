package project.serverLogic;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.mongodb.*;
import com.google.gson.*;
import org.bson.*;

public class MongoConnection {
	
	public boolean sendtodb(String jsonstring, int userid){
		
		MongoClient mongoClient = new MongoClient( "localhost" ); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase("mydb");//gets db called mydb
		MongoCollection<Document> collection = database.getCollection("test");//
		
		
		
//		Document dbObject = JSON.parse(jsonstring);
//		collection.insertOne(dbObject);
		
		return false;
		
	}
	
	
}
