package com.discord.utilities.media;

import b.d.b.a.outline;
import com.discord.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppSound.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/utilities/media/AppSound;", "", "", "component1", "()I", "", "component2", "()Z", "component3", "component4", "resId", "shouldLoop", "contentType", "usage", "copy", "(IZII)Lcom/discord/utilities/media/AppSound;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getResId", "getUsage", "Z", "getShouldLoop", "getContentType", "<init>", "(IZII)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AppSound {
    private final int contentType;
    private final int resId;
    private final boolean shouldLoop;
    private final int usage;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AppSound SOUND_DEAFEN = new AppSound(R.raw.deafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_UNDEAFEN = new AppSound(R.raw.undeafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_MUTE = new AppSound(R.raw.mute, false, 4, 13, 2, null);
    private static final AppSound SOUND_UNMUTE = new AppSound(R.raw.unmute, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_ENDED = new AppSound(R.raw.stream_ended, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_STARTED = new AppSound(R.raw.stream_started, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_USER_JOINED = new AppSound(R.raw.stream_user_joined, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_USER_LEFT = new AppSound(R.raw.stream_user_left, false, 4, 13, 2, null);
    private static final AppSound SOUND_CALL_RINGING = new AppSound(R.raw.call_ringing, true, 4, 7);
    private static final AppSound SOUND_CALL_CALLING = new AppSound(R.raw.call_calling, true, 4, 3);
    private static final AppSound SOUND_RECONNECT = new AppSound(R.raw.reconnect, false, 4, 3, 2, null);
    private static final AppSound SOUND_USER_JOINED = new AppSound(R.raw.user_join, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_LEFT = new AppSound(R.raw.user_leave, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_MOVED = new AppSound(R.raw.user_moved, false, 4, 13, 2, null);

    /* compiled from: AppSound.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006#"}, d2 = {"Lcom/discord/utilities/media/AppSound$Companion;", "", "Lcom/discord/utilities/media/AppSound;", "SOUND_CALL_CALLING", "Lcom/discord/utilities/media/AppSound;", "getSOUND_CALL_CALLING", "()Lcom/discord/utilities/media/AppSound;", "SOUND_UNDEAFEN", "getSOUND_UNDEAFEN", "SOUND_USER_LEFT", "getSOUND_USER_LEFT", "SOUND_STREAM_ENDED", "getSOUND_STREAM_ENDED", "SOUND_DEAFEN", "getSOUND_DEAFEN", "SOUND_RECONNECT", "getSOUND_RECONNECT", "SOUND_UNMUTE", "getSOUND_UNMUTE", "SOUND_USER_JOINED", "getSOUND_USER_JOINED", "SOUND_CALL_RINGING", "getSOUND_CALL_RINGING", "SOUND_STREAM_USER_JOINED", "getSOUND_STREAM_USER_JOINED", "SOUND_MUTE", "getSOUND_MUTE", "SOUND_USER_MOVED", "getSOUND_USER_MOVED", "SOUND_STREAM_STARTED", "getSOUND_STREAM_STARTED", "SOUND_STREAM_USER_LEFT", "getSOUND_STREAM_USER_LEFT", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final AppSound getSOUND_CALL_CALLING() {
            return AppSound.access$getSOUND_CALL_CALLING$cp();
        }

        public final AppSound getSOUND_CALL_RINGING() {
            return AppSound.access$getSOUND_CALL_RINGING$cp();
        }

        public final AppSound getSOUND_DEAFEN() {
            return AppSound.access$getSOUND_DEAFEN$cp();
        }

        public final AppSound getSOUND_MUTE() {
            return AppSound.access$getSOUND_MUTE$cp();
        }

        public final AppSound getSOUND_RECONNECT() {
            return AppSound.access$getSOUND_RECONNECT$cp();
        }

        public final AppSound getSOUND_STREAM_ENDED() {
            return AppSound.access$getSOUND_STREAM_ENDED$cp();
        }

        public final AppSound getSOUND_STREAM_STARTED() {
            return AppSound.access$getSOUND_STREAM_STARTED$cp();
        }

        public final AppSound getSOUND_STREAM_USER_JOINED() {
            return AppSound.access$getSOUND_STREAM_USER_JOINED$cp();
        }

        public final AppSound getSOUND_STREAM_USER_LEFT() {
            return AppSound.access$getSOUND_STREAM_USER_LEFT$cp();
        }

        public final AppSound getSOUND_UNDEAFEN() {
            return AppSound.access$getSOUND_UNDEAFEN$cp();
        }

        public final AppSound getSOUND_UNMUTE() {
            return AppSound.access$getSOUND_UNMUTE$cp();
        }

        public final AppSound getSOUND_USER_JOINED() {
            return AppSound.access$getSOUND_USER_JOINED$cp();
        }

        public final AppSound getSOUND_USER_LEFT() {
            return AppSound.access$getSOUND_USER_LEFT$cp();
        }

        public final AppSound getSOUND_USER_MOVED() {
            return AppSound.access$getSOUND_USER_MOVED$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AppSound(int i, boolean z2, int i2, int i3) {
        this.resId = i;
        this.shouldLoop = z2;
        this.contentType = i2;
        this.usage = i3;
    }

    public static final /* synthetic */ AppSound access$getSOUND_CALL_CALLING$cp() {
        return SOUND_CALL_CALLING;
    }

    public static final /* synthetic */ AppSound access$getSOUND_CALL_RINGING$cp() {
        return SOUND_CALL_RINGING;
    }

    public static final /* synthetic */ AppSound access$getSOUND_DEAFEN$cp() {
        return SOUND_DEAFEN;
    }

    public static final /* synthetic */ AppSound access$getSOUND_MUTE$cp() {
        return SOUND_MUTE;
    }

    public static final /* synthetic */ AppSound access$getSOUND_RECONNECT$cp() {
        return SOUND_RECONNECT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_ENDED$cp() {
        return SOUND_STREAM_ENDED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_STARTED$cp() {
        return SOUND_STREAM_STARTED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_USER_JOINED$cp() {
        return SOUND_STREAM_USER_JOINED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_USER_LEFT$cp() {
        return SOUND_STREAM_USER_LEFT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_UNDEAFEN$cp() {
        return SOUND_UNDEAFEN;
    }

    public static final /* synthetic */ AppSound access$getSOUND_UNMUTE$cp() {
        return SOUND_UNMUTE;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_JOINED$cp() {
        return SOUND_USER_JOINED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_LEFT$cp() {
        return SOUND_USER_LEFT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_MOVED$cp() {
        return SOUND_USER_MOVED;
    }

    public static /* synthetic */ AppSound copy$default(AppSound appSound, int i, boolean z2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = appSound.resId;
        }
        if ((i4 & 2) != 0) {
            z2 = appSound.shouldLoop;
        }
        if ((i4 & 4) != 0) {
            i2 = appSound.contentType;
        }
        if ((i4 & 8) != 0) {
            i3 = appSound.usage;
        }
        return appSound.copy(i, z2, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShouldLoop() {
        return this.shouldLoop;
    }

    /* renamed from: component3, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getUsage() {
        return this.usage;
    }

    public final AppSound copy(int resId, boolean shouldLoop, int contentType, int usage) {
        return new AppSound(resId, shouldLoop, contentType, usage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSound)) {
            return false;
        }
        AppSound appSound = (AppSound) other;
        return this.resId == appSound.resId && this.shouldLoop == appSound.shouldLoop && this.contentType == appSound.contentType && this.usage == appSound.usage;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final int getResId() {
        return this.resId;
    }

    public final boolean getShouldLoop() {
        return this.shouldLoop;
    }

    public final int getUsage() {
        return this.usage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.resId * 31;
        boolean z2 = this.shouldLoop;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return ((((i + i2) * 31) + this.contentType) * 31) + this.usage;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AppSound(resId=");
        sbU.append(this.resId);
        sbU.append(", shouldLoop=");
        sbU.append(this.shouldLoop);
        sbU.append(", contentType=");
        sbU.append(this.contentType);
        sbU.append(", usage=");
        return outline.B(sbU, this.usage, ")");
    }

    public /* synthetic */ AppSound(int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? false : z2, i2, i3);
    }
}
