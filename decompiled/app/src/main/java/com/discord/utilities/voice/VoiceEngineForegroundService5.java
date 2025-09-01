package com.discord.utilities.voice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VoiceEngineForegroundService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/voice/VoiceEngineForegroundService$Connection$connection$1", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "className", "Landroid/os/IBinder;", "binder", "", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$Connection$connection$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class VoiceEngineForegroundService5 implements ServiceConnection {
    public final /* synthetic */ VoiceEngineForegroundService.Connection this$0;

    public VoiceEngineForegroundService5(VoiceEngineForegroundService.Connection connection) {
        this.this$0 = connection;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName className, IBinder binder) {
        Intrinsics3.checkNotNullParameter(className, "className");
        Intrinsics3.checkNotNullParameter(binder, "binder");
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, ((VoiceEngineForegroundService.LocalBinder) binder).getService());
        this.this$0.setUnbinding(false);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName className) {
        Intrinsics3.checkNotNullParameter(className, "className");
        this.this$0.setUnbinding(false);
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, null);
    }
}
