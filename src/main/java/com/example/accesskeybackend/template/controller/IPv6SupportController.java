package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.dto.IPv6SupportDTO;
import com.example.accesskeybackend.template.service.IPv6SupportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class IPv6SupportController {
    private final IPv6SupportService ipv6SupportService;

    @GetMapping("/checkIpv6Support")
    public IPv6SupportDTO checkIPv6Support(@RequestParam String siteUrl) {
        return ipv6SupportService.checkIPv6Support(siteUrl);
    }
}
