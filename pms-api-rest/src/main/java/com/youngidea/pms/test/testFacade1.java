/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.test;


import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.dao.impl.converter.GenericConverter;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemPriceResponseModel;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.facade.ItemFacade;
import com.youngidea.pms.facade.ItemStatusFacade;
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
    private GenericFacade genericFacade;

    @EJB
    private ItemFacade itemFacade;

    @EJB
    private ItemStatusFacade itemStatusFacade;

    @EJB
    private GenericConverter<ItemPrice, ItemPriceRequestModel, ItemPriceResponseModel> genericConverter;

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

//// Merge entity example.
//            List<Item> items = Lists.newArrayList();
//            Item item = new Item();
//            item.setId(Long.parseLong("1"));
//            item.setName("Espresso");
//
////            Item item2 = new Item();
////            item2.setId(Long.parseLong("2"));
////            item2.setName("Capuccino");
//
//            Item item3 = new Item();
//            item3.setId(Long.parseLong("3"));
//            item3.setName("Latte");
//
//            Category category = new Category();
//            category.setId(new Long("1"));
//            category.setName("Italian Coffee");
//
//            items.add(item);
////            items.add(item2);
//            items.add(item3);
//            category.setItems(items);
//
//            genericFacade.edit(category);

// Test Item

//            Item item = new Item();
//            item.setId(new Long("2"));
//            item.setName("Cappuccino");


            // Item nguyen goc duoc lay len tu database
            Item item = itemFacade.find(new Long("11"));

            List<ItemPrice> itemPrices = Lists.newArrayList();
            ItemPrice itemPrice = new ItemPrice();
            itemPrice.setItemStatus((ItemStatus) genericFacade.find(ItemStatus.class, new Long("1")));
            itemPrice.setPrice(35000);
            itemPrices.add(itemPrice);
            item.setItemPrices(itemPrices);
            itemFacade.edit(item);


            // Item gia lap lai item tu database, ko co du lieu cu nen ko xoa cac price cu
//            Item item = new Item();
//            item.setId(new Long("11"));
//            item.setDescription("FUCK THAT SHIT");
//            item.setName("SHIT");
//            List<ItemPrice> itemPrices = Lists.newArrayList();
//            ItemPrice itemPrice = new ItemPrice();
//            ItemStatus itemStatus = new ItemStatus();
//            itemStatus.setId(new Long("2"));
//            itemPrice.setItemStatus(itemStatus);
//            itemPrice.setPrice(35000);
//            itemPrices.add(itemPrice);
//            item.setItemPrices(itemPrices);
//            itemFacade.edit(item);

            ItemPriceRequestModel itemPriceModel = new ItemPriceRequestModel();
            itemPriceModel.setId(new Long("1"));
            itemPriceModel.setStatusId(new Long("1"));
            itemPriceModel.setPrice(56);
            ItemPrice output = genericConverter.convertBack(itemPriceModel, ItemPrice.class);

            out.println(output.getId());
            out.println(output.getItemStatus().getId());
            out.println(output.getPrice());

            out.println("Holly Shit, Bitch !!!!!");
            out.println("OKKKK");


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
