package com.project.MicroservicesSpringBoot.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/companies")
//public class CompanyController {
//
//    private CompanyService companyService;
//
//    public CompanyController(CompanyService companyService) {
//        this.companyService = companyService;
//    }
//
//    @GetMapping
//   public ResponseEntity<List<Company>> getAllCompanies(){
//        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
//   }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company ){
//        companyService.updateCompany(company, id);
//        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
//    }
//    @PostMapping(consumes = "application/json", produces = "application/json")
// public ResponseEntity<Company> createCompany(@RequestBody Company company){
//       Company created =  companyService.createCompany(company);
//
//        return new ResponseEntity<>(created, HttpStatus.CREATED);
// }

//    @RestController
//    @RequestMapping("/companies")
//    public class CompanyController {
//
//        private final CompanyService companyService;
//
//        public CompanyController(CompanyService companyService) {
//            this.companyService = companyService;
//        }
//
//        @PostMapping(consumes = "application/json", produces = "application/json")
//        public ResponseEntity<Company> createCompany(@RequestBody Company company) {
//            Company created = companyService.createCompany(company);
//            return new ResponseEntity<>(created, HttpStatus.CREATED);
//        }
//    }
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping // no need to explicitly add consumes unless overriding defaults
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = companyService.createCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}