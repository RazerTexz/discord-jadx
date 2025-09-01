package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelUserNote.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/ModelUserNote;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "noteUserId", "note", "copy", "(JLjava/lang/String;)Lcom/discord/models/domain/ModelUserNote;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNote", "J", "getNoteUserId", "<init>", "(JLjava/lang/String;)V", "Update", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelUserNote {
    private final String note;
    private final long noteUserId;

    /* compiled from: ModelUserNote.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/ModelUserNote$Update;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "note", "copy", "(JLjava/lang/String;)Lcom/discord/models/domain/ModelUserNote$Update;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNote", "J", "getId", "<init>", "(JLjava/lang/String;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Update {
        private final long id;
        private final String note;

        /* compiled from: ModelUserNote.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelUserNote$Update$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelUserNote$Update;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelUserNote$Update;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Parser implements Model.Parser<Update> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Update parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Update parse(Model.JsonReader reader) throws IOException {
                Intrinsics3.checkNotNullParameter(reader, "reader");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.element = 0L;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                reader.nextObject(new ModelUserNote2(ref$LongRef, reader, ref$ObjectRef));
                return new Update(ref$LongRef.element, (String) ref$ObjectRef.element);
            }
        }

        public Update(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "note");
            this.id = j;
            this.note = str;
        }

        public static /* synthetic */ Update copy$default(Update update, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = update.id;
            }
            if ((i & 2) != 0) {
                str = update.note;
            }
            return update.copy(j, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        public final Update copy(long id2, String note) {
            Intrinsics3.checkNotNullParameter(note, "note");
            return new Update(id2, note);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return this.id == update.id && Intrinsics3.areEqual(this.note, update.note);
        }

        public final long getId() {
            return this.id;
        }

        public final String getNote() {
            return this.note;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.note;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Update(id=");
            sbU.append(this.id);
            sbU.append(", note=");
            return outline.J(sbU, this.note, ")");
        }
    }

    public ModelUserNote(long j, String str) {
        this.noteUserId = j;
        this.note = str;
    }

    public static /* synthetic */ ModelUserNote copy$default(ModelUserNote modelUserNote, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserNote.noteUserId;
        }
        if ((i & 2) != 0) {
            str = modelUserNote.note;
        }
        return modelUserNote.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNoteUserId() {
        return this.noteUserId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ModelUserNote copy(long noteUserId, String note) {
        return new ModelUserNote(noteUserId, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserNote)) {
            return false;
        }
        ModelUserNote modelUserNote = (ModelUserNote) other;
        return this.noteUserId == modelUserNote.noteUserId && Intrinsics3.areEqual(this.note, modelUserNote.note);
    }

    public final String getNote() {
        return this.note;
    }

    public final long getNoteUserId() {
        return this.noteUserId;
    }

    public int hashCode() {
        long j = this.noteUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.note;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserNote(noteUserId=");
        sbU.append(this.noteUserId);
        sbU.append(", note=");
        return outline.J(sbU, this.note, ")");
    }
}
