package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.a.CodeRules;
import b.a.t.a.CodeRules3;
import b.a.t.a.CodeRules5;
import b.a.t.a.CodeStyleProviders;
import b.a.t.a.Crystal;
import b.a.t.a.Crystal2;
import b.a.t.a.JavaScript;
import b.a.t.a.JavaScript2;
import b.a.t.a.JavaScript3;
import b.a.t.a.JavaScript4;
import b.a.t.a.Kotlin;
import b.a.t.a.Kotlin2;
import b.a.t.a.Kotlin3;
import b.a.t.a.TypeScript;
import b.a.t.a.TypeScript2;
import b.a.t.a.TypeScript3;
import b.a.t.a.TypeScript4;
import b.a.t.a.TypeScript5;
import b.a.t.a.Xml;
import b.a.t.a.Xml2;
import b.a.t.b.a.TextNode;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.a.t.c.MarkdownRules;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockBackgroundNode;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.BulletListNode;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.HeaderNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.TimestampNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import d0.LazyJVM;
import d0.Tuples;
import d0.g0.StringNumberConversions;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Rules.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004ijklB\t\b\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u000b*\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0016J?\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001cJ?\u0010 \u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00028\u00010\u001e\"\b\b\u0000\u0010\u000f*\u00020\u0018\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u001a¢\u0006\u0004\b \u0010!J5\u0010$\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020\"\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b$\u0010\u001cJ5\u0010'\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020%\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b'\u0010\u001cJ5\u0010)\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020(\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b)\u0010\u001cJ5\u0010+\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020*\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b+\u0010\u001cJ5\u0010-\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020*\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b-\u0010\u001cJ5\u0010.\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020*\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b.\u0010\u001cJ1\u00100\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b0\u0010\u001cJ5\u00103\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000002\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u000201\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b3\u0010\u001cJ5\u00106\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000005\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u000204\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b6\u0010\u001cJ5\u00107\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000005\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u000204\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b7\u0010\u001cJ5\u00108\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000005\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u000204\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b8\u0010\u001cJ1\u00109\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b9\u0010\u001cJ5\u0010<\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020:\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b<\u0010\u001cJ5\u0010=\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020*\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b=\u0010\u001cJ1\u0010>\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b>\u0010\u001cJ5\u0010@\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000?\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0000\u0010\u000f*\u00020\u0018\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\b@\u0010\u001cJ5\u0010B\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000A\u0012\u0004\u0012\u00028\u00010\u001e\"\b\b\u0000\u0010\u000f*\u00020\u0018\"\u0004\b\u0001\u0010\u0010¢\u0006\u0004\bB\u0010!R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010J\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010L\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010KR\u001e\u0010M\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010KR\u001e\u0010N\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010KR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010Q\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010KR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010S\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010PR\u001e\u0010T\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010KR\u001e\u0010U\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010KR\u001e\u0010V\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010KR\u0016\u0010W\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010KR\u001e\u0010X\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010KR\u001e\u0010Y\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010KR\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010PR\u001e\u0010[\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010KR\u001e\u0010\\\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010KR\u001e\u0010]\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010KR%\u0010b\u001a\n I*\u0004\u0018\u00010H0H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001e\u0010c\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010KR\u001e\u0010d\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010KR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\be\u0010PR\u0016\u0010f\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010P¨\u0006m"}, d2 = {"Lcom/discord/utilities/textprocessing/Rules;", "", "Lcom/discord/utilities/textprocessing/Rules$EmojiDataProvider;", "emojiDataProvider", "", "setEmojiDataProvider", "(Lcom/discord/utilities/textprocessing/Rules$EmojiDataProvider;)V", "", "originalText", "replaceEmojiSurrogates", "(Ljava/lang/String;)Ljava/lang/String;", "", "default", "toLongOrDefault", "(Ljava/lang/String;J)J", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "createBoldColoredRule", "(I)Lcom/discord/simpleast/core/parser/Rule;", "createStrikethroughColoredRule", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "RC", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", "createCodeBlockRule", "()Lcom/discord/simpleast/core/parser/Rule;", "createInlineCodeRule", "Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "Lcom/discord/utilities/textprocessing/node/BlockQuoteNode;", "createBlockQuoteRule", "()Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "Lcom/discord/utilities/textprocessing/node/ChannelMentionNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/ChannelMentionNode;", "createChannelMentionRule", "Lcom/discord/utilities/textprocessing/node/RoleMentionNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/RoleMentionNode;", "createRoleMentionRule", "Lcom/discord/utilities/textprocessing/node/UserMentionNode$RenderContext;", "createUserMentionRule", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "createUnicodeEmojiRule", "Lcom/discord/utilities/textprocessing/node/EmojiNode;", "createCustomEmojiRule", "createNamedEmojiRule", "Lb/a/t/b/a/a;", "createUnescapeEmoticonRule", "Lcom/discord/utilities/textprocessing/node/TimestampNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/TimestampNode;", "createTimestampRule", "Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/UrlNode;", "createUrlRule", "createMaskedLinkRule", "createUrlNoEmbedRule", "createSoftHyphenRule", "Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "createSpoilerRule", "createTextReplacementRule", "createHookedLinkRule", "Lcom/discord/utilities/textprocessing/node/BulletListNode;", "createListItemRule", "Lcom/discord/utilities/textprocessing/node/HeaderNode;", "createHeaderItemRule", "Lcom/discord/utilities/textprocessing/Rules$EmojiDataProvider;", "", "", "PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS", "Ljava/util/Set;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATTERN_NAMED_EMOJI", "Ljava/util/regex/Pattern;", "PATTERN_HOOKED_LINK", "PATTERN_TIMESTAMP", "PATTERN_UNESCAPE_EMOTICON", "LINK", "Ljava/lang/String;", "PATTERN_ROLE_MENTION", "HOOKED_LINK", "REGEX_CUSTOM_EMOJI", "PATTERN_BLOCK_QUOTE", "PATTERN_MENTION", "PATTERN_URL", "PATTERN_HEADER_ITEM", "PATTERN_MASKED_LINK", "PATTERN_CUSTOM_EMOJI", "REGEX_LINK_HREF_AND_TITLE", "PATTERN_SPOILER", "PATTERN_URL_NO_EMBED", "PATTERN_SOFT_HYPHEN", "PATTERN_UNICODE_EMOJI$delegate", "Lkotlin/Lazy;", "getPATTERN_UNICODE_EMOJI", "()Ljava/util/regex/Pattern;", "PATTERN_UNICODE_EMOJI", "PATTERN_LIST_ITEM", "PATTERN_CHANNEL_MENTION", "REGEX_URL", "REGEX_LINK_INSIDE", "<init>", "()V", "BlockQuoteState", "EmojiDataProvider", "HeaderLineClassedRule", "MarkdownListItemRule", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Rules {
    private static final Pattern PATTERN_HEADER_ITEM;
    public static final String REGEX_CUSTOM_EMOJI = "<(a)?:([a-zA-Z_0-9]+):(\\d+)>";
    private static final String REGEX_LINK_HREF_AND_TITLE = "\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*";
    private static final String REGEX_LINK_INSIDE = "(?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*";
    private static final String REGEX_URL = "(https?://[^\\s<]+[^<.,:;\"')\\]\\s])";
    private static EmojiDataProvider emojiDataProvider;
    public static final Rules INSTANCE = new Rules();
    private static final Pattern PATTERN_BLOCK_QUOTE = Pattern.compile("^(?: *>>> +(.*)| *>(?!>>) +([^\\n]*\\n?))", 32);
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&(\\d+)>");
    private static final Pattern PATTERN_MENTION = Pattern.compile("^<@!?(\\d+)>|^@(everyone|here)");

    /* renamed from: PATTERN_UNICODE_EMOJI$delegate, reason: from kotlin metadata */
    private static final Lazy PATTERN_UNICODE_EMOJI = LazyJVM.lazy(Rules$PATTERN_UNICODE_EMOJI$2.INSTANCE);
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:([a-zA-Z_0-9]+):(\\d+)>");
    private static final Pattern PATTERN_NAMED_EMOJI = Pattern.compile("^:([^\\s:]+?(?:::skin-tone-\\d)?):");
    private static final Pattern PATTERN_UNESCAPE_EMOTICON = Pattern.compile("^(¯\\\\_\\(ツ\\)_/¯)");
    private static final Pattern PATTERN_TIMESTAMP = Pattern.compile("^<t:(-?\\d{1,17})(?::(t|T|d|D|f|F|R))?>");
    private static final Pattern PATTERN_URL = Pattern.compile("^(https?://[^\\s<]+[^<.,:;\"')\\]\\s])");
    private static final String LINK = "^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_MASKED_LINK = Pattern.compile(LINK);
    private static final Set<Character> PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS = Sets5.setOf((Object[]) new Character[]{'[', ']'});
    private static final Pattern PATTERN_URL_NO_EMBED = Pattern.compile("^<(https?://[^\\s<]+[^<.,:;\"')\\]\\s])>");
    private static final Pattern PATTERN_SOFT_HYPHEN = Pattern.compile("^\\u00AD");
    private static final Pattern PATTERN_SPOILER = Pattern.compile("^\\|\\|([\\s\\S]+?)\\|\\|");
    private static final String HOOKED_LINK = "^\\$\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)?]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_HOOKED_LINK = Pattern.compile(HOOKED_LINK);
    private static final Pattern PATTERN_LIST_ITEM = Pattern.compile("^([^\\S\\r\\n]*)[*-][ \\s]?(.*)([\\n|$])?");

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", "Self", "", "", "isInQuote", "newBlockQuoteState", "(Z)Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface BlockQuoteState<Self extends BlockQuoteState<Self>> {
        /* renamed from: isInQuote */
        boolean getIsInQuote();

        Self newBlockQuoteState(boolean isInQuote);
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/textprocessing/Rules$EmojiDataProvider;", "", "", "", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "getUnicodeEmojisNamesMap", "()Ljava/util/Map;", "getUnicodeEmojiSurrogateMap", "Ljava/util/regex/Pattern;", "getUnicodeEmojisPattern", "()Ljava/util/regex/Pattern;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface EmojiDataProvider {
        Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap();

        Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap();

        Pattern getUnicodeEmojisPattern();
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\u0004BE\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aJM\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u000b\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/discord/utilities/textprocessing/Rules$HeaderLineClassedRule;", "RC", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Lb/a/t/c/a$a;", "", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/simpleast/core/node/Node;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "Lkotlin/Function0;", "", "headerPaddingSpanProvider", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "", "Landroid/text/style/CharacterStyle;", "styleSpanProvider", "", "classSpanProvider", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderLineClassedRule<RC, T, S> extends MarkdownRules.a<RC, Object, S> {
        private final Function0<List<Object>> headerPaddingSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HeaderLineClassedRule(Function0<? extends List<? extends Object>> function0, Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function12) {
            super(function1, function12);
            Intrinsics3.checkNotNullParameter(function0, "headerPaddingSpanProvider");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function12, "classSpanProvider");
            this.headerPaddingSpanProvider = function0;
        }

        @Override // b.a.t.c.MarkdownRules.a, b.a.t.c.MarkdownRules.b, b.a.t.c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Node<RC> node = super.parse(matcher, parser, state).root;
            StyleNode styleNode = new StyleNode(this.headerPaddingSpanProvider.invoke());
            styleNode.addChild(node);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state);
        }
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013JM\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00052 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/textprocessing/Rules$MarkdownListItemRule;", "RC", ExifInterface.LATITUDE_SOUTH, "Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "Lkotlin/Function0;", "", "", "spansProvider", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MarkdownListItemRule<RC, S> extends Rule.BlockRule<RC, Node<RC>, S> {
        private final Function0<List<Object>> spansProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MarkdownListItemRule(Function0<? extends List<? extends Object>> function0) {
            super(MarkdownRules.a);
            Intrinsics3.checkNotNullParameter(function0, "spansProvider");
            MarkdownRules markdownRules = MarkdownRules.e;
            this.spansProvider = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(this.spansProvider.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001J+\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJM\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2 \u0010\r\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/discord/utilities/textprocessing/Rules$createBlockQuoteRule$1", "Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "Lcom/discord/utilities/textprocessing/node/BlockQuoteNode;", "", "inspectionSource", "", "lastCapture", "state", "Ljava/util/regex/Matcher;", "match", "(Ljava/lang/CharSequence;Ljava/lang/String;Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;)Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBlockQuoteRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule.BlockRule<T, BlockQuoteNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule.BlockRule, com.discord.simpleast.core.parser.Rule
        public /* bridge */ /* synthetic */ Matcher match(CharSequence charSequence, String str, Object obj) {
            return match(charSequence, str, (BlockQuoteState) obj);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public /* bridge */ /* synthetic */ ParseSpec parse(Matcher matcher, Parser parser, Object obj) {
            return parse(matcher, parser, (BlockQuoteState) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/lang/CharSequence;Ljava/lang/String;TS;)Ljava/util/regex/Matcher; */
        /* JADX WARN: Multi-variable type inference failed */
        public Matcher match(CharSequence inspectionSource, String lastCapture, BlockQuoteState state) {
            Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
            Intrinsics3.checkNotNullParameter(state, "state");
            if (state.getIsInQuote()) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, (String) state);
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser<TT;-Lcom/discord/utilities/textprocessing/node/BlockQuoteNode<TT;>;TS;>;TS;)Lcom/discord/simpleast/core/parser/ParseSpec<TT;TS;>; */
        public ParseSpec parse(Matcher matcher, Parser parser, BlockQuoteState state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Intrinsics3.checkNotNullParameter(state, "state");
            int i = matcher.group(1) != null ? 1 : 2;
            BlockQuoteState blockQuoteStateNewBlockQuoteState = state.newBlockQuoteState(true);
            BlockQuoteNode blockQuoteNode = new BlockQuoteNode();
            int iStart = matcher.start(i);
            int iEnd = matcher.end(i);
            Intrinsics3.checkNotNullParameter(blockQuoteNode, "node");
            return new ParseSpec(blockQuoteNode, blockQuoteStateNewBlockQuoteState, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "", "Landroid/text/style/CharacterStyle;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBoldColoredRule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends CharacterStyle> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends CharacterStyle> invoke2() {
            return Collections2.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StyleSpan(1)});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createChannelMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/ChannelMentionNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createChannelMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, ChannelMentionNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super ChannelMentionNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            ChannelMentionNode channelMentionNode = new ChannelMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            Intrinsics3.checkNotNullParameter(channelMentionNode, "node");
            return new ParseSpec<>(channelMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RC, S] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "RC", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", ExifInterface.LATITUDE_SOUTH, "Lcom/discord/simpleast/code/CodeNode;", "codeNode", "", "block", "state", "Lcom/discord/simpleast/core/node/Node;", "invoke", "(Lcom/discord/simpleast/code/CodeNode;ZLcom/discord/utilities/textprocessing/Rules$BlockQuoteState;)Lcom/discord/simpleast/core/node/Node;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1, reason: invalid class name */
    public static final class AnonymousClass1<RC, S> extends Lambda implements Function3<CodeNode<RC>, Boolean, S, Node<RC>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: Rules.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createCodeBlockRule$1$1", "Lcom/discord/simpleast/core/node/Node$a;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02261 extends Node.a<RC> {
            public final /* synthetic */ CodeNode $codeNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02261(CodeNode codeNode, Node[] nodeArr) {
                super(nodeArr);
                this.$codeNode = codeNode;
            }

            @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
            public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
                render(spannableStringBuilder, (BasicRenderContext) obj);
            }

            /* JADX WARN: Incorrect types in method signature: (Landroid/text/SpannableStringBuilder;TRC;)V */
            public void render(SpannableStringBuilder builder, BasicRenderContext renderContext) {
                Intrinsics3.checkNotNullParameter(builder, "builder");
                Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
                int length = builder.length();
                super.render(builder, (SpannableStringBuilder) renderContext);
                builder.setSpan(new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_code)), length, builder.length(), 33);
            }
        }

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((CodeNode) obj, bool.booleanValue(), (BlockQuoteState) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (Lcom/discord/simpleast/code/CodeNode<TRC;>;ZTS;)Lcom/discord/simpleast/core/node/Node<TRC;>; */
        public final Node invoke(CodeNode codeNode, boolean z2, BlockQuoteState blockQuoteState) {
            Intrinsics3.checkNotNullParameter(codeNode, "codeNode");
            Intrinsics3.checkNotNullParameter(blockQuoteState, "state");
            return !z2 ? new C02261(codeNode, new Node[]{codeNode}) : new BlockBackgroundNode(blockQuoteState.getIsInQuote(), codeNode);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createCustomEmojiRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/EmojiNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCustomEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, EmojiNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super EmojiNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String strGroup = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup);
            long longOrDefault$default = Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(3), 0L, 1, null);
            EmojiNode emojiNode = new EmojiNode(strGroup, new Rules$createCustomEmojiRule$1$parse$emojiNode$1(longOrDefault$default, zIsEmpty), new EmojiNode.EmojiIdAndType.Custom(longOrDefault$default, zIsEmpty, strGroup), 0, 0, 24, null);
            Intrinsics3.checkNotNullParameter(emojiNode, "node");
            return new ParseSpec<>(emojiNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createHeaderItemRule$1", "Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "Lcom/discord/utilities/textprocessing/node/HeaderNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHeaderItemRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule.BlockRule<T, HeaderNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super HeaderNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            HeaderNode headerNode = new HeaderNode(strGroup != null ? strGroup.length() : 1);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(headerNode, "node");
            return new ParseSpec<>(headerNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createHookedLinkRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHookedLinkRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(Collections2.emptyList());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "RC", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", ExifInterface.LATITUDE_SOUTH, "it", "", "get", "(Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)Ljava/lang/Iterable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$1, reason: invalid class name */
    public static final class AnonymousClass1<RC> implements StyleNode.a<RC> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // com.discord.simpleast.core.node.StyleNode.a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
            return Collections2.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), R.style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
        }
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "RC", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", ExifInterface.LATITUDE_SOUTH, "it", "", "get", "(Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)Ljava/lang/Iterable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$2, reason: invalid class name */
    public static final class AnonymousClass2<RC> implements StyleNode.a<RC> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // com.discord.simpleast.core.node.StyleNode.a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
            return CollectionsJVM.listOf(new BackgroundColorSpan(ColorCompat.getThemedColor(basicRenderContext.getContext(), R.attr.theme_chat_code)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createListItemRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/BulletListNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createListItemRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, BulletListNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super BulletListNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            int i = strGroup == null || strGroup.length() == 0 ? 1 : 2;
            String strGroup2 = matcher.group(3);
            BulletListNode bulletListNode = new BulletListNode(i, true ^ (strGroup2 == null || strGroup2.length() == 0));
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(bulletListNode, "node");
            return new ParseSpec<>(bulletListNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJM\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122\u0006\u0010\u000f\u001a\u00020\f2 \u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/discord/utilities/textprocessing/Rules$createMaskedLinkRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/UrlNode;", "", "source", "", "isLikelyPathologicalAttack", "(Ljava/lang/CharSequence;)Z", "inspectionSource", "", "lastCapture", "state", "Ljava/util/regex/Matcher;", "match", "(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/Object;)Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createMaskedLinkRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        private final boolean isLikelyPathologicalAttack(CharSequence source) {
            if (source.length() < 30) {
                return false;
            }
            double length = source.length() * 0.3d;
            int length2 = source.length();
            int i = 0;
            for (int i2 = 0; i2 < length2; i2++) {
                if (Rules.access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules.INSTANCE).contains(Character.valueOf(source.charAt(i2)))) {
                    i++;
                    if (i > length) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
            Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
            if (isLikelyPathologicalAttack(inspectionSource)) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, state);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            String strGroup2 = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup2);
            UrlNode urlNode = new UrlNode(strGroup2, strGroup);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createNamedEmojiRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createNamedEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisNamesMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                Intrinsics3.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            String strGroup2 = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup2, "matcher.group()");
            TextNode textNode = new TextNode(strGroup2);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createRoleMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/RoleMentionNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createRoleMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, RoleMentionNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super RoleMentionNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            RoleMentionNode roleMentionNode = new RoleMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            Intrinsics3.checkNotNullParameter(roleMentionNode, "node");
            return new ParseSpec<>(roleMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createSoftHyphenRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lb/a/t/b/a/a;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSoftHyphenRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, TextNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TextNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            TextNode textNode = new TextNode("");
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createSpoilerRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSpoilerRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, SpoilerNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super SpoilerNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            SpoilerNode spoilerNode = new SpoilerNode(strGroup);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(spoilerNode, "node");
            return new ParseSpec<>(spoilerNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "", "Landroid/text/style/CharacterStyle;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createStrikethroughColoredRule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends CharacterStyle> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends CharacterStyle> invoke2() {
            return Collections2.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StrikethroughSpan()});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nR7\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/discord/utilities/textprocessing/Rules$createTextReplacementRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "", "innerRules", "Ljava/util/List;", "getInnerRules", "()Ljava/util/List;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTextReplacementRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        private final List<Rule<T, Node<T>, S>> innerRules;

        public AnonymousClass1(Pattern pattern) {
            super(pattern);
            this.innerRules = Collections2.listOf((Object[]) new Rule[]{Rules.INSTANCE.createNamedEmojiRule(), SimpleMarkdownRules5.h.d()});
        }

        public final List<Rule<T, Node<T>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Node node;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Rules rules = Rules.INSTANCE;
            String strGroup = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
            List<T> list = parser.parse(Rules.access$replaceEmojiSurrogates(rules, strGroup), state, this.innerRules);
            if (list.size() == 1) {
                Object objFirst = _Collections.first((List<? extends Object>) list);
                Objects.requireNonNull(objFirst, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                node = (Node) objFirst;
            } else {
                StyleNode styleNode = new StyleNode(Collections2.emptyList());
                for (Object obj : list) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                    styleNode.addChild((Node) obj);
                }
                node = styleNode;
            }
            Intrinsics3.checkNotNullParameter(node, "node");
            return new ParseSpec<>(node, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createTimestampRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/TimestampNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTimestampRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, TimestampNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TimestampNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            TimestampNode timestampNode = new TimestampNode(strGroup, matcher.group(2));
            Intrinsics3.checkNotNullParameter(timestampNode, "node");
            return new ParseSpec<>(timestampNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createUnescapeEmoticonRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lb/a/t/b/a/a;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnescapeEmoticonRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, TextNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TextNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createUnicodeEmojiRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnicodeEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                Intrinsics3.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "match");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createUrlNoEmbedRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/UrlNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlNoEmbedRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createUrlRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/utilities/textprocessing/node/UrlNode;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0001JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/textprocessing/Rules$createUserMentionRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUserMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            if (!TextUtils.isEmpty(matcher.group(1))) {
                UserMentionNode userMentionNode = new UserMentionNode(UserMentionNode.Type.USER, Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                Intrinsics3.checkNotNullParameter(userMentionNode, "node");
                return new ParseSpec<>(userMentionNode, state);
            }
            String strGroup = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup);
            UserMentionNode userMentionNode2 = new UserMentionNode(strGroup.charAt(0) != 'e' ? UserMentionNode.Type.HERE : UserMentionNode.Type.EVERYONE, 0L, 2, null);
            Intrinsics3.checkNotNullParameter(userMentionNode2, "node");
            return new ParseSpec<>(userMentionNode2, state);
        }
    }

    static {
        MarkdownRules markdownRules = MarkdownRules.e;
        PATTERN_HEADER_ITEM = MarkdownRules.f309b;
    }

    private Rules() {
    }

    public static final /* synthetic */ EmojiDataProvider access$getEmojiDataProvider$p(Rules rules) {
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        return emojiDataProvider2;
    }

    public static final /* synthetic */ Set access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules rules) {
        return PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS;
    }

    public static final /* synthetic */ String access$replaceEmojiSurrogates(Rules rules, String str) {
        return rules.replaceEmojiSurrogates(str);
    }

    public static final /* synthetic */ void access$setEmojiDataProvider$p(Rules rules, EmojiDataProvider emojiDataProvider2) {
        emojiDataProvider = emojiDataProvider2;
    }

    private final Pattern getPATTERN_UNICODE_EMOJI() {
        return (Pattern) PATTERN_UNICODE_EMOJI.getValue();
    }

    private final String replaceEmojiSurrogates(String originalText) {
        StringBuffer stringBuffer = new StringBuffer();
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        Matcher matcher = emojiDataProvider2.getUnicodeEmojisPattern().matcher(originalText);
        while (matcher.find()) {
            String strGroup = matcher.group();
            EmojiDataProvider emojiDataProvider3 = emojiDataProvider;
            if (emojiDataProvider3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
            }
            ModelEmojiUnicode modelEmojiUnicode = emojiDataProvider3.getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                StringBuilder sbU = outline.U(":");
                sbU.append(modelEmojiUnicode.getFirstName());
                sbU.append(":");
                matcher.appendReplacement(stringBuffer, sbU.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String string = stringBuffer.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public static final void setEmojiDataProvider(EmojiDataProvider emojiDataProvider2) {
        Intrinsics3.checkNotNullParameter(emojiDataProvider2, "emojiDataProvider");
        emojiDataProvider = emojiDataProvider2;
    }

    private final long toLongOrDefault(String str, long j) {
        Long longOrNull;
        return (str == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? j : longOrNull.longValue();
    }

    public static /* synthetic */ long toLongOrDefault$default(Rules rules, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return rules.toLongOrDefault(str, j);
    }

    public final <T extends BasicRenderContext, S extends BlockQuoteState<S>> Rule.BlockRule<T, BlockQuoteNode<T>, S> createBlockQuoteRule() {
        Pattern pattern = PATTERN_BLOCK_QUOTE;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BLOCK_QUOTE");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createBoldColoredRule(@ColorInt int color) {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern = SimpleMarkdownRules5.a;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BOLD");
        return SimpleMarkdownRules5.c(pattern, new AnonymousClass1(color));
    }

    public final <T extends ChannelMentionNode.RenderContext, S> Rule<T, ChannelMentionNode<T>, S> createChannelMentionRule() {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new AnonymousClass1(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createCodeBlockRule() {
        CodeStyleProviders codeStyleProviders = new CodeStyleProviders(Rules$createCodeBlockRule$codeStyleProviders$1.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$2.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$3.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$4.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$5.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$6.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$7.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$8.INSTANCE);
        CodeRules5 codeRules5 = CodeRules5.f;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Kotlin2 kotlin2 = Kotlin2.f;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern = Kotlin2.c;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_KOTLIN_COMMENTS");
        Pattern pattern2 = Kotlin2.e;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_KOTLIN_STRINGS");
        Pattern pattern3 = Kotlin2.d;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_KOTLIN_ANNOTATION");
        Kotlin2.a.C0020a c0020a = Kotlin2.a.f299b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern4 = Kotlin2.a.a;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "PATTERN_KOTLIN_FIELD");
        Kotlin2.b.a aVar = Kotlin2.b.f300b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        List listB = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, pattern, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, pattern2, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, pattern3, 0, codeStyleProviders.g, 1), new Kotlin(c0020a, codeStyleProviders, pattern4), new Kotlin3(aVar, codeStyleProviders, Kotlin2.b.a)}), new String[]{"object", "class", "interface"}, Kotlin2.f298b, Kotlin2.a, null, 32);
        Pattern patternC = codeRules5.c("//");
        Intrinsics3.checkNotNullExpressionValue(patternC, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        List listB2 = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, patternC, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, patternCompile, 0, codeStyleProviders.c, 1)}), new String[]{"message|enum|extend|service"}, new String[]{"true|false", "string|bool|double|float|bytes", "int32|uint32|sint32|int64|unit64|sint64", "map"}, new String[]{"required|repeated|optional|option|oneof|default|reserved", "package|import", "rpc|returns"}, null, 32);
        Pattern patternC2 = codeRules5.c("#");
        Intrinsics3.checkNotNullExpressionValue(patternC2, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile2 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile3 = Pattern.compile("^'[\\s\\S]*?(?<!\\\\)'(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^'[\\s…*?(?<!\\\\)'(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile4 = Pattern.compile("^@(\\w+)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^@(\\w+)\"\"\")");
        List listB3 = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, patternC2, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, patternCompile2, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, patternCompile3, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, patternCompile4, 0, codeStyleProviders.g, 1)}), new String[]{"class", "def", "lambda"}, new String[]{"True|False|None"}, new String[]{"from|import|global|nonlocal", "async|await|class|self|cls|def|lambda", "for|while|if|else|elif|break|continue|return", "try|except|finally|raise|pass|yeild", "in|as|is|del", "and|or|not|assert"}, null, 32);
        Pattern patternC3 = codeRules5.c("//");
        Intrinsics3.checkNotNullExpressionValue(patternC3, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile5 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile6 = Pattern.compile("^#!?\\[.*?\\]\\n");
        Intrinsics3.checkNotNullExpressionValue(patternCompile6, "Pattern.compile(\"\"\"^#!?\\[.*?\\]\\n\"\"\")");
        List listB4 = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, patternC3, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, patternCompile5, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, patternCompile6, 0, codeStyleProviders.g, 1)}), new String[]{"struct", "trait", "mod"}, new String[]{"Self|Result|Ok|Err|Option|None|Some", "Copy|Clone|Eq|Hash|Send|Sync|Sized|Debug|Display", "Arc|Rc|Box|Pin|Future", "true|false|bool|usize|i64|u64|u32|i32|str|String"}, new String[]{"let|mut|static|const|unsafe", "crate|mod|extern|pub|pub(super)|use", "struct|enum|trait|type|where|impl|dyn|async|await|move|self|fn", "for|while|loop|if|else|match|break|continue|return|try", "in|as|ref"}, null, 32);
        Xml xml = Xml.c;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern5 = CodeRules5.c;
        Pattern pattern6 = CodeRules5.d;
        List listListOf = Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, Xml.a, 0, codeStyleProviders.f291b, 1), new Xml2(xml, codeStyleProviders, Xml.f306b), CodeRules5.e(codeRules5, pattern5, 0, null, 3), CodeRules5.e(codeRules5, pattern6, 0, null, 3)});
        Pattern patternC4 = codeRules5.c("#");
        Intrinsics3.checkNotNullExpressionValue(patternC4, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile7 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile7, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        String strPattern = codeRules5.d("true|false|null").pattern();
        Intrinsics3.checkNotNullExpressionValue(strPattern, "createWordPattern(\"true|false|null\").pattern()");
        Pattern patternCompile8 = Pattern.compile(strPattern, 2);
        Intrinsics3.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        String strPattern2 = codeRules5.d("select|from|join|where|and|as|distinct|count|avg", "order by|group by|desc|sum|min|max", "like|having|in|is|not").pattern();
        Intrinsics3.checkNotNullExpressionValue(strPattern2, "createWordPattern(\n     …ing|in|is|not\").pattern()");
        Pattern patternCompile9 = Pattern.compile(strPattern2, 2);
        Intrinsics3.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        List listListOf2 = Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, patternC4, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, patternCompile7, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, patternCompile8, 0, codeStyleProviders.g, 1), CodeRules5.e(codeRules5, patternCompile9, 0, codeStyleProviders.d, 1), CodeRules5.e(codeRules5, CodeRules5.e, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, pattern5, 0, null, 3), CodeRules5.e(codeRules5, pattern6, 0, null, 3)});
        Crystal2 crystal2 = Crystal2.h;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern7 = Crystal2.c;
        Intrinsics3.checkNotNullExpressionValue(pattern7, "PATTERN_CRYSTAL_COMMENTS");
        Pattern pattern8 = Crystal2.e;
        Intrinsics3.checkNotNullExpressionValue(pattern8, "PATTERN_CRYSTAL_STRINGS");
        Pattern pattern9 = Crystal2.f;
        Intrinsics3.checkNotNullExpressionValue(pattern9, "PATTERN_CRYSTAL_REGEX");
        Pattern pattern10 = Crystal2.d;
        Intrinsics3.checkNotNullExpressionValue(pattern10, "PATTERN_CRYSTAL_ANNOTATION");
        Pattern pattern11 = Crystal2.g;
        Intrinsics3.checkNotNullExpressionValue(pattern11, "PATTERN_CRYSTAL_SYMBOL");
        Crystal2.a.C0018a c0018a = Crystal2.a.f293b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern12 = Crystal2.a.a;
        Intrinsics3.checkNotNullExpressionValue(pattern12, "PATTERN_CRYSTAL_FUNC");
        List listB5 = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, pattern7, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, pattern8, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, pattern9, 0, codeStyleProviders.c, 1), CodeRules5.e(codeRules5, pattern10, 0, codeStyleProviders.g, 1), CodeRules5.e(codeRules5, pattern11, 0, codeStyleProviders.c, 1), new Crystal(c0018a, codeStyleProviders, pattern12)}), new String[]{"def", "class"}, Crystal2.f292b, Crystal2.a, null, 32);
        JavaScript2 javaScript2 = JavaScript2.g;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern13 = JavaScript2.e;
        Intrinsics3.checkNotNullExpressionValue(pattern13, "PATTERN_JAVASCRIPT_COMMENTS");
        Pattern pattern14 = JavaScript2.f;
        Intrinsics3.checkNotNullExpressionValue(pattern14, "PATTERN_JAVASCRIPT_STRINGS");
        JavaScript2.c.a aVar2 = JavaScript2.c.f297b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern15 = JavaScript2.c.a;
        Intrinsics3.checkNotNullExpressionValue(pattern15, "PATTERN_JAVASCRIPT_OBJECT_PROPERTY");
        Pattern pattern16 = JavaScript2.d;
        Intrinsics3.checkNotNullExpressionValue(pattern16, "PATTERN_JAVASCRIPT_GENERIC");
        Pattern pattern17 = JavaScript2.c;
        Intrinsics3.checkNotNullExpressionValue(pattern17, "PATTERN_JAVASCRIPT_REGEX");
        JavaScript2.a.C0019a c0019a = JavaScript2.a.f295b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern18 = JavaScript2.a.a;
        Intrinsics3.checkNotNullExpressionValue(pattern18, "PATTERN_JAVASCRIPT_FIELD");
        JavaScript2.b.a aVar3 = JavaScript2.b.f296b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        List listB6 = CodeRules5.b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, pattern13, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, pattern14, 0, codeStyleProviders.c, 1), new JavaScript4(aVar2, codeStyleProviders, pattern15), CodeRules5.e(codeRules5, pattern16, 0, codeStyleProviders.g, 1), CodeRules5.e(codeRules5, pattern17, 0, codeStyleProviders.c, 1), new JavaScript(c0019a, codeStyleProviders, pattern18), new JavaScript3(aVar3, codeStyleProviders, JavaScript2.b.a)}), new String[]{"class"}, JavaScript2.f294b, JavaScript2.a, null, 32);
        TypeScript2 typeScript2 = TypeScript2.g;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern19 = TypeScript2.e;
        Intrinsics3.checkNotNullExpressionValue(pattern19, "PATTERN_TYPESCRIPT_COMMENTS");
        Pattern pattern20 = TypeScript2.f;
        Intrinsics3.checkNotNullExpressionValue(pattern20, "PATTERN_TYPESCRIPT_STRINGS");
        TypeScript2.d.a aVar4 = TypeScript2.d.f305b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern21 = TypeScript2.d.a;
        Intrinsics3.checkNotNullExpressionValue(pattern21, "PATTERN_TYPESCRIPT_OBJECT_PROPERTY");
        Pattern pattern22 = TypeScript2.d;
        Intrinsics3.checkNotNullExpressionValue(pattern22, "PATTERN_TYPESCRIPT_REGEX");
        TypeScript2.b.a aVar5 = TypeScript2.b.f303b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern23 = TypeScript2.b.a;
        Intrinsics3.checkNotNullExpressionValue(pattern23, "PATTERN_TYPESCRIPT_FIELD");
        TypeScript2.c.a aVar6 = TypeScript2.c.f304b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        TypeScript2.a.C0021a c0021a = TypeScript2.a.f302b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern24 = TypeScript2.a.a;
        Intrinsics3.checkNotNullExpressionValue(pattern24, "PATTERN_TYPESCRIPT_DECORATOR");
        List listA = codeRules5.a(codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.e(codeRules5, pattern19, 0, codeStyleProviders.f291b, 1), CodeRules5.e(codeRules5, pattern20, 0, codeStyleProviders.c, 1), new TypeScript5(aVar4, codeStyleProviders, pattern21), CodeRules5.e(codeRules5, pattern22, 0, codeStyleProviders.c, 1), new TypeScript3(aVar5, codeStyleProviders, pattern23), new TypeScript4(aVar6, codeStyleProviders, TypeScript2.c.a), new TypeScript(c0021a, codeStyleProviders, pattern24)}), new String[]{"class", "interface", "enum", "namespace", "module", "type"}, TypeScript2.f301b, TypeScript2.a, TypeScript2.c);
        Map mapMapOf = Maps6.mapOf(Tuples.to("kt", listB), Tuples.to("kotlin", listB), Tuples.to("protobuf", listB2), Tuples.to("proto", listB2), Tuples.to("pb", listB2), Tuples.to("py", listB3), Tuples.to("python", listB3), Tuples.to("rs", listB4), Tuples.to("rust", listB4), Tuples.to("cql", listListOf2), Tuples.to("sql", listListOf2), Tuples.to("xml", listListOf), Tuples.to("http", listListOf), Tuples.to("cr", listB5), Tuples.to("crystal", listB5), Tuples.to("js", listB6), Tuples.to("javascript", listB6), Tuples.to("ts", listA), Tuples.to("typescript", listA));
        CodeRules5 codeRules52 = CodeRules5.f;
        StyleNode.a<R> aVar7 = codeStyleProviders.a;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics3.checkNotNullParameter(aVar7, "textStyleProvider");
        Intrinsics3.checkNotNullParameter(mapMapOf, "languageMap");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "wrapperNodeProvider");
        return new CodeRules(codeRules52, mapMapOf, aVar7, anonymousClass1, CodeRules5.a);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, EmojiNode<T>, S> createCustomEmojiRule() {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new AnonymousClass1(pattern);
    }

    public final <T extends BasicRenderContext, S> Rule.BlockRule<T, HeaderNode<T>, S> createHeaderItemRule() {
        return new AnonymousClass1(PATTERN_HEADER_ITEM);
    }

    public final <T, S> Rule<T, Node<T>, S> createHookedLinkRule() {
        Pattern pattern = PATTERN_HOOKED_LINK;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_HOOKED_LINK");
        return new AnonymousClass1(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createInlineCodeRule() {
        CodeRules5 codeRules5 = CodeRules5.f;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Intrinsics3.checkNotNullParameter(anonymousClass1, "textStyleProvider");
        Intrinsics3.checkNotNullParameter(anonymousClass2, "bgStyleProvider");
        return new CodeRules3(codeRules5, anonymousClass1, anonymousClass2, CodeRules5.f290b);
    }

    public final <T extends BasicRenderContext, S> Rule<T, BulletListNode<T>, S> createListItemRule() {
        Pattern pattern = PATTERN_LIST_ITEM;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_LIST_ITEM");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createMaskedLinkRule() {
        Pattern pattern = PATTERN_MASKED_LINK;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_MASKED_LINK");
        return new AnonymousClass1(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createNamedEmojiRule() {
        Pattern pattern = PATTERN_NAMED_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_NAMED_EMOJI");
        return new AnonymousClass1(pattern);
    }

    public final <T extends RoleMentionNode.RenderContext, S> Rule<T, RoleMentionNode<T>, S> createRoleMentionRule() {
        Pattern pattern = PATTERN_ROLE_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, TextNode<T>, S> createSoftHyphenRule() {
        Pattern pattern = PATTERN_SOFT_HYPHEN;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_SOFT_HYPHEN");
        return new AnonymousClass1(pattern);
    }

    public final <T extends SpoilerNode.RenderContext, S> Rule<T, SpoilerNode<T>, S> createSpoilerRule() {
        Pattern pattern = PATTERN_SPOILER;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_SPOILER");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createStrikethroughColoredRule(@ColorInt int color) {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern = SimpleMarkdownRules5.c;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_STRIKETHRU");
        return SimpleMarkdownRules5.c(pattern, new AnonymousClass1(color));
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createTextReplacementRule() {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern = SimpleMarkdownRules5.e;
        Intrinsics3.checkNotNullExpressionValue(pattern, "SimpleMarkdownRules.PATTERN_TEXT");
        return new AnonymousClass1(pattern);
    }

    public final <T extends TimestampNode.RenderContext, S> Rule<T, TimestampNode<T>, S> createTimestampRule() {
        Pattern pattern = PATTERN_TIMESTAMP;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_TIMESTAMP");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, TextNode<T>, S> createUnescapeEmoticonRule() {
        Pattern pattern = PATTERN_UNESCAPE_EMOTICON;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_UNESCAPE_EMOTICON");
        return new AnonymousClass1(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createUnicodeEmojiRule() {
        Pattern pattern_unicode_emoji = getPATTERN_UNICODE_EMOJI();
        Intrinsics3.checkNotNullExpressionValue(pattern_unicode_emoji, "PATTERN_UNICODE_EMOJI");
        return new AnonymousClass1(pattern_unicode_emoji);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlNoEmbedRule() {
        Pattern pattern = PATTERN_URL_NO_EMBED;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_URL_NO_EMBED");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlRule() {
        Pattern pattern = PATTERN_URL;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_URL");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UserMentionNode.RenderContext, S> Rule<T, Node<T>, S> createUserMentionRule() {
        Pattern pattern = PATTERN_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_MENTION");
        return new AnonymousClass1(pattern);
    }
}
