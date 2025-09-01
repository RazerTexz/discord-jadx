package com.discord.utilities.intent;

import a0.a.a.b;
import android.net.Uri;
import b.a.d.m0.RoutingPatterns;
import b.d.b.a.outline;
import d0.LazyJVM;
import d0.g0.StringNumberConversions;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: StaticChannelRoutes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\t\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/discord/utilities/intent/StaticChannelRoutes;", "", "", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "WithGuild", "ROLE_SUBSCRIPTIONS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum StaticChannelRoutes {
    ROLE_SUBSCRIPTIONS("role-subscriptions");

    private final String route;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy routeToName$delegate = LazyJVM.lazy(StaticChannelRoutes2.INSTANCE);

    /* compiled from: StaticChannelRoutes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\nR)\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/intent/StaticChannelRoutes$Companion;", "", "", "route", "Lcom/discord/utilities/intent/StaticChannelRoutes;", "fromRoute", "(Ljava/lang/String;)Lcom/discord/utilities/intent/StaticChannelRoutes;", "Landroid/net/Uri;", "Lcom/discord/utilities/intent/StaticChannelRoutes$WithGuild;", "extractStaticRoute", "(Landroid/net/Uri;)Lcom/discord/utilities/intent/StaticChannelRoutes$WithGuild;", "", "routeToName$delegate", "Lkotlin/Lazy;", "getRouteToName", "()Ljava/util/Map;", "routeToName", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final StaticChannelRoutes fromRoute(String route) {
            return getRouteToName().get(route);
        }

        private final Map<String, StaticChannelRoutes> getRouteToName() {
            Lazy lazyAccess$getRouteToName$cp = StaticChannelRoutes.access$getRouteToName$cp();
            Companion companion = StaticChannelRoutes.INSTANCE;
            return (Map) lazyAccess$getRouteToName$cp.getValue();
        }

        public final WithGuild extractStaticRoute(Uri uri) {
            String path;
            StaticChannelRoutes staticChannelRoutesFromRoute;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(uri, "$this$extractStaticRoute");
            if ((uri.getHost() == null || IntentUtils.INSTANCE.isHttpDomainUrl(uri)) && (path = uri.getPath()) != null) {
                RoutingPatterns routingPatterns = RoutingPatterns.G;
                Regex regex = RoutingPatterns.u;
                Intrinsics3.checkNotNullExpressionValue(path, "path");
                MatchResult matchResultMatchEntire = regex.matchEntire(path);
                if (matchResultMatchEntire != null && (staticChannelRoutesFromRoute = fromRoute((String) _Collections.getOrNull(matchResultMatchEntire.getGroupValues(), 2))) != null) {
                    String str = (String) _Collections.getOrNull(matchResultMatchEntire.getGroupValues(), 1);
                    return new WithGuild(staticChannelRoutesFromRoute, (str == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StaticChannelRoutes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\u0010\n\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001d\u0010\n\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/intent/StaticChannelRoutes$WithGuild;", "", "Lcom/discord/utilities/intent/StaticChannelRoutes;", "component1", "()Lcom/discord/utilities/intent/StaticChannelRoutes;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "route", "guildId", "copy", "(Lcom/discord/utilities/intent/StaticChannelRoutes;J)Lcom/discord/utilities/intent/StaticChannelRoutes$WithGuild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/intent/StaticChannelRoutes;", "getRoute", "J", "getGuildId", "<init>", "(Lcom/discord/utilities/intent/StaticChannelRoutes;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class WithGuild {
        private final long guildId;
        private final StaticChannelRoutes route;

        public WithGuild(StaticChannelRoutes staticChannelRoutes, long j) {
            Intrinsics3.checkNotNullParameter(staticChannelRoutes, "route");
            this.route = staticChannelRoutes;
            this.guildId = j;
        }

        public static /* synthetic */ WithGuild copy$default(WithGuild withGuild, StaticChannelRoutes staticChannelRoutes, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                staticChannelRoutes = withGuild.route;
            }
            if ((i & 2) != 0) {
                j = withGuild.guildId;
            }
            return withGuild.copy(staticChannelRoutes, j);
        }

        /* renamed from: component1, reason: from getter */
        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final WithGuild copy(StaticChannelRoutes route, long guildId) {
            Intrinsics3.checkNotNullParameter(route, "route");
            return new WithGuild(route, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WithGuild)) {
                return false;
            }
            WithGuild withGuild = (WithGuild) other;
            return Intrinsics3.areEqual(this.route, withGuild.route) && this.guildId == withGuild.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        public int hashCode() {
            StaticChannelRoutes staticChannelRoutes = this.route;
            return b.a(this.guildId) + ((staticChannelRoutes != null ? staticChannelRoutes.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("WithGuild(route=");
            sbU.append(this.route);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }
    }

    StaticChannelRoutes(String str) {
        this.route = str;
    }

    public static final /* synthetic */ Lazy access$getRouteToName$cp() {
        return routeToName$delegate;
    }

    public final String getRoute() {
        return this.route;
    }
}
