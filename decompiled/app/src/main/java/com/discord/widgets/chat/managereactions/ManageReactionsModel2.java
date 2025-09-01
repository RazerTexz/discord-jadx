package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReactions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: ManageReactionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012\n\u0010(\u001a\u00060\u000ej\u0002`'\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b2\u00103J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J[\u0010\u0015\u001a\u00020\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010(\u001a\u00060\u000ej\u0002`'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010,\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R&\u0010/\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", "", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "targetedEmoji", "Lrx/Observable;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "getUsersForReaction", "(Lcom/discord/api/message/reaction/MessageReactionEmoji;)Lrx/Observable;", "", "Lcom/discord/api/message/reaction/MessageReaction;", "reactions", "results", "", "canManageMessages", "", "Lcom/discord/primitives/UserId;", "myId", "", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "createModel", "(Ljava/util/List;Lcom/discord/stores/StoreMessageReactions$EmojiResults;Lcom/discord/api/message/reaction/MessageReactionEmoji;ZJLjava/util/Map;)Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "get", "()Lrx/Observable;", "", "emojiKey", "", "onEmojiTargeted", "(Ljava/lang/String;)V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "messageId", "getMessageId", "Lrx/subjects/SerializedSubject;", "targetedEmojiKeySubject", "Lrx/subjects/SerializedSubject;", "initTargetedReactionKey", "<init>", "(JJLjava/lang/String;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel2 {
    private final long channelId;
    private final long messageId;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final SerializedSubject<String, String> targetedEmojiKeySubject;

    /* compiled from: ManageReactionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isMeMfaEnabled", "Lrx/Observable;", "invoke", "(Z)Lrx/Observable;", "getCanManageMessagesObs"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Observable<Boolean>> {

        /* compiled from: ManageReactionsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/models/guild/Guild;", "guild", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02801<T1, T2, R> implements Func2<Long, Guild, Boolean> {
            public final /* synthetic */ boolean $isMeMfaEnabled;

            public C02801(boolean z2) {
                this.$isMeMfaEnabled = z2;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Long l, Guild guild) {
                return call2(l, guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Long l, Guild guild) {
                return Boolean.valueOf(guild != null && PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, l, this.$isMeMfaEnabled, guild.getMfaLevel()));
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Boolean> invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final Observable<Boolean> invoke(boolean z2) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Boolean> observableJ = Observable.j(companion.getPermissions().observePermissionsForChannel(ManageReactionsModel2.this.getChannelId()), companion.getGuilds().observeFromChannelId(ManageReactionsModel2.this.getChannelId()), new C02801(z2));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ld.mfaLevel\n      )\n    }");
            return observableJ;
        }
    }

    /* compiled from: ManageReactionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lrx/Observable;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<MeUser, Observable<? extends ManageReactionsModel>> {
        public final /* synthetic */ AnonymousClass1 $getCanManageMessagesObs$1;
        public final /* synthetic */ Observable $guildMembersObservable;
        public final /* synthetic */ Observable $reactionsObs;

        /* compiled from: ManageReactionsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001aÆ\u0001\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u00124\u00122\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n \u0001*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00060\u0006 \u0001*b\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u00124\u00122\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n \u0001*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00060\u0006\u0018\u00010\f0\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000326\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n \u0001*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "kotlin.jvm.PlatformType", "canManageMessages", "", "Lcom/discord/api/message/reaction/MessageReaction;", "reactions", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "Lkotlin/Triple;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;)Lkotlin/Triple;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Boolean, List<? extends MessageReaction>, Map<Long, ? extends GuildMember>, Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> call(Boolean bool, List<? extends MessageReaction> list, Map<Long, ? extends GuildMember> map) {
                return call2(bool, (List<MessageReaction>) list, (Map<Long, GuildMember>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples3<Boolean, List<MessageReaction>, Map<Long, GuildMember>> call2(Boolean bool, List<MessageReaction> list, Map<Long, GuildMember> map) {
                return new Tuples3<>(bool, list, map);
            }
        }

        /* compiled from: ManageReactionsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b0\u000b2Ë\u0001\u0010\n\u001aÆ\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u00124\u00122\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t \u0002*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u00050\u0005 \u0002*b\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u00124\u00122\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t \u0002*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u00050\u0005\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlin/Triple;", "", "kotlin.jvm.PlatformType", "", "Lcom/discord/api/message/reaction/MessageReaction;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Triple;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02812<T, R> implements Func1<Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>, Observable<? extends ManageReactionsModel>> {
            public final /* synthetic */ MeUser $me;

            /* compiled from: ManageReactionsModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "targetedEmojiKey", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lcom/discord/api/message/reaction/MessageReactionEmoji;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$1, reason: invalid class name */
            public static final class AnonymousClass1<T, R> implements Func1<String, MessageReactionEmoji> {
                public final /* synthetic */ List $reactions;

                public AnonymousClass1(List list) {
                    this.$reactions = list;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ MessageReactionEmoji call(String str) {
                    return call2(str);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final MessageReactionEmoji call2(String str) {
                    T next;
                    MessageReactionEmoji emoji;
                    List list = this.$reactions;
                    Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = (T) null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics3.areEqual(((MessageReaction) next).getEmoji().c(), str)) {
                            break;
                        }
                    }
                    MessageReaction messageReaction = next;
                    if (messageReaction != null && (emoji = messageReaction.getEmoji()) != null) {
                        return emoji;
                    }
                    List list2 = this.$reactions;
                    Intrinsics3.checkNotNullExpressionValue(list2, "reactions");
                    return ((MessageReaction) _Collections.first(list2)).getEmoji();
                }
            }

            /* compiled from: ManageReactionsModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/message/reaction/MessageReactionEmoji;", "kotlin.jvm.PlatformType", "targetedEmoji", "Lrx/Observable;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/message/reaction/MessageReactionEmoji;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$2, reason: invalid class name and collision with other inner class name */
            public static final class C02822<T, R> implements Func1<MessageReactionEmoji, Observable<? extends ManageReactionsModel>> {
                public final /* synthetic */ Boolean $canManageMessages;
                public final /* synthetic */ Map $guildMembers;
                public final /* synthetic */ List $reactions;

                /* compiled from: ManageReactionsModel.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessageReactions$EmojiResults;)Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
                /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1<T, R> implements Func1<StoreMessageReactions.EmojiResults, ManageReactionsModel> {
                    public final /* synthetic */ MessageReactionEmoji $targetedEmoji;

                    public AnonymousClass1(MessageReactionEmoji messageReactionEmoji) {
                        this.$targetedEmoji = messageReactionEmoji;
                    }

                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ ManageReactionsModel call(StoreMessageReactions.EmojiResults emojiResults) {
                        return call2(emojiResults);
                    }

                    /* renamed from: call, reason: avoid collision after fix types in other method */
                    public final ManageReactionsModel call2(StoreMessageReactions.EmojiResults emojiResults) {
                        C02822 c02822 = C02822.this;
                        ManageReactionsModel2 manageReactionsModel2 = ManageReactionsModel2.this;
                        List list = c02822.$reactions;
                        Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                        Intrinsics3.checkNotNullExpressionValue(emojiResults, "users");
                        MessageReactionEmoji messageReactionEmoji = this.$targetedEmoji;
                        Boolean bool = C02822.this.$canManageMessages;
                        Intrinsics3.checkNotNullExpressionValue(bool, "canManageMessages");
                        boolean zBooleanValue = bool.booleanValue();
                        long id2 = C02812.this.$me.getId();
                        Map map = C02822.this.$guildMembers;
                        Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
                        return ManageReactionsModel2.access$createModel(manageReactionsModel2, list, emojiResults, messageReactionEmoji, zBooleanValue, id2, map);
                    }
                }

                public C02822(List list, Boolean bool, Map map) {
                    this.$reactions = list;
                    this.$canManageMessages = bool;
                    this.$guildMembers = map;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MessageReactionEmoji messageReactionEmoji) {
                    return call2(messageReactionEmoji);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends ManageReactionsModel> call2(MessageReactionEmoji messageReactionEmoji) {
                    ManageReactionsModel2 manageReactionsModel2 = ManageReactionsModel2.this;
                    Intrinsics3.checkNotNullExpressionValue(messageReactionEmoji, "targetedEmoji");
                    return ManageReactionsModel2.access$getUsersForReaction(manageReactionsModel2, messageReactionEmoji).G(new AnonymousClass1(messageReactionEmoji));
                }
            }

            public C02812(MeUser meUser) {
                this.$me = meUser;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> tuples3) {
                return call2((Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>>) tuples3);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends ManageReactionsModel> call2(Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>> tuples3) {
                Boolean boolComponent1 = tuples3.component1();
                List<MessageReaction> listComponent2 = tuples3.component2();
                return listComponent2.isEmpty() ? new ScalarSynchronousObservable(null) : ManageReactionsModel2.access$getTargetedEmojiKeySubject$p(ManageReactionsModel2.this).r().G(new AnonymousClass1(listComponent2)).Y(new C02822(listComponent2, boolComponent1, tuples3.component3()));
            }
        }

        public AnonymousClass2(AnonymousClass1 anonymousClass1, Observable observable, Observable observable2) {
            this.$getCanManageMessagesObs$1 = anonymousClass1;
            this.$reactionsObs = observable;
            this.$guildMembersObservable = observable2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ManageReactionsModel> call2(MeUser meUser) {
            return Observable.i(this.$getCanManageMessagesObs$1.invoke(meUser.getMfaEnabled()), this.$reactionsObs, this.$guildMembersObservable, AnonymousClass1.INSTANCE).Y(new C02812(meUser));
        }
    }

    public ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.channelId = j;
        this.messageId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
        this.targetedEmojiKeySubject = new SerializedSubject<>(BehaviorSubject.l0(str));
    }

    public static final /* synthetic */ ManageReactionsModel access$createModel(ManageReactionsModel2 manageReactionsModel2, List list, StoreMessageReactions.EmojiResults emojiResults, MessageReactionEmoji messageReactionEmoji, boolean z2, long j, Map map) {
        return manageReactionsModel2.createModel(list, emojiResults, messageReactionEmoji, z2, j, map);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.storeGuilds;
    }

    public static final /* synthetic */ SerializedSubject access$getTargetedEmojiKeySubject$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.targetedEmojiKeySubject;
    }

    public static final /* synthetic */ Observable access$getUsersForReaction(ManageReactionsModel2 manageReactionsModel2, MessageReactionEmoji messageReactionEmoji) {
        return manageReactionsModel2.getUsersForReaction(messageReactionEmoji);
    }

    private final ManageReactionsModel createModel(List<MessageReaction> reactions, StoreMessageReactions.EmojiResults results, MessageReactionEmoji targetedEmoji, boolean canManageMessages, long myId, Map<Long, GuildMember> guildMembers) {
        List listListOf;
        Map<Long, GuildMember> map;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (MessageReaction messageReaction : reactions) {
            arrayList.add(new ManageReactionsEmojisAdapter.ReactionEmojiItem(messageReaction, Intrinsics3.areEqual(messageReaction.getEmoji(), targetedEmoji)));
        }
        if (results instanceof StoreMessageReactions.EmojiResults.Users) {
            StoreMessageReactions.EmojiResults.Users users = (StoreMessageReactions.EmojiResults.Users) results;
            Collection<User> collectionValues = users.getUsers().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "results.users.values");
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                Intrinsics3.checkNotNullExpressionValue(user, "user");
                long j = this.channelId;
                long j2 = this.messageId;
                MessageReactionEmoji emoji = users.getEmoji();
                if (canManageMessages || user.getId() == myId) {
                    map = guildMembers;
                    z2 = true;
                } else {
                    map = guildMembers;
                    z2 = false;
                }
                arrayList2.add(new ManageReactionsResultsAdapter.ReactionUserItem(user, j, j2, emoji, z2, (GuildMember) outline.f(user, map)));
            }
            listListOf = _Collections.toList(arrayList2);
        } else if (results instanceof StoreMessageReactions.EmojiResults.Loading) {
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.LoadingItem());
        } else {
            if (!(results instanceof StoreMessageReactions.EmojiResults.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreMessageReactions.EmojiResults.Failure failure = (StoreMessageReactions.EmojiResults.Failure) results;
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.ErrorItem(failure.getChannelId(), failure.getMessageId(), failure.getEmoji()));
        }
        return new ManageReactionsModel(arrayList, listListOf);
    }

    private final Observable<StoreMessageReactions.EmojiResults> getUsersForReaction(MessageReactionEmoji targetedEmoji) {
        return StoreStream.INSTANCE.getMessageReactions().observeMessageReactions(this.channelId, this.messageId, targetedEmoji);
    }

    public final Observable<ManageReactionsModel> get() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = companion.getMessages().observeMessagesForChannel(this.channelId, this.messageId).G(ManageReactionsModel4.INSTANCE).G(ManageReactionsModel5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…ion -> reaction.count } }");
        Observable observableY = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Y(new AnonymousClass2(anonymousClass1, observableG, ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeGuilds}, false, null, null, new ManageReactionsModel3(this), 14, null)));
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        Observable<ManageReactionsModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void onEmojiTargeted(String emojiKey) {
        Intrinsics3.checkNotNullParameter(emojiKey, "emojiKey");
        this.targetedEmojiKeySubject.k.onNext(emojiKey);
    }

    public /* synthetic */ ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
