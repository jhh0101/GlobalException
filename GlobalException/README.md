# 🗺️ Spring Global Exception 정복 로드맵
### Chapter 1. 예외 처리의 근본 (DispatcherServlet & ControllerAdvice)
스프링이 에러를 낚아채는 흐름을 완벽히 이해하는 기초 단계입니다.        
학습 내용: Filter, Interceptor, ControllerAdvice의 예외 처리 시점 차이, @RestControllerAdvice의 동작 원리.        
실무 예시: 존재하지 않는 경매 API 경로로 접근했을 때(404 에러), 서블릿 필터 단에서 터지는 에러와 컨트롤러 단에서 터지는 에러를 어떻게 다르게 제어할지 구분하기.        

### Chapter 2. ErrorCode와 Custom Exception 고도화 (상태 코드 동적 할당)
현재 하드코딩된 상태 코드를 개선하고, 흩어진 예외들을 하나로 통합합니다.       
학습 내용: ErrorCode Enum에 HttpStatus 필드 추가, 하위 도메인 예외(LoginException 등)를 CustomException 아키텍처로 흡수시키는 방법.       
실무 예시: 토큰 만료(EXPIRED_TOKEN) 시 401을, 잘못된 요청(BAD_REQUEST) 시 400을, 서버 오류(INTERNAL_SERVER_ERROR) 시 500을 GlobalExceptionHandler에서 동적으로 뽑아서 응답하도록 리팩토링하기.     

### Chapter 3. Validation 예외 처리의 미학 (@Valid & @Validated)
사용자가 잘못된 값을 보냈을 때 친절하고 명확하게 알려주는 방법을 배웁니다.      
학습 내용: MethodArgumentNotValidException 발생 시 단순 문자열 하나가 아니라, 여러 개의 FieldError 리스트를 추출하고 가공하여 일관된 JSON 객체로 만드는 법.             
실무 예시: 회원가입 시 "이메일 형식 오류"와 "비밀번호 길이 오류"가 동시에 발생했을 때, 프론트엔드에 두 개의 에러 내용을 한 번에 배열(List) 형태로 깔끔하게 묶어서 응답해주기.           

### Chapter 4. 외부 API 연동 예외 및 트랜잭션 제어 (External & Transaction)
내부 로직이 아닌 외부 요인으로 터지는 에러를 안전하게 덮는 심화 과정입니다.         
학습 내용: 예외 발생 시 @Transactional의 롤백(Rollback) 조건 제어(rollbackFor), 외부 통신 예외를 내 비즈니스 예외로 래핑(Wrapping)하는 기법.         
실무 예시: 토스 결제 승인(PAYMENT_NOT_DONE) 과정에서 외부 통신 실패나 예외가 터졌을 때, 진행 중이던 포인트 충전 트랜잭션을 안전하게 롤백하고 사용자에겐 커스텀 에러 코드 던지기.          

### Chapter 5. 장애 추적과 로깅 전략 (Logging & MDC)
에러를 잡는 것을 넘어, 원인을 빠르게 찾아내는 '관제탑'을 구축합니다.            
학습 내용: Log Level(INFO, WARN, ERROR)의 명확한 분리 기준 정립, MDC(Mapped Diagnostic Context)를 활용한 요청 스레드별 식별자 로깅.              
실무 예시: 수많은 사용자가 동시에 입찰(BID_PRICE_TOO_LOW)을 시도하다 에러가 폭주할 때, 로그에 고유한 TraceID를 남겨 어떤 유저의 요청 흐름에서 터진 예외인지 1초 만에 추적해내기.          
