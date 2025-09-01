package com.discord.utilities.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference0Impl;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContentResizingCoordinatorLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u001d\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0017\u0010\u001bB'\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u001dJ7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/views/ContentResizingCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "", "appBarVerticalOffset", "measuredAppBarHeight", "measuredContainerHeight", "widthMeasureSpec", "heightMeasureSpec", "", "updateContentLayoutParams", "(IIIII)V", "onMeasure", "(II)V", "Landroid/view/View;", "content", "Landroid/view/View;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "currentVerticalOffset", "I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContentResizingCoordinatorLayout extends CoordinatorLayout {
    private AppBarLayout appBarLayout;
    private View content;
    private int currentVerticalOffset;

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
            super(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.class, "appBarLayout", "getAppBarLayout()Lcom/google/android/material/appbar/AppBarLayout;", 0);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return ContentResizingCoordinatorLayout.access$getAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl
        public void set(Object obj) {
            ContentResizingCoordinatorLayout.access$setAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver, (AppBarLayout) obj);
        }
    }

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "verticalOffset", "", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ int $heightMeasureSpec;
        public final /* synthetic */ int $widthMeasureSpec;

        public AnonymousClass2(int i, int i2) {
            this.$widthMeasureSpec = i;
            this.$heightMeasureSpec = i2;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            ContentResizingCoordinatorLayout.access$setCurrentVerticalOffset$p(ContentResizingCoordinatorLayout.this, i);
            ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
            ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, i, ContentResizingCoordinatorLayout.access$getAppBarLayout$p(contentResizingCoordinatorLayout).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
        }
    }

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(II)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Integer, Integer, Unit> {
        public final /* synthetic */ int $heightMeasureSpec;
        public final /* synthetic */ int $widthMeasureSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i, int i2) {
            super(2);
            this.$widthMeasureSpec = i;
            this.$heightMeasureSpec = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
            ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.access$getCurrentVerticalOffset$p(contentResizingCoordinatorLayout), ContentResizingCoordinatorLayout.access$getAppBarLayout$p(ContentResizingCoordinatorLayout.this).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ AppBarLayout access$getAppBarLayout$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        AppBarLayout appBarLayout = contentResizingCoordinatorLayout.appBarLayout;
        if (appBarLayout == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayout;
    }

    public static final /* synthetic */ int access$getCurrentVerticalOffset$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        return contentResizingCoordinatorLayout.currentVerticalOffset;
    }

    public static final /* synthetic */ void access$setAppBarLayout$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, AppBarLayout appBarLayout) {
        contentResizingCoordinatorLayout.appBarLayout = appBarLayout;
    }

    public static final /* synthetic */ void access$setCurrentVerticalOffset$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i) {
        contentResizingCoordinatorLayout.currentVerticalOffset = i;
    }

    public static final /* synthetic */ void access$updateContentLayoutParams(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i, int i2, int i3, int i4, int i5) {
        contentResizingCoordinatorLayout.updateContentLayoutParams(i, i2, i3, i4, i5);
    }

    private final void updateContentLayoutParams(int appBarVerticalOffset, int measuredAppBarHeight, int measuredContainerHeight, int widthMeasureSpec, int heightMeasureSpec) {
        int i = measuredAppBarHeight + appBarVerticalOffset;
        View view = this.content;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = measuredContainerHeight - i;
        View view2 = this.content;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        view2.setLayoutParams(layoutParams);
        View view3 = this.content;
        if (view3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        measureChild(view3, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.appBarLayout == null && getChildCount() >= 2) {
            View childAt = getChildAt(0);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
            this.appBarLayout = (AppBarLayout) childAt;
            View childAt2 = getChildAt(1);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.view.View");
            this.content = childAt2;
            AppBarLayout appBarLayout = this.appBarLayout;
            if (appBarLayout == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            measureChild(appBarLayout, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout2.offsetTopAndBottom(0);
            AppBarLayout appBarLayout3 = this.appBarLayout;
            if (appBarLayout3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            updateContentLayoutParams(0, appBarLayout3.getMeasuredHeight(), size, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout4 = this.appBarLayout;
            if (appBarLayout4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout4.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AnonymousClass2(widthMeasureSpec, heightMeasureSpec));
            AppBarLayout appBarLayout5 = this.appBarLayout;
            if (appBarLayout5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            ViewExtensions.addOnHeightChangedListener(appBarLayout5, new AnonymousClass3(widthMeasureSpec, heightMeasureSpec));
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
