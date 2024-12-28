package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root",
					"root");
			PreparedStatement ps = con.prepareStatement("update event set title=?,loc=?,date=?,guest=? where id=?");
			ps.setString(1, req.getParameter("title"));
			ps.setString(2, req.getParameter("loc"));
			ps.setString(3, req.getParameter("date"));
			ps.setString(4, req.getParameter("guest"));
			ps.setInt(5, Integer.parseInt(req.getParameter("id")));
			ps.executeUpdate();
//			RequestDispatcher rd=req.getRequestDispatcher("updateEvent.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("all");
			rd.forward(req, res);
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}

/*
 * other way @WebServlet("/updatepage") public class UpdatePageServlet extends
 * HttpServlet { public void service(ServletRequest req,ServletResponse res)
 * throws ServletException,IOException { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection
 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evs","root",
 * "root"); PreparedStatement
 * ps=con.prepareStatement("select * from event where id=?"); ps.setInt(1,
 * Integer.parseInt(req.getParameter("id"))); // int row=ps.executeUpdate(); //
 * System.out.println(row+":Row updated"); ResultSet rs=ps.executeQuery();
 * if(rs.next()) { req.setAttribute("rs",rs); RequestDispatcher
 * rd=req.getRequestDispatcher("updateevent.jsp"); rd.forward(req, res); }
 * rs.close(); ps.close(); con.close(); } catch (ClassNotFoundException |
 * SQLException e) { e.printStackTrace(); }
 * 
 * } }
 */
