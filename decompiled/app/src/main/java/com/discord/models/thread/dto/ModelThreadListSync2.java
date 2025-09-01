package com.discord.models.thread.dto;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.stream.JsonToken;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelThreadListSync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelThreadListSync2<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $guildId;
    public final /* synthetic */ Ref$ObjectRef $members;
    public final /* synthetic */ Ref$ObjectRef $mostRecentMessages;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $threads;

    /* compiled from: ModelThreadListSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Channel> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Channel get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Channel get() {
            return (Channel) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, Channel.class);
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/thread/ThreadMember;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/api/thread/ThreadMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Model.JsonReader.ItemFactory<ThreadMember> {
        public AnonymousClass2() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ThreadMember get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ThreadMember get() {
            return (ThreadMember) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, ThreadMember.class);
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "threadId", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<String> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            ThreadMember threadMember = (ThreadMember) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, ThreadMember.class);
            Intrinsics3.checkNotNullExpressionValue(str, "threadId");
            ((List) ModelThreadListSync2.this.$members.element).add(new ThreadMember(Long.parseLong(str), threadMember.getUserId(), threadMember.getFlags(), threadMember.getJoinTimestamp(), threadMember.getMuted(), threadMember.getMuteConfig()));
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/message/Message;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/api/message/Message;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Model.JsonReader.ItemFactory<Message> {
        public AnonymousClass4() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Message get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Message get() {
            return (Message) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, Message.class);
        }
    }

    public ModelThreadListSync2(Ref$LongRef ref$LongRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$guildId = ref$LongRef;
        this.$reader = jsonReader;
        this.$threads = ref$ObjectRef;
        this.$members = ref$ObjectRef2;
        this.$mostRecentMessages = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1337936983:
                    if (str.equals("threads")) {
                        this.$threads.element = (T) this.$reader.nextList(new AnonymousClass1());
                        return;
                    }
                    break;
                case -1306538777:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                        Ref$LongRef ref$LongRef = this.$guildId;
                        Long lNextLongOrNull = this.$reader.nextLongOrNull();
                        Intrinsics3.checkNotNull(lNextLongOrNull);
                        ref$LongRef.element = lNextLongOrNull.longValue();
                        return;
                    }
                    break;
                case 948881689:
                    if (str.equals("members")) {
                        if (this.$reader.peek() != JsonToken.BEGIN_ARRAY) {
                            this.$reader.nextObject(new AnonymousClass3());
                            return;
                        }
                        Ref$ObjectRef ref$ObjectRef = this.$members;
                        T t = (T) this.$reader.nextList(new AnonymousClass2());
                        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { Inboun…readMember::class.java) }");
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case 1472794100:
                    if (str.equals("most_recent_messages")) {
                        this.$mostRecentMessages.element = (T) this.$reader.nextList(new AnonymousClass4());
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
