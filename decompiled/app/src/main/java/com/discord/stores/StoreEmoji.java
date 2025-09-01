package com.discord.stores;

import a0.a.a.b;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMediaFavorites;
import com.discord.utilities.Quad;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.user.UserUtils;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: StoreEmoji.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ^2\u00020\u0001:\u0002^_B/\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\b\\\u0010]J{\u0010\u0014\u001a\u00020\u00132\"\u0010\u0006\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020'0\u0002H\u0016¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020'0\u0002H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010&J\u0015\u0010,\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-J?\u00102\u001a\b\u0012\u0004\u0012\u00020\u0013012\n\u0010.\u001a\u00060\u0003j\u0002`\u00042\n\u00100\u001a\u00060\u0003j\u0002`/2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b2\u00103J+\u00102\u001a\b\u0012\u0004\u0012\u00020\u0013012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b2\u00104J\u001d\u00107\u001a\u0004\u0018\u00010\u00052\n\u00106\u001a\u00060\u0003j\u0002`5H\u0007¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020!H\u0007¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0017¢\u0006\u0004\b<\u0010=J\u0015\u0010<\u001a\u00020!2\u0006\u0010>\u001a\u00020\u0016¢\u0006\u0004\b<\u0010?R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020'0\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR(\u0010P\u001a\u0014\u0012\u0004\u0012\u00020O\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010ER\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020'0\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010ER\u0016\u0010U\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/discord/stores/StoreEmoji;", "Lcom/discord/utilities/textprocessing/Rules$EmojiDataProvider;", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "allCustomEmojis", "Lcom/discord/stores/StoreEmoji$EmojiContext;", "emojiContext", "", "sortedGuildIds", "", "isMePremium", "includeUnusableEmojis", "includeUnavailableEmojis", "hasExternalEmojiPermission", "", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "favorites", "Lcom/discord/models/domain/emoji/EmojiSet;", "buildUsableEmojiSet", "(Ljava/util/Map;Lcom/discord/stores/StoreEmoji$EmojiContext;Ljava/util/List;ZZZZLjava/util/Set;)Lcom/discord/models/domain/emoji/EmojiSet;", "", "Lcom/discord/models/domain/emoji/Emoji;", "emojiIdsMap", "getFrequentlyUsedEmojis", "(Ljava/util/Map;)Ljava/util/List;", "Landroid/content/Context;", "context", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode$Bundle;", "loadUnicodeEmojisFromDisk", "(Landroid/content/Context;)Lcom/discord/models/domain/emoji/ModelEmojiUnicode$Bundle;", "unicodeEmojisBundle", "", "handleLoadedUnicodeEmojis", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode$Bundle;)V", "Ljava/util/regex/Pattern;", "compileSurrogatesPattern", "()Ljava/util/regex/Pattern;", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "getUnicodeEmojiSurrogateMap", "()Ljava/util/Map;", "getUnicodeEmojisNamesMap", "getUnicodeEmojisPattern", "initBlocking", "(Landroid/content/Context;)V", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "getEmojiSet", "(JJZZ)Lrx/Observable;", "(Lcom/discord/stores/StoreEmoji$EmojiContext;ZZ)Lrx/Observable;", "Lcom/discord/primitives/EmojiId;", "emojiId", "getCustomEmojiInternal", "(J)Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "handlePreLogout", "()V", "emoji", "onEmojiUsed", "(Lcom/discord/models/domain/emoji/Emoji;)V", "emojiKey", "(Ljava/lang/String;)V", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/media/MediaFrecencyTracker;", "frecencyCache", "Lcom/discord/utilities/persister/Persister;", "unicodeEmojiSurrogateMap", "Ljava/util/Map;", "Lcom/discord/stores/StoreEmojiCustom;", "customEmojiStore", "Lcom/discord/stores/StoreEmojiCustom;", "Lcom/discord/stores/StoreMediaFavorites;", "mediaFavoritesStore", "Lcom/discord/stores/StoreMediaFavorites;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/models/domain/emoji/EmojiCategory;", "unicodeEmojis", "Lcom/discord/stores/StoreGuildsSorted;", "sortedGuildsStore", "Lcom/discord/stores/StoreGuildsSorted;", "unicodeEmojisNamesMap", "unicodeEmojisPattern", "Ljava/util/regex/Pattern;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "frecency", "Lcom/discord/utilities/media/MediaFrecencyTracker;", "<init>", "(Lcom/discord/stores/StoreEmojiCustom;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildsSorted;Lcom/discord/stores/StoreMediaFavorites;)V", "Companion", "EmojiContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEmoji implements Rules.EmojiDataProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] DEFAULT_FREQUENT_EMOJIS = {"bread", "fork_and_knife", "yum", "weary", "tired_face", "poop", "thumbsup", "100"};
    private static final int MAX_FREQUENTLY_USED_EMOJIS = 40;
    private final StoreEmojiCustom customEmojiStore;
    private final MediaFrecencyTracker frecency;
    private final Persister<MediaFrecencyTracker> frecencyCache;
    private final StoreMediaFavorites mediaFavoritesStore;
    private final StorePermissions permissionsStore;
    private final StoreGuildsSorted sortedGuildsStore;
    private Map<String, ? extends ModelEmojiUnicode> unicodeEmojiSurrogateMap;
    private Map<EmojiCategory, ? extends List<? extends Emoji>> unicodeEmojis;
    private Map<String, ? extends ModelEmojiUnicode> unicodeEmojisNamesMap;
    private Pattern unicodeEmojisPattern;
    private final StoreUser userStore;

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreEmoji$Companion;", "", "", "", "DEFAULT_FREQUENT_EMOJIS", "[Ljava/lang/String;", "getDEFAULT_FREQUENT_EMOJIS", "()[Ljava/lang/String;", "", "MAX_FREQUENTLY_USED_EMOJIS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final String[] getDEFAULT_FREQUENT_EMOJIS() {
            return StoreEmoji.access$getDEFAULT_FREQUENT_EMOJIS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext;", "", "<init>", "()V", "Chat", "Global", "Guild", "GuildProfile", "Lcom/discord/stores/StoreEmoji$EmojiContext$Chat;", "Lcom/discord/stores/StoreEmoji$EmojiContext$Global;", "Lcom/discord/stores/StoreEmoji$EmojiContext$GuildProfile;", "Lcom/discord/stores/StoreEmoji$EmojiContext$Guild;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class EmojiContext {

        /* compiled from: StoreEmoji.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext$Chat;", "Lcom/discord/stores/StoreEmoji$EmojiContext;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "guildId", "channelId", "copy", "(JJ)Lcom/discord/stores/StoreEmoji$EmojiContext$Chat;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "getGuildId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Chat extends EmojiContext {
            private final long channelId;
            private final long guildId;

            public Chat(long j, long j2) {
                super(null);
                this.guildId = j;
                this.channelId = j2;
            }

            public static /* synthetic */ Chat copy$default(Chat chat, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = chat.guildId;
                }
                if ((i & 2) != 0) {
                    j2 = chat.channelId;
                }
                return chat.copy(j, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final Chat copy(long guildId, long channelId) {
                return new Chat(guildId, channelId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chat)) {
                    return false;
                }
                Chat chat = (Chat) other;
                return this.guildId == chat.guildId && this.channelId == chat.channelId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.channelId) + (b.a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Chat(guildId=");
                sbU.append(this.guildId);
                sbU.append(", channelId=");
                return outline.C(sbU, this.channelId, ")");
            }
        }

        /* compiled from: StoreEmoji.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext$Global;", "Lcom/discord/stores/StoreEmoji$EmojiContext;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Global extends EmojiContext {
            public static final Global INSTANCE = new Global();

            private Global() {
                super(null);
            }
        }

        /* compiled from: StoreEmoji.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext$Guild;", "Lcom/discord/stores/StoreEmoji$EmojiContext;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/stores/StoreEmoji$EmojiContext$Guild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Guild extends EmojiContext {
            private final long guildId;

            public Guild(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guild.guildId;
                }
                return guild.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Guild copy(long guildId) {
                return new Guild(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: StoreEmoji.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreEmoji$EmojiContext$GuildProfile;", "Lcom/discord/stores/StoreEmoji$EmojiContext;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/stores/StoreEmoji$EmojiContext$GuildProfile;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GuildProfile extends EmojiContext {
            private final long guildId;

            public GuildProfile(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ GuildProfile copy$default(GuildProfile guildProfile, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guildProfile.guildId;
                }
                return guildProfile.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildProfile copy(long guildId) {
                return new GuildProfile(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof GuildProfile) && this.guildId == ((GuildProfile) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("GuildProfile(guildId="), this.guildId, ")");
            }
        }

        private EmojiContext() {
        }

        public /* synthetic */ EmojiContext(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "invoke", "(J)Z", "isExternalEmoji"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmojiContext emojiContext) {
            super(1);
            this.$emojiContext = emojiContext;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            EmojiContext emojiContext = this.$emojiContext;
            if (emojiContext instanceof EmojiContext.Chat) {
                if (((EmojiContext.Chat) emojiContext).getGuildId() == j) {
                    return false;
                }
            } else if (!(emojiContext instanceof EmojiContext.Global)) {
                if (emojiContext instanceof EmojiContext.GuildProfile) {
                    if (((EmojiContext.GuildProfile) emojiContext).getGuildId() == j) {
                        return false;
                    }
                } else {
                    if (!(emojiContext instanceof EmojiContext.Guild)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (((EmojiContext.Guild) emojiContext).getGuildId() == j) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "isExternalEmoji", "invoke", "(Z)Z", "isExternalEmojiRestricted"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ boolean $hasExternalEmojiPermission;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, EmojiContext emojiContext) {
            super(1);
            this.$hasExternalEmojiPermission = z2;
            this.$emojiContext = emojiContext;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
            return Boolean.valueOf(invoke(bool.booleanValue()));
        }

        public final boolean invoke(boolean z2) {
            EmojiContext emojiContext = this.$emojiContext;
            return ((emojiContext instanceof EmojiContext.Chat) || (emojiContext instanceof EmojiContext.Guild)) && z2 && !this.$hasExternalEmojiPermission;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "key", "", "invoke", "(Ljava/util/Map;Ljava/lang/Object;)V", "increment"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$4, reason: invalid class name */
    public static final class AnonymousClass4<T> extends Lambda implements Function2<Map<T, Integer>, T, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke((Map<Map<T, Integer>, Integer>) obj, (Map<T, Integer>) obj2);
            return Unit.a;
        }

        public final <T> void invoke(Map<T, Integer> map, T t) {
            Intrinsics3.checkNotNullParameter(map, "$this$increment");
            Integer num = map.get(t);
            map.put(t, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "invoke", "(J)V", "processGuildEmojis"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Map $allCustomEmojis;
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ ShallowPartitionMap $emojiIdsMap;
        public final /* synthetic */ ShallowPartitionMap $emojiNameCounts;
        public final /* synthetic */ boolean $includeUnavailableEmojis;
        public final /* synthetic */ boolean $includeUnusableEmojis;
        public final /* synthetic */ AnonymousClass1 $isExternalEmoji$1;
        public final /* synthetic */ AnonymousClass2 $isExternalEmojiRestricted$2;
        public final /* synthetic */ boolean $isMePremium;
        public final /* synthetic */ HashMap $usableCustomEmojis;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Map map, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, boolean z2, EmojiContext emojiContext, boolean z3, boolean z4, ShallowPartitionMap shallowPartitionMap, ShallowPartitionMap shallowPartitionMap2, HashMap map2) {
            super(1);
            this.$allCustomEmojis = map;
            this.$isExternalEmoji$1 = anonymousClass1;
            this.$isExternalEmojiRestricted$2 = anonymousClass2;
            this.$includeUnavailableEmojis = z2;
            this.$emojiContext = emojiContext;
            this.$isMePremium = z3;
            this.$includeUnusableEmojis = z4;
            this.$emojiNameCounts = shallowPartitionMap;
            this.$emojiIdsMap = shallowPartitionMap2;
            this.$usableCustomEmojis = map2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        @SuppressLint({"DefaultLocale"})
        public final void invoke(long j) {
            ModelEmojiCustom modelEmojiCustom;
            Map map = (Map) this.$allCustomEmojis.get(Long.valueOf(j));
            if (map != null) {
                boolean zInvoke = this.$isExternalEmoji$1.invoke(j);
                if (this.$isExternalEmojiRestricted$2.invoke(zInvoke)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = map.values().iterator();
                while (true) {
                    boolean z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    ModelEmojiCustom modelEmojiCustom2 = (ModelEmojiCustom) it.next();
                    if (this.$includeUnavailableEmojis || modelEmojiCustom2.isAvailable()) {
                        boolean z3 = modelEmojiCustom2.isManaged() && ((this.$emojiContext instanceof EmojiContext.Global) ^ true);
                        if (!this.$isMePremium && (modelEmojiCustom2.isAnimated() || (zInvoke && !z3))) {
                            z2 = false;
                        }
                        if (this.$includeUnusableEmojis || z2) {
                            Integer num = (Integer) this.$emojiNameCounts.get(modelEmojiCustom2.getName());
                            if (num == null && z2) {
                                modelEmojiCustom = modelEmojiCustom2;
                            } else {
                                modelEmojiCustom = new ModelEmojiCustom(modelEmojiCustom2, num != null ? num.intValue() : 0, z2);
                            }
                            arrayList.add(modelEmojiCustom);
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
                            ShallowPartitionMap shallowPartitionMap = this.$emojiNameCounts;
                            String name = modelEmojiCustom2.getName();
                            Intrinsics3.checkNotNullExpressionValue(name, "emoji.name");
                            anonymousClass4.invoke((Map<ShallowPartitionMap, Integer>) shallowPartitionMap, (ShallowPartitionMap) name);
                            ShallowPartitionMap shallowPartitionMap2 = this.$emojiIdsMap;
                            String uniqueId = modelEmojiCustom2.getUniqueId();
                            Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                            shallowPartitionMap2.put(uniqueId, modelEmojiCustom);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.$usableCustomEmojis.put(Long.valueOf(j), _Collections.sortedWith(arrayList, new StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1()));
                }
            }
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<MeUser, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            return Boolean.valueOf(userUtils.isPremium(meUser));
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0005*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00070\u00072X\u0010\u0006\u001aT\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0005**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedHashMap;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<LinkedHashMap<Long, Guild>, List<? extends Long>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Long> call(LinkedHashMap<Long, Guild> linkedHashMap) {
            return call2(linkedHashMap);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
            Set<Long> setKeySet = linkedHashMap.keySet();
            Intrinsics3.checkNotNullExpressionValue(setKeySet, "it.keys");
            return _Collections.toList(setKeySet);
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001aº\u0001\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0001*\u000e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \u0001*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b \u0001*\\\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0001*\u000e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \u0001*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b\u0018\u00010\u000b0\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\"\u0010\u0007\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0001*\u000e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u00042\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t \u0001*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\bH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "kotlin.jvm.PlatformType", "isPremium", "hasExternalEmojiPermission", "", "", "Lcom/discord/primitives/GuildId;", "sortedGuildIds", "", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "favorites", "Lcom/discord/utilities/Quad;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Set;)Lcom/discord/utilities/Quad;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, List<? extends Long>, Set<? extends StoreMediaFavorites.Favorite>, Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> call(Boolean bool, Boolean bool2, List<? extends Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
            return call2(bool, bool2, (List<Long>) list, set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Quad<Boolean, Boolean, List<Long>, Set<StoreMediaFavorites.Favorite>> call2(Boolean bool, Boolean bool2, List<Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
            return new Quad<>(bool, bool2, list, set);
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\n0\n \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\t2¿\u0001\u0010\b\u001aº\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0002*\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00030\u0003\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u0002*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \u0002*\\\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0002*\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00030\u0003\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u0002*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/utilities/Quad;", "", "kotlin.jvm.PlatformType", "", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/models/domain/emoji/EmojiSet;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/Quad;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>, Observable<? extends EmojiSet>> {
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ boolean $includeUnavailableEmojis;
        public final /* synthetic */ boolean $includeUnusableEmojis;

        /* compiled from: StoreEmoji.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\b2V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000j\u0002`\u0005 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000j\u0002`\u0005\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/EmojiId;", "Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "Lcom/discord/stores/EmojiMap;", "kotlin.jvm.PlatformType", "allowedCustomEmoji", "Lcom/discord/models/domain/emoji/EmojiSet;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/domain/emoji/EmojiSet;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$4$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>>, EmojiSet> {
            public final /* synthetic */ Set $favorites;
            public final /* synthetic */ Boolean $hasExternalEmojiPermission;
            public final /* synthetic */ Boolean $isPremium;
            public final /* synthetic */ List $sortedGuildIds;

            public AnonymousClass1(List list, Boolean bool, Boolean bool2, Set set) {
                this.$sortedGuildIds = list;
                this.$isPremium = bool;
                this.$hasExternalEmojiPermission = bool2;
                this.$favorites = set;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ EmojiSet call(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
                return call2(map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final EmojiSet call2(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
                StoreEmoji storeEmoji = StoreEmoji.this;
                Intrinsics3.checkNotNullExpressionValue(map, "allowedCustomEmoji");
                EmojiContext emojiContext = AnonymousClass4.this.$emojiContext;
                List list = this.$sortedGuildIds;
                Intrinsics3.checkNotNullExpressionValue(list, "sortedGuildIds");
                Boolean bool = this.$isPremium;
                Intrinsics3.checkNotNullExpressionValue(bool, "isPremium");
                boolean zBooleanValue = bool.booleanValue();
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                boolean z2 = anonymousClass4.$includeUnavailableEmojis;
                boolean z3 = anonymousClass4.$includeUnusableEmojis;
                Boolean bool2 = this.$hasExternalEmojiPermission;
                Intrinsics3.checkNotNullExpressionValue(bool2, "hasExternalEmojiPermission");
                boolean zBooleanValue2 = bool2.booleanValue();
                Set set = this.$favorites;
                Intrinsics3.checkNotNullExpressionValue(set, "favorites");
                return StoreEmoji.access$buildUsableEmojiSet(storeEmoji, map, emojiContext, list, zBooleanValue, z3, z2, zBooleanValue2, set);
            }
        }

        public AnonymousClass4(EmojiContext emojiContext, boolean z2, boolean z3) {
            this.$emojiContext = emojiContext;
            this.$includeUnavailableEmojis = z2;
            this.$includeUnusableEmojis = z3;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends EmojiSet> call(Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
            return call2((Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>) quad);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends EmojiSet> call2(Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
            Boolean boolComponent1 = quad.component1();
            Boolean boolComponent2 = quad.component2();
            return ObservableExtensionsKt.computationLatest(StoreEmoji.access$getCustomEmojiStore$p(StoreEmoji.this).observeAllowedGuildEmoji()).G(new AnonymousClass1(quad.component3(), boolComponent1, boolComponent2, quad.component4()));
        }
    }

    /* compiled from: StoreEmoji.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "emoji", "", "invoke", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)V", "indexEmoji"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmoji$handleLoadedUnicodeEmojis$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelEmojiUnicode, Unit> {
        public final /* synthetic */ HashMap $unicodeEmojiSurrogateMap;
        public final /* synthetic */ HashMap $unicodeEmojisNamesMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HashMap map, HashMap map2) {
            super(1);
            this.$unicodeEmojiSurrogateMap = map;
            this.$unicodeEmojisNamesMap = map2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelEmojiUnicode modelEmojiUnicode) {
            invoke2(modelEmojiUnicode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelEmojiUnicode modelEmojiUnicode) {
            Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "emoji");
            HashMap map = this.$unicodeEmojiSurrogateMap;
            String surrogates = modelEmojiUnicode.getSurrogates();
            Intrinsics3.checkNotNullExpressionValue(surrogates, "emoji.surrogates");
            map.put(surrogates, modelEmojiUnicode);
            List<String> names = modelEmojiUnicode.getNames();
            Intrinsics3.checkNotNullExpressionValue(names, "emoji\n          .names");
            for (String str : names) {
                HashMap map2 = this.$unicodeEmojisNamesMap;
                Intrinsics3.checkNotNullExpressionValue(str, "emojiName");
                map2.put(str, modelEmojiUnicode);
            }
            String surrogates2 = modelEmojiUnicode.getSurrogates();
            Intrinsics3.checkNotNullExpressionValue(surrogates2, "emoji.surrogates");
            if (Strings4.indexOf$default((CharSequence) surrogates2, (char) 8205, 0, false, 6, (Object) null) < 0) {
                String surrogates3 = modelEmojiUnicode.getSurrogates();
                Intrinsics3.checkNotNullExpressionValue(surrogates3, "emoji.surrogates");
                String strReplace$default = StringsJVM.replace$default(surrogates3, "️", "", false, 4, (Object) null);
                if (!Intrinsics3.areEqual(strReplace$default, modelEmojiUnicode.getSurrogates())) {
                    this.$unicodeEmojiSurrogateMap.put(strReplace$default, modelEmojiUnicode);
                }
            }
        }
    }

    public StoreEmoji(StoreEmojiCustom storeEmojiCustom, StoreUser storeUser, StorePermissions storePermissions, StoreGuildsSorted storeGuildsSorted, StoreMediaFavorites storeMediaFavorites) {
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "customEmojiStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "sortedGuildsStore");
        Intrinsics3.checkNotNullParameter(storeMediaFavorites, "mediaFavoritesStore");
        this.customEmojiStore = storeEmojiCustom;
        this.userStore = storeUser;
        this.permissionsStore = storePermissions;
        this.sortedGuildsStore = storeGuildsSorted;
        this.mediaFavoritesStore = storeMediaFavorites;
        Persister<MediaFrecencyTracker> persister = new Persister<>("EMOJI_HISTORY_V4", new MediaFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    public static final /* synthetic */ EmojiSet access$buildUsableEmojiSet(StoreEmoji storeEmoji, Map map, EmojiContext emojiContext, List list, boolean z2, boolean z3, boolean z4, boolean z5, Set set) {
        return storeEmoji.buildUsableEmojiSet(map, emojiContext, list, z2, z3, z4, z5, set);
    }

    public static final /* synthetic */ StoreEmojiCustom access$getCustomEmojiStore$p(StoreEmoji storeEmoji) {
        return storeEmoji.customEmojiStore;
    }

    public static final /* synthetic */ String[] access$getDEFAULT_FREQUENT_EMOJIS$cp() {
        return DEFAULT_FREQUENT_EMOJIS;
    }

    private final EmojiSet buildUsableEmojiSet(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> allCustomEmojis, EmojiContext emojiContext, List<Long> sortedGuildIds, boolean isMePremium, boolean includeUnusableEmojis, boolean includeUnavailableEmojis, boolean hasExternalEmojiPermission, Set<? extends StoreMediaFavorites.Favorite> favorites) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(emojiContext);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(hasExternalEmojiPermission, emojiContext);
        Set<Long> setKeySet = allCustomEmojis.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!sortedGuildIds.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        int size = sortedGuildIds.size() + arrayList.size();
        Iterator it = Collections2.listOf((Object[]) new List[]{sortedGuildIds, arrayList}).iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            int size2 = 0;
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                Map<Long, ? extends ModelEmojiCustom> map = allCustomEmojis.get(Long.valueOf(jLongValue));
                size2 += (map == null || anonymousClass2.invoke(anonymousClass1.invoke(jLongValue))) ? 0 : map.size();
            }
            i += size2;
        }
        Map<String, ? extends ModelEmojiUnicode> map2 = this.unicodeEmojisNamesMap;
        if (map2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        int size3 = map2.size();
        Map<EmojiCategory, ? extends List<? extends Emoji>> map3 = this.unicodeEmojis;
        if (map3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        Iterator<T> it3 = map3.values().iterator();
        int size4 = 0;
        while (it3.hasNext()) {
            size4 += ((List) it3.next()).size();
        }
        ShallowPartitionMap.Companion companion = ShallowPartitionMap.INSTANCE;
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap.Companion.create$default(companion, i + size3, 0, 0, null, 14, null);
        HashMap map4 = new HashMap(size);
        ShallowPartitionMap shallowPartitionMapCreate$default2 = ShallowPartitionMap.Companion.create$default(companion, i + size4, 0, 0, null, 14, null);
        if (!(emojiContext instanceof EmojiContext.GuildProfile)) {
            Map<EmojiCategory, ? extends List<? extends Emoji>> map5 = this.unicodeEmojis;
            if (map5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
            }
            Iterator<T> it4 = map5.values().iterator();
            while (it4.hasNext()) {
                for (Emoji emoji : (List) it4.next()) {
                    String uniqueId = emoji.getUniqueId();
                    Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                    shallowPartitionMapCreate$default2.put(uniqueId, emoji);
                }
            }
        }
        AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
        ShallowPartitionMap shallowPartitionMap = shallowPartitionMapCreate$default2;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(allCustomEmojis, anonymousClass1, anonymousClass2, includeUnavailableEmojis, emojiContext, isMePremium, includeUnusableEmojis, shallowPartitionMapCreate$default, shallowPartitionMap, map4);
        Map<String, ? extends ModelEmojiUnicode> map6 = this.unicodeEmojisNamesMap;
        if (map6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        Iterator<T> it5 = map6.keySet().iterator();
        while (it5.hasNext()) {
            AnonymousClass4.INSTANCE.invoke((Map<ShallowPartitionMap, Integer>) shallowPartitionMapCreate$default, (ShallowPartitionMap) it5.next());
        }
        long guildId = emojiContext instanceof EmojiContext.Chat ? ((EmojiContext.Chat) emojiContext).getGuildId() : 0L;
        anonymousClass5.invoke(guildId);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : sortedGuildIds) {
            if (((Number) obj2).longValue() != guildId) {
                arrayList2.add(obj2);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            anonymousClass5.invoke(((Number) it6.next()).longValue());
        }
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            anonymousClass5.invoke(((Number) it7.next()).longValue());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : favorites) {
            if (obj3 instanceof StoreMediaFavorites.FavoriteEmoji) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it8 = arrayList3.iterator();
        while (it8.hasNext()) {
            ShallowPartitionMap shallowPartitionMap2 = shallowPartitionMap;
            Emoji emoji2 = (Emoji) shallowPartitionMap2.get(((StoreMediaFavorites.FavoriteEmoji) it8.next()).getEmojiUniqueId());
            if (emoji2 != null) {
                arrayList4.add(emoji2);
            }
            shallowPartitionMap = shallowPartitionMap2;
        }
        ShallowPartitionMap shallowPartitionMap3 = shallowPartitionMap;
        Set set = _Collections.toSet(arrayList4);
        Map<EmojiCategory, ? extends List<? extends Emoji>> map7 = this.unicodeEmojis;
        if (map7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        return new EmojiSet(map7, map4, shallowPartitionMap3, getFrequentlyUsedEmojis(shallowPartitionMap3), set);
    }

    private final Pattern compileSurrogatesPattern() {
        Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        Pattern patternCompile = Pattern.compile(_Collections.joinToString$default(_Collections.sortedWith(map.keySet(), new StoreEmoji$compileSurrogatesPattern$$inlined$sortedBy$1()), "|", null, null, 0, null, StoreEmoji2.INSTANCE, 30, null));
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(emojiSurrogatesPattern)");
        return patternCompile;
    }

    public static /* synthetic */ Observable getEmojiSet$default(StoreEmoji storeEmoji, long j, long j2, boolean z2, boolean z3, int i, Object obj) {
        return storeEmoji.getEmojiSet(j, j2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    private final List<Emoji> getFrequentlyUsedEmojis(Map<String, ? extends Emoji> emojiIdsMap) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedKeys$default.iterator();
        while (it.hasNext()) {
            Emoji emoji = emojiIdsMap.get((String) it.next());
            if (emoji != null) {
                arrayList.add(emoji);
            }
        }
        List<Emoji> listTake = _Collections.take(arrayList, 40);
        if (listTake.size() >= 40) {
            return listTake;
        }
        String[] strArr = DEFAULT_FREQUENT_EMOJIS;
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojisNamesMap;
            if (map == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
            }
            ModelEmojiUnicode modelEmojiUnicode = map.get(str);
            if (modelEmojiUnicode != null) {
                arrayList2.add(modelEmojiUnicode);
            }
        }
        return _Collections.distinct(_Sequences2.toList(n.flattenSequenceOfIterable(n.sequenceOf(listTake, _Collections.take(arrayList2, 40 - listTake.size())))));
    }

    private final void handleLoadedUnicodeEmojis(ModelEmojiUnicode.Bundle unicodeEmojisBundle) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(map3, map2);
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = unicodeEmojisBundle.getEmojis();
        Intrinsics3.checkNotNullExpressionValue(emojis, "unicodeEmojisBundle.emojis");
        for (Map.Entry<EmojiCategory, List<ModelEmojiUnicode>> entry : emojis.entrySet()) {
            EmojiCategory key = entry.getKey();
            List<ModelEmojiUnicode> value = entry.getValue();
            Intrinsics3.checkNotNullExpressionValue(key, "category");
            Intrinsics3.checkNotNullExpressionValue(value, "categoryEmojis");
            map.put(key, value);
            for (ModelEmojiUnicode modelEmojiUnicode : value) {
                Intrinsics3.checkNotNullExpressionValue(modelEmojiUnicode, "unicodeEmoji");
                anonymousClass1.invoke2(modelEmojiUnicode);
                List<ModelEmojiUnicode> asDiverse = modelEmojiUnicode.getAsDiverse();
                Intrinsics3.checkNotNullExpressionValue(asDiverse, "unicodeEmoji\n                .asDiverse");
                for (ModelEmojiUnicode modelEmojiUnicode2 : asDiverse) {
                    Intrinsics3.checkNotNullExpressionValue(modelEmojiUnicode2, "diverseEmoji");
                    anonymousClass1.invoke2(modelEmojiUnicode2);
                }
            }
        }
        this.unicodeEmojis = map;
        this.unicodeEmojisNamesMap = map2;
        this.unicodeEmojiSurrogateMap = map3;
        this.unicodeEmojisPattern = compileSurrogatesPattern();
    }

    private final ModelEmojiUnicode.Bundle loadUnicodeEmojisFromDisk(Context context) throws IOException {
        Model model = new Model.JsonReader(new InputStreamReader(context.getAssets().open("data/emojis.json"), Constants.ENCODING)).parse(new ModelEmojiUnicode.Bundle());
        Intrinsics3.checkNotNullExpressionValue(model, "jsonReader.parse(ModelEmojiUnicode.Bundle())");
        return (ModelEmojiUnicode.Bundle) model;
    }

    @Store3
    public final ModelEmojiCustom getCustomEmojiInternal(long emojiId) {
        Iterator<Map.Entry<Long, Map<Long, ModelEmojiCustom>>> it = this.customEmojiStore.getAllGuildEmojiInternal().entrySet().iterator();
        while (it.hasNext()) {
            ModelEmojiCustom modelEmojiCustom = it.next().getValue().get(Long.valueOf(emojiId));
            if (modelEmojiCustom != null) {
                return modelEmojiCustom;
            }
        }
        return null;
    }

    public final Observable<EmojiSet> getEmojiSet(long guildId, long channelId, boolean includeUnusableEmojis, boolean includeUnavailableEmojis) {
        return getEmojiSet(new EmojiContext.Chat(guildId, channelId), includeUnusableEmojis, includeUnavailableEmojis);
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap() {
        Map map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap() {
        Map map = this.unicodeEmojisNamesMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Pattern getUnicodeEmojisPattern() {
        Pattern pattern = this.unicodeEmojisPattern;
        if (pattern == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisPattern");
        }
        return pattern;
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void initBlocking(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        handleLoadedUnicodeEmojis(loadUnicodeEmojisFromDisk(context));
    }

    public final void onEmojiUsed(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        String uniqueId = emoji.getUniqueId();
        Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
        onEmojiUsed(uniqueId);
    }

    public final void onEmojiUsed(String emojiKey) {
        Intrinsics3.checkNotNullParameter(emojiKey, "emojiKey");
        FrecencyTracker.track$default(this.frecency, emojiKey, 0L, 2, null);
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Observable<EmojiSet> getEmojiSet(EmojiContext emojiContext, boolean includeUnusableEmojis, boolean includeUnavailableEmojis) {
        ScalarSynchronousObservable scalarSynchronousObservable;
        Observable observableG;
        Intrinsics3.checkNotNullParameter(emojiContext, "emojiContext");
        if (emojiContext instanceof EmojiContext.Chat) {
            EmojiContext.Chat chat = (EmojiContext.Chat) emojiContext;
            if (chat.getGuildId() != 0) {
                observableG = this.permissionsStore.observePermissionsForChannel(chat.getChannelId()).G(StoreEmoji3.INSTANCE);
            } else {
                if (emojiContext instanceof EmojiContext.Guild) {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
                } else {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.TRUE);
                }
                observableG = scalarSynchronousObservable;
            }
        }
        Observable<EmojiSet> observableY = Observable.h(StoreUser.observeMe$default(this.userStore, false, 1, null).G(AnonymousClass1.INSTANCE), observableG, this.sortedGuildsStore.observeOrderedGuilds().G(AnonymousClass2.INSTANCE), this.mediaFavoritesStore.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), AnonymousClass3.INSTANCE).r().Y(new AnonymousClass4(emojiContext, includeUnavailableEmojis, includeUnusableEmojis));
        Intrinsics3.checkNotNullExpressionValue(observableY, "Observable\n        .comb…              }\n        }");
        return observableY;
    }
}
