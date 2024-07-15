package com.BiteBeat.Response;

import com.BiteBeat.Model.USER_ROLE;
import com.BiteBeat.Repository.CartRepository;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
