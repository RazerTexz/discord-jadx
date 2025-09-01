package com.discord.utilities.views.viewstub;

import android.view.ViewStub;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LazyViewStubDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "invoke", "()Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.views.viewstub.LazyViewStubDelegate$Companion$lazyViewStub$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LazyViewStubDelegate2 extends Lambda implements Function0<LazyViewStubDelegate> {
    public final /* synthetic */ Function0 $getViewStub;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate2(Function0 function0) {
        super(0);
        this.$getViewStub = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LazyViewStubDelegate invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LazyViewStubDelegate invoke() {
        return new LazyViewStubDelegate((ViewStub) this.$getViewStub.invoke(), null);
    }
}
