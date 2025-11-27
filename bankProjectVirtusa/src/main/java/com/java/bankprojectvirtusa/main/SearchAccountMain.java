package com.java.bankprojectvirtusa.main;



import com.java.bankprojectvirtusa.dao.BankDao;
import com.java.bankprojectvirtusa.dao.BankDaoImpl;
import com.java.bankprojectvirtusa.model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {
  public static void main(String[] args) {
    BankDao bankDao = new BankDaoImpl();
    int accountNo;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter account no   ");
    accountNo = sc.nextInt();
    try {
      Accounts account = bankDao.searchAccount(accountNo);
      if (account != null) {
        System.out.println(account);
      } else {
        System.out.println("Account not found");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
