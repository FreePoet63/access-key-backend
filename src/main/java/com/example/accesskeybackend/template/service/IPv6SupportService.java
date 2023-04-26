package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IPv6SupportException;
import com.example.accesskeybackend.template.dto.IPv6SupportDTO;
import com.example.accesskeybackend.template.entity.IPv6Support;
import com.example.accesskeybackend.template.mapper.IPv6SupportMapper;
import com.example.accesskeybackend.template.repo.IPv6SupportRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
@AllArgsConstructor
@Log4j2
public class IPv6SupportService {
    private final IPv6SupportRepository ipv6SupportRepository;
    private final IPv6SupportMapper iPv6SupportMapper;

    public IPv6SupportDTO checkIPv6Support(String siteUrl) {
        boolean ipv6Supported = checkIPv6SupportForSite(siteUrl);
        IPv6Support ipv6SupportEntity = ipv6SupportRepository.findBySiteUrl(siteUrl);
        if (ipv6SupportEntity == null) {
            ipv6SupportEntity = new IPv6Support(siteUrl, ipv6Supported);
        } else {
            ipv6SupportEntity.setIpv6Supported(ipv6Supported);
        }
        ipv6SupportRepository.save(ipv6SupportEntity);
        return iPv6SupportMapper.toDTO(ipv6SupportEntity);
    }

    public boolean checkIPv6SupportForSite(String urlStr) {
        try {
            String strUrl = urlStr;
            if (!urlStr.startsWith("https")) {
                strUrl = "https://" + urlStr;
            }
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            boolean success = false;
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                if (Inet6Address.getByName(url.getHost()).isReachable(5000)) {
                    success = true;
                }
            }
            conn.disconnect();
            return success;
        } catch (Exception ex) {
            throw new IPv6SupportException(String.format("Incorrect data: %s", urlStr), ex);
        }
    }
}
