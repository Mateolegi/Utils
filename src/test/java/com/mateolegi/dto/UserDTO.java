package com.mateolegi.dto;

import java.util.Date;

public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private Date birthday;

    public UserDTO(Long id, String name, String lastName, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public Date getBirthday() { return birthday; }
}
