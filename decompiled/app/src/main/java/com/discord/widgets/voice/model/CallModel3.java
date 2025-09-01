package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func8;

/* compiled from: CallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0016\u001a\n \u0002*\u0004\u0018\u00010\u00130\u00132\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u0018\u0010\u0005\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00040\u0000j\u0002`\u00042\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062.\u0010\n\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\t \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b2\u000e\u0010\f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e \u0002*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0012\u001a\n \u0002*\u0004\u0018\u00010\u00110\u0011H\n¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "myUserId", "Lcom/discord/primitives/Timestamp;", "timeConnectedMs", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "voiceConfig", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceParticipants", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "videoDevices", "selectedVideoDevice", "Lcom/discord/stores/StoreAudioManagerV2$State;", "audioManagerState", "Lcom/discord/widgets/voice/model/CallModel$Companion$Chunk;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;Lco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreAudioManagerV2$State;)Lcom/discord/widgets/voice/model/CallModel$Companion$Chunk;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.model.CallModel$Companion$observeChunk$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CallModel3<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Long, Long, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, Long, List<? extends DeviceDescription4>, DeviceDescription4, StoreAudioManagerV2.State, CallModel.Companion.Chunk> {
    public final /* synthetic */ Channel $channel;

    public CallModel3(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ CallModel.Companion.Chunk call(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, Long l3, List<? extends DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
        return call2(l, l2, voiceConfiguration, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, l3, (List<DeviceDescription4>) list, deviceDescription4, state);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final CallModel.Companion.Chunk call2(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l3, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        Intrinsics3.checkNotNullExpressionValue(l2, "timeConnectedMs");
        long jLongValue2 = l2.longValue();
        Intrinsics3.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
        Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
        Intrinsics3.checkNotNullExpressionValue(list, "videoDevices");
        Intrinsics3.checkNotNullExpressionValue(state, "audioManagerState");
        return new CallModel.Companion.Chunk(channel, jLongValue, jLongValue2, voiceConfiguration, map, l3, list, deviceDescription4, state);
    }
}
