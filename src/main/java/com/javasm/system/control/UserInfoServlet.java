package com.javasm.system.control;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.SetPwdInfo;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.service.UserService;
import com.javasm.system.service.implement.UserServiceImpl;
import com.javasm.util.BaseUtil;
import com.javasm.util.DataUtil;
import lombok.Data;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:38
 * @description:
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends BaseServlet<UserInfo> {
    UserService userService = new UserServiceImpl();

    /**
     * 请求用户显示信息
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserInfoVo(HttpServletRequest req) {
        UserInfo login = (UserInfo) req.getSession().getAttribute("login");
        UserInfoVo userInfoVo = userService.showUserInfo(login.getUserId());
        if (userInfoVo == null) {
            return "-1";
        }
        return JSON.toJSONString(userInfoVo);
    }

    /**
     * 请求设置用户当前数据
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUserInfo(HttpServletRequest req) {
        UserInfo login = (UserInfo) req.getSession().getAttribute("login");
        SetUserInfo setUserInfo = userService.getSetUserInfo(login);
        if (setUserInfo == null) {
            return "-1";
        }
        return JSON.toJSONString(setUserInfo);
    }

    /**
     * 请求设置用户数据
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUser(HttpServletRequest req) {
        SetUserInfo setUserInfo = BaseUtil.readBean(req, SetUserInfo.class);
        Integer integer = userService.updateUserInfo(setUserInfo);
        //判断是否成功,成功
        if (integer > 0) {
            UserInfo u = (UserInfo) req.getSession().getAttribute("login");
            updateLogin(u, setUserInfo);
            UserInfoVo userInfoVo = userService.showUserInfo(u.getUserId());
            return JSON.toJSONString(userInfoVo);
        } else {
            return "-1";
        }

    }

    /**
     * 请求或设置密码
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetPwd(HttpServletRequest req) {
        SetPwdInfo setPwdInfo = BaseUtil.readBean(req, SetPwdInfo.class);
        if (setPwdInfo.getNewPwd() == null || setPwdInfo.getOldPwd() == null) {
            return "-1";
        }
        setPwdInfo.setOldPwd(Base64.encode(setPwdInfo.getOldPwd()));
        setPwdInfo.setNewPwd(Base64.encode(setPwdInfo.getNewPwd()));
        UserInfo userInfo = (UserInfo) req.getSession().getAttribute("login");
        if (!userInfo.getUserPwd().equals(setPwdInfo.getOldPwd())) {
            return "-1";
        }
        Integer i = userService.setPwd(userInfo.getUserId(), setPwdInfo.getNewPwd());
        if (i > 0) {
            userInfo.setUserPwd(setPwdInfo.getNewPwd());
            return "1";
        }
        return "-1";
    }

    /**
     * 处理上传头像
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUpload(HttpServletRequest req) {
        String id = req.getParameter("id");
        Integer userId = DataUtil.stringConvertToInteger(id);
        File file = null;
        String uploadPath = null;
        if (userId == null || userId < 1) {
            return "-1";
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    uploadPath = "./img/" + new Date().getTime() + "-" + fileItem.getName();
                    file = new File(uploadPath);
                    fileItem.write(file);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (uploadPath == null || uploadPath.equals("")) {
            return "-1";
        }
        req.getSession().setAttribute("uploadId", userId);
        req.getSession().setAttribute("uploadPath", uploadPath);
        return file.getAbsolutePath();
    }

    public String reqSaveImage(HttpServletRequest req) {
        Integer userId = (Integer) req.getSession().getAttribute("uploadId");
        String uploadPath = (String) req.getSession().getAttribute("uploadPath");
        if (userId == null || uploadPath == null || userId < 0 || uploadPath.equals("")) {
            return "-1";
        }
        String code = req.getParameter("code");
        if (code.equals("1")) {
            Integer i = userService.saveImage(userId, uploadPath);
            if (i > 0) {
                return "1";
            }
        } else if (code.equals("-1")) {
            File file = new File(uploadPath);
            boolean delete = file.delete();
            if (delete) {
                return "1";
            }
        }
        return "-1";
    }


    private void updateLogin(UserInfo u, SetUserInfo setUserInfo) {
        u.setUserName(setUserInfo.getUserName());
        u.setDes(setUserInfo.getDes());
        u.setSex(setUserInfo.getSex());
        u.setBirthday(setUserInfo.getBirthday());
        u.setAvatarColor(setUserInfo.getAvatarColor());
        u.setPhone(setUserInfo.getPhone());
        u.setRoleId(setUserInfo.getRoles().getNowRole().getRoleId());
    }
}
