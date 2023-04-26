package com.example.accesskeybackend.template.repo;

import com.example.accesskeybackend.template.entity.IPv6Support;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPv6SupportRepository extends JpaRepository<IPv6Support, Long> {
    IPv6Support findBySiteUrl(String siteUrl);
}
