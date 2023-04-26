package com.example.accesskeybackend.template.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
public class IPv6SupportDTO {
    @NotEmpty
    @NotNull
    private String siteUrl;
    private boolean ipv6Supported;
}
