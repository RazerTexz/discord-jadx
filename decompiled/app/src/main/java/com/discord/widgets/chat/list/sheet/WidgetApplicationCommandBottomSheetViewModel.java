package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005&'()*BW\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\n\u0010\u0018\u001a\u00060\u000bj\u0002`\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001d\u0010\u0018\u001a\u00060\u000bj\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "", "requestInteractionData", "()V", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", "retry", "", "interactionId", "J", "getInteractionId", "()J", "", "messageNonce", "Ljava/lang/String;", "getMessageNonce", "()Ljava/lang/String;", "messageId", "getMessageId", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "applicationId", "getApplicationId", "interactionUserId", "getInteractionUserId", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "Lrx/Observable;", "storeObservable", "<init>", "(JJJLjava/lang/Long;JJLjava/lang/String;Lrx/Observable;)V", "Companion", "SlashCommandParam", "StoreState", "UserData", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final long interactionId;
    private final long interactionUserId;
    private final long messageId;
    private final String messageNonce;

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel) {
            super(1, widgetApplicationCommandBottomSheetViewModel, WidgetApplicationCommandBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetApplicationCommandBottomSheetViewModel.access$handleStoreState((WidgetApplicationCommandBottomSheetViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<StoreState, UserData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ UserData call(StoreState storeState) {
            return call2(storeState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final UserData call2(StoreState storeState) {
            return new UserData(storeState.getMentionedUsers(), storeState.getUsers());
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<UserData, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
            invoke2(userData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserData userData) {
            if (WidgetApplicationCommandBottomSheetViewModel.this.getGuildId() != null) {
                StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetApplicationCommandBottomSheetViewModel.this.getGuildId().longValue(), null, _Collections.toList(userData.getMentionedUserIds()), null, 10, null);
            }
            if (userData.getUsers().size() != userData.getMentionedUserIds().size()) {
                StoreStream.INSTANCE.getUsers().fetchUsers(_Collections.toList(userData.getMentionedUserIds()));
            }
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJq\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00062\n\u0010\t\u001a\u00060\u0004j\u0002`\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "", "interactionId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/UserId;", "userId", "applicationId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreApplicationInteractions;", "storeInteractions", "Lcom/discord/stores/StoreApplicationCommands;", "storeApplicationCommands", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "observeStores", "(Lcom/discord/stores/updates/ObservationDeck;JLjava/lang/Long;JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreApplicationInteractions;Lcom/discord/stores/StoreApplicationCommands;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, ObservationDeck observationDeck, long j, Long l, long j2, long j3, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands) {
            return companion.observeStores(observationDeck, j, l, j2, j3, storeGuilds, storeChannels, storeUser, storeApplicationInteractions, storeApplicationCommands);
        }

        private final Observable<StoreState> observeStores(ObservationDeck observationDeck, long interactionId, Long guildId, long userId, long applicationId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUsers, StoreApplicationInteractions storeInteractions, StoreApplicationCommands storeApplicationCommands) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeApplicationCommands, storeChannels, storeInteractions, storeGuilds, storeUsers}, false, null, null, new WidgetApplicationCommandBottomSheetViewModel2(storeInteractions, interactionId, storeApplicationCommands, applicationId, userId, storeGuilds, guildId, storeUsers, storeChannels), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", ModelAuditLogEntry.CHANGE_KEY_NAME, "value", "valueColor", "copyText", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCopyText", "getName", "getValue", "Ljava/lang/Integer;", "getValueColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SlashCommandParam {
        private final String copyText;
        private final String name;
        private final String value;
        private final Integer valueColor;

        public SlashCommandParam(String str, String str2, Integer num, String str3) {
            outline.q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "value", str3, "copyText");
            this.name = str;
            this.value = str2;
            this.valueColor = num;
            this.copyText = str3;
        }

        public static /* synthetic */ SlashCommandParam copy$default(SlashCommandParam slashCommandParam, String str, String str2, Integer num, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = slashCommandParam.name;
            }
            if ((i & 2) != 0) {
                str2 = slashCommandParam.value;
            }
            if ((i & 4) != 0) {
                num = slashCommandParam.valueColor;
            }
            if ((i & 8) != 0) {
                str3 = slashCommandParam.copyText;
            }
            return slashCommandParam.copy(str, str2, num, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getValueColor() {
            return this.valueColor;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCopyText() {
            return this.copyText;
        }

        public final SlashCommandParam copy(String name, String value, Integer valueColor, String copyText) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(value, "value");
            Intrinsics3.checkNotNullParameter(copyText, "copyText");
            return new SlashCommandParam(name, value, valueColor, copyText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlashCommandParam)) {
                return false;
            }
            SlashCommandParam slashCommandParam = (SlashCommandParam) other;
            return Intrinsics3.areEqual(this.name, slashCommandParam.name) && Intrinsics3.areEqual(this.value, slashCommandParam.value) && Intrinsics3.areEqual(this.valueColor, slashCommandParam.valueColor) && Intrinsics3.areEqual(this.copyText, slashCommandParam.copyText);
        }

        public final String getCopyText() {
            return this.copyText;
        }

        public final String getName() {
            return this.name;
        }

        public final String getValue() {
            return this.value;
        }

        public final Integer getValueColor() {
            return this.valueColor;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.valueColor;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            String str3 = this.copyText;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SlashCommandParam(name=");
            sbU.append(this.name);
            sbU.append(", value=");
            sbU.append(this.value);
            sbU.append(", valueColor=");
            sbU.append(this.valueColor);
            sbU.append(", copyText=");
            return outline.J(sbU, this.copyText, ")");
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0018\u0010%\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012\u0012\u0018\u0010&\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012\u0012\u0016\u0010'\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u0012\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\u0004\bE\u0010FJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0014\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0018\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J \u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J \u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u0012HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0015J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0012HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015JÒ\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u001a\b\u0002\u0010%\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u001a\b\u0002\u0010&\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00122\u0018\b\u0002\u0010'\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u00020\u00122\u0018\b\u0002\u0010(\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u00122\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0012HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104R\u001b\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b6\u0010\u0007R)\u0010(\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b8\u0010\u0015R%\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b9\u0010\u0015R\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\b;\u0010\u0011R+\u0010%\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b<\u0010\u0015R+\u0010&\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b=\u0010\u0015R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010\u0004R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bA\u0010\rR)\u0010'\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0013\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\bB\u0010\u0015R\u001b\u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010C\u001a\u0004\bD\u0010\n¨\u0006G"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/StoreApplicationInteractions$State;", "component3", "()Lcom/discord/stores/StoreApplicationInteractions$State;", "Lcom/discord/models/commands/Application;", "component4", "()Lcom/discord/models/commands/Application;", "", "", "component5", "()Ljava/util/Set;", "", "Lcom/discord/primitives/UserId;", "component6", "()Ljava/util/Map;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component7", "component8", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component9", "", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam;", "component10", "user", "interactionUser", "interactionState", "application", "mentionedUsers", "guildMembers", "guildRoles", "users", "channels", "commandValues", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/stores/StoreApplicationInteractions$State;Lcom/discord/models/commands/Application;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getInteractionUser", "Ljava/util/Map;", "getChannels", "getCommandValues", "Ljava/util/Set;", "getMentionedUsers", "getGuildMembers", "getGuildRoles", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/commands/Application;", "getApplication", "getUsers", "Lcom/discord/stores/StoreApplicationInteractions$State;", "getInteractionState", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/stores/StoreApplicationInteractions$State;Lcom/discord/models/commands/Application;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Application application;
        private final Map<Long, Channel> channels;
        private final Map<String, SlashCommandParam> commandValues;
        private final Map<Long, GuildMember> guildMembers;
        private final Map<Long, GuildRole> guildRoles;
        private final StoreApplicationInteractions.State interactionState;
        private final GuildMember interactionUser;
        private final Set<Long> mentionedUsers;
        private final User user;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(User user, GuildMember guildMember, StoreApplicationInteractions.State state, Application application, Set<Long> set, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, ? extends User> map3, Map<Long, Channel> map4, Map<String, SlashCommandParam> map5) {
            Intrinsics3.checkNotNullParameter(set, "mentionedUsers");
            Intrinsics3.checkNotNullParameter(map3, "users");
            Intrinsics3.checkNotNullParameter(map4, "channels");
            Intrinsics3.checkNotNullParameter(map5, "commandValues");
            this.user = user;
            this.interactionUser = guildMember;
            this.interactionState = state;
            this.application = application;
            this.mentionedUsers = set;
            this.guildMembers = map;
            this.guildRoles = map2;
            this.users = map3;
            this.channels = map4;
            this.commandValues = map5;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, GuildMember guildMember, StoreApplicationInteractions.State state, Application application, Set set, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.user : user, (i & 2) != 0 ? storeState.interactionUser : guildMember, (i & 4) != 0 ? storeState.interactionState : state, (i & 8) != 0 ? storeState.application : application, (i & 16) != 0 ? storeState.mentionedUsers : set, (i & 32) != 0 ? storeState.guildMembers : map, (i & 64) != 0 ? storeState.guildRoles : map2, (i & 128) != 0 ? storeState.users : map3, (i & 256) != 0 ? storeState.channels : map4, (i & 512) != 0 ? storeState.commandValues : map5);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<String, SlashCommandParam> component10() {
            return this.commandValues;
        }

        /* renamed from: component2, reason: from getter */
        public final GuildMember getInteractionUser() {
            return this.interactionUser;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreApplicationInteractions.State getInteractionState() {
            return this.interactionState;
        }

        /* renamed from: component4, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        public final Set<Long> component5() {
            return this.mentionedUsers;
        }

        public final Map<Long, GuildMember> component6() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> component7() {
            return this.guildRoles;
        }

        public final Map<Long, User> component8() {
            return this.users;
        }

        public final Map<Long, Channel> component9() {
            return this.channels;
        }

        public final StoreState copy(User user, GuildMember interactionUser, StoreApplicationInteractions.State interactionState, Application application, Set<Long> mentionedUsers, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> users, Map<Long, Channel> channels, Map<String, SlashCommandParam> commandValues) {
            Intrinsics3.checkNotNullParameter(mentionedUsers, "mentionedUsers");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(commandValues, "commandValues");
            return new StoreState(user, interactionUser, interactionState, application, mentionedUsers, guildMembers, guildRoles, users, channels, commandValues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.interactionUser, storeState.interactionUser) && Intrinsics3.areEqual(this.interactionState, storeState.interactionState) && Intrinsics3.areEqual(this.application, storeState.application) && Intrinsics3.areEqual(this.mentionedUsers, storeState.mentionedUsers) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.guildRoles, storeState.guildRoles) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.commandValues, storeState.commandValues);
        }

        public final Application getApplication() {
            return this.application;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Map<String, SlashCommandParam> getCommandValues() {
            return this.commandValues;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final StoreApplicationInteractions.State getInteractionState() {
            return this.interactionState;
        }

        public final GuildMember getInteractionUser() {
            return this.interactionUser;
        }

        public final Set<Long> getMentionedUsers() {
            return this.mentionedUsers;
        }

        public final User getUser() {
            return this.user;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.interactionUser;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            StoreApplicationInteractions.State state = this.interactionState;
            int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
            Application application = this.application;
            int iHashCode4 = (iHashCode3 + (application != null ? application.hashCode() : 0)) * 31;
            Set<Long> set = this.mentionedUsers;
            int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.guildMembers;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.guildRoles;
            int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, User> map3 = this.users;
            int iHashCode8 = (iHashCode7 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Channel> map4 = this.channels;
            int iHashCode9 = (iHashCode8 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<String, SlashCommandParam> map5 = this.commandValues;
            return iHashCode9 + (map5 != null ? map5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", interactionUser=");
            sbU.append(this.interactionUser);
            sbU.append(", interactionState=");
            sbU.append(this.interactionState);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", mentionedUsers=");
            sbU.append(this.mentionedUsers);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", commandValues=");
            return outline.M(sbU, this.commandValues, ")");
        }

        public /* synthetic */ StoreState(User user, GuildMember guildMember, StoreApplicationInteractions.State state, Application application, Set set, Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, (i & 2) != 0 ? null : guildMember, state, application, set, map, map2, map3, map4, map5);
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ>\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0006R)\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;", "", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/Set;", "", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/Map;", "mentionedUserIds", "users", "copy", "(Ljava/util/Set;Ljava/util/Map;)Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$UserData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getMentionedUserIds", "Ljava/util/Map;", "getUsers", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserData {
        private final Set<Long> mentionedUserIds;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UserData(Set<Long> set, Map<Long, ? extends User> map) {
            Intrinsics3.checkNotNullParameter(set, "mentionedUserIds");
            Intrinsics3.checkNotNullParameter(map, "users");
            this.mentionedUserIds = set;
            this.users = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserData copy$default(UserData userData, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = userData.mentionedUserIds;
            }
            if ((i & 2) != 0) {
                map = userData.users;
            }
            return userData.copy(set, map);
        }

        public final Set<Long> component1() {
            return this.mentionedUserIds;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final UserData copy(Set<Long> mentionedUserIds, Map<Long, ? extends User> users) {
            Intrinsics3.checkNotNullParameter(mentionedUserIds, "mentionedUserIds");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new UserData(mentionedUserIds, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserData)) {
                return false;
            }
            UserData userData = (UserData) other;
            return Intrinsics3.areEqual(this.mentionedUserIds, userData.mentionedUserIds) && Intrinsics3.areEqual(this.users, userData.users);
        }

        public final Set<Long> getMentionedUserIds() {
            return this.mentionedUserIds;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Set<Long> set = this.mentionedUserIds;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserData(mentionedUserIds=");
            sbU.append(this.mentionedUserIds);
            sbU.append(", users=");
            return outline.M(sbU, this.users, ")");
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Failed;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u001b\u0012\u000e\u0010!\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001` \u0012\u0018\u0010(\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020#\u0018\u00010\u0002\u0012\u0018\u0010,\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`*\u0012\u0004\u0012\u00020+\u0018\u00010\u0002\u0012\u0018\u00104\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002` \u0012\u0004\u0012\u000203\u0018\u00010\u0002\u0012\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b6\u00107R)\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001c\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010!\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R+\u0010(\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020#\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010\tR+\u0010,\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`*\u0012\u0004\u0012\u00020+\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0007\u001a\u0004\b-\u0010\tR\u0019\u0010/\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R+\u00104\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002` \u0012\u0004\u0012\u000203\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0007\u001a\u0004\b5\u0010\t¨\u00068"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "", "", "Lcom/discord/primitives/UserId;", "", "usernamesOrNicks", "Ljava/util/Map;", "getUsernamesOrNicks", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam;", "commandValues", "getCommandValues", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/user/User;", "getUser", "()Lcom/discord/models/user/User;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "Lcom/discord/models/commands/Application;", "application", "Lcom/discord/models/commands/Application;", "getApplication", "()Lcom/discord/models/commands/Application;", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "Lcom/discord/models/member/GuildMember;", "interactionUser", "Lcom/discord/models/member/GuildMember;", "getInteractionUser", "()Lcom/discord/models/member/GuildMember;", "guildMembers", "getGuildMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "getGuildRoles", "Lcom/discord/api/commands/ApplicationCommandData;", "applicationCommandData", "Lcom/discord/api/commands/ApplicationCommandData;", "getApplicationCommandData", "()Lcom/discord/api/commands/ApplicationCommandData;", "Lcom/discord/api/channel/Channel;", "channels", "getChannels", "<init>", "(JLcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/models/commands/Application;Lcom/discord/api/commands/ApplicationCommandData;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ViewState {
            private final Application application;
            private final ApplicationCommandData applicationCommandData;
            private final Long channelId;
            private final Map<Long, Channel> channels;
            private final Map<String, SlashCommandParam> commandValues;
            private final Long guildId;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final long id;
            private final GuildMember interactionUser;
            private final User user;
            private final Map<Long, String> usernamesOrNicks;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, User user, GuildMember guildMember, Application application, ApplicationCommandData applicationCommandData, Long l, Long l2, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, Channel> map3, Map<Long, String> map4, Map<String, SlashCommandParam> map5) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationCommandData, "applicationCommandData");
                Intrinsics3.checkNotNullParameter(map4, "usernamesOrNicks");
                Intrinsics3.checkNotNullParameter(map5, "commandValues");
                this.id = j;
                this.user = user;
                this.interactionUser = guildMember;
                this.application = application;
                this.applicationCommandData = applicationCommandData;
                this.guildId = l;
                this.channelId = l2;
                this.guildMembers = map;
                this.guildRoles = map2;
                this.channels = map3;
                this.usernamesOrNicks = map4;
                this.commandValues = map5;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final ApplicationCommandData getApplicationCommandData() {
                return this.applicationCommandData;
            }

            public final Long getChannelId() {
                return this.channelId;
            }

            public final Map<Long, Channel> getChannels() {
                return this.channels;
            }

            public final Map<String, SlashCommandParam> getCommandValues() {
                return this.commandValues;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final long getId() {
                return this.id;
            }

            public final GuildMember getInteractionUser() {
                return this.interactionUser;
            }

            public final User getUser() {
                return this.user;
            }

            public final Map<Long, String> getUsernamesOrNicks() {
                return this.usernamesOrNicks;
            }
        }

        /* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        if ((i & 128) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, observationDeck, j, l, j4, j5, companion2.getGuilds(), companion2.getChannels(), companion2.getUsers(), companion2.getInteractions(), companion2.getApplicationCommands());
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, j2, j3, l, j4, j5, str, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel, StoreState storeState) {
        widgetApplicationCommandBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        String username;
        StoreApplicationInteractions.State interactionState = storeState.getInteractionState();
        if (Intrinsics3.areEqual(interactionState, StoreApplicationInteractions.State.Failure.INSTANCE)) {
            updateViewState(ViewState.Failed.INSTANCE);
            return;
        }
        if (Intrinsics3.areEqual(interactionState, StoreApplicationInteractions.State.Fetching.INSTANCE)) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (interactionState instanceof StoreApplicationInteractions.State.Loaded) {
            if (storeState.getMentionedUsers().size() == storeState.getUsers().size()) {
                int size = storeState.getMentionedUsers().size();
                Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                if (guildMembers != null && size == guildMembers.size()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<T> it = storeState.getMentionedUsers().iterator();
                    while (it.hasNext()) {
                        long jLongValue = ((Number) it.next()).longValue();
                        GuildMember guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue));
                        if (guildMember == null || (username = guildMember.getNick()) == null) {
                            User user = storeState.getUsers().get(Long.valueOf(jLongValue));
                            username = user != null ? user.getUsername() : null;
                        }
                        if (username == null) {
                            username = "";
                        }
                        linkedHashMap.put(Long.valueOf(jLongValue), username);
                    }
                    updateViewState(new ViewState.Loaded(this.interactionId, storeState.getUser(), storeState.getInteractionUser(), storeState.getApplication(), ((StoreApplicationInteractions.State.Loaded) storeState.getInteractionState()).getCommandOptions(), this.guildId, Long.valueOf(this.channelId), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannels(), linkedHashMap, storeState.getCommandValues()));
                    return;
                }
            }
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    private final void requestInteractionData() {
        StoreStream.INSTANCE.getInteractions().fetchInteractionDataIfNonExisting(this.interactionId, this.channelId, this.messageId, this.messageNonce);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final long getInteractionId() {
        return this.interactionId;
    }

    public final long getInteractionUserId() {
        return this.interactionUserId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getMessageNonce() {
        return this.messageNonce;
    }

    public final void retry() {
        requestInteractionData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.interactionId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.guildId = l;
        this.interactionUserId = j4;
        this.applicationId = j5;
        this.messageNonce = str;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetApplicationCommandBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        requestInteractionData();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).G(AnonymousClass2.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeObservable.computat…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetApplicationCommandBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
