package project.serverLogic;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
//TODO josh you use javadoccing for this kind of shit not just a bunch of commented lines. /** on the first line to indicate a javadoc.
public class Mongoconnect //TODO josh what have you done. there are like 25 warnings and 20 of them are from this class because you use this.blah to access static fields.
{
	
	private static String host = "localhost";
	private static String dbname = "mydb";
	private static String usedcoll = "test1";
	public static ArrayList<String> collectionlist;
	
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
	
	public MongoCollection<Document> getConnection(String collection2){//sets up initial connection
		MongoClient mongoClient = new MongoClient(host); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase(dbname);//gets db called mydb
		MongoCollection<Document> collection = database.getCollection(collection2);//replace with not tes
		mongoClient.close();
		return collection;
	}
	
	public String getDbInfo(){//get db info, probably never gonna be used, might commend out
		MongoClient mongoClient = new MongoClient(host); //connects to client on localhost
		MongoDatabase database = mongoClient.getDatabase(dbname);//gets db called mydb
		String info = database.getName();//just make a string with the name of the db
		mongoClient.close();
		return info;//return
	}
	
	public void insertToDb(String collection){//send data to database, test method using ServerStart.getTestJson()
		MongoCollection<Document> collname = getConnection(collection);
		Document parsedjson = Document.parse(ServerStart.getTestJson()); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		collname.insertOne(parsedjson); //insert document into collection
	}
	
	public void insertToDb(String json, String collection){//send data to database
		MongoCollection<Document> collname = getConnection(collection);
		Document parsedjson = Document.parse(json); //REPLACE THIS WITH NOT TEST METHOD, create new document from JSON string
		collname.insertOne(parsedjson); //insert document into collection
	}
	
	public long getUserCount(String collection2){//gets the number of users in a db
		MongoCollection<Document> collection = getConnection(null);//retrieve a collection
		long usercount = collection.count();
		return usercount;
	}
	
	public ArrayList<String> getCollectionList(){
		return collectionlist;
	}
	
	public String getfromdb(String field, String value, String collection){//for example, getfromdb(username, john);
		MongoCollection<Document> collname = getConnection(collection);//retrieve a collection
		Document myDoc = collname.find(eq(field,value)).first();
		return myDoc.toJson();
	}
	

}