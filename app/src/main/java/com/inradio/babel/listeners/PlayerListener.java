package com.inradio.babel.listeners;

public interface PlayerListener {
    void onStartPlaying();
    void onPlayerPause();
    void onPlayerStop();
    void onPlayerError();
}
