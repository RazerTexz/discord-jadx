package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNavigation;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreLurking.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u0001:\u0003YZ[B\u001f\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bW\u0010XJ{\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001a0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\nH\u0001¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020#H\u0001¢\u0006\u0004\b \u0010$J\u001b\u0010\"\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0001¢\u0006\u0004\b \u0010%J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b&\u0010'J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020#H\u0001¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020#H\u0001¢\u0006\u0004\b0\u0010.J\u001b\u00103\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0001¢\u0006\u0004\b2\u0010\u0014J\u001b\u00105\u001a\u00020\u000b2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005H\u0001¢\u0006\u0004\b4\u0010\u0014Jm\u00106\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b6\u00107J5\u00108\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u00020\u000b2\n\u0010:\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b;\u0010\u0014J5\u0010<\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b<\u0010\u0018J!\u0010=\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010G\u001a\n\u0018\u00010Ej\u0004\u0018\u0001`F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HRz\u0010M\u001af\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020K L*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020K\u0018\u00010J0J L*2\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020K L*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020K\u0018\u00010J0J\u0018\u00010I0I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR&\u0010O\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020K0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Lcom/discord/stores/StoreLurking;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "navigateToGuild", "Lkotlin/Function3;", "Lcom/discord/models/guild/Guild;", "", "onGuildLurked", "Lkotlin/Function0;", "onErrorLurking", "Landroid/content/Context;", "context", "startLurkingInternal", "(JLjava/lang/Long;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroid/content/Context;)V", "stopLurkingInternal", "(J)V", "onSuccess", "onFailure", "postLeaveGuild", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lrx/Observable;", "", "getLurkingGuildIds", "()Lrx/Observable;", "getLurkingGuildIdsSync", "()Ljava/util/Set;", "guild", "isLurking$app_productionGoogleRelease", "(Lcom/discord/models/guild/Guild;)Z", "isLurking", "Lcom/discord/api/guild/Guild;", "(Lcom/discord/api/guild/Guild;)Z", "(J)Z", "isLurkingObs", "(J)Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen$app_productionGoogleRelease", "(Lcom/discord/models/domain/ModelPayload;)V", "handleConnectionOpen", "handleGuildAdd$app_productionGoogleRelease", "(Lcom/discord/api/guild/Guild;)V", "handleGuildAdd", "handleGuildRemove$app_productionGoogleRelease", "handleGuildRemove", "handleGuildSelected$app_productionGoogleRelease", "handleGuildSelected", "handleVoiceChannelSelected$app_productionGoogleRelease", "handleVoiceChannelSelected", "startLurking", "(JLjava/lang/Long;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "startLurkingAndNavigate", "(JLjava/lang/Long;Landroid/content/Context;)V", "currentlyLurkedGuildId", "removeOldLurkingGuilds", "stopLurking", "postJoinGuildAsMember", "(JLandroid/content/Context;)V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreLurking$LurkRequest;", "lurkRequest", "Lcom/discord/stores/StoreLurking$LurkRequest;", "", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "Lrx/subjects/BehaviorSubject;", "", "Lcom/discord/stores/StoreLurking$LurkContext;", "kotlin.jvm.PlatformType", "lurkedGuildsSubject", "Lrx/subjects/BehaviorSubject;", "lurkedGuilds", "Ljava/util/Map;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/Dispatcher;)V", "Companion", "LurkContext", "LurkRequest", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreLurking {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final StoreGuilds guildsStore;
    private LurkRequest lurkRequest;
    private final Map<Long, LurkContext> lurkedGuilds;
    private final BehaviorSubject<Map<Long, LurkContext>> lurkedGuildsSubject;
    private String sessionId;
    private final StoreStream stream;

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0007H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreLurking$Companion;", "", "", "isJoined", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "lurkingGuildIds", "isLurking", "(ZJLjava/util/Set;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isLurking(Companion companion, boolean z2, long j, Set set) {
            return companion.isLurking(z2, j, set);
        }

        private final boolean isLurking(boolean isJoined, long guildId, Set<Long> lurkingGuildIds) {
            return !isJoined && lurkingGuildIds.contains(Long.valueOf(guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreLurking$LurkContext;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Z", "guildId", "shouldNavigate", "copy", "(JZ)Lcom/discord/stores/StoreLurking$LurkContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "Z", "getShouldNavigate", "<init>", "(JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class LurkContext {
        private final long guildId;
        private final boolean shouldNavigate;

        public LurkContext(long j, boolean z2) {
            this.guildId = j;
            this.shouldNavigate = z2;
        }

        public static /* synthetic */ LurkContext copy$default(LurkContext lurkContext, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lurkContext.guildId;
            }
            if ((i & 2) != 0) {
                z2 = lurkContext.shouldNavigate;
            }
            return lurkContext.copy(j, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShouldNavigate() {
            return this.shouldNavigate;
        }

        public final LurkContext copy(long guildId, boolean shouldNavigate) {
            return new LurkContext(guildId, shouldNavigate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LurkContext)) {
                return false;
            }
            LurkContext lurkContext = (LurkContext) other;
            return this.guildId == lurkContext.guildId && this.shouldNavigate == lurkContext.shouldNavigate;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getShouldNavigate() {
            return this.shouldNavigate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            boolean z2 = this.shouldNavigate;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iA + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("LurkContext(guildId=");
            sbU.append(this.guildId);
            sbU.append(", shouldNavigate=");
            return outline.O(sbU, this.shouldNavigate, ")");
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreLurking$LurkRequest;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/lang/Long;", "guildId", "channelId", "copy", "(JLjava/lang/Long;)Lcom/discord/stores/StoreLurking$LurkRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getChannelId", "J", "getGuildId", "<init>", "(JLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class LurkRequest {
        private final Long channelId;
        private final long guildId;

        public LurkRequest(long j, Long l) {
            this.guildId = j;
            this.channelId = l;
        }

        public static /* synthetic */ LurkRequest copy$default(LurkRequest lurkRequest, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lurkRequest.guildId;
            }
            if ((i & 2) != 0) {
                l = lurkRequest.channelId;
            }
            return lurkRequest.copy(j, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        public final LurkRequest copy(long guildId, Long channelId) {
            return new LurkRequest(guildId, channelId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LurkRequest)) {
                return false;
            }
            LurkRequest lurkRequest = (LurkRequest) other;
            return this.guildId == lurkRequest.guildId && Intrinsics3.areEqual(this.channelId, lurkRequest.channelId);
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            Long l = this.channelId;
            return iA + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("LurkRequest(guildId=");
            sbU.append(this.guildId);
            sbU.append(", channelId=");
            return outline.G(sbU, this.channelId, ")");
        }

        public /* synthetic */ LurkRequest(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : l);
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/stores/StoreLurking$LurkContext;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$getLurkingGuildIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, LurkContext>, Set<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, LurkContext> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, LurkContext> map) {
            return map.keySet();
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\n\u001a\n \u0003*\u0004\u0018\u00010\u00070\u00072\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "lurkingGuildIds", "Lcom/discord/models/guild/Guild;", "guild", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;Lcom/discord/models/guild/Guild;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$isLurkingObs$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Set<? extends Long>, Guild, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set, Guild guild) {
            return call2((Set<Long>) set, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set, Guild guild) {
            if (guild != null) {
                Companion companion = StoreLurking.INSTANCE;
                zAccess$isLurking = guild.getJoinedAt() != null;
                long id2 = guild.getId();
                Intrinsics3.checkNotNullExpressionValue(set, "lurkingGuildIds");
                zAccess$isLurking = Companion.access$isLurking(companion, zAccess$isLurking, id2, set);
            }
            return Boolean.valueOf(zAccess$isLurking);
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$postJoinGuildAsMember$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$postLeaveGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$postLeaveGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$postLeaveGuild$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$postLeaveGuild$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/ChannelId;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke", "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Guild, Long, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
            invoke(guild, l, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Guild guild, Long l, boolean z2) {
            Intrinsics3.checkNotNullParameter(guild, "<anonymous parameter 0>");
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurking$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurking$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $navigateToGuild;
        public final /* synthetic */ Function0 $onErrorLurking;
        public final /* synthetic */ Function3 $onGuildLurked;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j, Long l, boolean z2, Function3 function3, Function0 function0) {
            super(0);
            this.$guildId = j;
            this.$channelId = l;
            this.$navigateToGuild = z2;
            this.$onGuildLurked = function3;
            this.$onErrorLurking = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreLurking.startLurkingInternal$default(StoreLurking.this, this.$guildId, this.$channelId, this.$navigateToGuild, this.$onGuildLurked, this.$onErrorLurking, null, 32, null);
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreLurking.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "alreadyJoined", "", "invoke", "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01461 extends Lambda implements Function3<Guild, Long, Boolean, Unit> {

            /* compiled from: StoreLurking.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "it", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01471 extends Lambda implements Function1<FragmentActivity, Boolean> {
                public static final C01471 INSTANCE = new C01471();

                public C01471() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
                    return Boolean.valueOf(invoke2(fragmentActivity));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(FragmentActivity fragmentActivity) {
                    Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
                    StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.OPEN, null, 2, null);
                    return true;
                }
            }

            public C01461() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
                invoke(guild, l, bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(Guild guild, Long l, boolean z2) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                StoreLurking2 storeLurking2 = new StoreLurking2(this, l);
                if (z2) {
                    storeLurking2.invoke();
                    return;
                }
                if (z2) {
                    return;
                }
                storeLurking2.invoke();
                StoreLurking.access$getStream$p(StoreLurking.this).handleGuildJoined(AnonymousClass1.this.$guildId, guild.getWelcomeScreen());
                StoreNavigation navigation = StoreStream.INSTANCE.getNavigation();
                StringBuilder sbU = outline.U("LURK:");
                sbU.append(AnonymousClass1.this.$guildId);
                navigation.launchNotice(sbU.toString(), C01471.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, Context context) {
            super(0);
            this.$guildId = j;
            this.$channelId = l;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreLurking.access$getSessionId$p(StoreLurking.this) != null) {
                StoreLurking.startLurkingInternal$default(StoreLurking.this, this.$guildId, this.$channelId, false, new C01461(), null, this.$context, 20, null);
                return;
            }
            StringBuilder sbU = outline.U("Queue lurk request: ");
            sbU.append(this.$guildId);
            sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            sbU.append(this.$channelId);
            AppLog.i(sbU.toString());
            StoreLurking.access$setLurkRequest$p(StoreLurking.this, new LurkRequest(this.$guildId, this.$channelId));
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/ChannelId;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke", "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Guild, Long, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
            invoke(guild, l, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Guild guild, Long l, boolean z2) {
            Intrinsics3.checkNotNullParameter(guild, "<anonymous parameter 0>");
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreLurking.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreLurking.access$getLurkedGuilds$p(StoreLurking.this).remove(Long.valueOf(AnonymousClass3.this.$guildId));
                StoreLurking.access$getLurkedGuildsSubject$p(StoreLurking.this).onNext(StoreLurking.access$getLurkedGuilds$p(StoreLurking.this));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            error.setShowErrorToasts(StoreLurking.this.isLurking$app_productionGoogleRelease(this.$guildId));
            StoreLurking.access$getDispatcher$p(StoreLurking.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreLurking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function3 $onGuildLurked;

        /* compiled from: StoreLurking.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreLurking$startLurkingInternal$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ com.discord.api.guild.Guild $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(com.discord.api.guild.Guild guild) {
                super(0);
                this.$it = guild;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (!StoreLurking.this.isLurking$app_productionGoogleRelease(this.$it)) {
                    StoreLurking.access$getLurkedGuilds$p(StoreLurking.this).remove(Long.valueOf(AnonymousClass4.this.$guildId));
                    StoreLurking.access$getLurkedGuildsSubject$p(StoreLurking.this).onNext(StoreLurking.access$getLurkedGuilds$p(StoreLurking.this));
                }
                AnonymousClass4.this.$onGuildLurked.invoke(new Guild(this.$it), AnonymousClass4.this.$channelId, Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(long j, Function3 function3, Long l) {
            super(1);
            this.$guildId = j;
            this.$onGuildLurked = function3;
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            StoreLurking.access$getDispatcher$p(StoreLurking.this).schedule(new AnonymousClass1(guild));
        }
    }

    public StoreLurking(StoreStream storeStream, StoreGuilds storeGuilds, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.lurkedGuilds = new LinkedHashMap();
        this.lurkedGuildsSubject = BehaviorSubject.l0(new LinkedHashMap());
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreLurking storeLurking) {
        return storeLurking.dispatcher;
    }

    public static final /* synthetic */ LurkRequest access$getLurkRequest$p(StoreLurking storeLurking) {
        return storeLurking.lurkRequest;
    }

    public static final /* synthetic */ Map access$getLurkedGuilds$p(StoreLurking storeLurking) {
        return storeLurking.lurkedGuilds;
    }

    public static final /* synthetic */ BehaviorSubject access$getLurkedGuildsSubject$p(StoreLurking storeLurking) {
        return storeLurking.lurkedGuildsSubject;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreLurking storeLurking) {
        return storeLurking.sessionId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreLurking storeLurking) {
        return storeLurking.stream;
    }

    public static final /* synthetic */ void access$setLurkRequest$p(StoreLurking storeLurking, LurkRequest lurkRequest) {
        storeLurking.lurkRequest = lurkRequest;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreLurking storeLurking, String str) {
        storeLurking.sessionId = str;
    }

    private final void postLeaveGuild(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveGuild(guildId, new RestAPIParams.LeaveGuildBody(true)), false, 1, null), StoreLurking.class, (Context) null, (Function1) null, new AnonymousClass3(onFailure), (Function0) null, (Function0) null, new AnonymousClass4(onSuccess), 54, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postLeaveGuild$default(StoreLurking storeLurking, long j, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = AnonymousClass1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function02 = AnonymousClass2.INSTANCE;
        }
        storeLurking.postLeaveGuild(j, function0, function02);
    }

    public static /* synthetic */ void startLurking$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z2;
        if ((i & 8) != 0) {
            function3 = AnonymousClass1.INSTANCE;
        }
        Function3 function32 = function3;
        if ((i & 16) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        storeLurking.startLurking(j, l, z3, function32, function0);
    }

    public static /* synthetic */ void startLurkingAndNavigate$default(StoreLurking storeLurking, long j, Long l, Context context, int i, Object obj) {
        if ((i & 4) != 0) {
            context = null;
        }
        storeLurking.startLurkingAndNavigate(j, l, context);
    }

    @Store3
    private final void startLurkingInternal(long guildId, Long channelId, boolean navigateToGuild, Function3<? super Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking, Context context) {
        if (this.sessionId == null) {
            Logger.w$default(AppLog.g, "Cannot lurk " + guildId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + channelId + " with no session", null, 2, null);
            onErrorLurking.invoke();
            return;
        }
        if (guildId != 0 || guildId == -1) {
            Guild guild = this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
            if (guild != null && !isLurking$app_productionGoogleRelease(guild)) {
                onGuildLurked.invoke(guild, channelId, Boolean.TRUE);
                return;
            }
            this.lurkedGuilds.put(Long.valueOf(guildId), new LurkContext(guildId, navigateToGuild));
            this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.joinGuild$default(RestAPI.INSTANCE.getApi(), guildId, true, this.sessionId, null, new RestAPIParams.InviteCode(null, null), null, 32, null), false, 1, null)), StoreLurking.class, context, (Function1) null, new AnonymousClass3(guildId), (Function0) null, (Function0) null, new AnonymousClass4(guildId, onGuildLurked, channelId), 52, (Object) null);
            return;
        }
        Logger.w$default(AppLog.g, "Invalid ids for lurking " + guildId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + channelId, null, 2, null);
        onErrorLurking.invoke();
    }

    public static /* synthetic */ void startLurkingInternal$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, Context context, int i, Object obj) {
        storeLurking.startLurkingInternal(j, l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function3, (i & 16) != 0 ? AnonymousClass2.INSTANCE : function0, (i & 32) != 0 ? null : context);
    }

    @Store3
    private final void stopLurkingInternal(long guildId) {
        if (this.lurkedGuilds.remove(Long.valueOf(guildId)) != null) {
            this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
        }
    }

    public final Observable<Set<Long>> getLurkingGuildIds() {
        Observable observableG = this.lurkedGuildsSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "lurkedGuildsSubject.map { it.keys }");
        return observableG;
    }

    public final Set<Long> getLurkingGuildIdsSync() {
        return this.lurkedGuilds.keySet();
    }

    @Store3
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        LurkRequest lurkRequest = this.lurkRequest;
        if (lurkRequest != null) {
            AppLog.i("Processing lurk request from app link");
            startLurkingAndNavigate$default(this, lurkRequest.getGuildId(), lurkRequest.getChannelId(), null, 4, null);
        }
        this.lurkRequest = null;
    }

    @Store3
    public final void handleGuildAdd$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        LurkContext lurkContext;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.lurkedGuilds.keySet().contains(Long.valueOf(guild.getId()))) {
            if (guild.getJoinedAt() == null && (lurkContext = this.lurkedGuilds.get(Long.valueOf(guild.getId()))) != null && lurkContext.getShouldNavigate()) {
                this.stream.getGuildSelected().handleGuildSelected(guild.getId());
            } else if (guild.getJoinedAt() != null) {
                stopLurkingInternal(guild.getId());
            }
        }
    }

    @Store3
    public final void handleGuildRemove$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        stopLurkingInternal(guild.getId());
    }

    @Store3
    public final void handleGuildSelected$app_productionGoogleRelease(long guildId) {
        LurkRequest lurkRequest = this.lurkRequest;
        if ((lurkRequest == null || guildId != lurkRequest.getGuildId()) && this.sessionId != null) {
            this.lurkRequest = null;
        }
        removeOldLurkingGuilds(guildId);
    }

    @Store3
    public final void handleVoiceChannelSelected$app_productionGoogleRelease(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (channel == null || ((Number) obj).longValue() != channel.getGuildId()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (jLongValue != this.stream.getGuildSelected().getSelectedGuildIdInternal$app_productionGoogleRelease()) {
                postLeaveGuild$default(this, jLongValue, null, null, 6, null);
            }
        }
    }

    @Store3
    public final boolean isLurking$app_productionGoogleRelease(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return Companion.access$isLurking(INSTANCE, guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    public final Observable<Boolean> isLurkingObs(long guildId) {
        Observable<Boolean> observableR = Observable.j(getLurkingGuildIds(), this.stream.getGuilds().observeGuild(guildId), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public final void postJoinGuildAsMember(long guildId, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildJoinHelper.joinGuild$default(context, guildId, false, this.sessionId, null, null, StoreLurking.class, null, null, null, AnonymousClass1.INSTANCE, 944, null);
    }

    public final void removeOldLurkingGuilds(long currentlyLurkedGuildId) {
        Channel channel = this.stream.getChannels().getChannel(this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId());
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue != currentlyLurkedGuildId && (lValueOf == null || jLongValue != lValueOf.longValue())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Guild guild = this.guildsStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
            if (guild != null) {
                arrayList2.add(guild);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            postLeaveGuild$default(this, ((Guild) it2.next()).getId(), null, null, 6, null);
        }
    }

    public final void startLurking(long guildId, Long channelId, boolean navigateToGuild, Function3<? super Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking) {
        Intrinsics3.checkNotNullParameter(onGuildLurked, "onGuildLurked");
        Intrinsics3.checkNotNullParameter(onErrorLurking, "onErrorLurking");
        this.dispatcher.schedule(new AnonymousClass3(guildId, channelId, navigateToGuild, onGuildLurked, onErrorLurking));
    }

    public final void startLurkingAndNavigate(long guildId, Long channelId, Context context) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId, context));
    }

    public final void stopLurking(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        postLeaveGuild(guildId, onSuccess, onFailure);
    }

    @Store3
    public final boolean isLurking$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return Companion.access$isLurking(INSTANCE, guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    @Store3
    public final boolean isLurking$app_productionGoogleRelease(long guildId) {
        return Companion.access$isLurking(INSTANCE, false, guildId, this.lurkedGuilds.keySet());
    }
}
