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

    private String name;

    private String email;

    private Boolean gender;

    private Integer departId;

    private Date birthday;

    private static final long serialVersionUID = 1L;
}