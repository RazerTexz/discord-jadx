package com.discord.restapi;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import b.d.b.a.outline;
import b.i.d.JsonNull;
import b.i.d.JsonSerializationContext;
import b.i.d.JsonSerializer2;
import com.discord.api.application.Application;
import com.discord.api.botuikit.Component6;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentions2;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.presence.ClientStatus;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelSubscription;
import com.discord.nullserializable.NullSerializable;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: RestAPIParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\bo\u0018\u00002\u00020\u0001:l\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnoB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006p"}, d2 = {"Lcom/discord/restapi/RestAPIParams;", "", "<init>", "()V", "ActivateMfaSMS", "AddServerBody", "ApplicationCommand", "AuthLogin", "AuthRegister", "AuthRegisterPhone", "AuthorizeIP", "BanGuildMember", "CaptchaCode", "ChannelFollowerPost", "ChannelMessagesAck", "ChannelPermissionOverwrites", "ChannelPosition", "ChannelVoiceStateUpdate", "ComponentInteraction", "ComponentInteractionData", "ConnectedAccount", "ConnectedAccountContacts", "ConnectedAccountNameOnly", "ConnectionState", "Consents", "ContactEntry", "CreateChannel", "CreateGuild", "CreateGuildChannel", "CreateGuildFromTemplate", "CreateGuildRoleSubscriptionGroupListing", "CreateGuildRoleSubscriptionTierListing", "CreateGuildScheduledEventBody", "DeleteGuild", "DeletePhone", "DisableAccount", "DisableGuildCommunication", "DowngradeSubscriptionBody", "EmptyBody", "EnableIntegration", "EnableMFA", "ForgotPassword", "GenerateGiftCode", "GetForumPostData", "GreetMessage", "GroupDM", "GuildBoosting", "GuildFeatureAck", "GuildIntegration", "GuildMFA", "GuildMember", "GuildMemberDisconnect", "HubWaitlist", "Invite", "InviteCode", "InvoicePreviewBody", "LeaveGuildBody", "MFALogin", "MemberVerificationForm", "Message", "ModalInteraction", "ModalInteractionData", "ModalInteractionDataComponent", "Nick", "OAuth2Authorize", "PatchGuildEmoji", "Phone", "PostGuildEmoji", "PruneGuild", "PurchaseMetadataBody", "RemoteAuthCancel", "RemoteAuthFinish", "RemoteAuthInitialize", "Report", "Ring", "Role", "StartStageInstanceBody", "TextChannel", "ThreadCreationSettings", "ThreadMemberSettings", "ThreadSettings", "Thumbnail", "TopicalChannel", "TransferGuildOwnership", "UpdateGuild", "UpdateGuildRoleSubscriptionGroupListing", "UpdateGuildRoleSubscriptionTierFreeTrial", "UpdateGuildRoleSubscriptionTierListing", "UpdateGuildScheduledEventBody", "UpdateStageInstanceBody", "UpdateSubscription", "UploadContacts", "UserAgreements", "UserBulkRelationship", "UserDevices", "UserEmailConfirmCode", "UserGuildSettings", "UserInfo", "UserNoteUpdate", "UserRelationship", "UserSettings", "UserSettingsCustomStatus", "VanityUrl", "VerificationCode", "VerificationCodeOnly", "VerificationCodeResend", "VerificationPhoneCode", "VerifyEmail", "VerifyEmailCode", "VerifyPurchaseResponse", "VerifyPurchaseTokenBody", "VoiceChannel", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RestAPIParams {

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ActivateMfaSMS;", "", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActivateMfaSMS {
        private final String password;

        public ActivateMfaSMS(String str) {
            Intrinsics3.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AddServerBody;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "primaryCategoryId", "copy", "(Ljava/lang/String;I)Lcom/discord/restapi/RestAPIParams$AddServerBody;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "I", "getPrimaryCategoryId", "<init>", "(Ljava/lang/String;I)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AddServerBody {
        private final String description;
        private final int primaryCategoryId;

        public AddServerBody(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            this.description = str;
            this.primaryCategoryId = i;
        }

        public static /* synthetic */ AddServerBody copy$default(AddServerBody addServerBody, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = addServerBody.description;
            }
            if ((i2 & 2) != 0) {
                i = addServerBody.primaryCategoryId;
            }
            return addServerBody.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPrimaryCategoryId() {
            return this.primaryCategoryId;
        }

        public final AddServerBody copy(String description, int primaryCategoryId) {
            Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            return new AddServerBody(description, primaryCategoryId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddServerBody)) {
                return false;
            }
            AddServerBody addServerBody = (AddServerBody) other;
            return Intrinsics3.areEqual(this.description, addServerBody.description) && this.primaryCategoryId == addServerBody.primaryCategoryId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getPrimaryCategoryId() {
            return this.primaryCategoryId;
        }

        public int hashCode() {
            String str = this.description;
            return ((str != null ? str.hashCode() : 0) * 31) + this.primaryCategoryId;
        }

        public String toString() {
            StringBuilder sbU = outline.U("AddServerBody(description=");
            sbU.append(this.description);
            sbU.append(", primaryCategoryId=");
            return outline.B(sbU, this.primaryCategoryId, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007JZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b(\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b)\u0010\u0007¨\u0006,"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ApplicationCommand;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/discord/api/commands/ApplicationCommandData;", "component5", "()Lcom/discord/api/commands/ApplicationCommandData;", "component6", "component7", "type", "channelId", "applicationId", "guildId", "data", "sessionId", "nonce", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/commands/ApplicationCommandData;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$ApplicationCommand;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildId", "J", "getType", "getSessionId", "Lcom/discord/api/commands/ApplicationCommandData;", "getData", "getApplicationId", "getNonce", "getChannelId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/commands/ApplicationCommandData;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ApplicationCommand {
        private final String applicationId;
        private final String channelId;
        private final ApplicationCommandData data;
        private final String guildId;
        private final String nonce;
        private final String sessionId;
        private final long type;

        public ApplicationCommand(long j, String str, String str2, String str3, ApplicationCommandData applicationCommandData, String str4, String str5) {
            Intrinsics3.checkNotNullParameter(str, "channelId");
            Intrinsics3.checkNotNullParameter(str2, "applicationId");
            Intrinsics3.checkNotNullParameter(applicationCommandData, "data");
            Intrinsics3.checkNotNullParameter(str5, "nonce");
            this.type = j;
            this.channelId = str;
            this.applicationId = str2;
            this.guildId = str3;
            this.data = applicationCommandData;
            this.sessionId = str4;
            this.nonce = str5;
        }

        public static /* synthetic */ ApplicationCommand copy$default(ApplicationCommand applicationCommand, long j, String str, String str2, String str3, ApplicationCommandData applicationCommandData, String str4, String str5, int i, Object obj) {
            return applicationCommand.copy((i & 1) != 0 ? applicationCommand.type : j, (i & 2) != 0 ? applicationCommand.channelId : str, (i & 4) != 0 ? applicationCommand.applicationId : str2, (i & 8) != 0 ? applicationCommand.guildId : str3, (i & 16) != 0 ? applicationCommand.data : applicationCommandData, (i & 32) != 0 ? applicationCommand.sessionId : str4, (i & 64) != 0 ? applicationCommand.nonce : str5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        /* renamed from: component5, reason: from getter */
        public final ApplicationCommandData getData() {
            return this.data;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        public final ApplicationCommand copy(long type, String channelId, String applicationId, String guildId, ApplicationCommandData data, String sessionId, String nonce) {
            Intrinsics3.checkNotNullParameter(channelId, "channelId");
            Intrinsics3.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics3.checkNotNullParameter(data, "data");
            Intrinsics3.checkNotNullParameter(nonce, "nonce");
            return new ApplicationCommand(type, channelId, applicationId, guildId, data, sessionId, nonce);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApplicationCommand)) {
                return false;
            }
            ApplicationCommand applicationCommand = (ApplicationCommand) other;
            return this.type == applicationCommand.type && Intrinsics3.areEqual(this.channelId, applicationCommand.channelId) && Intrinsics3.areEqual(this.applicationId, applicationCommand.applicationId) && Intrinsics3.areEqual(this.guildId, applicationCommand.guildId) && Intrinsics3.areEqual(this.data, applicationCommand.data) && Intrinsics3.areEqual(this.sessionId, applicationCommand.sessionId) && Intrinsics3.areEqual(this.nonce, applicationCommand.nonce);
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final ApplicationCommandData getData() {
            return this.data;
        }

        public final String getGuildId() {
            return this.guildId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.channelId;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.applicationId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.guildId;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ApplicationCommandData applicationCommandData = this.data;
            int iHashCode4 = (iHashCode3 + (applicationCommandData != null ? applicationCommandData.hashCode() : 0)) * 31;
            String str4 = this.sessionId;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.nonce;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ApplicationCommand(type=");
            sbU.append(this.type);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(", sessionId=");
            sbU.append(this.sessionId);
            sbU.append(", nonce=");
            return outline.J(sbU, this.nonce, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eBC\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AuthLogin;", "", "", "loginSource", "Ljava/lang/String;", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "login", "captchaRqtoken", "captchaKey", "", "undelete", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "LoginSource", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthLogin {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String login;
        private final String loginSource;
        private final String password;
        private final Boolean undelete;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AuthLogin$LoginSource;", "", "", "LOGIN_SOURCE_KEYCHAIN_AUTO", "Ljava/lang/String;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoginSource {
            public static final LoginSource INSTANCE = new LoginSource();
            public static final String LOGIN_SOURCE_KEYCHAIN_AUTO = "keychain_auto_login";

            private LoginSource() {
            }
        }

        public AuthLogin(String str, String str2, String str3, String str4, Boolean bool, String str5) {
            this.login = str;
            this.password = str2;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
            this.undelete = bool;
            this.loginSource = str5;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AuthRegister;", "", "", NotificationCompat.CATEGORY_EMAIL, "Ljava/lang/String;", "Lcom/discord/primitives/UtcTimestamp;", "dateOfBirth", "phoneToken", "guildTemplateCode", "", "consent", "Z", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "captchaKey", "captchaRqtoken", "username", "invite", "fingerprint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthRegister {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final boolean consent;
        private final String dateOfBirth;
        private final String email;
        private final String fingerprint;
        private final String guildTemplateCode;
        private final String invite;
        private final String password;
        private final String phoneToken;
        private final String username;

        public AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10) {
            this.fingerprint = str;
            this.username = str2;
            this.email = str3;
            this.phoneToken = str4;
            this.password = str5;
            this.captchaKey = str6;
            this.captchaRqtoken = str7;
            this.invite = str8;
            this.guildTemplateCode = str9;
            this.consent = z2;
            this.dateOfBirth = str10;
        }

        public /* synthetic */ AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, z2, (i & 1024) != 0 ? null : str10);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AuthRegisterPhone;", "", "", "phone", "Ljava/lang/String;", "captchaKey", "captchaRqtoken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthRegisterPhone {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String phone;

        public AuthRegisterPhone(String str, String str2, String str3) {
            Intrinsics3.checkNotNullParameter(str, "phone");
            this.phone = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$AuthorizeIP;", "", "", "token", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthorizeIP {
        private final String token;

        public AuthorizeIP(String str) {
            this.token = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$BanGuildMember;", "", "", "deleteMessageDays", "Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class BanGuildMember {
        private final Integer deleteMessageDays;

        public BanGuildMember() {
            this(null, 1, null);
        }

        public BanGuildMember(Integer num) {
            this.deleteMessageDays = num;
        }

        public /* synthetic */ BanGuildMember(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CaptchaCode;", "", "", "captchaRqtoken", "Ljava/lang/String;", "captchaKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CaptchaCode {
        private final String captchaKey;
        private final String captchaRqtoken;

        public CaptchaCode(String str, String str2) {
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelFollowerPost;", "", "", "Lcom/discord/primitives/ChannelId;", "webhookChannelId", "J", "getWebhookChannelId", "()J", "<init>", "(J)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelFollowerPost {
        private final long webhookChannelId;

        public ChannelFollowerPost(long j) {
            this.webhookChannelId = j;
        }

        public final long getWebhookChannelId() {
            return this.webhookChannelId;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelMessagesAck;", "", "", "mentionCount", "Ljava/lang/Integer;", "", "manual", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelMessagesAck {
        private final Boolean manual;
        private final Integer mentionCount;

        public ChannelMessagesAck(Boolean bool, Integer num) {
            this.manual = bool;
            this.mentionCount = num;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB=\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "", "", "type", "Ljava/lang/Integer;", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, "Ljava/lang/Long;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelPermissionOverwrites {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long allow;
        private final Long deny;
        private final String id;
        private final Integer type;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ7\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004H\u0007¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites$Companion;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, "Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "createForRole", "(JLjava/lang/Long;Ljava/lang/Long;)Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "createForMember", "Lcom/discord/api/permission/PermissionOverwrite;", "overwrite", "fromPermissionOverwrite", "(Lcom/discord/api/permission/PermissionOverwrite;)Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    PermissionOverwrite.Type.values();
                    int[] iArr = new int[2];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[PermissionOverwrite.Type.ROLE.ordinal()] = 1;
                    iArr[PermissionOverwrite.Type.MEMBER.ordinal()] = 2;
                }
            }

            private Companion() {
            }

            public final ChannelPermissionOverwrites createForMember(long id2, Long allow, Long deny) {
                return new ChannelPermissionOverwrites(1, String.valueOf(id2), allow, deny, null);
            }

            public final ChannelPermissionOverwrites createForRole(long id2, Long allow, Long deny) {
                return new ChannelPermissionOverwrites(0, String.valueOf(id2), allow, deny, null);
            }

            public final ChannelPermissionOverwrites fromPermissionOverwrite(PermissionOverwrite overwrite) {
                Intrinsics3.checkNotNullParameter(overwrite, "overwrite");
                int iOrdinal = overwrite.getType().ordinal();
                int i = 1;
                if (iOrdinal == 0) {
                    i = 0;
                } else if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ChannelPermissionOverwrites(Integer.valueOf(i), String.valueOf(overwrite.e()), Long.valueOf(overwrite.getAllow()), Long.valueOf(overwrite.getDeny()), null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2) {
            this.type = num;
            this.id = str;
            this.allow = l;
            this.deny = l2;
        }

        public static final ChannelPermissionOverwrites createForMember(long j, Long l, Long l2) {
            return INSTANCE.createForMember(j, l, l2);
        }

        public static final ChannelPermissionOverwrites createForRole(long j, Long l, Long l2) {
            return INSTANCE.createForRole(j, l, l2);
        }

        public /* synthetic */ ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, str, l, l2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelPosition;", "", "", "parentId", "Ljava/lang/Long;", "getParentId", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "I", "getPosition", "()I", "<init>", "(JILjava/lang/Long;)V", "Companion", "Serializer", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelPosition {
        public static final long PARENT_ID_NONE = -1;
        private final long id;
        private final Long parentId;
        private final int position;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelPosition$Serializer;", "Lb/i/d/m;", "Lcom/discord/restapi/RestAPIParams$ChannelPosition;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lb/i/d/l;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/discord/restapi/RestAPIParams$ChannelPosition;Ljava/lang/reflect/Type;Lb/i/d/l;)Lcom/google/gson/JsonElement;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Serializer implements JsonSerializer2<ChannelPosition> {
            @Override // b.i.d.JsonSerializer2
            public /* bridge */ /* synthetic */ JsonElement serialize(ChannelPosition channelPosition, Type type, JsonSerializationContext jsonSerializationContext) {
                return serialize2(channelPosition, type, jsonSerializationContext);
            }

            /* renamed from: serialize, reason: avoid collision after fix types in other method */
            public JsonElement serialize2(ChannelPosition src, Type typeOfSrc, JsonSerializationContext context) {
                if (src == null || (!Intrinsics3.areEqual(typeOfSrc, ChannelPosition.class))) {
                    return null;
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.i(ModelAuditLogEntry.CHANGE_KEY_ID, Long.valueOf(src.getId()));
                jsonObject.i(ModelAuditLogEntry.CHANGE_KEY_POSITION, Integer.valueOf(src.getPosition()));
                Long parentId = src.getParentId();
                if (parentId != null) {
                    long jLongValue = parentId.longValue();
                    if (jLongValue == -1) {
                        jsonObject.a.put("parent_id", JsonNull.a);
                    } else {
                        jsonObject.i("parent_id", Long.valueOf(jLongValue));
                    }
                }
                return jsonObject;
            }
        }

        public ChannelPosition(long j, int i, Long l) {
            this.id = j;
            this.position = i;
            this.parentId = l;
        }

        public final long getId() {
            return this.id;
        }

        public final Long getParentId() {
            return this.parentId;
        }

        public final int getPosition() {
            return this.position;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelVoiceStateUpdate;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Ljava/lang/Boolean;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component3", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "channelId", "suppress", "requestToSpeakTimestamp", "copy", "(JLjava/lang/Boolean;Lcom/discord/api/utcdatetime/UtcDateTime;)Lcom/discord/restapi/RestAPIParams$ChannelVoiceStateUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Ljava/lang/Boolean;", "getSuppress", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getRequestToSpeakTimestamp", "<init>", "(JLjava/lang/Boolean;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelVoiceStateUpdate {
        private final long channelId;
        private final UtcDateTime requestToSpeakTimestamp;
        private final Boolean suppress;

        public ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime) {
            this.channelId = j;
            this.suppress = bool;
            this.requestToSpeakTimestamp = utcDateTime;
        }

        public static /* synthetic */ ChannelVoiceStateUpdate copy$default(ChannelVoiceStateUpdate channelVoiceStateUpdate, long j, Boolean bool, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = channelVoiceStateUpdate.channelId;
            }
            if ((i & 2) != 0) {
                bool = channelVoiceStateUpdate.suppress;
            }
            if ((i & 4) != 0) {
                utcDateTime = channelVoiceStateUpdate.requestToSpeakTimestamp;
            }
            return channelVoiceStateUpdate.copy(j, bool, utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getSuppress() {
            return this.suppress;
        }

        /* renamed from: component3, reason: from getter */
        public final UtcDateTime getRequestToSpeakTimestamp() {
            return this.requestToSpeakTimestamp;
        }

        public final ChannelVoiceStateUpdate copy(long channelId, Boolean suppress, UtcDateTime requestToSpeakTimestamp) {
            return new ChannelVoiceStateUpdate(channelId, suppress, requestToSpeakTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelVoiceStateUpdate)) {
                return false;
            }
            ChannelVoiceStateUpdate channelVoiceStateUpdate = (ChannelVoiceStateUpdate) other;
            return this.channelId == channelVoiceStateUpdate.channelId && Intrinsics3.areEqual(this.suppress, channelVoiceStateUpdate.suppress) && Intrinsics3.areEqual(this.requestToSpeakTimestamp, channelVoiceStateUpdate.requestToSpeakTimestamp);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final UtcDateTime getRequestToSpeakTimestamp() {
            return this.requestToSpeakTimestamp;
        }

        public final Boolean getSuppress() {
            return this.suppress;
        }

        public int hashCode() {
            long j = this.channelId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            Boolean bool = this.suppress;
            int iHashCode = (i + (bool != null ? bool.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
            return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelVoiceStateUpdate(channelId=");
            sbU.append(this.channelId);
            sbU.append(", suppress=");
            sbU.append(this.suppress);
            sbU.append(", requestToSpeakTimestamp=");
            sbU.append(this.requestToSpeakTimestamp);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : utcDateTime);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\u0010\u0017\u001a\u00060\u0002j\u0002`\u0005\u0012\n\u0010\u0018\u001a\u00060\u0002j\u0002`\u0007\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t\u0012\n\u0010\u001a\u001a\u00060\u0002j\u0002`\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\r\u001a\u00060\u0002j\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0082\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\f\b\u0002\u0010\u0017\u001a\u00060\u0002j\u0002`\u00052\f\b\u0002\u0010\u0018\u001a\u00060\u0002j\u0002`\u00072\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t2\f\b\u0002\u0010\u001a\u001a\u00060\u0002j\u0002`\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b!\u0010\u0014J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0011R!\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b1\u0010\u000bR\u001d\u0010\u0017\u001a\u00060\u0002j\u0002`\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b3\u0010\u0014R\u001d\u0010\u0018\u001a\u00060\u0002j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b4\u0010\u0004R\u001d\u0010\u001a\u001a\u00060\u0002j\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ComponentInteraction;", "", "", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/ApplicationId;", "component3", "Lcom/discord/primitives/GuildId;", "component4", "()Ljava/lang/Long;", "Lcom/discord/primitives/MessageId;", "component5", "component6", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "component7", "()Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "", "component8", "()Ljava/lang/String;", "component9", "type", "channelId", "applicationId", "guildId", "messageId", "messageFlags", "data", "sessionId", "nonce", "copy", "(JJJLjava/lang/Long;JLjava/lang/Long;Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$ComponentInteraction;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getMessageFlags", "Ljava/lang/String;", "getSessionId", "J", "getType", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "getData", "getGuildId", "getChannelId", "getNonce", "getApplicationId", "getMessageId", "<init>", "(JJJLjava/lang/Long;JLjava/lang/Long;Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ComponentInteraction {
        private final long applicationId;
        private final long channelId;
        private final ComponentInteractionData data;
        private final Long guildId;
        private final Long messageFlags;
        private final long messageId;
        private final String nonce;
        private final String sessionId;
        private final long type;

        public ComponentInteraction(long j, long j2, long j3, Long l, long j4, Long l2, ComponentInteractionData componentInteractionData, String str, String str2) {
            Intrinsics3.checkNotNullParameter(componentInteractionData, "data");
            Intrinsics3.checkNotNullParameter(str2, "nonce");
            this.type = j;
            this.channelId = j2;
            this.applicationId = j3;
            this.guildId = l;
            this.messageId = j4;
            this.messageFlags = l2;
            this.data = componentInteractionData;
            this.sessionId = str;
            this.nonce = str2;
        }

        public static /* synthetic */ ComponentInteraction copy$default(ComponentInteraction componentInteraction, long j, long j2, long j3, Long l, long j4, Long l2, ComponentInteractionData componentInteractionData, String str, String str2, int i, Object obj) {
            return componentInteraction.copy((i & 1) != 0 ? componentInteraction.type : j, (i & 2) != 0 ? componentInteraction.channelId : j2, (i & 4) != 0 ? componentInteraction.applicationId : j3, (i & 8) != 0 ? componentInteraction.guildId : l, (i & 16) != 0 ? componentInteraction.messageId : j4, (i & 32) != 0 ? componentInteraction.messageFlags : l2, (i & 64) != 0 ? componentInteraction.data : componentInteractionData, (i & 128) != 0 ? componentInteraction.sessionId : str, (i & 256) != 0 ? componentInteraction.nonce : str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component5, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getMessageFlags() {
            return this.messageFlags;
        }

        /* renamed from: component7, reason: from getter */
        public final ComponentInteractionData getData() {
            return this.data;
        }

        /* renamed from: component8, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component9, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        public final ComponentInteraction copy(long type, long channelId, long applicationId, Long guildId, long messageId, Long messageFlags, ComponentInteractionData data, String sessionId, String nonce) {
            Intrinsics3.checkNotNullParameter(data, "data");
            Intrinsics3.checkNotNullParameter(nonce, "nonce");
            return new ComponentInteraction(type, channelId, applicationId, guildId, messageId, messageFlags, data, sessionId, nonce);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentInteraction)) {
                return false;
            }
            ComponentInteraction componentInteraction = (ComponentInteraction) other;
            return this.type == componentInteraction.type && this.channelId == componentInteraction.channelId && this.applicationId == componentInteraction.applicationId && Intrinsics3.areEqual(this.guildId, componentInteraction.guildId) && this.messageId == componentInteraction.messageId && Intrinsics3.areEqual(this.messageFlags, componentInteraction.messageFlags) && Intrinsics3.areEqual(this.data, componentInteraction.data) && Intrinsics3.areEqual(this.sessionId, componentInteraction.sessionId) && Intrinsics3.areEqual(this.nonce, componentInteraction.nonce);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final ComponentInteractionData getData() {
            return this.data;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageFlags() {
            return this.messageFlags;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            long j2 = this.channelId;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.applicationId;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            Long l = this.guildId;
            int iHashCode = l != null ? l.hashCode() : 0;
            long j4 = this.messageId;
            int i3 = (((i2 + iHashCode) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            Long l2 = this.messageFlags;
            int iHashCode2 = (i3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            ComponentInteractionData componentInteractionData = this.data;
            int iHashCode3 = (iHashCode2 + (componentInteractionData != null ? componentInteractionData.hashCode() : 0)) * 31;
            String str = this.sessionId;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.nonce;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ComponentInteraction(type=");
            sbU.append(this.type);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", messageId=");
            sbU.append(this.messageId);
            sbU.append(", messageFlags=");
            sbU.append(this.messageFlags);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(", sessionId=");
            sbU.append(this.sessionId);
            sbU.append(", nonce=");
            return outline.J(sbU, this.nonce, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "", "<init>", "()V", "ButtonComponentInteractionData", "SelectComponentInteractionData", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData;", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$SelectComponentInteractionData;", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ComponentInteractionData {

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData;", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "component2", "()Ljava/lang/String;", "componentType", "customId", "copy", "(Lcom/discord/api/botuikit/ComponentType;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCustomId", "Lcom/discord/api/botuikit/ComponentType;", "getComponentType", "<init>", "(Lcom/discord/api/botuikit/ComponentType;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ButtonComponentInteractionData extends ComponentInteractionData {
            private final Component6 componentType;
            private final String customId;

            public /* synthetic */ ButtonComponentInteractionData(Component6 component6, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Component6.BUTTON : component6, str);
            }

            public static /* synthetic */ ButtonComponentInteractionData copy$default(ButtonComponentInteractionData buttonComponentInteractionData, Component6 component6, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    component6 = buttonComponentInteractionData.componentType;
                }
                if ((i & 2) != 0) {
                    str = buttonComponentInteractionData.customId;
                }
                return buttonComponentInteractionData.copy(component6, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Component6 getComponentType() {
                return this.componentType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getCustomId() {
                return this.customId;
            }

            public final ButtonComponentInteractionData copy(Component6 componentType, String customId) {
                Intrinsics3.checkNotNullParameter(componentType, "componentType");
                Intrinsics3.checkNotNullParameter(customId, "customId");
                return new ButtonComponentInteractionData(componentType, customId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ButtonComponentInteractionData)) {
                    return false;
                }
                ButtonComponentInteractionData buttonComponentInteractionData = (ButtonComponentInteractionData) other;
                return Intrinsics3.areEqual(this.componentType, buttonComponentInteractionData.componentType) && Intrinsics3.areEqual(this.customId, buttonComponentInteractionData.customId);
            }

            public final Component6 getComponentType() {
                return this.componentType;
            }

            public final String getCustomId() {
                return this.customId;
            }

            public int hashCode() {
                Component6 component6 = this.componentType;
                int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
                String str = this.customId;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ButtonComponentInteractionData(componentType=");
                sbU.append(this.componentType);
                sbU.append(", customId=");
                return outline.J(sbU, this.customId, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ButtonComponentInteractionData(Component6 component6, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(component6, "componentType");
                Intrinsics3.checkNotNullParameter(str, "customId");
                this.componentType = component6;
                this.customId = str;
            }
        }

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$SelectComponentInteractionData;", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "componentType", "customId", "values", "copy", "(Lcom/discord/api/botuikit/ComponentType;Ljava/lang/String;Ljava/util/List;)Lcom/discord/restapi/RestAPIParams$ComponentInteractionData$SelectComponentInteractionData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCustomId", "Ljava/util/List;", "getValues", "Lcom/discord/api/botuikit/ComponentType;", "getComponentType", "<init>", "(Lcom/discord/api/botuikit/ComponentType;Ljava/lang/String;Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SelectComponentInteractionData extends ComponentInteractionData {
            private final Component6 componentType;
            private final String customId;
            private final List<String> values;

            public /* synthetic */ SelectComponentInteractionData(Component6 component6, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Component6.SELECT : component6, str, list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectComponentInteractionData copy$default(SelectComponentInteractionData selectComponentInteractionData, Component6 component6, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    component6 = selectComponentInteractionData.componentType;
                }
                if ((i & 2) != 0) {
                    str = selectComponentInteractionData.customId;
                }
                if ((i & 4) != 0) {
                    list = selectComponentInteractionData.values;
                }
                return selectComponentInteractionData.copy(component6, str, list);
            }

            /* renamed from: component1, reason: from getter */
            public final Component6 getComponentType() {
                return this.componentType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getCustomId() {
                return this.customId;
            }

            public final List<String> component3() {
                return this.values;
            }

            public final SelectComponentInteractionData copy(Component6 componentType, String customId, List<String> values) {
                Intrinsics3.checkNotNullParameter(componentType, "componentType");
                Intrinsics3.checkNotNullParameter(customId, "customId");
                Intrinsics3.checkNotNullParameter(values, "values");
                return new SelectComponentInteractionData(componentType, customId, values);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectComponentInteractionData)) {
                    return false;
                }
                SelectComponentInteractionData selectComponentInteractionData = (SelectComponentInteractionData) other;
                return Intrinsics3.areEqual(this.componentType, selectComponentInteractionData.componentType) && Intrinsics3.areEqual(this.customId, selectComponentInteractionData.customId) && Intrinsics3.areEqual(this.values, selectComponentInteractionData.values);
            }

            public final Component6 getComponentType() {
                return this.componentType;
            }

            public final String getCustomId() {
                return this.customId;
            }

            public final List<String> getValues() {
                return this.values;
            }

            public int hashCode() {
                Component6 component6 = this.componentType;
                int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
                String str = this.customId;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                List<String> list = this.values;
                return iHashCode2 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SelectComponentInteractionData(componentType=");
                sbU.append(this.componentType);
                sbU.append(", customId=");
                sbU.append(this.customId);
                sbU.append(", values=");
                return outline.L(sbU, this.values, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectComponentInteractionData(Component6 component6, String str, List<String> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(component6, "componentType");
                Intrinsics3.checkNotNullParameter(str, "customId");
                Intrinsics3.checkNotNullParameter(list, "values");
                this.componentType = component6;
                this.customId = str;
                this.values = list;
            }
        }

        private ComponentInteractionData() {
        }

        public /* synthetic */ ComponentInteractionData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012BI\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ConnectedAccount;", "", "", "visibility", "I", "", "verified", "Z", "revoked", "show_activity", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "type", "friend_sync", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZI)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConnectedAccount {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean friend_sync;
        private final String id;
        private final String name;
        private final boolean revoked;
        private final boolean show_activity;
        private final String type;
        private final boolean verified;
        private final int visibility;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ConnectedAccount$Companion;", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "connectedAccount", "", "syncFriends", "showActivity", "", "visibility", "Lcom/discord/restapi/RestAPIParams$ConnectedAccount;", "create", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;ZZI)Lcom/discord/restapi/RestAPIParams$ConnectedAccount;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ConnectedAccount create(com.discord.api.connectedaccounts.ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, int visibility) {
                Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
                return new ConnectedAccount(syncFriends, connectedAccount.getId(), connectedAccount.getName(), connectedAccount.getRevoked(), showActivity, connectedAccount.getType(), connectedAccount.getVerified(), visibility);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ConnectedAccount(boolean z2, String str, String str2, boolean z3, boolean z4, String str3, boolean z5, int i) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(str3, "type");
            this.friend_sync = z2;
            this.id = str;
            this.name = str2;
            this.revoked = z3;
            this.show_activity = z4;
            this.type = str3;
            this.verified = z5;
            this.visibility = i;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ConnectedAccountContacts;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "friend_sync", "copy", "(Ljava/lang/String;Z)Lcom/discord/restapi/RestAPIParams$ConnectedAccountContacts;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Z)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ConnectedAccountContacts {
        private final boolean friend_sync;
        private final String name;

        public ConnectedAccountContacts(String str, boolean z2) {
            this.name = str;
            this.friend_sync = z2;
        }

        /* renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        private final boolean getFriend_sync() {
            return this.friend_sync;
        }

        public static /* synthetic */ ConnectedAccountContacts copy$default(ConnectedAccountContacts connectedAccountContacts, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = connectedAccountContacts.name;
            }
            if ((i & 2) != 0) {
                z2 = connectedAccountContacts.friend_sync;
            }
            return connectedAccountContacts.copy(str, z2);
        }

        public final ConnectedAccountContacts copy(String name, boolean friend_sync) {
            return new ConnectedAccountContacts(name, friend_sync);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectedAccountContacts)) {
                return false;
            }
            ConnectedAccountContacts connectedAccountContacts = (ConnectedAccountContacts) other;
            return Intrinsics3.areEqual(this.name, connectedAccountContacts.name) && this.friend_sync == connectedAccountContacts.friend_sync;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.friend_sync;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectedAccountContacts(name=");
            sbU.append(this.name);
            sbU.append(", friend_sync=");
            return outline.O(sbU, this.friend_sync, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ConnectedAccountNameOnly;", "", "", "component1", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$ConnectedAccountNameOnly;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ConnectedAccountNameOnly {
        private final String name;

        public ConnectedAccountNameOnly() {
            this(null, 1, null);
        }

        public ConnectedAccountNameOnly(String str) {
            this.name = str;
        }

        /* renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        public static /* synthetic */ ConnectedAccountNameOnly copy$default(ConnectedAccountNameOnly connectedAccountNameOnly, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = connectedAccountNameOnly.name;
            }
            return connectedAccountNameOnly.copy(str);
        }

        public final ConnectedAccountNameOnly copy(String name) {
            return new ConnectedAccountNameOnly(name);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConnectedAccountNameOnly) && Intrinsics3.areEqual(this.name, ((ConnectedAccountNameOnly) other).name);
            }
            return true;
        }

        public int hashCode() {
            String str = this.name;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("ConnectedAccountNameOnly(name="), this.name, ")");
        }

        public /* synthetic */ ConnectedAccountNameOnly(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ConnectionState;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "state", "", "fromContinuation", "Ljava/lang/Boolean;", "insecure", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConnectionState {
        private final String code;
        private final Boolean fromContinuation;
        private final Boolean insecure;
        private final String state;

        public ConnectionState(String str, String str2, Boolean bool, Boolean bool2) {
            this.code = str;
            this.state = str2;
            this.fromContinuation = bool;
            this.insecure = bool2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Consents;", "", "", "", "grant", "Ljava/util/List;", "revoke", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Type", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Consents {
        private final List<String> grant;
        private final List<String> revoke;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Consents$Type;", "", "", "PERSONALIZATION", "Ljava/lang/String;", "USAGE_STATS", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Type {
            public static final Type INSTANCE = new Type();
            public static final String PERSONALIZATION = "personalization";
            public static final String USAGE_STATS = "usage_statistics";

            private Type() {
            }
        }

        public Consents() {
            this(null, null, 3, null);
        }

        public Consents(List<String> list, List<String> list2) {
            Intrinsics3.checkNotNullParameter(list, "grant");
            Intrinsics3.checkNotNullParameter(list2, "revoke");
            this.grant = list;
            this.revoke = list2;
        }

        public /* synthetic */ Consents(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ContactEntry;", "", "", "mutual_id_hash", "Ljava/lang/String;", "", "metadata", "Ljava/util/Map;", "friend_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ContactEntry {
        private final String friend_id;
        private final Map<String, String> metadata;
        private final String mutual_id_hash;

        public ContactEntry(String str, String str2, Map<String, String> map) {
            Intrinsics3.checkNotNullParameter(str, "mutual_id_hash");
            Intrinsics3.checkNotNullParameter(str2, "friend_id");
            Intrinsics3.checkNotNullParameter(map, "metadata");
            this.mutual_id_hash = str;
            this.friend_id = str2;
            this.metadata = map;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuild;", "", "", "Lcom/discord/restapi/RestAPIParams$CreateGuildChannel;", "channels", "Ljava/util/List;", "", "Lcom/discord/primitives/ChannelId;", "systemChannelId", "Ljava/lang/Long;", "", "icon", "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateGuild {
        private final List<CreateGuildChannel> channels;
        private final String icon;
        private final String name;
        private final Long systemChannelId;

        public CreateGuild(String str, String str2, List<CreateGuildChannel> list, Long l) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.icon = str2;
            this.channels = list;
            this.systemChannelId = l;
        }

        public /* synthetic */ CreateGuild(String str, String str2, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0005R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuildChannel;", "", "", "Lcom/discord/primitives/Snowflake;", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/Long;", "", "Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "permissionOverwrites", "Ljava/util/List;", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Ljava/lang/String;", "", "type", "I", "parentId", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateGuildChannel {
        private final Long id;
        private final String name;
        private final Long parentId;
        private final List<ChannelPermissionOverwrites> permissionOverwrites;
        private final String topic;
        private final int type;

        public CreateGuildChannel(int i, Long l, String str, Long l2, List<ChannelPermissionOverwrites> list, String str2) {
            this.type = i;
            this.id = l;
            this.name = str;
            this.parentId = l2;
            this.permissionOverwrites = list;
            this.topic = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuildFromTemplate;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateGuildFromTemplate {
        private final String icon;
        private final String name;

        public CreateGuildFromTemplate(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.icon = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuildRoleSubscriptionGroupListing;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "image", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "fullServerGate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$CreateGuildRoleSubscriptionGroupListing;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getFullServerGate", "Ljava/lang/String;", "getDescription", "getImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CreateGuildRoleSubscriptionGroupListing {
        private final String description;
        private final Boolean fullServerGate;
        private final String image;

        public CreateGuildRoleSubscriptionGroupListing(String str, String str2, Boolean bool) {
            this.image = str;
            this.description = str2;
            this.fullServerGate = bool;
        }

        public static /* synthetic */ CreateGuildRoleSubscriptionGroupListing copy$default(CreateGuildRoleSubscriptionGroupListing createGuildRoleSubscriptionGroupListing, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createGuildRoleSubscriptionGroupListing.image;
            }
            if ((i & 2) != 0) {
                str2 = createGuildRoleSubscriptionGroupListing.description;
            }
            if ((i & 4) != 0) {
                bool = createGuildRoleSubscriptionGroupListing.fullServerGate;
            }
            return createGuildRoleSubscriptionGroupListing.copy(str, str2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final CreateGuildRoleSubscriptionGroupListing copy(String image, String description, Boolean fullServerGate) {
            return new CreateGuildRoleSubscriptionGroupListing(image, description, fullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildRoleSubscriptionGroupListing)) {
                return false;
            }
            CreateGuildRoleSubscriptionGroupListing createGuildRoleSubscriptionGroupListing = (CreateGuildRoleSubscriptionGroupListing) other;
            return Intrinsics3.areEqual(this.image, createGuildRoleSubscriptionGroupListing.image) && Intrinsics3.areEqual(this.description, createGuildRoleSubscriptionGroupListing.description) && Intrinsics3.areEqual(this.fullServerGate, createGuildRoleSubscriptionGroupListing.fullServerGate);
        }

        public final String getDescription() {
            return this.description;
        }

        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final String getImage() {
            return this.image;
        }

        public int hashCode() {
            String str = this.image;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.fullServerGate;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CreateGuildRoleSubscriptionGroupListing(image=");
            sbU.append(this.image);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", fullServerGate=");
            return outline.D(sbU, this.fullServerGate, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\rJ\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\r¨\u0006*"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuildRoleSubscriptionTierListing;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "component4", "()Ljava/util/List;", "", "component5", "()I", "", "component6", "()Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "image", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "benefits", "priceTier", "canAccessAllChannels", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IZ)Lcom/discord/restapi/RestAPIParams$CreateGuildRoleSubscriptionTierListing;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImage", "getDescription", "Ljava/util/List;", "getBenefits", "getName", "Z", "getCanAccessAllChannels", "I", "getPriceTier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IZ)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CreateGuildRoleSubscriptionTierListing {
        private final List<GuildRoleSubscriptionBenefit> benefits;
        private final boolean canAccessAllChannels;
        private final String description;
        private final String image;
        private final String name;
        private final int priceTier;

        public CreateGuildRoleSubscriptionTierListing(String str, String str2, String str3, List<GuildRoleSubscriptionBenefit> list, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(list, "benefits");
            this.name = str;
            this.image = str2;
            this.description = str3;
            this.benefits = list;
            this.priceTier = i;
            this.canAccessAllChannels = z2;
        }

        public static /* synthetic */ CreateGuildRoleSubscriptionTierListing copy$default(CreateGuildRoleSubscriptionTierListing createGuildRoleSubscriptionTierListing, String str, String str2, String str3, List list, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = createGuildRoleSubscriptionTierListing.name;
            }
            if ((i2 & 2) != 0) {
                str2 = createGuildRoleSubscriptionTierListing.image;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                str3 = createGuildRoleSubscriptionTierListing.description;
            }
            String str5 = str3;
            if ((i2 & 8) != 0) {
                list = createGuildRoleSubscriptionTierListing.benefits;
            }
            List list2 = list;
            if ((i2 & 16) != 0) {
                i = createGuildRoleSubscriptionTierListing.priceTier;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z2 = createGuildRoleSubscriptionTierListing.canAccessAllChannels;
            }
            return createGuildRoleSubscriptionTierListing.copy(str, str4, str5, list2, i3, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final List<GuildRoleSubscriptionBenefit> component4() {
            return this.benefits;
        }

        /* renamed from: component5, reason: from getter */
        public final int getPriceTier() {
            return this.priceTier;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final CreateGuildRoleSubscriptionTierListing copy(String name, String image, String description, List<GuildRoleSubscriptionBenefit> benefits, int priceTier, boolean canAccessAllChannels) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(benefits, "benefits");
            return new CreateGuildRoleSubscriptionTierListing(name, image, description, benefits, priceTier, canAccessAllChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildRoleSubscriptionTierListing)) {
                return false;
            }
            CreateGuildRoleSubscriptionTierListing createGuildRoleSubscriptionTierListing = (CreateGuildRoleSubscriptionTierListing) other;
            return Intrinsics3.areEqual(this.name, createGuildRoleSubscriptionTierListing.name) && Intrinsics3.areEqual(this.image, createGuildRoleSubscriptionTierListing.image) && Intrinsics3.areEqual(this.description, createGuildRoleSubscriptionTierListing.description) && Intrinsics3.areEqual(this.benefits, createGuildRoleSubscriptionTierListing.benefits) && this.priceTier == createGuildRoleSubscriptionTierListing.priceTier && this.canAccessAllChannels == createGuildRoleSubscriptionTierListing.canAccessAllChannels;
        }

        public final List<GuildRoleSubscriptionBenefit> getBenefits() {
            return this.benefits;
        }

        public final boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getName() {
            return this.name;
        }

        public final int getPriceTier() {
            return this.priceTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<GuildRoleSubscriptionBenefit> list = this.benefits;
            int iHashCode4 = (((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.priceTier) * 31;
            boolean z2 = this.canAccessAllChannels;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode4 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CreateGuildRoleSubscriptionTierListing(name=");
            sbU.append(this.name);
            sbU.append(", image=");
            sbU.append(this.image);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", benefits=");
            sbU.append(this.benefits);
            sbU.append(", priceTier=");
            sbU.append(this.priceTier);
            sbU.append(", canAccessAllChannels=");
            return outline.O(sbU, this.canAccessAllChannels, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001d\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jz\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\bR\u0019\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0011R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b2\u0010\u0004R!\u0010\u001d\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u000eR\u001b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b6\u0010\u0017R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b7\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b8\u0010\u0004¨\u0006;"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateGuildScheduledEventBody;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component3", "()Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component4", "component5", "", "Lcom/discord/primitives/ChannelId;", "component6", "()Ljava/lang/Long;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "component7", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "component8", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "", "component9", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "privacyLevel", "scheduledStartTime", "scheduledEndTime", "channelId", "entityType", "entityMetadata", "broadcastToDirectoryChannels", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$CreateGuildScheduledEventBody;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "getEntityMetadata", "Ljava/lang/String;", "getScheduledStartTime", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "getPrivacyLevel", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "getEntityType", "getDescription", "Ljava/lang/Long;", "getChannelId", "Ljava/lang/Boolean;", "getBroadcastToDirectoryChannels", "getScheduledEndTime", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CreateGuildScheduledEventBody {
        private final Boolean broadcastToDirectoryChannels;
        private final Long channelId;
        private final String description;
        private final GuildScheduledEventEntityMetadata entityMetadata;
        private final GuildScheduledEventEntityType entityType;
        private final String name;
        private final StageInstancePrivacyLevel privacyLevel;
        private final String scheduledEndTime;
        private final String scheduledStartTime;

        public CreateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Boolean bool) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
            Intrinsics3.checkNotNullParameter(str3, "scheduledStartTime");
            Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
            this.name = str;
            this.description = str2;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.scheduledStartTime = str3;
            this.scheduledEndTime = str4;
            this.channelId = l;
            this.entityType = guildScheduledEventEntityType;
            this.entityMetadata = guildScheduledEventEntityMetadata;
            this.broadcastToDirectoryChannels = bool;
        }

        public static /* synthetic */ CreateGuildScheduledEventBody copy$default(CreateGuildScheduledEventBody createGuildScheduledEventBody, String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Boolean bool, int i, Object obj) {
            return createGuildScheduledEventBody.copy((i & 1) != 0 ? createGuildScheduledEventBody.name : str, (i & 2) != 0 ? createGuildScheduledEventBody.description : str2, (i & 4) != 0 ? createGuildScheduledEventBody.privacyLevel : stageInstancePrivacyLevel, (i & 8) != 0 ? createGuildScheduledEventBody.scheduledStartTime : str3, (i & 16) != 0 ? createGuildScheduledEventBody.scheduledEndTime : str4, (i & 32) != 0 ? createGuildScheduledEventBody.channelId : l, (i & 64) != 0 ? createGuildScheduledEventBody.entityType : guildScheduledEventEntityType, (i & 128) != 0 ? createGuildScheduledEventBody.entityMetadata : guildScheduledEventEntityMetadata, (i & 256) != 0 ? createGuildScheduledEventBody.broadcastToDirectoryChannels : bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* renamed from: component4, reason: from getter */
        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        /* renamed from: component5, reason: from getter */
        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component7, reason: from getter */
        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        /* renamed from: component8, reason: from getter */
        public final GuildScheduledEventEntityMetadata getEntityMetadata() {
            return this.entityMetadata;
        }

        /* renamed from: component9, reason: from getter */
        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final CreateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, Long channelId, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Boolean broadcastToDirectoryChannels) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(privacyLevel, "privacyLevel");
            Intrinsics3.checkNotNullParameter(scheduledStartTime, "scheduledStartTime");
            Intrinsics3.checkNotNullParameter(entityType, "entityType");
            return new CreateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, broadcastToDirectoryChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildScheduledEventBody)) {
                return false;
            }
            CreateGuildScheduledEventBody createGuildScheduledEventBody = (CreateGuildScheduledEventBody) other;
            return Intrinsics3.areEqual(this.name, createGuildScheduledEventBody.name) && Intrinsics3.areEqual(this.description, createGuildScheduledEventBody.description) && Intrinsics3.areEqual(this.privacyLevel, createGuildScheduledEventBody.privacyLevel) && Intrinsics3.areEqual(this.scheduledStartTime, createGuildScheduledEventBody.scheduledStartTime) && Intrinsics3.areEqual(this.scheduledEndTime, createGuildScheduledEventBody.scheduledEndTime) && Intrinsics3.areEqual(this.channelId, createGuildScheduledEventBody.channelId) && Intrinsics3.areEqual(this.entityType, createGuildScheduledEventBody.entityType) && Intrinsics3.areEqual(this.entityMetadata, createGuildScheduledEventBody.entityMetadata) && Intrinsics3.areEqual(this.broadcastToDirectoryChannels, createGuildScheduledEventBody.broadcastToDirectoryChannels);
        }

        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final GuildScheduledEventEntityMetadata getEntityMetadata() {
            return this.entityMetadata;
        }

        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final String getName() {
            return this.name;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode3 = (iHashCode2 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            String str3 = this.scheduledStartTime;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.scheduledEndTime;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Long l = this.channelId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
            int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
            GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
            int iHashCode8 = (iHashCode7 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
            Boolean bool = this.broadcastToDirectoryChannels;
            return iHashCode8 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CreateGuildScheduledEventBody(name=");
            sbU.append(this.name);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", privacyLevel=");
            sbU.append(this.privacyLevel);
            sbU.append(", scheduledStartTime=");
            sbU.append(this.scheduledStartTime);
            sbU.append(", scheduledEndTime=");
            sbU.append(this.scheduledEndTime);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", entityType=");
            sbU.append(this.entityType);
            sbU.append(", entityMetadata=");
            sbU.append(this.entityMetadata);
            sbU.append(", broadcastToDirectoryChannels=");
            return outline.D(sbU, this.broadcastToDirectoryChannels, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$DeleteGuild;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeleteGuild {
        private final String code;

        public DeleteGuild(String str) {
            this.code = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$DeletePhone;", "", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeletePhone {
        private final String password;

        public DeletePhone(String str) {
            Intrinsics3.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$DisableAccount;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class DisableAccount {
        private final String code;
        private final String password;

        public DisableAccount(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
            this.code = str2;
        }

        public /* synthetic */ DisableAccount(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$DisableGuildCommunication;", "", "", "communicationDisabledUntil", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class DisableGuildCommunication {
        private final String communicationDisabledUntil;

        public DisableGuildCommunication() {
            this(null, 1, null);
        }

        public DisableGuildCommunication(String str) {
            this.communicationDisabledUntil = str;
        }

        public /* synthetic */ DisableGuildCommunication(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$DowngradeSubscriptionBody;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "subscriptionId", "purchaseToken", "subscriptionSkuId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$DowngradeSubscriptionBody;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPurchaseToken", "getSubscriptionSkuId", "getSubscriptionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DowngradeSubscriptionBody {
        private final String purchaseToken;
        private final String subscriptionId;
        private final String subscriptionSkuId;

        public DowngradeSubscriptionBody(String str, String str2, String str3) {
            outline.q0(str, "subscriptionId", str2, "purchaseToken", str3, "subscriptionSkuId");
            this.subscriptionId = str;
            this.purchaseToken = str2;
            this.subscriptionSkuId = str3;
        }

        public static /* synthetic */ DowngradeSubscriptionBody copy$default(DowngradeSubscriptionBody downgradeSubscriptionBody, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downgradeSubscriptionBody.subscriptionId;
            }
            if ((i & 2) != 0) {
                str2 = downgradeSubscriptionBody.purchaseToken;
            }
            if ((i & 4) != 0) {
                str3 = downgradeSubscriptionBody.subscriptionSkuId;
            }
            return downgradeSubscriptionBody.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public final DowngradeSubscriptionBody copy(String subscriptionId, String purchaseToken, String subscriptionSkuId) {
            Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
            Intrinsics3.checkNotNullParameter(subscriptionSkuId, "subscriptionSkuId");
            return new DowngradeSubscriptionBody(subscriptionId, purchaseToken, subscriptionSkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DowngradeSubscriptionBody)) {
                return false;
            }
            DowngradeSubscriptionBody downgradeSubscriptionBody = (DowngradeSubscriptionBody) other;
            return Intrinsics3.areEqual(this.subscriptionId, downgradeSubscriptionBody.subscriptionId) && Intrinsics3.areEqual(this.purchaseToken, downgradeSubscriptionBody.purchaseToken) && Intrinsics3.areEqual(this.subscriptionSkuId, downgradeSubscriptionBody.subscriptionSkuId);
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public int hashCode() {
            String str = this.subscriptionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.purchaseToken;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subscriptionSkuId;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DowngradeSubscriptionBody(subscriptionId=");
            sbU.append(this.subscriptionId);
            sbU.append(", purchaseToken=");
            sbU.append(this.purchaseToken);
            sbU.append(", subscriptionSkuId=");
            return outline.J(sbU, this.subscriptionSkuId, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/restapi/RestAPIParams$EmptyBody;", "", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class EmptyBody {
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$EnableIntegration;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/String;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class EnableIntegration {
        private final String id;
        private final String type;

        public EnableIntegration(String str, String str2) {
            this.type = str;
            this.id = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$EnableMFA;", "", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_CODE, "secret", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class EnableMFA {
        private final String code;
        private final String password;
        private final String secret;

        public EnableMFA(String str, String str2, String str3) {
            outline.q0(str, ModelAuditLogEntry.CHANGE_KEY_CODE, str2, "secret", str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.code = str;
            this.secret = str2;
            this.password = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ForgotPassword;", "", "", "captchaRqtoken", "Ljava/lang/String;", "login", "captchaKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForgotPassword {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String login;

        public ForgotPassword(String str, String str2, String str3) {
            this.login = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\b\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GenerateGiftCode;", "", "", "Lcom/discord/primitives/PlanId;", "subscriptionPlanId", "Ljava/lang/Long;", "getSubscriptionPlanId", "()Ljava/lang/Long;", "Lcom/discord/primitives/SkuId;", "skuId", "J", "getSkuId", "()J", "<init>", "(JLjava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GenerateGiftCode {
        private final long skuId;
        private final Long subscriptionPlanId;

        public GenerateGiftCode(long j, Long l) {
            this.skuId = j;
            this.subscriptionPlanId = l;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GetForumPostData;", "", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()Ljava/util/List;", "threadIds", "copy", "(Ljava/util/List;)Lcom/discord/restapi/RestAPIParams$GetForumPostData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getThreadIds", "<init>", "(Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GetForumPostData {
        private final List<Long> threadIds;

        public GetForumPostData(List<Long> list) {
            Intrinsics3.checkNotNullParameter(list, "threadIds");
            this.threadIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetForumPostData copy$default(GetForumPostData getForumPostData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = getForumPostData.threadIds;
            }
            return getForumPostData.copy(list);
        }

        public final List<Long> component1() {
            return this.threadIds;
        }

        public final GetForumPostData copy(List<Long> threadIds) {
            Intrinsics3.checkNotNullParameter(threadIds, "threadIds");
            return new GetForumPostData(threadIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GetForumPostData) && Intrinsics3.areEqual(this.threadIds, ((GetForumPostData) other).threadIds);
            }
            return true;
        }

        public final List<Long> getThreadIds() {
            return this.threadIds;
        }

        public int hashCode() {
            List<Long> list = this.threadIds;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("GetForumPostData(threadIds="), this.threadIds, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GreetMessage;", "", "", "", "sticker_ids", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GreetMessage {
        private final List<Long> sticker_ids;

        public GreetMessage(List<Long> list) {
            Intrinsics3.checkNotNullParameter(list, "sticker_ids");
            this.sticker_ids = list;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GroupDM;", "", "", "icon", "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GroupDM {
        private final String icon;
        private final String name;

        public GroupDM(String str, String str2) {
            this.name = str;
            this.icon = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\t\u0010\nR#\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildBoosting;", "", "", "", "Lcom/discord/primitives/GuildBoostSlotId;", "userPremiumGuildSubscriptionSlotIds", "Ljava/util/List;", "getUserPremiumGuildSubscriptionSlotIds", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildBoosting {
        private final List<Long> userPremiumGuildSubscriptionSlotIds;

        public GuildBoosting(List<Long> list) {
            Intrinsics3.checkNotNullParameter(list, "userPremiumGuildSubscriptionSlotIds");
            this.userPremiumGuildSubscriptionSlotIds = list;
        }

        public final List<Long> getUserPremiumGuildSubscriptionSlotIds() {
            return this.userPremiumGuildSubscriptionSlotIds;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildFeatureAck;", "", "", "manual", "Ljava/lang/Boolean;", "", "mentionCount", "Ljava/lang/Integer;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildFeatureAck {
        private final Boolean manual;
        private final Integer mentionCount;

        public GuildFeatureAck(Boolean bool, Integer num) {
            this.manual = bool;
            this.mentionCount = num;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildIntegration;", "", "", "expireGracePeriod", "I", "", "enableEmoticons", "Z", "expireBehavior", "<init>", "(IIZ)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildIntegration {
        private final boolean enableEmoticons;
        private final int expireBehavior;
        private final int expireGracePeriod;

        public GuildIntegration(int i, int i2, boolean z2) {
            this.expireBehavior = i;
            this.expireGracePeriod = i2;
            this.enableEmoticons = z2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildMFA;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "", "level", "I", "<init>", "(ILjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildMFA {
        private final String code;
        private final int level;

        public GuildMFA(int i, String str) {
            this.level = i;
            this.code = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012BO\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u001e\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildMember;", "", "", ModelAuditLogEntry.CHANGE_KEY_DEAF, "Ljava/lang/Boolean;", "", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "", "", "roles", "Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_MUTE, "Lcom/discord/primitives/ChannelId;", "channelId", "Ljava/lang/Long;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildMember {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long channelId;
        private final Boolean deaf;
        private final Boolean mute;
        private final String nick;
        private final List<Long> roles;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\bj\u0002`\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildMember$Companion;", "", "", ModelAuditLogEntry.CHANGE_KEY_NICK, "Lcom/discord/restapi/RestAPIParams$GuildMember;", "createWithNick", "(Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$GuildMember;", "", "", "roles", "createWithRoles", "(Ljava/util/List;)Lcom/discord/restapi/RestAPIParams$GuildMember;", "", ModelAuditLogEntry.CHANGE_KEY_MUTE, "createWithMute", "(Z)Lcom/discord/restapi/RestAPIParams$GuildMember;", ModelAuditLogEntry.CHANGE_KEY_DEAF, "createWithDeaf", "Lcom/discord/primitives/ChannelId;", "channelId", "createWithChannelId", "(J)Lcom/discord/restapi/RestAPIParams$GuildMember;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final GuildMember createWithChannelId(long channelId) {
                return new GuildMember(null, null, null, null, Long.valueOf(channelId), 15, null);
            }

            public final GuildMember createWithDeaf(boolean deaf) {
                return new GuildMember(null, null, null, Boolean.valueOf(deaf), null, 23, null);
            }

            public final GuildMember createWithMute(boolean mute) {
                return new GuildMember(null, null, Boolean.valueOf(mute), null, null, 27, null);
            }

            public final GuildMember createWithNick(String nick) {
                return new GuildMember(nick, null, null, null, null, 30, null);
            }

            public final GuildMember createWithRoles(List<Long> roles) {
                return new GuildMember(null, roles, null, null, null, 29, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public GuildMember() {
            this(null, null, null, null, null, 31, null);
        }

        public GuildMember(String str, List<Long> list, Boolean bool, Boolean bool2, Long l) {
            this.nick = str;
            this.roles = list;
            this.mute = bool;
            this.deaf = bool2;
            this.channelId = l;
        }

        public static final GuildMember createWithChannelId(long j) {
            return INSTANCE.createWithChannelId(j);
        }

        public static final GuildMember createWithDeaf(boolean z2) {
            return INSTANCE.createWithDeaf(z2);
        }

        public static final GuildMember createWithMute(boolean z2) {
            return INSTANCE.createWithMute(z2);
        }

        public static final GuildMember createWithNick(String str) {
            return INSTANCE.createWithNick(str);
        }

        public static final GuildMember createWithRoles(List<Long> list) {
            return INSTANCE.createWithRoles(list);
        }

        public /* synthetic */ GuildMember(String str, List list, Boolean bool, Boolean bool2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : l);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$GuildMemberDisconnect;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Ljava/lang/Long;", "<init>", "(Ljava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class GuildMemberDisconnect {
        private final Long channelId;

        public GuildMemberDisconnect() {
            this(null, 1, null);
        }

        public GuildMemberDisconnect(Long l) {
            this.channelId = l;
        }

        public /* synthetic */ GuildMemberDisconnect(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/restapi/RestAPIParams$HubWaitlist;", "", "", "component1", "()Ljava/lang/String;", "component2", NotificationCompat.CATEGORY_EMAIL, "school", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$HubWaitlist;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSchool", "getEmail", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class HubWaitlist {
        private final String email;
        private final String school;

        public HubWaitlist(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(str2, "school");
            this.email = str;
            this.school = str2;
        }

        public static /* synthetic */ HubWaitlist copy$default(HubWaitlist hubWaitlist, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hubWaitlist.email;
            }
            if ((i & 2) != 0) {
                str2 = hubWaitlist.school;
            }
            return hubWaitlist.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSchool() {
            return this.school;
        }

        public final HubWaitlist copy(String email, String school) {
            Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(school, "school");
            return new HubWaitlist(email, school);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HubWaitlist)) {
                return false;
            }
            HubWaitlist hubWaitlist = (HubWaitlist) other;
            return Intrinsics3.areEqual(this.email, hubWaitlist.email) && Intrinsics3.areEqual(this.school, hubWaitlist.school);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getSchool() {
            return this.school;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.school;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("HubWaitlist(email=");
            sbU.append(this.email);
            sbU.append(", school=");
            return outline.J(sbU, this.school, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Invite;", "", "", "regenerate", "Ljava/lang/String;", "", "maxUses", "I", "maxAge", "", ModelAuditLogEntry.CHANGE_KEY_TEMPORARY, "Z", "<init>", "(IIZLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Invite {
        private final int maxAge;
        private final int maxUses;
        private final String regenerate;
        private final boolean temporary;

        public Invite(int i, int i2, boolean z2, String str) {
            this.maxAge = i;
            this.maxUses = i2;
            this.temporary = z2;
            this.regenerate = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$InviteCode;", "", "", "captchaKey", "Ljava/lang/String;", "captchaRqtoken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class InviteCode {
        private final String captchaKey;
        private final String captchaRqtoken;

        public InviteCode(String str, String str2) {
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/restapi/RestAPIParams$InvoicePreviewBody;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "subscriptionId", "renewal", "applyEntitlements", "copy", "(Ljava/lang/String;ZZ)Lcom/discord/restapi/RestAPIParams$InvoicePreviewBody;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSubscriptionId", "Z", "getRenewal", "getApplyEntitlements", "<init>", "(Ljava/lang/String;ZZ)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InvoicePreviewBody {
        private final boolean applyEntitlements;
        private final boolean renewal;
        private final String subscriptionId;

        public InvoicePreviewBody(String str, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(str, "subscriptionId");
            this.subscriptionId = str;
            this.renewal = z2;
            this.applyEntitlements = z3;
        }

        public static /* synthetic */ InvoicePreviewBody copy$default(InvoicePreviewBody invoicePreviewBody, String str, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invoicePreviewBody.subscriptionId;
            }
            if ((i & 2) != 0) {
                z2 = invoicePreviewBody.renewal;
            }
            if ((i & 4) != 0) {
                z3 = invoicePreviewBody.applyEntitlements;
            }
            return invoicePreviewBody.copy(str, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRenewal() {
            return this.renewal;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getApplyEntitlements() {
            return this.applyEntitlements;
        }

        public final InvoicePreviewBody copy(String subscriptionId, boolean renewal, boolean applyEntitlements) {
            Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
            return new InvoicePreviewBody(subscriptionId, renewal, applyEntitlements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvoicePreviewBody)) {
                return false;
            }
            InvoicePreviewBody invoicePreviewBody = (InvoicePreviewBody) other;
            return Intrinsics3.areEqual(this.subscriptionId, invoicePreviewBody.subscriptionId) && this.renewal == invoicePreviewBody.renewal && this.applyEntitlements == invoicePreviewBody.applyEntitlements;
        }

        public final boolean getApplyEntitlements() {
            return this.applyEntitlements;
        }

        public final boolean getRenewal() {
            return this.renewal;
        }

        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.subscriptionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.renewal;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.applyEntitlements;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("InvoicePreviewBody(subscriptionId=");
            sbU.append(this.subscriptionId);
            sbU.append(", renewal=");
            sbU.append(this.renewal);
            sbU.append(", applyEntitlements=");
            return outline.O(sbU, this.applyEntitlements, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/restapi/RestAPIParams$LeaveGuildBody;", "", "", "component1", "()Z", "lurking", "copy", "(Z)Lcom/discord/restapi/RestAPIParams$LeaveGuildBody;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getLurking", "<init>", "(Z)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class LeaveGuildBody {
        private final boolean lurking;

        public LeaveGuildBody() {
            this(false, 1, null);
        }

        public LeaveGuildBody(boolean z2) {
            this.lurking = z2;
        }

        public static /* synthetic */ LeaveGuildBody copy$default(LeaveGuildBody leaveGuildBody, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = leaveGuildBody.lurking;
            }
            return leaveGuildBody.copy(z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getLurking() {
            return this.lurking;
        }

        public final LeaveGuildBody copy(boolean lurking) {
            return new LeaveGuildBody(lurking);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof LeaveGuildBody) && this.lurking == ((LeaveGuildBody) other).lurking;
            }
            return true;
        }

        public final boolean getLurking() {
            return this.lurking;
        }

        public int hashCode() {
            boolean z2 = this.lurking;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("LeaveGuildBody(lurking="), this.lurking, ")");
        }

        public /* synthetic */ LeaveGuildBody(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$MFALogin;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "ticket", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class MFALogin {
        private final String code;
        private final String ticket;

        public MFALogin(String str, String str2) {
            this.ticket = str;
            this.code = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$MemberVerificationForm;", "", "", "version", "Ljava/lang/String;", "", "Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "formFields", "Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class MemberVerificationForm {
        private final List<ModelMemberVerificationForm.FormField> formFields;
        private final String version;

        public MemberVerificationForm() {
            this(null, null, 3, null);
        }

        public MemberVerificationForm(List<ModelMemberVerificationForm.FormField> list, String str) {
            this.formFields = list;
            this.version = str;
        }

        public /* synthetic */ MemberVerificationForm(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001:\u0003<=>B{\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0088\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0004R!\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0015R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b2\u0010\u0004R!\u0010\u001a\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\tR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b5\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b7\u0010\u0012R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\f¨\u0006?"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Message;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/discord/primitives/ApplicationId;", "component3", "()Ljava/lang/Long;", "Lcom/discord/restapi/RestAPIParams$Message$Activity;", "component4", "()Lcom/discord/restapi/RestAPIParams$Message$Activity;", "", "component5", "()Ljava/util/List;", "Lcom/discord/restapi/RestAPIParams$Message$MessageReference;", "component6", "()Lcom/discord/restapi/RestAPIParams$Message$MessageReference;", "Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "component7", "()Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "component8", "component9", "content", "nonce", "applicationId", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "stickerIds", "messageReference", "allowedMentions", "captchaKey", "captchaRqtoken", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/discord/restapi/RestAPIParams$Message$Activity;Ljava/util/List;Lcom/discord/restapi/RestAPIParams$Message$MessageReference;Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$Message;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContent", "Ljava/util/List;", "getStickerIds", "getCaptchaKey", "Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "getAllowedMentions", "getCaptchaRqtoken", "Ljava/lang/Long;", "getApplicationId", "getNonce", "Lcom/discord/restapi/RestAPIParams$Message$MessageReference;", "getMessageReference", "Lcom/discord/restapi/RestAPIParams$Message$Activity;", "getActivity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/discord/restapi/RestAPIParams$Message$Activity;Ljava/util/List;Lcom/discord/restapi/RestAPIParams$Message$MessageReference;Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;Ljava/lang/String;Ljava/lang/String;)V", "Activity", "AllowedMentions", "MessageReference", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Message {
        private final Activity activity;
        private final AllowedMentions allowedMentions;
        private final Long applicationId;
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String content;
        private final MessageReference messageReference;
        private final String nonce;
        private final List<Long> stickerIds;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Message$Activity;", "", "", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Lcom/discord/primitives/ActivityPartyId;", "partyId", "getPartyId", "Lcom/discord/api/message/activity/MessageActivityType;", "type", "Lcom/discord/api/message/activity/MessageActivityType;", "getType", "()Lcom/discord/api/message/activity/MessageActivityType;", "<init>", "(Lcom/discord/api/message/activity/MessageActivityType;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Activity {
            private final String partyId;
            private final String sessionId;
            private final MessageActivityType type;

            public Activity(MessageActivityType messageActivityType, String str, String str2) {
                Intrinsics3.checkNotNullParameter(messageActivityType, "type");
                Intrinsics3.checkNotNullParameter(str, "partyId");
                Intrinsics3.checkNotNullParameter(str2, "sessionId");
                this.type = messageActivityType;
                this.partyId = str;
                this.sessionId = str2;
            }

            public final String getPartyId() {
                return this.partyId;
            }

            public final String getSessionId() {
                return this.sessionId;
            }

            public final MessageActivityType getType() {
                return this.type;
            }
        }

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BA\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "", "", "", "parse", "Ljava/util/List;", "getParse", "()Ljava/util/List;", "", "roles", "getRoles", "", "repliedUser", "Ljava/lang/Boolean;", "getRepliedUser", "()Ljava/lang/Boolean;", "users", "getUsers", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class AllowedMentions {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final List<String> parse;
            private final Boolean repliedUser;
            private final List<Long> roles;
            private final List<Long> users;

            /* compiled from: RestAPIParams.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions$Companion;", "", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "model", "Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "create", "(Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;)Lcom/discord/restapi/RestAPIParams$Message$AllowedMentions;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public final AllowedMentions create(MessageAllowedMentions model) {
                    ArrayList arrayList;
                    Intrinsics3.checkNotNullParameter(model, "model");
                    List<MessageAllowedMentions2> listA = model.a();
                    if (listA != null) {
                        arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
                        Iterator<T> it = listA.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((MessageAllowedMentions2) it.next()).getApiStringRepresentation());
                        }
                    } else {
                        arrayList = null;
                    }
                    return new AllowedMentions(arrayList, model.d(), model.c(), model.getRepliedUser());
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public AllowedMentions(List<String> list, List<Long> list2, List<Long> list3, Boolean bool) {
                this.parse = list;
                this.users = list2;
                this.roles = list3;
                this.repliedUser = bool;
            }

            public final List<String> getParse() {
                return this.parse;
            }

            public final Boolean getRepliedUser() {
                return this.repliedUser;
            }

            public final List<Long> getRoles() {
                return this.roles;
            }

            public final List<Long> getUsers() {
                return this.users;
            }
        }

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u000b\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\b¢\u0006\u0004\b\u0010\u0010\u0011R!\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Message$MessageReference;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "Lcom/discord/primitives/MessageId;", "messageId", "getMessageId", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "<init>", "(Ljava/lang/Long;JLjava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessageReference {
            private final long channelId;
            private final Long guildId;
            private final Long messageId;

            public MessageReference(Long l, long j, Long l2) {
                this.guildId = l;
                this.channelId = j;
                this.messageId = l2;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final Long getMessageId() {
                return this.messageId;
            }
        }

        public Message(String str, String str2, Long l, Activity activity, List<Long> list, MessageReference messageReference, AllowedMentions allowedMentions, String str3, String str4) {
            this.content = str;
            this.nonce = str2;
            this.applicationId = l;
            this.activity = activity;
            this.stickerIds = list;
            this.messageReference = messageReference;
            this.allowedMentions = allowedMentions;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
        }

        public static /* synthetic */ Message copy$default(Message message, String str, String str2, Long l, Activity activity, List list, MessageReference messageReference, AllowedMentions allowedMentions, String str3, String str4, int i, Object obj) {
            return message.copy((i & 1) != 0 ? message.content : str, (i & 2) != 0 ? message.nonce : str2, (i & 4) != 0 ? message.applicationId : l, (i & 8) != 0 ? message.activity : activity, (i & 16) != 0 ? message.stickerIds : list, (i & 32) != 0 ? message.messageReference : messageReference, (i & 64) != 0 ? message.allowedMentions : allowedMentions, (i & 128) != 0 ? message.captchaKey : str3, (i & 256) != 0 ? message.captchaRqtoken : str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component4, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final List<Long> component5() {
            return this.stickerIds;
        }

        /* renamed from: component6, reason: from getter */
        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        /* renamed from: component7, reason: from getter */
        public final AllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        /* renamed from: component8, reason: from getter */
        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        /* renamed from: component9, reason: from getter */
        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final Message copy(String content, String nonce, Long applicationId, Activity activity, List<Long> stickerIds, MessageReference messageReference, AllowedMentions allowedMentions, String captchaKey, String captchaRqtoken) {
            return new Message(content, nonce, applicationId, activity, stickerIds, messageReference, allowedMentions, captchaKey, captchaRqtoken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return Intrinsics3.areEqual(this.content, message.content) && Intrinsics3.areEqual(this.nonce, message.nonce) && Intrinsics3.areEqual(this.applicationId, message.applicationId) && Intrinsics3.areEqual(this.activity, message.activity) && Intrinsics3.areEqual(this.stickerIds, message.stickerIds) && Intrinsics3.areEqual(this.messageReference, message.messageReference) && Intrinsics3.areEqual(this.allowedMentions, message.allowedMentions) && Intrinsics3.areEqual(this.captchaKey, message.captchaKey) && Intrinsics3.areEqual(this.captchaRqtoken, message.captchaRqtoken);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final AllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        public final Long getApplicationId() {
            return this.applicationId;
        }

        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final String getContent() {
            return this.content;
        }

        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final List<Long> getStickerIds() {
            return this.stickerIds;
        }

        public int hashCode() {
            String str = this.content;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.nonce;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.applicationId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Activity activity = this.activity;
            int iHashCode4 = (iHashCode3 + (activity != null ? activity.hashCode() : 0)) * 31;
            List<Long> list = this.stickerIds;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            MessageReference messageReference = this.messageReference;
            int iHashCode6 = (iHashCode5 + (messageReference != null ? messageReference.hashCode() : 0)) * 31;
            AllowedMentions allowedMentions = this.allowedMentions;
            int iHashCode7 = (iHashCode6 + (allowedMentions != null ? allowedMentions.hashCode() : 0)) * 31;
            String str3 = this.captchaKey;
            int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.captchaRqtoken;
            return iHashCode8 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Message(content=");
            sbU.append(this.content);
            sbU.append(", nonce=");
            sbU.append(this.nonce);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", activity=");
            sbU.append(this.activity);
            sbU.append(", stickerIds=");
            sbU.append(this.stickerIds);
            sbU.append(", messageReference=");
            sbU.append(this.messageReference);
            sbU.append(", allowedMentions=");
            sbU.append(this.allowedMentions);
            sbU.append(", captchaKey=");
            sbU.append(this.captchaKey);
            sbU.append(", captchaRqtoken=");
            return outline.J(sbU, this.captchaRqtoken, ")");
        }

        public /* synthetic */ Message(String str, String str2, Long l, Activity activity, List list, MessageReference messageReference, AllowedMentions allowedMentions, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : activity, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : messageReference, (i & 64) != 0 ? null : allowedMentions, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jf\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ModalInteraction;", "", "", "component1", "()J", "component2", "component3", "()Ljava/lang/Long;", "component4", "component5", "", "component6", "()Ljava/lang/String;", "component7", "Lcom/discord/restapi/RestAPIParams$ModalInteractionData;", "component8", "()Lcom/discord/restapi/RestAPIParams$ModalInteractionData;", "type", "applicationId", "messageId", "channelId", "guildId", "sessionId", "nonce", "data", "copy", "(JJLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;JLcom/discord/restapi/RestAPIParams$ModalInteractionData;)Lcom/discord/restapi/RestAPIParams$ModalInteraction;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Lcom/discord/restapi/RestAPIParams$ModalInteractionData;", "getData", "getNonce", "getType", "getApplicationId", "Ljava/lang/String;", "getSessionId", "Ljava/lang/Long;", "getMessageId", "getGuildId", "<init>", "(JJLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;JLcom/discord/restapi/RestAPIParams$ModalInteractionData;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModalInteraction {
        private final long applicationId;
        private final long channelId;
        private final ModalInteractionData data;
        private final Long guildId;
        private final Long messageId;
        private final long nonce;
        private final String sessionId;
        private final long type;

        public ModalInteraction(long j, long j2, Long l, long j3, Long l2, String str, long j4, ModalInteractionData modalInteractionData) {
            Intrinsics3.checkNotNullParameter(modalInteractionData, "data");
            this.type = j;
            this.applicationId = j2;
            this.messageId = l;
            this.channelId = j3;
            this.guildId = l2;
            this.sessionId = str;
            this.nonce = j4;
            this.data = modalInteractionData;
        }

        public static /* synthetic */ ModalInteraction copy$default(ModalInteraction modalInteraction, long j, long j2, Long l, long j3, Long l2, String str, long j4, ModalInteractionData modalInteractionData, int i, Object obj) {
            return modalInteraction.copy((i & 1) != 0 ? modalInteraction.type : j, (i & 2) != 0 ? modalInteraction.applicationId : j2, (i & 4) != 0 ? modalInteraction.messageId : l, (i & 8) != 0 ? modalInteraction.channelId : j3, (i & 16) != 0 ? modalInteraction.guildId : l2, (i & 32) != 0 ? modalInteraction.sessionId : str, (i & 64) != 0 ? modalInteraction.nonce : j4, (i & 128) != 0 ? modalInteraction.data : modalInteractionData);
        }

        /* renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component4, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final long getNonce() {
            return this.nonce;
        }

        /* renamed from: component8, reason: from getter */
        public final ModalInteractionData getData() {
            return this.data;
        }

        public final ModalInteraction copy(long type, long applicationId, Long messageId, long channelId, Long guildId, String sessionId, long nonce, ModalInteractionData data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new ModalInteraction(type, applicationId, messageId, channelId, guildId, sessionId, nonce, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteraction)) {
                return false;
            }
            ModalInteraction modalInteraction = (ModalInteraction) other;
            return this.type == modalInteraction.type && this.applicationId == modalInteraction.applicationId && Intrinsics3.areEqual(this.messageId, modalInteraction.messageId) && this.channelId == modalInteraction.channelId && Intrinsics3.areEqual(this.guildId, modalInteraction.guildId) && Intrinsics3.areEqual(this.sessionId, modalInteraction.sessionId) && this.nonce == modalInteraction.nonce && Intrinsics3.areEqual(this.data, modalInteraction.data);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final ModalInteractionData getData() {
            return this.data;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public final long getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            long j2 = this.applicationId;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            Long l = this.messageId;
            int iHashCode = l != null ? l.hashCode() : 0;
            long j3 = this.channelId;
            int i2 = (((i + iHashCode) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            Long l2 = this.guildId;
            int iHashCode2 = (i2 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str = this.sessionId;
            int iHashCode3 = str != null ? str.hashCode() : 0;
            long j4 = this.nonce;
            int i3 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            ModalInteractionData modalInteractionData = this.data;
            return i3 + (modalInteractionData != null ? modalInteractionData.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModalInteraction(type=");
            sbU.append(this.type);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", messageId=");
            sbU.append(this.messageId);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", sessionId=");
            sbU.append(this.sessionId);
            sbU.append(", nonce=");
            sbU.append(this.nonce);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ModalInteractionData;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/restapi/RestAPIParams$ModalInteractionDataComponent;", "component3", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_ID, "customId", "components", "copy", "(JLjava/lang/String;Ljava/util/List;)Lcom/discord/restapi/RestAPIParams$ModalInteractionData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getComponents", "J", "getId", "Ljava/lang/String;", "getCustomId", "<init>", "(JLjava/lang/String;Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModalInteractionData {
        private final List<ModalInteractionDataComponent> components;
        private final String customId;
        private final long id;

        public ModalInteractionData(long j, String str, List<ModalInteractionDataComponent> list) {
            Intrinsics3.checkNotNullParameter(str, "customId");
            Intrinsics3.checkNotNullParameter(list, "components");
            this.id = j;
            this.customId = str;
            this.components = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModalInteractionData copy$default(ModalInteractionData modalInteractionData, long j, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = modalInteractionData.id;
            }
            if ((i & 2) != 0) {
                str = modalInteractionData.customId;
            }
            if ((i & 4) != 0) {
                list = modalInteractionData.components;
            }
            return modalInteractionData.copy(j, str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCustomId() {
            return this.customId;
        }

        public final List<ModalInteractionDataComponent> component3() {
            return this.components;
        }

        public final ModalInteractionData copy(long id2, String customId, List<ModalInteractionDataComponent> components) {
            Intrinsics3.checkNotNullParameter(customId, "customId");
            Intrinsics3.checkNotNullParameter(components, "components");
            return new ModalInteractionData(id2, customId, components);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteractionData)) {
                return false;
            }
            ModalInteractionData modalInteractionData = (ModalInteractionData) other;
            return this.id == modalInteractionData.id && Intrinsics3.areEqual(this.customId, modalInteractionData.customId) && Intrinsics3.areEqual(this.components, modalInteractionData.components);
        }

        public final List<ModalInteractionDataComponent> getComponents() {
            return this.components;
        }

        public final String getCustomId() {
            return this.customId;
        }

        public final long getId() {
            return this.id;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.customId;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            List<ModalInteractionDataComponent> list = this.components;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModalInteractionData(id=");
            sbU.append(this.id);
            sbU.append(", customId=");
            sbU.append(this.customId);
            sbU.append(", components=");
            return outline.L(sbU, this.components, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001e\u0010\nR!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ModalInteractionDataComponent;", "", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "component4", "type", "components", "customId", "value", "copy", "(Lcom/discord/api/botuikit/ComponentType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$ModalInteractionDataComponent;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCustomId", "Lcom/discord/api/botuikit/ComponentType;", "getType", "getValue", "Ljava/util/List;", "getComponents", "<init>", "(Lcom/discord/api/botuikit/ComponentType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModalInteractionDataComponent {
        private final List<ModalInteractionDataComponent> components;
        private final String customId;
        private final Component6 type;
        private final String value;

        public ModalInteractionDataComponent(Component6 component6, List<ModalInteractionDataComponent> list, String str, String str2) {
            Intrinsics3.checkNotNullParameter(component6, "type");
            this.type = component6;
            this.components = list;
            this.customId = str;
            this.value = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModalInteractionDataComponent copy$default(ModalInteractionDataComponent modalInteractionDataComponent, Component6 component6, List list, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                component6 = modalInteractionDataComponent.type;
            }
            if ((i & 2) != 0) {
                list = modalInteractionDataComponent.components;
            }
            if ((i & 4) != 0) {
                str = modalInteractionDataComponent.customId;
            }
            if ((i & 8) != 0) {
                str2 = modalInteractionDataComponent.value;
            }
            return modalInteractionDataComponent.copy(component6, list, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final Component6 getType() {
            return this.type;
        }

        public final List<ModalInteractionDataComponent> component2() {
            return this.components;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCustomId() {
            return this.customId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final ModalInteractionDataComponent copy(Component6 type, List<ModalInteractionDataComponent> components, String customId, String value) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new ModalInteractionDataComponent(type, components, customId, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteractionDataComponent)) {
                return false;
            }
            ModalInteractionDataComponent modalInteractionDataComponent = (ModalInteractionDataComponent) other;
            return Intrinsics3.areEqual(this.type, modalInteractionDataComponent.type) && Intrinsics3.areEqual(this.components, modalInteractionDataComponent.components) && Intrinsics3.areEqual(this.customId, modalInteractionDataComponent.customId) && Intrinsics3.areEqual(this.value, modalInteractionDataComponent.value);
        }

        public final List<ModalInteractionDataComponent> getComponents() {
            return this.components;
        }

        public final String getCustomId() {
            return this.customId;
        }

        public final Component6 getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            Component6 component6 = this.type;
            int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
            List<ModalInteractionDataComponent> list = this.components;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.customId;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModalInteractionDataComponent(type=");
            sbU.append(this.type);
            sbU.append(", components=");
            sbU.append(this.components);
            sbU.append(", customId=");
            sbU.append(this.customId);
            sbU.append(", value=");
            return outline.J(sbU, this.value, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Nick;", "", "", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Nick {
        private final String nick;

        public Nick(String str) {
            this.nick = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize;", "", "<init>", "()V", "ResponseGet", "ResponsePost", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class OAuth2Authorize {
        public static final OAuth2Authorize INSTANCE = new OAuth2Authorize();

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "", "", "Lcom/discord/restapi/RestAPIParams$ConnectedAccount;", "connections", "Ljava/util/List;", "getConnections", "()Ljava/util/List;", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "getUser", "()Lcom/discord/api/user/User;", "Lcom/discord/api/application/Application;", "application", "Lcom/discord/api/application/Application;", "getApplication", "()Lcom/discord/api/application/Application;", "Lcom/discord/api/guild/Guild;", "guilds", "getGuilds", "<init>", "(Lcom/discord/api/user/User;Lcom/discord/api/application/Application;Ljava/util/List;Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class ResponseGet {
            private final Application application;
            private final List<ConnectedAccount> connections;
            private final List<Guild> guilds;
            private final User user;

            public ResponseGet(User user, Application application, List<ConnectedAccount> list, List<Guild> list2) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(application, "application");
                Intrinsics3.checkNotNullParameter(list, "connections");
                Intrinsics3.checkNotNullParameter(list2, "guilds");
                this.user = user;
                this.application = application;
                this.connections = list;
                this.guilds = list2;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final List<ConnectedAccount> getConnections() {
                return this.connections;
            }

            public final List<Guild> getGuilds() {
                return this.guilds;
            }

            public final User getUser() {
                return this.user;
            }
        }

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;", "", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class ResponsePost {
            private final String location;

            public ResponsePost(String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
                this.location = str;
            }

            public final String getLocation() {
                return this.location;
            }
        }

        private OAuth2Authorize() {
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$PatchGuildEmoji;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class PatchGuildEmoji {
        private final String name;

        public PatchGuildEmoji(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Phone;", "", "", "source", "Ljava/lang/String;", "captchaKey", "phone", "captchaRqtoken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Phone {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String phone;
        private final String source;

        public Phone(String str, String str2, String str3, String str4) {
            this.phone = str;
            this.source = str2;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$PostGuildEmoji;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "image", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class PostGuildEmoji {
        private final String image;
        private final String name;

        public PostGuildEmoji(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "image");
            this.name = str;
            this.image = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$PruneGuild;", "", "", "days", "Ljava/lang/Integer;", "", "computePruneCount", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class PruneGuild {
        private final Boolean computePruneCount;
        private final Integer days;

        public PruneGuild() {
            this(null, null, 3, null);
        }

        public PruneGuild(Integer num, Boolean bool) {
            this.days = num;
            this.computePruneCount = bool;
        }

        public /* synthetic */ PruneGuild(Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? Boolean.FALSE : bool);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$PurchaseMetadataBody;", "", "", "Lcom/discord/primitives/SkuId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "skuId", "paymentGatewaySkuId", "copy", "(JLjava/lang/String;)Lcom/discord/restapi/RestAPIParams$PurchaseMetadataBody;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSkuId", "Ljava/lang/String;", "getPaymentGatewaySkuId", "<init>", "(JLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PurchaseMetadataBody {
        private final String paymentGatewaySkuId;
        private final long skuId;

        public PurchaseMetadataBody(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.skuId = j;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ PurchaseMetadataBody copy$default(PurchaseMetadataBody purchaseMetadataBody, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = purchaseMetadataBody.skuId;
            }
            if ((i & 2) != 0) {
                str = purchaseMetadataBody.paymentGatewaySkuId;
            }
            return purchaseMetadataBody.copy(j, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final PurchaseMetadataBody copy(long skuId, String paymentGatewaySkuId) {
            Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
            return new PurchaseMetadataBody(skuId, paymentGatewaySkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PurchaseMetadataBody)) {
                return false;
            }
            PurchaseMetadataBody purchaseMetadataBody = (PurchaseMetadataBody) other;
            return this.skuId == purchaseMetadataBody.skuId && Intrinsics3.areEqual(this.paymentGatewaySkuId, purchaseMetadataBody.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public int hashCode() {
            long j = this.skuId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.paymentGatewaySkuId;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PurchaseMetadataBody(skuId=");
            sbU.append(this.skuId);
            sbU.append(", paymentGatewaySkuId=");
            return outline.J(sbU, this.paymentGatewaySkuId, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$RemoteAuthCancel;", "", "", "handshakeToken", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class RemoteAuthCancel {
        private final String handshakeToken;

        public RemoteAuthCancel(String str) {
            Intrinsics3.checkNotNullParameter(str, "handshakeToken");
            this.handshakeToken = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$RemoteAuthFinish;", "", "", "handshakeToken", "Ljava/lang/String;", "", ModelAuditLogEntry.CHANGE_KEY_TEMPORARY, "Z", "<init>", "(ZLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class RemoteAuthFinish {
        private final String handshakeToken;
        private final boolean temporary;

        public RemoteAuthFinish(boolean z2, String str) {
            Intrinsics3.checkNotNullParameter(str, "handshakeToken");
            this.temporary = z2;
            this.handshakeToken = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$RemoteAuthInitialize;", "", "", "fingerprint", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class RemoteAuthInitialize {
        private final String fingerprint;

        public RemoteAuthInitialize(String str) {
            Intrinsics3.checkNotNullParameter(str, "fingerprint");
            this.fingerprint = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Report;", "", "", "Lcom/discord/primitives/MessageId;", "messageId", "Ljava/lang/Long;", "Lcom/discord/primitives/ChannelId;", "channelId", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "I", "<init>", "(ILjava/lang/Long;Ljava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Report {
        private final Long channelId;
        private final Long messageId;
        private final int reason;

        public Report(int i, Long l, Long l2) {
            this.reason = i;
            this.channelId = l;
            this.messageId = l2;
        }

        public /* synthetic */ Report(int i, Long l, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : l2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Ring;", "", "", "", "recipients", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ring {
        private final List<Long> recipients;

        public Ring(List<Long> list) {
            this.recipients = list;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00010Bk\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010$\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR*\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u00061"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Role;", "", "", "icon", "Ljava/lang/String;", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "", ModelAuditLogEntry.CHANGE_KEY_MENTIONABLE, "Ljava/lang/Boolean;", "getMentionable", "()Ljava/lang/Boolean;", "setMentionable", "(Ljava/lang/Boolean;)V", ModelAuditLogEntry.CHANGE_KEY_HOIST, "getHoist", "setHoist", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", "setName", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Ljava/lang/Long;", "getPermissions", "()Ljava/lang/Long;", "setPermissions", "(Ljava/lang/Long;)V", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "setId", "(J)V", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Ljava/lang/Integer;", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getPosition", "setPosition", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;JLjava/lang/String;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Role {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private Integer color;
        private Boolean hoist;
        private String icon;
        private long id;
        private Boolean mentionable;
        private String name;
        private Long permissions;
        private Integer position;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Role$Companion;", "", "Lcom/discord/api/role/GuildRole;", "role", "Lcom/discord/restapi/RestAPIParams$Role;", "createWithRole", "(Lcom/discord/api/role/GuildRole;)Lcom/discord/restapi/RestAPIParams$Role;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "createForPosition", "(JI)Lcom/discord/restapi/RestAPIParams$Role;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Role createForPosition(long id2, int position) {
                return new Role(null, null, null, null, Integer.valueOf(position), null, id2, null, 175, null);
            }

            public final Role createWithRole(GuildRole role) {
                Intrinsics3.checkNotNullParameter(role, "role");
                return new Role(Boolean.valueOf(role.getHoist()), role.getName(), Boolean.valueOf(role.getMentionable()), Integer.valueOf(role.getColor()), Integer.valueOf(role.getPosition()), Long.valueOf(role.getPermissions()), role.getId(), null, 128, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Role() {
            this(null, null, null, null, null, null, 0L, null, 255, null);
        }

        public Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2) {
            this.hoist = bool;
            this.name = str;
            this.mentionable = bool2;
            this.color = num;
            this.position = num2;
            this.permissions = l;
            this.id = j;
            this.icon = str2;
        }

        public static final Role createForPosition(long j, int i) {
            return INSTANCE.createForPosition(j, i);
        }

        public static final Role createWithRole(GuildRole guildRole) {
            return INSTANCE.createWithRole(guildRole);
        }

        public final Integer getColor() {
            return this.color;
        }

        public final Boolean getHoist() {
            return this.hoist;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final long getId() {
            return this.id;
        }

        public final Boolean getMentionable() {
            return this.mentionable;
        }

        public final String getName() {
            return this.name;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final void setColor(Integer num) {
            this.color = num;
        }

        public final void setHoist(Boolean bool) {
            this.hoist = bool;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final void setMentionable(Boolean bool) {
            this.mentionable = bool;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final void setPermissions(Long l) {
            this.permissions = l;
        }

        public final void setPosition(Integer num) {
            this.position = num;
        }

        public /* synthetic */ Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : l, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? str2 : null);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJH\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b \u0010\bR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lcom/discord/restapi/RestAPIParams$StartStageInstanceBody;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component3", "()Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "", "component4", "()Z", "component5", "channelId", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "privacyLevel", "sendStartNotification", "guildScheduledEventId", "copy", "(JLjava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;ZLjava/lang/String;)Lcom/discord/restapi/RestAPIParams$StartStageInstanceBody;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTopic", "getGuildScheduledEventId", "J", "getChannelId", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "getPrivacyLevel", "Z", "getSendStartNotification", "<init>", "(JLjava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;ZLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StartStageInstanceBody {
        private final long channelId;
        private final String guildScheduledEventId;
        private final StageInstancePrivacyLevel privacyLevel;
        private final boolean sendStartNotification;
        private final String topic;

        public StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
            Intrinsics3.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
            this.channelId = j;
            this.topic = str;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.sendStartNotification = z2;
            this.guildScheduledEventId = str2;
        }

        public static /* synthetic */ StartStageInstanceBody copy$default(StartStageInstanceBody startStageInstanceBody, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = startStageInstanceBody.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = startStageInstanceBody.topic;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                stageInstancePrivacyLevel = startStageInstanceBody.privacyLevel;
            }
            StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
            if ((i & 8) != 0) {
                z2 = startStageInstanceBody.sendStartNotification;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                str2 = startStageInstanceBody.guildScheduledEventId;
            }
            return startStageInstanceBody.copy(j2, str3, stageInstancePrivacyLevel2, z3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getSendStartNotification() {
            return this.sendStartNotification;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGuildScheduledEventId() {
            return this.guildScheduledEventId;
        }

        public final StartStageInstanceBody copy(long channelId, String topic, StageInstancePrivacyLevel privacyLevel, boolean sendStartNotification, String guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
            Intrinsics3.checkNotNullParameter(privacyLevel, "privacyLevel");
            return new StartStageInstanceBody(channelId, topic, privacyLevel, sendStartNotification, guildScheduledEventId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartStageInstanceBody)) {
                return false;
            }
            StartStageInstanceBody startStageInstanceBody = (StartStageInstanceBody) other;
            return this.channelId == startStageInstanceBody.channelId && Intrinsics3.areEqual(this.topic, startStageInstanceBody.topic) && Intrinsics3.areEqual(this.privacyLevel, startStageInstanceBody.privacyLevel) && this.sendStartNotification == startStageInstanceBody.sendStartNotification && Intrinsics3.areEqual(this.guildScheduledEventId, startStageInstanceBody.guildScheduledEventId);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getGuildScheduledEventId() {
            return this.guildScheduledEventId;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final boolean getSendStartNotification() {
            return this.sendStartNotification;
        }

        public final String getTopic() {
            return this.topic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            long j = this.channelId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.topic;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode2 = (iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            boolean z2 = this.sendStartNotification;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int i3 = (iHashCode2 + i2) * 31;
            String str2 = this.guildScheduledEventId;
            return i3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StartStageInstanceBody(channelId=");
            sbU.append(this.channelId);
            sbU.append(", topic=");
            sbU.append(this.topic);
            sbU.append(", privacyLevel=");
            sbU.append(this.privacyLevel);
            sbU.append(", sendStartNotification=");
            sbU.append(this.sendStartNotification);
            sbU.append(", guildScheduledEventId=");
            return outline.J(sbU, this.guildScheduledEventId, ")");
        }

        public /* synthetic */ StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, stageInstancePrivacyLevel, z2, (i & 16) != 0 ? null : str2);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/restapi/RestAPIParams$TextChannel;", "", "", "defaultAutoArchiveDuration", "Ljava/lang/Integer;", "rateLimitPerUser", "type", "", ModelAuditLogEntry.CHANGE_KEY_NSFW, "Ljava/lang/Boolean;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextChannel {
        private final Integer defaultAutoArchiveDuration;
        private final String name;
        private final Boolean nsfw;
        private final Integer rateLimitPerUser;
        private final String topic;
        private final Integer type;

        public TextChannel(String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3) {
            this.name = str;
            this.type = num;
            this.topic = str2;
            this.nsfw = bool;
            this.rateLimitPerUser = num2;
            this.defaultAutoArchiveDuration = num3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ThreadCreationSettings;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "()Ljava/lang/Integer;", ModelAuditLogEntry.CHANGE_KEY_NAME, "type", "autoArchiveDuration", "copy", "(Ljava/lang/String;ILjava/lang/Integer;)Lcom/discord/restapi/RestAPIParams$ThreadCreationSettings;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "Ljava/lang/Integer;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ThreadCreationSettings {
        private final Integer autoArchiveDuration;
        private final String name;
        private final int type;

        public ThreadCreationSettings(String str, int i, Integer num) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.type = i;
            this.autoArchiveDuration = num;
        }

        /* renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        private final int getType() {
            return this.type;
        }

        /* renamed from: component3, reason: from getter */
        private final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public static /* synthetic */ ThreadCreationSettings copy$default(ThreadCreationSettings threadCreationSettings, String str, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = threadCreationSettings.name;
            }
            if ((i2 & 2) != 0) {
                i = threadCreationSettings.type;
            }
            if ((i2 & 4) != 0) {
                num = threadCreationSettings.autoArchiveDuration;
            }
            return threadCreationSettings.copy(str, i, num);
        }

        public final ThreadCreationSettings copy(String name, int type, Integer autoArchiveDuration) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new ThreadCreationSettings(name, type, autoArchiveDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadCreationSettings)) {
                return false;
            }
            ThreadCreationSettings threadCreationSettings = (ThreadCreationSettings) other;
            return Intrinsics3.areEqual(this.name, threadCreationSettings.name) && this.type == threadCreationSettings.type && Intrinsics3.areEqual(this.autoArchiveDuration, threadCreationSettings.autoArchiveDuration);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
            Integer num = this.autoArchiveDuration;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadCreationSettings(name=");
            sbU.append(this.name);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", autoArchiveDuration=");
            return outline.F(sbU, this.autoArchiveDuration, ")");
        }

        public /* synthetic */ ThreadCreationSettings(String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? null : num);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/restapi/RestAPIParams$ThreadMemberSettings;", "", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/Boolean;", "Lcom/discord/models/domain/ModelMuteConfig;", "component3", "()Lcom/discord/models/domain/ModelMuteConfig;", "flags", "muted", "muteConfig", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/discord/models/domain/ModelMuteConfig;)Lcom/discord/restapi/RestAPIParams$ThreadMemberSettings;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getFlags", "Lcom/discord/models/domain/ModelMuteConfig;", "getMuteConfig", "Ljava/lang/Boolean;", "getMuted", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/discord/models/domain/ModelMuteConfig;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ThreadMemberSettings {
        private final Integer flags;
        private final ModelMuteConfig muteConfig;
        private final Boolean muted;

        public ThreadMemberSettings() {
            this(null, null, null, 7, null);
        }

        public ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig) {
            this.flags = num;
            this.muted = bool;
            this.muteConfig = modelMuteConfig;
        }

        public static /* synthetic */ ThreadMemberSettings copy$default(ThreadMemberSettings threadMemberSettings, Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                num = threadMemberSettings.flags;
            }
            if ((i & 2) != 0) {
                bool = threadMemberSettings.muted;
            }
            if ((i & 4) != 0) {
                modelMuteConfig = threadMemberSettings.muteConfig;
            }
            return threadMemberSettings.copy(num, bool, modelMuteConfig);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getFlags() {
            return this.flags;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getMuted() {
            return this.muted;
        }

        /* renamed from: component3, reason: from getter */
        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final ThreadMemberSettings copy(Integer flags, Boolean muted, ModelMuteConfig muteConfig) {
            return new ThreadMemberSettings(flags, muted, muteConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadMemberSettings)) {
                return false;
            }
            ThreadMemberSettings threadMemberSettings = (ThreadMemberSettings) other;
            return Intrinsics3.areEqual(this.flags, threadMemberSettings.flags) && Intrinsics3.areEqual(this.muted, threadMemberSettings.muted) && Intrinsics3.areEqual(this.muteConfig, threadMemberSettings.muteConfig);
        }

        public final Integer getFlags() {
            return this.flags;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final Boolean getMuted() {
            return this.muted;
        }

        public int hashCode() {
            Integer num = this.flags;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            Boolean bool = this.muted;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            return iHashCode2 + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadMemberSettings(flags=");
            sbU.append(this.flags);
            sbU.append(", muted=");
            sbU.append(this.muted);
            sbU.append(", muteConfig=");
            sbU.append(this.muteConfig);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : modelMuteConfig);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ThreadSettings;", "", "", "component1", "()Ljava/lang/Boolean;", "component2", "", "component3", "()Ljava/lang/Integer;", ModelAuditLogEntry.CHANGE_KEY_ARCHIVED, ModelAuditLogEntry.CHANGE_KEY_LOCKED, "autoArchiveDuration", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/discord/restapi/RestAPIParams$ThreadSettings;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ThreadSettings {
        private final Boolean archived;
        private final Integer autoArchiveDuration;
        private final Boolean locked;

        public ThreadSettings() {
            this(null, null, null, 7, null);
        }

        public ThreadSettings(Boolean bool, Boolean bool2, Integer num) {
            this.archived = bool;
            this.locked = bool2;
            this.autoArchiveDuration = num;
        }

        /* renamed from: component1, reason: from getter */
        private final Boolean getArchived() {
            return this.archived;
        }

        /* renamed from: component2, reason: from getter */
        private final Boolean getLocked() {
            return this.locked;
        }

        /* renamed from: component3, reason: from getter */
        private final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public static /* synthetic */ ThreadSettings copy$default(ThreadSettings threadSettings, Boolean bool, Boolean bool2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = threadSettings.archived;
            }
            if ((i & 2) != 0) {
                bool2 = threadSettings.locked;
            }
            if ((i & 4) != 0) {
                num = threadSettings.autoArchiveDuration;
            }
            return threadSettings.copy(bool, bool2, num);
        }

        public final ThreadSettings copy(Boolean archived, Boolean locked, Integer autoArchiveDuration) {
            return new ThreadSettings(archived, locked, autoArchiveDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadSettings)) {
                return false;
            }
            ThreadSettings threadSettings = (ThreadSettings) other;
            return Intrinsics3.areEqual(this.archived, threadSettings.archived) && Intrinsics3.areEqual(this.locked, threadSettings.locked) && Intrinsics3.areEqual(this.autoArchiveDuration, threadSettings.autoArchiveDuration);
        }

        public int hashCode() {
            Boolean bool = this.archived;
            int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.locked;
            int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Integer num = this.autoArchiveDuration;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadSettings(archived=");
            sbU.append(this.archived);
            sbU.append(", locked=");
            sbU.append(this.locked);
            sbU.append(", autoArchiveDuration=");
            return outline.F(sbU, this.autoArchiveDuration, ")");
        }

        public /* synthetic */ ThreadSettings(Boolean bool, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : num);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$Thumbnail;", "", "", "thumbnail", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Thumbnail {
        private final String thumbnail;

        public Thumbnail(String str) {
            Intrinsics3.checkNotNullParameter(str, "thumbnail");
            this.thumbnail = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$TopicalChannel;", "", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Ljava/lang/String;", "", "type", "Ljava/lang/Integer;", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class TopicalChannel {
        private final String name;
        private final String topic;
        private final Integer type;

        public TopicalChannel(String str, Integer num, String str2) {
            this.name = str;
            this.type = num;
            this.topic = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$TransferGuildOwnership;", "", "", "ownerId", "J", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "<init>", "(JLjava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class TransferGuildOwnership {
        private final String code;
        private final long ownerId;

        public TransferGuildOwnership(long j, String str) {
            this.ownerId = j;
            this.code = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001'BÁ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b%\u0010&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\nR\u001b\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\r¨\u0006("}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "", "", "afkChannelId", "Ljava/lang/Long;", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "Lcom/discord/api/guild/GuildVerificationLevel;", "", "splash", "Ljava/lang/String;", "publicUpdatesChannelId", "getPublicUpdatesChannelId", "()Ljava/lang/Long;", "", "afkTimeout", "Ljava/lang/Integer;", "banner", "preferredLocale", "getPreferredLocale", "()Ljava/lang/String;", "systemChannelId", ModelAuditLogEntry.CHANGE_KEY_NAME, "systemChannelFlags", "", "Lcom/discord/api/guild/GuildFeature;", "features", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "defaultMessageNotifications", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "explicitContentFilter", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "icon", "rulesChannelId", "getRulesChannelId", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/guild/GuildVerificationLevel;Lcom/discord/api/guild/GuildExplicitContentFilter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateGuild {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long afkChannelId;
        private final Integer afkTimeout;
        private final String banner;
        private final Integer defaultMessageNotifications;
        private final GuildExplicitContentFilter explicitContentFilter;
        private final List<GuildFeature> features;
        private final String icon;
        private final String name;
        private final String preferredLocale;
        private final Long publicUpdatesChannelId;
        private final Long rulesChannelId;
        private final String splash;
        private final Integer systemChannelFlags;
        private final Long systemChannelId;
        private final GuildVerificationLevel verificationLevel;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuild$Companion;", "", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "createForVerificationLevel", "(Lcom/discord/api/guild/GuildVerificationLevel;)Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "explicitContentFilter", "createForExplicitContentFilter", "(Lcom/discord/api/guild/GuildExplicitContentFilter;)Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter explicitContentFilter) {
                Intrinsics3.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
                return new UpdateGuild(null, null, null, null, null, null, null, explicitContentFilter, null, null, null, null, null, null, null, 32639, null);
            }

            public final UpdateGuild createForVerificationLevel(GuildVerificationLevel verificationLevel) {
                Intrinsics3.checkNotNullParameter(verificationLevel, "verificationLevel");
                return new UpdateGuild(null, null, null, null, null, null, verificationLevel, null, null, null, null, null, null, null, null, 32703, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UpdateGuild() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List<? extends GuildFeature> list, Long l3, Long l4, String str5) {
            this.afkChannelId = l;
            this.afkTimeout = num;
            this.systemChannelId = l2;
            this.defaultMessageNotifications = num2;
            this.icon = str;
            this.name = str2;
            this.verificationLevel = guildVerificationLevel;
            this.explicitContentFilter = guildExplicitContentFilter;
            this.splash = str3;
            this.banner = str4;
            this.systemChannelFlags = num3;
            this.features = list;
            this.rulesChannelId = l3;
            this.publicUpdatesChannelId = l4;
            this.preferredLocale = str5;
        }

        public static final UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter guildExplicitContentFilter) {
            return INSTANCE.createForExplicitContentFilter(guildExplicitContentFilter);
        }

        public static final UpdateGuild createForVerificationLevel(GuildVerificationLevel guildVerificationLevel) {
            return INSTANCE.createForVerificationLevel(guildVerificationLevel);
        }

        public final List<GuildFeature> getFeatures() {
            return this.features;
        }

        public final String getPreferredLocale() {
            return this.preferredLocale;
        }

        public final Long getPublicUpdatesChannelId() {
            return this.publicUpdatesChannelId;
        }

        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        public /* synthetic */ UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List list, Long l3, Long l4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : guildVerificationLevel, (i & 128) != 0 ? null : guildExplicitContentFilter, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : l3, (i & 8192) != 0 ? null : l4, (i & 16384) == 0 ? str5 : null);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionGroupListing;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "image", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "fullServerGate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionGroupListing;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getImage", "Ljava/lang/Boolean;", "getFullServerGate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateGuildRoleSubscriptionGroupListing {
        private final String description;
        private final Boolean fullServerGate;
        private final String image;

        public UpdateGuildRoleSubscriptionGroupListing(String str, String str2, Boolean bool) {
            this.image = str;
            this.description = str2;
            this.fullServerGate = bool;
        }

        public static /* synthetic */ UpdateGuildRoleSubscriptionGroupListing copy$default(UpdateGuildRoleSubscriptionGroupListing updateGuildRoleSubscriptionGroupListing, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateGuildRoleSubscriptionGroupListing.image;
            }
            if ((i & 2) != 0) {
                str2 = updateGuildRoleSubscriptionGroupListing.description;
            }
            if ((i & 4) != 0) {
                bool = updateGuildRoleSubscriptionGroupListing.fullServerGate;
            }
            return updateGuildRoleSubscriptionGroupListing.copy(str, str2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final UpdateGuildRoleSubscriptionGroupListing copy(String image, String description, Boolean fullServerGate) {
            return new UpdateGuildRoleSubscriptionGroupListing(image, description, fullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionGroupListing)) {
                return false;
            }
            UpdateGuildRoleSubscriptionGroupListing updateGuildRoleSubscriptionGroupListing = (UpdateGuildRoleSubscriptionGroupListing) other;
            return Intrinsics3.areEqual(this.image, updateGuildRoleSubscriptionGroupListing.image) && Intrinsics3.areEqual(this.description, updateGuildRoleSubscriptionGroupListing.description) && Intrinsics3.areEqual(this.fullServerGate, updateGuildRoleSubscriptionGroupListing.fullServerGate);
        }

        public final String getDescription() {
            return this.description;
        }

        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final String getImage() {
            return this.image;
        }

        public int hashCode() {
            String str = this.image;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.fullServerGate;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateGuildRoleSubscriptionGroupListing(image=");
            sbU.append(this.image);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", fullServerGate=");
            return outline.D(sbU, this.fullServerGate, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial;", "", "Lcom/discord/nullserializable/NullSerializable;", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component1", "()Lcom/discord/nullserializable/NullSerializable;", "", "component2", "trial", "maxNumActiveTrialUsers", "copy", "(Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;)Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/nullserializable/NullSerializable;", "getMaxNumActiveTrialUsers", "getTrial", "<init>", "(Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateGuildRoleSubscriptionTierFreeTrial {
        private final NullSerializable<Integer> maxNumActiveTrialUsers;
        private final NullSerializable<SubscriptionTrialInterval> trial;

        public UpdateGuildRoleSubscriptionTierFreeTrial(NullSerializable<SubscriptionTrialInterval> nullSerializable, NullSerializable<Integer> nullSerializable2) {
            this.trial = nullSerializable;
            this.maxNumActiveTrialUsers = nullSerializable2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateGuildRoleSubscriptionTierFreeTrial copy$default(UpdateGuildRoleSubscriptionTierFreeTrial updateGuildRoleSubscriptionTierFreeTrial, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
            if ((i & 1) != 0) {
                nullSerializable = updateGuildRoleSubscriptionTierFreeTrial.trial;
            }
            if ((i & 2) != 0) {
                nullSerializable2 = updateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers;
            }
            return updateGuildRoleSubscriptionTierFreeTrial.copy(nullSerializable, nullSerializable2);
        }

        public final NullSerializable<SubscriptionTrialInterval> component1() {
            return this.trial;
        }

        public final NullSerializable<Integer> component2() {
            return this.maxNumActiveTrialUsers;
        }

        public final UpdateGuildRoleSubscriptionTierFreeTrial copy(NullSerializable<SubscriptionTrialInterval> trial, NullSerializable<Integer> maxNumActiveTrialUsers) {
            return new UpdateGuildRoleSubscriptionTierFreeTrial(trial, maxNumActiveTrialUsers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionTierFreeTrial)) {
                return false;
            }
            UpdateGuildRoleSubscriptionTierFreeTrial updateGuildRoleSubscriptionTierFreeTrial = (UpdateGuildRoleSubscriptionTierFreeTrial) other;
            return Intrinsics3.areEqual(this.trial, updateGuildRoleSubscriptionTierFreeTrial.trial) && Intrinsics3.areEqual(this.maxNumActiveTrialUsers, updateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers);
        }

        public final NullSerializable<Integer> getMaxNumActiveTrialUsers() {
            return this.maxNumActiveTrialUsers;
        }

        public final NullSerializable<SubscriptionTrialInterval> getTrial() {
            return this.trial;
        }

        public int hashCode() {
            NullSerializable<SubscriptionTrialInterval> nullSerializable = this.trial;
            int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
            NullSerializable<Integer> nullSerializable2 = this.maxNumActiveTrialUsers;
            return iHashCode + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateGuildRoleSubscriptionTierFreeTrial(trial=");
            sbU.append(this.trial);
            sbU.append(", maxNumActiveTrialUsers=");
            sbU.append(this.maxNumActiveTrialUsers);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010Jj\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\tR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b(\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b)\u0010\u0004R!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\r¨\u0006."}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionTierListing;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Integer;", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "component5", "()Ljava/util/List;", "", "component6", "()Ljava/lang/Boolean;", "component7", ModelAuditLogEntry.CHANGE_KEY_NAME, "image", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "priceTier", "benefits", "published", "canAccessAllChannels", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$UpdateGuildRoleSubscriptionTierListing;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "Ljava/lang/Boolean;", "getCanAccessAllChannels", "Ljava/lang/Integer;", "getPriceTier", "getImage", "getPublished", "getName", "Ljava/util/List;", "getBenefits", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateGuildRoleSubscriptionTierListing {
        private final List<GuildRoleSubscriptionBenefit> benefits;
        private final Boolean canAccessAllChannels;
        private final String description;
        private final String image;
        private final String name;
        private final Integer priceTier;
        private final Boolean published;

        public UpdateGuildRoleSubscriptionTierListing(String str, String str2, String str3, Integer num, List<GuildRoleSubscriptionBenefit> list, Boolean bool, Boolean bool2) {
            this.name = str;
            this.image = str2;
            this.description = str3;
            this.priceTier = num;
            this.benefits = list;
            this.published = bool;
            this.canAccessAllChannels = bool2;
        }

        public static /* synthetic */ UpdateGuildRoleSubscriptionTierListing copy$default(UpdateGuildRoleSubscriptionTierListing updateGuildRoleSubscriptionTierListing, String str, String str2, String str3, Integer num, List list, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateGuildRoleSubscriptionTierListing.name;
            }
            if ((i & 2) != 0) {
                str2 = updateGuildRoleSubscriptionTierListing.image;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = updateGuildRoleSubscriptionTierListing.description;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                num = updateGuildRoleSubscriptionTierListing.priceTier;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                list = updateGuildRoleSubscriptionTierListing.benefits;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                bool = updateGuildRoleSubscriptionTierListing.published;
            }
            Boolean bool3 = bool;
            if ((i & 64) != 0) {
                bool2 = updateGuildRoleSubscriptionTierListing.canAccessAllChannels;
            }
            return updateGuildRoleSubscriptionTierListing.copy(str, str4, str5, num2, list2, bool3, bool2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getPriceTier() {
            return this.priceTier;
        }

        public final List<GuildRoleSubscriptionBenefit> component5() {
            return this.benefits;
        }

        /* renamed from: component6, reason: from getter */
        public final Boolean getPublished() {
            return this.published;
        }

        /* renamed from: component7, reason: from getter */
        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final UpdateGuildRoleSubscriptionTierListing copy(String name, String image, String description, Integer priceTier, List<GuildRoleSubscriptionBenefit> benefits, Boolean published, Boolean canAccessAllChannels) {
            return new UpdateGuildRoleSubscriptionTierListing(name, image, description, priceTier, benefits, published, canAccessAllChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionTierListing)) {
                return false;
            }
            UpdateGuildRoleSubscriptionTierListing updateGuildRoleSubscriptionTierListing = (UpdateGuildRoleSubscriptionTierListing) other;
            return Intrinsics3.areEqual(this.name, updateGuildRoleSubscriptionTierListing.name) && Intrinsics3.areEqual(this.image, updateGuildRoleSubscriptionTierListing.image) && Intrinsics3.areEqual(this.description, updateGuildRoleSubscriptionTierListing.description) && Intrinsics3.areEqual(this.priceTier, updateGuildRoleSubscriptionTierListing.priceTier) && Intrinsics3.areEqual(this.benefits, updateGuildRoleSubscriptionTierListing.benefits) && Intrinsics3.areEqual(this.published, updateGuildRoleSubscriptionTierListing.published) && Intrinsics3.areEqual(this.canAccessAllChannels, updateGuildRoleSubscriptionTierListing.canAccessAllChannels);
        }

        public final List<GuildRoleSubscriptionBenefit> getBenefits() {
            return this.benefits;
        }

        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getPriceTier() {
            return this.priceTier;
        }

        public final Boolean getPublished() {
            return this.published;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.priceTier;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            List<GuildRoleSubscriptionBenefit> list = this.benefits;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool = this.published;
            int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
            Boolean bool2 = this.canAccessAllChannels;
            return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateGuildRoleSubscriptionTierListing(name=");
            sbU.append(this.name);
            sbU.append(", image=");
            sbU.append(this.image);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", priceTier=");
            sbU.append(this.priceTier);
            sbU.append(", benefits=");
            sbU.append(this.benefits);
            sbU.append(", published=");
            sbU.append(this.published);
            sbU.append(", canAccessAllChannels=");
            return outline.D(sbU, this.canAccessAllChannels, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b>\u0010?J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u001c\u0010\u000e\u001a\u000e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0098\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010 \u001a\u000e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b0\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b1\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\bR%\u0010 \u001a\u000e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\u000fR\u001b\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b7\u0010\u0012R\u001b\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b9\u0010\u0017R\u001b\u0010$\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\b;\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b<\u0010\u0004R!\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00104\u001a\u0004\b=\u0010\u000f¨\u0006@"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateGuildScheduledEventBody;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component3", "()Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component4", "component5", "Lcom/discord/nullserializable/NullSerializable;", "", "Lcom/discord/primitives/ChannelId;", "component6", "()Lcom/discord/nullserializable/NullSerializable;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "component7", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "component8", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;", "component9", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;", "", "component10", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "privacyLevel", "scheduledStartTime", "scheduledEndTime", "channelId", "entityType", "entityMetadata", "status", "broadcastToDirectoryChannels", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;Ljava/lang/String;Ljava/lang/String;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$UpdateGuildScheduledEventBody;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getScheduledStartTime", "getDescription", "getScheduledEndTime", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "getPrivacyLevel", "Lcom/discord/nullserializable/NullSerializable;", "getChannelId", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "getEntityType", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;", "getStatus", "Ljava/lang/Boolean;", "getBroadcastToDirectoryChannels", "getName", "getEntityMetadata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;Ljava/lang/String;Ljava/lang/String;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateGuildScheduledEventBody {
        private final Boolean broadcastToDirectoryChannels;
        private final NullSerializable<Long> channelId;
        private final String description;
        private final NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata;
        private final GuildScheduledEventEntityType entityType;
        private final String name;
        private final StageInstancePrivacyLevel privacyLevel;
        private final String scheduledEndTime;
        private final String scheduledStartTime;
        private final GuildScheduledEventStatus status;

        public UpdateGuildScheduledEventBody() {
            this(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
        }

        public UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable<Long> nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool) {
            this.name = str;
            this.description = str2;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.scheduledStartTime = str3;
            this.scheduledEndTime = str4;
            this.channelId = nullSerializable;
            this.entityType = guildScheduledEventEntityType;
            this.entityMetadata = nullSerializable2;
            this.status = guildScheduledEventStatus;
            this.broadcastToDirectoryChannels = bool;
        }

        public static /* synthetic */ UpdateGuildScheduledEventBody copy$default(UpdateGuildScheduledEventBody updateGuildScheduledEventBody, String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool, int i, Object obj) {
            return updateGuildScheduledEventBody.copy((i & 1) != 0 ? updateGuildScheduledEventBody.name : str, (i & 2) != 0 ? updateGuildScheduledEventBody.description : str2, (i & 4) != 0 ? updateGuildScheduledEventBody.privacyLevel : stageInstancePrivacyLevel, (i & 8) != 0 ? updateGuildScheduledEventBody.scheduledStartTime : str3, (i & 16) != 0 ? updateGuildScheduledEventBody.scheduledEndTime : str4, (i & 32) != 0 ? updateGuildScheduledEventBody.channelId : nullSerializable, (i & 64) != 0 ? updateGuildScheduledEventBody.entityType : guildScheduledEventEntityType, (i & 128) != 0 ? updateGuildScheduledEventBody.entityMetadata : nullSerializable2, (i & 256) != 0 ? updateGuildScheduledEventBody.status : guildScheduledEventStatus, (i & 512) != 0 ? updateGuildScheduledEventBody.broadcastToDirectoryChannels : bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component10, reason: from getter */
        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* renamed from: component4, reason: from getter */
        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        /* renamed from: component5, reason: from getter */
        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final NullSerializable<Long> component6() {
            return this.channelId;
        }

        /* renamed from: component7, reason: from getter */
        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final NullSerializable<GuildScheduledEventEntityMetadata> component8() {
            return this.entityMetadata;
        }

        /* renamed from: component9, reason: from getter */
        public final GuildScheduledEventStatus getStatus() {
            return this.status;
        }

        public final UpdateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, NullSerializable<Long> channelId, GuildScheduledEventEntityType entityType, NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata, GuildScheduledEventStatus status, Boolean broadcastToDirectoryChannels) {
            return new UpdateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, status, broadcastToDirectoryChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildScheduledEventBody)) {
                return false;
            }
            UpdateGuildScheduledEventBody updateGuildScheduledEventBody = (UpdateGuildScheduledEventBody) other;
            return Intrinsics3.areEqual(this.name, updateGuildScheduledEventBody.name) && Intrinsics3.areEqual(this.description, updateGuildScheduledEventBody.description) && Intrinsics3.areEqual(this.privacyLevel, updateGuildScheduledEventBody.privacyLevel) && Intrinsics3.areEqual(this.scheduledStartTime, updateGuildScheduledEventBody.scheduledStartTime) && Intrinsics3.areEqual(this.scheduledEndTime, updateGuildScheduledEventBody.scheduledEndTime) && Intrinsics3.areEqual(this.channelId, updateGuildScheduledEventBody.channelId) && Intrinsics3.areEqual(this.entityType, updateGuildScheduledEventBody.entityType) && Intrinsics3.areEqual(this.entityMetadata, updateGuildScheduledEventBody.entityMetadata) && Intrinsics3.areEqual(this.status, updateGuildScheduledEventBody.status) && Intrinsics3.areEqual(this.broadcastToDirectoryChannels, updateGuildScheduledEventBody.broadcastToDirectoryChannels);
        }

        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final NullSerializable<Long> getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final NullSerializable<GuildScheduledEventEntityMetadata> getEntityMetadata() {
            return this.entityMetadata;
        }

        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final String getName() {
            return this.name;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        public final GuildScheduledEventStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode3 = (iHashCode2 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            String str3 = this.scheduledStartTime;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.scheduledEndTime;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            NullSerializable<Long> nullSerializable = this.channelId;
            int iHashCode6 = (iHashCode5 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
            GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
            int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
            NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2 = this.entityMetadata;
            int iHashCode8 = (iHashCode7 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
            GuildScheduledEventStatus guildScheduledEventStatus = this.status;
            int iHashCode9 = (iHashCode8 + (guildScheduledEventStatus != null ? guildScheduledEventStatus.hashCode() : 0)) * 31;
            Boolean bool = this.broadcastToDirectoryChannels;
            return iHashCode9 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateGuildScheduledEventBody(name=");
            sbU.append(this.name);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", privacyLevel=");
            sbU.append(this.privacyLevel);
            sbU.append(", scheduledStartTime=");
            sbU.append(this.scheduledStartTime);
            sbU.append(", scheduledEndTime=");
            sbU.append(this.scheduledEndTime);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", entityType=");
            sbU.append(this.entityType);
            sbU.append(", entityMetadata=");
            sbU.append(this.entityMetadata);
            sbU.append(", status=");
            sbU.append(this.status);
            sbU.append(", broadcastToDirectoryChannels=");
            return outline.D(sbU, this.broadcastToDirectoryChannels, ")");
        }

        public /* synthetic */ UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : stageInstancePrivacyLevel, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? null : guildScheduledEventEntityType, (i & 128) != 0 ? null : nullSerializable2, (i & 256) != 0 ? null : guildScheduledEventStatus, (i & 512) == 0 ? bool : null);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateStageInstanceBody;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "component2", "()Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "privacyLevel", "copy", "(Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;)Lcom/discord/restapi/RestAPIParams$UpdateStageInstanceBody;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "getPrivacyLevel", "Ljava/lang/String;", "getTopic", "<init>", "(Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateStageInstanceBody {
        private final StageInstancePrivacyLevel privacyLevel;
        private final String topic;

        public UpdateStageInstanceBody() {
            this(null, null, 3, null);
        }

        public UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel) {
            this.topic = str;
            this.privacyLevel = stageInstancePrivacyLevel;
        }

        public static /* synthetic */ UpdateStageInstanceBody copy$default(UpdateStageInstanceBody updateStageInstanceBody, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateStageInstanceBody.topic;
            }
            if ((i & 2) != 0) {
                stageInstancePrivacyLevel = updateStageInstanceBody.privacyLevel;
            }
            return updateStageInstanceBody.copy(str, stageInstancePrivacyLevel);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* renamed from: component2, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final UpdateStageInstanceBody copy(String topic, StageInstancePrivacyLevel privacyLevel) {
            return new UpdateStageInstanceBody(topic, privacyLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateStageInstanceBody)) {
                return false;
            }
            UpdateStageInstanceBody updateStageInstanceBody = (UpdateStageInstanceBody) other;
            return Intrinsics3.areEqual(this.topic, updateStageInstanceBody.topic) && Intrinsics3.areEqual(this.privacyLevel, updateStageInstanceBody.privacyLevel);
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getTopic() {
            return this.topic;
        }

        public int hashCode() {
            String str = this.topic;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            return iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateStageInstanceBody(topic=");
            sbU.append(this.topic);
            sbU.append(", privacyLevel=");
            sbU.append(this.privacyLevel);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : stageInstancePrivacyLevel);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UpdateSubscription;", "", "", "status", "Ljava/lang/Integer;", "", "paymentSourceId", "Ljava/lang/String;", "", "Lcom/discord/primitives/PlanId;", "planId", "Ljava/lang/Long;", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionAdditionalPlan;", "additionalPlans", "Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateSubscription {
        private final List<ModelSubscription.SubscriptionAdditionalPlan> additionalPlans;
        private final String paymentSourceId;
        private final Long planId;
        private final Integer status;

        public UpdateSubscription() {
            this(null, null, null, null, 15, null);
        }

        public UpdateSubscription(Integer num, String str, Long l, List<ModelSubscription.SubscriptionAdditionalPlan> list) {
            this.status = num;
            this.paymentSourceId = str;
            this.planId = l;
            this.additionalPlans = list;
        }

        public /* synthetic */ UpdateSubscription(Integer num, String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : list);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UploadContacts;", "", "", "background", "Z", "", "Lcom/discord/restapi/RestAPIParams$ContactEntry;", "friend_list_entries", "Ljava/util/List;", "Lcom/discord/api/friendsuggestions/AllowedInSuggestionsType;", "set_use_for_suggestions", "Lcom/discord/api/friendsuggestions/AllowedInSuggestionsType;", "<init>", "(Ljava/util/List;ZLcom/discord/api/friendsuggestions/AllowedInSuggestionsType;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UploadContacts {
        private final boolean background;
        private final List<ContactEntry> friend_list_entries;
        private final AllowedInSuggestionsType set_use_for_suggestions;

        public UploadContacts(List<ContactEntry> list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType) {
            Intrinsics3.checkNotNullParameter(list, "friend_list_entries");
            this.friend_list_entries = list;
            this.background = z2;
            this.set_use_for_suggestions = allowedInSuggestionsType;
        }

        public /* synthetic */ UploadContacts(List list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z2, (i & 4) != 0 ? AllowedInSuggestionsType.DISABLED : allowedInSuggestionsType);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\tB+\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserAgreements;", "", "", "acknowledgment", "Ljava/lang/Boolean;", "terms", "privacy", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserAgreements {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean acknowledgment;
        private final Boolean privacy;
        private final Boolean terms;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserAgreements$Companion;", "", "Lcom/discord/restapi/RestAPIParams$UserAgreements;", "acknowledge", "()Lcom/discord/restapi/RestAPIParams$UserAgreements;", "agree", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final UserAgreements acknowledge() {
                return new UserAgreements(null, null, Boolean.TRUE, 3, null);
            }

            public final UserAgreements agree() {
                Boolean bool = Boolean.TRUE;
                return new UserAgreements(bool, bool, null, 4, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserAgreements() {
            this(null, null, null, 7, null);
        }

        public UserAgreements(Boolean bool, Boolean bool2, Boolean bool3) {
            this.terms = bool;
            this.privacy = bool2;
            this.acknowledgment = bool3;
        }

        public /* synthetic */ UserAgreements(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\f\u001a\u00020\u00002\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserBulkRelationship;", "", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "user_ids", "token", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$UserBulkRelationship;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserBulkRelationship {
        private final String token;
        private final List<Long> user_ids;

        public UserBulkRelationship(List<Long> list, String str) {
            Intrinsics3.checkNotNullParameter(list, "user_ids");
            Intrinsics3.checkNotNullParameter(str, "token");
            this.user_ids = list;
            this.token = str;
        }

        private final List<Long> component1() {
            return this.user_ids;
        }

        /* renamed from: component2, reason: from getter */
        private final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserBulkRelationship copy$default(UserBulkRelationship userBulkRelationship, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userBulkRelationship.user_ids;
            }
            if ((i & 2) != 0) {
                str = userBulkRelationship.token;
            }
            return userBulkRelationship.copy(list, str);
        }

        public final UserBulkRelationship copy(List<Long> user_ids, String token) {
            Intrinsics3.checkNotNullParameter(user_ids, "user_ids");
            Intrinsics3.checkNotNullParameter(token, "token");
            return new UserBulkRelationship(user_ids, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserBulkRelationship)) {
                return false;
            }
            UserBulkRelationship userBulkRelationship = (UserBulkRelationship) other;
            return Intrinsics3.areEqual(this.user_ids, userBulkRelationship.user_ids) && Intrinsics3.areEqual(this.token, userBulkRelationship.token);
        }

        public int hashCode() {
            List<Long> list = this.user_ids;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.token;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserBulkRelationship(user_ids=");
            sbU.append(this.user_ids);
            sbU.append(", token=");
            return outline.J(sbU, this.token, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserDevices;", "", "", "provider", "Ljava/lang/String;", "token", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserDevices {
        private final String provider = "gcm";
        private final String token;

        public UserDevices(String str) {
            this.token = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserEmailConfirmCode;", "", "", "component1", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_CODE, "copy", "(Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$UserEmailConfirmCode;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserEmailConfirmCode {
        private final String code;

        public UserEmailConfirmCode(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.code = str;
        }

        public static /* synthetic */ UserEmailConfirmCode copy$default(UserEmailConfirmCode userEmailConfirmCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userEmailConfirmCode.code;
            }
            return userEmailConfirmCode.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        public final UserEmailConfirmCode copy(String code) {
            Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            return new UserEmailConfirmCode(code);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserEmailConfirmCode) && Intrinsics3.areEqual(this.code, ((UserEmailConfirmCode) other).code);
            }
            return true;
        }

        public final String getCode() {
            return this.code;
        }

        public int hashCode() {
            String str = this.code;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("UserEmailConfirmCode(code="), this.code, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001&Bs\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b \u0010!B\u001d\b\u0016\u0012\n\u0010#\u001a\u00060\bj\u0002`\"\u0012\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b \u0010%R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R'\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016¨\u0006'"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserGuildSettings;", "", "", "mobilePush", "Ljava/lang/Boolean;", "getMobilePush", "()Ljava/lang/Boolean;", "", "", "Lcom/discord/restapi/RestAPIParams$UserGuildSettings$ChannelOverride;", "channelOverrides", "Ljava/util/Map;", "getChannelOverrides", "()Ljava/util/Map;", "suppressRoles", "getSuppressRoles", "suppressEveryone", "getSuppressEveryone", "", "messageNotifications", "Ljava/lang/Integer;", "getMessageNotifications", "()Ljava/lang/Integer;", "Lcom/discord/models/domain/ModelMuteConfig;", "muteConfig", "Lcom/discord/models/domain/ModelMuteConfig;", "getMuteConfig", "()Lcom/discord/models/domain/ModelMuteConfig;", "muted", "getMuted", "notifyHighlights", "getNotifyHighlights", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/discord/models/domain/ModelMuteConfig;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Integer;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "channelOverride", "(JLcom/discord/restapi/RestAPIParams$UserGuildSettings$ChannelOverride;)V", "ChannelOverride", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserGuildSettings {
        private final Map<Long, ChannelOverride> channelOverrides;
        private final Integer messageNotifications;
        private final Boolean mobilePush;
        private final ModelMuteConfig muteConfig;
        private final Boolean muted;
        private final Integer notifyHighlights;
        private final Boolean suppressEveryone;
        private final Boolean suppressRoles;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B3\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014B\u001d\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0015R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserGuildSettings$ChannelOverride;", "", "", "flags", "Ljava/lang/Integer;", "getFlags", "()Ljava/lang/Integer;", "Lcom/discord/models/domain/ModelMuteConfig;", "muteConfig", "Lcom/discord/models/domain/ModelMuteConfig;", "getMuteConfig", "()Lcom/discord/models/domain/ModelMuteConfig;", "", "muted", "Ljava/lang/Boolean;", "getMuted", "()Ljava/lang/Boolean;", "messageNotifications", "getMessageNotifications", "<init>", "(Ljava/lang/Boolean;Lcom/discord/models/domain/ModelMuteConfig;Ljava/lang/Integer;Ljava/lang/Integer;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class ChannelOverride {
            private final Integer flags;
            private final Integer messageNotifications;
            private final ModelMuteConfig muteConfig;
            private final Boolean muted;

            public ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2) {
                this.muted = bool;
                this.muteConfig = modelMuteConfig;
                this.messageNotifications = num;
                this.flags = num2;
            }

            public final Integer getFlags() {
                return this.flags;
            }

            public final Integer getMessageNotifications() {
                return this.messageNotifications;
            }

            public final ModelMuteConfig getMuteConfig() {
                return this.muteConfig;
            }

            public final Boolean getMuted() {
                return this.muted;
            }

            public /* synthetic */ ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(bool, modelMuteConfig, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
            }

            public ChannelOverride(Integer num, Integer num2) {
                this(null, null, num, num2);
            }
        }

        public UserGuildSettings() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map<Long, ChannelOverride> map, Integer num2) {
            this.suppressEveryone = bool;
            this.suppressRoles = bool2;
            this.muted = bool3;
            this.muteConfig = modelMuteConfig;
            this.mobilePush = bool4;
            this.messageNotifications = num;
            this.channelOverrides = map;
            this.notifyHighlights = num2;
        }

        public final Map<Long, ChannelOverride> getChannelOverrides() {
            return this.channelOverrides;
        }

        public final Integer getMessageNotifications() {
            return this.messageNotifications;
        }

        public final Boolean getMobilePush() {
            return this.mobilePush;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final Boolean getMuted() {
            return this.muted;
        }

        public final Integer getNotifyHighlights() {
            return this.notifyHighlights;
        }

        public final Boolean getSuppressEveryone() {
            return this.suppressEveryone;
        }

        public final Boolean getSuppressRoles() {
            return this.suppressRoles;
        }

        public /* synthetic */ UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map map, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : modelMuteConfig, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : map, (i & 128) == 0 ? num2 : null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public UserGuildSettings(long j, ChannelOverride channelOverride) {
            this(null, null, null, null, null, null, MapsJVM.mapOf(Tuples.to(Long.valueOf(j), channelOverride)), null, Opcodes.ATHROW, null);
            Intrinsics3.checkNotNullParameter(channelOverride, "channelOverride");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserNoteUpdate;", "", "", "component1", "()Ljava/lang/String;", "note", "copy", "(Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$UserNoteUpdate;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserNoteUpdate {
        private final String note;

        public UserNoteUpdate(String str) {
            this.note = str;
        }

        /* renamed from: component1, reason: from getter */
        private final String getNote() {
            return this.note;
        }

        public static /* synthetic */ UserNoteUpdate copy$default(UserNoteUpdate userNoteUpdate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userNoteUpdate.note;
            }
            return userNoteUpdate.copy(str);
        }

        public final UserNoteUpdate copy(String note) {
            return new UserNoteUpdate(note);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserNoteUpdate) && Intrinsics3.areEqual(this.note, ((UserNoteUpdate) other).note);
            }
            return true;
        }

        public int hashCode() {
            String str = this.note;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("UserNoteUpdate(note="), this.note, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\fB/\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserRelationship;", "", "", "captchaRqtoken", "Ljava/lang/String;", "", "type", "Ljava/lang/Integer;", "friendToken", "captchaKey", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Add", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRelationship {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String friendToken;
        private final Integer type;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserRelationship$Add;", "", "", "captchaKey", "Ljava/lang/String;", "captchaRqtoken", "", "discriminator", "I", "username", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Add {
            private final String captchaKey;
            private final String captchaRqtoken;
            private final int discriminator;
            private final String username;

            public Add(String str, int i, String str2, String str3) {
                Intrinsics3.checkNotNullParameter(str, "username");
                this.username = str;
                this.discriminator = i;
                this.captchaKey = str2;
                this.captchaRqtoken = str3;
            }
        }

        public UserRelationship(Integer num, String str, String str2, String str3) {
            this.type = num;
            this.friendToken = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0002#$Bù\u0001\b\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserSettings;", "", "", "contactSyncEnabled", "Ljava/lang/Boolean;", "renderEmbeds", "", "locale", "Ljava/lang/String;", "", "explicitContentFilter", "Ljava/lang/Integer;", "allowAccessibilityDetection", "defaultGuildsRestricted", "inlineAttachmentMedia", "", "Lcom/discord/models/domain/ModelGuildFolder;", "guildFolders", "Ljava/util/Collection;", "Lcom/discord/restapi/RestAPIParams$UserSettings$FriendSourceFlags;", "friendSourceFlags", "Lcom/discord/restapi/RestAPIParams$UserSettings$FriendSourceFlags;", "animateStickers", "", "restrictedGuilds", "theme", "status", "showCurrentGame", "friendDiscoveryFlags", "inlineEmbedMedia", "developerMode", "blockedMessageBar", "animateEmoji", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Collection;Ljava/lang/Boolean;Lcom/discord/restapi/RestAPIParams$UserSettings$FriendSourceFlags;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "Companion", "FriendSourceFlags", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserSettings {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean allowAccessibilityDetection;
        private final Boolean animateEmoji;
        private final Integer animateStickers;
        private final Boolean blockedMessageBar;
        private final Boolean contactSyncEnabled;
        private final Boolean defaultGuildsRestricted;
        private final Boolean developerMode;
        private final Integer explicitContentFilter;
        private final Integer friendDiscoveryFlags;
        private final FriendSourceFlags friendSourceFlags;
        private final Collection<ModelGuildFolder> guildFolders;
        private final Boolean inlineAttachmentMedia;
        private final Boolean inlineEmbedMedia;
        private final String locale;
        private final Boolean renderEmbeds;
        private final Collection<Long> restrictedGuilds;
        private final Boolean showCurrentGame;
        private final String status;
        private final String theme;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\"\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0007¢\u0006\u0004\b\"\u0010#J-\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0007H\u0007¢\u0006\u0004\b.\u0010\nJ\u0019\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b3\u00101J\u0019\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\b8\u00106J\u000f\u00109\u001a\u00020\u0004H\u0007¢\u0006\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserSettings$Companion;", "", "", "theme", "Lcom/discord/restapi/RestAPIParams$UserSettings;", "createWithTheme", "(Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "", "developerMode", "createWithDeveloperMode", "(Z)Lcom/discord/restapi/RestAPIParams$UserSettings;", "renderEmbeds", "createWithRenderEmbeds", "inlineEmbedMedia", "createWithInlineEmbedMedia", "inlineAttachmentMedia", "createWithInlineAttachmentMedia", "blockedMessageBar", "createWithBlockedMessageBar", "locale", "createWithLocale", "Lcom/discord/api/presence/ClientStatus;", "status", "createWithStatus", "(Lcom/discord/api/presence/ClientStatus;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "", "Lcom/discord/models/domain/ModelGuildFolder;", "guildFolders", "createWithGuildFolders", "(Ljava/util/List;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "defaultGuildsRestricted", "", "", "restrictedGuilds", "createWithRestrictedGuilds", "(Ljava/lang/Boolean;Ljava/util/Collection;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "all", "mutualGuilds", "mutualFriends", "createWithFriendSourceFlags", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "", "explicitContentFilter", "createWithExplicitContentFilter", "(I)Lcom/discord/restapi/RestAPIParams$UserSettings;", "showCurrentGame", "createWithShowCurrentGame", "allowAnimatedEmojis", "createWithAllowAnimatedEmojis", "(Ljava/lang/Boolean;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "allowAccessibilityDetection", "createWithAllowAccessibilityDetection", "stickerAnimationSettings", "createWithStickerAnimationSettings", "(Ljava/lang/Integer;)Lcom/discord/restapi/RestAPIParams$UserSettings;", "friendDiscoveryFlags", "createWithFriendDiscoveryFlags", "createWithContactSyncUpsellShown", "()Lcom/discord/restapi/RestAPIParams$UserSettings;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final UserSettings createWithAllowAccessibilityDetection(Boolean allowAccessibilityDetection) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAccessibilityDetection, null, null, null, 491519, null);
            }

            public final UserSettings createWithAllowAnimatedEmojis(Boolean allowAnimatedEmojis) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAnimatedEmojis, null, null, null, null, 507903, null);
            }

            public final UserSettings createWithBlockedMessageBar(boolean blockedMessageBar) {
                return new UserSettings(null, null, null, null, null, Boolean.valueOf(blockedMessageBar), null, null, null, null, null, null, null, null, null, null, null, null, null, 524255, null);
            }

            public final UserSettings createWithContactSyncUpsellShown() {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, 393215, null);
            }

            public final UserSettings createWithDeveloperMode(boolean developerMode) {
                return new UserSettings(null, Boolean.valueOf(developerMode), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524285, null);
            }

            public final UserSettings createWithExplicitContentFilter(int explicitContentFilter) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(explicitContentFilter), null, null, null, null, null, 516095, null);
            }

            public final UserSettings createWithFriendDiscoveryFlags(Integer friendDiscoveryFlags) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, friendDiscoveryFlags, 262143, null);
            }

            public final UserSettings createWithFriendSourceFlags(Boolean all, Boolean mutualGuilds, Boolean mutualFriends) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, new FriendSourceFlags(all, mutualGuilds, mutualFriends), null, null, null, null, null, null, 520191, null);
            }

            public final UserSettings createWithGuildFolders(List<ModelGuildFolder> guildFolders) {
                Intrinsics3.checkNotNullParameter(guildFolders, "guildFolders");
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, guildFolders, null, null, null, null, null, null, null, null, 523263, null);
            }

            public final UserSettings createWithInlineAttachmentMedia(boolean inlineAttachmentMedia) {
                return new UserSettings(null, null, null, null, Boolean.valueOf(inlineAttachmentMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524271, null);
            }

            public final UserSettings createWithInlineEmbedMedia(boolean inlineEmbedMedia) {
                return new UserSettings(null, null, null, Boolean.valueOf(inlineEmbedMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524279, null);
            }

            public final UserSettings createWithLocale(String locale) {
                Intrinsics3.checkNotNullParameter(locale, "locale");
                return new UserSettings(null, null, null, null, null, null, locale, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
            }

            public final UserSettings createWithRenderEmbeds(boolean renderEmbeds) {
                return new UserSettings(null, null, Boolean.valueOf(renderEmbeds), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null);
            }

            public final UserSettings createWithRestrictedGuilds(Boolean defaultGuildsRestricted, Collection<Long> restrictedGuilds) {
                return new UserSettings(null, null, null, null, null, null, null, restrictedGuilds, null, null, null, defaultGuildsRestricted, null, null, null, null, null, null, null, 522111, null);
            }

            public final UserSettings createWithShowCurrentGame(boolean showCurrentGame) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, Boolean.valueOf(showCurrentGame), null, null, null, null, null, null, null, null, null, 523775, null);
            }

            public final UserSettings createWithStatus(ClientStatus status) {
                Intrinsics3.checkNotNullParameter(status, "status");
                String strName = status.name();
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return new UserSettings(null, null, null, null, null, null, null, null, lowerCase, null, null, null, null, null, null, null, null, null, null, 524031, null);
            }

            public final UserSettings createWithStickerAnimationSettings(Integer stickerAnimationSettings) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, stickerAnimationSettings, null, null, 458751, null);
            }

            public final UserSettings createWithTheme(String theme) {
                Intrinsics3.checkNotNullParameter(theme, "theme");
                return new UserSettings(theme, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524286, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserSettings$FriendSourceFlags;", "", "", "all", "Ljava/lang/Boolean;", "mutualGuilds", "mutualFriends", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class FriendSourceFlags {
            private final Boolean all;
            private final Boolean mutualFriends;
            private final Boolean mutualGuilds;

            public FriendSourceFlags(Boolean bool, Boolean bool2, Boolean bool3) {
                this.all = bool;
                this.mutualGuilds = bool2;
                this.mutualFriends = bool3;
            }
        }

        private UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection<Long> collection, String str3, Boolean bool6, Collection<ModelGuildFolder> collection2, Boolean bool7, FriendSourceFlags friendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3) {
            this.theme = str;
            this.developerMode = bool;
            this.renderEmbeds = bool2;
            this.inlineEmbedMedia = bool3;
            this.inlineAttachmentMedia = bool4;
            this.blockedMessageBar = bool5;
            this.locale = str2;
            this.restrictedGuilds = collection;
            this.status = str3;
            this.showCurrentGame = bool6;
            this.guildFolders = collection2;
            this.defaultGuildsRestricted = bool7;
            this.friendSourceFlags = friendSourceFlags;
            this.explicitContentFilter = num;
            this.animateEmoji = bool8;
            this.allowAccessibilityDetection = bool9;
            this.animateStickers = num2;
            this.contactSyncEnabled = bool10;
            this.friendDiscoveryFlags = num3;
        }

        public static final UserSettings createWithAllowAccessibilityDetection(Boolean bool) {
            return INSTANCE.createWithAllowAccessibilityDetection(bool);
        }

        public static final UserSettings createWithAllowAnimatedEmojis(Boolean bool) {
            return INSTANCE.createWithAllowAnimatedEmojis(bool);
        }

        public static final UserSettings createWithBlockedMessageBar(boolean z2) {
            return INSTANCE.createWithBlockedMessageBar(z2);
        }

        public static final UserSettings createWithContactSyncUpsellShown() {
            return INSTANCE.createWithContactSyncUpsellShown();
        }

        public static final UserSettings createWithDeveloperMode(boolean z2) {
            return INSTANCE.createWithDeveloperMode(z2);
        }

        public static final UserSettings createWithExplicitContentFilter(int i) {
            return INSTANCE.createWithExplicitContentFilter(i);
        }

        public static final UserSettings createWithFriendDiscoveryFlags(Integer num) {
            return INSTANCE.createWithFriendDiscoveryFlags(num);
        }

        public static final UserSettings createWithFriendSourceFlags(Boolean bool, Boolean bool2, Boolean bool3) {
            return INSTANCE.createWithFriendSourceFlags(bool, bool2, bool3);
        }

        public static final UserSettings createWithGuildFolders(List<ModelGuildFolder> list) {
            return INSTANCE.createWithGuildFolders(list);
        }

        public static final UserSettings createWithInlineAttachmentMedia(boolean z2) {
            return INSTANCE.createWithInlineAttachmentMedia(z2);
        }

        public static final UserSettings createWithInlineEmbedMedia(boolean z2) {
            return INSTANCE.createWithInlineEmbedMedia(z2);
        }

        public static final UserSettings createWithLocale(String str) {
            return INSTANCE.createWithLocale(str);
        }

        public static final UserSettings createWithRenderEmbeds(boolean z2) {
            return INSTANCE.createWithRenderEmbeds(z2);
        }

        public static final UserSettings createWithRestrictedGuilds(Boolean bool, Collection<Long> collection) {
            return INSTANCE.createWithRestrictedGuilds(bool, collection);
        }

        public static final UserSettings createWithShowCurrentGame(boolean z2) {
            return INSTANCE.createWithShowCurrentGame(z2);
        }

        public static final UserSettings createWithStatus(ClientStatus clientStatus) {
            return INSTANCE.createWithStatus(clientStatus);
        }

        public static final UserSettings createWithStickerAnimationSettings(Integer num) {
            return INSTANCE.createWithStickerAnimationSettings(num);
        }

        public static final UserSettings createWithTheme(String str) {
            return INSTANCE.createWithTheme(str);
        }

        public /* synthetic */ UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection collection, String str3, Boolean bool6, Collection collection2, Boolean bool7, FriendSourceFlags friendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : collection, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : bool6, (i & 1024) != 0 ? null : collection2, (i & 2048) != 0 ? null : bool7, (i & 4096) != 0 ? null : friendSourceFlags, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : bool8, (i & 32768) != 0 ? null : bool9, (i & 65536) != 0 ? null : num2, (i & 131072) != 0 ? null : bool10, (i & 262144) != 0 ? null : num3);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserSettingsCustomStatus;", "", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "customStatus", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "<init>", "(Lcom/discord/models/domain/ModelCustomStatusSetting;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserSettingsCustomStatus {
        private final ModelCustomStatusSetting customStatus;

        public UserSettingsCustomStatus(ModelCustomStatusSetting modelCustomStatusSetting) {
            this.customStatus = modelCustomStatusSetting;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VanityUrl;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VanityUrl {
        private final String code;

        public VanityUrl() {
            this(null, 1, null);
        }

        public VanityUrl(String str) {
            this.code = str;
        }

        public /* synthetic */ VanityUrl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerificationCode;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationCode {
        private final String code;
        private final String phone;

        public VerificationCode(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "phone");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.phone = str;
            this.code = str2;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerificationCodeOnly;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationCodeOnly {
        private final String code;

        public VerificationCodeOnly(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.code = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerificationCodeResend;", "", "", "phone", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationCodeResend {
        private final String phone;

        public VerificationCodeResend(String str) {
            Intrinsics3.checkNotNullParameter(str, "phone");
            this.phone = str;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerificationPhoneCode;", "", "", "phoneToken", "Ljava/lang/String;", "source", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationPhoneCode {
        private final String password;
        private final String phoneToken;
        private final String source;

        public VerificationPhoneCode(String str, String str2, String str3) {
            outline.q0(str, "phoneToken", str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, str3, "source");
            this.phoneToken = str;
            this.password = str2;
            this.source = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R!\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerifyEmail;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Z", "component4", NotificationCompat.CATEGORY_EMAIL, "guildId", "allowMultipleGuilds", "useVerificationCode", "copy", "(Ljava/lang/String;Ljava/lang/Long;ZZ)Lcom/discord/restapi/RestAPIParams$VerifyEmail;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getGuildId", "Ljava/lang/String;", "getEmail", "Z", "getUseVerificationCode", "getAllowMultipleGuilds", "<init>", "(Ljava/lang/String;Ljava/lang/Long;ZZ)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerifyEmail {
        private final boolean allowMultipleGuilds;
        private final String email;
        private final Long guildId;
        private final boolean useVerificationCode;

        public VerifyEmail(String str, Long l, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            this.email = str;
            this.guildId = l;
            this.allowMultipleGuilds = z2;
            this.useVerificationCode = z3;
        }

        public static /* synthetic */ VerifyEmail copy$default(VerifyEmail verifyEmail, String str, Long l, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyEmail.email;
            }
            if ((i & 2) != 0) {
                l = verifyEmail.guildId;
            }
            if ((i & 4) != 0) {
                z2 = verifyEmail.allowMultipleGuilds;
            }
            if ((i & 8) != 0) {
                z3 = verifyEmail.useVerificationCode;
            }
            return verifyEmail.copy(str, l, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAllowMultipleGuilds() {
            return this.allowMultipleGuilds;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getUseVerificationCode() {
            return this.useVerificationCode;
        }

        public final VerifyEmail copy(String email, Long guildId, boolean allowMultipleGuilds, boolean useVerificationCode) {
            Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            return new VerifyEmail(email, guildId, allowMultipleGuilds, useVerificationCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyEmail)) {
                return false;
            }
            VerifyEmail verifyEmail = (VerifyEmail) other;
            return Intrinsics3.areEqual(this.email, verifyEmail.email) && Intrinsics3.areEqual(this.guildId, verifyEmail.guildId) && this.allowMultipleGuilds == verifyEmail.allowMultipleGuilds && this.useVerificationCode == verifyEmail.useVerificationCode;
        }

        public final boolean getAllowMultipleGuilds() {
            return this.allowMultipleGuilds;
        }

        public final String getEmail() {
            return this.email;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final boolean getUseVerificationCode() {
            return this.useVerificationCode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.guildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.allowMultipleGuilds;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.useVerificationCode;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifyEmail(email=");
            sbU.append(this.email);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", allowMultipleGuilds=");
            sbU.append(this.allowMultipleGuilds);
            sbU.append(", useVerificationCode=");
            return outline.O(sbU, this.useVerificationCode, ")");
        }

        public /* synthetic */ VerifyEmail(String str, Long l, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3);
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R!\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerifyEmailCode;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/discord/primitives/GuildId;", "component3", "()Ljava/lang/Long;", NotificationCompat.CATEGORY_EMAIL, ModelAuditLogEntry.CHANGE_KEY_CODE, "guildId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/restapi/RestAPIParams$VerifyEmailCode;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Ljava/lang/Long;", "getGuildId", "getCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerifyEmailCode {
        private final String code;
        private final String email;
        private final Long guildId;

        public VerifyEmailCode(String str, String str2, Long l) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.email = str;
            this.code = str2;
            this.guildId = l;
        }

        public static /* synthetic */ VerifyEmailCode copy$default(VerifyEmailCode verifyEmailCode, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyEmailCode.email;
            }
            if ((i & 2) != 0) {
                str2 = verifyEmailCode.code;
            }
            if ((i & 4) != 0) {
                l = verifyEmailCode.guildId;
            }
            return verifyEmailCode.copy(str, str2, l);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        public final VerifyEmailCode copy(String email, String code, Long guildId) {
            Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            return new VerifyEmailCode(email, code, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyEmailCode)) {
                return false;
            }
            VerifyEmailCode verifyEmailCode = (VerifyEmailCode) other;
            return Intrinsics3.areEqual(this.email, verifyEmailCode.email) && Intrinsics3.areEqual(this.code, verifyEmailCode.code) && Intrinsics3.areEqual(this.guildId, verifyEmailCode.guildId);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getEmail() {
            return this.email;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.code;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.guildId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifyEmailCode(email=");
            sbU.append(this.email);
            sbU.append(", code=");
            sbU.append(this.code);
            sbU.append(", guildId=");
            return outline.G(sbU, this.guildId, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR!\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "", "", "Lcom/discord/primitives/SkuId;", "component1", "()J", "Lcom/discord/primitives/PlanId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/String;", "verifiedSkuId", "subscriptionPlanId", "giftCode", "copy", "(JLjava/lang/Long;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getVerifiedSkuId", "Ljava/lang/String;", "getGiftCode", "Ljava/lang/Long;", "getSubscriptionPlanId", "<init>", "(JLjava/lang/Long;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerifyPurchaseResponse {
        private final String giftCode;
        private final Long subscriptionPlanId;
        private final long verifiedSkuId;

        public VerifyPurchaseResponse(long j, Long l, String str) {
            this.verifiedSkuId = j;
            this.subscriptionPlanId = l;
            this.giftCode = str;
        }

        public static /* synthetic */ VerifyPurchaseResponse copy$default(VerifyPurchaseResponse verifyPurchaseResponse, long j, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = verifyPurchaseResponse.verifiedSkuId;
            }
            if ((i & 2) != 0) {
                l = verifyPurchaseResponse.subscriptionPlanId;
            }
            if ((i & 4) != 0) {
                str = verifyPurchaseResponse.giftCode;
            }
            return verifyPurchaseResponse.copy(j, l, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getVerifiedSkuId() {
            return this.verifiedSkuId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGiftCode() {
            return this.giftCode;
        }

        public final VerifyPurchaseResponse copy(long verifiedSkuId, Long subscriptionPlanId, String giftCode) {
            return new VerifyPurchaseResponse(verifiedSkuId, subscriptionPlanId, giftCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyPurchaseResponse)) {
                return false;
            }
            VerifyPurchaseResponse verifyPurchaseResponse = (VerifyPurchaseResponse) other;
            return this.verifiedSkuId == verifyPurchaseResponse.verifiedSkuId && Intrinsics3.areEqual(this.subscriptionPlanId, verifyPurchaseResponse.subscriptionPlanId) && Intrinsics3.areEqual(this.giftCode, verifyPurchaseResponse.giftCode);
        }

        public final String getGiftCode() {
            return this.giftCode;
        }

        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }

        public final long getVerifiedSkuId() {
            return this.verifiedSkuId;
        }

        public int hashCode() {
            long j = this.verifiedSkuId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            Long l = this.subscriptionPlanId;
            int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.giftCode;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifyPurchaseResponse(verifiedSkuId=");
            sbU.append(this.verifiedSkuId);
            sbU.append(", subscriptionPlanId=");
            sbU.append(this.subscriptionPlanId);
            sbU.append(", giftCode=");
            return outline.J(sbU, this.giftCode, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0018\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\f\b\u0002\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u000e\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R!\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b!\u0010\u0004R!\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerifyPurchaseTokenBody;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "component3", "Lcom/discord/primitives/PaymentGatewaySkuId;", "component4", "component5", "purchaseToken", "userId", "packageName", "subscriptionSkuId", "oneTimePurchaseSkuId", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/restapi/RestAPIParams$VerifyPurchaseTokenBody;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "Ljava/lang/String;", "getPurchaseToken", "getSubscriptionSkuId", "getPackageName", "getOneTimePurchaseSkuId", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerifyPurchaseTokenBody {
        private final String oneTimePurchaseSkuId;
        private final String packageName;
        private final String purchaseToken;
        private final String subscriptionSkuId;
        private final long userId;

        public VerifyPurchaseTokenBody(String str, long j, String str2, String str3, String str4) {
            Intrinsics3.checkNotNullParameter(str, "purchaseToken");
            Intrinsics3.checkNotNullParameter(str2, "packageName");
            this.purchaseToken = str;
            this.userId = j;
            this.packageName = str2;
            this.subscriptionSkuId = str3;
            this.oneTimePurchaseSkuId = str4;
        }

        public static /* synthetic */ VerifyPurchaseTokenBody copy$default(VerifyPurchaseTokenBody verifyPurchaseTokenBody, String str, long j, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyPurchaseTokenBody.purchaseToken;
            }
            if ((i & 2) != 0) {
                j = verifyPurchaseTokenBody.userId;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str2 = verifyPurchaseTokenBody.packageName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = verifyPurchaseTokenBody.subscriptionSkuId;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = verifyPurchaseTokenBody.oneTimePurchaseSkuId;
            }
            return verifyPurchaseTokenBody.copy(str, j2, str5, str6, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        /* renamed from: component2, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getOneTimePurchaseSkuId() {
            return this.oneTimePurchaseSkuId;
        }

        public final VerifyPurchaseTokenBody copy(String purchaseToken, long userId, String packageName, String subscriptionSkuId, String oneTimePurchaseSkuId) {
            Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
            Intrinsics3.checkNotNullParameter(packageName, "packageName");
            return new VerifyPurchaseTokenBody(purchaseToken, userId, packageName, subscriptionSkuId, oneTimePurchaseSkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyPurchaseTokenBody)) {
                return false;
            }
            VerifyPurchaseTokenBody verifyPurchaseTokenBody = (VerifyPurchaseTokenBody) other;
            return Intrinsics3.areEqual(this.purchaseToken, verifyPurchaseTokenBody.purchaseToken) && this.userId == verifyPurchaseTokenBody.userId && Intrinsics3.areEqual(this.packageName, verifyPurchaseTokenBody.packageName) && Intrinsics3.areEqual(this.subscriptionSkuId, verifyPurchaseTokenBody.subscriptionSkuId) && Intrinsics3.areEqual(this.oneTimePurchaseSkuId, verifyPurchaseTokenBody.oneTimePurchaseSkuId);
        }

        public final String getOneTimePurchaseSkuId() {
            return this.oneTimePurchaseSkuId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public final long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            String str = this.purchaseToken;
            int iHashCode = str != null ? str.hashCode() : 0;
            long j = this.userId;
            int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            String str2 = this.packageName;
            int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subscriptionSkuId;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.oneTimePurchaseSkuId;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifyPurchaseTokenBody(purchaseToken=");
            sbU.append(this.purchaseToken);
            sbU.append(", userId=");
            sbU.append(this.userId);
            sbU.append(", packageName=");
            sbU.append(this.packageName);
            sbU.append(", subscriptionSkuId=");
            sbU.append(this.subscriptionSkuId);
            sbU.append(", oneTimePurchaseSkuId=");
            return outline.J(sbU, this.oneTimePurchaseSkuId, ")");
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VoiceChannel;", "", "", "rtcRegion", "Ljava/lang/String;", "", ModelAuditLogEntry.CHANGE_KEY_BITRATE, "Ljava/lang/Integer;", "type", ModelAuditLogEntry.CHANGE_KEY_TOPIC, ModelAuditLogEntry.CHANGE_KEY_NAME, "", ModelAuditLogEntry.CHANGE_KEY_NSFW, "Ljava/lang/Boolean;", "userLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class VoiceChannel {
        private final Integer bitrate;
        private final String name;
        private final Boolean nsfw;
        private final String rtcRegion;
        private final String topic;
        private final Integer type;
        private final Integer userLimit;

        public VoiceChannel(String str, String str2, Integer num, Boolean bool, Integer num2, Integer num3, String str3) {
            this.name = str;
            this.topic = str2;
            this.type = num;
            this.nsfw = bool;
            this.userLimit = num2;
            this.bitrate = num3;
            this.rtcRegion = str3;
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$CreateChannel;", "", "", "", "recipients", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "recipientId", "(J)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateChannel {
        private final List<Long> recipients;

        public CreateChannel(List<Long> list) {
            this.recipients = list == null ? Collections2.emptyList() : list;
        }

        public CreateChannel(long j) {
            this((List<Long>) CollectionsJVM.listOf(Long.valueOf(j)));
        }
    }

    /* compiled from: RestAPIParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0091\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserInfo;", "", "", "pushProvider", "Ljava/lang/String;", "avatar", "emailToken", "newPassword", "pushToken", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "username", NotificationCompat.CATEGORY_EMAIL, ModelAuditLogEntry.CHANGE_KEY_CODE, "discriminator", "", "flags", "Ljava/lang/Integer;", "Lcom/discord/primitives/UtcTimestamp;", "dateOfBirth", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String avatar;
        private final String code;
        private final String dateOfBirth;
        private final String discriminator;
        private final String email;
        private final String emailToken;
        private final Integer flags;
        private final String newPassword;
        private final String password;
        private final String pushProvider;
        private final String pushToken;
        private final String username;

        /* compiled from: RestAPIParams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RestAPIParams$UserInfo$Companion;", "", "", NotificationCompat.CATEGORY_EMAIL, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Lcom/discord/restapi/RestAPIParams$UserInfo;", "createForEmail", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/discord/restapi/RestAPIParams$UserInfo;", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final UserInfo createForEmail(CharSequence email, CharSequence password) {
                Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
                Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                return new UserInfo(null, email.toString(), null, password.toString(), null, null, null, null, null, null, null, 2037, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10) {
            this.avatar = str;
            this.email = str2;
            this.emailToken = str3;
            this.password = str4;
            this.newPassword = str5;
            this.username = str6;
            this.pushToken = str7;
            this.code = str8;
            this.discriminator = str9;
            this.flags = num;
            this.dateOfBirth = str10;
            this.pushProvider = "gcm";
        }

        public static final UserInfo createForEmail(CharSequence charSequence, CharSequence charSequence2) {
            return INSTANCE.createForEmail(charSequence, charSequence2);
        }

        public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : num, (i & 1024) == 0 ? str10 : null);
        }
    }
}
