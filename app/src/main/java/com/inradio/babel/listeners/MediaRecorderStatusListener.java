package com.inradio.babel.listeners;

public interface MediaRecorderStatusListener {
    void onMyRecorderStart();
    void onMyRecorderStop();
    void onMyRecorderError();
}
