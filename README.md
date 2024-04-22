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
