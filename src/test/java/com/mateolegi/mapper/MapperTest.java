package com.mateolegi.mapper;

import com.mateolegi.dto.UserDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    private BigDecimal id = BigDecimal.valueOf(1);
    private String name = "Joe";
    private String lastName = "Smith";
    private Date birthday = new Date();

    @Test
    void map() {
        Object[] o = new Object[] {id, name, lastName, birthday};
        UserDTO userDTO = Mapper.map(o, UserDTO.class);
        assertNotNull(userDTO);
        Long idLong = id.longValue();
        assertEquals(idLong, userDTO.getId());
        assertEquals(name, userDTO.getName());
        assertEquals(lastName, userDTO.getLastName());
        assertEquals(birthday, userDTO.getBirthday());
    }
}