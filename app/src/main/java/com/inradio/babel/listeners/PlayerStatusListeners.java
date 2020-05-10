package com.inradio.babel.listeners;

public interface PlayerStatusListeners {
    void onMyPlayerStartPlaying();
    void onMyPlayerPause();
    void onMyPlayerStop();
    void onMyPlayerError();
}
