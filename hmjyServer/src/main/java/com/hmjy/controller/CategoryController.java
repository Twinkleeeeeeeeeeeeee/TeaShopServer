package com.hmjy.controller;
 
import com.hmjy.pojo.Category;
import com.hmjy.service.CategoryService;
import com.hmjy.util.ImageUtil;
import com.hmjy.util.Page;
import com.hmjy.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
 
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
  
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        List<Category> cs= categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("total",total);
        return "admin/listCategory";
    }
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploaded){
        categoryService.add(c);
        File imageFolder =new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            uploaded.getImage().transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin_category_list";
    }
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session){
        categoryService.delete(id);
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        if(file.exists()) {
            file.delete();
        }
        return "redirect:/admin_category_list";
    }
    @RequestMapping("admin_category_edit")
    public String get(int id,Model model){
        Category category = categoryService.get(id);
        model.addAttribute("c",category);
        return "admin/editCategory";
    }



}