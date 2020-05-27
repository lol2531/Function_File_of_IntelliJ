package Function;

import java.io.IOException;

// 사용법 (예시)
// StopWatch(true); // 타이머가 켜짐
// StopWatch(false); // 타이머가 꺼지고 시간 문자열을 버퍼에 설정
// System.out.format("Timer OFF! 경과 시간: [%s]%n", timeBuffer); // 경과 시간 화면에 출력

public class StopWatch {
    static String timeBuffer;
    static int oldTime;

    /**
     * 타이머를 시작합니다.
     */
    public static void Start() {
        oldTime = (int) System.currentTimeMillis() / 1000;  // 타이머 시작 시점의 시간을 저장
    }

    /**
     * 타이머를 멈추고 걸린 시간 값을 저장합니다.
     */
    public static void Stop()  // 타이머 정지
    {
        secToHHMMSS(((int)System.currentTimeMillis() / 1000) - oldTime);
    }

    /**
     * HH:MM:ss 형태의 시간 문자열을 가져옵니다.
     * @return 시간 문자열
     */
    public static String GetTime()  // 시간 문자열 획득
    {
        return timeBuffer;
    }

    // 정수로 된 시간을 초단위(sec)로 입력 받아, "04:11:15" 등의 형식의 문자열로 시분초를 저장
    private static void secToHHMMSS(int secs)
    {
        int hour, min, sec;

        sec  = secs % 60;
        min  = secs / 60 % 60;
        hour = secs / 3600;
        // day = hour / 24;
        // month = day / 30;
        // year = month / 12;

        timeBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
    }

    /**
     * Enter키를 누를 때까지 타이머를 동작 중인 상태로 대기합니다.
     */
    public static void pause()
    {
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }
}
