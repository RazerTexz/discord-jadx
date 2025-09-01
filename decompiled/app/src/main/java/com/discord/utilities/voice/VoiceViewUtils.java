package com.discord.utilities.voice;

import android.content.Context;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.rtcconnection.RtcConnection;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: VoiceViewUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/utilities/voice/VoiceViewUtils;", "", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "connectionQuality", "", "getQualityIndicator", "(Lcom/discord/rtcconnection/RtcConnection$Quality;)I", "", "hasVideo", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "getCallIndicatorIcon", "(ZLcom/discord/utilities/streams/StreamContext;)I", "Landroid/content/Context;", "context", "Lcom/discord/rtcconnection/RtcConnection$State;", "rtcConnectionState", "", "getConnectedText", "(Landroid/content/Context;Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/utilities/streams/StreamContext;Z)Ljava/lang/CharSequence;", "connectionState", "getConnectionStatusColor", "(Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Landroid/content/Context;)I", "getIsSoundshareSupported", "()Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceViewUtils {
    public static final VoiceViewUtils INSTANCE = new VoiceViewUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            RtcConnection.Quality.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            RtcConnection.Quality quality = RtcConnection.Quality.BAD;
            iArr[quality.ordinal()] = 1;
            RtcConnection.Quality quality2 = RtcConnection.Quality.AVERAGE;
            iArr[quality2.ordinal()] = 2;
            RtcConnection.Quality quality3 = RtcConnection.Quality.FINE;
            iArr[quality3.ordinal()] = 3;
            RtcConnection.Quality quality4 = RtcConnection.Quality.UNKNOWN;
            iArr[quality4.ordinal()] = 4;
            RtcConnection.Quality.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[quality.ordinal()] = 1;
            iArr2[quality2.ordinal()] = 2;
            iArr2[quality3.ordinal()] = 3;
            iArr2[quality4.ordinal()] = 4;
        }
    }

    private VoiceViewUtils() {
    }

    public static /* synthetic */ CharSequence getConnectedText$default(VoiceViewUtils voiceViewUtils, Context context, RtcConnection.State state, StreamContext streamContext, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return voiceViewUtils.getConnectedText(context, state, streamContext, z2);
    }

    public final int getCallIndicatorIcon(boolean hasVideo, StreamContext streamContext) {
        return (streamContext == null || !streamContext.isCurrentUserParticipating()) ? hasVideo ? R.drawable.ic_videocam_white_16dp : R.drawable.ic_call_indicator_voice_16dp : streamContext.isSelfStream() ? R.drawable.ic_call_indicator_mobile_screenshare_16dp : R.drawable.ic_call_indicator_streaming_16dp;
    }

    public final CharSequence getConnectedText(Context context, RtcConnection.State rtcConnectionState, StreamContext streamContext, boolean hasVideo) {
        int i;
        Intrinsics3.checkNotNullParameter(context, "context");
        RtcConnection.State.f fVar = RtcConnection.State.f.a;
        if (rtcConnectionState == fVar && streamContext != null && streamContext.isCurrentUserParticipating()) {
            if (streamContext.isSelfStream()) {
                return FormatUtils.h(context, R.string.connection_status_stream_self_connected, new Object[0], null, 4);
            }
            Object[] objArr = new Object[1];
            String userNickname = streamContext.getUserNickname();
            if (userNickname == null) {
                userNickname = streamContext.getUser().getUsername();
            }
            objArr[0] = userNickname;
            return FormatUtils.h(context, R.string.connection_status_stream_connected, objArr, null, 4);
        }
        if (Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.c.a)) {
            i = R.string.connection_status_connecting;
        } else if (Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.e.a)) {
            i = R.string.connection_status_no_route;
        } else if (Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.b.a)) {
            i = R.string.connection_status_awaiting_endpoint;
        } else if (Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.a.a)) {
            i = R.string.connection_status_authenticating;
        } else if (Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.g.a)) {
            i = R.string.connection_status_rtc_connecting;
        } else if (Intrinsics3.areEqual(rtcConnectionState, fVar)) {
            i = hasVideo ? R.string.connection_status_video_connected : R.string.connection_status_voice_connected;
        } else {
            if (!(rtcConnectionState instanceof RtcConnection.State.d) && !Intrinsics3.areEqual(rtcConnectionState, RtcConnection.State.h.a) && rtcConnectionState != null) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.connection_status_disconnected;
        }
        String string = context.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r5 != 3) goto L15;
     */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getConnectionStatusColor(RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (!Intrinsics3.areEqual(connectionState, RtcConnection.State.f.a)) {
            return (Intrinsics3.areEqual(connectionState, RtcConnection.State.b.a) || Intrinsics3.areEqual(connectionState, RtcConnection.State.c.a) || Intrinsics3.areEqual(connectionState, RtcConnection.State.a.a) || Intrinsics3.areEqual(connectionState, RtcConnection.State.g.a)) ? ColorCompat.getColor(context, R.color.status_yellow_500) : Intrinsics3.areEqual(connectionState, RtcConnection.State.e.a) ? ColorCompat.getColor(context, R.color.status_red_500) : ((connectionState instanceof RtcConnection.State.d) || Intrinsics3.areEqual(connectionState, RtcConnection.State.h.a)) ? ColorCompat.getColor(context, R.color.status_red_500) : ColorCompat.getColor(context, R.color.status_red_500);
        }
        if (connectionQuality != null) {
            int iOrdinal = connectionQuality.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    return ColorCompat.getColor(context, R.color.status_red_500);
                }
                if (iOrdinal == 2) {
                    return ColorCompat.getColor(context, R.color.status_yellow_500);
                }
            }
            return ColorCompat.getColor(context, R.color.status_green_600);
        }
        return ColorCompat.getColor(context, R.color.status_green_600);
    }

    public final boolean getIsSoundshareSupported() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @DrawableRes
    public final int getQualityIndicator(RtcConnection.Quality connectionQuality) {
        int iOrdinal;
        return (connectionQuality == null || (iOrdinal = connectionQuality.ordinal()) == 0) ? R.drawable.ic_voice_quality_unknown : iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? R.drawable.ic_voice_quality_unknown : R.drawable.ic_voice_quality_fine : R.drawable.ic_voice_quality_average : R.drawable.ic_voice_quality_bad;
    }
}
