package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class Department {

    @Id // khóa chính
    @Column(name = "id") //tên cột
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
    private int id;

    @Column(name = "name",length = 50,unique = true,nullable = false)
    private String name;

}
