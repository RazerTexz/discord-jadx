package com.discord.api.message.embed;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: MessageEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u0004R\u001b\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010C\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010\u0004¨\u0006E"}, d2 = {"Lcom/discord/api/message/embed/MessageEmbed;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/message/embed/EmbedField;", "fields", "Ljava/util/List;", "d", "()Ljava/util/List;", "Lcom/discord/api/message/embed/EmbedType;", "type", "Lcom/discord/api/message/embed/EmbedType;", "k", "()Lcom/discord/api/message/embed/EmbedType;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "timestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "i", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "title", "Ljava/lang/String;", "j", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/discord/api/message/embed/EmbedFooter;", "footer", "Lcom/discord/api/message/embed/EmbedFooter;", "e", "()Lcom/discord/api/message/embed/EmbedFooter;", "Lcom/discord/api/message/embed/EmbedAuthor;", "author", "Lcom/discord/api/message/embed/EmbedAuthor;", "a", "()Lcom/discord/api/message/embed/EmbedAuthor;", "Lcom/discord/api/message/embed/EmbedImage;", "image", "Lcom/discord/api/message/embed/EmbedImage;", "f", "()Lcom/discord/api/message/embed/EmbedImage;", "url", "l", "Lcom/discord/api/message/embed/EmbedProvider;", "provider", "Lcom/discord/api/message/embed/EmbedProvider;", "g", "()Lcom/discord/api/message/embed/EmbedProvider;", "Lcom/discord/api/message/embed/EmbedVideo;", MediaStreamTrack.VIDEO_TRACK_KIND, "Lcom/discord/api/message/embed/EmbedVideo;", "m", "()Lcom/discord/api/message/embed/EmbedVideo;", "Lcom/discord/api/message/embed/EmbedThumbnail;", "thumbnail", "Lcom/discord/api/message/embed/EmbedThumbnail;", "h", "()Lcom/discord/api/message/embed/EmbedThumbnail;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "c", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageEmbed {
    private final EmbedAuthor author;
    private final Integer color;
    private final String description;
    private final List<EmbedField> fields;
    private final EmbedFooter footer;
    private final EmbedImage image;
    private final EmbedProvider provider;
    private final EmbedThumbnail thumbnail;
    private final UtcDateTime timestamp;
    private final String title;
    private final EmbedType type;
    private final String url;
    private final EmbedVideo video;

    /* renamed from: a, reason: from getter */
    public final EmbedAuthor getAuthor() {
        return this.author;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<EmbedField> d() {
        return this.fields;
    }

    /* renamed from: e, reason: from getter */
    public final EmbedFooter getFooter() {
        return this.footer;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEmbed)) {
            return false;
        }
        MessageEmbed messageEmbed = (MessageEmbed) other;
        return Intrinsics3.areEqual(this.title, messageEmbed.title) && Intrinsics3.areEqual(this.type, messageEmbed.type) && Intrinsics3.areEqual(this.description, messageEmbed.description) && Intrinsics3.areEqual(this.url, messageEmbed.url) && Intrinsics3.areEqual(this.timestamp, messageEmbed.timestamp) && Intrinsics3.areEqual(this.color, messageEmbed.color) && Intrinsics3.areEqual(this.footer, messageEmbed.footer) && Intrinsics3.areEqual(this.image, messageEmbed.image) && Intrinsics3.areEqual(this.thumbnail, messageEmbed.thumbnail) && Intrinsics3.areEqual(this.video, messageEmbed.video) && Intrinsics3.areEqual(this.provider, messageEmbed.provider) && Intrinsics3.areEqual(this.author, messageEmbed.author) && Intrinsics3.areEqual(this.fields, messageEmbed.fields);
    }

    /* renamed from: f, reason: from getter */
    public final EmbedImage getImage() {
        return this.image;
    }

    /* renamed from: g, reason: from getter */
    public final EmbedProvider getProvider() {
        return this.provider;
    }

    /* renamed from: h, reason: from getter */
    public final EmbedThumbnail getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        EmbedType embedType = this.type;
        int iHashCode2 = (iHashCode + (embedType != null ? embedType.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.timestamp;
        int iHashCode5 = (iHashCode4 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        EmbedFooter embedFooter = this.footer;
        int iHashCode7 = (iHashCode6 + (embedFooter != null ? embedFooter.hashCode() : 0)) * 31;
        EmbedImage embedImage = this.image;
        int iHashCode8 = (iHashCode7 + (embedImage != null ? embedImage.hashCode() : 0)) * 31;
        EmbedThumbnail embedThumbnail = this.thumbnail;
        int iHashCode9 = (iHashCode8 + (embedThumbnail != null ? embedThumbnail.hashCode() : 0)) * 31;
        EmbedVideo embedVideo = this.video;
        int iHashCode10 = (iHashCode9 + (embedVideo != null ? embedVideo.hashCode() : 0)) * 31;
        EmbedProvider embedProvider = this.provider;
        int iHashCode11 = (iHashCode10 + (embedProvider != null ? embedProvider.hashCode() : 0)) * 31;
        EmbedAuthor embedAuthor = this.author;
        int iHashCode12 = (iHashCode11 + (embedAuthor != null ? embedAuthor.hashCode() : 0)) * 31;
        List<EmbedField> list = this.fields;
        return iHashCode12 + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: k, reason: from getter */
    public final EmbedType getType() {
        return this.type;
    }

    /* renamed from: l, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: m, reason: from getter */
    public final EmbedVideo getVideo() {
        return this.video;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageEmbed(title=");
        sbU.append(this.title);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", timestamp=");
        sbU.append(this.timestamp);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", footer=");
        sbU.append(this.footer);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", thumbnail=");
        sbU.append(this.thumbnail);
        sbU.append(", video=");
        sbU.append(this.video);
        sbU.append(", provider=");
        sbU.append(this.provider);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", fields=");
        return outline.L(sbU, this.fields, ")");
    }
}
