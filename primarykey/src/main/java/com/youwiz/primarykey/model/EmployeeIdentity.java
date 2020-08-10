package com.youwiz.primarykey.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class EmployeeIdentity implements Serializable {

    @NotNull
    @Size(max = 20)
    private String employeeId;

    @NotNull
    @Size(max = 20)
    private String companyId;

//    @Override
//    public int hashCode() {
//        int result = employeeId.hashCode();
//        result = 31 * result + companyId.hashCode();
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//
//        EmployeeIdentity that = (EmployeeIdentity) obj;
//
//        if (!employeeId.equals(that.employeeId)) return false;
//        return companyId.equals(that.companyId);
//    }
}
