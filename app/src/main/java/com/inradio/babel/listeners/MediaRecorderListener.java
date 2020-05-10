package com.inradio.babel.listeners;

public interface MediaRecorderListener {
    void onRecordingStart();
    void onRecordingStop();
    void onRecordingError();
}
