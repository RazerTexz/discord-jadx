package com.discord.models.commands;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData2;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: ApplicationCommandLocalSendData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\n\u0010 \u001a\u00060\bj\u0002`\u000b\u0012\u000e\u0010!\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r\u0012\u000e\u0010\"\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010&\u001a\u00020\u0014\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bF\u0010GJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\bj\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000fJ\u009e\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\b2\f\b\u0002\u0010 \u001a\u00060\bj\u0002`\u000b2\u0010\b\u0002\u0010!\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r2\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r2\b\b\u0002\u0010#\u001a\u00020\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b,\u0010\u0016J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103R\u001b\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00104\u001a\u0004\b5\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b7\u0010\nR!\u0010!\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b8\u0010\u000fR\u0019\u0010#\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b:\u0010\u0013R\u0019\u0010%\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010;\u001a\u0004\b<\u0010\u0016R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010=\u001a\u0004\b>\u0010\u001cR\u001b\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010;\u001a\u0004\b?\u0010\u0016R\u0019\u0010@\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010\u0016R\u001d\u0010 \u001a\u00060\bj\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00106\u001a\u0004\bB\u0010\nR!\u0010\"\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00104\u001a\u0004\bC\u0010\u000fR\u0019\u0010&\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010;\u001a\u0004\bD\u0010\u0016R\u001b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010;\u001a\u0004\bE\u0010\u0016¨\u0006H"}, d2 = {"Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "", "Lcom/discord/restapi/RestAPIParams$ApplicationCommand;", "toRestApiParam", "()Lcom/discord/restapi/RestAPIParams$ApplicationCommand;", "Lcom/discord/api/commands/ApplicationCommandData;", "toRestApiApplicationCommandDataParam", "()Lcom/discord/api/commands/ApplicationCommandData;", "", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/GuildId;", "component3", "()Ljava/lang/Long;", "component4", "Lcom/discord/models/commands/Application;", "component5", "()Lcom/discord/models/commands/Application;", "", "component6", "()Ljava/lang/String;", "component7", "component8", "", "Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "component9", "()Ljava/util/List;", "component10", "component11", "nonce", "channelId", "guildId", "commandGuildId", "application", "sessionId", "applicationCommandName", "applicationCommandId", "applicationCommandsValues", "version", "interactionId", "copy", "(JJLjava/lang/Long;Ljava/lang/Long;Lcom/discord/models/commands/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getInteractionId", "J", "getNonce", "getGuildId", "Lcom/discord/models/commands/Application;", "getApplication", "Ljava/lang/String;", "getApplicationCommandName", "Ljava/util/List;", "getApplicationCommandsValues", "getVersion", "nonceString", "getNonceString", "getChannelId", "getCommandGuildId", "getApplicationCommandId", "getSessionId", "<init>", "(JJLjava/lang/Long;Ljava/lang/Long;Lcom/discord/models/commands/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandLocalSendData {
    private final Application application;
    private final String applicationCommandId;
    private final String applicationCommandName;
    private final List<ApplicationCommandValue> applicationCommandsValues;
    private final long channelId;
    private final Long commandGuildId;
    private final Long guildId;
    private final Long interactionId;
    private final long nonce;
    private final String nonceString;
    private final String sessionId;
    private final String version;

    public ApplicationCommandLocalSendData(long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List<ApplicationCommandValue> list, String str4, Long l3) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(str2, "applicationCommandName");
        Intrinsics3.checkNotNullParameter(str3, "applicationCommandId");
        Intrinsics3.checkNotNullParameter(list, "applicationCommandsValues");
        this.nonce = j;
        this.channelId = j2;
        this.guildId = l;
        this.commandGuildId = l2;
        this.application = application;
        this.sessionId = str;
        this.applicationCommandName = str2;
        this.applicationCommandId = str3;
        this.applicationCommandsValues = list;
        this.version = str4;
        this.interactionId = l3;
        this.nonceString = String.valueOf(j);
    }

    public static /* synthetic */ ApplicationCommandLocalSendData copy$default(ApplicationCommandLocalSendData applicationCommandLocalSendData, long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List list, String str4, Long l3, int i, Object obj) {
        return applicationCommandLocalSendData.copy((i & 1) != 0 ? applicationCommandLocalSendData.nonce : j, (i & 2) != 0 ? applicationCommandLocalSendData.channelId : j2, (i & 4) != 0 ? applicationCommandLocalSendData.guildId : l, (i & 8) != 0 ? applicationCommandLocalSendData.commandGuildId : l2, (i & 16) != 0 ? applicationCommandLocalSendData.application : application, (i & 32) != 0 ? applicationCommandLocalSendData.sessionId : str, (i & 64) != 0 ? applicationCommandLocalSendData.applicationCommandName : str2, (i & 128) != 0 ? applicationCommandLocalSendData.applicationCommandId : str3, (i & 256) != 0 ? applicationCommandLocalSendData.applicationCommandsValues : list, (i & 512) != 0 ? applicationCommandLocalSendData.version : str4, (i & 1024) != 0 ? applicationCommandLocalSendData.interactionId : l3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNonce() {
        return this.nonce;
    }

    /* renamed from: component10, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getInteractionId() {
        return this.interactionId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getCommandGuildId() {
        return this.commandGuildId;
    }

    /* renamed from: component5, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getApplicationCommandName() {
        return this.applicationCommandName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getApplicationCommandId() {
        return this.applicationCommandId;
    }

    public final List<ApplicationCommandValue> component9() {
        return this.applicationCommandsValues;
    }

    public final ApplicationCommandLocalSendData copy(long nonce, long channelId, Long guildId, Long commandGuildId, Application application, String sessionId, String applicationCommandName, String applicationCommandId, List<ApplicationCommandValue> applicationCommandsValues, String version, Long interactionId) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(applicationCommandName, "applicationCommandName");
        Intrinsics3.checkNotNullParameter(applicationCommandId, "applicationCommandId");
        Intrinsics3.checkNotNullParameter(applicationCommandsValues, "applicationCommandsValues");
        return new ApplicationCommandLocalSendData(nonce, channelId, guildId, commandGuildId, application, sessionId, applicationCommandName, applicationCommandId, applicationCommandsValues, version, interactionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandLocalSendData)) {
            return false;
        }
        ApplicationCommandLocalSendData applicationCommandLocalSendData = (ApplicationCommandLocalSendData) other;
        return this.nonce == applicationCommandLocalSendData.nonce && this.channelId == applicationCommandLocalSendData.channelId && Intrinsics3.areEqual(this.guildId, applicationCommandLocalSendData.guildId) && Intrinsics3.areEqual(this.commandGuildId, applicationCommandLocalSendData.commandGuildId) && Intrinsics3.areEqual(this.application, applicationCommandLocalSendData.application) && Intrinsics3.areEqual(this.sessionId, applicationCommandLocalSendData.sessionId) && Intrinsics3.areEqual(this.applicationCommandName, applicationCommandLocalSendData.applicationCommandName) && Intrinsics3.areEqual(this.applicationCommandId, applicationCommandLocalSendData.applicationCommandId) && Intrinsics3.areEqual(this.applicationCommandsValues, applicationCommandLocalSendData.applicationCommandsValues) && Intrinsics3.areEqual(this.version, applicationCommandLocalSendData.version) && Intrinsics3.areEqual(this.interactionId, applicationCommandLocalSendData.interactionId);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getApplicationCommandId() {
        return this.applicationCommandId;
    }

    public final String getApplicationCommandName() {
        return this.applicationCommandName;
    }

    public final List<ApplicationCommandValue> getApplicationCommandsValues() {
        return this.applicationCommandsValues;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getCommandGuildId() {
        return this.commandGuildId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getInteractionId() {
        return this.interactionId;
    }

    public final long getNonce() {
        return this.nonce;
    }

    public final String getNonceString() {
        return this.nonceString;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.nonce) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.commandGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode3 = (iHashCode2 + (application != null ? application.hashCode() : 0)) * 31;
        String str = this.sessionId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.applicationCommandName;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.applicationCommandId;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ApplicationCommandValue> list = this.applicationCommandsValues;
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.version;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Long l3 = this.interactionId;
        return iHashCode8 + (l3 != null ? l3.hashCode() : 0);
    }

    public final ApplicationCommandData toRestApiApplicationCommandDataParam() {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i = 0;
        ref$IntRef.element = 0;
        List<ApplicationCommandData3> restParams = ApplicationCommandLocalSendData3.toRestParams(this.applicationCommandsValues, new ApplicationCommandLocalSendData2(ref$IntRef));
        String str = this.version;
        String str2 = this.applicationCommandId;
        Long l = this.commandGuildId;
        String strValueOf = l != null ? String.valueOf(l.longValue()) : null;
        String str3 = this.applicationCommandName;
        List<ApplicationCommandValue> listFlatten = StoreApplicationCommandsKt.flatten(this.applicationCommandsValues);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFlatten) {
            if (((ApplicationCommandValue) obj).getType() == 11) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList2.add(new ApplicationCommandData2(String.valueOf(((ApplicationCommandValue) obj2).getValue()), String.valueOf(i)));
            i = i2;
        }
        return new ApplicationCommandData(str, strValueOf, str2, str3, restParams, arrayList2);
    }

    public final RestAPIParams.ApplicationCommand toRestApiParam() {
        String strValueOf = String.valueOf(this.channelId);
        String strValueOf2 = String.valueOf(this.application.getId());
        Long l = this.guildId;
        String strValueOf3 = l != null ? String.valueOf(l.longValue()) : null;
        ApplicationCommandData restApiApplicationCommandDataParam = toRestApiApplicationCommandDataParam();
        String str = this.sessionId;
        return new RestAPIParams.ApplicationCommand(2L, strValueOf, strValueOf2, strValueOf3, restApiApplicationCommandDataParam, str != null ? str : null, this.nonceString);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandLocalSendData(nonce=");
        sbU.append(this.nonce);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", commandGuildId=");
        sbU.append(this.commandGuildId);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", applicationCommandName=");
        sbU.append(this.applicationCommandName);
        sbU.append(", applicationCommandId=");
        sbU.append(this.applicationCommandId);
        sbU.append(", applicationCommandsValues=");
        sbU.append(this.applicationCommandsValues);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", interactionId=");
        return outline.G(sbU, this.interactionId, ")");
    }

    public /* synthetic */ ApplicationCommandLocalSendData(long j, long j2, Long l, Long l2, Application application, String str, String str2, String str3, List list, String str4, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, l, l2, application, str, str2, str3, list, str4, (i & 1024) != 0 ? null : l3);
    }
}
