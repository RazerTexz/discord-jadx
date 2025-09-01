package com.discord.api.guild;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.embeddedactivities.EmbeddedActivityInGuild;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.presence.Presence;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.sticker.Sticker;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: Guild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0090\u0004\u0012\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0012\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0012\u0012\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u0012\u0012\u0007\u0010\u008a\u0001\u001a\u00020\u0002\u0012\b\u0010y\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\u0007\u0010\u0086\u0001\u001a\u00020@\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010r\u001a\u00020@\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\b\u0010^\u001a\u0004\u0018\u00010]\u0012\u0010\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u0012\u0012\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0012\u0012\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0006\u0010Y\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010n\u001a\u00020\u0005\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010@\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\b\u00103\u001a\u0004\u0018\u00010\u0002\u0012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010u\u001a\u00020\u0005\u0012\u0006\u0010}\u001a\u00020\u0005\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010R\u001a\u0004\u0018\u00010@\u0012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010@\u0012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010p\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010g\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010{\u001a\u0004\u0018\u00010@\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0012\u0012\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0012\u0012\u0007\u0010\u0088\u0001\u001a\u00020\t\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0012\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0012\u0012\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0012\u0012\b\u0010j\u001a\u0004\u0018\u00010i¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0007R!\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R!\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017R!\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017R!\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b2\u0010\u0017R\u001b\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\r\u001a\u0004\b4\u0010\u0004R\u001f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00128\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017R!\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010\u0017R\u001b\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\r\u001a\u0004\b<\u0010\u0004R!\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017R\u001b\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR!\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0015\u001a\u0004\bG\u0010\u0017R!\u0010I\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0015\u001a\u0004\bJ\u0010\u0017R\u001b\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010P\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\r\u001a\u0004\bQ\u0010\u0004R\u001b\u0010R\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010B\u001a\u0004\bS\u0010DR\u001b\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0019\u0010Y\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001b\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001b\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0019\u0010g\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010\u0010\u001a\u0004\bh\u0010\u0007R\u001b\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0019\u0010n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010\u0010\u001a\u0004\bo\u0010\u0007R\u001b\u0010p\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bp\u0010\r\u001a\u0004\bq\u0010\u0004R\u0019\u0010r\u001a\u00020@8\u0006@\u0006¢\u0006\f\n\u0004\br\u0010,\u001a\u0004\bs\u0010tR\u0019\u0010u\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bu\u0010\u0010\u001a\u0004\bv\u0010\u0007R!\u0010w\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bw\u0010\u0015\u001a\u0004\bx\u0010\u0017R\u001b\u0010y\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\by\u0010\r\u001a\u0004\bz\u0010\u0004R\u001b\u0010{\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010B\u001a\u0004\b|\u0010DR\u0019\u0010}\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b}\u0010\u0010\u001a\u0004\b~\u0010\u0007R\"\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u00128\u0006@\u0006¢\u0006\r\n\u0004\b\u007f\u0010\u0015\u001a\u0005\b\u0080\u0001\u0010\u0017R\u001d\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\r\n\u0005\b\u0081\u0001\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001e\u0010\u0082\u0001\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010B\u001a\u0005\b\u0083\u0001\u0010DR\u001e\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\r\u001a\u0005\b\u0085\u0001\u0010\u0004R\u001c\u0010\u0086\u0001\u001a\u00020@8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010,\u001a\u0005\b\u0087\u0001\u0010tR\u001c\u0010\u0088\u0001\u001a\u00020\t8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010Z\u001a\u0005\b\u0089\u0001\u0010\\R\u001c\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\r\u001a\u0005\b\u008b\u0001\u0010\u0004R%\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0015\u001a\u0005\b\u008e\u0001\u0010\u0017R\u001e\u0010\u008f\u0001\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010B\u001a\u0005\b\u0090\u0001\u0010D¨\u0006\u0093\u0001"}, d2 = {"Lcom/discord/api/guild/Guild;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_REGION, "Ljava/lang/String;", "F", "premiumTier", "I", "C", "", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "Ljava/util/List;", "R", "()Ljava/util/List;", "mfaLevel", "w", "approximatePresenceCount", "d", "Lcom/discord/api/emoji/GuildEmoji;", "emojis", "k", "memberCount", "u", "defaultMessageNotifications", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "Lcom/discord/api/guildhash/GuildHashes;", "guildHashes", "Lcom/discord/api/guildhash/GuildHashes;", "n", "()Lcom/discord/api/guildhash/GuildHashes;", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstances", "J", "Lcom/discord/api/role/GuildRole;", "roles", "G", "Lcom/discord/api/guildmember/GuildMember;", "members", "v", "banner", "e", "Lcom/discord/api/guild/GuildFeature;", "features", "m", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvents", "o", "joinedAt", "s", "Lcom/discord/api/sticker/Sticker;", "stickers", "K", "", "afkChannelId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "Lcom/discord/api/channel/Channel;", "channels", "g", "Lcom/discord/api/embeddedactivities/EmbeddedActivityInGuild;", "embeddedActivities", "j", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "Lcom/discord/api/guild/GuildVerificationLevel;", "Q", "()Lcom/discord/api/guild/GuildVerificationLevel;", "icon", "q", "rulesChannelId", "H", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "welcomeScreen", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", ExifInterface.LATITUDE_SOUTH, "()Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "unavailable", "Z", "O", "()Z", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "explicitContentFilter", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "l", "()Lcom/discord/api/guild/GuildExplicitContentFilter;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "maxVideoChannelUsers", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "t", "()Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "approximateMemberCount", "getApproximateMemberCount", "Lcom/discord/api/guild/GuildHubType;", "hubType", "Lcom/discord/api/guild/GuildHubType;", "p", "()Lcom/discord/api/guild/GuildHubType;", "afkTimeout", "c", "vanityUrlCode", "P", "ownerId", "z", "()J", "premiumSubscriptionCount", "B", "threads", "N", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "i", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "getPermissions", "systemChannelFlags", "L", "channelUpdates", "f", "splash", "publicUpdatesChannelId", ExifInterface.LONGITUDE_EAST, "preferredLocale", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ModelAuditLogEntry.CHANGE_KEY_ID, "r", ModelAuditLogEntry.CHANGE_KEY_NSFW, "y", ModelAuditLogEntry.CHANGE_KEY_NAME, "x", "Lcom/discord/api/presence/Presence;", "presences", "D", "systemChannelId", "M", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;JLjava/lang/String;Lcom/discord/api/guild/GuildVerificationLevel;Lcom/discord/api/guild/GuildExplicitContentFilter;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZIILjava/lang/Long;Ljava/lang/Long;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/discord/api/guild/welcome/GuildWelcomeScreen;Lcom/discord/api/guild/GuildMaxVideoChannelUsers;Ljava/lang/String;IILjava/lang/Long;Lcom/discord/api/guildhash/GuildHashes;Ljava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/discord/api/guild/GuildHubType;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Guild {
    private final Long afkChannelId;
    private final int afkTimeout;
    private final int approximateMemberCount;
    private final int approximatePresenceCount;
    private final String banner;
    private final List<Channel> channelUpdates;
    private final List<Channel> channels;
    private final Integer defaultMessageNotifications;
    private final String description;
    private final List<EmbeddedActivityInGuild> embeddedActivities;
    private final List<GuildEmoji> emojis;
    private final GuildExplicitContentFilter explicitContentFilter;
    private final List<GuildFeature> features;
    private final GuildHashes guildHashes;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final GuildHubType hubType;
    private final String icon;
    private final long id;
    private final String joinedAt;
    private final GuildMaxVideoChannelUsers maxVideoChannelUsers;
    private final int memberCount;
    private final List<GuildMember> members;
    private final int mfaLevel;
    private final String name;
    private final boolean nsfw;
    private final long ownerId;
    private final Long permissions;
    private final String preferredLocale;
    private final int premiumSubscriptionCount;
    private final int premiumTier;
    private final List<Presence> presences;
    private final Long publicUpdatesChannelId;
    private final String region;
    private final List<GuildRole> roles;
    private final Long rulesChannelId;
    private final String splash;
    private final List<StageInstance> stageInstances;
    private final List<Sticker> stickers;
    private final int systemChannelFlags;
    private final Long systemChannelId;
    private final List<Channel> threads;
    private final boolean unavailable;
    private final String vanityUrlCode;
    private final GuildVerificationLevel verificationLevel;
    private final List<VoiceState> voiceStates;
    private final GuildWelcomeScreen welcomeScreen;

    /* JADX WARN: Multi-variable type inference failed */
    public Guild(List<GuildRole> list, List<GuildEmoji> list2, List<Sticker> list3, String str, String str2, Integer num, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, List<Presence> list4, List<Channel> list5, List<GuildMember> list6, List<VoiceState> list7, boolean z2, int i, int i2, Long l, Long l2, List<? extends GuildFeature> list8, int i3, String str5, String str6, int i4, int i5, int i6, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i7, int i8, Long l5, GuildHashes guildHashes, List<Channel> list9, List<Channel> list10, boolean z3, List<StageInstance> list11, List<GuildScheduledEvent> list12, List<EmbeddedActivityInGuild> list13, GuildHubType guildHubType) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list8, "features");
        this.roles = list;
        this.emojis = list2;
        this.stickers = list3;
        this.name = str;
        this.description = str2;
        this.defaultMessageNotifications = num;
        this.id = j;
        this.region = str3;
        this.ownerId = j2;
        this.icon = str4;
        this.verificationLevel = guildVerificationLevel;
        this.explicitContentFilter = guildExplicitContentFilter;
        this.presences = list4;
        this.channels = list5;
        this.members = list6;
        this.voiceStates = list7;
        this.unavailable = z2;
        this.mfaLevel = i;
        this.afkTimeout = i2;
        this.afkChannelId = l;
        this.systemChannelId = l2;
        this.features = list8;
        this.memberCount = i3;
        this.banner = str5;
        this.splash = str6;
        this.premiumTier = i4;
        this.premiumSubscriptionCount = i5;
        this.systemChannelFlags = i6;
        this.joinedAt = str7;
        this.rulesChannelId = l3;
        this.publicUpdatesChannelId = l4;
        this.preferredLocale = str8;
        this.welcomeScreen = guildWelcomeScreen;
        this.maxVideoChannelUsers = guildMaxVideoChannelUsers;
        this.vanityUrlCode = str9;
        this.approximateMemberCount = i7;
        this.approximatePresenceCount = i8;
        this.permissions = l5;
        this.guildHashes = guildHashes;
        this.channelUpdates = list9;
        this.threads = list10;
        this.nsfw = z3;
        this.stageInstances = list11;
        this.guildScheduledEvents = list12;
        this.embeddedActivities = list13;
        this.hubType = guildHubType;
    }

    public static Guild a(Guild guild, List list, List list2, List list3, String str, String str2, Integer num, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, List list4, List list5, List list6, List list7, boolean z2, int i, int i2, Long l, Long l2, List list8, int i3, String str5, String str6, int i4, int i5, int i6, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i7, int i8, Long l5, GuildHashes guildHashes, List list9, List list10, boolean z3, List list11, List list12, List list13, GuildHubType guildHubType, int i9, int i10) {
        List list14 = (i9 & 1) != 0 ? guild.roles : list;
        List list15 = (i9 & 2) != 0 ? guild.emojis : list2;
        List list16 = (i9 & 4) != 0 ? guild.stickers : list3;
        String str10 = (i9 & 8) != 0 ? guild.name : str;
        String str11 = (i9 & 16) != 0 ? guild.description : str2;
        Integer num2 = (i9 & 32) != 0 ? guild.defaultMessageNotifications : num;
        long j3 = (i9 & 64) != 0 ? guild.id : j;
        String str12 = (i9 & 128) != 0 ? guild.region : str3;
        long j4 = (i9 & 256) != 0 ? guild.ownerId : j2;
        String str13 = (i9 & 512) != 0 ? guild.icon : str4;
        GuildVerificationLevel guildVerificationLevel2 = (i9 & 1024) != 0 ? guild.verificationLevel : guildVerificationLevel;
        GuildExplicitContentFilter guildExplicitContentFilter2 = (i9 & 2048) != 0 ? guild.explicitContentFilter : guildExplicitContentFilter;
        List list17 = (i9 & 4096) != 0 ? guild.presences : list4;
        List list18 = (i9 & 8192) != 0 ? guild.channels : list5;
        List list19 = (i9 & 16384) != 0 ? guild.members : list6;
        List<VoiceState> list20 = (i9 & 32768) != 0 ? guild.voiceStates : null;
        boolean z4 = (i9 & 65536) != 0 ? guild.unavailable : z2;
        int i11 = (i9 & 131072) != 0 ? guild.mfaLevel : i;
        int i12 = (i9 & 262144) != 0 ? guild.afkTimeout : i2;
        Long l6 = (i9 & 524288) != 0 ? guild.afkChannelId : l;
        Long l7 = (i9 & 1048576) != 0 ? guild.systemChannelId : l2;
        List list21 = (i9 & 2097152) != 0 ? guild.features : list8;
        String str14 = str13;
        int i13 = (i9 & 4194304) != 0 ? guild.memberCount : i3;
        String str15 = (i9 & 8388608) != 0 ? guild.banner : str5;
        String str16 = (i9 & 16777216) != 0 ? guild.splash : str6;
        int i14 = (i9 & 33554432) != 0 ? guild.premiumTier : i4;
        int i15 = (i9 & 67108864) != 0 ? guild.premiumSubscriptionCount : i5;
        int i16 = (i9 & 134217728) != 0 ? guild.systemChannelFlags : i6;
        String str17 = (i9 & 268435456) != 0 ? guild.joinedAt : null;
        Long l8 = (i9 & 536870912) != 0 ? guild.rulesChannelId : l3;
        Long l9 = (i9 & BasicMeasure.EXACTLY) != 0 ? guild.publicUpdatesChannelId : l4;
        String str18 = (i9 & Integer.MIN_VALUE) != 0 ? guild.preferredLocale : str8;
        GuildWelcomeScreen guildWelcomeScreen2 = (i10 & 1) != 0 ? guild.welcomeScreen : null;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers2 = (i10 & 2) != 0 ? guild.maxVideoChannelUsers : guildMaxVideoChannelUsers;
        String str19 = (i10 & 4) != 0 ? guild.vanityUrlCode : str9;
        int i17 = (i10 & 8) != 0 ? guild.approximateMemberCount : i7;
        int i18 = (i10 & 16) != 0 ? guild.approximatePresenceCount : i8;
        Long l10 = (i10 & 32) != 0 ? guild.permissions : null;
        GuildHashes guildHashes2 = (i10 & 64) != 0 ? guild.guildHashes : null;
        List<Channel> list22 = (i10 & 128) != 0 ? guild.channelUpdates : null;
        List<Channel> list23 = (i10 & 256) != 0 ? guild.threads : null;
        boolean z5 = (i10 & 512) != 0 ? guild.nsfw : z3;
        List<StageInstance> list24 = (i10 & 1024) != 0 ? guild.stageInstances : null;
        List<GuildScheduledEvent> list25 = (i10 & 2048) != 0 ? guild.guildScheduledEvents : null;
        List<EmbeddedActivityInGuild> list26 = (i10 & 4096) != 0 ? guild.embeddedActivities : null;
        GuildHubType guildHubType2 = (i10 & 8192) != 0 ? guild.hubType : null;
        Objects.requireNonNull(guild);
        Intrinsics3.checkNotNullParameter(str10, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list21, "features");
        return new Guild(list14, list15, list16, str10, str11, num2, j3, str12, j4, str14, guildVerificationLevel2, guildExplicitContentFilter2, list17, list18, list19, list20, z4, i11, i12, l6, l7, list21, i13, str15, str16, i14, i15, i16, str17, l8, l9, str18, guildWelcomeScreen2, guildMaxVideoChannelUsers2, str19, i17, i18, l10, guildHashes2, list22, list23, z5, list24, list25, list26, guildHubType2);
    }

    /* renamed from: A, reason: from getter */
    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    /* renamed from: B, reason: from getter */
    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    /* renamed from: C, reason: from getter */
    public final int getPremiumTier() {
        return this.premiumTier;
    }

    public final List<Presence> D() {
        return this.presences;
    }

    /* renamed from: E, reason: from getter */
    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    /* renamed from: F, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    public final List<GuildRole> G() {
        return this.roles;
    }

    /* renamed from: H, reason: from getter */
    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    /* renamed from: I, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    public final List<StageInstance> J() {
        return this.stageInstances;
    }

    public final List<Sticker> K() {
        return this.stickers;
    }

    /* renamed from: L, reason: from getter */
    public final int getSystemChannelFlags() {
        return this.systemChannelFlags;
    }

    /* renamed from: M, reason: from getter */
    public final Long getSystemChannelId() {
        return this.systemChannelId;
    }

    public final List<Channel> N() {
        return this.threads;
    }

    /* renamed from: O, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* renamed from: P, reason: from getter */
    public final String getVanityUrlCode() {
        return this.vanityUrlCode;
    }

    /* renamed from: Q, reason: from getter */
    public final GuildVerificationLevel getVerificationLevel() {
        return this.verificationLevel;
    }

    public final List<VoiceState> R() {
        return this.voiceStates;
    }

    /* renamed from: S, reason: from getter */
    public final GuildWelcomeScreen getWelcomeScreen() {
        return this.welcomeScreen;
    }

    /* renamed from: b, reason: from getter */
    public final Long getAfkChannelId() {
        return this.afkChannelId;
    }

    /* renamed from: c, reason: from getter */
    public final int getAfkTimeout() {
        return this.afkTimeout;
    }

    /* renamed from: d, reason: from getter */
    public final int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* renamed from: e, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Guild)) {
            return false;
        }
        Guild guild = (Guild) other;
        return Intrinsics3.areEqual(this.roles, guild.roles) && Intrinsics3.areEqual(this.emojis, guild.emojis) && Intrinsics3.areEqual(this.stickers, guild.stickers) && Intrinsics3.areEqual(this.name, guild.name) && Intrinsics3.areEqual(this.description, guild.description) && Intrinsics3.areEqual(this.defaultMessageNotifications, guild.defaultMessageNotifications) && this.id == guild.id && Intrinsics3.areEqual(this.region, guild.region) && this.ownerId == guild.ownerId && Intrinsics3.areEqual(this.icon, guild.icon) && Intrinsics3.areEqual(this.verificationLevel, guild.verificationLevel) && Intrinsics3.areEqual(this.explicitContentFilter, guild.explicitContentFilter) && Intrinsics3.areEqual(this.presences, guild.presences) && Intrinsics3.areEqual(this.channels, guild.channels) && Intrinsics3.areEqual(this.members, guild.members) && Intrinsics3.areEqual(this.voiceStates, guild.voiceStates) && this.unavailable == guild.unavailable && this.mfaLevel == guild.mfaLevel && this.afkTimeout == guild.afkTimeout && Intrinsics3.areEqual(this.afkChannelId, guild.afkChannelId) && Intrinsics3.areEqual(this.systemChannelId, guild.systemChannelId) && Intrinsics3.areEqual(this.features, guild.features) && this.memberCount == guild.memberCount && Intrinsics3.areEqual(this.banner, guild.banner) && Intrinsics3.areEqual(this.splash, guild.splash) && this.premiumTier == guild.premiumTier && this.premiumSubscriptionCount == guild.premiumSubscriptionCount && this.systemChannelFlags == guild.systemChannelFlags && Intrinsics3.areEqual(this.joinedAt, guild.joinedAt) && Intrinsics3.areEqual(this.rulesChannelId, guild.rulesChannelId) && Intrinsics3.areEqual(this.publicUpdatesChannelId, guild.publicUpdatesChannelId) && Intrinsics3.areEqual(this.preferredLocale, guild.preferredLocale) && Intrinsics3.areEqual(this.welcomeScreen, guild.welcomeScreen) && Intrinsics3.areEqual(this.maxVideoChannelUsers, guild.maxVideoChannelUsers) && Intrinsics3.areEqual(this.vanityUrlCode, guild.vanityUrlCode) && this.approximateMemberCount == guild.approximateMemberCount && this.approximatePresenceCount == guild.approximatePresenceCount && Intrinsics3.areEqual(this.permissions, guild.permissions) && Intrinsics3.areEqual(this.guildHashes, guild.guildHashes) && Intrinsics3.areEqual(this.channelUpdates, guild.channelUpdates) && Intrinsics3.areEqual(this.threads, guild.threads) && this.nsfw == guild.nsfw && Intrinsics3.areEqual(this.stageInstances, guild.stageInstances) && Intrinsics3.areEqual(this.guildScheduledEvents, guild.guildScheduledEvents) && Intrinsics3.areEqual(this.embeddedActivities, guild.embeddedActivities) && Intrinsics3.areEqual(this.hubType, guild.hubType);
    }

    public final List<Channel> f() {
        return this.channelUpdates;
    }

    public final List<Channel> g() {
        return this.channels;
    }

    /* renamed from: h, reason: from getter */
    public final Integer getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<GuildRole> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildEmoji> list2 = this.emojis;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Sticker> list3 = this.stickers;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.defaultMessageNotifications;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        long j = this.id;
        int i = (iHashCode6 + ((int) (j ^ (j >>> 32)))) * 31;
        String str3 = this.region;
        int iHashCode7 = (i + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j2 = this.ownerId;
        int i2 = (iHashCode7 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str4 = this.icon;
        int iHashCode8 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        GuildVerificationLevel guildVerificationLevel = this.verificationLevel;
        int iHashCode9 = (iHashCode8 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
        GuildExplicitContentFilter guildExplicitContentFilter = this.explicitContentFilter;
        int iHashCode10 = (iHashCode9 + (guildExplicitContentFilter != null ? guildExplicitContentFilter.hashCode() : 0)) * 31;
        List<Presence> list4 = this.presences;
        int iHashCode11 = (iHashCode10 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<Channel> list5 = this.channels;
        int iHashCode12 = (iHashCode11 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<GuildMember> list6 = this.members;
        int iHashCode13 = (iHashCode12 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<VoiceState> list7 = this.voiceStates;
        int iHashCode14 = (iHashCode13 + (list7 != null ? list7.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (((((iHashCode14 + i3) * 31) + this.mfaLevel) * 31) + this.afkTimeout) * 31;
        Long l = this.afkChannelId;
        int iHashCode15 = (i4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.systemChannelId;
        int iHashCode16 = (iHashCode15 + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<GuildFeature> list8 = this.features;
        int iHashCode17 = (((iHashCode16 + (list8 != null ? list8.hashCode() : 0)) * 31) + this.memberCount) * 31;
        String str5 = this.banner;
        int iHashCode18 = (iHashCode17 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.splash;
        int iHashCode19 = (((((((iHashCode18 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.premiumTier) * 31) + this.premiumSubscriptionCount) * 31) + this.systemChannelFlags) * 31;
        String str7 = this.joinedAt;
        int iHashCode20 = (iHashCode19 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Long l3 = this.rulesChannelId;
        int iHashCode21 = (iHashCode20 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.publicUpdatesChannelId;
        int iHashCode22 = (iHashCode21 + (l4 != null ? l4.hashCode() : 0)) * 31;
        String str8 = this.preferredLocale;
        int iHashCode23 = (iHashCode22 + (str8 != null ? str8.hashCode() : 0)) * 31;
        GuildWelcomeScreen guildWelcomeScreen = this.welcomeScreen;
        int iHashCode24 = (iHashCode23 + (guildWelcomeScreen != null ? guildWelcomeScreen.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.maxVideoChannelUsers;
        int iHashCode25 = (iHashCode24 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        String str9 = this.vanityUrlCode;
        int iHashCode26 = (((((iHashCode25 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.approximateMemberCount) * 31) + this.approximatePresenceCount) * 31;
        Long l5 = this.permissions;
        int iHashCode27 = (iHashCode26 + (l5 != null ? l5.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        int iHashCode28 = (iHashCode27 + (guildHashes != null ? guildHashes.hashCode() : 0)) * 31;
        List<Channel> list9 = this.channelUpdates;
        int iHashCode29 = (iHashCode28 + (list9 != null ? list9.hashCode() : 0)) * 31;
        List<Channel> list10 = this.threads;
        int iHashCode30 = (iHashCode29 + (list10 != null ? list10.hashCode() : 0)) * 31;
        boolean z3 = this.nsfw;
        int i5 = (iHashCode30 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        List<StageInstance> list11 = this.stageInstances;
        int iHashCode31 = (i5 + (list11 != null ? list11.hashCode() : 0)) * 31;
        List<GuildScheduledEvent> list12 = this.guildScheduledEvents;
        int iHashCode32 = (iHashCode31 + (list12 != null ? list12.hashCode() : 0)) * 31;
        List<EmbeddedActivityInGuild> list13 = this.embeddedActivities;
        int iHashCode33 = (iHashCode32 + (list13 != null ? list13.hashCode() : 0)) * 31;
        GuildHubType guildHubType = this.hubType;
        return iHashCode33 + (guildHubType != null ? guildHubType.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<EmbeddedActivityInGuild> j() {
        return this.embeddedActivities;
    }

    public final List<GuildEmoji> k() {
        return this.emojis;
    }

    /* renamed from: l, reason: from getter */
    public final GuildExplicitContentFilter getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public final List<GuildFeature> m() {
        return this.features;
    }

    /* renamed from: n, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    public final List<GuildScheduledEvent> o() {
        return this.guildScheduledEvents;
    }

    /* renamed from: p, reason: from getter */
    public final GuildHubType getHubType() {
        return this.hubType;
    }

    /* renamed from: q, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: r, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: s, reason: from getter */
    public final String getJoinedAt() {
        return this.joinedAt;
    }

    /* renamed from: t, reason: from getter */
    public final GuildMaxVideoChannelUsers getMaxVideoChannelUsers() {
        return this.maxVideoChannelUsers;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Guild(roles=");
        sbU.append(this.roles);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", defaultMessageNotifications=");
        sbU.append(this.defaultMessageNotifications);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", region=");
        sbU.append(this.region);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", verificationLevel=");
        sbU.append(this.verificationLevel);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", voiceStates=");
        sbU.append(this.voiceStates);
        sbU.append(", unavailable=");
        sbU.append(this.unavailable);
        sbU.append(", mfaLevel=");
        sbU.append(this.mfaLevel);
        sbU.append(", afkTimeout=");
        sbU.append(this.afkTimeout);
        sbU.append(", afkChannelId=");
        sbU.append(this.afkChannelId);
        sbU.append(", systemChannelId=");
        sbU.append(this.systemChannelId);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", premiumTier=");
        sbU.append(this.premiumTier);
        sbU.append(", premiumSubscriptionCount=");
        sbU.append(this.premiumSubscriptionCount);
        sbU.append(", systemChannelFlags=");
        sbU.append(this.systemChannelFlags);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", publicUpdatesChannelId=");
        sbU.append(this.publicUpdatesChannelId);
        sbU.append(", preferredLocale=");
        sbU.append(this.preferredLocale);
        sbU.append(", welcomeScreen=");
        sbU.append(this.welcomeScreen);
        sbU.append(", maxVideoChannelUsers=");
        sbU.append(this.maxVideoChannelUsers);
        sbU.append(", vanityUrlCode=");
        sbU.append(this.vanityUrlCode);
        sbU.append(", approximateMemberCount=");
        sbU.append(this.approximateMemberCount);
        sbU.append(", approximatePresenceCount=");
        sbU.append(this.approximatePresenceCount);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(", channelUpdates=");
        sbU.append(this.channelUpdates);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", nsfw=");
        sbU.append(this.nsfw);
        sbU.append(", stageInstances=");
        sbU.append(this.stageInstances);
        sbU.append(", guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", embeddedActivities=");
        sbU.append(this.embeddedActivities);
        sbU.append(", hubType=");
        sbU.append(this.hubType);
        sbU.append(")");
        return sbU.toString();
    }

    /* renamed from: u, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final List<GuildMember> v() {
        return this.members;
    }

    /* renamed from: w, reason: from getter */
    public final int getMfaLevel() {
        return this.mfaLevel;
    }

    /* renamed from: x, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getNsfw() {
        return this.nsfw;
    }

    /* renamed from: z, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }
}
