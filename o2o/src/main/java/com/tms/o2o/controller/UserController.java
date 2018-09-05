package com.tms.o2o.controller;

import com.tms.o2o.common.Result;
import com.tms.o2o.entities.PersonInfo;
import com.tms.o2o.entities.Shop;
import com.tms.o2o.service.ShopService;
import com.tms.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

//用户控制层
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ShopService shopService;

    //登陆验证
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    @ResponseBody
    public Result usrLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //销毁session
        //session.invalidate();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PersonInfo user = userService.checkuser(username,password);
        Result rs = new Result();
        if (!Objects.isNull(user))
        {
            session.setAttribute("my",user);
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

    //通过parentCategoryId查看选到的商店信息（查大类）
    @RequestMapping(value = "/selectShopBig",method = RequestMethod.POST)
    @ResponseBody
    private Result selectShopBig (HttpServletRequest request, HttpServletResponse response)
    {
        int parentCategoryId = Integer.parseInt(request.getParameter("parentCategoryId"));
        List<Shop> shops = shopService.findBig(parentCategoryId);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到数据！");
            rs.setData(shops);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到数据！");
        }
        return rs;
    }

    //通过parentCategoryId、shopCategoryId查看选到的商店信息（查小类）
    @RequestMapping(value = "/selectShopSmall",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    @ResponseBody
    private Result selectShopSmall (HttpServletRequest request, HttpServletResponse response)
    {
        int parentCategoryId = Integer.parseInt(request.getParameter("parentCategoryId"));
        int shopCategoryId = Integer.parseInt(request.getParameter("shopCategoryId"));
        List<Shop> shops = shopService.findSmall(parentCategoryId,shopCategoryId);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到数据！");
            rs.setData(shops);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到数据！");
        }
        return rs;
    }


}
