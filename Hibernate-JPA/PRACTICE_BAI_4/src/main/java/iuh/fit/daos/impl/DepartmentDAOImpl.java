package iuh.fit.daos.impl;

import iuh.fit.daos.DepartmentDAO;
import iuh.fit.models.Department;
import iuh.fit.utils.JPAUtil;

import java.util.List;

/**
 * Admin 4/9/2025
 **/
public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> listDepartmentsWithoutStudents() {
        try (var em = JPAUtil.getEntityManager()) {
            return em.createQuery("""
            SELECT DISTINCT d
            FROM Department d
            LEFT JOIN d.courses c
            LEFT JOIN c.studentGrades sg
            WHERE sg.student IS NULL
        """, Department.class).getResultList();
        }
    }
}
