package com.discord.utilities.message;

import android.content.Context;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.utilities.context.ContextExtensions;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MessageUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b>\u0010=J[\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010'\u001a\u00020&*\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"¢\u0006\u0004\b'\u0010(J!\u0010+\u001a\u00020*2\n\u0010)\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J%\u0010.\u001a\u00020*2\n\u0010)\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001b\u001a\u00060\u0007j\u0002`-¢\u0006\u0004\b.\u0010,R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020*0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020*0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R2\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000706j\b\u0012\u0004\u0012\u00020\u0007`78\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b8\u00109\u0012\u0004\b<\u0010=\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/discord/utilities/message/MessageUtils;", "", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "", "Lcom/discord/api/channel/ChannelRecipientNick;", "nicks", "", "getNickOrUsernames", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/List;)Ljava/util/Map;", "messageId1", "messageId2", "", "compareMessages", "(Ljava/lang/Long;Ljava/lang/Long;)I", "", "isNewer", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "Landroid/content/Context;", "context", "messageId", "getSystemMessageUserJoin", "(Landroid/content/Context;J)I", "guildName", "authorName", "Lcom/discord/api/message/role_subscription/RoleSubscriptionData;", "roleSubscriptionData", "Lkotlin/Function1;", "Lcom/discord/i18n/RenderContext;", "", "initializer", "", "getSystemMessageRoleSubscriptionPurchase", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/message/role_subscription/RoleSubscriptionData;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "meUserId", "Lcom/discord/api/sticker/StickerPartial;", "getWelcomeSticker", "(JJ)Lcom/discord/api/sticker/StickerPartial;", "Lcom/discord/primitives/MessageId;", "getRoleSubscriptionPurchaseSticker", "", "WELCOME_STICKERS", "[Lcom/discord/api/sticker/StickerPartial;", "ROLE_SUBSCRIPTION_PURCHASE_STICKERS", "", "WELCOME_MESSAGES", "[I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "SORT_BY_IDS_COMPARATOR", "Ljava/util/Comparator;", "getSORT_BY_IDS_COMPARATOR", "()Ljava/util/Comparator;", "getSORT_BY_IDS_COMPARATOR$annotations", "()V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageUtils {
    private static final StickerPartial[] ROLE_SUBSCRIPTION_PURCHASE_STICKERS;
    private static final Comparator<Long> SORT_BY_IDS_COMPARATOR;
    private static final StickerPartial[] WELCOME_STICKERS;
    public static final MessageUtils INSTANCE = new MessageUtils();
    private static final int[] WELCOME_MESSAGES = {R.string.system_message_guild_member_join_001, R.string.system_message_guild_member_join_002, R.string.system_message_guild_member_join_003, R.string.system_message_guild_member_join_004, R.string.system_message_guild_member_join_005, R.string.system_message_guild_member_join_006, R.string.system_message_guild_member_join_007, R.string.system_message_guild_member_join_008, R.string.system_message_guild_member_join_009, R.string.system_message_guild_member_join_010, R.string.system_message_guild_member_join_011, R.string.system_message_guild_member_join_012, R.string.system_message_guild_member_join_013};

    /* compiled from: MessageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.message.MessageUtils$getSystemMessageRoleSubscriptionPurchase$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        }
    }

    static {
        StickerFormatType stickerFormatType = StickerFormatType.LOTTIE;
        StickerFormatType stickerFormatType2 = StickerFormatType.APNG;
        WELCOME_STICKERS = new StickerPartial[]{new StickerPartial(749054660769218631L, stickerFormatType, "Wumpus waves hello"), new StickerPartial(751606379340365864L, stickerFormatType, "Nelly peeks around a wall and waves hello"), new StickerPartial(754108890559283200L, stickerFormatType, "Clyde cheerfully waving"), new StickerPartial(781291131828699156L, stickerFormatType2, "Choco waves in greeting"), new StickerPartial(816087792291282944L, stickerFormatType, "Doggo spins and greets you"), new StickerPartial(819128604311027752L, stickerFormatType, "Peach raising her arms in distress")};
        ROLE_SUBSCRIPTION_PURCHASE_STICKERS = new StickerPartial[]{new StickerPartial(781323471249604648L, stickerFormatType2, "Cheerful Choco jumps out of gift box"), new StickerPartial(781324642736144424L, stickerFormatType2, "Cheerful Choco preens against window"), new StickerPartial(781323769960202280L, stickerFormatType2, "Cheerful Choco sparkles"), new StickerPartial(781324722394103808L, stickerFormatType2, "Cheerful Choco cheers"), new StickerPartial(813951723822645278L, stickerFormatType2, "Cheerful Choco gives thumbs up")};
        SORT_BY_IDS_COMPARATOR = MessageUtils2.INSTANCE;
    }

    private MessageUtils() {
    }

    public static final int compareMessages(Long messageId1, Long messageId2) {
        long jLongValue = messageId1 != null ? messageId1.longValue() : 0L;
        long jLongValue2 = messageId2 != null ? messageId2.longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    public static final Map<Long, String> getNickOrUsernames(Message message, Channel channel, Map<Long, GuildMember> guildMembers, List<ChannelRecipientNick> nicks) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        List<User> mentions = message.getMentions();
        HashMap map = new HashMap((mentions != null ? mentions.size() : 0) + 1);
        List<User> mentions2 = message.getMentions();
        if (mentions2 != null) {
            for (User user : mentions2) {
                map.put(Long.valueOf(user.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(user), guildMembers.get(Long.valueOf(user.getId())), channel, nicks));
            }
        }
        User author = message.getAuthor();
        if (author != null) {
            map.put(Long.valueOf(author.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(author), guildMembers.get(Long.valueOf(author.getId())), channel, nicks));
        }
        Interaction interaction = message.getInteraction();
        User user2 = interaction != null ? interaction.getUser() : null;
        if (user2 != null) {
            map.put(Long.valueOf(user2.getId()), GuildMember.INSTANCE.getNickOrUsername(new CoreUser(user2), guildMembers.get(Long.valueOf(user2.getId())), channel, nicks));
        }
        return map;
    }

    public static /* synthetic */ Map getNickOrUsernames$default(Message message, Channel channel, Map map, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = null;
        }
        return getNickOrUsernames(message, channel, map, list);
    }

    public static final Comparator<Long> getSORT_BY_IDS_COMPARATOR() {
        return SORT_BY_IDS_COMPARATOR;
    }

    public static /* synthetic */ void getSORT_BY_IDS_COMPARATOR$annotations() {
    }

    public static /* synthetic */ CharSequence getSystemMessageRoleSubscriptionPurchase$default(MessageUtils messageUtils, Context context, String str, String str2, RoleSubscriptionData roleSubscriptionData, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        return messageUtils.getSystemMessageRoleSubscriptionPurchase(context, str, str2, roleSubscriptionData, function1);
    }

    public static final boolean isNewer(Long messageId1, Long messageId2) {
        return compareMessages(messageId1, messageId2) < 0;
    }

    public final StickerPartial getRoleSubscriptionPurchaseSticker(long meUserId, long messageId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(messageId)) + TimeUtils.parseSnowflake(Long.valueOf(meUserId));
        return ROLE_SUBSCRIPTION_PURCHASE_STICKERS[(int) (snowflake % r3.length)];
    }

    public final CharSequence getSystemMessageRoleSubscriptionPurchase(Context context, String str, String str2, RoleSubscriptionData roleSubscriptionData, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(context, "$this$getSystemMessageRoleSubscriptionPurchase");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        if ((!Intrinsics3.areEqual(ContextExtensions.getLocaleOrNull(context) != null ? r0.getLanguage() : null, new Locale("en").getLanguage())) || roleSubscriptionData == null) {
            return FormatUtils.h(context, R.string.reply_quote_message_not_loaded, new Object[0], null, 4);
        }
        String tierName = roleSubscriptionData.getTierName();
        if (roleSubscriptionData.getTotalMonthsSubscribed() > 0) {
            return FormatUtils.b(context, roleSubscriptionData.getIsRenewal() ? R.string.system_message_role_subscription_renew_with_duration_mobile : R.string.system_message_role_subscription_join_with_duration_mobile, new Object[]{str2, tierName, str, StringResourceUtils.getI18nPluralString(context, R.plurals.system_message_role_subscription_join_with_duration_mobile_months, roleSubscriptionData.getTotalMonthsSubscribed(), Integer.valueOf(roleSubscriptionData.getTotalMonthsSubscribed()))}, function1);
        }
        return FormatUtils.b(context, roleSubscriptionData.getIsRenewal() ? R.string.system_message_role_subscription_renew_mobile : R.string.system_message_role_subscription_join_mobile, new Object[]{str2, tierName, str}, function1);
    }

    public final int getSystemMessageUserJoin(Context context, long messageId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Locale localeOrNull = ContextExtensions.getLocaleOrNull(context);
        return WELCOME_MESSAGES[(int) (Intrinsics3.areEqual(localeOrNull != null ? localeOrNull.getLanguage() : null, new Locale("en").getLanguage()) ^ true ? 0L : TimeUtils.parseSnowflake(Long.valueOf(messageId)) % WELCOME_MESSAGES.length)];
    }

    public final StickerPartial getWelcomeSticker(long meUserId, long messageId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(messageId)) + TimeUtils.parseSnowflake(Long.valueOf(meUserId));
        return WELCOME_STICKERS[(int) (snowflake % r3.length)];
    }
}
