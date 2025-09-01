package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelChannelUnreadUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "", "", "Lcom/discord/models/domain/ModelReadState;", "component1", "()Ljava/util/List;", "channelReadStates", "copy", "(Ljava/util/List;)Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChannelReadStates", "<init>", "(Ljava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelChannelUnreadUpdate {
    private final List<ModelReadState> channelReadStates;

    /* compiled from: ModelChannelUnreadUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelChannelUnreadUpdate$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelChannelUnreadUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelChannelUnreadUpdate parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.Parser
        public ModelChannelUnreadUpdate parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            reader.nextObject(new ModelChannelUnreadUpdate2(ref$ObjectRefC0, reader));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("channelReadStates");
            }
            return new ModelChannelUnreadUpdate((List) t);
        }
    }

    public ModelChannelUnreadUpdate(List<ModelReadState> list) {
        Intrinsics3.checkNotNullParameter(list, "channelReadStates");
        this.channelReadStates = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelChannelUnreadUpdate copy$default(ModelChannelUnreadUpdate modelChannelUnreadUpdate, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelChannelUnreadUpdate.channelReadStates;
        }
        return modelChannelUnreadUpdate.copy(list);
    }

    public final List<ModelReadState> component1() {
        return this.channelReadStates;
    }

    public final ModelChannelUnreadUpdate copy(List<ModelReadState> channelReadStates) {
        Intrinsics3.checkNotNullParameter(channelReadStates, "channelReadStates");
        return new ModelChannelUnreadUpdate(channelReadStates);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelChannelUnreadUpdate) && Intrinsics3.areEqual(this.channelReadStates, ((ModelChannelUnreadUpdate) other).channelReadStates);
        }
        return true;
    }

    public final List<ModelReadState> getChannelReadStates() {
        return this.channelReadStates;
    }

    public int hashCode() {
        List<ModelReadState> list = this.channelReadStates;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.L(outline.U("ModelChannelUnreadUpdate(channelReadStates="), this.channelReadStates, ")");
    }
}
