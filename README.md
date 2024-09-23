# Baseballgame 만들기!
![image](https://github.com/user-attachments/assets/00e748a6-0fdb-4cbf-9e26-7104f864d330)
메뉴를 보여주고 게임을 시작하는 초입부입니다.

![image](https://github.com/user-attachments/assets/3f7f83d3-3923-46c2-8dcc-914eef37b320)

베이스볼 클래스입니다.
게임의 정답리스트와 게임 시도횟수를 저장하는걸 구현해놓았습니다.

![image](https://github.com/user-attachments/assets/d7f03938-c542-4a62-ba0f-cd0b2315dff0)

본격적인 메뉴입니다. 1번 2번 3번을 각각 switch,case를 이용하여 작성했습니다.
또한 게임을 종료하는것 말고 showgameRecords 부분에 여태 정답을 입력한 횟수를 보여주는 부분도 구현했습니다.

![image](https://github.com/user-attachments/assets/abcf9c5b-c43a-49dc-9d94-2966fc9e4c41)

플레이 메서드입니다.
본격적인 게임진행에 관련된 부분을 적었습니다.
시도횟수와 관련된 부분도 적용하였으며, 올바르지않은 숫자를 입력했을때 나오는 결과와 정답을 맞췄을떄의 결과, 몇번만의 시도가있었는지 출력이되게 했습니다
힌트부분 즉, 스트라이크 볼 아웃 이 출력되는 것도 만들었습니다.
정답을 맞춘후 다시 처음부터 돌아가게했습니다.

![image](https://github.com/user-attachments/assets/c462423e-9fd1-4a05-ba56-5ae3da0f3439)

정답 숫자를 생성하는  private void generateAnswe 를 입력하였으며 1부터 9까지의 숫자를 생성할수있도록 적용시켰습니다.

![image](https://github.com/user-attachments/assets/57aeb0b4-e52b-473b-ab1d-be307041fe94)

또한 입력값이 올바른지 (세 자리 숫자. 중복없음. 숫자만 입력)을  protected boolean validateInput을 이용하였습니다.

![image](https://github.com/user-attachments/assets/658e302f-b02d-45f1-9657-701067b815ca)

제일 중요한 스트라이크 볼 아웃을 계산하는 메서드입니다.
스트라이크 같은경우 숫자와 자리까지 일치하는 경우를 적용하였으며,볼은 숫자만 일치하는경우를 계산할수잇도록 만들었습니다.

![image](https://github.com/user-attachments/assets/be4c7452-92a5-4746-b1ac-28c2a1c14d72)

힌트(아웃)를 제공하는 부분입니다. 

![image](https://github.com/user-attachments/assets/9146bff1-ef37-4585-b633-43be7b3c9530)

gameRecords에 저장된 기록을 출력하는 부분이며. 기록이 없을 때는 관련 메시지를 출력하도록 했습니다.
