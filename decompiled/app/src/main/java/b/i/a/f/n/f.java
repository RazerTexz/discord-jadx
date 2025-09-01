package b.i.a.f.n;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
public interface f<TResult, TContinuationResult> {
    @NonNull
    Task<TContinuationResult> a(@RecentlyNonNull TResult tresult) throws Exception;
}
