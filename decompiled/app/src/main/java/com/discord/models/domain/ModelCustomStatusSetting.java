package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.google.gson.stream.JsonToken;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelCustomStatusSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B5\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JF\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/models/domain/ModelCustomStatusSetting;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", "Lcom/discord/primitives/UtcTimestamp;", "component4", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "emojiId", "emojiName", "expiresAt", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/ModelCustomStatusSetting;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getExpiresAt", "Ljava/lang/Long;", "getEmojiId", "getEmojiName", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelCustomStatusSetting {
    private final Long emojiId;
    private final String emojiName;
    private final String expiresAt;
    private final String text;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelCustomStatusSetting CLEAR = new ModelCustomStatusSetting(null, null, null, null);

    /* compiled from: ModelCustomStatusSetting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelCustomStatusSetting$Companion;", "", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "CLEAR", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "getCLEAR", "()Lcom/discord/models/domain/ModelCustomStatusSetting;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ModelCustomStatusSetting getCLEAR() {
            return ModelCustomStatusSetting.access$getCLEAR$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModelCustomStatusSetting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelCustomStatusSetting$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelCustomStatusSetting;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelCustomStatusSetting> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelCustomStatusSetting parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelCustomStatusSetting parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return ModelCustomStatusSetting.INSTANCE.getCLEAR();
            }
            reader.nextObject(new ModelCustomStatusSetting2(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            return new ModelCustomStatusSetting((String) ref$ObjectRefC0.element, (Long) ref$ObjectRef.element, (String) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelCustomStatusSetting(String str, Long l, String str2, String str3) {
        this.text = str;
        this.emojiId = l;
        this.emojiName = str2;
        this.expiresAt = str3;
    }

    public static final /* synthetic */ ModelCustomStatusSetting access$getCLEAR$cp() {
        return CLEAR;
    }

    public static /* synthetic */ ModelCustomStatusSetting copy$default(ModelCustomStatusSetting modelCustomStatusSetting, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelCustomStatusSetting.text;
        }
        if ((i & 2) != 0) {
            l = modelCustomStatusSetting.emojiId;
        }
        if ((i & 4) != 0) {
            str2 = modelCustomStatusSetting.emojiName;
        }
        if ((i & 8) != 0) {
            str3 = modelCustomStatusSetting.expiresAt;
        }
        return modelCustomStatusSetting.copy(str, l, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final ModelCustomStatusSetting copy(String text, Long emojiId, String emojiName, String expiresAt) {
        return new ModelCustomStatusSetting(text, emojiId, emojiName, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCustomStatusSetting)) {
            return false;
        }
        ModelCustomStatusSetting modelCustomStatusSetting = (ModelCustomStatusSetting) other;
        return Intrinsics3.areEqual(this.text, modelCustomStatusSetting.text) && Intrinsics3.areEqual(this.emojiId, modelCustomStatusSetting.emojiId) && Intrinsics3.areEqual(this.emojiName, modelCustomStatusSetting.emojiName) && Intrinsics3.areEqual(this.expiresAt, modelCustomStatusSetting.expiresAt);
    }

    public final Long getEmojiId() {
        return this.emojiId;
    }

    public final String getEmojiName() {
        return this.emojiName;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiresAt;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelCustomStatusSetting(text=");
        sbU.append(this.text);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", expiresAt=");
        return outline.J(sbU, this.expiresAt, ")");
    }
}
