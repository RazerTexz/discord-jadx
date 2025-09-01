package com.discord.api.message.embed;

import androidx.core.os.EnvironmentCompat;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: EmbedType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/api/message/embed/EmbedType;", "", "", "apiValue", "Ljava/lang/String;", "getApiValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ARTICLE", "IMAGE", "VIDEO", "TWEET", "LINK", "HTML", "FILE", "GIFV", "RICH", "APPLICATION_NEWS", "UNKNOWN", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum EmbedType {
    ARTICLE("article"),
    IMAGE("image"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    TWEET("tweet"),
    LINK("link"),
    HTML("html"),
    FILE("file"),
    GIFV("gifv"),
    RICH("rich"),
    APPLICATION_NEWS("application_news"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);

    private final String apiValue;

    EmbedType(String str) {
        this.apiValue = str;
    }

    public final String getApiValue() {
        return this.apiValue;
    }
}
