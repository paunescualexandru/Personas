/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astirotaghandlers;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Dinamo
 */
public class connectdb extends SimpleTagSupport {

    private String dburl;
    private String dbdriver;
    private String dbusername;
    private String dbpassword;
    private String dbconnection;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Class driverClass = Class.forName(dbdriver); // test if driver class from Java DB is Correct
            dbconnection = (DriverManager.getConnection(dburl, dbusername, dbpassword)).toString();
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            getJspContext().setAttribute(dbconnection, out, PageContext.SESSION_SCOPE);
        } catch (java.io.IOException ex) {
            throw new JspException("Error in connectdb tag", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(connectdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDburl(String dburl) {
        this.dburl = dburl;
    }

    public void setDbdriver(String dbdriver) {
        this.dbdriver = dbdriver;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public void setDbconnection(String dbconnection) {
        this.dbconnection = dbconnection;
    }
    
}
