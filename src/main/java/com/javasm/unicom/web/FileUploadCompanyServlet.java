package com.javasm.unicom.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * @Author：
 * @Version：1.0
 * @Date：2022/5/12-19:26
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet("/fileUpload.do")
public class FileUploadCompanyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet( request, response );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        //判断提交方式是否正确
        Boolean flag = ServletFileUpload.isMultipartContent( request );
        //文件名
        String fileName = "";
        if (flag) {
            //获取文件流
            //实例化工厂对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //实例化servletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload( diskFileItemFactory );

            try {
                //将HttpServletRequest转化为List<FileItem>
                List<FileItem> list = servletFileUpload.parseRequest( request );
                //遍历文件
                for (FileItem fileItem : list) {
//                    System.out.println("文件名："+fileItem.getName());
//                    System.out.println("字段名："+fileItem.getFieldName());
//                    System.out.println("内容："+fileItem.getString());
//                    System.out.println("是否为普通字段："+fileItem.isFormField());

                    if (!fileItem.isFormField()) {

                        String projectPath = getServletContext().getRealPath( "/" );
                        //上传路径
                        String path = projectPath + "/img";
                        //文件名
                       fileName = new Date().getTime() + fileItem.getName();
                        fileName = fileItem.getName();
                        //创建一个空的文件
                        File newFile = new File( path + fileName );
                        //将fileItem复制到newFile
                        fileItem.write( newFile );

                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.setContentType( "text/plain;charset=utf-8" );
        PrintWriter out = response.getWriter();
        out.write( fileName );
        out.flush();
        out.close();
    }
}
