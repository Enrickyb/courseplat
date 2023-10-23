package com.courseplat.courseplat.controllers.TransactionControllers;

import com.courseplat.courseplat.domain.transactions.Category.Category;
import com.courseplat.courseplat.domain.transactions.Category.CategoryRepository;
import com.courseplat.courseplat.domain.transactions.Company.Company;
import com.courseplat.courseplat.domain.transactions.Company.CompanyDTO;
import com.courseplat.courseplat.domain.transactions.Company.CompanyRepository;
import com.courseplat.courseplat.domain.transactions.Category_Company.Category_CompanyRepository;
import com.courseplat.courseplat.domain.transactions.Category_Company.Category_Company;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transaction/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Category_CompanyRepository category_companyRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody @Valid CompanyDTO company) {
        try {
            Optional<Category> catOptional = categoryRepository.findById(company.category_id());

            if (catOptional.isPresent()) {
                Category cat = catOptional.get();

                Company compExist = companyRepository.findByName(company.name());
                if (compExist != null) {
                    return ResponseEntity.badRequest().body("Company already exists");
                }

                Company comp = companyRepository.save(new Company(company.name(), company.image()));
                Category_Company catcomp = category_companyRepository.save(new Category_Company(cat.getId(), comp.getId()));
                return ResponseEntity.ok().body("Company created successfully" + comp.toString() + " with category " + catcomp.toString());
            }

            return ResponseEntity.badRequest().body("Category does not exist");




        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }

}
