/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.item;

import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.core.converter.ItemConverter;
import com.youngidea.pms.core.entity.item.Category;
import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.entity.item.ItemStatus;
import com.youngidea.pms.core.entity.item.Item;

import javax.ejb.EJB;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author sean
 */
@Path("/item")
public class ItemServiceREST extends CRUIDServiceREST<Item, ItemRequestModel, ItemResponseModel> {

    @EJB
    protected ItemConverter itemConverter;

    public ItemServiceREST() {
        super(ItemRequestModel.class, ItemResponseModel.class, Item.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"}) // create then add prices
    @Override
    public Response create(ItemRequestModel itemRequestModel) {
        Item item = null;
        if (!itemRequestModel.getItemPrices().isEmpty()) {
            item = addPrices(new Item(), itemRequestModel.getItemPrices());
        }
        super.facade.create(itemConverter.convertBack(itemRequestModel, item));
        return Response.status(Response.Status.CREATED).
                entity(itemRequestModel).build();
    }

    private Item addPrices(Item item, List<ItemPriceRequestModel> itemPriceModels) {
        for (ItemPriceRequestModel priceBean : itemPriceModels) {
            ItemStatus status = genericFacade.find(ItemStatus.class, priceBean.getStatusId());
            item.addPrice(new ItemPrice(status, priceBean.getPrice()));
        }
        return item;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    @Override
    public Response edit(ItemRequestModel itemRequestModel, @PathParam("id") Long id) {
        clearItemPrices(itemRequestModel.getId());
        for (ItemPriceRequestModel priceBean : itemRequestModel.getItemPrices()) {
            addItemPrice(itemRequestModel.getId(), priceBean);
        }
        super.facade.edit(itemConverter.convertBack(itemRequestModel,
                super.facade.find(itemRequestModel.getId())));
        return Response.status(Response.Status.OK).
                entity(itemRequestModel).build();
    }

    @POST
    @Path("{itemId}/price")
    @Consumes({"application/xml", "application/json"})
    public Response addItemPrice(@PathParam("itemId") Long itemId, ItemPriceRequestModel itemPriceBean) {
        Item item = super.facade.find(itemId);
        ItemPrice itemPrice = new ItemPrice(super.genericFacade.find(ItemStatus.class, itemPriceBean.getStatusId()),
                itemPriceBean.getPrice());
        super.genericFacade.create(ItemPrice.class, itemPrice);
        item.addPrice(itemPrice);
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @DELETE
    @Path("{itemId}/price")
    @Produces({"application/xml", "application/json"})
    public Response clearItemPrices(@PathParam("itemId") Long itemId) throws ValidationException {
        Item item = super.facade.find(itemId);
        for (ItemPrice itemPrice : item.getItemPrices()) {
            super.genericFacade.remove(ItemPrice.class, itemPrice);
        }
        item.clearPrices();
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @DELETE
    @Path("{itemId}/price/{itemPriceId}")
    public Response removeItemPrice(@PathParam("itemId") Long itemId, @PathParam("itemPriceId") Long itemPriceId) throws ValidationException {
        Item item = super.facade.find(itemId);
        ItemPrice tobeRemoved = super.genericFacade.find(ItemPrice.class, itemPriceId);
        item.removePrice(tobeRemoved); //  
        super.genericFacade.remove(ItemPrice.class, tobeRemoved); // remove from database, avoid reload after reploy app
        super.facade.edit(item); // 
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @GET
    @Path("{itemId}/category/{categoryId}")
    public Response setCategory(@PathParam("itemId") Long itemId, @PathParam("categoryId") Long categoryId) throws ValidationException {
        Item item = super.facade.find(itemId);
        item.setCategory(super.genericFacade.find(Category.class, categoryId));
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

//    @POST
//    @Consumes({"application/xml", "application/json"})
//    @Path("/testValidation")
//    public Response testValidation(@Valid Person item) {
////        dao.create(getConverter().convertBack(model, null));
//        return Response.status(Response.Status.CREATED).
//                entity(item).build();
//    }

    @Override
    protected ItemConverter getConverter() {
        return itemConverter;
    }

//    @GET
//    @Path("/image/{fileName}")
//    @Produces({"image/jpg", "image/png"})
//    public StreamingOutput getImage(@PathParam("fileName") String name) {
//        String imageURL = FILE_PATH + name;
//        System.out.println(imageURL);
//        if (imageURL == null) {
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//        }
//        if (!imageURL.endsWith(".jpg")) {
//            imageURL = imageURL + ".jpg";
//        }
//        File image = new File(imageURL);
//        if (!image.exists()) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
//        }
//        return new FileStreamingOutput(image);
//    }
//
//    @POST
//    @Path("/image/upload/")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
////    @Produces("image/jpg")
//    public Response uploadFile(@org.glassfish.jersey.media.multipart.FormDataParam("file") InputStream uploadedInputStream,
//            @org.glassfish.jersey.media.multipart.FormDataParam("file") org.glassfish.jersey.media.multipart.FormDataContentDisposition fileDetail) {
//        String uploadedFileLocation = FILE_PATH + fileDetail.getFileName();
//        UploadHelper.writeToFile(uploadedInputStream, uploadedFileLocation);
//        System.out.println("Image name : " + fileDetail.getFileName() + " -------------------");
//        return Response.status(200).entity(uploadedFileLocation).build();
//    }
    
//    private class FileStreamingOutput implements StreamingOutput {
//
//        private File file;
//
//        public FileStreamingOutput(File file) {
//            this.file = file;
//        }
//
//        @Override
//        public void write(OutputStream output)
//                throws IOException, WebApplicationException {
//            FileInputStream input = new FileInputStream(file);
//            try {
//                int bytes;
//                while ((bytes = input.read()) != -1) {
//                    output.write(bytes);
//                }
//            } catch (Exception e) {
//                throw new WebApplicationException(e);
//            } finally {
//                if (output != null) {
//                    output.close();
//                }
//                if (input != null) {
//                    input.close();
//                }
//            }
//        }
//
//    }
}
