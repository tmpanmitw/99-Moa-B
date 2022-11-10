package com.moa.moabackend.controller;

import com.moa.moabackend.entity.ResponseDto;
import com.moa.moabackend.entity.user.MypageRequestDto;
import com.moa.moabackend.entity.user.UserRequestDto;
import com.moa.moabackend.security.user.UserDetailsImpl;
import com.moa.moabackend.service.FriendService;
import com.moa.moabackend.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    // 마이프로필 수정
    @PutMapping("/mypage")
    public ResponseDto updateMypage(@AuthenticationPrincipal UserDetailsImpl userDetails, MypageRequestDto requestDto, @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        return mypageService.updateMypage(userDetails.getUser(), requestDto, file);
    }

    // 유저 정보 가져오기
    @GetMapping("/mypage")
    public ResponseDto getUserDetail(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mypageService.getUserDetail(userDetails.getUser());
    }
}
