# AndroidRxJava-Interval
Android RxJava, how to start, stop, reset Observable.interval programmatically on run time!

# Android RxJava Interval: Sample App
[![AmjadOmari](https://firebasestorage.googleapis.com/v0/b/misc-31544.appspot.com/o/aomari.svg?alt=media&token=77658c30-5a06-4e1f-a783-2a51675d16b1)](http://www.amjadomari.com/)

In this sample app, we are creating a class that is triggering an event each n time, in addition we have added useful methods to the class, that will allow as to use it smoothly.
1. setPeriod(int period): this method set the ticks period in seconds.
2. start(): this mithod to start the observable.interval forever.
3. stop(): to stop the observable.interval.
4. setOnTickListener(OnTickListener onTickListener): listener method that will be called in heach tick.

## Expectation:
to understand this samble, you should have a knowledge of:
1. Java programming and Android.
2. Java 8 lambda expressions.
3. have a good knowledge of using Butterknife library.

This is a Samble app that is connecting to Nasa rest API service to get data and display it in a list view.
This App aims to present of how to build a clean code using Dagger 2 and MVP structure.


------------


##### This app has been designed in such a way to describe how to use the reactive programming (Observable.interval) using RxJava and butterknife.

### Observable.interval
```java
 subscription = Observable.interval(period, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(aLong -> {
                        onTickListener.onTick();
                    });
```

As you see, Observable.interval takes two parameters
1. Period: the period between each tick
2. Unit time and this code be in **MILLISECONDS, SECONDS, DAYS, HOURS, MICROSECONDS, NANOSECONDS, and MINUTS**.

**Take care the ObserveOn will not run on UI thread if you did not pass AndroidSchedulers.mainThread**

`observeOn(AndroidSchedulers.mainThread())`

and on each tick, the observer will call:
`subscribe(aLong -> {
                        //do what ever you want here...
                    });`
## To Stop the Disposable interval:To Stop the Disposable interval:
```java
if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
```

### Library reference resources:
1. RxJava2: https://github.com/amitshekhariitbhu/RxJava2-Android-Samples
2. ButterKnife: http://jakewharton.github.io/butterknife/
3. Lambda: https://guides.codepath.com/android/Lambda-Expressions

### Concept reference resources:
1. [RxJava + Fast Android Networking](https://blog.mindorks.com/rxjava-fast-android-networking-6e3d90ee4387#.7hjoex22m)
2. [Migrating from RxJava 1.0 to RxJava 2.0 and Learn RxJava by Examples](https://blog.mindorks.com/migrating-from-rxjava1-to-rxjava2-5dac0a94b4aa#.3lg46kora)
3. [RxJava Anatomy: What is RxJava, how RxJava is designed, and how RxJava works.](https://blog.mindorks.com/rxjava-anatomy-what-is-rxjava-how-rxjava-is-designed-and-how-rxjava-works-d357b3aca586)

### aomari open source projects
[Check out amjadomari awesome open source projects here](http://www.amjadomari.com)


### Contributing to Android RxJava2 Architecture
Just make pull request. You are in!
