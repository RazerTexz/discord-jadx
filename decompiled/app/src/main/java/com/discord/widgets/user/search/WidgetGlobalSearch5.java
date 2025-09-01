package com.discord.widgets.user.search;

import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;

/* compiled from: WidgetGlobalSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$setSearchPrefix$1$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearch5 implements Runnable {
    public final /* synthetic */ TextInputLayout $this_apply;

    public WidgetGlobalSearch5(TextInputLayout textInputLayout) {
        this.$this_apply = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensions.setSelectionEnd(this.$this_apply);
    }
}
