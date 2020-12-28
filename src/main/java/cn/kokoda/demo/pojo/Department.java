package cn.kokoda.demo.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    private Integer id;

    private Integer userId;

    private String name;

    private static final long serialVersionUID = 1L;
}