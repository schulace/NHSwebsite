package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import org.bson.*;
import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;


/**
 * Here's how do:
	
	You can pass 0, 1, 2 or 3 variables to the constructor. If nothing is passed, it uses all default values,
	But you can also specify the collection, database, and host in that order.

	Methods: 
	getDbInfo(), returns String dbinfo;
	insertToDb(), returns nothing;
	insertToDb(String json), returns nothing;
	getUserCount(), returns int count;
	getFromDb(String field, String value), returns String json;
 */

public class Mongoconnect
{
	
	private static String host = "localhost";
	private static String dbname = "mydb";
	private static String usedcoll = "test1";
	public static ArrayList<String> collectionlist = new ArrayList<String>();
	
	public Mongoconnect(){
		super();
		checkCollection();
	}
	
	public Mongoconnect(String calledcoll){
		usedcoll = calledcoll;//testdb
		checkCollection();
	}
	
	public Mongoconnect(String calledcoll, String db){
		dbname = db;//defualtdb
		usedcoll = calledcoll;//testdb
		checkCollection();
	}
	
	public Mongoconnect(String calledcoll, String db, String location){
		host = location;//default host
		dbname = db;//defualtdb
		usedcoll = calledcoll;//testdb
		checkCollection();
	}
	
	public void checkCollection(){
		Boolean isin = false;
		for (int i = 0;i<collectionlist.size();i++){
			if (usedcoll ==  collectionlist.get(i)){
				 isin = true;
			}
		}
		collectionlist.add(usedcoll);
	}
	
	//sets up initial connection
	public MongoDatabase getConnection(){
		MongoClient mongoClient = new MongoClient(host); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase(dbname);//gets db called mydb
		//MongoCollection<Document> collection = database.getCollection(collection2);//replace with not tes
		return database;
	}
	
	//get db info, probably never gonna be used, might commend out
	public String getDbInfo(){
		MongoClient mongoClient = new MongoClient(host); //connects to client
		MongoDatabase database = mongoClient.getDatabase(dbname);//gets db called mydb
		String info = database.getName();//just make a string with the name of the db
		info += " , collections are ";
		MongoIterable<String> fuckyou = database.listCollectionNames();
		info += fuckyou.first();
		return info;//return
	}
	
	//send data to database, test method using ServerStart.getTestJson()
	public void insertToDb(String collection){
		MongoDatabase database = getConnection();
		MongoCollection<Document> coll = database.getCollection(collection);//replace with not tes
		Document parsedjson = Document.parse(ServerStart.getTestJson()); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		coll.insertOne(parsedjson); //insert document into collection
	}
	
	public void insertToDb(String json, String collection){//send data to database
		MongoDatabase database = getConnection();
		MongoCollection<Document> coll = database.getCollection(collection);//replace with not tes
		Document parsedjson = Document.parse(json); //create new document from JSON string
		coll.insertOne(parsedjson); //insert document into collection
	}
	
	//Gets the number of users in a db
	public long getUserCount(String collection){
		MongoDatabase database = getConnection();//retrieve a collection
		MongoCollection<Document> coll = database.getCollection(collection);//replace with not tes
		long usercount = coll.count();
		return usercount;
	}
	
	//Return collection list. TODO: Get rid of this I think
	public ArrayList<String> getCollectionList(){
		return collectionlist;
	}
	
	//Get specified document from collection. For example, getfromdb(username, john);
	public String getFromDb(String field, String value, String collection){
		MongoDatabase database = getConnection();//retrieve a collection
		MongoCollection<Document> coll = database.getCollection(collection);
		Document myDoc = coll.find(eq(field,value)).first();
		return myDoc.toJson();
	}

	public ArrayList<String> getCollection(String collection) 
	{
		MongoDatabase database = getConnection();//retrieve a collection
		MongoCollection<Document> colls = database.getCollection(collection);
		ArrayList<String> allJSON = null;
		for (Document cur : colls.find()) {
		    allJSON.add(cur.toJson());
		}
		return allJSON;
	}
	
	
	public ArrayList<String> listCollections(String collectionName){
		MongoDatabase database = getConnection();//retrieve a collection
		MongoIterable<String> colls = database.listCollectionNames();
		ArrayList<String> collnames = null;
		for (String s : colls) {
			collnames.add(s);
		}
		return collnames;
	}
	

}