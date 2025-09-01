package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/discord/models/domain/StreamType;", "", "", "serializedRepresentation", "Ljava/lang/String;", "getSerializedRepresentation", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "GUILD", "CALL", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamType, reason: use source file name */
/* loaded from: classes.dex */
public enum ModelApplicationStream9 {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelApplicationStream9[] VALUES = values();

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/models/domain/StreamType$Companion;", "", "", "string", "Lcom/discord/models/domain/StreamType;", "fromString", "(Ljava/lang/String;)Lcom/discord/models/domain/StreamType;", "", "VALUES", "[Lcom/discord/models/domain/StreamType;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamType$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ModelApplicationStream9 fromString(String string) {
            ModelApplicationStream9 modelApplicationStream9;
            Intrinsics3.checkNotNullParameter(string, "string");
            ModelApplicationStream9[] modelApplicationStream9ArrAccess$getVALUES$cp = ModelApplicationStream9.access$getVALUES$cp();
            int length = modelApplicationStream9ArrAccess$getVALUES$cp.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    modelApplicationStream9 = null;
                    break;
                }
                modelApplicationStream9 = modelApplicationStream9ArrAccess$getVALUES$cp[i];
                if (Intrinsics3.areEqual(modelApplicationStream9.getSerializedRepresentation(), string)) {
                    break;
                }
                i++;
            }
            if (modelApplicationStream9 != null) {
                return modelApplicationStream9;
            }
            throw new IllegalArgumentException(outline.w("unable to parse stream type: ", string));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ModelApplicationStream9(String str) {
        this.serializedRepresentation = str;
    }

    public static final /* synthetic */ ModelApplicationStream9[] access$getVALUES$cp() {
        return VALUES;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}
