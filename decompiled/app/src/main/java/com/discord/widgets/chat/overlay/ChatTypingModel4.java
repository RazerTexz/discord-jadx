package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel4<T, R> implements Func1<Channel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel4 INSTANCE = new ChatTypingModel4();

    /* compiled from: ChatTypingModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/guild/GuildVerificationLevel;", "kotlin.jvm.PlatformType", "verificationLevel", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guild/GuildVerificationLevel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<GuildVerificationLevel, Observable<? extends ChatTypingModel>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: ChatTypingModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "kotlin.jvm.PlatformType", "typingUsers", "", "cooldownSecs", "Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/lang/Integer;)Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02831<T1, T2, R> implements Func2<List<? extends CharSequence>, Integer, ChatTypingModel.Typing> {
            public C02831() {
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ ChatTypingModel.Typing call(List<? extends CharSequence> list, Integer num) {
                return call2(list, num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ChatTypingModel.Typing call2(List<? extends CharSequence> list, Integer num) {
                Intrinsics3.checkNotNullExpressionValue(list, "typingUsers");
                int rateLimitPerUser = AnonymousClass1.this.$channel.getRateLimitPerUser();
                Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
                return new ChatTypingModel.Typing(list, rateLimitPerUser, num.intValue());
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
            return call2(guildVerificationLevel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ChatTypingModel> call2(GuildVerificationLevel guildVerificationLevel) {
            return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : Observable.j(ChatTypingModel.Companion.access$getTypingUsers(ChatTypingModel.INSTANCE, this.$channel), StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(this.$channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new C02831());
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).Y(new AnonymousClass1(channel));
    }
}
