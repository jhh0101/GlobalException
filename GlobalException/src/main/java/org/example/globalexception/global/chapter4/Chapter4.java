package org.example.globalexception.global.chapter4;

import lombok.extern.slf4j.Slf4j;
import org.example.globalexception.global.error.CustomException;
import org.example.globalexception.global.error.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

@Slf4j
@Service
public class Chapter4 {

    // 외부 API 통신
    @Transactional
    public void tossApi(){
        // DB로직

        try {
            // 외부 API 통신 로직
        } catch (RestClientException e) { // 무슨 에러 터지는지 궁금하면 사용 메서드를 타고 들어가서 throw 찾기
            // 통신 중 에러 발생

            log.error(e.getMessage());

//            throw new CustomException(ErrorCode.TOSS_PAYMENT_ERROR); // 외부 API 전역 에러 처리
        }
        // 성공 로직
    }
}
