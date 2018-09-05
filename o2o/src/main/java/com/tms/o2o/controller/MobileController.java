package com.tms.o2o.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tms.o2o.common.Result;
import com.tms.o2o.entities.*;
import com.tms.o2o.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Objects;

//主控制器
@Controller
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    ShopService shopService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductImgService productImgService;
    @Autowired
    AreaService areaService;
    @Autowired
    ShopCategoryService shopCategoryService;


    @Autowired
    DefaultKaptcha defaultKaptcha;
    //主界面
    @RequestMapping("/index")
    public  String index(){

        return "/mobile/index";
    }

    //查看商品界面
    @RequestMapping("/about")
    public  String about(HttpServletRequest request, HttpServletResponse response, Model model){

        //取得商品编号
        int productId = Integer.parseInt(request.getParameter("productId"));
        //查询商品信息
        Product theproduct = productService.findOne(productId);
        //返回该店铺信息
        Result rs = new Result();
        if (!Objects.isNull(theproduct))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(theproduct);
            model.addAttribute("theproduct",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到该店铺！");
            model.addAttribute("theproduct",rs);
        }

        //查询该商品所有图片
        List<ProductImg> productImgs = productImgService.finOneProduct(productId);
        //返回商品图片信息
        Result rs2 = new Result();
        if (!Objects.isNull(productImgs))
        {
            rs2.setCode(1);
            rs2.setMsg("查询到商品！");
            rs2.setData(productImgs);
            model.addAttribute("productImgs",rs2);
        }
        else {
            rs2.setCode(-1);
            rs2.setMsg("没有查询到商品！");
            model.addAttribute("productImgs",rs2);
        }
        return "/mobile/about";
    }

    //登陆
    @RequestMapping("/login")
    public  String login(){
        return "/mobile/login";
    }

    //注册
    @RequestMapping("/register")
    public  String register(Model model){

        List<Area> areas = areaService.findall();
        List<ShopCategory> shopCategories = shopCategoryService.findall();

        model.addAttribute("areas",areas);
        model.addAttribute("shopCategories",shopCategories);

        return "/mobile/register";
    }

    //二手市场
    @RequestMapping("/SecondhandMarket")
    public  String SecondhandMarket(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Shop> shops = shopService.findBig(10);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/SecondhandMarket";
    }

    //美容美发
    @RequestMapping("/cosmetology")
    public  String cosmetology(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Shop> shops = shopService.findBig(11);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/cosmetology";
    }

    //美食饮品
    @RequestMapping("/foodordrink")
    public  String foodordrink(HttpServletRequest request, HttpServletResponse response, Model model){

        List<Shop> shops = shopService.findBig(12);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/foodordrink";
    }

    //休闲娱乐
    @RequestMapping("/fun")
    public  String fun(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Shop> shops = shopService.findBig(13);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/fun";
    }

    //培训教育
    @RequestMapping("/edu")
    public  String edu(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Shop> shops = shopService.findBig(27);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/edu";
    }

    //租赁市场
    @RequestMapping("/rentalmarket")
    public  String rentalmarket(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Shop> shops = shopService.findBig(28);
        Result rs = new Result();
        if (!Objects.isNull(shops))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shops);
            model.addAttribute("rs",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到相关店铺！");
            model.addAttribute("rs",rs);
        }
        return "/mobile/rentalmarket";
    }

    //进入商店
    @RequestMapping("/intoshop")
    public  String intoshop(HttpServletRequest request, HttpServletResponse response, Model model){
        int shopId = Integer.parseInt(request.getParameter("shopId"));
        //查询店铺信息
        Shop theshop = shopService.findOne(shopId);
        //返回该店铺信息
        Result rs = new Result();
        if (!Objects.isNull(theshop))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(theshop);
            model.addAttribute("theshop",rs);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到该店铺！");
            model.addAttribute("theshop",rs);
        }

        //通过shopId查询所有商品
        List<Product> products = productService.finAllProduct(shopId);
        //返回商品信息
        Result rs2 = new Result();
        if (!Objects.isNull(products))
        {
            rs2.setCode(1);
            rs2.setMsg("查询到商品！");
            rs2.setData(products);
            model.addAttribute("rsp",rs2);
        }
        else {
            rs2.setCode(-1);
            rs2.setMsg("没有查询到商品！");
            model.addAttribute("rsp",rs2);
        }
        return "/mobile/intoshop";
    }

    //店家登陆界面
    @RequestMapping("/shopkeeperlogin")
    public String shopkeeperlogin(){
        return "/mobile/shopkeeperlogin";
    }

    //进入店家管理页面
    @RequestMapping("/shopkeeperindex")
    public String shopkeeperindex(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){
        //取得店家信息
        PersonInfo user = (PersonInfo) session.getAttribute("shopkeeper");
        int userId = user.getUserId();
        List<Shop> shops = shopService.findShops(userId);
        //设置查询到的商店列表
        model.addAttribute("shops",shops);

        return "/mobile/shopkeeperindex";
    }

    //店铺管理选项界面
    @RequestMapping("/shopmanagement")
    public String shopmanagement(HttpServletRequest request,HttpServletResponse response,Model model){
        String shopId = request.getParameter("shopId");
        model.addAttribute("shopId",shopId);
        return "/mobile/shopmanagement";
    }

    //店铺信息界面
    @RequestMapping("/shopinfo")
    public String shopinfo(HttpServletRequest request,HttpServletResponse response,Model model){
        //先获取要显示的商店Id
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));

        //获取店铺信息
        Shop shopinfo = shopService.findOne(shopId);

        Result rs = new Result();
        if (!Objects.isNull(shopinfo))
        {
            rs.setCode(1);
            rs.setMsg("查询到店铺信息！");
            rs.setData(shopinfo);
            model.addAttribute("shopinfo",rs);

            //获取区域信息
            Area areainfo = areaService.findone(shopinfo.getAreaId());
            model.addAttribute("areainfo",areainfo);
            //获取店铺类型信息
            ShopCategory shopCategoryinfo = shopCategoryService.finone(shopinfo.getShopCategoryId());
            model.addAttribute("shopCategoryinfo",shopCategoryinfo);
        }
        else {
            rs.setCode(-1);
            rs.setMsg("没有查询到该店铺！");
            model.addAttribute("shopinfo",rs);
        }

        return "/mobile/shopinfo";
    }


    //验证码
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
