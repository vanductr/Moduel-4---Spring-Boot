package rikkei.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.entity.Product;
import rikkei.academy.service.IProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @GetMapping("/product-list")
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/product-list";
    }

    @GetMapping("/add-new-product")
    public String addNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add-new-product";
    }

    @PostMapping("/do-add-new-product")
    public String doAddNewProduct(Model model, @ModelAttribute Product product) {
        productService.save(product);
        model.addAttribute("product", new Product());
        model.addAttribute("message", "Đã thêm thành công 1 Sản phẩm mới");
        return "product/add-new-product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product/product-list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product/product-list";
    }
}
