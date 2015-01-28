/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.service.impl;

import com.google.common.collect.Lists;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemGroup;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.entity.order.DiscountOrder;
import com.youngidea.pms.entity.order.PriceOrder;
import com.youngidea.pms.entity.order.RuleOrder;
import com.youngidea.pms.entity.promotion.PeriodicSchedule;
import com.youngidea.pms.entity.promotion.Promotion;
import com.youngidea.pms.entity.promotion.PromotionPrice;
import com.youngidea.pms.entity.promotion.PromotionRule;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.model.OrderRequestModel;
import com.youngidea.pms.service.BillingService;
import com.youngidea.pms.service.PromotionHandler;
import com.youngidea.pms.service.PromotionScheduler;
import com.youngidea.pms.service.SchedulerService;
import com.youngidea.pms.test.DateTimeTest;
import com.youngidea.pms.ultilities.PeriodicType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
/**
 *
 * @author sean
 */
@WebServlet(name = "TestBillingService", urlPatterns = {"/TestBillingService"})
public class TestBillingService extends HttpServlet {

    @EJB
    private BillingService billingService;
    
    @EJB
    private GenericFacade genericFacade;
    
    @EJB
    private PromotionHandler promotionHandler;
    
    @EJB
    private SchedulerService promotionSchedulerServiceImpl;
    
    @EJB
    private PromotionScheduler promotionScheduler;
    
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
            throws ServletException, IOException, SchedulerException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            PriceOrder priceOrder = new PriceOrder();
//            priceOrder.setItemPrice(genericFacade.find(ItemPrice.class, Long.parseLong("1")));
//            priceOrder.setQuantity(2);
//            genericFacade.create(PriceOrder.class, priceOrder);
//            
//            DiscountOrder discountOrder = new DiscountOrder();
//            discountOrder.setItemPrice(genericFacade.find(ItemPrice.class, Long.parseLong("2")));
//            discountOrder.setQuantity(1);
//            discountOrder.setDiscountPercent(30);
//            genericFacade.create(DiscountOrder.class, discountOrder);
            
//            RuleOrder ruleOrder = new RuleOrder();
//            ruleOrder.setItemPrice(genericFacade.find(ItemPrice.class, Long.parseLong("1")));
//            ruleOrder.setQuantity(5);
//            genericFacade.create(RuleOrder.class, ruleOrder);
//            
//            PromotionPrice pp = new PromotionPrice();
//            pp.addExtraOrder(genericFacade.find(PriceOrder.class, Long.parseLong("1")));
//            genericFacade.create(PromotionPrice.class, pp);
            
            
//            PromotionRule pr = new PromotionRule();
//            pr.setPromotionPrice(genericFacade.find(PromotionPrice.class, 1));
//            pr.addRuleOrder(genericFacade.find(RuleOrder.class, Long.parseLong("1")));
//            genericFacade.create(PromotionRule.class, pr);
            
//            Promotion promotion = new Promotion();
//            promotion.setName("Happy New year");
//            promotion.setDescription("Happy new year promotion");
//            promotion.setPromotionRule(genericFacade.find(PromotionRule.class, 1));
//            genericFacade.create(Promotion.class, promotion);

//            PromotionRule pr = genericFacade.find(PromotionRule.class, 1);
//            pr.addRuleOrder(genericFacade.find(RuleOrder.class, Long.parseLong("1")));
//            genericFacade.edit(PromotionRule.class, pr);
            
            
            
            // Mua 5 tang 2 
//            OrderRequestModel order1 = new OrderRequestModel(Long.parseLong("1"), 15);
//            OrderRequestModel order3 = new OrderRequestModel(Long.parseLong("2"), 6);
//            OrderRequestModel order2 = new OrderRequestModel(Long.parseLong("1"), 1);
//            billingService.addOrder(order1);
//            billingService.addOrder(order3);
//            billingService.removeOrder(order2);
//            out.println(billingService.getTotal());
//            List<PromotionPrice> pps = promotionHandler.retrievePromotionPrices(genericFacade.find(PromotionRule.class, 1), 
//                    billingService.getCurrentOrders());
//            out.println(pps.get(0).getId());
//            for (PromotionPrice pp : pps) {
//                out.println("Extra orders: ");
//                for (PriceOrder po : pp.getExtraOrders()) {
//                    out.println(po.getItemPrice().getItem().getName());
//                    out.println(po.getItemPrice().getItemStatus().getName());
//                    out.println(po.getQuantity());
//                }
//                out.println("Discount orders: ");
//                for (DiscountOrder po : pp.getDiscountOrders()) {
//                    out.println(po.getItemPrice().getItem().getName());
//                    out.println(po.getItemPrice().getItemStatus().getName());
//                    out.println(po.getQuantity());
//                }
//            }
//            ItemGroup itemGroup = new ItemGroup();
//            itemGroup.setName("New Combo");
//            genericFacade.create(ItemGroup.class, itemGroup);
//            
//            Item item = genericFacade.find(Item.class, Long.parseLong("1"));
////            List<ItemGroup> gl = Lists.newArrayList();
////            gl.add(genericFacade.find(ItemGroup.class, Long.parseLong("1")));
////            item.setItemGroups(gl);
//            item.addGroup(genericFacade.find(ItemGroup.class, Long.parseLong("1")));
//            genericFacade.edit(Item.class, item);
            
//            ItemGroup ig = genericFacade.find(ItemGroup.class, Long.parseLong("1"));
//            ig.addItemPrice(genericFacade.find(ItemPrice.class, Long.parseLong("2")));
//            genericFacade.edit(ItemGroup.class, ig);
            
            // Test DateTime
            
//            DateTimeTest dt = new DateTimeTest();
//            dt.setCreated(new Date());
//            dt.setModified(new Date());
//            dt.setTimeField(new Time(5L * 60L * 60L * 1000L));
//            
//            genericFacade.create(DateTimeTest.class, dt);
            
//            PeriodicSchedule schedule = new PeriodicSchedule();
//            Date startTime = promotionSchedulerServiceImpl.addTimeToDate(new Date(System.currentTimeMillis()), 
//                    60000L);
//            schedule.setStartTime(startTime);
//            schedule.setEndTime(promotionSchedulerServiceImpl.addTimeToDate(new Date(System.currentTimeMillis()), 
//                    10000000L));
//            schedule.setType(PeriodicType.DAILY);
//            schedule.setPeriodicStartTime(promotionSchedulerServiceImpl.addTimeToDate(startTime, 
//                    40000L));
//            Promotion promotion = new Promotion();
//            promotion.setName("Test Scheduler promotion");
//            promotion.setPeriod(5000L);
//            promotion.setPeriodicSchedule(schedule);
//            genericFacade.create(Promotion.class, promotion);
            
            promotionScheduler.schedule(genericFacade.find(Promotion.class, Long.parseLong("50")));
//            promotionSchedulerServiceImpl.scheduleForPromotion(genericFacade.find(Promotion.class, Long.parseLong("49")));

            out.println("OK");
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
        try {
            processRequest(request, response);
        } catch (SchedulerException ex) {
            Logger.getLogger(TestBillingService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBillingService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SchedulerException ex) {
            Logger.getLogger(TestBillingService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBillingService.class.getName()).log(Level.SEVERE, null, ex);
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
