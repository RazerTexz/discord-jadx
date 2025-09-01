package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackSendMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\bE\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R#\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R!\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012R\u001b\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012R\u001b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012R\u001b\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010\u0012R\u001c\u00108\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0005R\u001b\u0010;\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010\u0012R!\u0010=\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b>\u0010)R\u001b\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012R\u001b\u0010A\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u001b\u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0010\u001a\u0004\bD\u0010\u0012R\u001b\u0010E\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010\u0012R\u001b\u0010G\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0018\u001a\u0004\bH\u0010\u001aR!\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010'\u001a\u0004\bJ\u0010)R\u001b\u0010K\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0018\u001a\u0004\bK\u0010\u001aR\u001b\u0010L\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0010\u001a\u0004\bM\u0010\u0012R\u001b\u0010N\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u0010\u001a\u0004\bO\u0010\u0012R\u001b\u0010P\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bQ\u0010\u0012R\u001b\u0010R\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\u0010\u001a\u0004\bS\u0010\u0012R\u001b\u0010T\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001b\u0010X\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010\u0010\u001a\u0004\bY\u0010\u0012R!\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010'\u001a\u0004\b[\u0010)R\u001b\u0010\\\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010\u0018\u001a\u0004\b]\u0010\u001aR\u001b\u0010^\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010\u0018\u001a\u0004\b_\u0010\u001aR!\u0010`\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010'\u001a\u0004\ba\u0010)R\u001b\u0010b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010\u0010\u001a\u0004\bc\u0010\u0012R!\u0010d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010'\u001a\u0004\be\u0010)R\u001b\u0010f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010\u0010\u001a\u0004\bg\u0010\u0012R\u001b\u0010h\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010\u0018\u001a\u0004\bh\u0010\u001aR!\u0010i\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010'\u001a\u0004\bj\u0010)R$\u0010l\u001a\u0004\u0018\u00010k8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001b\u0010r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\br\u0010\u0018\u001a\u0004\bs\u0010\u001aR\u001b\u0010t\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010\u0010\u001a\u0004\bu\u0010\u0012¨\u0006v"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSendMessage;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "clientApplicationId", "Ljava/lang/Long;", "getClientApplicationId", "()Ljava/lang/Long;", "length", "getLength", "emojiAnimated", "getEmojiAnimated", "hasSpoiler", "Ljava/lang/Boolean;", "getHasSpoiler", "()Ljava/lang/Boolean;", "isFirstMessage", "numMentions", "getNumMentions", "wordCount", "getWordCount", "messageType", "getMessageType", "referenceMessageChannel", "getReferenceMessageChannel", "", "", "attachmentContentTypes", "Ljava/util/List;", "getAttachmentContentTypes", "()Ljava/util/List;", "channelType", "getChannelType", "stickerIds", "getStickerIds", "maxAttachmentSize", "getMaxAttachmentSize", "numEmbeds", "getNumEmbeds", "emojiManagedExternal", "getEmojiManagedExternal", "referenceMessageId", "getReferenceMessageId", "emojiCustom", "getEmojiCustom", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "numUrls", "getNumUrls", "attachmentMimetypes", "getAttachmentMimetypes", "emojiCustomExternal", "getEmojiCustomExternal", "emojiUnicode", "getEmojiUnicode", "numAttachments", "getNumAttachments", "referenceMessageGuild", "getReferenceMessageGuild", "private", "getPrivate", "attachmentIds", "getAttachmentIds", "isGreeting", "webhookId", "getWebhookId", "messageId", "getMessageId", "channel", "getChannel", "activityAction", "getActivityAction", "activityPartyPlatform", "Ljava/lang/CharSequence;", "getActivityPartyPlatform", "()Ljava/lang/CharSequence;", "server", "getServer", "components", "getComponents", "emojiOnly", "getEmojiOnly", "mentionEveryone", "getMentionEveryone", "mentionIds", "getMentionIds", "emojiManaged", "getEmojiManaged", "mentionRoleIds", "getMentionRoleIds", "replyAgeSeconds", "getReplyAgeSeconds", "isFriend", "recipientIds", "getRecipientIds", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "probablyHasMarkdown", "getProbablyHasMarkdown", "applicationId", "getApplicationId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSendMessage implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Long channel = null;
    private final Long channelType = null;
    private final Boolean isFriend = null;
    private final Boolean private = null;
    private final Long server = null;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final List<Long> recipientIds = null;
    private final List<Long> mentionIds = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final Boolean mentionEveryone = null;
    private final Long emojiUnicode = null;
    private final Long emojiCustom = null;
    private final Long emojiCustomExternal = null;
    private final Long emojiManaged = null;
    private final Long emojiManagedExternal = null;
    private final Long emojiAnimated = null;
    private final Boolean emojiOnly = null;
    private final Long numEmbeds = null;
    private final List<Long> components = null;
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
    private final List<Long> stickerIds = null;
    private final Long replyAgeSeconds = null;
    private final Long webhookId = null;
    private final Boolean isGreeting = null;
    private final Boolean isFirstMessage = null;
    private final List<CharSequence> attachmentContentTypes = null;
    private final List<CharSequence> attachmentMimetypes = null;
    private final Long numUrls = null;
    private final Long numMentions = null;
    private final List<Long> mentionRoleIds = null;
    private final transient String analyticsSchemaTypeName = "send_message";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSendMessage)) {
            return false;
        }
        TrackSendMessage trackSendMessage = (TrackSendMessage) other;
        return Intrinsics3.areEqual(this.messageId, trackSendMessage.messageId) && Intrinsics3.areEqual(this.messageType, trackSendMessage.messageType) && Intrinsics3.areEqual(this.channel, trackSendMessage.channel) && Intrinsics3.areEqual(this.channelType, trackSendMessage.channelType) && Intrinsics3.areEqual(this.isFriend, trackSendMessage.isFriend) && Intrinsics3.areEqual(this.private, trackSendMessage.private) && Intrinsics3.areEqual(this.server, trackSendMessage.server) && Intrinsics3.areEqual(this.numAttachments, trackSendMessage.numAttachments) && Intrinsics3.areEqual(this.maxAttachmentSize, trackSendMessage.maxAttachmentSize) && Intrinsics3.areEqual(this.recipientIds, trackSendMessage.recipientIds) && Intrinsics3.areEqual(this.mentionIds, trackSendMessage.mentionIds) && Intrinsics3.areEqual(this.length, trackSendMessage.length) && Intrinsics3.areEqual(this.wordCount, trackSendMessage.wordCount) && Intrinsics3.areEqual(this.mentionEveryone, trackSendMessage.mentionEveryone) && Intrinsics3.areEqual(this.emojiUnicode, trackSendMessage.emojiUnicode) && Intrinsics3.areEqual(this.emojiCustom, trackSendMessage.emojiCustom) && Intrinsics3.areEqual(this.emojiCustomExternal, trackSendMessage.emojiCustomExternal) && Intrinsics3.areEqual(this.emojiManaged, trackSendMessage.emojiManaged) && Intrinsics3.areEqual(this.emojiManagedExternal, trackSendMessage.emojiManagedExternal) && Intrinsics3.areEqual(this.emojiAnimated, trackSendMessage.emojiAnimated) && Intrinsics3.areEqual(this.emojiOnly, trackSendMessage.emojiOnly) && Intrinsics3.areEqual(this.numEmbeds, trackSendMessage.numEmbeds) && Intrinsics3.areEqual(this.components, trackSendMessage.components) && Intrinsics3.areEqual(this.clientApplicationId, trackSendMessage.clientApplicationId) && Intrinsics3.areEqual(this.applicationId, trackSendMessage.applicationId) && Intrinsics3.areEqual(this.attachmentIds, trackSendMessage.attachmentIds) && Intrinsics3.areEqual(this.activityAction, trackSendMessage.activityAction) && Intrinsics3.areEqual(this.activityPartyPlatform, trackSendMessage.activityPartyPlatform) && Intrinsics3.areEqual(this.hasSpoiler, trackSendMessage.hasSpoiler) && Intrinsics3.areEqual(this.probablyHasMarkdown, trackSendMessage.probablyHasMarkdown) && Intrinsics3.areEqual(this.referenceMessageId, trackSendMessage.referenceMessageId) && Intrinsics3.areEqual(this.referenceMessageChannel, trackSendMessage.referenceMessageChannel) && Intrinsics3.areEqual(this.referenceMessageGuild, trackSendMessage.referenceMessageGuild) && Intrinsics3.areEqual(this.stickerIds, trackSendMessage.stickerIds) && Intrinsics3.areEqual(this.replyAgeSeconds, trackSendMessage.replyAgeSeconds) && Intrinsics3.areEqual(this.webhookId, trackSendMessage.webhookId) && Intrinsics3.areEqual(this.isGreeting, trackSendMessage.isGreeting) && Intrinsics3.areEqual(this.isFirstMessage, trackSendMessage.isFirstMessage) && Intrinsics3.areEqual(this.attachmentContentTypes, trackSendMessage.attachmentContentTypes) && Intrinsics3.areEqual(this.attachmentMimetypes, trackSendMessage.attachmentMimetypes) && Intrinsics3.areEqual(this.numUrls, trackSendMessage.numUrls) && Intrinsics3.areEqual(this.numMentions, trackSendMessage.numMentions) && Intrinsics3.areEqual(this.mentionRoleIds, trackSendMessage.mentionRoleIds);
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
        Boolean bool = this.isFriend;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.private;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l5 = this.server;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numAttachments;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.maxAttachmentSize;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionIds;
        int iHashCode11 = (iHashCode10 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l8 = this.length;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.wordCount;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool3 = this.mentionEveryone;
        int iHashCode14 = (iHashCode13 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l10 = this.emojiUnicode;
        int iHashCode15 = (iHashCode14 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.emojiCustom;
        int iHashCode16 = (iHashCode15 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.emojiCustomExternal;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.emojiManaged;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.emojiManagedExternal;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.emojiAnimated;
        int iHashCode20 = (iHashCode19 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Boolean bool4 = this.emojiOnly;
        int iHashCode21 = (iHashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l16 = this.numEmbeds;
        int iHashCode22 = (iHashCode21 + (l16 != null ? l16.hashCode() : 0)) * 31;
        List<Long> list3 = this.components;
        int iHashCode23 = (iHashCode22 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l17 = this.clientApplicationId;
        int iHashCode24 = (iHashCode23 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.applicationId;
        int iHashCode25 = (iHashCode24 + (l18 != null ? l18.hashCode() : 0)) * 31;
        List<Long> list4 = this.attachmentIds;
        int iHashCode26 = (iHashCode25 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l19 = this.activityAction;
        int iHashCode27 = (iHashCode26 + (l19 != null ? l19.hashCode() : 0)) * 31;
        CharSequence charSequence = this.activityPartyPlatform;
        int iHashCode28 = (iHashCode27 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool5 = this.hasSpoiler;
        int iHashCode29 = (iHashCode28 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.probablyHasMarkdown;
        int iHashCode30 = (iHashCode29 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Long l20 = this.referenceMessageId;
        int iHashCode31 = (iHashCode30 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.referenceMessageChannel;
        int iHashCode32 = (iHashCode31 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.referenceMessageGuild;
        int iHashCode33 = (iHashCode32 + (l22 != null ? l22.hashCode() : 0)) * 31;
        List<Long> list5 = this.stickerIds;
        int iHashCode34 = (iHashCode33 + (list5 != null ? list5.hashCode() : 0)) * 31;
        Long l23 = this.replyAgeSeconds;
        int iHashCode35 = (iHashCode34 + (l23 != null ? l23.hashCode() : 0)) * 31;
        Long l24 = this.webhookId;
        int iHashCode36 = (iHashCode35 + (l24 != null ? l24.hashCode() : 0)) * 31;
        Boolean bool7 = this.isGreeting;
        int iHashCode37 = (iHashCode36 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.isFirstMessage;
        int iHashCode38 = (iHashCode37 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        List<CharSequence> list6 = this.attachmentContentTypes;
        int iHashCode39 = (iHashCode38 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<CharSequence> list7 = this.attachmentMimetypes;
        int iHashCode40 = (iHashCode39 + (list7 != null ? list7.hashCode() : 0)) * 31;
        Long l25 = this.numUrls;
        int iHashCode41 = (iHashCode40 + (l25 != null ? l25.hashCode() : 0)) * 31;
        Long l26 = this.numMentions;
        int iHashCode42 = (iHashCode41 + (l26 != null ? l26.hashCode() : 0)) * 31;
        List<Long> list8 = this.mentionRoleIds;
        return iHashCode42 + (list8 != null ? list8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSendMessage(messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
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
        sbU.append(", mentionEveryone=");
        sbU.append(this.mentionEveryone);
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
        sbU.append(", components=");
        sbU.append(this.components);
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
        sbU.append(", stickerIds=");
        sbU.append(this.stickerIds);
        sbU.append(", replyAgeSeconds=");
        sbU.append(this.replyAgeSeconds);
        sbU.append(", webhookId=");
        sbU.append(this.webhookId);
        sbU.append(", isGreeting=");
        sbU.append(this.isGreeting);
        sbU.append(", isFirstMessage=");
        sbU.append(this.isFirstMessage);
        sbU.append(", attachmentContentTypes=");
        sbU.append(this.attachmentContentTypes);
        sbU.append(", attachmentMimetypes=");
        sbU.append(this.attachmentMimetypes);
        sbU.append(", numUrls=");
        sbU.append(this.numUrls);
        sbU.append(", numMentions=");
        sbU.append(this.numMentions);
        sbU.append(", mentionRoleIds=");
        return outline.L(sbU, this.mentionRoleIds, ")");
    }
}
