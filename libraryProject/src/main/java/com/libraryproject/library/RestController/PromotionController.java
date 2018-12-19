package com.libraryproject.library.RestController;


import com.libraryproject.library.Model.Book;
import com.libraryproject.library.Model.Promotion;
import com.libraryproject.library.Repository.AuthorRepository;
import com.libraryproject.library.Repository.BookCategoryRepository;
import com.libraryproject.library.Repository.PromotionRepository;
import com.libraryproject.library.ServiceLayer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PromotionController {

     @Autowired
    private PromotionRepository promotionRepository;


    @RequestMapping(value = "/promotion/all" ,method = RequestMethod.GET)
     public ResponseEntity getPromotion() {
        List<Promotion> promotions = promotionRepository.findAll();
        return new ResponseEntity(promotions, HttpStatus.OK);
    }


}
