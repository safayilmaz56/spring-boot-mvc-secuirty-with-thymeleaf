package com.teknopar.springboot.demo.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebUser {
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String userName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String password;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
}
