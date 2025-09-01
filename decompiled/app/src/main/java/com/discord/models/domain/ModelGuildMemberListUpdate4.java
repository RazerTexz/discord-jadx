package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;
import rx.functions.Action1;

/* compiled from: ModelGuildMemberListUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildMemberListUpdate4<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $index;
    public final /* synthetic */ Ref$ObjectRef $item;
    public final /* synthetic */ Ref$ObjectRef $items;
    public final /* synthetic */ Ref$ObjectRef $range;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $type;

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Integer> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Integer get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Integer get() {
            return ModelGuildMemberListUpdate4.this.$reader.nextIntOrNull();
        }
    }

    /* compiled from: ModelGuildMemberListUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Operation.Item> {
        public AnonymousClass3() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate.Operation.Item get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelGuildMemberListUpdate.Operation.Item get() {
            return ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(ModelGuildMemberListUpdate4.this.$reader);
        }
    }

    public ModelGuildMemberListUpdate4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$type = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$index = ref$ObjectRef2;
        this.$range = ref$ObjectRef3;
        this.$item = ref$ObjectRef4;
        this.$items = ref$ObjectRef5;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case 3553:
                    if (str.equals("op")) {
                        this.$type.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 3242771:
                    if (str.equals("item")) {
                        this.$item.element = (T) ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(this.$reader);
                        return;
                    }
                    break;
                case 100346066:
                    if (str.equals("index")) {
                        this.$index.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 100526016:
                    if (str.equals("items")) {
                        this.$items.element = (T) this.$reader.nextList(new AnonymousClass3());
                        return;
                    }
                    break;
                case 108280125:
                    if (str.equals("range")) {
                        Ref$ObjectRef ref$ObjectRef = this.$range;
                        List<T> listNextList = this.$reader.nextList(new AnonymousClass1());
                        T t = listNextList.get(0);
                        Intrinsics3.checkNotNullExpressionValue(t, "it[0]");
                        int iIntValue = ((Number) t).intValue();
                        T t2 = listNextList.get(1);
                        Intrinsics3.checkNotNullExpressionValue(t2, "it[1]");
                        ref$ObjectRef.element = (T) new Ranges2(iIntValue, ((Number) t2).intValue());
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
