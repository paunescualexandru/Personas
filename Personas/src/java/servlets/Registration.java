/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Dinamo
 */
public class Registration extends HttpServlet {
    
    /*public void chekEntry(String entry){
    //if (entry == null){
        /System.out.println("Fild must be populated"+ entry);
    } */ 
    public static String DEFAULT_USER_ROLE = "USER";
    
    
    //Random rand = new Random();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // we'll need a DB connection for our insert, delete or update actions. To avoid redefinition of these we'll define it here
        String user = "test";
        String password = "1234";
        String url = "jdbc:derby://localhost:1527/persoane;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        PreparedStatement statement = null; // we need it for insert or update
        ResultSet resultSet = null;
        //test
        // DigestUtils comes from commons-codec-1.7.jar (For Generate Encrypt Text)
        // identify pushed button
        //if(request.getParameter("admin_users_insert") != null){
            // read values inserted by admin to be inserted
            String id = request.getParameter("admin_users_id");
            PrintWriter out= response.getWriter();
            String un = request.getParameter("account");
            String pas = request.getParameter("password");
           // String role = request.getParameter("admin_user_role");
            String name = request.getParameter("fname");
            String surname = request.getParameter("surname");
            String phone  = request.getParameter("phone");
            String email  = request.getParameter("email");
            String gender  = request.getParameter("gender");
            String date  = request.getParameter("date"); 
            String address  = request.getParameter("address");
            String age  = request.getParameter("age");
                
            //String newPword = DigestUtils.md5Hex(pas);// DigestUtils comes from commons-codec-1.7.jar (For Generate Encrypt Text)
            
            //Generate Hash Code which helps in Activation Link
            String myHash;
            Random random = new Random();
            random.nextInt(999999);
            myHash = DigestUtils.md5Hex(""+random);// DigestUtils comes from commons-codec-1.7.jar (For Generate Encrypt Text)
            //New create data bean
            RegisterBean rb = new RegisterBean();
            rb.setMyHash(myHash);
                
                
                
            //declare DB working variables
            
            try{
               // PreparedStatement ptsm1 = connection.prepareStatement("SELECT MAX(ID)+1 FROM USERS");
                 //String sql="SELECT id FROM USERS ORDER BY id DESC LIMIT 1";
                 //PreparedStatement  pst=connection.prepareStatement(sql);
                 //ResultSet rs=pst.executeQuery();
                 
       
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                //Run a select query to recover number of rows
                PreparedStatement ptsml = connection.prepareStatement("SELECT COUNT(ID) FROM USERS");
                ResultSet rs=ptsml.executeQuery();
                int lastId = 0;
                while(rs.next()){
                    lastId = rs.getInt(1);
                }
                SendingEmail se = new SendingEmail(email, myHash);
                se.sendEmail();
                
                //lastId contains number of rows
                String insertQuerry = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(insertQuerry);
                statement.setInt(1, lastId + 331);
                statement.setString(2, un);
                statement.setString(3, pas);
                statement.setString(4, DEFAULT_USER_ROLE);
                statement.setString(5, name);
                statement.setString(6, surname);
                statement.setString(7, phone);
                statement.setString(8, email);
                statement.setString(9, gender);
                statement.setString(10, date);
                statement.setString(11, address);
                statement.setString(12, age);
                statement.setString(13, myHash);
                statement.setString(14, "0");
                statement.execute();
                //statement.executeUpdate("INSERT INTO USERS VALUES("+un+"','"+pas+"','"+name+"','"+surname+"','"+phone+"','"+email+"','"+gender+"','"+date+"','"+address+"')");
                
                int i = ptsml.executeUpdate();
                if(i!=0){
                    // Sendig Email Code
                    //SendingEmail se = new SendingEmail(email, myHash);
                    //se.sendEmail();
                }
            }
             catch (ClassNotFoundException | SQLException ex)
            {
                ex.getMessage();
            }
            finally
            {
                if (resultSet != null)
                {
                    try
                    {
                        resultSet.close();
                    }
                    catch (SQLException ex){
                        ex.getMessage();
                    }
                }
                if (statement != null)
                {
                    try
                    {
                        statement.close();
                    }
                    catch (SQLException ex){
                        ex.getMessage();
                    }
                }	
                if (connection != null)
                {
                    try
                    {
                        connection.close();
                    }
                    catch (SQLException ex){
                        ex.getMessage();
                    }
                }
            }
            // forward control to the same jsp - register.jsp ==> this will reload master view with new row inserted if everything is ok
        // redirect page to its JSP as view
                    request.getRequestDispatcher("./verifypage.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
    

}
