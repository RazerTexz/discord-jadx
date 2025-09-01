package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelGuildMemberListUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildMemberListUpdate5<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $groups;
    public final /* synthetic */ Ref$ObjectRef $guildId;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Ref$ObjectRef $operations;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Operation> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate.Operation get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelGuildMemberListUpdate.Operation get() {
            return ModelGuildMemberListUpdate.Operation.Parser.INSTANCE.parse(ModelGuildMemberListUpdate5.this.$reader);
        }
    }

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Group> {
        public AnonymousClass2() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate.Group get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelGuildMemberListUpdate.Group get() {
            return ModelGuildMemberListUpdate.Group.Parser.INSTANCE.parse(ModelGuildMemberListUpdate5.this.$reader);
        }
    }

    public ModelGuildMemberListUpdate5(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4) {
        this.$guildId = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$id = ref$ObjectRef2;
        this.$operations = ref$ObjectRef3;
        this.$groups = ref$ObjectRef4;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1306538777) {
                if (iHashCode != -1237460524) {
                    if (iHashCode != 3355) {
                        if (iHashCode == 110258 && str.equals("ops")) {
                            this.$operations.element = (T) this.$reader.nextList(new AnonymousClass1());
                            return;
                        }
                    } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                        this.$id.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                } else if (str.equals("groups")) {
                    this.$groups.element = (T) this.$reader.nextList(new AnonymousClass2());
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                this.$guildId.element = (T) this.$reader.nextLongOrNull();
                return;
            }
        }
        this.$reader.skipValue();
    }
}
