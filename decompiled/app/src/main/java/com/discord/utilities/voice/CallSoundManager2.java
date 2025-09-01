package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.voice.CallSoundManager;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func7;

/* compiled from: CallSoundManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0017\u001a\n \u0004*\u0004\u0018\u00010\u00140\u00142.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\t\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00000\u00002B\u0010\r\u001a>\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\f \u0004*\u001e\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\f\u0018\u00010\u00000\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n \u0004*\u0004\u0018\u00010\u00100\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "kotlin.jvm.PlatformType", "voiceParticipants", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "rtcConnectionState", "Lcom/discord/models/domain/ModelApplicationStream;", "streamsByUser", "", "Lcom/discord/primitives/StreamKey;", "", "streamSpectators", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeApplicationStream", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/api/channel/Channel;", "selectedVoiceChannel", "Lcom/discord/utilities/voice/CallSoundManager$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Lcom/discord/rtcconnection/RtcConnection$StateChange;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;)Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.voice.CallSoundManager$StoreStateGenerator$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class CallSoundManager2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, RtcConnection.StateChange, Map<Long, ? extends ModelApplicationStream>, Map<String, ? extends List<? extends Long>>, StoreApplicationStreaming.ActiveApplicationStream, MeUser, Channel, CallSoundManager.StoreState> {
    public static final CallSoundManager2 INSTANCE = new CallSoundManager2();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ CallSoundManager.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<? extends Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
        return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, stateChange, map2, (Map<String, ? extends List<Long>>) map3, activeApplicationStream, meUser, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final CallSoundManager.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
        Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
        RtcConnection.State state = stateChange.state;
        Intrinsics3.checkNotNullExpressionValue(map2, "streamsByUser");
        Intrinsics3.checkNotNullExpressionValue(map3, "streamSpectators");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        return new CallSoundManager.StoreState(map, state, map2, map3, activeApplicationStream, meUser, channel);
    }
}
