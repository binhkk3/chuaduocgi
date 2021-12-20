package binhkk.test.controller;

import binhkk.test.model.Product;
import binhkk.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productImplService;

    @GetMapping("/index")
    public String showList(Model model) {
        Iterable<Product> productsList = productImplService.findAll();
        model.addAttribute("products", productsList);
        return "/showList";
    }

    @GetMapping ("/add")
    public String showAdd() {
        return "/add";
    }

    @PostMapping("/add")
    public String saveProduct(Product product) {
        productImplService.save(product);
        return "redirect:/index";
    }
    @GetMapping("/edit")
    public String showEdit(@PathVariable Long id,Model model){
        Optional<Product> product =
        productImplService.findById(id);
        model.addAttribute("product",product.get());
        return "/edit";
    }
    @PostMapping("/edit")
    public String saveEditProduct(Product product){
        productImplService.save(product);
        return "redirect:/index";
    }
}
