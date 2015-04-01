package com.youngidea.pms.api.rest.dao.impl.converter;

/**
 * Created by sean on 3/26/15.
 */
import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.GenericFacade;
import org.quartz.SchedulerException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sean
 */
@WebServlet(name = "testDozer", urlPatterns = {"/"})
public class testDozer extends HttpServlet {
    @EJB
    private GenericFacade<ItemStatus> genericFacade;

    @EJB
    private ItemStatusDao itemStatusDao;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SchedulerException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            BasicConfigurator.configure();
            ItemStatusDozerConverter itemStatusDozerConverter = new ItemStatusDozerConverter();
            ItemStatus itemStatus = genericFacade.find(ItemStatus.class, new Long("1"));
//
//            out.println(itemStatusDozerConverter.convert(itemStatus).getStatusName());
//            ItemStatusModel itemStatusModel = new ItemStatusModel("Blended","Ice Blended","shit");
            out.println(itemStatusDao.find(new Long("2")));
            out.println(itemStatusDozerConverter.convert(genericFacade.find(ItemStatus.class, new Long("2"))));
//            out.println(genericFacade.find(ItemStatus.class, new Long("2")).getName());
            out.println("FUCK THAT SHIT !!");
            out.println("OK");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SchedulerException ex) {
            Logger.getLogger(testDozer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testDozer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SchedulerException ex) {
            Logger.getLogger(testDozer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testDozer.class.getName()).log(Level.SEVERE, null, ex);
        }
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

