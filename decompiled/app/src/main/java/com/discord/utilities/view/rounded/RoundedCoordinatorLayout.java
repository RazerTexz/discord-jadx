package com.discord.utilities.view.rounded;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utilities.view.rounded.RoundedCornerViewCoordinator;
import com.discord.utils.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RoundedCoordinatorLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u001d\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001eB'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/discord/utilities/view/rounded/RoundedCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "", "radius", "updateTopLeftRadius", "(F)V", "updateTopRightRadius", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Lcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator;", "roundedViewCoordinator", "Lcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoundedCoordinatorLayout extends CoordinatorLayout {
    private final RoundedCornerViewCoordinator roundedViewCoordinator;

    /* compiled from: RoundedCoordinatorLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Canvas;", "it", "", "invoke", "(Landroid/graphics/Canvas;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.rounded.RoundedCoordinatorLayout$draw$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Canvas, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics3.checkNotNullParameter(canvas, "it");
            RoundedCoordinatorLayout.m22access$draw$s747643027(RoundedCoordinatorLayout.this, canvas);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
    }

    /* renamed from: access$draw$s-747643027, reason: not valid java name */
    public static final /* synthetic */ void m22access$draw$s747643027(RoundedCoordinatorLayout roundedCoordinatorLayout, Canvas canvas) {
        super.draw(canvas);
    }

    private final void initialize(AttributeSet attrs) {
        RoundedCornerViewCoordinator roundedCornerViewCoordinator = this.roundedViewCoordinator;
        int[] iArr = R.b.RoundedCoordinatorLayout;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.RoundedCoordinatorLayout");
        roundedCornerViewCoordinator.initialize(this, attrs, iArr, R.b.RoundedCoordinatorLayout_topLeftRadius, R.b.RoundedCoordinatorLayout_topRightRadius, R.b.RoundedCoordinatorLayout_bottomLeftRadius, R.b.RoundedCoordinatorLayout_bottomRightRadius);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        this.roundedViewCoordinator.draw(canvas, new AnonymousClass1());
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.roundedViewCoordinator.onSizeChanged(w, h);
    }

    public final void updateTopLeftRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator.Corner.TOP_LEFT);
    }

    public final void updateTopRightRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator.Corner.TOP_RIGHT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
