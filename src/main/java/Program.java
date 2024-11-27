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

                 session.persist(department);  //Hibernate sẽ tạo câu lệnh SQL INSERT để thêm thông tin của đối tượng department vào bảng tương ứng trong cơ sở dữ liệu.

                });
            factory.inTransaction(session -> {
                var department = new Department();
                department.setName("Bảo vệ");

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

 //find by id
 factory.inTransaction(session -> {
     var department = session.get(Department.class, 1); // ví dụ lấy ra phng ban với id = 1
     System.out.println("department = " + department);
 });
 
 //find by name
            
            factory.inTransaction(session -> {
               var hql = "FROM Department WHERE name = :name";
               var department = session.createSelectionQuery(hql, Department.class)
                       .setParameter("name","Bảo vệ")
                       .uniqueResult();
                System.out.println("departments = " + department);
            });

  //Update
  factory.inTransaction(session -> {
      var department = session.get(Department.class, 2);
      department.setName("kinh doanh");
      session.merge(department); // lenh update
  })  ;

  //delete
            factory.inTransaction(session -> {
                var department = session.get(Department.class, 1); // lấy ra phòng ban (VD phòng ban với id = 1)
                session.remove(department); // xóa 1 đối tượng
            });
        }
    }
}
