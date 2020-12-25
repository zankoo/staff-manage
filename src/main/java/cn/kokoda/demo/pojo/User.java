package cn.kokoda.demo.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}