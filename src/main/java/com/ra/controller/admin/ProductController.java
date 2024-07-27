package com.ra.controller.admin;


import com.ra.models.Category;
import com.ra.models.Product;
import com.ra.services.CategoryService;
import com.ra.services.ProductService;
import com.ra.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductService productService;


    @RequestMapping("/product")
    public String index(Model model) {
        List<Product> listCategory = this.productService.getAll();
        model.addAttribute("listCategory", listCategory);
        return "admin/product/index";

    }
    @RequestMapping("/product-add")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> listCate= this.categoryService.getAll();
        model.addAttribute("listCate", listCate);
        return "admin/product/add";

    }

    @PostMapping("/product-add")
    public String save (@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file){
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if (this.productService.create(product)){
            return "redirect:/admin/product";
        }
        return "admin/product/add";

    }
    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "admin/product/edit";
    }
    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable("id") Integer id){
        if (this.productService.delete(id)){
            return "redirect:/admin/product";
        }else
        return "redirect:/admin/product";
    }

}
