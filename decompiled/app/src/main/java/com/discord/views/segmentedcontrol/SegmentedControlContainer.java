package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import b.a.y.n0.SegmentedControlSegment;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SegmentedControlContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006R*\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/discord/views/segmentedcontrol/SegmentedControlContainer;", "Landroid/widget/LinearLayout;", "", "selectedIndex", "", "a", "(I)V", "Lkotlin/Function1;", "Lcom/discord/views/segmentedcontrol/SegmentSelectedChangeListener;", "listener", "setOnSegmentSelectedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setSelectedIndex", "j", "Lkotlin/jvm/functions/Function1;", "segmentSelectedChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SegmentedControlContainer extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> segmentSelectedChangeListener;

    /* compiled from: SegmentedControlContainer.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ SegmentedControlContainer k;

        public a(int i, SegmentedControlContainer segmentedControlContainer) {
            this.j = i;
            this.k = segmentedControlContainer;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Integer, Unit> function1 = this.k.segmentSelectedChangeListener;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.j));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedControlContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void b(SegmentedControlContainer segmentedControlContainer, int i, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        segmentedControlContainer.a(i);
    }

    public final void a(int selectedIndex) {
        int i = 0;
        for (View view : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            View view2 = view;
            if (!(view2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            view2.setOnClickListener(new a(i, this));
            i = i2;
        }
        setSelectedIndex(selectedIndex);
    }

    public final void setOnSegmentSelectedChangeListener(Function1<? super Integer, Unit> listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.segmentSelectedChangeListener = listener;
    }

    public final void setSelectedIndex(int selectedIndex) {
        int i = 0;
        for (KeyEvent.Callback callback : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            KeyEvent.Callback callback2 = (View) callback;
            if (!(callback2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            ((SegmentedControlSegment) callback2).a(i == selectedIndex);
            i = i2;
        }
    }
}
