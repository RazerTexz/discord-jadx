package com.discord.utilities.animations;

import com.airbnb.lottie.LottieAnimationView;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: LottieAnimationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/airbnb/lottie/LottieAnimationView;", "", "triggerFrame", "Lkotlin/ranges/IntRange;", "loopFrames", "", "disabledAnimation", "", "loopFrom", "(Lcom/airbnb/lottie/LottieAnimationView;ILkotlin/ranges/IntRange;Z)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.animations.LottieAnimationUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class LottieAnimationUtils2 {
    public static final void loopFrom(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2, boolean z2) {
        Intrinsics3.checkNotNullParameter(lottieAnimationView, "$this$loopFrom");
        Intrinsics3.checkNotNullParameter(ranges2, "loopFrames");
        if (z2) {
            lottieAnimationView.setFrame(i);
            lottieAnimationView.c();
        } else {
            lottieAnimationView.p.l.j.add(new LottieAnimationUtils(lottieAnimationView, i, ranges2));
        }
    }

    public static /* synthetic */ void loopFrom$default(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
        }
        loopFrom(lottieAnimationView, i, ranges2, z2);
    }
}
