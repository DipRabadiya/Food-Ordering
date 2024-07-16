package com.BiteBeat.Controller;

import com.BiteBeat.Model.Category;
import com.BiteBeat.Model.User;
import com.BiteBeat.Service.CategoryService;
import com.BiteBeat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Category category1 = categoryService.createCategory(category.getName(), user.getId());

        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Category> category1 = categoryService.findCategoryByRestaurantId(user.getId());

        return new ResponseEntity<>(category1, HttpStatus.OK);
    }
}


