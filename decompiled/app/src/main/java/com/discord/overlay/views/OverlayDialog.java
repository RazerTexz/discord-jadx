package com.discord.overlay.views;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.WindowManager;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: OverlayDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/discord/overlay/views/OverlayDialog;", "Lcom/discord/overlay/views/OverlayBubbleWrap;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "flag", "setFlag", "(I)V", "", "<anonymous parameter 0>", "f", "()Z", "setMoving", "(Z)V", "isMoving", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "overlay_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class OverlayDialog extends OverlayBubbleWrap {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayDialog(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        WindowManager.LayoutParams windowLayoutParams = getWindowLayoutParams();
        windowLayoutParams.width = -1;
        windowLayoutParams.height = -1;
        windowLayoutParams.x = 0;
        windowLayoutParams.y = 0;
        Intrinsics3.checkNotNullParameter(windowLayoutParams, "$this$addFlag");
        windowLayoutParams.flags |= 2;
        windowLayoutParams.dimAmount = 0.5f;
        setStateListAnimator(null);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public boolean f() {
        return false;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getWindowLayoutParams().x = 0;
        getWindowLayoutParams().y = 0;
        getWindowManager().updateViewLayout(this, getWindowLayoutParams());
    }

    public final void setFlag(int flag) {
        getWindowLayoutParams().flags = flag | getWindowLayoutParams().flags;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void setMoving(boolean z2) {
        Log.w(getClass().getSimpleName(), "Move disabled");
    }
}
