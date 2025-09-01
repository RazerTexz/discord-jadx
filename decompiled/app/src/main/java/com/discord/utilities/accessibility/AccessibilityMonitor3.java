package com.discord.utilities.accessibility;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: AccessibilityMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"com/discord/utilities/accessibility/AccessibilityMonitor$animationScaleObserver$1", "Landroid/database/ContentObserver;", "", "selfChange", "", "onChange", "(Z)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "(ZLandroid/net/Uri;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$animationScaleObserver$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AccessibilityMonitor3 extends ContentObserver {
    public final /* synthetic */ AccessibilityMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityMonitor3(AccessibilityMonitor accessibilityMonitor, Handler handler) {
        super(handler);
        this.this$0 = accessibilityMonitor;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        onChange(selfChange, null);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        AccessibilityMonitor.access$handleReduceMotionUpdated(this.this$0);
    }
}
