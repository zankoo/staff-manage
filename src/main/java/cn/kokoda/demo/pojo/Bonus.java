package cn.kokoda.demo.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bonus implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer empId;

    private String reason;

    private Integer bonus;

    private static final long serialVersionUID = 1L;
}