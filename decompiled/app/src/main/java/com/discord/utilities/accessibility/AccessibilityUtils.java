package com.discord.utilities.accessibility;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AccessibilityUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityUtils;", "", "Landroid/content/Context;", "context", "", "message", "", "sendAnnouncement", "(Landroid/content/Context;I)V", "", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/view/View;", "view", "setViewIsHeading", "(Landroid/view/View;)V", "", "isReducedMotionEnabled", "()Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    /* compiled from: AccessibilityUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/accessibility/AccessibilityUtils$setViewIsHeading$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.accessibility.AccessibilityUtils$setViewIsHeading$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics3.checkNotNullParameter(host, "host");
            Intrinsics3.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setHeading(true);
        }
    }

    private AccessibilityUtils() {
    }

    public final boolean isReducedMotionEnabled() {
        return StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
    }

    public final void sendAnnouncement(Context context, @StringRes int message) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(message);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(message)");
        sendAnnouncement(context, string);
    }

    public final void setViewIsHeading(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        ViewCompat.setAccessibilityDelegate(view, new AnonymousClass1());
    }

    public final void sendAnnouncement(Context context, String message) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            Intrinsics3.checkNotNullExpressionValue(accessibilityEventObtain, "event");
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(message);
            try {
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            } catch (IllegalStateException unused) {
            }
        }
    }
}
