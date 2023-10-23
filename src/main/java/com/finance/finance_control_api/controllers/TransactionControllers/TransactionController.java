package com.finance.finance_control_api.controllers.TransactionControllers;

import com.finance.finance_control_api.domain.transactions.Expense.Expense;
import com.finance.finance_control_api.domain.transactions.Income.Income;
import com.finance.finance_control_api.domain.transactions.Income.IncomeRepository;
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


    @PostMapping("/expense/create")
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {

        try {
            Expense exp = ExpenseRepository.save(new Expense(expense.getTitle(), expense.getDescription(), expense.getUser_id(), expense.getCompany_id(), expense.getValue(), expense.getDate()));
            return ResponseEntity.status(HttpStatus.OK).body("Expense created successfully" + exp.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/expense/all")
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(ExpenseRepository.findAll());
    }

    @GetMapping("/income/all")
    public ResponseEntity<List<Income>> getIncomes() {
        return ResponseEntity.status(HttpStatus.OK).body(IncomeRepository.findAll());
    }

    //get all transactions
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







}
