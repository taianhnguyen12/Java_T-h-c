package converter;

import entity.Department;
import jakarta.persistence.AttributeConverter;

public class DepartmentTypeConverter
        implements AttributeConverter<Department.Type,Character> {
    // có 2 dữ liu trong atrr<x,y>
    // . trong đó x Là bạn muốn chuyen từ kiểu giữ liệu nào, kiểu giữ liệu mốn chuyền vào

    @Override
    public Character convertToDatabaseColumn(Department.Type type) {
        return type.toString().charAt(0);
    }

    @Override
    public Department.Type convertToEntityAttribute(Character code) {
        if (code == 'D') {
            return Department.Type.DEVELOPER;
        }
        if (code == 'T') {
            return Department.Type.TESTER;
        }
        if (code == 'S') {
            return Department.Type.SCRUM_MASTER;
        }

            return Department.Type.PROJECT_MANAGER;
        }



}