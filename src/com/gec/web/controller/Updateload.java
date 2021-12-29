package com.gec.web.controller;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateload")
public class Updateload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        diskFileItemFactory.setRepository(new File("F:\\"));
        diskFileItemFactory.setSizeThreshold(1024 * 1024 * 100);

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setHeaderEncoding("UTF-8");
        upload.setFileSizeMax(1024 * 1024 * 100);
        upload.setSizeMax(1024 * 1024 * 100);

        File file = new File("F:\\","updateDodown");

        if (!file.exists()) file.mkdir();

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem item : fileItems) {
                File files = new File(file.getPath(),item.getName());
                item.write(files);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
