package com.sttmanageweb.service.sttmanagewebservicespringboot.web;

import com.sttmanageweb.service.sttmanagewebservicespringboot.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {

    @Test
    void 롬북_기능(){
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

    }


}