package com.discord.api.auth;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OAuthScope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u001b\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u001b\"#$%&'()*+,-./0123456789:;<¨\u0006="}, d2 = {"Lcom/discord/api/auth/OAuthScope;", "", "", "scopeName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ActivitiesRead", "ActivitiesWrite", "ApplicationsBuildsRead", "ApplicationsBuildsUpload", "ApplicationsCommands", "ApplicationsCommandsUpdate", "ApplicationsEntitlements", "ApplicationsStoreUpdate", "Bot", "Connections", "DMChannelsRead", "Email", "GdmJoin", "Guilds", "GuildsJoin", "GuildsMembersRead", "Identify", "Invalid", "MessagesRead", "RelationshipsRead", "Rpc", "RpcActivitiesWrite", "RpcNotificationsRead", "RpcVoiceRead", "RpcVoiceWrite", "Voice", "WebhookIncoming", "Lcom/discord/api/auth/OAuthScope$Identify;", "Lcom/discord/api/auth/OAuthScope$Email;", "Lcom/discord/api/auth/OAuthScope$Connections;", "Lcom/discord/api/auth/OAuthScope$Guilds;", "Lcom/discord/api/auth/OAuthScope$GuildsJoin;", "Lcom/discord/api/auth/OAuthScope$GuildsMembersRead;", "Lcom/discord/api/auth/OAuthScope$GdmJoin;", "Lcom/discord/api/auth/OAuthScope$Rpc;", "Lcom/discord/api/auth/OAuthScope$RpcNotificationsRead;", "Lcom/discord/api/auth/OAuthScope$RpcVoiceRead;", "Lcom/discord/api/auth/OAuthScope$RpcVoiceWrite;", "Lcom/discord/api/auth/OAuthScope$RpcActivitiesWrite;", "Lcom/discord/api/auth/OAuthScope$Bot;", "Lcom/discord/api/auth/OAuthScope$WebhookIncoming;", "Lcom/discord/api/auth/OAuthScope$MessagesRead;", "Lcom/discord/api/auth/OAuthScope$ApplicationsBuildsUpload;", "Lcom/discord/api/auth/OAuthScope$ApplicationsBuildsRead;", "Lcom/discord/api/auth/OAuthScope$ApplicationsCommands;", "Lcom/discord/api/auth/OAuthScope$ApplicationsCommandsUpdate;", "Lcom/discord/api/auth/OAuthScope$ApplicationsStoreUpdate;", "Lcom/discord/api/auth/OAuthScope$ApplicationsEntitlements;", "Lcom/discord/api/auth/OAuthScope$ActivitiesRead;", "Lcom/discord/api/auth/OAuthScope$ActivitiesWrite;", "Lcom/discord/api/auth/OAuthScope$RelationshipsRead;", "Lcom/discord/api/auth/OAuthScope$Voice;", "Lcom/discord/api/auth/OAuthScope$DMChannelsRead;", "Lcom/discord/api/auth/OAuthScope$Invalid;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class OAuthScope {
    private final String scopeName;

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ActivitiesRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ActivitiesRead extends OAuthScope {
        public static final ActivitiesRead INSTANCE = new ActivitiesRead();

        public ActivitiesRead() {
            super("activities.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ActivitiesWrite;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ActivitiesWrite extends OAuthScope {
        public static final ActivitiesWrite INSTANCE = new ActivitiesWrite();

        public ActivitiesWrite() {
            super("activities.write", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsBuildsRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsBuildsRead extends OAuthScope {
        public static final ApplicationsBuildsRead INSTANCE = new ApplicationsBuildsRead();

        public ApplicationsBuildsRead() {
            super("applications.builds.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsBuildsUpload;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsBuildsUpload extends OAuthScope {
        public static final ApplicationsBuildsUpload INSTANCE = new ApplicationsBuildsUpload();

        public ApplicationsBuildsUpload() {
            super("applications.builds.upload", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsCommands;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsCommands extends OAuthScope {
        public static final ApplicationsCommands INSTANCE = new ApplicationsCommands();

        public ApplicationsCommands() {
            super("applications.commands", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsCommandsUpdate;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsCommandsUpdate extends OAuthScope {
        public static final ApplicationsCommandsUpdate INSTANCE = new ApplicationsCommandsUpdate();

        public ApplicationsCommandsUpdate() {
            super("applications.commands.update", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsEntitlements;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsEntitlements extends OAuthScope {
        public static final ApplicationsEntitlements INSTANCE = new ApplicationsEntitlements();

        public ApplicationsEntitlements() {
            super("applications.entitlements", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$ApplicationsStoreUpdate;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class ApplicationsStoreUpdate extends OAuthScope {
        public static final ApplicationsStoreUpdate INSTANCE = new ApplicationsStoreUpdate();

        public ApplicationsStoreUpdate() {
            super("applications.store.update", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Bot;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Bot extends OAuthScope {
        public static final Bot INSTANCE = new Bot();

        public Bot() {
            super("bot", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Connections;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Connections extends OAuthScope {
        public static final Connections INSTANCE = new Connections();

        public Connections() {
            super("connections", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$DMChannelsRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class DMChannelsRead extends OAuthScope {
        public static final DMChannelsRead INSTANCE = new DMChannelsRead();

        public DMChannelsRead() {
            super("dm_channels.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Email;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Email extends OAuthScope {
        public static final Email INSTANCE = new Email();

        public Email() {
            super(NotificationCompat.CATEGORY_EMAIL, null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$GdmJoin;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class GdmJoin extends OAuthScope {
        public static final GdmJoin INSTANCE = new GdmJoin();

        public GdmJoin() {
            super("gdm.join", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Guilds;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Guilds extends OAuthScope {
        public static final Guilds INSTANCE = new Guilds();

        public Guilds() {
            super("guilds", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$GuildsJoin;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class GuildsJoin extends OAuthScope {
        public static final GuildsJoin INSTANCE = new GuildsJoin();

        public GuildsJoin() {
            super("guilds.join", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$GuildsMembersRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class GuildsMembersRead extends OAuthScope {
        public static final GuildsMembersRead INSTANCE = new GuildsMembersRead();

        public GuildsMembersRead() {
            super("guilds.members.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Identify;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Identify extends OAuthScope {
        public static final Identify INSTANCE = new Identify();

        public Identify() {
            super("identify", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Invalid;", "Lcom/discord/api/auth/OAuthScope;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "rawValue", "Ljava/lang/String;", "b", "<init>", "(Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Invalid extends OAuthScope {
        private final String rawValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Invalid(String str) {
            super("invalid", null);
            Intrinsics3.checkNotNullParameter(str, "rawValue");
            this.rawValue = str;
        }

        /* renamed from: b, reason: from getter */
        public final String getRawValue() {
            return this.rawValue;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Invalid) && Intrinsics3.areEqual(this.rawValue, ((Invalid) other).rawValue);
            }
            return true;
        }

        public int hashCode() {
            String str = this.rawValue;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("Invalid(rawValue="), this.rawValue, ")");
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$MessagesRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class MessagesRead extends OAuthScope {
        public static final MessagesRead INSTANCE = new MessagesRead();

        public MessagesRead() {
            super("messages.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$RelationshipsRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class RelationshipsRead extends OAuthScope {
        public static final RelationshipsRead INSTANCE = new RelationshipsRead();

        public RelationshipsRead() {
            super("relationships.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Rpc;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Rpc extends OAuthScope {
        public static final Rpc INSTANCE = new Rpc();

        public Rpc() {
            super("rpc", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$RpcActivitiesWrite;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class RpcActivitiesWrite extends OAuthScope {
        public static final RpcActivitiesWrite INSTANCE = new RpcActivitiesWrite();

        public RpcActivitiesWrite() {
            super("rpc.activities.write", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$RpcNotificationsRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class RpcNotificationsRead extends OAuthScope {
        public static final RpcNotificationsRead INSTANCE = new RpcNotificationsRead();

        public RpcNotificationsRead() {
            super("rpc.notifications.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$RpcVoiceRead;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class RpcVoiceRead extends OAuthScope {
        public static final RpcVoiceRead INSTANCE = new RpcVoiceRead();

        public RpcVoiceRead() {
            super("rpc.voice.read", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$RpcVoiceWrite;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class RpcVoiceWrite extends OAuthScope {
        public static final RpcVoiceWrite INSTANCE = new RpcVoiceWrite();

        public RpcVoiceWrite() {
            super("rpc.voice.write", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$Voice;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Voice extends OAuthScope {
        public static final Voice INSTANCE = new Voice();

        public Voice() {
            super("voice", null);
        }
    }

    /* compiled from: OAuthScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScope$WebhookIncoming;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class WebhookIncoming extends OAuthScope {
        public static final WebhookIncoming INSTANCE = new WebhookIncoming();

        public WebhookIncoming() {
            super("webhook.incoming", null);
        }
    }

    public OAuthScope(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.scopeName = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getScopeName() {
        return this.scopeName;
    }
}
