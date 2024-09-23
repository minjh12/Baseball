import java.util.*;

public class Main {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.start();  // 메뉴를 보여주고 게임 시작
    }
}

class BaseballGame {
    private List<Integer> answer;  // 정답 숫자 리스트
    private List<Integer> gameRecords; //게임 시도횟수를 저장하는부분
    private final Scanner scanner;

    public BaseballGame() {
        scanner = new Scanner(System.in);
        gameRecords = new ArrayList<>(); //게임 기록 초기화
    }
    // 게임 시작 및 메뉴 선택
    public void start() {
        label:
        while (true) {
            System.out.println("숫자야구게임을 시작하겠습니다!.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 확인 3. 종료하기");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    play();
                    break;
                case "2":
                    showgameRecords();
                    break;
                case "3":
                    System.out.println("게임을 종료합니다.");
                    break label;
                default:
                    System.out.println("올바르지 않은 선택입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    // 게임 진행
    public void play() {
        generateAnswer();  // 정답 생성
        System.out.println("< 게임을 시작합니다 >");
            int  Trycount = 0 ; //시도횟수
        while (true) {
            System.out.println("숫자를 입력하세요:");
            String input = scanner.nextLine();

            // 입력값 검증
            if (!validateInput(input)) {
                System.out.println("올바르지 않은 입력값입니다.");
                continue;
            }

            Trycount ++;


            int strike = countStrike(input);
            int ball = countBall(input);

            if (strike == 3) {
                System.out.println("정답입니다!");
                System.out.println(Trycount + "번 만에 정답을 맞추셨습니다!!");
                gameRecords.add(Trycount); //시도횟수를 기록하겠습니다
                break;
            }

            // 힌트 출력
            displayHint(strike, ball);
        }

        // 정답을 맞춘 후, 다시 메뉴로 돌아감
        start();
    }
       // 정답 숫자 생성 (1~9 사이의 중복되지 않는 3자리 수)
    private void generateAnswer() {
        answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() < 3) {
            int num = random.nextInt(9) + 1;  // 1~9 사이의 숫자 생성
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }
        System.out.println("정답(디버깅용): " + answer);  // 디버깅용으로 출력
    }

    // 입력값이 올바른지 검증 (세 자리 숫자, 중복 없음, 숫자만 입력)
    protected boolean validateInput(String input) {
        if (input.length() != 3) return false;  // 3자리가 아니면 false
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') return false;  // 숫자 이외의 문자가 있거나 0이 포함되면 false
            uniqueDigits.add(c);
        }
        return uniqueDigits.size() == 3;  // 중복된 숫자가 없으면 true
    }

    // 스트라이크 개수 계산
    private int countStrike(String input) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == Character.getNumericValue(input.charAt(i))) {
                strike++;
            }
        }
        return strike;
    }

    // 볼 개수 계산
    private int countBall(String input) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (answer.contains(num) && answer.get(i) != num) {
                ball++;
            }
        }
        return ball;
    }

    // 힌트 출력
    private void displayHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }

    private void showgameRecords(){
        if(gameRecords.isEmpty()){
            System.out.println("저장된 게임기록이 존재하지 않습니다");
        }else{
            System.out.println("<게임 기록 보기>");
            for (int i = 0; i < gameRecords.size(); i++) {
                System.out.println((i + 1)+"번째 게임을" + gameRecords.get(i) +"번 시도했습니다");
            }
        }
    }
}
