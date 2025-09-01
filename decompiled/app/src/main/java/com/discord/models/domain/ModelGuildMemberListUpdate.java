package com.discord.models.domain;

import androidx.browser.customtabs.CustomTabsCallback;
import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;

/* compiled from: ModelGuildMemberListUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0004'()*B;\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b%\u0010&J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJL\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\rR\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\tR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\r¨\u0006+"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "Lcom/discord/primitives/MemberListId;", "component2", "()Ljava/lang/String;", "", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "component3", "()Ljava/util/List;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "component4", "guildId", ModelAuditLogEntry.CHANGE_KEY_ID, "operations", "groups", "copy", "(JLjava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "Ljava/util/List;", "getGroups", "Ljava/lang/String;", "getId", "getOperations", "<init>", "(JLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Companion", "Group", "Operation", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate {
    public static final String EVERYONE_ID = "everyone";
    private final List<Group> groups;
    private final long guildId;
    private final String id;
    private final List<Operation> operations;

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", ModelAuditLogEntry.CHANGE_KEY_ID, "count", "copy", "(Ljava/lang/String;I)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group$Type;", "type", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group$Type;", "getType", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group$Type;", "I", "getCount", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;I)V", "Parser", "Type", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Group {
        private final int count;
        private final String id;
        private final Type type;

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Parser implements Model.Parser<Group> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Group parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Group parse(Model.JsonReader reader) throws IOException {
                Intrinsics3.checkNotNullParameter(reader, "reader");
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                reader.nextObject(new ModelGuildMemberListUpdate2(ref$ObjectRef, reader, ref$IntRef));
                return new Group((String) ref$ObjectRef.element, ref$IntRef.element);
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ROLE", "OFFLINE", "ONLINE", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            ROLE,
            OFFLINE,
            ONLINE
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Group(String str, int i) {
            Type type;
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            this.id = str;
            this.count = i;
            int iHashCode = str.hashCode();
            if (iHashCode != -1548612125) {
                type = (iHashCode == -1012222381 && str.equals(CustomTabsCallback.ONLINE_EXTRAS_KEY)) ? Type.ONLINE : Type.ROLE;
            } else if (str.equals("offline")) {
                type = Type.OFFLINE;
            }
            this.type = type;
        }

        public static /* synthetic */ Group copy$default(Group group, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = group.id;
            }
            if ((i2 & 2) != 0) {
                i = group.count;
            }
            return group.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final Group copy(String id2, int count) {
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            return new Group(id2, count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Group)) {
                return false;
            }
            Group group = (Group) other;
            return Intrinsics3.areEqual(this.id, group.id) && this.count == group.count;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.id;
            return ((str != null ? str.hashCode() : 0) * 31) + this.count;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Group(id=");
            sbU.append(this.id);
            sbU.append(", count=");
            return outline.B(sbU, this.count, ")");
        }
    }

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014B'\b\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "", "", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "item", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "getItem", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "<init>", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;Ljava/util/List;)V", "Delete", "Insert", "Invalidate", "Item", "Parser", "Sync", "Update", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Sync;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Update;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Insert;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Delete;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Invalidate;", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Operation {
        private final Item item;
        private final List<Item> items;

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Delete;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "", "component1", "()I", "index", "copy", "(I)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Delete;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "<init>", "(I)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Delete extends Operation {
            private final int index;

            public Delete(int i) {
                super(null, null, 3, null);
                this.index = i;
            }

            public static /* synthetic */ Delete copy$default(Delete delete, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = delete.index;
                }
                return delete.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Delete copy(int index) {
                return new Delete(index);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Delete) && this.index == ((Delete) other).index;
                }
                return true;
            }

            public final int getIndex() {
                return this.index;
            }

            public int hashCode() {
                return this.index;
            }

            public String toString() {
                return outline.B(outline.U("Delete(index="), this.index, ")");
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Insert;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "", "component1", "()I", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "component2", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "index", "item", "copy", "(ILcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Insert;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "getItem", "I", "getIndex", "<init>", "(ILcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Insert extends Operation {
            private final int index;
            private final Item item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Insert(int i, Item item) {
                super(item, null, 2, null);
                Intrinsics3.checkNotNullParameter(item, "item");
                this.index = i;
                this.item = item;
            }

            public static /* synthetic */ Insert copy$default(Insert insert, int i, Item item, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = insert.index;
                }
                if ((i2 & 2) != 0) {
                    item = insert.getItem();
                }
                return insert.copy(i, item);
            }

            /* renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Item component2() {
                return getItem();
            }

            public final Insert copy(int index, Item item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                return new Insert(index, item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Insert)) {
                    return false;
                }
                Insert insert = (Insert) other;
                return this.index == insert.index && Intrinsics3.areEqual(getItem(), insert.getItem());
            }

            public final int getIndex() {
                return this.index;
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public Item getItem() {
                return this.item;
            }

            public int hashCode() {
                int i = this.index * 31;
                Item item = getItem();
                return i + (item != null ? item.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Insert(index=");
                sbU.append(this.index);
                sbU.append(", item=");
                sbU.append(getItem());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Invalidate;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "Lkotlin/ranges/IntRange;", "component1", "()Lkotlin/ranges/IntRange;", "range", "copy", "(Lkotlin/ranges/IntRange;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Invalidate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/IntRange;", "getRange", "<init>", "(Lkotlin/ranges/IntRange;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Invalidate extends Operation {
            private final Ranges2 range;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invalidate(Ranges2 ranges2) {
                super(null, null, 3, null);
                Intrinsics3.checkNotNullParameter(ranges2, "range");
                this.range = ranges2;
            }

            public static /* synthetic */ Invalidate copy$default(Invalidate invalidate, Ranges2 ranges2, int i, Object obj) {
                if ((i & 1) != 0) {
                    ranges2 = invalidate.range;
                }
                return invalidate.copy(ranges2);
            }

            /* renamed from: component1, reason: from getter */
            public final Ranges2 getRange() {
                return this.range;
            }

            public final Invalidate copy(Ranges2 range) {
                Intrinsics3.checkNotNullParameter(range, "range");
                return new Invalidate(range);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Invalidate) && Intrinsics3.areEqual(this.range, ((Invalidate) other).range);
                }
                return true;
            }

            public final Ranges2 getRange() {
                return this.range;
            }

            public int hashCode() {
                Ranges2 ranges2 = this.range;
                if (ranges2 != null) {
                    return ranges2.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invalidate(range=");
                sbU.append(this.range);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "", "<init>", "()V", "GroupItem", "MemberItem", "Parser", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$GroupItem;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$MemberItem;", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Item {

            /* compiled from: ModelGuildMemberListUpdate.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$GroupItem;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "component1", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "group", "copy", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$GroupItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "getGroup", "<init>", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class GroupItem extends Item {
                private final Group group;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public GroupItem(Group group) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(group, "group");
                    this.group = group;
                }

                public static /* synthetic */ GroupItem copy$default(GroupItem groupItem, Group group, int i, Object obj) {
                    if ((i & 1) != 0) {
                        group = groupItem.group;
                    }
                    return groupItem.copy(group);
                }

                /* renamed from: component1, reason: from getter */
                public final Group getGroup() {
                    return this.group;
                }

                public final GroupItem copy(Group group) {
                    Intrinsics3.checkNotNullParameter(group, "group");
                    return new GroupItem(group);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof GroupItem) && Intrinsics3.areEqual(this.group, ((GroupItem) other).group);
                    }
                    return true;
                }

                public final Group getGroup() {
                    return this.group;
                }

                public int hashCode() {
                    Group group = this.group;
                    if (group != null) {
                        return group.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("GroupItem(group=");
                    sbU.append(this.group);
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: ModelGuildMemberListUpdate.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$MemberItem;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "Lcom/discord/api/guildmember/GuildMember;", "component1", "()Lcom/discord/api/guildmember/GuildMember;", "member", "copy", "(Lcom/discord/api/guildmember/GuildMember;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$MemberItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildmember/GuildMember;", "getMember", "<init>", "(Lcom/discord/api/guildmember/GuildMember;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class MemberItem extends Item {
                private final GuildMember member;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public MemberItem(GuildMember guildMember) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(guildMember, "member");
                    this.member = guildMember;
                }

                public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, GuildMember guildMember, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guildMember = memberItem.member;
                    }
                    return memberItem.copy(guildMember);
                }

                /* renamed from: component1, reason: from getter */
                public final GuildMember getMember() {
                    return this.member;
                }

                public final MemberItem copy(GuildMember member) {
                    Intrinsics3.checkNotNullParameter(member, "member");
                    return new MemberItem(member);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof MemberItem) && Intrinsics3.areEqual(this.member, ((MemberItem) other).member);
                    }
                    return true;
                }

                public final GuildMember getMember() {
                    return this.member;
                }

                public int hashCode() {
                    GuildMember guildMember = this.member;
                    if (guildMember != null) {
                        return guildMember.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("MemberItem(member=");
                    sbU.append(this.member);
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: ModelGuildMemberListUpdate.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Parser implements Model.Parser<Item> {
                public static final Parser INSTANCE = new Parser();

                private Parser() {
                }

                @Override // com.discord.models.domain.Model.Parser
                public /* bridge */ /* synthetic */ Item parse(Model.JsonReader jsonReader) {
                    return parse(jsonReader);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.discord.models.domain.Model.Parser
                public Item parse(Model.JsonReader reader) throws IOException {
                    Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                    ref$ObjectRefC0.element = null;
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    ref$ObjectRef.element = null;
                    reader.nextObject(new ModelGuildMemberListUpdate3(ref$ObjectRefC0, reader, ref$ObjectRef));
                    T t = ref$ObjectRef.element;
                    if (((GuildMember) t) != null) {
                        GuildMember guildMember = (GuildMember) t;
                        Intrinsics3.checkNotNull(guildMember);
                        return new MemberItem(guildMember);
                    }
                    T t2 = ref$ObjectRefC0.element;
                    if (((Group) t2) == null) {
                        throw new IllegalArgumentException("either member or group must be present.");
                    }
                    Group group = (Group) t2;
                    Intrinsics3.checkNotNull(group);
                    return new GroupItem(group);
                }
            }

            private Item() {
            }

            public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Parser implements Model.Parser<Operation> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Operation parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Operation parse(Model.JsonReader reader) throws IOException {
                Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                ref$ObjectRefC0.element = null;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = null;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = null;
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                ref$ObjectRef4.element = null;
                reader.nextObject(new ModelGuildMemberListUpdate4(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef3, ref$ObjectRef2, ref$ObjectRef4));
                String str = (String) ref$ObjectRefC0.element;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2130463047:
                            if (str.equals("INSERT")) {
                                Integer num = (Integer) ref$ObjectRef.element;
                                Intrinsics3.checkNotNull(num);
                                int iIntValue = num.intValue();
                                Item item = (Item) ref$ObjectRef2.element;
                                Intrinsics3.checkNotNull(item);
                                return new Insert(iIntValue, item);
                            }
                            break;
                        case -1785516855:
                            if (str.equals("UPDATE")) {
                                Integer num2 = (Integer) ref$ObjectRef.element;
                                Intrinsics3.checkNotNull(num2);
                                int iIntValue2 = num2.intValue();
                                Item item2 = (Item) ref$ObjectRef2.element;
                                Intrinsics3.checkNotNull(item2);
                                return new Update(iIntValue2, item2);
                            }
                            break;
                        case -1346757317:
                            if (str.equals("INVALIDATE")) {
                                Ranges2 ranges2 = (Ranges2) ref$ObjectRef3.element;
                                Intrinsics3.checkNotNull(ranges2);
                                return new Invalidate(ranges2);
                            }
                            break;
                        case 2560667:
                            if (str.equals("SYNC")) {
                                Ranges2 ranges22 = (Ranges2) ref$ObjectRef3.element;
                                Intrinsics3.checkNotNull(ranges22);
                                List list = (List) ref$ObjectRef4.element;
                                Intrinsics3.checkNotNull(list);
                                return new Sync(ranges22, list);
                            }
                            break;
                        case 2012838315:
                            if (str.equals("DELETE")) {
                                Integer num3 = (Integer) ref$ObjectRef.element;
                                Intrinsics3.checkNotNull(num3);
                                return new Delete(num3.intValue());
                            }
                            break;
                    }
                }
                StringBuilder sbU = outline.U("Invalid operation type: ");
                sbU.append((String) ref$ObjectRefC0.element);
                throw new IllegalArgumentException(sbU.toString());
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Sync;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "Lkotlin/ranges/IntRange;", "component1", "()Lkotlin/ranges/IntRange;", "", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "component2", "()Ljava/util/List;", "range", "items", "copy", "(Lkotlin/ranges/IntRange;Ljava/util/List;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Sync;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Lkotlin/ranges/IntRange;", "getRange", "<init>", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Sync extends Operation {
            private final List<Item> items;
            private final Ranges2 range;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Sync(Ranges2 ranges2, List<? extends Item> list) {
                super(null, list, 1, null);
                Intrinsics3.checkNotNullParameter(ranges2, "range");
                Intrinsics3.checkNotNullParameter(list, "items");
                this.range = ranges2;
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Sync copy$default(Sync sync, Ranges2 ranges2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    ranges2 = sync.range;
                }
                if ((i & 2) != 0) {
                    list = sync.getItems();
                }
                return sync.copy(ranges2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final Ranges2 getRange() {
                return this.range;
            }

            public final List<Item> component2() {
                return getItems();
            }

            public final Sync copy(Ranges2 range, List<? extends Item> items) {
                Intrinsics3.checkNotNullParameter(range, "range");
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Sync(range, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sync)) {
                    return false;
                }
                Sync sync = (Sync) other;
                return Intrinsics3.areEqual(this.range, sync.range) && Intrinsics3.areEqual(getItems(), sync.getItems());
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public List<Item> getItems() {
                return this.items;
            }

            public final Ranges2 getRange() {
                return this.range;
            }

            public int hashCode() {
                Ranges2 ranges2 = this.range;
                int iHashCode = (ranges2 != null ? ranges2.hashCode() : 0) * 31;
                List<Item> items = getItems();
                return iHashCode + (items != null ? items.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Sync(range=");
                sbU.append(this.range);
                sbU.append(", items=");
                sbU.append(getItems());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ModelGuildMemberListUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Update;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "", "component1", "()I", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "component2", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "index", "item", "copy", "(ILcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;)Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Update;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "getItem", "<init>", "(ILcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Update extends Operation {
            private final int index;
            private final Item item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Update(int i, Item item) {
                super(item, null, 2, null);
                Intrinsics3.checkNotNullParameter(item, "item");
                this.index = i;
                this.item = item;
            }

            public static /* synthetic */ Update copy$default(Update update, int i, Item item, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = update.index;
                }
                if ((i2 & 2) != 0) {
                    item = update.getItem();
                }
                return update.copy(i, item);
            }

            /* renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Item component2() {
                return getItem();
            }

            public final Update copy(int index, Item item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                return new Update(index, item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return this.index == update.index && Intrinsics3.areEqual(getItem(), update.getItem());
            }

            public final int getIndex() {
                return this.index;
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public Item getItem() {
                return this.item;
            }

            public int hashCode() {
                int i = this.index * 31;
                Item item = getItem();
                return i + (item != null ? item.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Update(index=");
                sbU.append(this.index);
                sbU.append(", item=");
                sbU.append(getItem());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Operation(Item item, List<? extends Item> list) {
            this.item = item;
            this.items = list;
        }

        public Item getItem() {
            return this.item;
        }

        public List<Item> getItems() {
            return this.items;
        }

        public /* synthetic */ Operation(Item item, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : item, (i & 2) != 0 ? null : list);
        }
    }

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelGuildMemberListUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelGuildMemberListUpdate parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new ModelGuildMemberListUpdate5(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            Long l = (Long) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = ModelGuildMemberListUpdate.EVERYONE_ID;
            }
            String str2 = str;
            List list = (List) ref$ObjectRef2.element;
            Intrinsics3.checkNotNull(list);
            List list2 = (List) ref$ObjectRef3.element;
            Intrinsics3.checkNotNull(list2);
            return new ModelGuildMemberListUpdate(jLongValue, str2, list, list2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelGuildMemberListUpdate(long j, String str, List<? extends Operation> list, List<Group> list2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(list, "operations");
        Intrinsics3.checkNotNullParameter(list2, "groups");
        this.guildId = j;
        this.id = str;
        this.operations = list;
        this.groups = list2;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate copy$default(ModelGuildMemberListUpdate modelGuildMemberListUpdate, long j, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelGuildMemberListUpdate.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = modelGuildMemberListUpdate.id;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = modelGuildMemberListUpdate.operations;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = modelGuildMemberListUpdate.groups;
        }
        return modelGuildMemberListUpdate.copy(j2, str2, list3, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<Operation> component3() {
        return this.operations;
    }

    public final List<Group> component4() {
        return this.groups;
    }

    public final ModelGuildMemberListUpdate copy(long guildId, String id2, List<? extends Operation> operations, List<Group> groups) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(operations, "operations");
        Intrinsics3.checkNotNullParameter(groups, "groups");
        return new ModelGuildMemberListUpdate(guildId, id2, operations, groups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate)) {
            return false;
        }
        ModelGuildMemberListUpdate modelGuildMemberListUpdate = (ModelGuildMemberListUpdate) other;
        return this.guildId == modelGuildMemberListUpdate.guildId && Intrinsics3.areEqual(this.id, modelGuildMemberListUpdate.id) && Intrinsics3.areEqual(this.operations, modelGuildMemberListUpdate.operations) && Intrinsics3.areEqual(this.groups, modelGuildMemberListUpdate.groups);
    }

    public final List<Group> getGroups() {
        return this.groups;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Operation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Operation> list = this.operations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Group> list2 = this.groups;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildMemberListUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", operations=");
        sbU.append(this.operations);
        sbU.append(", groups=");
        return outline.L(sbU, this.groups, ")");
    }
}
