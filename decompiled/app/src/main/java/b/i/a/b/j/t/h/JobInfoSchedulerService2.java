package b.i.a.b.j.t.h;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* compiled from: JobInfoSchedulerService.java */
/* renamed from: b.i.a.b.j.t.h.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class JobInfoSchedulerService2 implements Runnable {
    public final JobInfoSchedulerService j;
    public final JobParameters k;

    public JobInfoSchedulerService2(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.j = jobInfoSchedulerService;
        this.k = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        JobInfoSchedulerService jobInfoSchedulerService = this.j;
        JobParameters jobParameters = this.k;
        int i = JobInfoSchedulerService.j;
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }
}
