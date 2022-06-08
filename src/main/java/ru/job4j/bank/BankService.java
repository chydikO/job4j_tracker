package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (findByRequisite(passport, account.getRequisite()) == null) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        Set<User> usersSet = users.keySet();
        for (User user : usersSet) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        for (Account account: accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcUserAccount = findByRequisite(srcPassport, srcRequisite);
        Account destUserAccount = findByRequisite(destPassport, destRequisite);
        User destUser = findByPassport(destPassport);

        if (users.get(destUser).contains(destUserAccount)
                && amount <= srcUserAccount.getBalance()) {
            srcUserAccount.setBalance(srcUserAccount.getBalance() - amount);
            destUserAccount.setBalance(destUserAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}
