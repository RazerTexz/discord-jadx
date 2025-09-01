package com.discord.models.thread.dto;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelThreadListSync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&BA\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\tJR\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\tR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\"\u0010\tR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b#\u0010\t¨\u0006'"}, d2 = {"Lcom/discord/models/thread/dto/ModelThreadListSync;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "Lcom/discord/api/channel/Channel;", "component2", "()Ljava/util/List;", "Lcom/discord/api/thread/ThreadMember;", "component3", "Lcom/discord/api/message/Message;", "component4", "guildId", "threads", "members", "mostRecentMessages", "copy", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/discord/models/thread/dto/ModelThreadListSync;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "Ljava/util/List;", "getMembers", "getMostRecentMessages", "getThreads", "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelThreadListSync {
    private final long guildId;
    private final List<ThreadMember> members;
    private final List<Message> mostRecentMessages;
    private final List<Channel> threads;

    /* compiled from: ModelThreadListSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/thread/dto/ModelThreadListSync$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/thread/dto/ModelThreadListSync;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelThreadListSync> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelThreadListSync parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
        @Override // com.discord.models.domain.Model.Parser
        public ModelThreadListSync parse(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = -1L;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = new ArrayList();
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new ModelThreadListSync2(ref$LongRef, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            long j = ref$LongRef.element;
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new ModelThreadListSync(j, listEmptyList, (List) ref$ObjectRef2.element, (List) ref$ObjectRef3.element);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelThreadListSync(long j, List<Channel> list, List<? extends ThreadMember> list2, List<Message> list3) {
        Intrinsics3.checkNotNullParameter(list, "threads");
        this.guildId = j;
        this.threads = list;
        this.members = list2;
        this.mostRecentMessages = list3;
    }

    public static /* synthetic */ ModelThreadListSync copy$default(ModelThreadListSync modelThreadListSync, long j, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelThreadListSync.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = modelThreadListSync.threads;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            list2 = modelThreadListSync.members;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            list3 = modelThreadListSync.mostRecentMessages;
        }
        return modelThreadListSync.copy(j2, list4, list5, list3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Channel> component2() {
        return this.threads;
    }

    public final List<ThreadMember> component3() {
        return this.members;
    }

    public final List<Message> component4() {
        return this.mostRecentMessages;
    }

    public final ModelThreadListSync copy(long guildId, List<Channel> threads, List<? extends ThreadMember> members, List<Message> mostRecentMessages) {
        Intrinsics3.checkNotNullParameter(threads, "threads");
        return new ModelThreadListSync(guildId, threads, members, mostRecentMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelThreadListSync)) {
            return false;
        }
        ModelThreadListSync modelThreadListSync = (ModelThreadListSync) other;
        return this.guildId == modelThreadListSync.guildId && Intrinsics3.areEqual(this.threads, modelThreadListSync.threads) && Intrinsics3.areEqual(this.members, modelThreadListSync.members) && Intrinsics3.areEqual(this.mostRecentMessages, modelThreadListSync.mostRecentMessages);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<ThreadMember> getMembers() {
        return this.members;
    }

    public final List<Message> getMostRecentMessages() {
        return this.mostRecentMessages;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Channel> list = this.threads;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.mostRecentMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelThreadListSync(guildId=");
        sbU.append(this.guildId);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", mostRecentMessages=");
        return outline.L(sbU, this.mostRecentMessages, ")");
    }
}
