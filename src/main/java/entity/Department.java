package entity;


import converter.DepartmentTypeConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class Department {

    @Id // khóa chính
    @Column(name = "id") //tên cột
    @SequenceGenerator(
            name = "department_id_generator",
            sequenceName= "department_id_sequence",
            initialValue = 5,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "department_id_generator"
    )
    private int id;

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
