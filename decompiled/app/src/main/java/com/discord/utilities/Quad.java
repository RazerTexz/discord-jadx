package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Quad.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u00012\u00020\u0005B'\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00028\u0002\u0012\u0006\u0010\u0011\u001a\u00028\u0003¢\u0006\u0004\b \u0010!J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\nJP\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u000e\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00028\u00012\b\b\u0002\u0010\u0010\u001a\u00028\u00022\b\b\u0002\u0010\u0011\u001a\u00028\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000f\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\u0011\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000e\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0010\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001f\u0010\n¨\u0006\""}, d2 = {"Lcom/discord/utilities/Quad;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", "", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "first", "second", "third", "fourth", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/discord/utilities/Quad;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getSecond", "getFourth", "getFirst", "getThird", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class Quad<A, B, C, D> {
    private final A first;
    private final D fourth;
    private final B second;
    private final C third;

    public Quad(A a, B b2, C c, D d) {
        this.first = a;
        this.second = b2;
        this.third = c;
        this.fourth = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Quad copy$default(Quad quad, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
        if ((i & 1) != 0) {
            obj = quad.first;
        }
        if ((i & 2) != 0) {
            obj2 = quad.second;
        }
        if ((i & 4) != 0) {
            obj3 = quad.third;
        }
        if ((i & 8) != 0) {
            obj4 = quad.fourth;
        }
        return quad.copy(obj, obj2, obj3, obj4);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.fourth;
    }

    public final Quad<A, B, C, D> copy(A first, B second, C third, D fourth) {
        return new Quad<>(first, second, third, fourth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quad)) {
            return false;
        }
        Quad quad = (Quad) other;
        return Intrinsics3.areEqual(this.first, quad.first) && Intrinsics3.areEqual(this.second, quad.second) && Intrinsics3.areEqual(this.third, quad.third) && Intrinsics3.areEqual(this.fourth, quad.fourth);
    }

    public final A getFirst() {
        return this.first;
    }

    public final D getFourth() {
        return this.fourth;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c = this.third;
        int iHashCode3 = (iHashCode2 + (c != null ? c.hashCode() : 0)) * 31;
        D d = this.fourth;
        return iHashCode3 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbQ = outline.Q('(');
        sbQ.append(this.first);
        sbQ.append(", ");
        sbQ.append(this.second);
        sbQ.append(", ");
        sbQ.append(this.third);
        sbQ.append(", ");
        sbQ.append(this.fourth);
        sbQ.append(')');
        return sbQ.toString();
    }
}
