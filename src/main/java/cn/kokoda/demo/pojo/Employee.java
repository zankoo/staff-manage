package cn.kokoda.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;

    private Integer userId;

    private String email;

    private Boolean gender;

    private Date birthday;

    private Integer salary;

    private Integer bonus;

    private Integer departId;

    private String name;

    private static final long serialVersionUID = 1L;
}