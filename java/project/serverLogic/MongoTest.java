package project.serverLogic;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import project.user.Student;

public class MongoTest
{

		public static void main(String[] args)
		{
			Mongoconnect conn = new Mongoconnect();
			conn.setDbname("NHS");
			conn.insertToDb("students");
			String s = conn.getCollection("students").get(0);
			Gson g = new Gson();
			Student stu = g.fromJson(s, Student.class);
			conn.close();
		}
}
