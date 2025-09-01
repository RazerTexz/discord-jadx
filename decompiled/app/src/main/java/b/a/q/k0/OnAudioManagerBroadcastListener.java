package b.a.q.k0;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.q.l0.WiredHeadsetState;
import com.discord.rtcconnection.enums.ScoAudioState;

/* compiled from: OnAudioManagerBroadcastListener.kt */
@MainThread
/* renamed from: b.a.q.k0.h, reason: use source file name */
/* loaded from: classes.dex */
public interface OnAudioManagerBroadcastListener {
    void a(Context context, boolean z2);

    void b(Context context, ScoAudioState.b bVar);

    void c(Context context);

    void d(Context context, boolean z2);

    void e(Context context, WiredHeadsetState wiredHeadsetState);
}
