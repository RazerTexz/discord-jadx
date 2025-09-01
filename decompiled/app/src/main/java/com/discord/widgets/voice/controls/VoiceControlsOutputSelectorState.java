package com.discord.widgets.voice.controls;

import androidx.annotation.DrawableRes;
import com.discord.R;
import kotlin.Metadata;

/* compiled from: VoiceControlsOutputSelectorState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;", "", "", "isButtonActive", "Z", "()Z", "showMoreOptions", "getShowMoreOptions", "", "audioOutputIconRes", "I", "getAudioOutputIconRes", "()I", "<init>", "(Ljava/lang/String;IIZZ)V", "SPEAKER_ON", "SPEAKER_OFF", "BLUETOOTH_ON_AND_MORE", "SPEAKER_ON_AND_MORE", "SPEAKER_OFF_AND_MORE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum VoiceControlsOutputSelectorState {
    SPEAKER_ON(R.drawable.ic_sound_24dp, true, false),
    SPEAKER_OFF(R.drawable.ic_sound_quiet_24dp, false, false),
    BLUETOOTH_ON_AND_MORE(R.drawable.ic_sound_bluetooth_24dp, true, true),
    SPEAKER_ON_AND_MORE(R.drawable.ic_sound_24dp, true, true),
    SPEAKER_OFF_AND_MORE(R.drawable.ic_sound_quiet_24dp, false, true);

    private final int audioOutputIconRes;
    private final boolean isButtonActive;
    private final boolean showMoreOptions;

    VoiceControlsOutputSelectorState(@DrawableRes int i, boolean z2, boolean z3) {
        this.audioOutputIconRes = i;
        this.isButtonActive = z2;
        this.showMoreOptions = z3;
    }

    public final int getAudioOutputIconRes() {
        return this.audioOutputIconRes;
    }

    public final boolean getShowMoreOptions() {
        return this.showMoreOptions;
    }

    /* renamed from: isButtonActive, reason: from getter */
    public final boolean getIsButtonActive() {
        return this.isButtonActive;
    }
}
