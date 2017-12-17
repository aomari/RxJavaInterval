package com.aomari.testingrxjavainterval;

import android.util.Log;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by aomari on 12/17/2017.
 * TickHandler
 */

public class TickHandler {
    private Disposable subscription;
    private int period;

    private OnTickListener onTickListener;

    public TickHandler() {
        period = 1000;
    }

    public void setOnTickListener(OnTickListener onTickListener) {
        this.onTickListener = onTickListener;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public interface OnTickListener {
        void onTick();
    }

    void resume() {
        subscription = Observable.interval(period, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    onTickListener.onTick();
                });
    }

    void stop() {
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

    boolean isRunning() {
        return subscription != null && !subscription.isDisposed();
    }
}
