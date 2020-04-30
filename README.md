#SaturdaySpring

토요일 아침 스프링 스터디 

서버의 자바 시스템 모니터링

##기능

- 서버의 JAVA 시스템의 리소스 정보 수집
</br>
  - 5초마다 mysql 데이터에 저장
    pid
cpuUsage
memory Usage
virtualSizeUsage
residentSetSize
javaProcessName
  TODO 
  - mysql에 데이터 저장
  - request 요청에 대한 응답
    - request : 특정 자바 프로세스의 이름
  - 모니터링 웹 화면 만들기 ( / )
    - 응답체크 링크
    - 모니터링 체크 링크
- 수집한 리소스 중 특정 수치가 이상 되면 메일로 알람을 보내는 기능
  - [완료]Spring Scheduler 에서 확인 후 메일 발송
- 특정 사이트가 응답을 하는지 체크 
</br> 
  - [완료 ]원격의 특정 사이트가 죽었는지 확인
  TODO
  - 원격 사이트들의 주소 관리 
  - 원격사이트들의 주소들을 배치로 확인하고 로그를 기록
  
