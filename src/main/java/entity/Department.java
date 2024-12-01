package entity;


import converter.DepartmentTypeConverter;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class Department {

    @Id // khóa chính
    @Column(name = "id") //tên cột
    @GenericGenerator(name = "department_id_generator",
    strategy = "generator.DepartmentIdGenerator")
    @GeneratedValue(generator = "department_id_generator")
    private String id;

    @Column(name = "name",length = 50,unique = true,nullable = false)
    private String name;

@Column(name = "type",nullable = false)
@Convert(converter = DepartmentTypeConverter.class)
    private Type type;

   @Column(name = "create_at",nullable = false,updatable = false) // không cho người dùng sửa,cập nhật
   @CreationTimestamp //tự lấy thời gian trong hệ thống
    private LocalDateTime createAt; // tạo lúc

    @Column(name = "update_at",nullable = false)
    @UpdateTimestamp // tự động update thời gian cập nhật
    private LocalDateTime updateAt; // cập nhật lúc

    //hàm này sẽ được chạy trươc khi thêm vào database

    @PrePersist
    public void prePersist() {
        System.out.println(" Trước khi thêm vào");
    }


    //sau khi thêm vào database

    @PostPersist
    public void postPersist() {
        System.out.println("sau khi theem");
    }


    public enum Type {
        DEVELOPER,TESTER,SCRUM_MASTER,PROJECT_MANAGER
    }
}
