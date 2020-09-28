/*
 * Admin users servlet process the Insert, Delete, Update or Cancel actions of user
 */
package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Dinamo
 */
public class AdminUsersRoles extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // we'll need a DB connection for our insert, delete or update actions. To avoid redefinition of these we'll define it here
        String user = "test";
        String password = "1234";
        String url = "jdbc:derby://localhost:1527/persoane;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        // identify pushed button
        if(request.getParameter("admin_users_insert") != null){
            // read values inserted by admin to be inserted
            //String id = request.getParameter("admin_users_id");
            //String un = request.getParameter("admin_users_username");
            //String pas = request.getParameter("admin_users_password");
            String role = request.getParameter("admin_user_role");
            //declare DB working variables
            Connection connection = null;
            PreparedStatement statement = null; // we need it for insert or update
            ResultSet resultSet = null;
            try{
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                String insertQuerry = "INSERT INTO USERS VALUES (?, ?, ?, ?)"; // parameters for id, username, password and role
                statement = connection.prepareStatement(insertQuerry);
                //statement.setInt(1, Integer.parseInt(id)); // converts id from String to Smallint not int
                //statement.setString(2, un);
                //statement.setString(3, pas);
                statement.setString(4, role);
                statement.execute();
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
            // forward control to the same jsp - adminusers.jsp ==> this will reload master view with new row inserted if everything is ok
            request.getRequestDispatcher("./adminusers.jsp").forward(request, response);
        }
        else if(request.getParameter("admin_users_update") != null){
            // read values inserted by admin to be inserted
            String id = request.getParameter("admin_users_id");
            String un = request.getParameter("admin_users_username");
            String pas = request.getParameter("admin_users_password");
            String role = request.getParameter("admin_user_role");
            //declare DB working variables
            Connection connection = null;
            PreparedStatement statement = null; // we need it for insert or update
            ResultSet resultSet = null;
            try{
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                String updateQuerry = "UPDATE USERS SET username=?, password=?, role=? WHERE id=?"; // parameters for id, username, password and role
                statement = connection.prepareStatement(updateQuerry);
                statement.setString(1, un);
                statement.setString(2, pas);
                statement.setString(3, role);
                statement.setInt(4, Integer.parseInt(id));
                boolean execute = statement.execute();
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
            // forward control to the same jsp - adminusers.jsp ==> this will reload master view with new row inserted if everything is ok
            request.getRequestDispatcher("./adminusers.jsp").forward(request, response);
        }
        else if(request.getParameter("admin_users_delete") != null){ // delete all selected rows from table users
            // read values inserted by admin to be inserted
            String id = request.getParameter("admin_users_id");
            String un = request.getParameter("admin_users_username");
            String pas = request.getParameter("admin_users_password");
            String role = request.getParameter("admin_user_role");
            //declare DB working variables
            Connection connection = null;
            PreparedStatement statement = null; // we need it for insert or update
            ResultSet resultSet = null;
            try{
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                // identify selected checkboxes 
                String[] selectedCheckboxes = request.getParameterValues("admin_users_checkbox");
                // as we should make more SQL deletes we should declare a transaction before start
                connection.setAutoCommit(false);
                for(String s:selectedCheckboxes){
                    Short ids = Short.parseShort(s);
                    String updateQuerry = "DELETE FROM USERS WHERE id=?"; // parameters for id, username, password and role
                    statement = connection.prepareStatement(updateQuerry);
                    statement.setInt(1, ids); // converts id from String to Smallint not int
                    boolean execute = statement.execute();
                }
                // when and if transaction had no error close transaction
                connection.setAutoCommit(true);
            }
             catch (ClassNotFoundException | SQLException ex)
            {
                try {
                    // if an SQL exception appears we have to rollback the database
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex1);
                }
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
                        connection.setAutoCommit(true);
                        connection.close();
                    }
                    catch (SQLException ex){
                        ex.getMessage();
                    }
                }
            }
            // forward control to the same jsp - adminusers.jsp ==> this will reload master view with new row inserted if everything is ok
            request.getRequestDispatcher("./adminusers.jsp").forward(request, response);
        }
        else if(request.getParameter("admin_users_cancel") != null){
            // forward control to main.jsp page
            request.getRequestDispatcher("./main.jsp").forward(request, response);
        }
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
        return "Admin users servlet";
    }// </editor-fold>

}
