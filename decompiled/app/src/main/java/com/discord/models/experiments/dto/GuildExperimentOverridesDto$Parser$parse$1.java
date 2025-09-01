package com.discord.models.experiments.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_NAME, "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentOverridesDto$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $bucket;
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentOverridesDto$Parser$parse$1$1, reason: invalid class name */
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
            return Long.valueOf(GuildExperimentOverridesDto$Parser$parse$1.this.$reader.nextLong(-1L));
        }
    }

    public GuildExperimentOverridesDto$Parser$parse$1(Ref$IntRef ref$IntRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$bucket = ref$IntRef;
        this.$reader = jsonReader;
        this.$guildIds = ref$ObjectRef;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        if (str == null) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == 98) {
            if (str.equals("b")) {
                Ref$IntRef ref$IntRef = this.$bucket;
                ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
                return;
            }
            return;
        }
        if (iHashCode == 107 && str.equals("k")) {
            Ref$ObjectRef ref$ObjectRef = this.$guildIds;
            T t = (T) this.$reader.nextList(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { reader.nextLong(-1L) }");
            ref$ObjectRef.element = t;
        }
    }
}
