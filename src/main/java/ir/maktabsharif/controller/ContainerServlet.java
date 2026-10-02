package ir.maktabsharif.controller;

import ir.maktabsharif.model.Video;
import ir.maktabsharif.service.VideoServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "containerServlet" , value = "/containerServlet")
public class ContainerServlet extends HttpServlet {
    private VideoServiceImpl videoService;
    public void init( ) throws ServletException {
        videoService = (VideoServiceImpl) getServletContext().getAttribute("videoService");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String title = req.getParameter("title");
String description = req.getParameter("description");
String filePath = req.getParameter("filePath");
Long fileSize = Long.valueOf(req.getParameter("fileSize"));
String price = req.getParameter("price");
String uploader = req.getParameter("uploader");
        Video video = new Video(title,description,filePath,fileSize,price);
        videoService.persist(video);
    }


}
