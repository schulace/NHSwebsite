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
	insertToDb(String collection), returns nothing;
	insertToDb(String json, String collection), returns nothing;
	getUserCount(), returns int count;
	getFromDb(String field, String value, String collection), returns String json;
	getCollection(String collection), returns ArrayList<String> of all documents in collection in json
 */

public class Mongoconnect
{
	
	private  String host = "localhost";
	private  String dbname = "NHS";
	private  String usedcoll = "test1";
	public MongoClient client;
	public  ArrayList<String> collectionlist = new ArrayList<String>();
	
	public Mongoconnect()
	{
		this.getConnection();
		//checkCollection();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUsedcoll() {
		return usedcoll;
	}

	public void setUsedcoll(String usedcoll) {
		this.usedcoll = usedcoll;
	}

	public ArrayList<String> getCollectionlist() {
		return collectionlist;
	}

	public void setCollectionlist(ArrayList<String> collectionlist) {
		this.collectionlist = collectionlist;
	}



	public void checkCollection(){
		Boolean isin = false;
		for (int i = 0;i<collectionlist.size();i++){
			if (usedcoll.equals(collectionlist.get(i))){
				 isin = true;
			}
		}
		collectionlist.add(usedcoll);
	}
	
	//sets up initial connection
	public MongoDatabase getConnection(){
		this.client = new MongoClient(host); //connects to client on localhost
		MongoDatabase database = this.client.getDatabase(dbname);//gets db called mydb
		//MongoCollection<Document> collection = database.getCollection(collection2);//replace with not tes
		return database;
	}
	
	
	///YOU HAVE ENTERED THE DANGER ZONE:
	
	//THIS IS CODE THAT HAS BEEN WORKED ON BY TWO PEOPLE WHO DID NOT TALK TO EACH OTHER ABOUT WTF THEY'RE DOING
	//AND NOW IT'S A GRAVEYARD FOR CODE THAT COULD HAVE BEEN
	//MIGHT FIX LATER BUT TBH WE PROBABLY DON'T NEED IT
	//SO PROB NOT
	
	
//	//get db info, probably never gonna be used, might commend out
//	public String getDbInfo(){
//		MongoClient mongoClient = new MongoClient(host); //connects to client
//		MongoDatabase database = mongoClient.getDatabase(dbname);//gets db called mydb
//		String info = database.getName();//just make a string with the name of the db
//		info += " , collections are ";
//		MongoIterable<String> fuckyou = database.listCollectionNames();
//		info += fuckyou.first();
//		return info;//return
//	}
	
	
	
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
		ArrayList<String> allJSON = new ArrayList<String>();
		for (Document cur : colls.find()) {
		    allJSON.add(cur.toJson());
		}
		return allJSON;
	}
	
	public void close()
	{
		client.close();
	}
	
	
	public ArrayList<String> listCollections()
	{
		MongoDatabase database = getConnection();//retrieve a collection
		MongoIterable<String> colls = database.listCollectionNames();
		ArrayList<String> collnames = new ArrayList<String>();
		for (String s : colls)
		{
			collnames.add(s);
		}
		return collnames;
	}
	

}