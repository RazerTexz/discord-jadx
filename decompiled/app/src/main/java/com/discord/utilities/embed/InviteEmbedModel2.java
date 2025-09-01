package com.discord.utilities.embed;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: InviteEmbedModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00002\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b0\u00002\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\u0000¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "p1", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "p2", "Lcom/discord/api/stageinstance/StageInstance;", "p3", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "p4", "Lcom/discord/utilities/embed/InviteEmbedModel;", "invoke", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/embed/InviteEmbedModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.embed.InviteEmbedModel$Companion$observe$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class InviteEmbedModel2 extends FunctionReferenceImpl implements Function4<Map<Long, ? extends Channel>, Map<String, ? extends StoreInstantInvites.InviteState>, Map<Long, ? extends StageInstance>, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState>, InviteEmbedModel> {
    public static final InviteEmbedModel2 INSTANCE = new InviteEmbedModel2();

    public InviteEmbedModel2() {
        super(4, InviteEmbedModel.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ InviteEmbedModel invoke(Map<Long, ? extends Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, ? extends StageInstance> map3, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState> map4) {
        return invoke2((Map<Long, Channel>) map, map2, (Map<Long, StageInstance>) map3, (Map<Long, StoreRequestedStageChannels.StageInstanceState>) map4);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final InviteEmbedModel invoke2(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels.StageInstanceState> map4) {
        Intrinsics3.checkNotNullParameter(map, "p1");
        Intrinsics3.checkNotNullParameter(map2, "p2");
        Intrinsics3.checkNotNullParameter(map3, "p3");
        Intrinsics3.checkNotNullParameter(map4, "p4");
        return new InviteEmbedModel(map, map2, map3, map4);
    }
}
