
Below is logcat and stacktrace re: coroutines.
11609-11609 is main thread
11609-11648 is Background thread.
the info we get in the stacktrace about the main thread is MainActivity$mainThreadMethod2_ReturnsDeferredViaAsync$1$doResume$$inlined$bg$1.doResume(bg.kt:30)
(Good - So it shows where it's being called from by activity and method but not line number)

-------------------------------
08-03 11:21:25.782 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: in mainThread onCreate
08-03 11:21:25.782 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: in mainThreadMethod1
08-03 11:21:25.823 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: in mainThreadMethod2_ReturnsDeferredViaAsync
08-03 11:21:25.887 11609-11609/com.segunfamisa.kotlin.samples.retrofit D/NetworkSecurityConfig: No Network Security Config specified, using platform default
08-03 11:21:25.907 11609-11648/com.segunfamisa.kotlin.samples.retrofit D/BoomTest: In backGroundMethod1, about to run backGroundMethod2
08-03 11:21:25.907 11609-11648/com.segunfamisa.kotlin.samples.retrofit D/BoomTest: In backgroundMethod2
08-03 11:21:25.957 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: boomfrom bg
08-03 11:21:25.957 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: ----*************--------*************--------*************--------*************--------*************--------*************--------*************--------*************----
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: Exception stacktrace array has 11 elements
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err: java.lang.Exception: boom: Exception in backgroundmethod2
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepository.backGroundMethod2(SearchRepository.kt:41)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepository.backGroundMethod1(SearchRepository.kt:16)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at com.segunfamisa.kotlin.samples.retrofit.MainActivity$mainThreadMethod2_ReturnsDeferredViaAsync$1$doResume$$inlined$bg$1.doResume(bg.kt:30)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at kotlin.coroutines.experimental.jvm.internal.CoroutineImpl.resume(CoroutineImpl.kt:54)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at kotlinx.coroutines.experimental.DispatchedContinuation$resume$1.run(CoroutineDispatcher.kt:152)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:428)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.util.concurrent.FutureTask.run(FutureTask.java:237)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:272)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1133)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:607)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit W/System.err:     at java.lang.Thread.run(Thread.java:761)
08-03 11:21:25.958 11609-11609/com.segunfamisa.kotlin.samples.retrofit E/BoomTest: ----*************--------*************--------*************--------*************--------*************--------*************--------*************--------*************----
