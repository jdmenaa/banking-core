package org.banking.client.test.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.io.Serializable;

@Getter
@Setter
public class PersonDto implements Serializable {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;

}
