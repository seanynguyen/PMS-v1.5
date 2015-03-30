/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.test;


import com.google.common.collect.Lists;
import com.youngidea.pms.entity.item.Category;
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
public class testFacade1 extends HttpServlet {
    @EJB
    private GenericFacade<Category> genericFacade;

    @EJB
    private ItemFacade itemFacade;


//    @EJB
//    private ItemFacade itemFacade;


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

            List<Item> items = Lists.newArrayList();
            Item item = new Item();
            item.setId(Long.parseLong("3"));
            item.setName("Latte");

            Item item2 = new Item();
            item.setId(Long.parseLong("4"));
            item.setName("Mocha");

//            Category category = new Category();
//            category.setId(new Long("1"));
//            category.setName("Italian Coffee");

            Category category = genericFacade.find(Category.class, Long.parseLong("1"));

//            item.setCategory(category);
//            item.setCategory(category);
//            genericFacade.create(category);
//            itemFacade.edit(item);
            items.add(item);
            items.add(item2);
            category.setItems(items);

            genericFacade.edit(category);


            out.println("Holly Shit, Bitch !!!!!");
            out.println("OKKKK");

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
            Logger.getLogger(testFacade1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testFacade1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(testFacade1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(testFacade1.class.getName()).log(Level.SEVERE, null, ex);
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
