package com.discord.utilities.recycler;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpeedOnScrollListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 $2\u00020\u0001:\u0001$B;\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001a¨\u0006%"}, d2 = {"Lcom/discord/utilities/recycler/SpeedOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "Lkotlin/Function1;", "", "thresholdCallback", "Lkotlin/jvm/functions/Function1;", "getThresholdCallback", "()Lkotlin/jvm/functions/Function1;", "", "maxScrolledPxPerMs", "J", "getMaxScrolledPxPerMs", "()J", "orientation", "I", "getOrientation", "()I", "timeStamp", "<init>", "(JLkotlin/jvm/functions/Function1;ILcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpeedOnScrollListener extends RecyclerView.OnScrollListener {
    private static final long INIT_TIMESTAMP = -1;
    private final Clock clock;
    private final long maxScrolledPxPerMs;
    private final int orientation;
    private final Function1<Boolean, Unit> thresholdCallback;
    private long timeStamp;

    /* compiled from: SpeedOnScrollListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.SpeedOnScrollListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
        }
    }

    public SpeedOnScrollListener() {
        this(0L, null, 0, null, 15, null);
    }

    public /* synthetic */ SpeedOnScrollListener(long j, Function1 function1, int i, Clock clock, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1L : j, (i2 & 2) != 0 ? AnonymousClass1.INSTANCE : function1, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? ClockFactory.get() : clock);
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final long getMaxScrolledPxPerMs() {
        return this.maxScrolledPxPerMs;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final Function1<Boolean, Unit> getThresholdCallback() {
        return this.thresholdCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            this.thresholdCallback.invoke(Boolean.valueOf(0 < this.maxScrolledPxPerMs));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.timeStamp == -1) {
            this.timeStamp = jCurrentTimeMillis;
            return;
        }
        if (this.orientation == 1) {
            dx = dy;
        }
        float fAbs = Math.abs(dx / (jCurrentTimeMillis - r2));
        this.timeStamp = jCurrentTimeMillis;
        this.thresholdCallback.invoke(Boolean.valueOf(fAbs <= ((float) this.maxScrolledPxPerMs)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpeedOnScrollListener(long j, Function1<? super Boolean, Unit> function1, int i, Clock clock) {
        Intrinsics3.checkNotNullParameter(function1, "thresholdCallback");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.maxScrolledPxPerMs = j;
        this.thresholdCallback = function1;
        this.orientation = i;
        this.clock = clock;
        this.timeStamp = -1L;
    }
}
