package com.finance.finance_control_api.domain.transactions.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String>  {


    List<Expense> findByUserId(String user_id);





}
