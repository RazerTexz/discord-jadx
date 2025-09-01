package com.discord.widgets.voice.feedback;

import androidx.annotation.StringRes;
import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.Metadata;

/* compiled from: FeedbackIssue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0013\b\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "reasonStringRes", "getReasonStringRes", "<init>", "(Ljava/lang/String;II)V", "OTHER", "COULD_NOT_HEAR_AUDIO", "NOBODY_COULD_HEAR_ME", "AUDIO_ECHOS", "AUDIO_ROBOTIC", "AUDIO_CUT_IN_AND_OUT", "VOLUME_TOO_LOW_OR_HIGH", "BACKGROUND_NOISE_TOO_LOUD", "SPEAKERPHONE_ISSUE", "HEADSET_OR_BLUETOOTH_ISSUE", "STREAM_REPORT_ENDED_BLACK", "STREAM_REPORT_ENDED_BLURRY", "STREAM_REPORT_ENDED_LAGGING", "STREAM_REPORT_ENDED_OUT_OF_SYNC", "STREAM_REPORT_ENDED_AUDIO_MISSING", "STREAM_REPORT_ENDED_AUDIO_POOR", "STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY", "GUILD_DELETE_TOO_HARD", "GUILD_DELETE_TEST", "GUILD_DELETE_ACCIDENT", "GUILD_DELETE_TEMPLATE", "GUILD_DELETE_LONELY", "GUILD_DELETE_INACTIVE", "GUILD_DELETE_OTHER", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum FeedbackIssue implements MGRecyclerDataPayload {
    OTHER(R.string.call_feedback_option_other),
    COULD_NOT_HEAR_AUDIO(R.string.call_feedback_option_could_not_hear_audio),
    NOBODY_COULD_HEAR_ME(R.string.call_feedback_option_nobody_could_hear_me),
    AUDIO_ECHOS(R.string.call_feedback_option_audio_echos),
    AUDIO_ROBOTIC(R.string.call_feedback_option_audio_robotic),
    AUDIO_CUT_IN_AND_OUT(R.string.call_feedback_option_audio_cut),
    VOLUME_TOO_LOW_OR_HIGH(R.string.call_feedback_option_bad_volume),
    BACKGROUND_NOISE_TOO_LOUD(R.string.call_feedback_option_background_noise),
    SPEAKERPHONE_ISSUE(R.string.call_feedback_option_speakerphone),
    HEADSET_OR_BLUETOOTH_ISSUE(R.string.call_feedback_option_headset),
    STREAM_REPORT_ENDED_BLACK(R.string.stream_report_ended_black),
    STREAM_REPORT_ENDED_BLURRY(R.string.stream_report_ended_blurry),
    STREAM_REPORT_ENDED_LAGGING(R.string.stream_report_ended_lagging),
    STREAM_REPORT_ENDED_OUT_OF_SYNC(R.string.stream_report_ended_out_of_sync),
    STREAM_REPORT_ENDED_AUDIO_MISSING(R.string.stream_report_ended_audio_missing),
    STREAM_REPORT_ENDED_AUDIO_POOR(R.string.stream_report_ended_audio_poor),
    STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY(R.string.stream_report_ended_stream_stopped_unexpectedly),
    GUILD_DELETE_TOO_HARD(R.string.guild_delete_feedback_too_hard),
    GUILD_DELETE_TEST(R.string.guild_delete_feedback_test),
    GUILD_DELETE_ACCIDENT(R.string.guild_delete_feedback_accident),
    GUILD_DELETE_TEMPLATE(R.string.guild_delete_feedback_template),
    GUILD_DELETE_LONELY(R.string.guild_delete_feedback_lonely),
    GUILD_DELETE_INACTIVE(R.string.guild_delete_feedback_inactive),
    GUILD_DELETE_OTHER(R.string.guild_delete_feedback_other);

    private final String key = String.valueOf(hashCode());
    private final int reasonStringRes;
    private final int type;

    FeedbackIssue(@StringRes int i) {
        this.reasonStringRes = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getReasonStringRes() {
        return this.reasonStringRes;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
