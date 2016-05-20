package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	MongoClient mongoClient = new MongoClient( "localhost" );
	MongoDatabase database = mongoClient.getDatabase("mydb");
	
}
