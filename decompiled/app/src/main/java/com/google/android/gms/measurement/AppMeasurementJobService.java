package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import b.i.a.f.i.b.k9;
import b.i.a.f.i.b.p8;
import b.i.a.f.i.b.q3;
import b.i.a.f.i.b.r8;
import b.i.a.f.i.b.t8;
import b.i.a.f.i.b.u4;
import b.i.a.f.i.b.u8;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
@TargetApi(24)
/* loaded from: classes3.dex */
public final class AppMeasurementJobService extends JobService implements t8 {
    public p8<AppMeasurementJobService> j;

    @Override // b.i.a.f.i.b.t8
    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // b.i.a.f.i.b.t8
    public final void b(Intent intent) {
    }

    public final p8<AppMeasurementJobService> c() {
        if (this.j == null) {
            this.j = new p8<>(this);
        }
        return this.j;
    }

    @Override // b.i.a.f.i.b.t8
    public final boolean f(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        u4.b(c().a, null, null).g().n.a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        u4.b(c().a, null, null).g().n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        c().c(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) throws IllegalStateException {
        p8<AppMeasurementJobService> p8VarC = c();
        q3 q3VarG = u4.b(p8VarC.a, null, null).g();
        String string = jobParameters.getExtras().getString("action");
        q3VarG.n.b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        r8 r8Var = new r8(p8VarC, q3VarG, jobParameters);
        k9 k9VarB = k9.b(p8VarC.a);
        k9VarB.f().v(new u8(k9VarB, r8Var));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}
