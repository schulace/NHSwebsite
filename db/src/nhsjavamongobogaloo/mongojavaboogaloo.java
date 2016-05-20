package nhsjavamongobogaloo;

import com.mongodb.MongoClient;

public class mongojavaboogaloo {

	// To directly connect to a single MongoDB server
	// (this will not auto-discover the primary even if it's a member of a replica set)
	//MongoClient mongoClient = new MongoClient();

	// or
	MongoClient mongoClient = new MongoClient( "localhost" );

	// or
//	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//	// or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
//	MongoClient mongoClient = new MongoClient(
//	  Arrays.asList(new ServerAddress("localhost", 27017),
//	                new ServerAddress("localhost", 27018),
//	                new ServerAddress("localhost", 27019)));
//
//	// or use a connection string
//	MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017,localhost:27018,localhost:27019");
//	MongoClient mongoClient = new MongoClient(connectionString);
//
//	MongoDatabase database = mongoClient.getDatabase("mydb");
	
}
