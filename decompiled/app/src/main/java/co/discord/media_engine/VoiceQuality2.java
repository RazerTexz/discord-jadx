package co.discord.media_engine;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0019R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0019R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lco/discord/media_engine/Duration;", "", "", "component1", "()I", "component2", "component3", "component4", "listening", "speaking", "participation", "connected", "copy", "(IIII)Lco/discord/media_engine/Duration;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getConnected", "setConnected", "(I)V", "getSpeaking", "setSpeaking", "getListening", "setListening", "getParticipation", "setParticipation", "<init>", "(IIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.Duration, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality2 {
    private int connected;
    private int listening;
    private int participation;
    private int speaking;

    public VoiceQuality2(int i, int i2, int i3, int i4) {
        this.listening = i;
        this.speaking = i2;
        this.participation = i3;
        this.connected = i4;
    }

    public static /* synthetic */ VoiceQuality2 copy$default(VoiceQuality2 voiceQuality2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = voiceQuality2.listening;
        }
        if ((i5 & 2) != 0) {
            i2 = voiceQuality2.speaking;
        }
        if ((i5 & 4) != 0) {
            i3 = voiceQuality2.participation;
        }
        if ((i5 & 8) != 0) {
            i4 = voiceQuality2.connected;
        }
        return voiceQuality2.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getListening() {
        return this.listening;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSpeaking() {
        return this.speaking;
    }

    /* renamed from: component3, reason: from getter */
    public final int getParticipation() {
        return this.participation;
    }

    /* renamed from: component4, reason: from getter */
    public final int getConnected() {
        return this.connected;
    }

    public final VoiceQuality2 copy(int listening, int speaking, int participation, int connected) {
        return new VoiceQuality2(listening, speaking, participation, connected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality2)) {
            return false;
        }
        VoiceQuality2 voiceQuality2 = (VoiceQuality2) other;
        return this.listening == voiceQuality2.listening && this.speaking == voiceQuality2.speaking && this.participation == voiceQuality2.participation && this.connected == voiceQuality2.connected;
    }

    public final int getConnected() {
        return this.connected;
    }

    public final int getListening() {
        return this.listening;
    }

    public final int getParticipation() {
        return this.participation;
    }

    public final int getSpeaking() {
        return this.speaking;
    }

    public int hashCode() {
        return (((((this.listening * 31) + this.speaking) * 31) + this.participation) * 31) + this.connected;
    }

    public final void setConnected(int i) {
        this.connected = i;
    }

    public final void setListening(int i) {
        this.listening = i;
    }

    public final void setParticipation(int i) {
        this.participation = i;
    }

    public final void setSpeaking(int i) {
        this.speaking = i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Duration(listening=");
        sbU.append(this.listening);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", participation=");
        sbU.append(this.participation);
        sbU.append(", connected=");
        return outline.B(sbU, this.connected, ")");
    }
}
