package iuh.fit;

import iuh.fit.daos.PersonDAO;
import iuh.fit.utils.JPAUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 2/11/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PersonDAO.getAll().forEach(System.out::println);

        JPAUtil.close();
    }
}