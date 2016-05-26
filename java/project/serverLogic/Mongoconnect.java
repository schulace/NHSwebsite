package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import static com.mongodb.client.model.Filters.*;

//	Here's how do:
//	
//	You can pass 0, 1, 2 or 3 variables to the constructor. If nothing is passed, it uses all default values,
//	But you can also specify the collection, database, and host in that order.
//
//	Methods: 
//	getDbInfo(), returns String dbinfo;
//	insertToDb(), returns nothing;
//	insertToDb(String json), returns nothing;
//	getUserCount(), returns int count;
//	getFromDb(String field, String value), returns String json;


public class Mongoconnect {
	
	private static String host = "localhost";
	private static String dbname = "mydb";
	private static String usedcoll = "test1";
	
	public Mongoconnect(){
		super();
	}
	
	public Mongoconnect(String calledcoll){
		this.usedcoll = calledcoll;//testdb
	}
	
	public Mongoconnect(String calledcoll, String db){
		this.dbname = db;//defualtdb
		this.usedcoll = calledcoll;//testdb
	}
	
	public Mongoconnect(String calledcoll, String db, String location){
		this.host = location;//default host
		this.dbname = db;//defualtdb
		this.usedcoll = calledcoll;//testdb
	}
	
	public MongoCollection<Document> getConnection(){//sets up initial connection
		MongoClient mongoClient = new MongoClient(this.host); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase(this.dbname);//gets db called mydb
		MongoCollection<Document> collection = database.getCollection(this.usedcoll);//replace with not tes
		return collection;
	}
	
	public String getDbInfo(){//get db info, probably never gonna be used, might commend out
		MongoClient mongoClient = new MongoClient(this.host); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase(this.dbname);//gets db called mydb
		String info = database.getName();//just make a string with the name of the db
		return info;//return
	}
	
	public void insertToDb(){//send data to database, test method using ServerStart.getTestJson()
		MongoCollection<Document> collection = getConnection();
		Document parsedjson = Document.parse(ServerStart.getTestJson()); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		collection.insertOne(parsedjson); //insert document into collection
	}
	
	public void insertToDb(String json){//send data to database
		MongoCollection<Document> collection = getConnection();
		Document parsedjson = Document.parse(json); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		collection.insertOne(parsedjson); //insert document into collection
	}
	
	public long getUserCount(){//gets the number of users in a db
		MongoCollection<Document> collection = getConnection();//retrieve a collection
		long usercount = collection.count();
		return usercount;
	}
	
	public String getfromdb(String field, String value){//for example, getfromdb(username, john);
		MongoCollection<Document> collection = getConnection();//retrieve a collection
		Document myDoc = collection.find(eq(field,value)).first();
		return myDoc.toJson();
	}
	
	public void closeconnection(){
		MongoClient mongoClient = new MongoClient(this.host); //connects to client on localhost
		mongoClient.close();
	}

}