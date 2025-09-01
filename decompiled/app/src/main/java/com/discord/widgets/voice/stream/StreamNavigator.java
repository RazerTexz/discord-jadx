package com.discord.widgets.voice.stream;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import androidx.fragment.app.Fragment;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StreamNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/voice/stream/StreamNavigator;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestStartStream", "(Landroidx/fragment/app/Fragment;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "intentCallback", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "START_SCREENSHARE_REQUEST_CODE", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StreamNavigator {
    public static final StreamNavigator INSTANCE = new StreamNavigator();
    private static final int START_SCREENSHARE_REQUEST_CODE = 420;

    private StreamNavigator() {
    }

    public static final void handleActivityResult(int requestCode, int resultCode, Intent data, Function1<? super Intent, Unit> intentCallback) {
        Intrinsics3.checkNotNullParameter(intentCallback, "intentCallback");
        if (resultCode == -1 && requestCode == START_SCREENSHARE_REQUEST_CODE && data != null) {
            intentCallback.invoke(data);
        }
    }

    public static final void requestStartStream(Fragment fragment) {
        Context contextRequireContext;
        if (fragment == null || (contextRequireContext = fragment.requireContext()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment?.requireContext() ?: return");
        Object systemService = contextRequireContext.getSystemService("media_projection");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        fragment.startActivityForResult(((MediaProjectionManager) systemService).createScreenCaptureIntent(), START_SCREENSHARE_REQUEST_CODE);
    }
}
