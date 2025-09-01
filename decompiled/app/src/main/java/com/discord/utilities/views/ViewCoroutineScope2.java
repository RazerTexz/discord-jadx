package com.discord.utilities.views;

import android.view.ViewTreeObserver;
import b.i.a.f.e.o.f;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ViewCoroutineScope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/discord/utilities/views/ViewCoroutineScopeKt$coroutineScope$1", "Landroid/view/ViewTreeObserver$OnWindowAttachListener;", "", "onWindowAttached", "()V", "onWindowDetached", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.views.ViewCoroutineScopeKt$coroutineScope$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewCoroutineScope2 implements ViewTreeObserver.OnWindowAttachListener {
    public final /* synthetic */ Ref$ObjectRef $scope;

    public ViewCoroutineScope2(Ref$ObjectRef ref$ObjectRef) {
        this.$scope = ref$ObjectRef;
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowAttached() {
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowDetached() {
        f.r((CoroutineScope) this.$scope.element, new CancellationException("view detached from window"));
    }
}
