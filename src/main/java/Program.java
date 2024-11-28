import entity.Department;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.hibernateUtil;

import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        try(var factory = hibernateUtil.buildSessionFactory()) {
            factory.inTransaction(session -> {
                var department = new Department();
                 department.setName("Gíam Đốc");
department.setType(Department.Type.DEVELOPER);
                 session.persist(department);  //Hibernate sẽ tạo câu lệnh SQL INSERT để thêm thông tin của đối tượng department vào bảng tương ứng trong cơ sở dữ liệu.

                });
            factory.inTransaction(session -> {
                var department = new Department();
                department.setName("Bảo vệ");
                department.setType(Department.Type.TESTER);
                session.persist(department);  //Hibernate sẽ tạo câu lệnh SQL INSERT để thêm thông tin của đối tượng department vào bảng tương ứng trong cơ sở dữ liệu.

            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM Department";
    var departments = session.createSelectionQuery(hql, Department.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (Department department : departments) {
         System.out.println("department = " + department); // lệnh gõ nhanh : department.soutv
     }

 });



        }
    }
}
