package com.example.accesskeybackend.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ipv6support")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IPv6Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "site_url", nullable = false, updatable = false)
    private String siteUrl;
    @Column(name = "ipv6_supported", nullable = false, updatable = false)
    private boolean ipv6Supported;

    public IPv6Support(String siteUrl, boolean ipv6Supported) {
        this.siteUrl = siteUrl;
        this.ipv6Supported = ipv6Supported;
    }
}
