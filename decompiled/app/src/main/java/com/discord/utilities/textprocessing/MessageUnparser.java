package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.TextNode;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringNumberConversions;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: MessageUnparser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'JQ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u00122\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J;\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u00122\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u001e\u0010$\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u001e\u0010%\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\"¨\u0006("}, d2 = {"Lcom/discord/utilities/textprocessing/MessageUnparser;", "", "", "rawMessageContent", "Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "", "unparse", "(Ljava/lang/String;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/domain/emoji/EmojiSet;)Ljava/lang/CharSequence;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "getUserMentionRule", "(Ljava/util/Map;)Lcom/discord/simpleast/core/parser/Rule;", "", "Lcom/discord/api/role/GuildRole;", "guildRoles", "getRoleMentionRule", "(Ljava/util/List;)Lcom/discord/simpleast/core/parser/Rule;", "getChannelMentionRule", "getCustomEmojiRule", "(Lcom/discord/models/domain/emoji/EmojiSet;)Lcom/discord/simpleast/core/parser/Rule;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATTERN_USER_MENTION", "Ljava/util/regex/Pattern;", "PATTERN_CUSTOM_EMOJI", "PATTERN_CHANNEL_MENTION", "PATTERN_ROLE_MENTION", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageUnparser {
    public static final MessageUnparser INSTANCE = new MessageUnparser();
    private static final Pattern PATTERN_USER_MENTION = Pattern.compile("^<@!?(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&?(\\d+)>");
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#?(\\d+)>");
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:(\\w+):(\\d+)>");

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/MessageUnparser$getChannelMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getChannelMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $channels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, Pattern pattern) {
            super(pattern);
            this.$channels = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            Channel channel = (Channel) this.$channels.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (channel != null) {
                StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
                sbQ.append(ChannelUtils.c(channel));
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/MessageUnparser$getCustomEmojiRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getCustomEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ EmojiSet $emojiSet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmojiSet emojiSet, Pattern pattern) {
            super(pattern);
            this.$emojiSet = emojiSet;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Emoji emoji = this.$emojiSet.emojiIndex.get(matcher.group(3));
            TextNode textNode = new TextNode(MentionUtils.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/MessageUnparser$getRoleMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getRoleMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ List $guildRoles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Pattern pattern) {
            super(pattern);
            this.$guildRoles = list;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            T next;
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            long jLongValue = (strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
            Iterator<T> it = this.$guildRoles.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (((GuildRole) next).getId() == jLongValue) {
                    break;
                }
            }
            GuildRole guildRole = next;
            if (guildRole != null) {
                StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                sbQ.append(guildRole.getName());
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/MessageUnparser$getUserMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getUserMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, Pattern pattern) {
            super(pattern);
            this.$users = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            User user = (User) this.$users.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (user != null) {
                StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                sbQ.append(user.getUsername());
                sbQ.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    private MessageUnparser() {
    }

    private final <T, S> Rule<T, Node<T>, S> getChannelMentionRule(Map<Long, Channel> channels) {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new AnonymousClass1(channels, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new AnonymousClass1(emojiSet, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new AnonymousClass1(guildRoles, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new AnonymousClass1(users, pattern);
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        Intrinsics3.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(SimpleMarkdownRules5.h.d()), rawMessageContent, null, null, 4, null), null);
    }
}
