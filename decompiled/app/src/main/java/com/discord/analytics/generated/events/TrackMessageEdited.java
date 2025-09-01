package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackMessageEdited.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\r\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R!\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u001b\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017R\u001b\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001b\u0010/\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017R\u001b\u00101\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b2\u0010\u0017R\u001b\u00103\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0017R!\u00105\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013R\u001b\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010\u0017R\u001b\u00109\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010\u0017R\u001b\u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b<\u0010\u0017R\u001b\u0010=\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b>\u0010\u0017R\u001b\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0015\u001a\u0004\bI\u0010\u0017R\u001c\u0010J\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0005R\u001b\u0010M\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u0015\u001a\u0004\bN\u0010\u0017R\u001b\u0010O\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bP\u0010\u0017R\u001b\u0010Q\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017R\u001b\u0010S\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010@\u001a\u0004\bT\u0010BR\u001b\u0010U\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0015\u001a\u0004\bV\u0010\u0017R\u001b\u0010W\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010@\u001a\u0004\bX\u0010BR!\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010\u0011\u001a\u0004\bZ\u0010\u0013R\u001b\u0010[\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010\u0015\u001a\u0004\b\\\u0010\u0017R\u001b\u0010]\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010\u0015\u001a\u0004\b^\u0010\u0017R\u001b\u0010_\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010\u0015\u001a\u0004\b`\u0010\u0017R\u001b\u0010a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010\u0015\u001a\u0004\bb\u0010\u0017R\u001b\u0010c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010@\u001a\u0004\bd\u0010BR\u001b\u0010e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010\u0015\u001a\u0004\bf\u0010\u0017R!\u0010g\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010\u0011\u001a\u0004\bh\u0010\u0013¨\u0006i"}, d2 = {"Lcom/discord/analytics/generated/events/TrackMessageEdited;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "stickerIds", "Ljava/util/List;", "getStickerIds", "()Ljava/util/List;", "channel", "Ljava/lang/Long;", "getChannel", "()Ljava/lang/Long;", "referenceMessageGuild", "getReferenceMessageGuild", "applicationId", "getApplicationId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "maxAttachmentSize", "getMaxAttachmentSize", "clientApplicationId", "getClientApplicationId", "mentionRoleIds", "getMentionRoleIds", "channelType", "getChannelType", "wordCount", "getWordCount", "replyAgeSeconds", "getReplyAgeSeconds", "emojiManagedExternal", "getEmojiManagedExternal", "messageId", "getMessageId", "emojiCustom", "getEmojiCustom", "attachmentIds", "getAttachmentIds", "messageType", "getMessageType", "emojiAnimated", "getEmojiAnimated", "referenceMessageId", "getReferenceMessageId", "referenceMessageChannel", "getReferenceMessageChannel", "emojiOnly", "Ljava/lang/Boolean;", "getEmojiOnly", "()Ljava/lang/Boolean;", "", "activityPartyPlatform", "Ljava/lang/CharSequence;", "getActivityPartyPlatform", "()Ljava/lang/CharSequence;", "numMentions", "getNumMentions", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "numEmbeds", "getNumEmbeds", "server", "getServer", "length", "getLength", "probablyHasMarkdown", "getProbablyHasMarkdown", "emojiCustomExternal", "getEmojiCustomExternal", "private", "getPrivate", "mentionIds", "getMentionIds", "numUrls", "getNumUrls", "emojiManaged", "getEmojiManaged", "activityAction", "getActivityAction", "numAttachments", "getNumAttachments", "hasSpoiler", "getHasSpoiler", "emojiUnicode", "getEmojiUnicode", "recipientIds", "getRecipientIds", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackMessageEdited implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Long channel = null;
    private final Long channelType = null;
    private final Boolean private = null;
    private final Long server = null;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final List<Long> recipientIds = null;
    private final List<Long> mentionIds = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final Long emojiUnicode = null;
    private final Long emojiCustom = null;
    private final Long emojiCustomExternal = null;
    private final Long emojiManaged = null;
    private final Long emojiManagedExternal = null;
    private final Long emojiAnimated = null;
    private final Boolean emojiOnly = null;
    private final Long numEmbeds = null;
    private final Long clientApplicationId = null;
    private final Long applicationId = null;
    private final List<Long> attachmentIds = null;
    private final Long activityAction = null;
    private final CharSequence activityPartyPlatform = null;
    private final Boolean hasSpoiler = null;
    private final Boolean probablyHasMarkdown = null;
    private final Long referenceMessageId = null;
    private final Long referenceMessageChannel = null;
    private final Long referenceMessageGuild = null;
    private final Long replyAgeSeconds = null;
    private final List<Long> stickerIds = null;
    private final Long numUrls = null;
    private final Long numMentions = null;
    private final List<Long> mentionRoleIds = null;
    private final transient String analyticsSchemaTypeName = "message_edited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMessageEdited)) {
            return false;
        }
        TrackMessageEdited trackMessageEdited = (TrackMessageEdited) other;
        return Intrinsics3.areEqual(this.messageId, trackMessageEdited.messageId) && Intrinsics3.areEqual(this.messageType, trackMessageEdited.messageType) && Intrinsics3.areEqual(this.channel, trackMessageEdited.channel) && Intrinsics3.areEqual(this.channelType, trackMessageEdited.channelType) && Intrinsics3.areEqual(this.private, trackMessageEdited.private) && Intrinsics3.areEqual(this.server, trackMessageEdited.server) && Intrinsics3.areEqual(this.numAttachments, trackMessageEdited.numAttachments) && Intrinsics3.areEqual(this.maxAttachmentSize, trackMessageEdited.maxAttachmentSize) && Intrinsics3.areEqual(this.recipientIds, trackMessageEdited.recipientIds) && Intrinsics3.areEqual(this.mentionIds, trackMessageEdited.mentionIds) && Intrinsics3.areEqual(this.length, trackMessageEdited.length) && Intrinsics3.areEqual(this.wordCount, trackMessageEdited.wordCount) && Intrinsics3.areEqual(this.emojiUnicode, trackMessageEdited.emojiUnicode) && Intrinsics3.areEqual(this.emojiCustom, trackMessageEdited.emojiCustom) && Intrinsics3.areEqual(this.emojiCustomExternal, trackMessageEdited.emojiCustomExternal) && Intrinsics3.areEqual(this.emojiManaged, trackMessageEdited.emojiManaged) && Intrinsics3.areEqual(this.emojiManagedExternal, trackMessageEdited.emojiManagedExternal) && Intrinsics3.areEqual(this.emojiAnimated, trackMessageEdited.emojiAnimated) && Intrinsics3.areEqual(this.emojiOnly, trackMessageEdited.emojiOnly) && Intrinsics3.areEqual(this.numEmbeds, trackMessageEdited.numEmbeds) && Intrinsics3.areEqual(this.clientApplicationId, trackMessageEdited.clientApplicationId) && Intrinsics3.areEqual(this.applicationId, trackMessageEdited.applicationId) && Intrinsics3.areEqual(this.attachmentIds, trackMessageEdited.attachmentIds) && Intrinsics3.areEqual(this.activityAction, trackMessageEdited.activityAction) && Intrinsics3.areEqual(this.activityPartyPlatform, trackMessageEdited.activityPartyPlatform) && Intrinsics3.areEqual(this.hasSpoiler, trackMessageEdited.hasSpoiler) && Intrinsics3.areEqual(this.probablyHasMarkdown, trackMessageEdited.probablyHasMarkdown) && Intrinsics3.areEqual(this.referenceMessageId, trackMessageEdited.referenceMessageId) && Intrinsics3.areEqual(this.referenceMessageChannel, trackMessageEdited.referenceMessageChannel) && Intrinsics3.areEqual(this.referenceMessageGuild, trackMessageEdited.referenceMessageGuild) && Intrinsics3.areEqual(this.replyAgeSeconds, trackMessageEdited.replyAgeSeconds) && Intrinsics3.areEqual(this.stickerIds, trackMessageEdited.stickerIds) && Intrinsics3.areEqual(this.numUrls, trackMessageEdited.numUrls) && Intrinsics3.areEqual(this.numMentions, trackMessageEdited.numMentions) && Intrinsics3.areEqual(this.mentionRoleIds, trackMessageEdited.mentionRoleIds);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.messageType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channel;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.private;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l5 = this.server;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numAttachments;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.maxAttachmentSize;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionIds;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l8 = this.length;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.wordCount;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.emojiUnicode;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.emojiCustom;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.emojiCustomExternal;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.emojiManaged;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.emojiManagedExternal;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.emojiAnimated;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Boolean bool2 = this.emojiOnly;
        int iHashCode19 = (iHashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l16 = this.numEmbeds;
        int iHashCode20 = (iHashCode19 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.clientApplicationId;
        int iHashCode21 = (iHashCode20 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.applicationId;
        int iHashCode22 = (iHashCode21 + (l18 != null ? l18.hashCode() : 0)) * 31;
        List<Long> list3 = this.attachmentIds;
        int iHashCode23 = (iHashCode22 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l19 = this.activityAction;
        int iHashCode24 = (iHashCode23 + (l19 != null ? l19.hashCode() : 0)) * 31;
        CharSequence charSequence = this.activityPartyPlatform;
        int iHashCode25 = (iHashCode24 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasSpoiler;
        int iHashCode26 = (iHashCode25 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.probablyHasMarkdown;
        int iHashCode27 = (iHashCode26 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l20 = this.referenceMessageId;
        int iHashCode28 = (iHashCode27 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.referenceMessageChannel;
        int iHashCode29 = (iHashCode28 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.referenceMessageGuild;
        int iHashCode30 = (iHashCode29 + (l22 != null ? l22.hashCode() : 0)) * 31;
        Long l23 = this.replyAgeSeconds;
        int iHashCode31 = (iHashCode30 + (l23 != null ? l23.hashCode() : 0)) * 31;
        List<Long> list4 = this.stickerIds;
        int iHashCode32 = (iHashCode31 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l24 = this.numUrls;
        int iHashCode33 = (iHashCode32 + (l24 != null ? l24.hashCode() : 0)) * 31;
        Long l25 = this.numMentions;
        int iHashCode34 = (iHashCode33 + (l25 != null ? l25.hashCode() : 0)) * 31;
        List<Long> list5 = this.mentionRoleIds;
        return iHashCode34 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageEdited(messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", private=");
        sbU.append(this.private);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", numAttachments=");
        sbU.append(this.numAttachments);
        sbU.append(", maxAttachmentSize=");
        sbU.append(this.maxAttachmentSize);
        sbU.append(", recipientIds=");
        sbU.append(this.recipientIds);
        sbU.append(", mentionIds=");
        sbU.append(this.mentionIds);
        sbU.append(", length=");
        sbU.append(this.length);
        sbU.append(", wordCount=");
        sbU.append(this.wordCount);
        sbU.append(", emojiUnicode=");
        sbU.append(this.emojiUnicode);
        sbU.append(", emojiCustom=");
        sbU.append(this.emojiCustom);
        sbU.append(", emojiCustomExternal=");
        sbU.append(this.emojiCustomExternal);
        sbU.append(", emojiManaged=");
        sbU.append(this.emojiManaged);
        sbU.append(", emojiManagedExternal=");
        sbU.append(this.emojiManagedExternal);
        sbU.append(", emojiAnimated=");
        sbU.append(this.emojiAnimated);
        sbU.append(", emojiOnly=");
        sbU.append(this.emojiOnly);
        sbU.append(", numEmbeds=");
        sbU.append(this.numEmbeds);
        sbU.append(", clientApplicationId=");
        sbU.append(this.clientApplicationId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", attachmentIds=");
        sbU.append(this.attachmentIds);
        sbU.append(", activityAction=");
        sbU.append(this.activityAction);
        sbU.append(", activityPartyPlatform=");
        sbU.append(this.activityPartyPlatform);
        sbU.append(", hasSpoiler=");
        sbU.append(this.hasSpoiler);
        sbU.append(", probablyHasMarkdown=");
        sbU.append(this.probablyHasMarkdown);
        sbU.append(", referenceMessageId=");
        sbU.append(this.referenceMessageId);
        sbU.append(", referenceMessageChannel=");
        sbU.append(this.referenceMessageChannel);
        sbU.append(", referenceMessageGuild=");
        sbU.append(this.referenceMessageGuild);
        sbU.append(", replyAgeSeconds=");
        sbU.append(this.replyAgeSeconds);
        sbU.append(", stickerIds=");
        sbU.append(this.stickerIds);
        sbU.append(", numUrls=");
        sbU.append(this.numUrls);
        sbU.append(", numMentions=");
        sbU.append(this.numMentions);
        sbU.append(", mentionRoleIds=");
        return outline.L(sbU, this.mentionRoleIds, ")");
    }
}
