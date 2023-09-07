package com.nt.springconcepts.security.oauth2.controller;

import com.nt.springconcepts.security.oauth2.model.Notice;
import com.nt.springconcepts.security.oauth2.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {
    @Autowired
    private NoticeRepository noticeRepository;
    @GetMapping("/api/v1/notices")
    @PostAuthorize("hasRole('USER')")
    public ResponseEntity<List<Notice>> getNotices(){
        List<Notice>notices=noticeRepository.findAllActiveNotices();
        if(notices!=null)
        {
            return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);
        }else
        {
            return null;
        }
    }
}
