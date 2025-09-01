package com.discord.app;

import b.d.b.a.outline;
import com.discord.api.science.AnalyticsSchema;
import d0.e0.KProperty3;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AppLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR'\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/discord/app/LoggingConfig;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Ld0/e0/g;", "b", "Ljava/util/List;", "getAutoLogImpressionProperties", "()Ljava/util/List;", "autoLogImpressionProperties", "Lkotlin/Function0;", "Lcom/discord/api/science/AnalyticsSchema;", "c", "Lkotlin/jvm/functions/Function0;", "getImpressionSchemaProvider", "()Lkotlin/jvm/functions/Function0;", "impressionSchemaProvider", "a", "Z", "getAutoLogImpressionOnChanged", "()Z", "autoLogImpressionOnChanged", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.app.LoggingConfig, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class AppLogger2 {

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean autoLogImpressionOnChanged;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<KProperty3<?, ?>> autoLogImpressionProperties;

    /* renamed from: c, reason: from kotlin metadata */
    public final Function0<AnalyticsSchema> impressionSchemaProvider;

    public AppLogger2() {
        this(false, null, null, 7);
    }

    public AppLogger2(boolean z2, List list, Function0 function0, int i) {
        z2 = (i & 1) != 0 ? true : z2;
        List<KProperty3<?, ?>> listEmptyList = (i & 2) != 0 ? Collections2.emptyList() : null;
        function0 = (i & 4) != 0 ? null : function0;
        Intrinsics3.checkNotNullParameter(listEmptyList, "autoLogImpressionProperties");
        this.autoLogImpressionOnChanged = z2;
        this.autoLogImpressionProperties = listEmptyList;
        this.impressionSchemaProvider = function0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppLogger2)) {
            return false;
        }
        AppLogger2 appLogger2 = (AppLogger2) other;
        return this.autoLogImpressionOnChanged == appLogger2.autoLogImpressionOnChanged && Intrinsics3.areEqual(this.autoLogImpressionProperties, appLogger2.autoLogImpressionProperties) && Intrinsics3.areEqual(this.impressionSchemaProvider, appLogger2.impressionSchemaProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.autoLogImpressionOnChanged;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<KProperty3<?, ?>> list = this.autoLogImpressionProperties;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Function0<AnalyticsSchema> function0 = this.impressionSchemaProvider;
        return iHashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LoggingConfig(autoLogImpressionOnChanged=");
        sbU.append(this.autoLogImpressionOnChanged);
        sbU.append(", autoLogImpressionProperties=");
        sbU.append(this.autoLogImpressionProperties);
        sbU.append(", impressionSchemaProvider=");
        sbU.append(this.impressionSchemaProvider);
        sbU.append(")");
        return sbU.toString();
    }
}
