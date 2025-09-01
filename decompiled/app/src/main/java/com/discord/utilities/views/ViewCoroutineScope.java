package com.discord.utilities.views;

import android.view.View;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;
import s.a.h1;

/* compiled from: ViewCoroutineScope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"", "SCOPE_TAG_KEY", "I", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "(Landroid/view/View;)Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.views.ViewCoroutineScopeKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewCoroutineScope {
    private static final int SCOPE_TAG_KEY = -53661613;

    /* JADX WARN: Type inference failed for: r1v4, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    public static final CoroutineScope getCoroutineScope(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$coroutineScope");
        if (!view.isAttachedToWindow()) {
            return null;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        int i = SCOPE_TAG_KEY;
        Object tag = view.getTag(i);
        if (!(tag instanceof CoroutineScope)) {
            tag = null;
        }
        ?? r3 = (CoroutineScope) tag;
        ref$ObjectRef.element = r3;
        if (((CoroutineScope) r3) != null) {
            return (CoroutineScope) r3;
        }
        Job jobD = f.d(null, 1);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        ref$ObjectRef.element = f.c(CoroutineContext.Element.a.plus((h1) jobD, MainDispatchers.f3830b.H()));
        view.getViewTreeObserver().addOnWindowAttachListener(new ViewCoroutineScope2(ref$ObjectRef));
        view.setTag(i, (CoroutineScope) ref$ObjectRef.element);
        return (CoroutineScope) ref$ObjectRef.element;
    }
}
