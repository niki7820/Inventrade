package com.inventrade.inventrade.controller;

import com.inventrade.inventrade.entity.Product;
import com.inventrade.inventrade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ITController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }


//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        // Principal contains logged-in user info
        String username = principal != null ? principal.getName() : "Guest";
        model.addAttribute("username", username);
        return "dashboard";
    }


    @GetMapping("/products/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList"; // full page
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product()); // important
        return "productAdd"; // your template name
    }


    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        model.addAttribute("products", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        model.addAttribute("product", product);

        // return the same add/edit form fragment
        return "productAdd :: productForm"; // <-- fragment ID inside productAdd.html
    }



    @PostMapping("/products/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }



}
