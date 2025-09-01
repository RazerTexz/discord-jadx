package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelReadState;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelChannelUnreadUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelChannelUnreadUpdate2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $channelReadStates;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: ModelChannelUnreadUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelReadState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<ModelReadState> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelReadState get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelReadState get() {
            return ModelReadState.Parser.INSTANCE.parse(ModelChannelUnreadUpdate2.this.$reader);
        }
    }

    public ModelChannelUnreadUpdate2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$channelReadStates = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != -298662154 || !str.equals("channel_unread_updates")) {
            this.$reader.skipValue();
            return;
        }
        Ref$ObjectRef ref$ObjectRef = this.$channelReadStates;
        T t = (T) this.$reader.nextList(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { ModelR…te.Parser.parse(reader) }");
        ref$ObjectRef.element = t;
    }
}
