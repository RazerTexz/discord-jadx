package com.discord.utilities.view.extensions;

import android.widget.ScrollView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ScrollViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/widget/ScrollView;", "", "flashScrollBars", "(Landroid/widget/ScrollView;)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.ScrollViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ScrollViewExtensions {
    public static final void flashScrollBars(ScrollView scrollView) {
        Intrinsics3.checkNotNullParameter(scrollView, "$this$flashScrollBars");
        scrollView.scrollBy(0, 1);
        scrollView.scrollBy(0, -1);
    }
}
