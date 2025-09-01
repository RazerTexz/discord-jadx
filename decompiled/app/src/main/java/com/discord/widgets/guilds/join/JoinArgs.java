package com.discord.widgets.guilds.join;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u000e\u0010\u001d\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u000f\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u009a\u0001\u0010#\u001a\u00020\u00002\f\b\u0002\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\f\b\u0002\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b%\u0010\fJ\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u000eR\u001d\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b0\u0010\u0011R\u001d\u0010\u001b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u0005R%\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b4\u0010\u0016R!\u0010\u001d\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\fR\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b\u001c\u0010\bR'\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b8\u0010\u0016R'\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b9\u0010\u0016¨\u0006<"}, d2 = {"Lcom/discord/widgets/guilds/join/JoinArgs;", "Lcom/discord/widgets/guilds/join/CaptchaArgs;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Z", "", "Lcom/discord/primitives/SessionId;", "component3", "()Ljava/lang/String;", "component4", "()Ljava/lang/Long;", "Ljava/lang/Class;", "component5", "()Ljava/lang/Class;", "Lkotlin/Function1;", "Lrx/Subscription;", "", "component6", "()Lkotlin/jvm/functions/Function1;", "Lcom/discord/utilities/error/Error;", "component7", "Lcom/discord/api/guild/Guild;", "component8", "guildId", "isLurker", "sessionId", "directoryChannelId", "errorClass", "subscriptionHandler", "errorHandler", "onNext", "copy", "(JZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/guilds/join/JoinArgs;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getDirectoryChannelId", "Ljava/lang/Class;", "getErrorClass", "J", "getGuildId", "Lkotlin/jvm/functions/Function1;", "getOnNext", "Ljava/lang/String;", "getSessionId", "Z", "getErrorHandler", "getSubscriptionHandler", "<init>", "(JZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class JoinArgs extends CaptchaArgs {
    private final Long directoryChannelId;
    private final Class<?> errorClass;
    private final Function1<Error, Unit> errorHandler;
    private final long guildId;
    private final boolean isLurker;
    private final Function1<Guild, Unit> onNext;
    private final String sessionId;
    private final Function1<Subscription, Unit> subscriptionHandler;

    public /* synthetic */ JoinArgs(long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z2, str, l, cls, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : function12, function13);
    }

    public static /* synthetic */ JoinArgs copy$default(JoinArgs joinArgs, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        return joinArgs.copy((i & 1) != 0 ? joinArgs.guildId : j, (i & 2) != 0 ? joinArgs.isLurker : z2, (i & 4) != 0 ? joinArgs.sessionId : str, (i & 8) != 0 ? joinArgs.directoryChannelId : l, (i & 16) != 0 ? joinArgs.errorClass : cls, (i & 32) != 0 ? joinArgs.subscriptionHandler : function1, (i & 64) != 0 ? joinArgs.errorHandler : function12, (i & 128) != 0 ? joinArgs.onNext : function13);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsLurker() {
        return this.isLurker;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final Class<?> component5() {
        return this.errorClass;
    }

    public final Function1<Subscription, Unit> component6() {
        return this.subscriptionHandler;
    }

    public final Function1<Error, Unit> component7() {
        return this.errorHandler;
    }

    public final Function1<Guild, Unit> component8() {
        return this.onNext;
    }

    public final JoinArgs copy(long guildId, boolean isLurker, String sessionId, Long directoryChannelId, Class<?> errorClass, Function1<? super Subscription, Unit> subscriptionHandler, Function1<? super Error, Unit> errorHandler, Function1<? super Guild, Unit> onNext) {
        Intrinsics3.checkNotNullParameter(errorClass, "errorClass");
        Intrinsics3.checkNotNullParameter(onNext, "onNext");
        return new JoinArgs(guildId, isLurker, sessionId, directoryChannelId, errorClass, subscriptionHandler, errorHandler, onNext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinArgs)) {
            return false;
        }
        JoinArgs joinArgs = (JoinArgs) other;
        return this.guildId == joinArgs.guildId && this.isLurker == joinArgs.isLurker && Intrinsics3.areEqual(this.sessionId, joinArgs.sessionId) && Intrinsics3.areEqual(this.directoryChannelId, joinArgs.directoryChannelId) && Intrinsics3.areEqual(this.errorClass, joinArgs.errorClass) && Intrinsics3.areEqual(this.subscriptionHandler, joinArgs.subscriptionHandler) && Intrinsics3.areEqual(this.errorHandler, joinArgs.errorHandler) && Intrinsics3.areEqual(this.onNext, joinArgs.onNext);
    }

    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final Class<?> getErrorClass() {
        return this.errorClass;
    }

    public final Function1<Error, Unit> getErrorHandler() {
        return this.errorHandler;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Function1<Guild, Unit> getOnNext() {
        return this.onNext;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Function1<Subscription, Unit> getSubscriptionHandler() {
        return this.subscriptionHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.isLurker;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        String str = this.sessionId;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.directoryChannelId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Class<?> cls = this.errorClass;
        int iHashCode3 = (iHashCode2 + (cls != null ? cls.hashCode() : 0)) * 31;
        Function1<Subscription, Unit> function1 = this.subscriptionHandler;
        int iHashCode4 = (iHashCode3 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function1<Error, Unit> function12 = this.errorHandler;
        int iHashCode5 = (iHashCode4 + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1<Guild, Unit> function13 = this.onNext;
        return iHashCode5 + (function13 != null ? function13.hashCode() : 0);
    }

    public final boolean isLurker() {
        return this.isLurker;
    }

    public String toString() {
        StringBuilder sbU = outline.U("JoinArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", isLurker=");
        sbU.append(this.isLurker);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", errorClass=");
        sbU.append(this.errorClass);
        sbU.append(", subscriptionHandler=");
        sbU.append(this.subscriptionHandler);
        sbU.append(", errorHandler=");
        sbU.append(this.errorHandler);
        sbU.append(", onNext=");
        sbU.append(this.onNext);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JoinArgs(long j, boolean z2, String str, Long l, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, Function1<? super Guild, Unit> function13) {
        super(null);
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function13, "onNext");
        this.guildId = j;
        this.isLurker = z2;
        this.sessionId = str;
        this.directoryChannelId = l;
        this.errorClass = cls;
        this.subscriptionHandler = function1;
        this.errorHandler = function12;
        this.onNext = function13;
    }
}
