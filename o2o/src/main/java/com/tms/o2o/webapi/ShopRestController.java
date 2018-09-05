package com.tms.o2o.webapi;

import com.tms.o2o.common.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/webapi/shop")
public class ShopRestController {

    @RequestMapping("/register")
    public boolean register(HttpSession httpSession,
                          @RequestParam("userName") String userName,
                            @RequestParam("password")   String password,
                            @RequestParam("verifyCode") String verifyCode){

        String wantCode=(String)httpSession.getAttribute("vrifyCode");
        if(verifyCode.equals(wantCode))
            return true;

        return false;

    }

    //处理文件上传
    @RequestMapping(value="/testuploadimg",method = RequestMethod.POST)
    public  String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }
}
