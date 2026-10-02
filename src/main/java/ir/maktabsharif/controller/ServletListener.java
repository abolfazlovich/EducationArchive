package ir.maktabsharif.controller;

import ir.maktabsharif.repository.UsersRepository;
import ir.maktabsharif.repository.UsersRepositoryImpl;
import ir.maktabsharif.repository.VideoRepository;
import ir.maktabsharif.repository.VideoRepositoryImpl;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.service.UserServiceImpl;
import ir.maktabsharif.service.VideoService;
import ir.maktabsharif.service.VideoServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
        UsersRepositoryImpl usersRepository = new UsersRepositoryImpl();
        VideoService videoService = new VideoServiceImpl(videoRepository);
        UserService userService = new UserServiceImpl(usersRepository);
        sce.getServletContext().setAttribute("userService",userService);
        sce.getServletContext().setAttribute("videoService",videoService);
    }
}
