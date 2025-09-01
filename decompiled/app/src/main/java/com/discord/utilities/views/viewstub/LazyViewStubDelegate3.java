package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LazyViewStubDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke", "()Landroid/view/View;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.views.viewstub.LazyViewStubDelegate$viewField$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LazyViewStubDelegate3 extends Lambda implements Function0<View> {
    public final /* synthetic */ ViewStub $stub;
    public final /* synthetic */ LazyViewStubDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate3(LazyViewStubDelegate lazyViewStubDelegate, ViewStub viewStub) {
        super(0);
        this.this$0 = lazyViewStubDelegate;
        this.$stub = viewStub;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View viewInflate = this.$stub.inflate();
        viewInflate.setOnClickListener(LazyViewStubDelegate.access$getListener$p(this.this$0));
        return viewInflate;
    }
}
