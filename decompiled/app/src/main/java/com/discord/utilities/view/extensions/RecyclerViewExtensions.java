package com.discord.utilities.view.extensions;

import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RecyclerViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "ignoreCurrentTouch", "(Landroidx/recyclerview/widget/RecyclerView;)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.RecyclerViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RecyclerViewExtensions {
    public static final void ignoreCurrentTouch(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "$this$ignoreCurrentTouch");
        recyclerView.suppressLayout(true);
        recyclerView.suppressLayout(false);
    }
}
