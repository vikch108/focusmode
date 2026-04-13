import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class focusmode {

    public static void main(String[] args) {
        int focusMinutes = 1;

        System.out.println("Focus Mode Started...");

        long endTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(focusMinutes);

        while (System.currentTimeMillis() < endTime) {
            blockApps();

            try {
                Thread.sleep(1000); // check every 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Focus Mode Ended");
    }

    public static void blockApps() {
        killProcess("msedge.exe");
        killProcess("chrome.exe");
        //killProcess("brave.exe");
        killProcess("discord.exe");
    }

    public static void killProcess(String processName) {
        ProcessBuilder processBuilder =
                new ProcessBuilder("taskkill", "/IM", processName, "/F");

        try {
            processBuilder.start();
        } catch (IOException e) {
            // ignore
        }
    }
}