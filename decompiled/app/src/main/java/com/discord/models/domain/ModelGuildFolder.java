package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelGuildFolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'BA\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b%\u0010&J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\fR#\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\tR!\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0005¨\u0006("}, d2 = {"Lcom/discord/models/domain/ModelGuildFolder;", "", "", "Lcom/discord/primitives/FolderId;", "component1", "()Ljava/lang/Long;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Integer;", "", "component4", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "guildIds", ModelAuditLogEntry.CHANGE_KEY_COLOR, ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/discord/models/domain/ModelGuildFolder;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/lang/Integer;", "getColor", "Ljava/util/List;", "getGuildIds", "Ljava/lang/Long;", "getId", "<init>", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGuildFolder {
    private final Integer color;
    private final List<Long> guildIds;
    private final Long id;
    private final String name;

    /* compiled from: ModelGuildFolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelGuildFolder$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelGuildFolder;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelGuildFolder;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelGuildFolder> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelGuildFolder parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelGuildFolder parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new ModelGuildFolder2(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            Long l = (Long) ref$ObjectRefC0.element;
            List list = (List) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(list);
            return new ModelGuildFolder(l, list, (Integer) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelGuildFolder(Long l, List<Long> list, Integer num, String str) {
        Intrinsics3.checkNotNullParameter(list, "guildIds");
        this.id = l;
        this.guildIds = list;
        this.color = num;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildFolder copy$default(ModelGuildFolder modelGuildFolder, Long l, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelGuildFolder.id;
        }
        if ((i & 2) != 0) {
            list = modelGuildFolder.guildIds;
        }
        if ((i & 4) != 0) {
            num = modelGuildFolder.color;
        }
        if ((i & 8) != 0) {
            str = modelGuildFolder.name;
        }
        return modelGuildFolder.copy(l, list, num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.guildIds;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildFolder copy(Long id2, List<Long> guildIds, Integer color, String name) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        return new ModelGuildFolder(id2, guildIds, color, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildFolder)) {
            return false;
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) other;
        return Intrinsics3.areEqual(this.id, modelGuildFolder.id) && Intrinsics3.areEqual(this.guildIds, modelGuildFolder.guildIds) && Intrinsics3.areEqual(this.color, modelGuildFolder.color) && Intrinsics3.areEqual(this.name, modelGuildFolder.name);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final List<Long> getGuildIds() {
        return this.guildIds;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.guildIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildFolder(id=");
        sbU.append(this.id);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }

    public /* synthetic */ ModelGuildFolder(Long l, List list, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, list, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
    }
}
