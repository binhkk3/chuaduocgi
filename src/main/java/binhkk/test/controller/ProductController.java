package binhkk.test.controller;

import binhkk.test.model.Product;
import binhkk.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productImplService;

    @GetMapping("/index")
    public String showList(Model model) {
        Iterable<Product> productsList = productImplService.findAll();
        model.addAttribute("product", productsList);
        return "/create";
    }
}
