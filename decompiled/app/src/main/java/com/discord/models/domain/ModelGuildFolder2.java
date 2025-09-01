package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelGuildFolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelGuildFolder$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildFolder2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $color;
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Ref$ObjectRef $name;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: ModelGuildFolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelGuildFolder$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Long> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Long get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Long get() {
            return ModelGuildFolder2.this.$reader.nextLongOrNull();
        }
    }

    public ModelGuildFolder2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4) {
        this.$id = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$guildIds = ref$ObjectRef2;
        this.$color = ref$ObjectRef3;
        this.$name = ref$ObjectRef4;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1847996308) {
                if (iHashCode != 3355) {
                    if (iHashCode != 3373707) {
                        if (iHashCode == 94842723 && str.equals(ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                            this.$color.element = (T) this.$reader.nextIntOrNull();
                            return;
                        }
                    } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        this.$name.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                    this.$id.element = (T) this.$reader.nextLongOrNull();
                    return;
                }
            } else if (str.equals("guild_ids")) {
                this.$guildIds.element = (T) this.$reader.nextList(new AnonymousClass1());
                return;
            }
        }
        this.$reader.skipValue();
    }
}
