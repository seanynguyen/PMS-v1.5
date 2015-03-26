/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.test;

import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.facade.ItemFacade;
import org.apache.log4j.BasicConfigurator;
import org.quartz.SchedulerException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sean
 */
@WebServlet(name = "testFacade", urlPatterns = {"/testFacade"})
public class testFacade extends HttpServlet {
    @EJB
    private GenericFacade baseEntityFacade;

    @EJB
    private ItemFacade itemFacade;


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
            BasicConfigurator.configure();

            final List<String> mappingFilesNames = new ArrayList<>();

            Item item = new Item();
            item.setId(Long.parseLong("4"));
            item.setName("blahblah123");
            itemFacade.edit(item);
            out.println("OK");

            // test dozer
//            DozerBeanMapper mapper = new DozerBeanMapper();
//            mappingFilesNames.add("dozer.xml");
//            mapper.setMappingFiles(mappingFilesNames);
//
//            dto1 newDto1 = new dto1();
//            newDto1.setMyName("SEAN");
//
//            dto2 destObject =
//                    mapper.map(newDto1, dto2.class);
//            out.println(destObject.getName());
//            out.println(destObject.getCompany());

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
            Logger.getLogger(testFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testFacade.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(testFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testFacade.class.getName()).log(Level.SEVERE, null, ex);
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
