package b.a.y.s0;

import android.graphics.Bitmap;
import b.f.j.q.BasePostprocessor;
import com.discord.views.user.UserAvatarPresenceView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: UserAvatarPresenceView.kt */
/* renamed from: b.a.y.s0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class UserAvatarPresenceView2 extends BasePostprocessor {
    public final /* synthetic */ UserAvatarPresenceView.c a;

    public UserAvatarPresenceView2(UserAvatarPresenceView.c cVar) {
        this.a = cVar;
    }

    @Override // b.f.j.q.BasePostprocessor
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = UserAvatarPresenceView.this.onAvatarBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$iconUrl);
        }
    }
}
