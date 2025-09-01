package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: OptionRange.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/input/models/OptionRange;", "", "Lkotlin/ranges/IntRange;", "component1", "()Lkotlin/ranges/IntRange;", "component2", "param", "value", "copy", "(Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;)Lcom/discord/widgets/chat/input/models/OptionRange;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/IntRange;", "getParam", "getValue", "<init>", "(Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class OptionRange {
    private final Ranges2 param;
    private final Ranges2 value;

    public OptionRange(Ranges2 ranges2, Ranges2 ranges22) {
        Intrinsics3.checkNotNullParameter(ranges2, "param");
        Intrinsics3.checkNotNullParameter(ranges22, "value");
        this.param = ranges2;
        this.value = ranges22;
    }

    public static /* synthetic */ OptionRange copy$default(OptionRange optionRange, Ranges2 ranges2, Ranges2 ranges22, int i, Object obj) {
        if ((i & 1) != 0) {
            ranges2 = optionRange.param;
        }
        if ((i & 2) != 0) {
            ranges22 = optionRange.value;
        }
        return optionRange.copy(ranges2, ranges22);
    }

    /* renamed from: component1, reason: from getter */
    public final Ranges2 getParam() {
        return this.param;
    }

    /* renamed from: component2, reason: from getter */
    public final Ranges2 getValue() {
        return this.value;
    }

    public final OptionRange copy(Ranges2 param, Ranges2 value) {
        Intrinsics3.checkNotNullParameter(param, "param");
        Intrinsics3.checkNotNullParameter(value, "value");
        return new OptionRange(param, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionRange)) {
            return false;
        }
        OptionRange optionRange = (OptionRange) other;
        return Intrinsics3.areEqual(this.param, optionRange.param) && Intrinsics3.areEqual(this.value, optionRange.value);
    }

    public final Ranges2 getParam() {
        return this.param;
    }

    public final Ranges2 getValue() {
        return this.value;
    }

    public int hashCode() {
        Ranges2 ranges2 = this.param;
        int iHashCode = (ranges2 != null ? ranges2.hashCode() : 0) * 31;
        Ranges2 ranges22 = this.value;
        return iHashCode + (ranges22 != null ? ranges22.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OptionRange(param=");
        sbU.append(this.param);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(")");
        return sbU.toString();
    }
}
