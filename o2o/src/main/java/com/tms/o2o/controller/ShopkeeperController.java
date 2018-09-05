package com.tms.o2o.controller;

import com.tms.o2o.common.Result;
import com.tms.o2o.entities.PersonInfo;
import com.tms.o2o.entities.Shop;
import com.tms.o2o.service.ShopService;
import com.tms.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

//店铺管理
@Controller
public class ShopkeeperController {

    @Autowired
    ShopService shopService;
    @Autowired
    UserService userService;

    //店家登陆验证
    @RequestMapping(value = "/shopkeeperlogin",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    @ResponseBody
    public Result usrLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session){
//        session.removeAttribute("shopkeeper");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PersonInfo user = userService.checkShopkeeper(username,password,1);
        Result rs = new Result();
        if (!Objects.isNull(user))
        {
            session.setAttribute("shopkeeper",user);
            rs.setCode(1);
            rs.setMsg("登陆成功！");
            rs.setData(user);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("用户名或密码错误！");
        }
        return rs;
    }








//    //获取所有的店铺信息
//    @RequestMapping("/getAllShop")
//    @ResponseBody
//    public List<Shop> getAllShop(){
//        return shopService.findAll();
//    }

}
