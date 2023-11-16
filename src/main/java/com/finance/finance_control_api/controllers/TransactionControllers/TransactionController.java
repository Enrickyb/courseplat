package com.finance.finance_control_api.controllers.TransactionControllers;

import com.finance.finance_control_api.domain.transactions.Expense.Expense;
import com.finance.finance_control_api.domain.transactions.Income.Income;
import com.finance.finance_control_api.domain.transactions.Income.IncomeRepository;
import com.finance.finance_control_api.domain.user.User;
import com.finance.finance_control_api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.finance.finance_control_api.domain.transactions.Expense.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ExpenseRepository ExpenseRepository;

    @Autowired
    private IncomeRepository IncomeRepository;

    @Autowired
    private UserRepository UserRepository;


    @PostMapping("/expense/create")
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {

        try {
            Expense exp = ExpenseRepository.save(new Expense(expense.getTitle(), expense.getDescription(), expense.getUserId(), expense.getCompany_id(), expense.getValue(), expense.getDate()));
            return ResponseEntity.status(HttpStatus.OK).body("Expense created successfully" + exp.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/expense/all")
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(ExpenseRepository.findAll());
    }

    @GetMapping("/expense/get/{id}")
    public ResponseEntity<?> getExpense(@PathVariable String id) {
        try{

           return ResponseEntity.ok().body(ExpenseRepository.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/expense/user/{id}")
    public ResponseEntity<?> getExpenseByUser(@PathVariable String id) {
        try{

            User userExists = UserRepository.findById(id).orElseThrow(() -> new Exception("User not found"));



            return ResponseEntity.ok().body(ExpenseRepository.findByUserId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity<?> getTransactions() {
        try {
            List<Income> incomes = IncomeRepository.findAll();
            List<Expense> expenses = ExpenseRepository.findAll();

            List<Object> transactions = new ArrayList<>();
            transactions.addAll(incomes);
            transactions.addAll(expenses);

            return ResponseEntity.status(HttpStatus.OK).body(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


    @PostMapping("/income/create")
    public ResponseEntity<?> createIncome(@RequestBody Income income) {

        try {
            Income inc = IncomeRepository.save(new Income(income.getTitle(), income.getDescription(), income.getUser_id(), income.getValue(), income.getDate()));
            return ResponseEntity.status(HttpStatus.OK).body("Income created successfully" + inc.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/income/all")
    public ResponseEntity<List<Income>> getIncomes() {
        return ResponseEntity.status(HttpStatus.OK).body(IncomeRepository.findAll());
    }


    @GetMapping("/income/{id}")
    public ResponseEntity<?> getIncome(@PathVariable String id) {
        try{
            return ResponseEntity.ok().body(IncomeRepository.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }









}
