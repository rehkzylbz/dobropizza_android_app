package ru.dobropizza_android_app

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker

import androidx.work.Worker
import androidx.work.WorkerParameters

class DobroWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): ListenableWorker.Result {
        Log.d(TAG, "Performing long running task in scheduled job")
        // TODO(developer): add long running task here.
        return ListenableWorker.Result.success()
    }

    companion object {
        private const val TAG = "DobroWorker"
    }
}