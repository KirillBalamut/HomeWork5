package org.example;

import java.time.LocalDate;

public class Homework5 {
    public static void main(String[] args) {
        // Тестирование класса Account
        Account account = new Account();
        account.put(10);
        System.out.println(account.getAmount()); // Ожидаемый результат: 10.0

        // Тестирование класса CreditAccount
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.put(100);
        creditAccount.take(50);
        System.out.println(creditAccount.getAmount()); // Ожидаемый результат: 50.5

        // Тестирование класса DepositAccount
        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(100);
        depositAccount.take(50);
        System.out.println(depositAccount.getAmount()); // Ожидаемый результат: 100.0

        depositAccount.setLastWithdrawalDate(LocalDate.now().minusDays(31)); // Установка даты последнего снятия более месяца назад
        depositAccount.take(50);
        System.out.println(depositAccount.getAmount()); // Ожидаемый результат: 50.0
    }
}
