import entity.Account;
import entity.Group;
import entity.GroupAccount;
import util.hibernateUtil;


public class Program {
    public static void main(String[] args) {
        try(var factory = hibernateUtil.buildSessionFactory()) {
            factory.inTransaction(session -> {
             var group1 = new Group();
             group1.setName("Hibernate core");
             session.persist(group1);

                var group2 = new Group();
                group2.setName("Spring framework");
                session.persist(group2);

                var account2 = new Account();
             account2.setName("Tài");
             account2.setEmail("Taianhnguyen12@gmail.com");
             session.persist(account2);

                var account1 = new Account();
                account1.setName("Hòa");
                account1.setEmail("HoaAnh96@gmail.com");
                session.persist(account1);


                var groupAccount1 = new GroupAccount();
               var pk1 = new GroupAccount.Primarykey();
               pk1.setGroupId(1);
               pk1.setAccountId(1);
               groupAccount1.setPk(pk1);
                session.persist(groupAccount1);

                var groupAccount2 = new GroupAccount();
                var pk2 = new GroupAccount.Primarykey();
                pk2.setGroupId(1);
                pk2.setAccountId(2);
                groupAccount2.setPk(pk2);
                session.persist(groupAccount2);

            });

            //THử thứ 2 Find all
 factory.inTransaction(session -> {
     //hibernate
     var hql = "FROM Group ";
    var groups = session.createSelectionQuery(hql, Group.class)
             .getResultList();//bắt buộc Department là tên của entity
     for (var group : groups) {
         System.out.println("group = " + group.getName()); // lệnh gõ nhanh : department.soutv
         var groupAccounts = group.getGroupAccounts();
         for (var groupAccount : groupAccounts) {
             System.out.println("account = " + groupAccount.getAccount().getName());
             System.out.println("joined_at = " + groupAccount.getJoinedAt());
         }
     }

 });
        }
    }
}
