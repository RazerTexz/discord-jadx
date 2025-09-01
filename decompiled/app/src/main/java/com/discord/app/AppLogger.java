package com.discord.app;

import com.discord.api.science.AnalyticsSchema;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.e0.KProperty3;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AppLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/discord/app/AppLogger;", "", "", "b", "()V", "Lcom/discord/api/science/AnalyticsSchema;", "analyticsSchema", "a", "(Lcom/discord/api/science/AnalyticsSchema;)V", "Lcom/discord/api/science/AnalyticsSchema;", "previousAnalyticsSchema", "Lcom/discord/app/AppLogger$a;", "c", "Lcom/discord/app/AppLogger$a;", "getProvider", "()Lcom/discord/app/AppLogger$a;", "provider", "", "Z", "hasLoggedImpression", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "d", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "getTracker", "()Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "tracker", "e", "isImpressionLoggingEnabled", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AppLogger {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean hasLoggedImpression;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public AnalyticsSchema previousAnalyticsSchema;

    /* renamed from: c, reason: from kotlin metadata */
    public final a provider;

    /* renamed from: d, reason: from kotlin metadata */
    public final AnalyticsUtils.Tracker tracker;

    /* renamed from: e, reason: from kotlin metadata */
    public final boolean isImpressionLoggingEnabled;

    /* compiled from: AppLogger.kt */
    public interface a {
        AppLogger2 getLoggingConfig();
    }

    public AppLogger(a aVar, AnalyticsUtils.Tracker tracker, boolean z2, int i) {
        AnalyticsUtils.Tracker companion = (i & 2) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : null;
        z2 = (i & 4) != 0 ? GrowthTeamFeatures.INSTANCE.isImpressionLoggingEnabled() : z2;
        Intrinsics3.checkNotNullParameter(aVar, "provider");
        Intrinsics3.checkNotNullParameter(companion, "tracker");
        this.provider = aVar;
        this.tracker = companion;
        this.isImpressionLoggingEnabled = z2;
    }

    public final void a(AnalyticsSchema analyticsSchema) {
        Function0<AnalyticsSchema> function0;
        AnalyticsSchema analyticsSchemaInvoke;
        if (analyticsSchema != null) {
            this.tracker.track(analyticsSchema);
            return;
        }
        AppLogger2 loggingConfig = this.provider.getLoggingConfig();
        if (loggingConfig == null || (function0 = loggingConfig.impressionSchemaProvider) == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
            return;
        }
        this.tracker.track(analyticsSchemaInvoke);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b() {
        AnalyticsSchema analyticsSchemaInvoke;
        boolean z2;
        if (this.isImpressionLoggingEnabled) {
            AppLogger2 loggingConfig = this.provider.getLoggingConfig();
            if (loggingConfig != null) {
                Function0<AnalyticsSchema> function0 = loggingConfig.impressionSchemaProvider;
                if (function0 == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
                    return;
                }
                boolean z3 = false;
                if (this.previousAnalyticsSchema == null) {
                    z3 = true;
                    if (this.hasLoggedImpression || z3) {
                        this.previousAnalyticsSchema = analyticsSchemaInvoke;
                        this.hasLoggedImpression = true;
                        a(analyticsSchemaInvoke);
                        return;
                    }
                    return;
                }
                if (loggingConfig.autoLogImpressionOnChanged) {
                    if (!loggingConfig.autoLogImpressionProperties.isEmpty() || !(!Intrinsics3.areEqual(r2, analyticsSchemaInvoke))) {
                        List<KProperty3<?, ?>> list = loggingConfig.autoLogImpressionProperties;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                KProperty3 kProperty3 = (KProperty3) it.next();
                                if ((!(kProperty3 instanceof KProperty3) ? null : kProperty3) != null ? !Intrinsics3.areEqual(kProperty3.get(analyticsSchemaInvoke), kProperty3.get(r2)) : false) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                if (this.hasLoggedImpression) {
                }
                this.previousAnalyticsSchema = analyticsSchemaInvoke;
                this.hasLoggedImpression = true;
                a(analyticsSchemaInvoke);
                return;
            }
        }
    }
}
