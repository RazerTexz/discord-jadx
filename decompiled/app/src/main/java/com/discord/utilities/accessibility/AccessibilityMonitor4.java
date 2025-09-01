package com.discord.utilities.accessibility;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AccessibilityMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityState;", "", "Ljava/util/EnumSet;", "Lcom/discord/utilities/accessibility/AccessibilityFeatureFlags;", "component1", "()Ljava/util/EnumSet;", "features", "copy", "(Ljava/util/EnumSet;)Lcom/discord/utilities/accessibility/AccessibilityState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/EnumSet;", "getFeatures", "<init>", "(Ljava/util/EnumSet;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.accessibility.AccessibilityState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class AccessibilityMonitor4 {
    private final EnumSet<AccessibilityFeatureFlags> features;

    public AccessibilityMonitor4() {
        this(null, 1, null);
    }

    public AccessibilityMonitor4(EnumSet<AccessibilityFeatureFlags> enumSet) {
        Intrinsics3.checkNotNullParameter(enumSet, "features");
        this.features = enumSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccessibilityMonitor4 copy$default(AccessibilityMonitor4 accessibilityMonitor4, EnumSet enumSet, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = accessibilityMonitor4.features;
        }
        return accessibilityMonitor4.copy(enumSet);
    }

    public final EnumSet<AccessibilityFeatureFlags> component1() {
        return this.features;
    }

    public final AccessibilityMonitor4 copy(EnumSet<AccessibilityFeatureFlags> features) {
        Intrinsics3.checkNotNullParameter(features, "features");
        return new AccessibilityMonitor4(features);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AccessibilityMonitor4) && Intrinsics3.areEqual(this.features, ((AccessibilityMonitor4) other).features);
        }
        return true;
    }

    public final EnumSet<AccessibilityFeatureFlags> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        EnumSet<AccessibilityFeatureFlags> enumSet = this.features;
        if (enumSet != null) {
            return enumSet.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AccessibilityState(features=");
        sbU.append(this.features);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AccessibilityMonitor4(EnumSet enumSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.of(AccessibilityFeatureFlags.NONE);
            Intrinsics3.checkNotNullExpressionValue(enumSet, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        }
        this(enumSet);
    }
}
