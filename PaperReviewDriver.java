import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperReviewDriver {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/erDiagram";
	static final String USER = "root";
	static final String PASS = "123456";

	public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try {
		Class.forName(JDBC_DRIVER);
		
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT id, title, abstraction, fileName FROM paper";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String abstraction = rs.getString("Abstraction");
			String fileName = rs.getString("fileName");
			
			System.out.println("ID: " + id);
			System.out.println(", Title: " + title);
			System.out.println(", Abstaction: " + abstraction);
			System.out.println(", FileName: " + fileName);
		}
		
		String sql1;
		sql1 = "SELECT firstName, lastName, eamilAddr FROM author";
		ResultSet rs1 = stmt.executeQuery(sql1);
		
		while(rs1.next()) {
			String firstName = rs1.getString("firstName");
			String lastName = rs1.getString("lastName");
			String emailAddr = rs1.getString("eamilAddr");
			
			System.out.println("FirstName: " + firstName);
			System.out.println(", LastName: " + lastName);
			System.out.println(", EmailAddress: " + emailAddr);
		}
		
		String sql2;
		sql2 = "SELECT id, paperId, reviewerId, meritScore, readabilityScore, originalityScore, relevanceScore, recommendation FROM review";
		ResultSet rs2 = stmt.executeQuery(sql2);
		
		while(rs2.next()) {
			int id = rs2.getInt("id");
			int paperId = rs2.getInt("paperId");
			int reviewerId = rs2.getInt("reviewerId");
			int meritScore = rs2.getInt("meritScore");
			int readabilityScore = rs2.getInt("readabilityScore");
			int originalityScore = rs2.getInt("originalityScore");
			int relevanceScore = rs2.getInt("relevanceScore");
			String recommendation = rs2.getString("recommendation");
			
			System.out.println("Id: " + id);
			System.out.println("paperId: " + paperId);
			System.out.println("reviewerId: " + reviewerId);
			System.out.println("meritScore: " + meritScore);
			System.out.println("readabilityScore: " + readabilityScore);
			System.out.println("originalityScore: " + originalityScore);
			System.out.println("relevanceScore: " + relevanceScore);
			System.out.println("recommendation: " + recommendation);
		}
		 
		public List<PaperReviewDriver> query() throws SQLException{
			List<PaperReviewDriver> paperReviewDriver = new ArrayList<PaperReviewDriver>();
			Connection conn = DBUtil.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id FROM paper");
			PreparedStatement ptmt = conn.preparedStatement(sb.toString());
			ResultSet rs = ptmt.executeQuery();
		}
		
		public void addAuthor(Integer id) throws SQLException{
			conn = DriverManager.getConnection();
			String sql3 = "INSERT INTO author(firstName, lastName, emailAddr) VALUES ('Jill', 'Red', '3745@email.com')";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, author.getFirstName());
			ptmt.setString(2, author.getLastName());
			ptmt.setString(3, author.getEmailAddr());
			
			ptmt.execute();
		}
		
		public void addPaper(Integer id) throws SQLException{
			String sql4 = "INSERT INTO paper(id, title, abstraction, fileName) VALUES ('456', 'the Development of Database Management System', 'Abstraction2', '456paper')";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, paper.getId());
			ptmt.setString(2, paper.getTitle()); 
			ptmt.setString(3, paper.getAbstraction());
			ptmt.setString(4, paper.getfileName());
			
			ptmt.execute();
		}
		public void deleteAuthor(Integer id) throws SQLException{
			conn = DriverManager.getConnection();
			String sql = "DELETE FROM author WHERE id='1'";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
			}
		
	    rs.close();
		stmt.close();
		conn.close();
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(stmt!=null) stmt.close();
		}catch(SQLException se2) {
		}
		try {
			if(conn!=null) conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	System.out.println("Bye");
	}
}
