package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.User;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: StoreMaskedLinks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/stores/StoreMaskedLinks;", "Lcom/discord/stores/StoreV2;", "", "url", "", "isTrustedDomain", "(Ljava/lang/String;)Z", "", "getUserTrustedDomains", "()Ljava/util/Set;", "mask", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "trustDomain", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "userTrustedDomainsSnapshot", "Ljava/util/Set;", "", "userTrustedDomains", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreUserRelationships;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreUserRelationships;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMaskedLinks extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Regex DISCORD_DOMAINS_REGEX;
    private static final String HOST_SPOTIFY = "https://spotify.com";
    private static final String HOST_SPOTIFY_OPEN = "https://open.spotify.com";
    private static final List<String> TRUSTED_DOMAINS;
    private static final String USER_TRUSTED_DOMAINS_CACHE_KEY = "USER_TRUSTED_DOMAINS_CACHE_KEY";
    private final Dispatcher dispatcher;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreUserRelationships storeUserRelationships;
    private Set<String> userTrustedDomains;
    private Set<String> userTrustedDomainsSnapshot;

    /* compiled from: StoreMaskedLinks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreMaskedLinks$Companion;", "", "", "url", "getDomainName", "(Ljava/lang/String;)Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "isImplicitlyTrustedDomain$app_productionGoogleRelease", "(Ljava/lang/String;)Z", "isImplicitlyTrustedDomain", "Lkotlin/text/Regex;", "DISCORD_DOMAINS_REGEX", "Lkotlin/text/Regex;", "HOST_SPOTIFY", "Ljava/lang/String;", "HOST_SPOTIFY_OPEN", "", "TRUSTED_DOMAINS", "Ljava/util/List;", StoreMaskedLinks.USER_TRUSTED_DOMAINS_CACHE_KEY, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getDomainName(Companion companion, String str) {
            return companion.getDomainName(str);
        }

        private final String getDomainName(String url) {
            try {
                Uri uri = Uri.parse(url);
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(url)");
                return uri.getHost();
            } catch (Exception unused) {
                return null;
            }
        }

        @VisibleForTesting
        public final boolean isImplicitlyTrustedDomain$app_productionGoogleRelease(String name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return StoreMaskedLinks.access$getTRUSTED_DOMAINS$cp().contains(name) || StoreMaskedLinks.access$getDISCORD_DOMAINS_REGEX$cp().containsMatchIn(name);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMaskedLinks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMaskedLinks$trustDomain$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$url = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strAccess$getDomainName = Companion.access$getDomainName(StoreMaskedLinks.INSTANCE, this.$url);
            if (strAccess$getDomainName != null) {
                StoreMaskedLinks.access$getUserTrustedDomains$p(StoreMaskedLinks.this).add(strAccess$getDomainName);
                StoreMaskedLinks.this.markChanged();
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TRUSTED_DOMAINS = Collections2.listOfNotNull((Object[]) new String[]{Companion.access$getDomainName(companion, BuildConfig.HOST), Companion.access$getDomainName(companion, BuildConfig.HOST_ALTERNATE), Companion.access$getDomainName(companion, BuildConfig.HOST_CDN), Companion.access$getDomainName(companion, BuildConfig.HOST_GIFT), Companion.access$getDomainName(companion, BuildConfig.HOST_INVITE), Companion.access$getDomainName(companion, BuildConfig.HOST_GUILD_TEMPLATE), Companion.access$getDomainName(companion, HOST_SPOTIFY), Companion.access$getDomainName(companion, HOST_SPOTIFY_OPEN)});
        DISCORD_DOMAINS_REGEX = new Regex("(?:^|\\.)(?:discordapp|discord)\\.com$");
    }

    public StoreMaskedLinks(Dispatcher dispatcher, StoreChannelsSelected storeChannelsSelected, StoreUserRelationships storeUserRelationships) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.dispatcher = dispatcher;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUserRelationships = storeUserRelationships;
        this.userTrustedDomainsSnapshot = Sets5.emptySet();
        this.userTrustedDomains = new LinkedHashSet();
    }

    public static final /* synthetic */ Regex access$getDISCORD_DOMAINS_REGEX$cp() {
        return DISCORD_DOMAINS_REGEX;
    }

    public static final /* synthetic */ List access$getTRUSTED_DOMAINS$cp() {
        return TRUSTED_DOMAINS;
    }

    public static final /* synthetic */ Set access$getUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks) {
        return storeMaskedLinks.userTrustedDomains;
    }

    public static final /* synthetic */ void access$setUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks, Set set) {
        storeMaskedLinks.userTrustedDomains = set;
    }

    public final Set<String> getUserTrustedDomains() {
        return this.userTrustedDomainsSnapshot;
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, Sets5.emptySet());
        if (stringSet == null) {
            stringSet = new LinkedHashSet<>();
        }
        this.userTrustedDomains = new HashSet(stringSet);
        markChanged();
    }

    public final boolean isTrustedDomain(String url, String mask) {
        Intrinsics3.checkNotNullParameter(url, "url");
        if (isTrustedDomain(url)) {
            return true;
        }
        boolean z2 = mask == null || Intrinsics3.areEqual(mask, url);
        Channel selectedChannel = this.storeChannelsSelected.getSelectedChannel();
        User userA = selectedChannel != null ? ChannelUtils.a(selectedChannel) : null;
        if (ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(userA != null ? Long.valueOf(userA.getId()) : null), 1)) {
            return z2;
        }
        return false;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.userTrustedDomainsSnapshot = new HashSet(this.userTrustedDomains);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, this.userTrustedDomainsSnapshot);
        editorEdit.apply();
    }

    public final void trustDomain(String url) {
        Intrinsics3.checkNotNullParameter(url, "url");
        this.dispatcher.schedule(new AnonymousClass1(url));
    }

    private final boolean isTrustedDomain(String url) {
        Companion companion = INSTANCE;
        String strAccess$getDomainName = Companion.access$getDomainName(companion, url);
        return _Collections.contains(this.userTrustedDomainsSnapshot, strAccess$getDomainName) || (strAccess$getDomainName != null && companion.isImplicitlyTrustedDomain$app_productionGoogleRelease(strAccess$getDomainName));
    }
}
