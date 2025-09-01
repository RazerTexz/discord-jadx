package com.discord.gateway.io;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.guildjoinrequest.GuildJoinRequest3;
import com.discord.api.guildmember.GuildMemberRemove;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.presence.Presence;
import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.api.role.GuildRoleCreate;
import com.discord.api.role.GuildRoleDelete;
import com.discord.api.role.GuildRoleUpdate;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.gateway.opcodes.Opcode;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream5;
import com.discord.models.domain.ModelApplicationStream7;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Incoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/gateway/io/IncomingParser;", "Lcom/discord/models/domain/Model;", "Lcom/discord/gateway/io/Incoming;", "build", "()Lcom/discord/gateway/io/Incoming;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "", "assignField", "(Lcom/discord/models/domain/Model$JsonReader;)V", "", "seq", "Ljava/lang/Integer;", "Lkotlin/Function1;", "", "log", "Lkotlin/jvm/functions/Function1;", "type", "Ljava/lang/String;", "Lcom/discord/gateway/opcodes/Opcode;", "opcode", "Lcom/discord/gateway/opcodes/Opcode;", "", "data", "Ljava/lang/Object;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.gateway.io.IncomingParser, reason: use source file name */
/* loaded from: classes.dex */
public final class Incoming2 implements Model {
    private Object data;
    private final Function1<String, Unit> log;
    private Opcode opcode;
    private Integer seq;
    private String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.io.IncomingParser$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Opcode.values();
            int[] iArr = new int[21];
            $EnumSwitchMapping$0 = iArr;
            iArr[Opcode.HELLO.ordinal()] = 1;
            iArr[Opcode.INVALID_SESSION.ordinal()] = 2;
            iArr[Opcode.DISPATCH.ordinal()] = 3;
        }
    }

    /* compiled from: Incoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/presence/Presence;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/api/presence/Presence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.io.IncomingParser$assignField$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Presence> {
        public final /* synthetic */ Model.JsonReader $reader;

        public AnonymousClass1(Model.JsonReader jsonReader) {
            this.$reader = jsonReader;
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Presence get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Presence get() {
            return (Presence) InboundGatewayGsonParser.fromJson(this.$reader, Presence.class);
        }
    }

    /* compiled from: Incoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/domain/ModelSession;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/domain/ModelSession;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.io.IncomingParser$assignField$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Model.JsonReader.ItemFactory<ModelSession> {
        public final /* synthetic */ Model.JsonReader $reader;

        public AnonymousClass2(Model.JsonReader jsonReader) {
            this.$reader = jsonReader;
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelSession get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelSession get() {
            return (ModelSession) this.$reader.parse(new ModelSession());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Incoming2(Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "log");
        this.log = function1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0208, code lost:
    
        if (r3.equals("THREAD_CREATE") != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x020a, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.Channel.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0218, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0222, code lost:
    
        if (r3.equals("CHANNEL_RECIPIENT_ADD") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022c, code lost:
    
        if (r3.equals("MESSAGE_DELETE") != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0236, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_MESSAGE_CREATE) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0238, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.message.Message.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0248, code lost:
    
        if (r3.equals("INTERACTION_SUCCESS") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0264, code lost:
    
        if (r3.equals("CALL_UPDATE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x026e, code lost:
    
        if (r3.equals("GUILD_UPDATE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f2, code lost:
    
        if (r3.equals("GUILD_MEMBER_UPDATE") != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030e, code lost:
    
        if (r3.equals("MESSAGE_DELETE_BULK") != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0310, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelMessageDelete());
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0335, code lost:
    
        if (r3.equals("CHANNEL_UPDATE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0351, code lost:
    
        if (r3.equals("CALL_DELETE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x035a, code lost:
    
        if (r3.equals("CALL_CREATE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x035c, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelCall());
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x036f, code lost:
    
        if (r3.equals("GUILD_DELETE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0378, code lost:
    
        if (r3.equals("GUILD_CREATE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x037a, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guild.Guild.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x039c, code lost:
    
        if (r3.equals("CHANNEL_RECIPIENT_REMOVE") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x039e, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.ChannelRecipient.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03ae, code lost:
    
        if (r3.equals("CHANNEL_DELETE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03b7, code lost:
    
        if (r3.equals("CHANNEL_CREATE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03b9, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.Channel.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03c7, code lost:
    
        if (r3.equals("RELATIONSHIP_REMOVE") != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d1, code lost:
    
        if (r3.equals("STAGE_INSTANCE_UPDATE") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0417, code lost:
    
        if (r3.equals("INTERACTION_CREATE") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0419, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.interaction.InteractionStateUpdate.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x045f, code lost:
    
        if (r3.equals("MESSAGE_REACTION_ADD") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0469, code lost:
    
        if (r3.equals("STAGE_INSTANCE_DELETE") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0472, code lost:
    
        if (r3.equals("GUILD_MEMBER_ADD") != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0474, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guildmember.GuildMember.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0484, code lost:
    
        if (r3.equals("GUILD_BAN_ADD") != false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0486, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelBan());
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0499, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_STAGE_INSTANCE_CREATE) != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x049b, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.stageinstance.StageInstance.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04ab, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_RELATIONSHIP_ADD) != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04ad, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelUserRelationship());
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0516, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE_ALL") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0520, code lost:
    
        if (r3.equals("GUILD_JOIN_REQUEST_UPDATE") != false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0560, code lost:
    
        if (r3.equals("USER_CONNECTIONS_INTEGRATION_JOINING") != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0562, code lost:
    
        r7.skipValue();
        r6.data = kotlin.Unit.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x05d8, code lost:
    
        if (r3.equals("GUILD_JOIN_REQUEST_CREATE") != false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x05da, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guildjoinrequest.GuildJoinRequest2.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x05e9, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE_EMOJI") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x05eb, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.message.reaction.MessageReactionUpdate.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
    
        if (r3.equals("THREAD_UPDATE") != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0168, code lost:
    
        if (r3.equals("GUILD_BAN_REMOVE") != false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0184, code lost:
    
        if (r3.equals("INTERACTION_FAILURE") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018e, code lost:
    
        if (r3.equals("MESSAGE_UPDATE") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
    
        if (r3.equals("USER_CONNECTIONS_UPDATE") != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01db, code lost:
    
        if (r3.equals("THREAD_DELETE") != false) goto L108;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.discord.models.domain.Model
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void assignField(Model.JsonReader reader) throws IOException {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        String strNextName = reader.nextName();
        if (strNextName != null) {
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 100) {
                if (iHashCode != 3553) {
                    if (iHashCode != 115) {
                        if (iHashCode == 116 && strNextName.equals("t")) {
                            this.type = reader.nextString(this.type);
                            return;
                        }
                    } else if (strNextName.equals("s")) {
                        this.seq = reader.nextIntOrNull();
                        return;
                    }
                } else if (strNextName.equals("op")) {
                    this.opcode = Opcode.INSTANCE.fromApiInt(reader.nextInt(-1));
                    return;
                }
            } else if (strNextName.equals("d")) {
                Opcode opcode = this.opcode;
                if (opcode == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("opcode");
                }
                int iOrdinal = opcode.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal == 10) {
                        this.data = Boolean.valueOf(reader.nextBoolean(false));
                        return;
                    } else if (iOrdinal != 11) {
                        reader.skipValue();
                        return;
                    } else {
                        this.data = reader.parse(new ModelPayload.Hello());
                        return;
                    }
                }
                String str = this.type;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2137365335:
                            break;
                        case -2067017195:
                            break;
                        case -2050181436:
                            if (str.equals("GUILD_JOIN_REQUEST_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildJoinRequest3.class);
                                break;
                            }
                            break;
                        case -2026522382:
                            if (str.equals("SESSIONS_REPLACE")) {
                                this.data = reader.nextList(new AnonymousClass2(reader));
                                break;
                            }
                            break;
                        case -2002723137:
                            if (str.equals("GUILD_SCHEDULED_EVENT_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                                break;
                            }
                            break;
                        case -1985887378:
                            if (str.equals("GUILD_SCHEDULED_EVENT_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                                break;
                            }
                            break;
                        case -1967037287:
                            if (str.equals("THREAD_MEMBER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMemberUpdate.class);
                                break;
                            }
                            break;
                        case -1921449515:
                            if (str.equals("APPLICATION_COMMAND_AUTOCOMPLETE_RESPONSE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ApplicationCommandAutocompleteResult.class);
                                break;
                            }
                            break;
                        case -1893369777:
                            break;
                        case -1862771270:
                            if (str.equals("THREAD_MEMBER_LIST_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMemberListUpdate.class);
                                break;
                            }
                            break;
                        case -1825641445:
                            if (str.equals("GUILD_MEMBERS_CHUNK")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildMembersChunk.class);
                                break;
                            }
                            break;
                        case -1580624828:
                            if (str.equals("EMBEDDED_ACTIVITY_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, EmbeddedActivityInboundUpdate.class);
                                break;
                            }
                            break;
                        case -1553569310:
                            break;
                        case -1553064252:
                            break;
                        case -1533134522:
                            if (str.equals("FORUM_UNREADS")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ForumUnreads.class);
                                break;
                            }
                            break;
                        case -1489275252:
                            if (str.equals(NotificationData.TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                                break;
                            }
                            break;
                        case -1484942443:
                            if (str.equals("GUILD_SCHEDULED_EVENT_USER_REMOVE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEventUserUpdate.class);
                                break;
                            }
                            break;
                        case -1467383482:
                            if (str.equals("USER_REQUIRED_ACTION_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, UserRequiredActionUpdate.class);
                                break;
                            }
                            break;
                        case -1446088218:
                            if (str.equals("GUILD_STICKERS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildStickersUpdate.class);
                                break;
                            }
                            break;
                        case -1327124998:
                            break;
                        case -1263316859:
                            break;
                        case -1261304891:
                            break;
                        case -1248965304:
                            break;
                        case -1246481100:
                            break;
                        case -1238538557:
                            break;
                        case -1201943215:
                            if (str.equals("GUILD_MEMBER_LIST_UPDATE")) {
                                this.data = ModelGuildMemberListUpdate.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case -960563390:
                            if (str.equals("USER_NOTE_UPDATE")) {
                                this.data = ModelUserNote.Update.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case -903406451:
                            if (str.equals("PRESENCE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, Presence.class);
                                break;
                            }
                            break;
                        case -850953239:
                            break;
                        case -843352707:
                            if (str.equals("GUILD_INTEGRATIONS_UPDATE")) {
                                this.data = reader.parse(new ModelGuildIntegration.Update());
                                break;
                            }
                            break;
                        case -778017807:
                            if (str.equals("USER_SETTINGS_UPDATE")) {
                                this.data = reader.parse(new ModelUserSettings());
                                break;
                            }
                            break;
                        case -767350043:
                            if (str.equals("GUILD_APPLICATION_COMMANDS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildApplicationCommands.class);
                                break;
                            }
                            break;
                        case -749868974:
                            break;
                        case -718889877:
                            break;
                        case -675064872:
                            break;
                        case -658229113:
                            break;
                        case -548091546:
                            break;
                        case -510741638:
                            if (str.equals("TYPING_START")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, TypingUser.class);
                                break;
                            }
                            break;
                        case -273749272:
                            break;
                        case -256913513:
                            break;
                        case -233612803:
                            break;
                        case -216777044:
                            break;
                        case -207118083:
                            if (str.equals("CHANNEL_UNREAD_UPDATE")) {
                                this.data = ModelChannelUnreadUpdate.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case -161616987:
                            break;
                        case -135720355:
                            if (str.equals("GUILD_MEMBER_REMOVE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildMemberRemove.class);
                                break;
                            }
                            break;
                        case -107601202:
                            break;
                        case -45642698:
                            if (str.equals("FRIEND_SUGGESTION_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, FriendSuggestion.class);
                                break;
                            }
                            break;
                        case -39955806:
                            break;
                        case -28806939:
                            if (str.equals("FRIEND_SUGGESTION_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, FriendSuggestionDelete.class);
                                break;
                            }
                            break;
                        case 77848963:
                            if (str.equals("READY")) {
                                this.log.invoke("Ready payload data received.");
                                long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
                                this.data = reader.parse(new ModelPayload());
                                Function1<String, Unit> function1 = this.log;
                                StringBuilder sbU = outline.U("Ready payload deserialized in ");
                                sbU.append(ClockFactory.get().currentTimeMillis() - jCurrentTimeMillis);
                                sbU.append(" ms.");
                                function1.invoke(sbU.toString());
                                break;
                            }
                            break;
                        case 85547718:
                            if (str.equals("STREAM_SERVER_UPDATE")) {
                                this.data = ModelApplicationStream7.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case 151900580:
                            if (str.equals("THREAD_MEMBERS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMembersUpdate.class);
                                break;
                            }
                            break;
                        case 239698613:
                            break;
                        case 279835082:
                            break;
                        case 391412669:
                            if (str.equals("USER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, User.class);
                                break;
                            }
                            break;
                        case 789496470:
                            break;
                        case 998188116:
                            break;
                        case 1015023875:
                            break;
                        case 1190664927:
                            break;
                        case 1249854210:
                            break;
                        case 1268388049:
                            break;
                        case 1276846319:
                            if (str.equals("GUILD_EMOJIS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildEmojisUpdate.class);
                                break;
                            }
                            break;
                        case 1281125393:
                            if (str.equals("MESSAGE_ACK")) {
                                this.data = ModelReadState.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case 1285223808:
                            break;
                        case 1389895301:
                            if (str.equals("USER_GUILD_SETTINGS_UPDATE")) {
                                this.data = reader.parse(new ModelNotificationSettings());
                                break;
                            }
                            break;
                        case 1476675193:
                            if (str.equals("GUILD_ROLE_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleCreate.class);
                                break;
                            }
                            break;
                        case 1478484999:
                            break;
                        case 1493510952:
                            if (str.equals("GUILD_ROLE_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleDelete.class);
                                break;
                            }
                            break;
                        case 1511636001:
                            break;
                        case 1570092061:
                            break;
                        case 1616207515:
                            if (str.equals("STREAM_CREATE")) {
                                this.data = ModelApplicationStream3.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case 1622830784:
                            break;
                        case 1633043274:
                            if (str.equals("STREAM_DELETE")) {
                                this.data = ModelApplicationStream5.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case 1689894925:
                            if (str.equals("PRESENCES_REPLACE")) {
                                this.data = reader.nextList(new AnonymousClass1(reader));
                                break;
                            }
                            break;
                        case 1699412580:
                            if (str.equals("VOICE_STATE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, VoiceState.class);
                                break;
                            }
                            break;
                        case 1737758480:
                            if (str.equals("GUILD_SCHEDULED_EVENT_USER_ADD")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEventUserUpdate.class);
                                break;
                            }
                            break;
                        case 1781835934:
                            break;
                        case 1882183896:
                            if (str.equals("VOICE_SERVER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, VoiceServer.class);
                                break;
                            }
                            break;
                        case 1901414427:
                            if (str.equals("INTERACTION_MODAL_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, InteractionModalCreate.class);
                                break;
                            }
                            break;
                        case 1928220071:
                            if (str.equals("THREAD_LIST_SYNC")) {
                                this.data = ModelThreadListSync.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                        case 1990123078:
                            if (str.equals("GUILD_ROLE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleUpdate.class);
                                break;
                            }
                            break;
                        case 2129655400:
                            if (str.equals("STREAM_UPDATE")) {
                                this.data = ModelApplicationStream3.Parser.INSTANCE.parse(reader);
                                break;
                            }
                            break;
                    }
                }
                reader.skipValue();
                return;
            }
        }
        reader.skipValue();
    }

    public final Incoming build() {
        String str = this.type;
        Integer num = this.seq;
        Opcode opcode = this.opcode;
        if (opcode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("opcode");
        }
        return new Incoming(str, num, opcode, this.data);
    }
}
