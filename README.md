<h2>DTO를 DB에 저장하는 과정 </h2>
DTO를 엔티티로 변환한 후 리파지토리를 이용해 엔티티를 DB에 저장한다. 

클라이언트 -> DTO (컨트롤러) 엔티티 (리파지토리)  -(저장)-> DB <br/>
DTO 에서 엔티티로 변환됨
              

<h2>DI(Dependency Injection)의존성 주입 </h2>

외부에서 만들어진 객체를 필요한 곳으로 가져오는 기법을 의존성주입이라고 한다. <br/>
스프링부트는 @AutoWired 어노테이션으로 의존성 주입을 할 수 있다. 

<h2>@log4j(Simple Logging Facade for Java)</h2>

로깅 할 때 사용. 로깅 기능으로 로그를 찍으면 나중에라도 그동안 찍힌 로그를 찾아볼 수 있다. log.info() 문 사용

              
