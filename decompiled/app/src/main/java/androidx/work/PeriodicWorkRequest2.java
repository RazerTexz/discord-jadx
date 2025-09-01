package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.PeriodicWorkRequest;
import d0.z.d.Intrinsics3;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: PeriodicWorkRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\u0007\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a$\u0010\u0007\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0007\u0010\n\u001a<\u0010\u0007\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0007\u0010\r\u001a,\u0010\u0007\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/work/ListenableWorker;", ExifInterface.LONGITUDE_WEST, "", "repeatInterval", "Ljava/util/concurrent/TimeUnit;", "repeatIntervalTimeUnit", "Landroidx/work/PeriodicWorkRequest$Builder;", "PeriodicWorkRequestBuilder", "(JLjava/util/concurrent/TimeUnit;)Landroidx/work/PeriodicWorkRequest$Builder;", "Ljava/time/Duration;", "(Ljava/time/Duration;)Landroidx/work/PeriodicWorkRequest$Builder;", "flexTimeInterval", "flexTimeIntervalUnit", "(JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)Landroidx/work/PeriodicWorkRequest$Builder;", "(Ljava/time/Duration;Ljava/time/Duration;)Landroidx/work/PeriodicWorkRequest$Builder;", "work-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.work.PeriodicWorkRequestKt, reason: use source file name */
/* loaded from: classes.dex */
public final class PeriodicWorkRequest2 {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        Intrinsics3.checkParameterIsNotNull(duration, "repeatInterval");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        Intrinsics3.checkParameterIsNotNull(timeUnit2, "flexTimeIntervalUnit");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, j, timeUnit, j2, timeUnit2);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        Intrinsics3.checkParameterIsNotNull(duration, "repeatInterval");
        Intrinsics3.checkParameterIsNotNull(duration2, "flexTimeInterval");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration, duration2);
    }
}
