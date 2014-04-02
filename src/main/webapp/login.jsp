<%@ page import ="java.sql.*" %>
<%@ page import ="com.pubiapplication.app.*" %>
<%@ page import ="java.security.NoSuchAlgorithmException"%>
<%@ page import ="org.*"%>


<%

	String user = request.getParameter("user");
	String pass="";
	
	try {
		pass = Login.stringToHash(request.getParameter("password"));
	} catch (NoSuchAlgorithmException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Connection conn = DatabaseConnection.getConnection();
	
	try {
		String query ="SELECT * FROM users WHERE kasutajanimi=? AND parool=?";
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setString(1,user);
		prepStmt.setString(2,pass);
		ResultSet rs= prepStmt.executeQuery();
		if(rs.next()){
			session.setAttribute("userid", user);
		}
		else{
			response.sendRedirect("success.jsp");
		}
	} catch (SQLException e) {

	} catch (Exception e) {

	}



	
	

//-------------------------------------------
    String userid = request.getParameter("uname");   
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname",
            "root", "dbpass");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
//--------------------------------------------------------------
%>