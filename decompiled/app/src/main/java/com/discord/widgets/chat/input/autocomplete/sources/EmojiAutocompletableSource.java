package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: EmojiAutocompletableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/EmojiAutocompletableSource;", "", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "", "animationsEnabled", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "createFromEmojiSet", "(Lcom/discord/models/domain/emoji/EmojiSet;Z)Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "observeEmojiAutocompletables", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/stores/StoreEmoji;", "emojiStore", "Lcom/discord/stores/StoreEmoji;", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreUserSettings;", "<init>", "(Lcom/discord/stores/StoreEmoji;Lcom/discord/stores/StoreUserSettings;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiAutocompletableSource {
    private final StoreEmoji emojiStore;
    private final StoreUserSettings userSettingsStore;

    /* compiled from: EmojiAutocompletableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007 \u0001*\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/models/domain/emoji/EmojiSet;", "kotlin.jvm.PlatformType", "emojiSet", "", "animationsEnabled", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/EmojiSet;Ljava/lang/Boolean;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource$observeEmojiAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<EmojiSet, Boolean, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(EmojiSet emojiSet, Boolean bool) {
            return call2(emojiSet, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(EmojiSet emojiSet, Boolean bool) {
            EmojiAutocompletableSource emojiAutocompletableSource = EmojiAutocompletableSource.this;
            Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
            Intrinsics3.checkNotNullExpressionValue(bool, "animationsEnabled");
            return EmojiAutocompletableSource.access$createFromEmojiSet(emojiAutocompletableSource, emojiSet, bool.booleanValue());
        }
    }

    public EmojiAutocompletableSource(StoreEmoji storeEmoji, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(storeEmoji, "emojiStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.emojiStore = storeEmoji;
        this.userSettingsStore = storeUserSettings;
    }

    public static final /* synthetic */ Map access$createFromEmojiSet(EmojiAutocompletableSource emojiAutocompletableSource, EmojiSet emojiSet, boolean z2) {
        return emojiAutocompletableSource.createFromEmojiSet(emojiSet, z2);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createFromEmojiSet(EmojiSet emojiSet, boolean animationsEnabled) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        Iterator<T> it = emojiSet.unicodeEmojis.values().iterator();
        while (it.hasNext()) {
            List<Emoji> list = (List) it.next();
            Intrinsics3.checkNotNullExpressionValue(list, "categoryEmojis");
            for (Emoji emoji : list) {
                Intrinsics3.checkNotNullExpressionValue(emoji, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji, animationsEnabled));
            }
        }
        Iterator<T> it2 = emojiSet.customEmojis.values().iterator();
        while (it2.hasNext()) {
            List list2 = (List) it2.next();
            ArrayList<Emoji> arrayListA0 = outline.a0(list2, "guildEmojis");
            for (Object obj : list2) {
                Emoji emoji2 = (Emoji) obj;
                Intrinsics3.checkNotNullExpressionValue(emoji2, "it");
                if (emoji2.isAvailable()) {
                    arrayListA0.add(obj);
                }
            }
            for (Emoji emoji3 : arrayListA0) {
                Intrinsics3.checkNotNullExpressionValue(emoji3, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji3, animationsEnabled));
            }
        }
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.EMOJI_AND_STICKERS, treeSet));
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeEmojiAutocompletables(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(this.emojiStore.getEmojiSet(channel.getGuildId(), channel.getId(), EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled(), false)), ObservableExtensionsKt.computationLatest(this.userSettingsStore.observeIsAnimatedEmojisEnabled(true)), new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… animationsEnabled)\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }
}
