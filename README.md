<h2>DTO를 DB에 저장하는 과정 </h2>
DTO를 엔티티로 변환한 후 리파지토리를 이용해 엔티티를 DB에 저장한다. 

클라이언트 -> DTO (컨트롤러) 엔티티 (리파지토리)  -(저장)-> DB <br/>
DTO 에서 엔티티로 변환됨
              

<h2>DI(Dependency Injection)의존성 주입 </h2>

외부에서 만들어진 객체를 필요한 곳으로 가져오는 기법을 의존성주입이라고 한다. <br/>
스프링부트는 @AutoWired 어노테이션으로 의존성 주입을 할 수 있다. 

<h2>@log4j(Simple Logging Facade for Java)</h2>

로깅 할 때 사용. 로깅 기능으로 로그를 찍으면 나중에라도 그동안 찍힌 로그를 찾아볼 수 있다. log.info() 문 사용

<h2>@noArgsConstructor </h2>
기본생성자 추가 어노테이션(롬복)   기본생성자: 매개변수가 아무것도 없는 생성자

<h2>데이터 조회과정</h2>
<img src="https://github.com/skal48/springboot_JPA/blob/main/%EA%B7%B8%EB%A6%BC/read_process.png?raw=true">

<h2>데이터 수정과정</h2>             
<img src="https://github.com/skal48/springboot_JPA/blob/main/%EA%B7%B8%EB%A6%BC/%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%88%98%EC%A0%95.png?raw=true">

<h2>리다이렉트</h2>

클라이언트가 보낸 요청을 마친 후 계속해서 처리할 다름 ㅏ요청 주소를 재지시하는 것, 이를 통해 분리된 기능을 하나의 연속적인 흐름으로 연결할 수 있다. <br/>
형식 - return "redirect:URL 주소"; 

<h2>RedirectAttributes</h2>
RedirectAttributes 객체의  addFlashAttribute() 메서드는 리다이렉트된 페이지에서 사용할 일회성 데이터를 등록할 수 있음

<h2>삭제과정</h2>
<img src="https://raw.githubusercontent.com/skal48/springboot_JPA/5d4cd3fa005f76362b76ac244bd8a70c08de6e4a/%EA%B7%B8%EB%A6%BC/%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%82%AD%EC%A0%9C.png">

<h2>REST API</h2>
서버의 자원을 클라이언트에 구애받지 않고 사용할 수 있게 설계하는 방식. HTTP 요청에 대한 응답으로 서버의 자원을 반환. 서버에서 보내는 응답이 특정기기에 종속되지 않도록 모든 기기에서 통용될 수 있는 데이터 반환.<br/>
응답데이터는 JSON 이다.

<h2>put과 patch의 차이점</h2>
PUT : 기존 데이터를 전부 새 내용으로 변경한다. 기존데이터가 없다면 새로 생성
PATCH : 기존 데이터 중에서 일부만 새 내용으로 변경한다.

<h2>@RequestBody</h2>
@RequestBody 는 본문에 실어 보내는 데이터를 메서드의 매개변수로 받아 올 수 있다. 

<h2>ResponseEntity와 HttpStatus</h2>
ResponseEntity는 REST 컨트롤러의 반환형, REST API의 응답을 위해 사용하는 클래스이다. 요청을 응답할 때 이 클래스에 HTTP 상태모드, 헤더, 본문을 실어 보낼 수 있다. <br/>
HttpStatus 는 HTTP 상태 모드를 관리하는 클래스로 다양한 Enum 타입과 관련한 메서드를 가진다. Enum 타입은 열거형으로 여러 상수로 이루어진 고정 집합을 가진다. <br/>
200 -> HttpStatus.OK /  201 -> HttpStatus.CREATED /   400 -> HttpStatus.BAD_REQUEST

<h2>iterable </h2>
iterable은 Collection의 상위 인터페이스이며, 하위클래스에서 iterator()의 생성을 강제하는 역활<br/>Iterable 인터페이스를 구현하는 것은 객체가 for-each loop 선언문의 타겟이 되도록 하는 것이다. 즉, forEach 제공하는 인터페이스

<h2>TDD(Test Driven Development</h2>
테스트주도개발이란 일단 테스트 코드를 만든 후 이를 통과하는 최고한의 코드부터 시작해 점진적으로 코드를 개선 및 확장해 나가는 개발 방식 <br/><br/>
<img src="https://www.icterra.com/wp-content/uploads/2020/01/Test_01-1.png" width="512px">

<h2>JpaRepository 인터페이스 계층구조</h2>
<img src="https://github.com/skal48/springboot_JPA/blob/main/%EA%B7%B8%EB%A6%BC/JpaRepository.png?raw=true" width="512px">

<h2>@ManyToOne/@JoinColumn(name="외래키_이름")</h2>
다대일 관계인 경우 @ManyToOne 어노테이션을 붙여 다대일 관계로 설정 <br/>
다대일 관계에서 매핑되는 키를 지정

<h2>@Query(value ="쿼리", nativeQuery = true) </h2>
SQL과 유사한 JPQL(Java Persistance Query Language)



