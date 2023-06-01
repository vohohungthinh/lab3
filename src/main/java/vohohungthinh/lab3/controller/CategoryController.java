package vohohungthinh.lab3.controller;

import vohohungthinh.lab3.entity.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vohohungthinh.lab3.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories    = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());

        return "Category/add";
    }
    @PostMapping("/add")
    public  String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){

            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model) {
        Category editCategory = categoryService.getCategoryById(id);
        if (editCategory != null) {
            model.addAttribute("category", editCategory);
            return "category/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editCategory( @ModelAttribute("category") Category updatedCategory) {
        categoryService.updateCategory(updatedCategory);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public  String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
