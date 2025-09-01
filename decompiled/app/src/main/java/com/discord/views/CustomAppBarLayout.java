package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CustomAppBarLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0015\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/discord/views/CustomAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lkotlin/Function1;", "", "callback", "setOnPercentCollapsedCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "k", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "percentCollapsedOffsetChangeListener", "l", "Lkotlin/jvm/functions/Function1;", "onPercentCollapsedCallback", "", "a", "()Z", "isCollapsed", "j", "F", "percentCollapsed", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CustomAppBarLayout extends AppBarLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public float percentCollapsed;

    /* renamed from: k, reason: from kotlin metadata */
    public final AppBarLayout.OnOffsetChangedListener percentCollapsedOffsetChangeListener;

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Float, Unit> onPercentCollapsedCallback;

    /* compiled from: CustomAppBarLayout.kt */
    public static final class a extends Lambda implements Function1<Float, Unit> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            f.floatValue();
            return Unit.a;
        }
    }

    /* compiled from: CustomAppBarLayout.kt */
    public static final class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Intrinsics3.checkNotNullExpressionValue(appBarLayout, "appBar");
            float fAbs = appBarLayout.getTotalScrollRange() <= 0 ? 1.0f : Math.abs(i) / appBarLayout.getTotalScrollRange();
            CustomAppBarLayout customAppBarLayout = CustomAppBarLayout.this;
            if (fAbs != customAppBarLayout.percentCollapsed) {
                customAppBarLayout.percentCollapsed = fAbs;
                customAppBarLayout.onPercentCollapsedCallback.invoke(Float.valueOf(fAbs));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.percentCollapsedOffsetChangeListener = new b();
        this.onPercentCollapsedCallback = a.j;
    }

    public final boolean a() {
        return this.percentCollapsed == 1.0f;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnOffsetChangedListener(this.percentCollapsedOffsetChangeListener);
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeOnOffsetChangedListener(this.percentCollapsedOffsetChangeListener);
        super.onDetachedFromWindow();
    }

    public final void setOnPercentCollapsedCallback(Function1<? super Float, Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.onPercentCollapsedCallback = callback;
    }
}
