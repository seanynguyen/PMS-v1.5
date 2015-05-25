package com.youngidea.pms.core.api.rest.service.impl;

import com.youngidea.pms.core.api.rest.service.FileManagementService;

/**
 * Created by sean on 5/20/15.
 */
public class FileManagementServiceImpl implements FileManagementService {

//    @POST
//    @Path("/upload")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
////    @Produces("image/jpg")
//    public Response uploadImage(@org.glassfish.jersey.media.multipart.FormDataParam("file") InputStream uploadedInputStream,
//                                @org.glassfish.jersey.media.multipart.FormDataParam("file") org.glassfish.jersey.media.multipart.FormDataContentDisposition fileDetail) {
//        // To be updated in the future if there are more mediaType to be uploaded. For now, I just use for image uploading.
//        String uploadedFileLocation = propertiesRetriever.getProp("file.path.image") + fileDetail.getFileName();
//        UploadHelper.writeToFile(uploadedInputStream, uploadedFileLocation);
//        // to be update in the future
//        UploadInfo uploadInfo = new UploadInfo();
//        uploadInfo.setMessage(UPLOAD_SUCCESSFUL_MESSAGE);
//        uploadInfo.setName(fileDetail.getFileName());
//        uploadInfo.setUrl(uploadedFileLocation);
//
//        return Response.status(200).entity(uploadInfo).build();
//    }
//
//    private class UploadInfo {
//        private String message;
//        private String name;
//        private String url;
//
//        public String getMessage() {
//            return this.message;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//        public String getUrl() {
//            return this.url;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//    }
//
//    @GET
//    @Path("/image/{fileName}")
//    @Produces({"image/jpg", "image/png"})
//    public StreamingOutput getImage(@PathParam("fileName") String name) {
//        String imageURL = propertiesRetriever.getProp("file.path.image") + name;
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
//    // In the future, I use this one to categorize file base one their extension.
//    private String getFileLocation(@org.glassfish.jersey.media.multipart.FormDataParam("file")
//                                   org.glassfish.jersey.media.multipart.FormDataContentDisposition fileDetail) {
//        com.google.common.net.MediaType typeEnum = com.google.common.net.MediaType.parse(fileDetail.getType());
//        if (typeEnum.equals(com.google.common.net.MediaType.JPEG) ||
//                typeEnum.equals(com.google.common.net.MediaType.PNG) ||
//                typeEnum.equals(com.google.common.net.MediaType.GIF)) {
//            return propertiesRetriever.getProp("file.path.image");
//        } else {
//            return propertiesRetriever.getProp("file.path");
//        }
//    }
//
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
//    }
}
