package binhkk.test.controller;

import binhkk.test.model.Customer;
import binhkk.test.model.Product;
import binhkk.test.service.ICustomerService;
import binhkk.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productImplService;
    @Autowired
    private ICustomerService iCustomerImplService;
    @ModelAttribute("customer")
    public Iterable<Customer> customers(){
        return iCustomerImplService.findAll();
    }

    @GetMapping("/index")
    public String showList(Model model, String key,String key2) {
       // List<Product> productList;
        if(key==null){
            if(key2 == null){
                Iterable<Product> productsList = productImplService.findAll();
                model.addAttribute("products", productsList);
                return "/Product/showList";
            }else {
                Iterable<Product> productsList = productImplService.findAllByOrderByPriceAsc();
                model.addAttribute("products", productsList);
                return "/Product/showList";
            }

        }
        else {
            Iterable<Product> productsList = productImplService.findByNameContaining(key);
            model.addAttribute("products", productsList);
            return "/Product/showList";
        }

    }

    @GetMapping ("/add")
    public String showAdd() {
        return "/Product/add";
    }

    @PostMapping("/add")
    public String saveProduct(Product product ,Long customerId) {
        Optional<Customer> customerOptional = iCustomerImplService.findById(customerId);
        product.setCustomer(customerOptional.get());
        productImplService.save(product);
        return "redirect:/index";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id,Model model){
        Optional<Product> product = productImplService.findById(id);
        model.addAttribute("product",product.get());
        return "/Product/edit";
    }
    @PostMapping("/edit")
    public String saveEditProduct(Product product,Long  customerId){
        Optional<Customer> customerOptional = iCustomerImplService.findById(customerId);
        product.setCustomer(customerOptional.get());
        productImplService.save(product);
        return "redirect:/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productImplService.remove(id);
        return "redirect:/index";
    }


}
