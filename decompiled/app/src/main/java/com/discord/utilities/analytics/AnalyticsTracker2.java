package com.discord.utilities.analytics;

import com.discord.utilities.lifecycle.ApplicationProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/firebase/analytics/FirebaseAnalytics;", "invoke", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsTracker$firebaseAnalytics$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsTracker2 extends Lambda implements Function0<FirebaseAnalytics> {
    public static final AnalyticsTracker2 INSTANCE = new AnalyticsTracker2();

    public AnalyticsTracker2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FirebaseAnalytics invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FirebaseAnalytics invoke() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(ApplicationProvider.INSTANCE.get());
        Intrinsics3.checkNotNullExpressionValue(firebaseAnalytics, "FirebaseAnalytics.getIns…pplicationProvider.get())");
        return firebaseAnalytics;
    }
}
