package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;
    private String sablon;

    public ProcessingThread(Context context, String sablon) {
        this.context = context;
        this.sablon = sablon;
    }

    public void run() {
        while(isRunning) {
            sendMessage();
        }
    }

    private void sendMessage() {
        String[] strArray = sablon.split(",");
        for (String s : strArray) {
            Intent intent = new Intent();
            intent.putExtra("mesaj_thread", s);
            context.sendBroadcast(intent);
            Log.d("un_tag", s);
            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
